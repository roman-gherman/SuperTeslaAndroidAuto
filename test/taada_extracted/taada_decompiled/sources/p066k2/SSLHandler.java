package p066k2;

import android.content.Context;
import androidx.constraintlayout.core.motion.a;
import fr.sd.taada.helpers.LogManager;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import p048h2.MessageHandler;

/* JADX INFO: loaded from: classes.dex */
public class SSLHandler extends AbstractSSLHandler {
    private static final String TAG = "SSLHandler";
    private static final SSLBufferPool sslBufferPool = new SSLBufferPool();
    private final ExecutorService executorService;
    private volatile boolean handshakeCompleted;
    private final SSLEngine sslEngine;

    public static class SSLBufferPool {
        private static final int LARGE_SSL_SIZE = 8192;
        private static final int MAX_POOL_SIZE = 6;
        private static final int MEDIUM_SSL_SIZE = 2048;
        private static final int SMALL_SSL_SIZE = 512;
        private static final int XLARGE_SSL_SIZE = 16384;
        private final AtomicInteger buffersCreated;
        private final AtomicLong largeHits;
        private final ConcurrentLinkedQueue<byte[]> largePool;
        private final AtomicLong mediumHits;
        private final ConcurrentLinkedQueue<byte[]> mediumPool;
        private final AtomicLong poolHits;
        private final AtomicLong poolMisses;
        private final AtomicLong smallHits;
        private final ConcurrentLinkedQueue<byte[]> smallPool;
        private final AtomicLong totalRequests;
        private final AtomicLong xlargeHits;
        private final ConcurrentLinkedQueue<byte[]> xlargePool;

        public static class ManagedBuffer {
            private final int actualLength;
            private final byte[] buffer;
            private final SSLBufferPool pool;
            private boolean released = false;

            public ManagedBuffer(byte[] bArr, int i, SSLBufferPool sSLBufferPool) {
                this.buffer = bArr;
                this.actualLength = i;
                this.pool = sSLBufferPool;
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
                if (this.released) {
                    return;
                }
                this.pool.releaseBuffer(this.buffer);
                this.released = true;
            }
        }

        private SSLBufferPool() {
            this.smallPool = new ConcurrentLinkedQueue<>();
            this.mediumPool = new ConcurrentLinkedQueue<>();
            this.largePool = new ConcurrentLinkedQueue<>();
            this.xlargePool = new ConcurrentLinkedQueue<>();
            this.totalRequests = new AtomicLong(0L);
            this.poolHits = new AtomicLong(0L);
            this.poolMisses = new AtomicLong(0L);
            this.buffersCreated = new AtomicInteger(0);
            this.smallHits = new AtomicLong(0L);
            this.mediumHits = new AtomicLong(0L);
            this.largeHits = new AtomicLong(0L);
            this.xlargeHits = new AtomicLong(0L);
        }

        public byte[] acquireBuffer(int i) {
            this.totalRequests.incrementAndGet();
            if (i <= 512) {
                byte[] bArrPoll = this.smallPool.poll();
                if (bArrPoll != null) {
                    this.poolHits.incrementAndGet();
                    this.smallHits.incrementAndGet();
                    return bArrPoll;
                }
                this.poolMisses.incrementAndGet();
                this.buffersCreated.incrementAndGet();
                return new byte[512];
            }
            if (i <= 2048) {
                byte[] bArrPoll2 = this.mediumPool.poll();
                if (bArrPoll2 != null) {
                    this.poolHits.incrementAndGet();
                    this.mediumHits.incrementAndGet();
                    return bArrPoll2;
                }
                this.poolMisses.incrementAndGet();
                this.buffersCreated.incrementAndGet();
                return new byte[2048];
            }
            if (i <= 8192) {
                byte[] bArrPoll3 = this.largePool.poll();
                if (bArrPoll3 != null) {
                    this.poolHits.incrementAndGet();
                    this.largeHits.incrementAndGet();
                    return bArrPoll3;
                }
                this.poolMisses.incrementAndGet();
                this.buffersCreated.incrementAndGet();
                return new byte[8192];
            }
            if (i > 16384) {
                this.poolMisses.incrementAndGet();
                this.buffersCreated.incrementAndGet();
                return new byte[i];
            }
            byte[] bArrPoll4 = this.xlargePool.poll();
            if (bArrPoll4 != null) {
                this.poolHits.incrementAndGet();
                this.xlargeHits.incrementAndGet();
                return bArrPoll4;
            }
            this.poolMisses.incrementAndGet();
            this.buffersCreated.incrementAndGet();
            return new byte[16384];
        }

