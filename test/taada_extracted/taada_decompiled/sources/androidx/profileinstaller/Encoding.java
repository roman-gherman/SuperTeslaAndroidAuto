package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    public static int bitsToBytes(int i) {
        return ((i + 7) & (-8)) / 8;
    }

    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static RuntimeException error(String str) {
        return new IllegalStateException(str);
    }

    public static byte[] read(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i3 = 0;
        while (i3 < i) {
            int i4 = inputStream.read(bArr, i3, i - i3);
            if (i4 < 0) {
                throw error(B2.b.c(i, "Not enough bytes to read: "));
            }
            i3 += i4;
        }
        return bArr;
    }

    public static byte[] readCompressed(InputStream inputStream, int i, int i3) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i) {
                int i5 = inputStream.read(bArr2);
                if (i5 < 0) {
                    throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i5);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i3 - iInflate);
                    i4 += i5;
                } catch (DataFormatException e) {
                    throw error(e.getMessage());
                }
            }
            if (i4 == i) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw error("Inflater did not finish");
            }
            throw error("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i4);
        } finally {
            inflater.end();
        }
    }

    public static String readString(InputStream inputStream, int i) {
        return new String(read(inputStream, i), StandardCharsets.UTF_8);
    }

    public static long readUInt(InputStream inputStream, int i) throws IOException {
        byte[] bArr = read(inputStream, i);
        long j6 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            j6 += ((long) (bArr[i3] & 255)) << (i3 * 8);
        }
        return j6;
    }

    public static int readUInt16(InputStream inputStream) {
        return (int) readUInt(inputStream, 2);
    }

    public static long readUInt32(InputStream inputStream) {
        return readUInt(inputStream, 4);
    }

    public static int readUInt8(InputStream inputStream) {
        return (int) readUInt(inputStream, 1);
    }

    public static int utf8Length(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void writeAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void writeCompressed(OutputStream outputStream, byte[] bArr) throws IOException {
        writeUInt32(outputStream, bArr.length);
        byte[] bArrCompress = compress(bArr);
        writeUInt32(outputStream, bArrCompress.length);
        outputStream.write(bArrCompress);
    }

    public static void writeString(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeUInt(OutputStream outputStream, long j6, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((j6 >> (i3 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    public static void writeUInt16(OutputStream outputStream, int i) throws IOException {
        writeUInt(outputStream, i, 2);
    }

    public static void writeUInt32(OutputStream outputStream, long j6) throws IOException {
        writeUInt(outputStream, j6, 4);
    }

    public static void writeUInt8(OutputStream outputStream, int i) throws IOException {
        writeUInt(outputStream, i, 1);
    }
}
