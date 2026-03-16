package P3;

import Q3.e;
import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Mac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1223a;
    public final int b;
    public final int c;
    public Memoable d;
    public Memoable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f1224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f1225g;

    static {
        Hashtable hashtable = new Hashtable();
        hashtable.put("GOST3411", 32);
        hashtable.put("MD2", 16);
        hashtable.put("MD4", 64);
        hashtable.put("MD5", 64);
        hashtable.put("RIPEMD128", 64);
        hashtable.put("RIPEMD160", 64);
        hashtable.put("SHA-1", 64);
        hashtable.put("SHA-224", 64);
        hashtable.put("SHA-256", 64);
        hashtable.put("SHA-384", 128);
        hashtable.put("SHA-512", 128);
        hashtable.put("Tiger", 64);
        hashtable.put("Whirlpool", 64);
    }

    public a(Digest digest) {
        int byteLength = ((ExtendedDigest) digest).getByteLength();
        this.f1223a = digest;
        int digestSize = digest.getDigestSize();
        this.b = digestSize;
        this.c = byteLength;
        this.f1224f = new byte[byteLength];
        this.f1225g = new byte[byteLength + digestSize];
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final int doFinal(byte[] bArr, int i) {
        ?? r02 = this.f1223a;
        byte[] bArr2 = this.f1225g;
        int i3 = this.c;
        r02.doFinal(bArr2, i3);
        Memoable memoable = this.e;
        if (memoable != null) {
            ((Memoable) r02).reset(memoable);
            r02.update(bArr2, i3, r02.getDigestSize());
        } else {
            r02.update(bArr2, 0, bArr2.length);
        }
        int iDoFinal = r02.doFinal(bArr, i);
        while (i3 < bArr2.length) {
            bArr2[i3] = 0;
            i3++;
        }
        Memoable memoable2 = this.d;
        if (memoable2 != null) {
            ((Memoable) r02).reset(memoable2);
            return iDoFinal;
        }
        byte[] bArr3 = this.f1224f;
        r02.update(bArr3, 0, bArr3.length);
        return iDoFinal;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final String getAlgorithmName() {
        return this.f1223a.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public final int getMacSize() {
        return this.b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final void init(CipherParameters cipherParameters) {
        ?? r02 = this.f1223a;
        r02.reset();
        byte[] bArr = ((e) cipherParameters).f1239a;
        int length = bArr.length;
        byte[] bArr2 = this.f1224f;
        int i = this.c;
        if (length > i) {
            r02.update(bArr, 0, length);
            r02.doFinal(bArr2, 0);
            length = this.b;
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, length);
        }
        while (length < bArr2.length) {
            bArr2[length] = 0;
            length++;
        }
        byte[] bArr3 = this.f1225g;
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) (bArr2[i3] ^ 54);
        }
        for (int i4 = 0; i4 < i; i4++) {
            bArr3[i4] = (byte) (bArr3[i4] ^ 92);
        }
        Memoable memoableCopy = ((Memoable) r02).copy();
        this.e = memoableCopy;
        ((Digest) memoableCopy).update(bArr3, 0, i);
        r02.update(bArr2, 0, bArr2.length);
        this.d = ((Memoable) r02).copy();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final void reset() {
        Memoable memoable = this.d;
        ?? r12 = this.f1223a;
        if (memoable != null) {
            ((Memoable) r12).reset(memoable);
            return;
        }
        r12.reset();
        byte[] bArr = this.f1224f;
        r12.update(bArr, 0, bArr.length);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final void update(byte b) {
        this.f1223a.update(b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    @Override // org.bouncycastle.crypto.Mac
    public final void update(byte[] bArr, int i, int i3) {
        this.f1223a.update(bArr, i, i3);
    }
}