        public ManagedBuffer createManagedBuffer(int i) {
            return new ManagedBuffer(acquireBuffer(i), i, this);
        }

        public String getStats() {
            long j6 = this.totalRequests.get();
            long j7 = this.poolHits.get();
            this.poolMisses.get();
            if (j6 == 0) {
                return "SSLBufferPool: No requests yet";
            }
            return String.format(Locale.ROOT, "SSLBufferPool: %.1f%% hit rate (%d/%d), %d pooled buffers, ~%d KB memory, %d created", Double.valueOf((j7 * 100.0d) / j6), Long.valueOf(j7), Long.valueOf(j6), Integer.valueOf(this.xlargePool.size() + this.largePool.size() + this.mediumPool.size() + this.smallPool.size()), Integer.valueOf(((this.xlargePool.size() * 16384) + ((this.largePool.size() * 8192) + ((this.mediumPool.size() * 2048) + (this.smallPool.size() * 512)))) / 1024), Integer.valueOf(this.buffersCreated.get()));
        }

        public void releaseBuffer(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            if (bArr.length == 512 && this.smallPool.size() < 6) {
                this.smallPool.offer(bArr);
                return;
            }
            if (bArr.length == 2048 && this.mediumPool.size() < 6) {
                this.mediumPool.offer(bArr);
                return;
            }
            if (bArr.length == 8192 && this.largePool.size() < 6) {
                this.largePool.offer(bArr);
            } else {
                if (bArr.length != 16384 || this.xlargePool.size() >= 6) {
                    return;
                }
                this.xlargePool.offer(bArr);
            }
        }

        public void resetStats() {
            this.totalRequests.set(0L);
            this.poolHits.set(0L);
            this.poolMisses.set(0L);
            this.buffersCreated.set(0);
            this.smallHits.set(0L);
            this.mediumHits.set(0L);
            this.largeHits.set(0L);
            this.xlargeHits.set(0L);
        }
    }

