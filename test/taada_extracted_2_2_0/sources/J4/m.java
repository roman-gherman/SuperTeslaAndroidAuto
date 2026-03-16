package J4;

import java.util.Map;
import org.bouncycastle.crypto.ExtendedDigest;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f894a;
    public final int b;
    public final int c;
    public final C0896n d;

    public m(C0896n c0896n) {
        if (c0896n == null) {
            throw new NullPointerException("treeDigest == null");
        }
        this.d = c0896n;
        ExtendedDigest extendedDigestA = f.a(c0896n);
        String algorithmName = extendedDigestA.getAlgorithmName();
        int digestSize = algorithmName.equals("SHAKE128") ? 32 : algorithmName.equals("SHAKE256") ? 64 : extendedDigestA.getDigestSize();
        this.f894a = digestSize;
        int i = 16;
        this.b = 16;
        double d = digestSize * 8;
        int i3 = 0;
        int i4 = 16;
        int i5 = 0;
        while (true) {
            i4 >>= 1;
            if (i4 == 0) {
                break;
            } else {
                i5++;
            }
        }
        int iCeil = (int) Math.ceil(d / ((double) i5));
        int i6 = 15 * iCeil;
        int i7 = 0;
        while (true) {
            i6 >>= 1;
            if (i6 == 0) {
                break;
            } else {
                i7++;
            }
        }
        while (true) {
            i >>= 1;
            if (i == 0) {
                break;
            } else {
                i3++;
            }
        }
        int iFloor = ((int) Math.floor(i7 / i3)) + 1 + iCeil;
        this.c = iFloor;
        String algorithmName2 = extendedDigestA.getAlgorithmName();
        if (algorithmName2 == null) {
            Map map = l.c;
            throw new NullPointerException("algorithmName == null");
        }
        if (((l) l.c.get(l.a(digestSize, iFloor, algorithmName2))) != null) {
            return;
        }
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + extendedDigestA.getAlgorithmName());
    }
}
