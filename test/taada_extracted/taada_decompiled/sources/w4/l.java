package w4;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.WeakHashMap;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner;
import w3.C0896n;
import w3.C0898p;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends j implements LMSContextBasedSigner {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k f5092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final k[] f5093m;
    public final byte[] b;
    public final p c;
    public final f d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f5094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WeakHashMap f5095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5096h;
    public final Digest i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f5098k;

    static {
        k kVar = new k(1);
        f5092l = kVar;
        k[] kVarArr = new k[129];
        f5093m = kVarArr;
        kVarArr[1] = kVar;
        int i = 2;
        while (true) {
            k[] kVarArr2 = f5093m;
            if (i >= kVarArr2.length) {
                return;
            }
            kVarArr2[i] = new k(i);
            i++;
        }
    }

    public l(l lVar, int i, int i3) {
        super(true);
        p pVar = lVar.c;
        this.c = pVar;
        this.d = lVar.d;
        this.f5097j = i;
        this.b = lVar.b;
        this.e = i3;
        this.f5094f = lVar.f5094f;
        this.f5096h = 1 << pVar.c;
        this.f5095g = lVar.f5095g;
        this.i = io.ktor.utils.io.jvm.javaio.q.f(pVar.b, pVar.d);
        this.f5098k = lVar.f5098k;
    }

    public static l e(Object obj) throws Throwable {
        Throwable th;
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("expected version 0 lms private key");
            }
            p pVar = (p) p.e.get(Integer.valueOf(dataInputStream.readInt()));
            f fVarA = f.a(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            int i = dataInputStream.readInt();
            int i3 = dataInputStream.readInt();
            int i4 = dataInputStream.readInt();
            if (i4 < 0) {
                throw new IllegalStateException("secret length less than zero");
            }
            if (i4 <= dataInputStream.available()) {
                byte[] bArr2 = new byte[i4];
                dataInputStream.readFully(bArr2);
                return new l(pVar, fVarA, i, bArr, i3, bArr2);
            }
            throw new IOException("secret length exceeded " + dataInputStream.available());
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return e(AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                l lVarE = e(dataInputStream3);
                dataInputStream3.close();
                return lVarE;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 == null) {
                    throw th;
                }
                dataInputStream2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final byte[] a(int i) {
        int i3 = 1 << this.c.c;
        byte[] bArr = this.b;
        Digest digest = this.i;
        if (i < i3) {
            int i4 = i * 2;
            byte[] bArrB = b(i4);
            byte[] bArrB2 = b(i4 + 1);
            t.c(g5.c.c(bArr), digest);
            t.s(i, digest);
            t.r((short) -31869, digest);
            digest.update(bArrB, 0, bArrB.length);
            digest.update(bArrB2, 0, bArrB2.length);
            byte[] bArr2 = new byte[digest.getDigestSize()];
            digest.doFinal(bArr2, 0);
            return bArr2;
        }
        t.c(g5.c.c(bArr), digest);
        t.s(i, digest);
        t.r((short) -32126, digest);
        byte[] bArrC = g5.c.c(bArr);
        int i5 = i - i3;
        byte[] bArrC2 = g5.c.c(this.f5094f);
        f fVar = this.d;
        Digest digestJ = io.ktor.utils.io.jvm.javaio.q.j(fVar);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bArrC);
            byte b = (byte) (i5 >>> 24);
            byteArrayOutputStream.write(b);
            byte b2 = (byte) (i5 >>> 16);
            byteArrayOutputStream.write(b2);
            byte b6 = (byte) (i5 >>> 8);
            byteArrayOutputStream.write(b6);
            byte b7 = (byte) i5;
            byteArrayOutputStream.write(b7);
            byteArrayOutputStream.write((byte) 128);
            byteArrayOutputStream.write((byte) 32896);
            while (byteArrayOutputStream.size() < 22) {
                byteArrayOutputStream.write(0);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            digestJ.update(byteArray, 0, byteArray.length);
            C0896n c0896n = fVar.f5084f;
            int i6 = fVar.b;
            Digest digestF = io.ktor.utils.io.jvm.javaio.q.f(i6, c0896n);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream2.write(bArrC);
                byteArrayOutputStream2.write(b);
                byteArrayOutputStream2.write(b2);
                byteArrayOutputStream2.write(b6);
                byteArrayOutputStream2.write(b7);
                int digestSize = digestF.getDigestSize() + 23;
                while (byteArrayOutputStream2.size() < digestSize) {
                    byteArrayOutputStream2.write(0);
                }
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                q qVar = new q(bArrC, bArrC2, io.ktor.utils.io.jvm.javaio.q.f(i6, c0896n));
                qVar.d = i5;
                qVar.e = 0;
                int i7 = (1 << fVar.c) - 1;
                int i8 = 0;
                while (true) {
                    int i9 = fVar.d;
                    if (i8 >= i9) {
                        int digestSize2 = digestJ.getDigestSize();
                        byte[] bArr3 = new byte[digestSize2];
                        digestJ.doFinal(bArr3, 0);
                        digest.update(bArr3, 0, digestSize2);
                        byte[] bArr4 = new byte[digest.getDigestSize()];
                        digest.doFinal(bArr4, 0);
                        return bArr4;
                    }
                    qVar.a(byteArray2, 23, i8 < i9 + (-1));
                    short s3 = (short) i8;
                    byteArray2[20] = (byte) (s3 >>> 8);
                    byteArray2[21] = (byte) s3;
                    for (int i10 = 0; i10 < i7; i10++) {
                        byteArray2[22] = (byte) i10;
                        digestF.update(byteArray2, 0, byteArray2.length);
                        digestF.doFinal(byteArray2, 23);
                    }
                    digestJ.update(byteArray2, 23, i6);
                    i8++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        } catch (Exception e6) {
            throw new RuntimeException(e6.getMessage(), e6);
        }
    }

    public final byte[] b(int i) {
        if (i < this.f5096h) {
            return c(i < 129 ? f5093m[i] : new k(i));
        }
        return a(i);
    }

    public final byte[] c(k kVar) {
        synchronized (this.f5095g) {
            try {
                byte[] bArr = (byte[]) this.f5095g.get(kVar);
                if (bArr != null) {
                    return bArr;
                }
                byte[] bArrA = a(kVar.f5091a);
                this.f5095g.put(kVar, bArrA);
                return bArrA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized int d() {
        return this.f5097j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f5097j != lVar.f5097j || this.e != lVar.e || !Arrays.equals(this.b, lVar.b)) {
            return false;
        }
        p pVar = lVar.c;
        p pVar2 = this.c;
        if (pVar2 == null ? pVar != null : !pVar2.equals(pVar)) {
            return false;
        }
        f fVar = lVar.d;
        f fVar2 = this.d;
        if (fVar2 == null ? fVar == null : fVar2.equals(fVar)) {
            return Arrays.equals(this.f5094f, lVar.f5094f);
        }
        return false;
    }

    public final m f() {
        m mVar;
        synchronized (this) {
            try {
                if (this.f5098k == null) {
                    this.f5098k = new m(this.c, this.d, c(f5092l), this.b);
                }
                mVar = this.f5098k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[LOOP:0: B:12:0x002a->B:13:0x002c, LOOP_END] */
    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w4.i generateLMSContext() {
        /*
            r11 = this;
            w4.p r0 = r11.c
            int r0 = r0.c
            int r1 = r11.d()
            monitor-enter(r11)
            int r2 = r11.f5097j     // Catch: java.lang.Throwable -> L81
            int r3 = r11.e     // Catch: java.lang.Throwable -> L81
            if (r2 >= r3) goto L86
            com.android.billingclient.api.A r5 = new com.android.billingclient.api.A     // Catch: java.lang.Throwable -> L81
            w4.f r3 = r11.d     // Catch: java.lang.Throwable -> L81
            byte[] r4 = r11.b     // Catch: java.lang.Throwable -> L81
            byte[] r6 = r11.f5094f     // Catch: java.lang.Throwable -> L81
            r5.<init>(r3, r4, r2, r6)     // Catch: java.lang.Throwable -> L81
            monitor-enter(r11)     // Catch: java.lang.Throwable -> L81
            int r2 = r11.f5097j     // Catch: java.lang.Throwable -> L83
            r3 = 1
            int r2 = r2 + r3
            r11.f5097j = r2     // Catch: java.lang.Throwable -> L83
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L81
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L81
            int r2 = r3 << r0
            int r2 = r2 + r1
            byte[][] r9 = new byte[r0][]
            r1 = 0
            r4 = r1
        L2a:
            if (r4 >= r0) goto L3a
            int r6 = r3 << r4
            int r6 = r2 / r6
            r6 = r6 ^ r3
            byte[] r6 = r11.b(r6)
            r9[r4] = r6
            int r4 = r4 + 1
            goto L2a
        L3a:
            w4.p r6 = r11.c
            java.lang.Object r0 = r5.b
            w4.f r0 = (w4.f) r0
            int r2 = r0.b
            byte[] r8 = new byte[r2]
            w4.q r3 = new w4.q
            org.bouncycastle.crypto.Digest r4 = io.ktor.utils.io.jvm.javaio.q.j(r0)
            java.lang.Object r7 = r5.c
            byte[] r7 = (byte[]) r7
            java.lang.Object r10 = r5.d
            byte[] r10 = (byte[]) r10
            r3.<init>(r7, r10, r4)
            int r4 = r5.f1800a
            r3.d = r4
            r4 = -3
            r3.e = r4
            r3.a(r8, r1, r1)
            w3.n r3 = r0.f5084f
            int r0 = r0.b
            org.bouncycastle.crypto.Digest r7 = io.ktor.utils.io.jvm.javaio.q.f(r0, r3)
            java.lang.Object r0 = r5.c
            byte[] r0 = (byte[]) r0
            io.ktor.utils.io.internal.t.c(r0, r7)
            int r0 = r5.f1800a
            io.ktor.utils.io.internal.t.s(r0, r7)
            r0 = -32383(0xffffffffffff8181, float:NaN)
            io.ktor.utils.io.internal.t.r(r0, r7)
            r7.update(r8, r1, r2)
            w4.i r4 = new w4.i
            r4.<init>(r5, r6, r7, r8, r9)
            return r4
        L81:
            r0 = move-exception
            goto L8f
        L83:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L83
            throw r0     // Catch: java.lang.Throwable -> L81
        L86:
            com.google.android.gms.tasks.a r0 = new com.google.android.gms.tasks.a     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = "ots private key exhausted"
            r2 = 7
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L81
            throw r0     // Catch: java.lang.Throwable -> L81
        L8f:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L81
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l.generateLMSContext():w4.i");
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public final byte[] generateSignature(i iVar) {
        try {
            return Z.k(iVar).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        C0898p c0898p = new C0898p();
        c0898p.h(0);
        c0898p.h(this.c.f5101a);
        c0898p.h(this.d.f5083a);
        c0898p.b(this.b);
        c0898p.h(this.f5097j);
        c0898p.h(this.e);
        byte[] bArr = this.f5094f;
        c0898p.h(bArr.length);
        c0898p.b(bArr);
        return c0898p.f5068a.toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public final long getUsagesRemaining() {
        return this.e - d();
    }

    public final int hashCode() {
        int iK = (g5.c.k(this.b) + (this.f5097j * 31)) * 31;
        p pVar = this.c;
        int iHashCode = (iK + (pVar != null ? pVar.hashCode() : 0)) * 31;
        f fVar = this.d;
        return g5.c.k(this.f5094f) + ((((iHashCode + (fVar != null ? fVar.hashCode() : 0)) * 31) + this.e) * 31);
    }

    public l(p pVar, f fVar, int i, byte[] bArr, int i3, byte[] bArr2) {
        super(true);
        this.c = pVar;
        this.d = fVar;
        this.f5097j = i;
        this.b = g5.c.c(bArr);
        this.e = i3;
        this.f5094f = g5.c.c(bArr2);
        this.f5096h = 1 << (pVar.c + 1);
        this.f5095g = new WeakHashMap();
        this.i = io.ktor.utils.io.jvm.javaio.q.f(pVar.b, pVar.d);
    }
}
