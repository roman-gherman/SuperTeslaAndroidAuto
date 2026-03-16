package J4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.ExtendedDigest;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public static final Map i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f906a;
    public final int b;
    public final int c;
    public final C0896n d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f909h;

    static {
        HashMap map = new HashMap();
        C0896n c0896n = NISTObjectIdentifiers.id_sha256;
        map.put(1, new t(10, c0896n));
        map.put(2, new t(16, c0896n));
        map.put(3, new t(20, c0896n));
        C0896n c0896n2 = NISTObjectIdentifiers.id_sha512;
        map.put(4, new t(10, c0896n2));
        map.put(5, new t(16, c0896n2));
        map.put(6, new t(20, c0896n2));
        C0896n c0896n3 = NISTObjectIdentifiers.id_shake128;
        map.put(7, new t(10, c0896n3));
        map.put(8, new t(16, c0896n3));
        map.put(9, new t(20, c0896n3));
        C0896n c0896n4 = NISTObjectIdentifiers.id_shake256;
        map.put(10, new t(10, c0896n4));
        map.put(11, new t(16, c0896n4));
        map.put(12, new t(20, c0896n4));
        i = Collections.unmodifiableMap(map);
    }

    public t(int i3, ExtendedDigest extendedDigest) {
        this(i3, f.b(extendedDigest.getAlgorithmName()));
    }

    public t(int i3, C0896n c0896n) {
        if (i3 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        if (c0896n == null) {
            throw new NullPointerException("digest == null");
        }
        this.b = i3;
        int i4 = 2;
        while (true) {
            int i5 = this.b;
            if (i4 > i5) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i5 - i4) % 2 == 0) {
                this.c = i4;
                String str = (String) f.b.get(c0896n);
                if (str == null) {
                    throw new IllegalArgumentException("unrecognized digest oid: " + c0896n);
                }
                this.f907f = str;
                this.d = c0896n;
                m mVar = new m(c0896n);
                this.f909h = mVar;
                int i6 = mVar.f894a;
                this.f908g = i6;
                int i7 = mVar.b;
                this.e = i7;
                this.f906a = (e) e.c.get(e.a(str, i6, i7, mVar.c, i3));
                return;
            }
            i4++;
        }
    }
}
