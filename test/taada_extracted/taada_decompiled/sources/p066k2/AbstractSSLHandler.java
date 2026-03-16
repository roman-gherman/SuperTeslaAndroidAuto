package p066k2;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.a;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.MemoryHelper;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import p048h2.MessageHandler;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSSLHandler {
    private static final int INITIAL_BUFFER_SIZE = 32768;
    private static final String INVALID_SSL_STATUS_PREFIX = "Invalid SSL status: ";
    private static final int MAX_BUFFER_SIZE = 67108864;
    private static final int SAFE_GROWTH_FACTOR = 2;
    protected static final String TAG = "AAGateWay";
    protected Context context;
    ByteBuffer encryptedBuffer;
    private final ExecutorService executorService;
    ByteBuffer inBuffer;
    protected MessageHandler ioHandler;
    protected LogManager logManager;
    ByteBuffer messageBuffer;
    ByteBuffer outBuffer;

    public static class HandshakeStatusHelper {
        static final int[] handshakeStatusOrdinals;
        static final int[] statusOrdinals;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            handshakeStatusOrdinals = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                handshakeStatusOrdinals[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                handshakeStatusOrdinals[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                handshakeStatusOrdinals[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                handshakeStatusOrdinals[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[SSLEngineResult.Status.values().length];
            statusOrdinals = iArr2;
            try {
                iArr2[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                statusOrdinals[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                statusOrdinals[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                statusOrdinals[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public AbstractSSLHandler(Context context) {
        this.messageBuffer = ByteBuffer.allocate(32768);
        this.encryptedBuffer = ByteBuffer.allocate(32768);
        this.outBuffer = ByteBuffer.allocate(32768);
        this.inBuffer = ByteBuffer.allocate(32768);
        this.executorService = Executors.newSingleThreadExecutor();
        this.context = context;
    }

    public boolean doHandshake(SSLEngine sSLEngine) {
        SSLEngineResult.HandshakeStatus handshakeStatus;
        SSLEngineResult sSLEngineResultUnwrap;
        getLogManager().logDebug("AbstractSSLHandler", "doHandshake from AbstractSSLHandler");
        this.encryptedBuffer.clear();
        this.inBuffer.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus2 = sSLEngine.getHandshakeStatus();
        if (handshakeStatus2 != SSLEngineResult.HandshakeStatus.FINISHED) {
            SSLEngineResult.HandshakeStatus handshakeStatus3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        while (handshakeStatus2 != SSLEngineResult.HandshakeStatus.FINISHED && handshakeStatus2 != (handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
            int i = HandshakeStatusHelper.handshakeStatusOrdinals[handshakeStatus2.ordinal()];
            if (i == 1) {
                byte[] data = this.ioHandler.readData();
                this.outBuffer.clear();
                if (data.length <= 0) {
                    if (sSLEngine.isInboundDone() && sSLEngine.isOutboundDone()) {
                        return false;
                    }
                    try {
                        sSLEngine.closeInbound();
                        sSLEngine.closeOutbound();
                        handshakeStatus2 = sSLEngine.getHandshakeStatus();
                    } catch (SSLException e) {
                        if (getLogManager() != null) {
                            getLogManager().logError(TAG, "Error closing inbound: " + e.getMessage());
                        }
                        throw new Exception("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
                    }
                } else {
                    if (data.length <= 6) {
                        if (getLogManager() != null) {
                            getLogManager().logError(TAG, "Data too short! Only " + data.length + " bytes");
                        }
                        return false;
                    }
                    this.inBuffer.put(data, 6, data.length - 6);
                    this.inBuffer.flip();
                    while (true) {
                        try {
                            sSLEngineResultUnwrap = sSLEngine.unwrap(this.inBuffer, this.outBuffer);
                            getLogManager().logDebug(TAG, "data unwrapped...");
                            getLogManager().logDebug(TAG, "Handskes is: " + sSLEngineResultUnwrap.getHandshakeStatus().toString() + " Current Status: " + sSLEngineResultUnwrap.getStatus() + " Bytes consumed: " + sSLEngineResultUnwrap.bytesConsumed() + " bytes produce: " + sSLEngineResultUnwrap.bytesProduced());
                            if (!this.inBuffer.hasRemaining() && sSLEngineResultUnwrap.bytesProduced() <= 0) {
                                break;
                            }
                        } catch (SSLException e6) {
                            if (getLogManager() != null) {
                                getLogManager().logError(TAG, "SSL exception during unwrap: " + e6.getMessage());
                            }
                            sSLEngine.closeOutbound();
                            sSLEngine.getHandshakeStatus();
                            throw new Exception("A problem was encountered while processing the data that caused the SSLEngine to abort. Will try to properly close connection..." + e6.getMessage());
                        }
                    }
                    this.inBuffer.compact();
                    getLogManager().logDebug(TAG, "data compacted...");
                    handshakeStatus = sSLEngineResultUnwrap.getHandshakeStatus();
                    getLogManager().logDebug(TAG, "Handshake status: " + handshakeStatus);
                    int i3 = HandshakeStatusHelper.statusOrdinals[sSLEngineResultUnwrap.getStatus().ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            this.outBuffer = resizeApplicationBuffer(sSLEngine, this.outBuffer);
                        } else if (i3 == 3) {
                            this.inBuffer = handleBufferUnderflow(sSLEngine, this.inBuffer);
                        } else {
                            if (i3 != 4) {
                                if (getLogManager() != null) {
                                    getLogManager().logError(TAG, INVALID_SSL_STATUS_PREFIX + sSLEngineResultUnwrap.getStatus());
                                }
                                throw new IllegalStateException(INVALID_SSL_STATUS_PREFIX + sSLEngineResultUnwrap.getStatus());
                            }
                            if (sSLEngine.isOutboundDone()) {
                                return false;
                            }
                        }
                    }
                    handshakeStatus2 = handshakeStatus;
                }
            } else {
                if (i == 2) {
                    this.encryptedBuffer.clear();
                    try {
                        this.messageBuffer.flip();
                        SSLEngineResult sSLEngineResultWrap = sSLEngine.wrap(this.messageBuffer, this.encryptedBuffer);
                        getLogManager().logDebug(TAG, "Got a result" + this.messageBuffer.toString());
                        this.messageBuffer.compact();
                        handshakeStatus = sSLEngineResultWrap.getHandshakeStatus();
                        getLogManager().logDebug(TAG, "Handskes is: " + sSLEngineResultWrap.getHandshakeStatus().toString() + " Current Status: " + sSLEngineResultWrap.getStatus() + " Bytes consumed: " + sSLEngineResultWrap.bytesConsumed() + " bytes produce: " + sSLEngineResultWrap.bytesProduced() + " bytes remaining: " + this.encryptedBuffer.remaining());
                        int i4 = HandshakeStatusHelper.statusOrdinals[sSLEngineResultWrap.getStatus().ordinal()];
                        if (i4 == 1) {
                            this.encryptedBuffer.flip();
                            int iRemaining = this.encryptedBuffer.remaining();
                            byte[] bArr = new byte[iRemaining + 6];
                            ByteBuffer byteBuffer = this.encryptedBuffer;
                            byteBuffer.get(bArr, 6, byteBuffer.remaining());
                            bArr[0] = 0;
                            bArr[1] = 3;
                            int i5 = iRemaining + 2;
                            bArr[2] = (byte) (i5 / 256);
                            bArr[3] = (byte) (i5 % 256);
                            bArr[4] = 0;
                            bArr[5] = 3;
                            this.ioHandler.sendData(bArr);
                        } else if (i4 == 2) {
                            this.encryptedBuffer = resizePacketBuffer(sSLEngine, this.encryptedBuffer);
                        } else {
                            if (i4 == 3) {
                                if (getLogManager() != null) {
                                    getLogManager().logError(TAG, "Buffer underflow after wrap - unexpected!");
                                }
                                throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                            }
                            if (i4 != 4) {
                                if (getLogManager() != null) {
                                    getLogManager().logError(TAG, INVALID_SSL_STATUS_PREFIX + sSLEngineResultWrap.getStatus());
                                }
                                throw new IllegalStateException(INVALID_SSL_STATUS_PREFIX + sSLEngineResultWrap.getStatus());
                            }
                            try {
                                getLogManager().logDebug(TAG, "Before WRAP FLIP");
                                this.encryptedBuffer.flip();
                                getLogManager().logDebug(TAG, "After WRAP FLIP");
                                while (this.encryptedBuffer.hasRemaining()) {
                                    getLogManager().logDebug(TAG, this.encryptedBuffer.toString());
                                    byte[] bArr2 = new byte[this.encryptedBuffer.remaining()];
                                    this.encryptedBuffer.get(bArr2);
                                    this.ioHandler.sendData(bArr2);
                                }
                                this.inBuffer.clear();
                            } catch (Exception e7) {
                                getLogManager().logError(TAG, "Failed to send server's CLOSE message: " + e7.getMessage());
                                sSLEngine.getHandshakeStatus();
                                throw new Exception("Failed to send server's CLOSE message due to socket channel's failure.");
                            }
                        }
                    } catch (SSLException e8) {
                        if (getLogManager() != null) {
                            getLogManager().logError(TAG, "SSLException during wrap: " + e8.getMessage());
                        }
                        sSLEngine.closeOutbound();
                        sSLEngine.getHandshakeStatus();
                        throw new Exception("A problem was encountered while processing the data that caused the SSLEngine to abort. Will try to properly close connection...");
                    }
                } else if (i == 3) {
                    while (true) {
                        Runnable delegatedTask = sSLEngine.getDelegatedTask();
                        if (delegatedTask == null) {
                            break;
                        }
                        this.executorService.execute(delegatedTask);
                    }
                    handshakeStatus2 = sSLEngine.getHandshakeStatus();
                } else if (i != 4) {
                    if (i != 5) {
                        Log.e(TAG, INVALID_SSL_STATUS_PREFIX + handshakeStatus2);
                        throw new IllegalStateException(INVALID_SSL_STATUS_PREFIX + handshakeStatus2);
                    }
                }
                handshakeStatus2 = handshakeStatus;
            }
        }
        return true;
    }

    public LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.context);
        }
        return this.logManager;
    }

    public ByteBuffer handleBufferUnderflow(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        if (sSLEngine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer byteBufferResizePacketBuffer = resizePacketBuffer(sSLEngine, byteBuffer);
        byteBuffer.flip();
        byteBufferResizePacketBuffer.put(byteBuffer);
        return byteBufferResizePacketBuffer;
    }

    public ByteBuffer resizeApplicationBuffer(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return resizeBuffer(byteBuffer, sSLEngine.getSession().getApplicationBufferSize());
    }

    public ByteBuffer resizeBuffer(ByteBuffer byteBuffer, int i) {
        int iMin;
        if (i < 0) {
            getLogManager().logError("AbstractSSLHandler", "Invalid preferredSize: " + i);
            i = 32768;
        }
        if (i > 67108864) {
            getLogManager().logWarning("AbstractSSLHandler", "Requested buffer size " + i + " exceeds maximum allowed size 67108864. Using maximum size.");
            i = 67108864;
        }
        int iCapacity = byteBuffer.capacity();
        if (i > iCapacity) {
            iMin = i;
        } else {
            long j6 = ((long) iCapacity) * 2;
            if (j6 > 67108864) {
                getLogManager().logWarning("AbstractSSLHandler", "Buffer growth would exceed maximum size. Using maximum size.");
                iMin = 67108864;
            } else {
                iMin = (int) j6;
            }
        }
        if (iMin <= 0 || iMin > 67108864) {
            getLogManager().logError("AbstractSSLHandler", a.n("Calculated buffer size ", iMin, " is invalid. Fallback to current capacity: ", iCapacity));
            iMin = iCapacity;
        }
        Context context = this.context;
        if (context != null) {
            MemoryHelper.MemoryStatus memoryStatusCheckMemoryStatus = MemoryHelper.checkMemoryStatus(context);
            if (memoryStatusCheckMemoryStatus == MemoryHelper.MemoryStatus.CRITICAL) {
                getLogManager().logError("AbstractSSLHandler", "❌ CRITICAL MEMORY STATE detected!");
                MemoryHelper.logMemoryState(this.context, "AbstractSSLHandler");
                iMin = Math.min(iMin, iCapacity + 16384);
                getLogManager().logWarning("AbstractSSLHandler", "🚨 Reducing buffer size to " + iMin + " due to critical memory state");
                MemoryHelper.requestMemoryCleanup(true);
            } else if (memoryStatusCheckMemoryStatus == MemoryHelper.MemoryStatus.WARNING) {
                getLogManager().logWarning("AbstractSSLHandler", "⚠️ Memory warning - Being conservative with allocation");
                if (!MemoryHelper.isAllocationSafe(this.context, iMin)) {
                    getLogManager().logWarning("AbstractSSLHandler", "🔧 Allocation deemed unsafe, reducing size");
                    iMin = Math.min(iMin, iCapacity + 32768);
                    MemoryHelper.requestMemoryCleanup(false);
                }
            }
            if (iMin > 1048576) {
                MemoryHelper.logMemoryState(this.context, "AbstractSSLHandler");
            }
        }
        try {
            getLogManager().logDebug("AbstractSSLHandler", "Resizing buffer from " + MemoryHelper.formatBytes(iCapacity) + " to " + MemoryHelper.formatBytes(iMin) + " (preferred: " + MemoryHelper.formatBytes(i) + ")");
            return ByteBuffer.allocate(iMin);
        } catch (OutOfMemoryError unused) {
            getLogManager().logError("AbstractSSLHandler", "OutOfMemoryError when allocating " + MemoryHelper.formatBytes(iMin) + ". Attempting with smaller size.");
            Context context2 = this.context;
            if (context2 != null) {
                MemoryHelper.logMemoryState(context2, "AbstractSSLHandler");
                MemoryHelper.requestMemoryCleanup(true);
            }
            int iMax = Math.max(iMin / 2, 32768);
            try {
                getLogManager().logDebug("AbstractSSLHandler", "Fallback: allocating " + MemoryHelper.formatBytes(iMax));
                return ByteBuffer.allocate(iMax);
            } catch (OutOfMemoryError unused2) {
                getLogManager().logError("AbstractSSLHandler", "Critical: Cannot allocate even " + MemoryHelper.formatBytes(iMax) + ". Using current buffer.");
                return byteBuffer;
            }
        }
    }

    public ByteBuffer resizePacketBuffer(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return resizeBuffer(byteBuffer, sSLEngine.getSession().getPacketBufferSize());
    }

    public AbstractSSLHandler() {
        this.messageBuffer = ByteBuffer.allocate(32768);
        this.encryptedBuffer = ByteBuffer.allocate(32768);
        this.outBuffer = ByteBuffer.allocate(32768);
        this.inBuffer = ByteBuffer.allocate(32768);
        this.executorService = Executors.newSingleThreadExecutor();
        this.context = null;
    }
}
