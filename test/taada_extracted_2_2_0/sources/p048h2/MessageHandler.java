package p048h2;

import fr.sd.taada.helpers.HexHelper;
import fr.sd.taada.helpers.LogManager;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MessageHandler {
    private static final byte[] EMPTY_BUFFER = new byte[0];
    private static final String TAG = "MessageHandler";
    DataInputStream dataInputStream;
    OutputStream outputStream;
    private long totalBytesRead = 0;
    private long totalBytesSent = 0;
    private int messageReadCount = 0;
    private int messageSentCount = 0;
    private int optimizedReads = 0;
    private int fallbackReads = 0;
    private LogManager logManager = LogManager.getInstance(null);
    private final BufferPool bufferPool = BufferPool.getInstance();

    public MessageHandler(InputStream inputStream, OutputStream outputStream) {
        this.dataInputStream = new DataInputStream(inputStream);
        this.outputStream = outputStream;
        this.logManager.logDebug(TAG, "MessageHandler initialized with optimized buffer pool");
    }

    public void cleanup() {
        this.logManager.logDebug(TAG, "Cleaning up MessageHandler resources");
        this.logManager.logDebug(TAG, "Final optimization stats: " + getOptimizationStatistics());
    }

    public String getOptimizationStatistics() {
        int i = this.optimizedReads;
        int i3 = this.fallbackReads + i;
        return String.format(Locale.ROOT, "MessageHandler Optimization: %.1f%% (%d/%d), BufferPool: %s", Double.valueOf(i3 > 0 ? (((double) i) / ((double) i3)) * 100.0d : 0.0d), Integer.valueOf(this.optimizedReads), Integer.valueOf(i3), this.bufferPool.getStatistics());
    }

    public byte[] readData() {
        return readData(0);
    }

    public byte[] readData_old(int i) throws IOException {
        byte[] bArr = new byte[16384];
        this.dataInputStream.readFully(bArr, 0, 4);
        short s3 = (short) (((bArr[2] & 255) << 8) | (bArr[3] & 255));
        byte b = bArr[1];
        if (b == 9 || b == 1) {
            s3 = (short) (s3 + 4);
        }
        this.dataInputStream.readFully(bArr, 4, s3);
        return Arrays.copyOf(bArr, s3 + 4);
    }

    public synchronized void sendData(byte[] bArr) {
        this.logManager.logDebug(TAG, "Sending data with default offset");
        sendData(bArr, 0);
    }

    public byte[] readData(int i) {
        char c;
        char c6 = 3;
        this.messageReadCount++;
        this.logManager.logDebug(TAG, "Reading data (#" + this.messageReadCount + ") with offset: " + i);
        byte[] headerBuffer = this.bufferPool.getHeaderBuffer();
        int i3 = 0;
        while (i3 < 4) {
            try {
                try {
                    int i4 = this.dataInputStream.read(headerBuffer, i3, 4 - i3);
                    if (i4 == -1) {
                        this.logManager.logWarning(TAG, "End of stream reached during header read (#" + this.messageReadCount + ") - read " + i3 + " of 4 bytes");
                        this.bufferPool.returnHeaderBuffer(headerBuffer);
                        this.fallbackReads = this.fallbackReads + 1;
                        return EMPTY_BUFFER;
                    }
                    i3 += i4;
                } catch (IOException e) {
                    this.logManager.logError(TAG, "Error reading header: " + e.getMessage());
                    this.bufferPool.returnHeaderBuffer(headerBuffer);
                    this.fallbackReads = this.fallbackReads + 1;
                    return EMPTY_BUFFER;
                }
            } catch (Exception e6) {
                this.logManager.logError(TAG, "Error reading data (#" + this.messageReadCount + "): " + e6.getMessage(), e6);
                this.fallbackReads = this.fallbackReads + 1;
                return EMPTY_BUFFER;
            }
        }
        this.totalBytesRead += (long) i3;
        int i5 = ((headerBuffer[2] & 255) << 8) | (headerBuffer[3] & 255);
        byte b = headerBuffer[1];
        byte b2 = headerBuffer[0];
        this.logManager.logDebug(TAG, "Message header (#" + this.messageReadCount + "): channel=" + ((int) b2) + ", type=" + ((int) b) + ", length=" + i5 + ", header bytes: " + HexHelper.bytesToHexString(headerBuffer, 0, 4));
        if (b == 9 || b == 1) {
            i5 += 4;
            this.logManager.logDebug(TAG, "Adjusted length for message type " + ((int) b) + ": " + i5);
        }
        if (i5 >= 0 && i5 <= 524288) {
            int i6 = i5 + 4;
            byte[] buffer = this.bufferPool.getBuffer(i6);
            buffer[0] = headerBuffer[0];
            buffer[1] = headerBuffer[1];
            buffer[2] = headerBuffer[2];
            buffer[3] = headerBuffer[3];
            this.bufferPool.returnHeaderBuffer(headerBuffer);
            int i7 = i5;
            int i8 = 0;
            while (i8 < i5) {
                try {
                    c = c6;
                    int i9 = i8 + 4;
                    try {
                        int i10 = this.dataInputStream.read(buffer, i9, i7);
                        if (i10 == -1) {
                            this.logManager.logWarning(TAG, "End of stream reached during payload read (#" + this.messageReadCount + ") - read " + i8 + " of " + i5 + " bytes");
                            this.bufferPool.returnBuffer(buffer);
                            this.fallbackReads = this.fallbackReads + 1;
                            if (i8 > 0) {
                                byte[] bArr = new byte[i9];
                                System.arraycopy(buffer, 0, bArr, 0, i9);
                                return bArr;
                            }
                            byte[] bArr2 = new byte[4];
                            System.arraycopy(buffer, 0, bArr2, 0, 4);
                            return bArr2;
                        }
                        i8 += i10;
                        i7 -= i10;
                        c6 = c;
                    } catch (IOException e7) {
                        e = e7;
                        this.logManager.logError(TAG, "Error reading payload: " + e.getMessage());
                        this.bufferPool.returnBuffer(buffer);
                        this.fallbackReads = this.fallbackReads + 1;
                        byte b6 = buffer[0];
                        byte b7 = buffer[1];
                        byte b8 = buffer[2];
                        byte b9 = buffer[c];
                        byte[] bArr3 = new byte[4];
                        bArr3[0] = b6;
                        bArr3[1] = b7;
                        bArr3[2] = b8;
                        bArr3[c] = b9;
                        return bArr3;
                    }
                } catch (IOException e8) {
                    e = e8;
                    c = c6;
                }
            }
            if (i8 > 0) {
                this.logManager.logDebug(TAG, "Payload read completed: " + i8 + " bytes (expected: " + i5 + ")");
            }
            this.totalBytesRead += (long) i8;
            if (this.messageReadCount % 100 == 0) {
                this.logManager.logDebug(TAG, "BufferPool optimization stats: " + this.bufferPool.getStatistics());
                this.logManager.logDebug(TAG, "MessageHandler stats: Optimized reads: " + this.optimizedReads + ", Fallback reads: " + this.fallbackReads);
            }
            if (buffer.length == i6) {
                this.optimizedReads++;
                this.logManager.logDebug(TAG, "Successfully read message #" + this.messageReadCount + ": " + buffer.length + " bytes (optimized), first 16 bytes: " + HexHelper.bytesToHexString(buffer, 0, Math.min(16, buffer.length)));
                return buffer;
            }
            byte[] bArr4 = new byte[i6];
            System.arraycopy(buffer, 0, bArr4, 0, i6);
            this.bufferPool.returnBuffer(buffer);
            this.optimizedReads++;
            this.logManager.logDebug(TAG, "Successfully read message #" + this.messageReadCount + ": " + i6 + " bytes (copy), first 16 bytes: " + HexHelper.bytesToHexString(bArr4, 0, Math.min(16, i6)));
            return bArr4;
        }
        this.logManager.logWarning(TAG, "Invalid message length: " + i5);
        byte[] bArr5 = new byte[4];
        System.arraycopy(headerBuffer, 0, bArr5, 0, 4);
        this.bufferPool.returnHeaderBuffer(headerBuffer);
        this.fallbackReads++;
        return bArr5;
    }

    public void sendData(byte[] bArr, int i) {
        this.messageSentCount++;
        if (bArr == null) {
            this.logManager.logWarning(TAG, "Attempted to send null data (message #" + this.messageSentCount + ")");
            return;
        }
        this.logManager.logDebug(TAG, "Sending data (#" + this.messageSentCount + ") with offset " + i + ", " + bArr.length + " bytes, first 16 bytes: " + HexHelper.bytesToHexString(bArr, 0, Math.min(16, bArr.length)));
        try {
            this.outputStream.write(bArr);
            this.outputStream.flush();
            this.totalBytesSent += (long) bArr.length;
            this.logManager.logDebug(TAG, "Data sent successfully (#" + this.messageSentCount + "), total bytes sent: " + this.totalBytesSent);
        } catch (IOException e) {
            this.logManager.logError(TAG, "Error sending data (#" + this.messageSentCount + "): " + e.getMessage(), e);
        }
    }
}
