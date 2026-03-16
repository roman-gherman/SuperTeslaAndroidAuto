package p048h2;

import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BufferPool {
    private static final int HEADER_SIZE = 4;
    private static final int LARGE_BUFFER_SIZE = 65536;
    private static final int MAX_BUFFERS_PER_SIZE = 8;
    private static final int MEDIUM_BUFFER_SIZE = 1024;
    private static final int SMALL_BUFFER_SIZE = 64;
    private static final int XLARGE_BUFFER_SIZE = 524288;
    private static BufferPool instance;
    private final AtomicInteger headerHits = new AtomicInteger(0);
    private final AtomicInteger headerMisses = new AtomicInteger(0);
    private final AtomicInteger smallHits = new AtomicInteger(0);
    private final AtomicInteger smallMisses = new AtomicInteger(0);
    private final AtomicInteger mediumHits = new AtomicInteger(0);
    private final AtomicInteger mediumMisses = new AtomicInteger(0);
    private final AtomicInteger largeHits = new AtomicInteger(0);
    private final AtomicInteger largeMisses = new AtomicInteger(0);
    private final AtomicInteger xlargeHits = new AtomicInteger(0);
    private final AtomicInteger xlargeMisses = new AtomicInteger(0);
    private final ConcurrentLinkedQueue<byte[]> headerPool = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<byte[]> smallPool = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<byte[]> mediumPool = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<byte[]> largePool = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<byte[]> xlargePool = new ConcurrentLinkedQueue<>();

    public static class BufferedData {
        private final int actualLength;
        private final byte[] buffer;
        private final BufferPool pool;
        private boolean returned = false;

        public BufferedData(byte[] bArr, int i, BufferPool bufferPool) {
            this.buffer = bArr;
            this.actualLength = i;
            this.pool = bufferPool;
        }

        public byte[] getData() {
            int i = this.actualLength;
            byte[] bArr = this.buffer;
            if (i == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        public byte[] getInternalBuffer() {
            return this.buffer;
        }

        public int getLength() {
            return this.actualLength;
        }

        public void release() {
            if (this.returned) {
                return;
            }
            this.pool.returnBuffer(this.buffer);
            this.returned = true;
        }
    }

    private BufferPool() {
        preallocateBuffers();
    }

    public static synchronized BufferPool getInstance() {
        try {
            if (instance == null) {
                instance = new BufferPool();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void preallocateBuffers() {
        for (int i = 0; i < 2; i++) {
            this.headerPool.offer(new byte[4]);
            this.smallPool.offer(new byte[64]);
            this.mediumPool.offer(new byte[1024]);
            this.largePool.offer(new byte[65536]);
            this.xlargePool.offer(new byte[524288]);
        }
    }

    public void clear() {
        this.headerPool.clear();
        this.smallPool.clear();
        this.mediumPool.clear();
        this.largePool.clear();
    }

    public BufferedData createBufferedData(int i) {
        return new BufferedData(getBuffer(i), i, this);
    }

    public byte[] getBuffer(int i) {
        if (i <= 64) {
            byte[] bArrPoll = this.smallPool.poll();
            if (bArrPoll != null) {
                this.smallHits.incrementAndGet();
                return bArrPoll;
            }
            this.smallMisses.incrementAndGet();
            return new byte[64];
        }
        if (i <= 1024) {
            byte[] bArrPoll2 = this.mediumPool.poll();
            if (bArrPoll2 != null) {
                this.mediumHits.incrementAndGet();
                return bArrPoll2;
            }
            this.mediumMisses.incrementAndGet();
            return new byte[1024];
        }
        if (i <= 65536) {
            byte[] bArrPoll3 = this.largePool.poll();
            if (bArrPoll3 != null) {
                this.largeHits.incrementAndGet();
                return bArrPoll3;
            }
            this.largeMisses.incrementAndGet();
            return new byte[65536];
        }
        if (i > 524288) {
            return new byte[i];
        }
        byte[] bArrPoll4 = this.xlargePool.poll();
        if (bArrPoll4 != null) {
            this.xlargeHits.incrementAndGet();
            return bArrPoll4;
        }
        this.xlargeMisses.incrementAndGet();
        return new byte[524288];
    }

    public byte[] getHeaderBuffer() {
        byte[] bArrPoll = this.headerPool.poll();
        if (bArrPoll != null) {
            this.headerHits.incrementAndGet();
            return bArrPoll;
        }
        this.headerMisses.incrementAndGet();
        return new byte[4];
    }

    public String getStatistics() {
        int i = this.largeHits.get() + this.mediumHits.get() + this.smallHits.get() + this.headerHits.get();
        int i3 = this.largeMisses.get() + this.mediumMisses.get() + this.smallMisses.get() + this.headerMisses.get() + i;
        return i3 == 0 ? "BufferPool: No requests yet" : String.format(Locale.ROOT, "BufferPool: Hit rate: %.1f%% (%d/%d), Pools: H:%d S:%d M:%d L:%d", Double.valueOf((((double) i) / ((double) i3)) * 100.0d), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.headerPool.size()), Integer.valueOf(this.smallPool.size()), Integer.valueOf(this.mediumPool.size()), Integer.valueOf(this.largePool.size()));
    }

    public void returnBuffer(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (bArr.length == 64 && this.smallPool.size() < 8) {
            this.smallPool.offer(bArr);
            return;
        }
        if (bArr.length == 1024 && this.mediumPool.size() < 8) {
            this.mediumPool.offer(bArr);
            return;
        }
        if (bArr.length == 65536 && this.largePool.size() < 8) {
            this.largePool.offer(bArr);
        } else {
            if (bArr.length != 524288 || this.xlargePool.size() >= 8) {
                return;
            }
            this.xlargePool.offer(bArr);
        }
    }

    public void returnHeaderBuffer(byte[] bArr) {
        if (bArr == null || bArr.length != 4 || this.headerPool.size() >= 8) {
            return;
        }
        this.headerPool.offer(bArr);
    }
}
