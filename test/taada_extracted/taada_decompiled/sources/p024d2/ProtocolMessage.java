package p024d2;

import B2.b;
import com.google.protobuf.MessageLite;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p066k2.SSLHandler;

/* JADX INFO: loaded from: classes.dex */
public class ProtocolMessage {
    private static final ProtocolBufferPool bufferPool = new ProtocolBufferPool();
    byte channel;
    byte extraFlag;
    int f7595d;
    short frameSize;
    int messageType;
    byte[] payload;
    byte service;
    byte sslFlag;

    public static class ProtocolBufferPool {
        private final int MAX_MESSAGE_POOL_SIZE;
        private final int MAX_SSL_POOL_SIZE;
        private final int MESSAGE_BUFFER_SIZE;
        private final int SSL_BUFFER_SIZE;
        private final ConcurrentLinkedQueue<ByteBuffer> messageBuffers;
        private final AtomicInteger messageBuffersCreated;
        private final AtomicLong messageHits;
        private final AtomicLong messageMisses;
        private final ConcurrentLinkedQueue<ByteBuffer> sslBuffers;
        private final AtomicInteger sslBuffersCreated;
        private final AtomicLong sslHits;
        private final AtomicLong sslMisses;

        private ProtocolBufferPool() {
            this.sslBuffers = new ConcurrentLinkedQueue<>();
            this.messageBuffers = new ConcurrentLinkedQueue<>();
            this.SSL_BUFFER_SIZE = 16384;
            this.MESSAGE_BUFFER_SIZE = 8192;
            this.MAX_SSL_POOL_SIZE = 10;
            this.MAX_MESSAGE_POOL_SIZE = 20;
            this.sslHits = new AtomicLong(0L);
            this.sslMisses = new AtomicLong(0L);
            this.messageHits = new AtomicLong(0L);
            this.messageMisses = new AtomicLong(0L);
            this.sslBuffersCreated = new AtomicInteger(0);
            this.messageBuffersCreated = new AtomicInteger(0);
        }

        public ByteBuffer acquireMessageBuffer(int i) {
            ByteBuffer byteBufferPoll;
            if (i > 8192 || (byteBufferPoll = this.messageBuffers.poll()) == null) {
                this.messageMisses.incrementAndGet();
                this.messageBuffersCreated.incrementAndGet();
                return ByteBuffer.allocate(Math.max(i, 8192));
            }
            byteBufferPoll.clear();
            this.messageHits.incrementAndGet();
            return byteBufferPoll;
        }

        public ByteBuffer acquireSSLBuffer() {
            ByteBuffer byteBufferPoll = this.sslBuffers.poll();
            if (byteBufferPoll != null) {
                byteBufferPoll.clear();
                this.sslHits.incrementAndGet();
                return byteBufferPoll;
            }
            this.sslMisses.incrementAndGet();
            this.sslBuffersCreated.incrementAndGet();
            return ByteBuffer.allocate(16384);
        }

        public String getStats() {
            long j6 = this.sslMisses.get() + this.sslHits.get();
            long j7 = this.messageMisses.get() + this.messageHits.get();
            return String.format(Locale.ROOT, "ProtocolBufferPool: SSL[%d pooled, %.1f%% hit], Message[%d pooled, %.1f%% hit], Memory: ~%d KB", Integer.valueOf(this.sslBuffers.size()), Double.valueOf(j6 > 0 ? (this.sslHits.get() * 100.0d) / j6 : 0.0d), Integer.valueOf(this.messageBuffers.size()), Double.valueOf(j7 > 0 ? (this.messageHits.get() * 100.0d) / j7 : 0.0d), Integer.valueOf(((this.messageBuffers.size() * 8192) + (this.sslBuffers.size() * 16384)) / 1024));
        }

