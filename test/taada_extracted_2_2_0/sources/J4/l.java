package J4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements XMSSOid {
    public static final Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f893a;
    public final String b;

    static {
        HashMap map = new HashMap();
        map.put(a(32, 67, "SHA-256"), new l(16777217, "WOTSP_SHA2-256_W16"));
        map.put(a(64, 131, "SHA-512"), new l(33554434, "WOTSP_SHA2-512_W16"));
        map.put(a(32, 67, "SHAKE128"), new l(50331651, "WOTSP_SHAKE128_W16"));
        map.put(a(64, 131, "SHAKE256"), new l(67108868, "WOTSP_SHAKE256_W16"));
        c = Collections.unmodifiableMap(map);
    }

    public l(int i, String str) {
        this.f893a = i;
        this.b = str;
    }

    public static String a(int i, int i3, String str) {
        return str + "-" + i + "-16-" + i3;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final int getOid() {
        return this.f893a;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSOid
    public final String toString() {
        return this.b;
    }
}