    public static class SSLStatusHelper {
        static final int[] sslStatusOrdinals;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            sslStatusOrdinals = iArr;
            try {
                iArr[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                sslStatusOrdinals[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                sslStatusOrdinals[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                sslStatusOrdinals[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SSLHandler(SSLEngine sSLEngine, MessageHandler messageHandler, boolean z6) {
        this(sSLEngine, messageHandler, z6, null);
    }

    private void executeDelegatedTasks() {
        while (true) {
            Runnable delegatedTask = this.sslEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            } else {
                delegatedTask.run();
            }
        }
    }

    public static String getSSLBufferPoolStats() {
        return sslBufferPool.getStats();
    }

    private void handleBufferOverflow() {
        if (getLogManager() != null) {
            getLogManager().logDebug(TAG, "Buffer overflow, resizing output buffer");
        }
        this.outBuffer = resizeApplicationBuffer(this.sslEngine, this.outBuffer);
    }

    private void handleBufferUnderflow() {
        this.inBuffer = handleBufferUnderflow(this.sslEngine, this.inBuffer);
    }

    private byte[] handleConnectionClosed(byte[] bArr) {
        if (getLogManager() != null) {
            getLogManager().logDebug("AA_GATEWAY_SERVER", "Client wants to close connection...");
            getLogManager().logDebug("AA_GATEWAY_SERVER", "Goodbye client!");
        }
        return bArr;
    }

    private byte[] handleUnwrapOK(int i) {
        SSLBufferPool sSLBufferPool = sslBufferPool;
        byte[] bArrAcquireBuffer = sSLBufferPool.acquireBuffer(i);
        try {
            this.outBuffer.get(bArrAcquireBuffer, 0, i);
            if (bArrAcquireBuffer.length == i) {
                if (bArrAcquireBuffer.length != i) {
                    sSLBufferPool.releaseBuffer(bArrAcquireBuffer);
                }
                return bArrAcquireBuffer;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(bArrAcquireBuffer, 0, bArr, 0, i);
            if (bArrAcquireBuffer.length != i) {
                sSLBufferPool.releaseBuffer(bArrAcquireBuffer);
            }
            return bArr;
        } catch (Throwable th) {
            if (bArrAcquireBuffer.length != i) {
                sslBufferPool.releaseBuffer(bArrAcquireBuffer);
            }
            throw th;
        }
    }

    public static boolean isSSLBufferPoolEfficient() {
        int iLastIndexOf;
        String stats = sslBufferPool.getStats();
        if (stats.contains("No requests")) {
            return true;
        }
        try {
            int iIndexOf = stats.indexOf("% hit rate");
            if (iIndexOf > 0 && (iLastIndexOf = stats.lastIndexOf(32, iIndexOf - 1)) > 0) {
                return Double.parseDouble(stats.substring(iLastIndexOf + 1, iIndexOf)) >= 70.0d;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static void resetSSLBufferPoolStats() {
        sslBufferPool.resetStats();
    }

    private boolean validateUnwrapParameters(byte[] bArr, int i, int i3) {
        if (bArr == null) {
            if (getLogManager() != null) {
                getLogManager().logError(TAG, "doUnwrap called with null data");
            }
            return false;
        }
        if (i < 0 || i3 < 0) {
            if (getLogManager() != null) {
                getLogManager().logError(TAG, a.n("doUnwrap called with negative parameters: offset=", i, ", length=", i3));
            }
            return false;
        }
        int i4 = i + i3;
        if (i4 <= bArr.length) {
            return true;
        }
        if (getLogManager() != null) {
            getLogManager().logError(TAG, "Invalid data parameters: data=" + bArr.length + ", offset=" + i + ", length=" + i3 + " (offset+length=" + i4 + " > data.length)");
        }
        return false;
    }

    public synchronized byte[] doUnwrap(byte[] bArr, int i, int i3) {
        if (!validateUnwrapParameters(bArr, i, i3)) {
            return new byte[0];
        }
        this.inBuffer.clear();
        this.inBuffer.put(bArr, i, i3);
        this.inBuffer.flip();
        byte[] bArrHandleUnwrapOK = null;
        while (this.inBuffer.hasRemaining()) {
            this.outBuffer.clear();
            SSLEngineResult sSLEngineResultUnwrap = this.sslEngine.unwrap(this.inBuffer, this.outBuffer);
            int i4 = SSLStatusHelper.sslStatusOrdinals[sSLEngineResultUnwrap.getStatus().ordinal()];
            if (i4 == 1) {
                this.outBuffer.flip();
                bArrHandleUnwrapOK = handleUnwrapOK(this.outBuffer.remaining());
            } else if (i4 == 2) {
                handleBufferOverflow();
            } else {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return handleConnectionClosed(bArrHandleUnwrapOK);
                    }
                    throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultUnwrap.getStatus());
                }
                handleBufferUnderflow();
            }
        }
        return bArrHandleUnwrapOK;
    }

    public boolean isHandshakeComplete() {
        boolean z6 = this.handshakeCompleted && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && !this.sslEngine.isInboundDone() && !this.sslEngine.isOutboundDone();
        if (getLogManager() != null) {
            getLogManager().logDebug(TAG, "Handshake complete check: " + z6 + " (handshakeCompleted=" + this.handshakeCompleted + ", status=" + this.sslEngine.getHandshakeStatus() + ", isInboundDone=" + this.sslEngine.isInboundDone() + ", isOutboundDone=" + this.sslEngine.isOutboundDone() + ")");
        }
        return z6;
    }

    public void logSSLBufferPoolStats() {
        if (getLogManager() != null) {
            getLogManager().logDebug(TAG, "🚀 " + sslBufferPool.getStats());
            return;
        }
        System.out.println("🚀 SSLHandler: " + sslBufferPool.getStats());
    }

    public synchronized void m2560g(byte[] bArr, int i, ByteBuffer byteBuffer) {
        try {
            this.messageBuffer.clear();
            if (i != 0) {
                this.messageBuffer.put((byte) ((i >> 8) & 255));
                this.messageBuffer.put((byte) (i & 255));
            }
            this.messageBuffer.put(bArr);
            this.messageBuffer.flip();
            this.encryptedBuffer.clear();
            SSLEngineResult sSLEngineResultWrap = this.sslEngine.wrap(this.messageBuffer, this.encryptedBuffer);
            int i3 = SSLStatusHelper.sslStatusOrdinals[sSLEngineResultWrap.getStatus().ordinal()];
            if (i3 == 1) {
                this.encryptedBuffer.flip();
                short sRemaining = (short) this.encryptedBuffer.remaining();
                byteBuffer.put((byte) ((sRemaining >> 8) & 255));
                byteBuffer.put((byte) (sRemaining & 255));
                byteBuffer.put(this.encryptedBuffer.array(), 0, sRemaining);
            } else {
                if (i3 != 2) {
                    if (i3 == 3) {
                        throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                    }
                    if (i3 == 4 && getLogManager() != null) {
                        getLogManager().logError(TAG, "Connection is closed");
                    }
                    throw new IllegalStateException("Invalid SSL status: " + sSLEngineResultWrap.getStatus());
                }
                this.encryptedBuffer = resizePacketBuffer(this.sslEngine, this.encryptedBuffer);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SSLHandler(SSLEngine sSLEngine, MessageHandler messageHandler, boolean z6, Context context) throws Exception {
        super(context);
        this.executorService = Executors.newSingleThreadExecutor();
        this.handshakeCompleted = false;
        if (sSLEngine == null) {
            throw new IllegalArgumentException("SSLEngine cannot be null");
        }
        this.sslEngine = sSLEngine;
        this.ioHandler = messageHandler;
        if (getLogManager() != null) {
            LogManager logManager = getLogManager();
            StringBuilder sb = new StringBuilder("Initializing SSLHandler with clientMode=");
            sb.append(z6);
            sb.append(", context=");
            sb.append(context != null ? "provided" : "null");
            logManager.logDebug(TAG, sb.toString());
            getLogManager().logDebug(TAG, "Initial SSLEngine state - isInboundDone: " + sSLEngine.isInboundDone() + ", isOutboundDone: " + sSLEngine.isOutboundDone() + ", handshakeStatus: " + sSLEngine.getHandshakeStatus());
        }
        sSLEngine.setUseClientMode(z6);
        sSLEngine.beginHandshake();
        if (getLogManager() != null) {
            getLogManager().logDebug(TAG, "After beginHandshake, status: " + sSLEngine.getHandshakeStatus());
            getLogManager().logDebug(TAG, "Begin handshake");
        }
        boolean zDoHandshake = doHandshake(sSLEngine);
        this.handshakeCompleted = zDoHandshake;
        if (getLogManager() != null) {
            getLogManager().logDebug(TAG, "Handshake completed with result: " + zDoHandshake);
            getLogManager().logDebug(TAG, "Post-handshake SSLEngine state - isInboundDone: " + sSLEngine.isInboundDone() + ", isOutboundDone: " + sSLEngine.isOutboundDone() + ", handshakeStatus: " + sSLEngine.getHandshakeStatus());
        }
        if (!zDoHandshake) {
            if (getLogManager() != null) {
                getLogManager().logError(TAG, "Handshake was not successful, throwing exception");
            }
            throw new Exception("SSL handshake failed");
        }
        if (sSLEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            executeDelegatedTasks();
        }
    }
}