        public void releaseMessageBuffer(ByteBuffer byteBuffer) {
            if (byteBuffer == null || byteBuffer.capacity() > 8192 || this.messageBuffers.size() >= 20) {
                return;
            }
            byteBuffer.clear();
            this.messageBuffers.offer(byteBuffer);
        }

        public void releaseSSLBuffer(ByteBuffer byteBuffer) {
            if (byteBuffer == null || byteBuffer.capacity() != 16384 || this.sslBuffers.size() >= 10) {
                return;
            }
            byteBuffer.clear();
            this.sslBuffers.offer(byteBuffer);
        }
    }

    public ProtocolMessage(byte b, byte b2, int i) {
        this.sslFlag = (byte) 8;
        this.extraFlag = (byte) 0;
        this.channel = b;
        this.service = b2;
        this.messageType = i;
    }

    public static String getBufferPoolStats() {
        return bufferPool.getStats();
    }

    public static void logBufferPoolStats() {
        System.out.println("🚀 " + bufferPool.getStats());
    }

    public static void resetBufferPoolStats() {
        ProtocolBufferPool protocolBufferPool = bufferPool;
        protocolBufferPool.sslHits.set(0L);
        protocolBufferPool.sslMisses.set(0L);
        protocolBufferPool.messageHits.set(0L);
        protocolBufferPool.messageMisses.set(0L);
        protocolBufferPool.sslBuffersCreated.set(0);
        protocolBufferPool.messageBuffersCreated.set(0);
    }

    public byte[] encryptWithSSL(SSLHandler sSLHandler) {
        if (this.sslFlag == 8) {
            ProtocolBufferPool protocolBufferPool = bufferPool;
            ByteBuffer byteBufferAcquireSSLBuffer = protocolBufferPool.acquireSSLBuffer();
            try {
                byteBufferAcquireSSLBuffer.put(this.channel);
                byteBufferAcquireSSLBuffer.put((byte) (this.service + this.sslFlag + this.extraFlag));
                sSLHandler.m2560g(this.payload, this.messageType, byteBufferAcquireSSLBuffer);
                byteBufferAcquireSSLBuffer.flip();
                byte[] bArr = new byte[byteBufferAcquireSSLBuffer.remaining()];
                byteBufferAcquireSSLBuffer.get(bArr);
                protocolBufferPool.releaseSSLBuffer(byteBufferAcquireSSLBuffer);
                return bArr;
            } catch (Exception unused) {
                bufferPool.releaseSSLBuffer(byteBufferAcquireSSLBuffer);
                return null;
            } catch (Throwable th) {
                bufferPool.releaseSSLBuffer(byteBufferAcquireSSLBuffer);
                throw th;
            }
        }
        int length = this.payload.length + 8;
        ProtocolBufferPool protocolBufferPool2 = bufferPool;
        ByteBuffer byteBufferAcquireMessageBuffer = protocolBufferPool2.acquireMessageBuffer(length);
        try {
            byteBufferAcquireMessageBuffer.put(this.channel);
            byteBufferAcquireMessageBuffer.put((byte) (this.service + this.extraFlag));
            byteBufferAcquireMessageBuffer.put((byte) (((this.payload.length + 2) >> 8) & 255));
            byteBufferAcquireMessageBuffer.put((byte) ((this.payload.length + 2) & 255));
            byteBufferAcquireMessageBuffer.put((byte) ((this.messageType >> 8) & 255));
            byteBufferAcquireMessageBuffer.put((byte) (this.messageType & 255));
            byteBufferAcquireMessageBuffer.put(this.payload);
            byte[] bArr2 = new byte[length];
            byteBufferAcquireMessageBuffer.flip();
            byteBufferAcquireMessageBuffer.get(bArr2);
            protocolBufferPool2.releaseMessageBuffer(byteBufferAcquireMessageBuffer);
            return bArr2;
        } catch (Throwable th2) {
            bufferPool.releaseMessageBuffer(byteBufferAcquireMessageBuffer);
            throw th2;
        }
    }

