package J4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements XMSSOid {
    public static final Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f883a;
    public final String b;

    static {
        HashMap map = new HashMap();
        map.put(a("SHA-256", 32, 16, 67, 10), new e(1, "XMSS_SHA2_10_256"));
        map.put(a("SHA-256", 32, 16, 67, 16), new e(2, "XMSS_SHA2_16_256"));
        map.put(a("SHA-256", 32, 16, 67, 20), new e(3, "XMSS_SHA2_20_256"));
        map.put(a("SHA-512", 64, 16, 131, 10), new e(4, "XMSS_SHA2_10_512"));
        map.put(a("SHA-512", 64, 16, 131, 16), new e(5, "XMSS_SHA2_16_512"));
        map.put(a("SHA-512", 64, 16, 131, 20), new e(6, "XMSS_SHA2_20_512"));
        map.put(a("SHAKE128", 32, 16, 67, 10), new e(7, "XMSS_SHAKE_10_256"));
        map.put(a("SHAKE128", 32, 16, 67, 16), new e(8, "XMSS_SHAKE_16_256"));
        map.put(a("SHAKE128", 32, 16, 67, 20), new e(9, "XMSS_SHAKE_20_256"));
        map.put(a("SHAKE256", 64, 16, 131, 10), new e(10, "XMSS_SHAKE_10_512"));
        map.put(a("SHAKE256", 64, 16, 131, 16), new e(11, "XMSS_SHAKE_16_512"));
        map.put(a("SHAKE256", 64, 16, 131, 20), new e(12, "XMSS_SHAKE_20_512"));
        c = Collections.unmodifiableMap(map);
    }

    public e(int i, String str) {
        this.f883a = i;
        this.b = str;
    }

    public static String a(String str, int i, int i3, int i4, int i5) {
        return str + "-" + i + "-" + i3 + "-" + i4 + "-" + i5;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final int getOid() {
        return this.f883a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final String toString() {
        return this.b;
    }
}
