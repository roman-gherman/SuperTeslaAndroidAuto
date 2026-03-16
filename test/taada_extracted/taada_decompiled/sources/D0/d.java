package D0;

import G0.C0035a;
import G0.C0038b;
import G0.C0041c;
import G0.C0044d;
import G0.C0047e;
import G0.C0050f;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.v;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends C0.d {
    @Override // C0.d
    public final MessageLite b(MessageLite messageLite) {
        C0044d c0044d = (C0044d) messageLite;
        C0035a c0035aW = C0038b.w();
        c0035aW.p();
        C0038b.t((C0038b) c0035aW.b);
        byte[] bArrA = v.a(c0044d.getKeySize());
        C0379n c0379nC = AbstractC0381o.c(bArrA, 0, bArrA.length);
        c0035aW.p();
        C0038b.u((C0038b) c0035aW.b, c0379nC);
        C0050f params = c0044d.getParams();
        c0035aW.p();
        C0038b.v((C0038b) c0035aW.b, params);
        return (C0038b) c0035aW.build();
    }

    @Override // C0.d
    public final Map h() {
        HashMap map = new HashMap();
        C0041c c0041cV = C0044d.v();
        c0041cV.p();
        C0044d.t((C0044d) c0041cV.b, 32);
        C0047e c0047eV = C0050f.v();
        c0047eV.p();
        C0050f.t((C0050f) c0047eV.b, 16);
        C0050f c0050f = (C0050f) c0047eV.build();
        c0041cV.p();
        C0044d.u((C0044d) c0041cV.b, c0050f);
        map.put("AES_CMAC", new C0.c((C0044d) c0041cV.build(), 1));
        C0041c c0041cV2 = C0044d.v();
        c0041cV2.p();
        C0044d.t((C0044d) c0041cV2.b, 32);
        C0047e c0047eV2 = C0050f.v();
        c0047eV2.p();
        C0050f.t((C0050f) c0047eV2.b, 16);
        C0050f c0050f2 = (C0050f) c0047eV2.build();
        c0041cV2.p();
        C0044d.u((C0044d) c0041cV2.b, c0050f2);
        map.put("AES256_CMAC", new C0.c((C0044d) c0041cV2.build(), 1));
        C0041c c0041cV3 = C0044d.v();
        c0041cV3.p();
        C0044d.t((C0044d) c0041cV3.b, 32);
        C0047e c0047eV3 = C0050f.v();
        c0047eV3.p();
        C0050f.t((C0050f) c0047eV3.b, 16);
        C0050f c0050f3 = (C0050f) c0047eV3.build();
        c0041cV3.p();
        C0044d.u((C0044d) c0041cV3.b, c0050f3);
        map.put("AES256_CMAC_RAW", new C0.c((C0044d) c0041cV3.build(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // C0.d
    public final MessageLite i(AbstractC0381o abstractC0381o) {
        return C0044d.w(abstractC0381o, D.a());
    }

    @Override // C0.d
    public final void k(MessageLite messageLite) throws GeneralSecurityException {
        C0044d c0044d = (C0044d) messageLite;
        e.i(c0044d.getParams());
        if (c0044d.getKeySize() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