    public byte getChannel() {
        return this.channel;
    }

    public byte getExtraFlag() {
        return this.extraFlag;
    }

    public short getFrameSize() {
        return this.frameSize;
    }

    public int getFrameType() {
        return this.f7595d;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public byte getService() {
        return this.service;
    }

    public void setExtraFlag(byte b) {
        this.extraFlag = b;
    }

    public void setPayloadFromProto(MessageLite.Builder builder) {
        this.payload = builder.build().toByteArray();
    }

    public String toString() {
        return "Channel: " + ((int) this.channel) + ", flag: " + ((int) this.service) + ", messageid: " + this.messageType + ", data: " + AbstractC2114e.m3592a(this.payload);
    }

    public void trimMessageTypeBytes() {
        byte[] bArr = this.payload;
        this.payload = Arrays.copyOfRange(bArr, 2, bArr.length);
    }

    public ProtocolMessage(byte b, byte b2, int i, MessageLite.Builder builder) {
        this(b, b2, i);
        setPayloadFromProto(builder);
    }

    public ProtocolMessage(byte b, byte b2, int i, byte[] bArr) {
        this.sslFlag = (byte) 8;
        this.extraFlag = (byte) 0;
        this.channel = b;
        this.service = b2;
        this.messageType = i;
        this.payload = bArr;
    }

    public ProtocolMessage(byte b, byte b2, short s3, short s6, int i, byte[] bArr) {
        this.sslFlag = (byte) 8;
        this.extraFlag = (byte) 0;
        this.channel = b;
        this.service = b2;
        this.frameSize = s3;
        this.f7595d = s6;
        this.messageType = i;
        this.payload = bArr;
    }

    public ProtocolMessage(byte[] bArr, SSLHandler sSLHandler) {
        byte b;
        if (bArr != null) {
            if (bArr.length >= 4) {
                this.channel = bArr[0];
                byte b2 = bArr[1];
                byte b6 = (byte) (b2 & 8);
                this.sslFlag = b6;
                this.extraFlag = (byte) (b2 & 4);
                byte b7 = (byte) (b2 & 3);
                this.service = b7;
                short s3 = (short) ((bArr[3] & 255) | ((bArr[2] & 255) << 8));
                this.frameSize = s3;
                if (b7 == 1) {
                    if (bArr.length >= 6) {
                        this.f7595d = (short) (((bArr[4] & 255) << 8) | (bArr[5] & 255));
                    } else {
                        throw new IllegalArgumentException("Service 1 requires at least 6 bytes, got: " + bArr.length);
                    }
                }
                short s6 = (b7 == 1 && b6 == 8) ? (short) 8 : (short) 4;
                if (s6 + s3 <= bArr.length) {
                    if (b7 == 1 && b6 == 8) {
                        this.payload = sSLHandler.doUnwrap(bArr, 8, s3);
                    } else if (b6 == 8) {
                        this.payload = sSLHandler.doUnwrap(bArr, 4, s3);
                    } else {
                        this.payload = Arrays.copyOfRange(bArr, 4, s3 + 4);
                    }
                    byte[] bArr2 = this.payload;
                    if (bArr2 == null || bArr2.length <= 0 || (b = this.service) == 0 || b == 2) {
                        return;
                    }
                    if (bArr2.length >= 2) {
                        this.messageType = ((bArr2[0] & 255) << 8) | (bArr2[1] & 255);
                        return;
                    } else {
                        throw new IllegalArgumentException("Payload too short for message type extraction: " + bArr2.length);
                    }
                }
                throw new IllegalArgumentException("Invalid frame size: " + ((int) s3) + " starting at offset " + ((int) s6) + " exceeds data length " + bArr.length);
            }
            throw new IllegalArgumentException(b.g(new StringBuilder("Invalid message length: "), " (minimum 4 bytes required)", bArr.length));
        }
        throw new IllegalArgumentException("Input data cannot be null");
    }
}
