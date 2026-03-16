package p024d2;

import com.google.protobuf.MessageLite;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ProtocolMessagePool {
    private static final int MAX_POOL_SIZE = 16;
    private static ProtocolMessagePool instance;
    private final AtomicInteger hits = new AtomicInteger(0);
    private final AtomicInteger misses = new AtomicInteger(0);
    private final AtomicInteger created = new AtomicInteger(0);
    private final AtomicInteger recycled = new AtomicInteger(0);
    private final ConcurrentLinkedQueue<ProtocolMessage> messagePool = new ConcurrentLinkedQueue<>();

    public static class PooledProtocolMessage {
        private final ProtocolMessage message;
        private final ProtocolMessagePool pool;
        private boolean recycled = false;

        public PooledProtocolMessage(ProtocolMessage protocolMessage, ProtocolMessagePool protocolMessagePool) {
            this.message = protocolMessage;
            this.pool = protocolMessagePool;
        }

        public void close() {
            recycle();
        }

        public ProtocolMessage getMessage() {
            return this.message;
        }

        public void recycle() {
            if (this.recycled) {
                return;
            }
            this.pool.recycleMessage(this.message);
            this.recycled = true;
        }
    }

    private ProtocolMessagePool() {
        preallocateMessages();
    }

    private ProtocolMessage acquireMessage() {
        ProtocolMessage protocolMessagePoll = this.messagePool.poll();
        if (protocolMessagePoll != null) {
            this.hits.incrementAndGet();
            return protocolMessagePoll;
        }
        this.misses.incrementAndGet();
        this.created.incrementAndGet();
        return new ProtocolMessage((byte) 0, (byte) 0, 0);
    }

    public static synchronized ProtocolMessagePool getInstance() {
        try {
            if (instance == null) {
                instance = new ProtocolMessagePool();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void preallocateMessages() {
        for (int i = 0; i < 3; i++) {
            this.messagePool.offer(new ProtocolMessage((byte) 0, (byte) 0, 0));
        }
    }

    private void resetMessage(ProtocolMessage protocolMessage) {
        protocolMessage.channel = (byte) 0;
        protocolMessage.service = (byte) 0;
        protocolMessage.frameSize = (short) 0;
        protocolMessage.f7595d = 0;
        protocolMessage.messageType = 0;
        protocolMessage.payload = null;
        protocolMessage.sslFlag = (byte) 8;
        protocolMessage.extraFlag = (byte) 0;
    }

    public void clear() {
        this.messagePool.clear();
    }

    public ProtocolMessage createMessage(byte b, byte b2, int i) {
        ProtocolMessage protocolMessageAcquireMessage = acquireMessage();
        protocolMessageAcquireMessage.channel = b;
        protocolMessageAcquireMessage.service = b2;
        protocolMessageAcquireMessage.messageType = i;
        protocolMessageAcquireMessage.sslFlag = (byte) 8;
        protocolMessageAcquireMessage.extraFlag = (byte) 0;
        return protocolMessageAcquireMessage;
    }

    public PooledProtocolMessage createPooledMessage(byte b, byte b2, int i) {
        return new PooledProtocolMessage(createMessage(b, b2, i), this);
    }

    public int getPoolSize() {
        return this.messagePool.size();
    }

    public String getStatistics() {
        int i = this.misses.get() + this.hits.get();
        if (i == 0) {
            return "ProtocolMessagePool: No requests yet";
        }
        return String.format(Locale.ROOT, "ProtocolMessagePool: Hit rate: %.1f%% (%d/%d), Pool size: %d, Created: %d, Recycled: %d", Double.valueOf((((double) this.hits.get()) / ((double) i)) * 100.0d), Integer.valueOf(this.hits.get()), Integer.valueOf(i), Integer.valueOf(this.messagePool.size()), Integer.valueOf(this.created.get()), Integer.valueOf(this.recycled.get()));
    }

    public void recycleMessage(ProtocolMessage protocolMessage) {
        if (protocolMessage == null) {
            return;
        }
        resetMessage(protocolMessage);
        if (this.messagePool.size() < 16) {
            this.messagePool.offer(protocolMessage);
            this.recycled.incrementAndGet();
        }
    }

    public PooledProtocolMessage createPooledMessage(byte b, byte b2, int i, MessageLite.Builder builder) {
        return new PooledProtocolMessage(createMessage(b, b2, i, builder), this);
    }

    public ProtocolMessage createMessage(byte b, byte b2, int i, MessageLite.Builder builder) {
        ProtocolMessage protocolMessageCreateMessage = createMessage(b, b2, i);
        protocolMessageCreateMessage.setPayloadFromProto(builder);
        return protocolMessageCreateMessage;
    }

    public ProtocolMessage createMessage(byte b, byte b2, int i, byte[] bArr) {
        ProtocolMessage protocolMessageCreateMessage = createMessage(b, b2, i);
        protocolMessageCreateMessage.payload = bArr;
        return protocolMessageCreateMessage;
    }

    public ProtocolMessage createMessage(byte b, byte b2, short s3, short s6, int i, byte[] bArr) {
        ProtocolMessage protocolMessageAcquireMessage = acquireMessage();
        protocolMessageAcquireMessage.channel = b;
        protocolMessageAcquireMessage.service = b2;
        protocolMessageAcquireMessage.frameSize = s3;
        protocolMessageAcquireMessage.f7595d = s6;
        protocolMessageAcquireMessage.messageType = i;
        protocolMessageAcquireMessage.payload = bArr;
        protocolMessageAcquireMessage.sslFlag = (byte) 8;
        protocolMessageAcquireMessage.extraFlag = (byte) 0;
        return protocolMessageAcquireMessage;
    }
}
