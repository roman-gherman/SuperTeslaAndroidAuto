package f;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final short[] f3157j = new short[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f3158a;
    public final x b;
    public int c;
    public final k d;
    public final k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f3159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f3160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f3161h;
    public final k i;

    public m(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        x xVar = new x();
        this.b = xVar;
        this.c = 0;
        this.d = new k(this, 3);
        this.e = new k(this, 4);
        this.f3159f = new k(this, 5);
        this.f3160g = new k(this, 2);
        this.f3161h = new k(this, 0);
        this.i = new k(this, 1);
        this.f3158a = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        xVar.b(this);
    }

    public static void b(int i, int i3) {
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index:", i, ", length=", i3));
        }
    }

    public final l a(int i, String str) {
        if ((i & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
        int i3 = this.c + i;
        ByteBuffer byteBufferDuplicate = this.f3158a.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(this.c);
        byteBufferDuplicate.limit(i3);
        l lVar = new l(this, str, byteBufferDuplicate);
        this.c = i3;
        return lVar;
    }

    public final void c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                this.f3158a = byteBufferWrap;
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                this.b.b(this);
                return;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public final l d(int i) {
        if (i < 0 || i >= this.f3158a.capacity()) {
            StringBuilder sbJ = B2.b.j(i, "position=", " length=");
            sbJ.append(this.f3158a.capacity());
            throw new IllegalArgumentException(sbJ.toString());
        }
        ByteBuffer byteBufferDuplicate = this.f3158a.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(this.f3158a.capacity());
        return new l(this, "section", byteBufferDuplicate);
    }

    public final e e(f fVar) {
        int i = fVar.i;
        if (i == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        l lVarD = d(i);
        int iZ = C5.f.Z(lVarD);
        int iZ2 = C5.f.Z(lVarD);
        int iZ3 = C5.f.Z(lVarD);
        int iZ4 = C5.f.Z(lVarD);
        C0437c[] c0437cArr = new C0437c[iZ];
        int iZ5 = 0;
        for (int i3 = 0; i3 < iZ; i3++) {
            iZ5 += C5.f.Z(lVarD);
            c0437cArr[i3] = new C0437c(iZ5, C5.f.Z(lVarD));
        }
        C0437c[] c0437cArr2 = new C0437c[iZ2];
        int iZ6 = 0;
        for (int i4 = 0; i4 < iZ2; i4++) {
            iZ6 += C5.f.Z(lVarD);
            c0437cArr2[i4] = new C0437c(iZ6, C5.f.Z(lVarD));
        }
        return new e(c0437cArr, c0437cArr2, lVarD.b(iZ3), lVarD.b(iZ4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c5, code lost:
    
        r0[r1] = new f.h(r3, r6, r11);
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f.i f(f.C0438d r21) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.m.f(f.d):f.i");
    }

    public final void g(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteBuffer byteBufferDuplicate = this.f3158a.duplicate();
        byteBufferDuplicate.clear();
        while (byteBufferDuplicate.hasRemaining()) {
            int iMin = Math.min(8192, byteBufferDuplicate.remaining());
            byteBufferDuplicate.get(bArr, 0, iMin);
            outputStream.write(bArr, 0, iMin);
        }
    }

    public m(int i) {
        this.b = new x();
        this.c = 0;
        this.d = new k(this, 3);
        this.e = new k(this, 4);
        this.f3159f = new k(this, 5);
        this.f3160g = new k(this, 2);
        this.f3161h = new k(this, 0);
        this.i = new k(this, 1);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[i]);
        this.f3158a = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
    }

    public m(File file) throws IOException {
        this.b = new x();
        this.c = 0;
        this.d = new k(this, 3);
        this.e = new k(this, 4);
        this.f3159f = new k(this, 5);
        this.f3160g = new k(this, 2);
        this.f3161h = new k(this, 0);
        this.i = new k(this, 1);
        String name = file.getName();
        if (!name.endsWith(".zip") && !name.endsWith(".jar") && !name.endsWith(".apk")) {
            if (file.getName().endsWith(".dex")) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    c(fileInputStream);
                    fileInputStream.close();
                } finally {
                }
            } else {
                throw new n("unknown output extension: " + file, null);
            }
        } else {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                try {
                    c(inputStream);
                    inputStream.close();
                    zipFile.close();
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            throw new n("Expected classes.dex in " + file, null);
        }
    }
}
