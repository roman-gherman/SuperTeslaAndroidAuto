package J4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.ExtendedDigest;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final Map e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f896a;
    public final t b;
    public final int c;
    public final int d;

    static {
        HashMap map = new HashMap();
        C0896n c0896n = NISTObjectIdentifiers.id_sha256;
        map.put(1, new o(20, 2, c0896n));
        B2.b.o(20, 4, c0896n, map, 2);
        B2.b.o(40, 2, c0896n, map, 3);
        B2.b.o(40, 4, c0896n, map, 4);
        B2.b.o(40, 8, c0896n, map, 5);
        B2.b.o(60, 3, c0896n, map, 6);
        B2.b.o(60, 6, c0896n, map, 7);
        B2.b.o(60, 12, c0896n, map, 8);
        C0896n c0896n2 = NISTObjectIdentifiers.id_sha512;
        map.put(9, new o(20, 2, c0896n2));
        B2.b.o(20, 4, c0896n2, map, 10);
        B2.b.o(40, 2, c0896n2, map, 11);
        B2.b.o(40, 4, c0896n2, map, 12);
        B2.b.o(40, 8, c0896n2, map, 13);
        B2.b.o(60, 3, c0896n2, map, 14);
        B2.b.o(60, 6, c0896n2, map, 15);
        B2.b.o(60, 12, c0896n2, map, 16);
        C0896n c0896n3 = NISTObjectIdentifiers.id_shake128;
        map.put(17, new o(20, 2, c0896n3));
        B2.b.o(20, 4, c0896n3, map, 18);
        map.put(19, new o(40, 2, c0896n3));
        B2.b.o(40, 4, c0896n3, map, 20);
        B2.b.o(40, 8, c0896n3, map, 21);
        B2.b.o(60, 3, c0896n3, map, 22);
        B2.b.o(60, 6, c0896n3, map, 23);
        B2.b.o(60, 12, c0896n3, map, 24);
        C0896n c0896n4 = NISTObjectIdentifiers.id_shake256;
        map.put(25, new o(20, 2, c0896n4));
        B2.b.o(20, 4, c0896n4, map, 26);
        B2.b.o(40, 2, c0896n4, map, 27);
        B2.b.o(40, 4, c0896n4, map, 28);
        B2.b.o(40, 8, c0896n4, map, 29);
        B2.b.o(60, 3, c0896n4, map, 30);
        B2.b.o(60, 6, c0896n4, map, 31);
        B2.b.o(60, 12, c0896n4, map, 32);
        e = Collections.unmodifiableMap(map);
    }

    public o(int i, int i3, ExtendedDigest extendedDigest) {
        this(i, i3, f.b(extendedDigest.getAlgorithmName()));
    }

    public o(int i, int i3, C0896n c0896n) {
        this.c = i;
        this.d = i3;
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i % i3 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i4 = i / i3;
        if (i4 == 1) {
            throw new IllegalArgumentException("height / layers must be greater than 1");
        }
        t tVar = new t(i4, c0896n);
        this.b = tVar;
        int i5 = tVar.f909h.c;
        String str = tVar.f907f;
        if (str != null) {
            this.f896a = (d) d.c.get(d.a(str, tVar.f908g, tVar.e, i5, i, i3));
        } else {
            Map map = d.c;
            throw new NullPointerException("algorithmName == null");
        }
    }
}
