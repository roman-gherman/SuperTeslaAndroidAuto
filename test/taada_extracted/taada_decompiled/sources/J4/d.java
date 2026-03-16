package J4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements XMSSOid {
    public static final Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f882a;
    public final String b;

    static {
        HashMap map = new HashMap();
        B2.b.p(1, "XMSSMT_SHA2_20/2_256", map, a("SHA-256", 32, 16, 67, 20, 2));
        B2.b.p(2, "XMSSMT_SHA2_20/4_256", map, a("SHA-256", 32, 16, 67, 20, 4));
        B2.b.p(3, "XMSSMT_SHA2_40/2_256", map, a("SHA-256", 32, 16, 67, 40, 2));
        B2.b.p(4, "XMSSMT_SHA2_40/4_256", map, a("SHA-256", 32, 16, 67, 40, 4));
        B2.b.p(5, "XMSSMT_SHA2_40/8_256", map, a("SHA-256", 32, 16, 67, 40, 8));
        B2.b.p(6, "XMSSMT_SHA2_60/3_256", map, a("SHA-256", 32, 16, 67, 60, 3));
        B2.b.p(7, "XMSSMT_SHA2_60/6_256", map, a("SHA-256", 32, 16, 67, 60, 6));
        B2.b.p(8, "XMSSMT_SHA2_60/12_256", map, a("SHA-256", 32, 16, 67, 60, 12));
        B2.b.p(9, "XMSSMT_SHA2_20/2_512", map, a("SHA-512", 64, 16, 131, 20, 2));
        B2.b.p(10, "XMSSMT_SHA2_20/4_512", map, a("SHA-512", 64, 16, 131, 20, 4));
        B2.b.p(11, "XMSSMT_SHA2_40/2_512", map, a("SHA-512", 64, 16, 131, 40, 2));
        B2.b.p(12, "XMSSMT_SHA2_40/4_512", map, a("SHA-512", 64, 16, 131, 40, 4));
        B2.b.p(13, "XMSSMT_SHA2_40/8_512", map, a("SHA-512", 64, 16, 131, 40, 8));
        B2.b.p(14, "XMSSMT_SHA2_60/3_512", map, a("SHA-512", 64, 16, 131, 60, 3));
        B2.b.p(15, "XMSSMT_SHA2_60/6_512", map, a("SHA-512", 64, 16, 131, 60, 6));
        B2.b.p(16, "XMSSMT_SHA2_60/12_512", map, a("SHA-512", 64, 16, 131, 60, 12));
        B2.b.p(17, "XMSSMT_SHAKE_20/2_256", map, a("SHAKE128", 32, 16, 67, 20, 2));
        B2.b.p(18, "XMSSMT_SHAKE_20/4_256", map, a("SHAKE128", 32, 16, 67, 20, 4));
        B2.b.p(19, "XMSSMT_SHAKE_40/2_256", map, a("SHAKE128", 32, 16, 67, 40, 2));
        B2.b.p(20, "XMSSMT_SHAKE_40/4_256", map, a("SHAKE128", 32, 16, 67, 40, 4));
        B2.b.p(21, "XMSSMT_SHAKE_40/8_256", map, a("SHAKE128", 32, 16, 67, 40, 8));
        B2.b.p(22, "XMSSMT_SHAKE_60/3_256", map, a("SHAKE128", 32, 16, 67, 60, 3));
        B2.b.p(23, "XMSSMT_SHAKE_60/6_256", map, a("SHAKE128", 32, 16, 67, 60, 6));
        B2.b.p(24, "XMSSMT_SHAKE_60/12_256", map, a("SHAKE128", 32, 16, 67, 60, 12));
        B2.b.p(25, "XMSSMT_SHAKE_20/2_512", map, a("SHAKE256", 64, 16, 131, 20, 2));
        B2.b.p(26, "XMSSMT_SHAKE_20/4_512", map, a("SHAKE256", 64, 16, 131, 20, 4));
        B2.b.p(27, "XMSSMT_SHAKE_40/2_512", map, a("SHAKE256", 64, 16, 131, 40, 2));
        B2.b.p(28, "XMSSMT_SHAKE_40/4_512", map, a("SHAKE256", 64, 16, 131, 40, 4));
        B2.b.p(29, "XMSSMT_SHAKE_40/8_512", map, a("SHAKE256", 64, 16, 131, 40, 8));
        B2.b.p(30, "XMSSMT_SHAKE_60/3_512", map, a("SHAKE256", 64, 16, 131, 60, 3));
        B2.b.p(31, "XMSSMT_SHAKE_60/6_512", map, a("SHAKE256", 64, 16, 131, 60, 6));
        map.put(a("SHAKE256", 64, 16, 131, 60, 12), new d(32, "XMSSMT_SHAKE_60/12_512"));
        c = Collections.unmodifiableMap(map);
    }

    public d(int i, String str) {
        this.f882a = i;
        this.b = str;
    }

    public static String a(String str, int i, int i3, int i4, int i5, int i6) {
        if (str == null) {
            throw new NullPointerException("algorithmName == null");
        }
        return str + "-" + i + "-" + i3 + "-" + i4 + "-" + i5 + "-" + i6;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final int getOid() {
        return this.f882a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final String toString() {
        return this.b;
    }
}
