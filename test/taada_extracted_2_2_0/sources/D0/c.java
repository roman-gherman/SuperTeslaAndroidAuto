package D0;

import G0.C0038b;
import G0.C0056h;
import G0.C0068l;
import G0.C0094w0;
import G0.C0095x;
import G0.D;
import G0.EnumC0086s0;
import G0.J;
import G0.M1;
import G0.N;
import G0.S;
import G0.W;
import G0.t1;
import G0.x1;
import com.android.billingclient.api.A;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.C0406c;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.u;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import x0.C0911a;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f226a;
    public final /* synthetic */ int b;

    public c(Class cls, int i) {
        this.b = i;
        this.f226a = cls;
    }

    public final Object a(MessageLite messageLite) throws GeneralSecurityException {
        switch (this.b) {
            case 0:
                C0038b c0038b = (C0038b) messageLite;
                return new u(new com.google.crypto.tink.subtle.s(c0038b.getKeyValue().k()), c0038b.getParams().getTagSize());
            case 1:
                C0094w0 c0094w0 = (C0094w0) messageLite;
                EnumC0086s0 hash = c0094w0.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(c0094w0.getKeyValue().k(), "HMAC");
                int tagSize = c0094w0.getParams().getTagSize();
                int iOrdinal = hash.ordinal();
                if (iOrdinal == 1) {
                    return new u(new A("HMACSHA1", secretKeySpec), tagSize);
                }
                if (iOrdinal == 2) {
                    return new u(new A("HMACSHA384", secretKeySpec), tagSize);
                }
                if (iOrdinal == 3) {
                    return new u(new A("HMACSHA256", secretKeySpec), tagSize);
                }
                if (iOrdinal == 4) {
                    return new u(new A("HMACSHA512", secretKeySpec), tagSize);
                }
                if (iOrdinal == 5) {
                    return new u(new A("HMACSHA224", secretKeySpec), tagSize);
                }
                throw new GeneralSecurityException("unknown hash");
            case 2:
                C0068l c0068l = (C0068l) messageLite;
                return new C0406c(c0068l.getKeyValue().k(), E1.k.o0(c0068l.getParams().getHkdfHashType()), c0068l.getParams().getDerivedKeySize(), E1.k.o0(c0068l.getParams().getHmacParams().getHash()), c0068l.getParams().getHmacParams().getTagSize(), c0068l.getParams().getCiphertextSegmentSize());
            case 3:
                D d = (D) messageLite;
                return new com.google.crypto.tink.subtle.i(d.getParams().getDerivedKeySize(), d.getParams().getCiphertextSegmentSize(), E1.k.o0(d.getParams().getHkdfHashType()), d.getKeyValue().k());
            case 4:
                C0056h c0056h = (C0056h) messageLite;
                c[] cVarArr = {new c(IndCpaCipher.class, 5)};
                HashMap map = new HashMap();
                for (c cVar : cVarArr) {
                    boolean zContainsKey = map.containsKey(cVar.f226a);
                    Class cls = cVar.f226a;
                    if (zContainsKey) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                if (cVarArr.length > 0) {
                    Class cls2 = cVarArr[0].f226a;
                }
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                G0.r aesCtrKey = c0056h.getAesCtrKey();
                c cVar2 = (c) mapUnmodifiableMap.get(IndCpaCipher.class);
                if (cVar2 == null) {
                    throw new IllegalArgumentException("Requested primitive class " + IndCpaCipher.class.getCanonicalName() + " not supported.");
                }
                IndCpaCipher indCpaCipher = (IndCpaCipher) cVar2.a(aesCtrKey);
                c[] cVarArr2 = {new c(Mac.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar3 : cVarArr2) {
                    boolean zContainsKey2 = map2.containsKey(cVar3.f226a);
                    Class cls3 = cVar3.f226a;
                    if (zContainsKey2) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar3);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f226a;
                }
                Map mapUnmodifiableMap2 = Collections.unmodifiableMap(map2);
                C0094w0 hmacKey = c0056h.getHmacKey();
                c cVar4 = (c) mapUnmodifiableMap2.get(Mac.class);
                if (cVar4 != null) {
                    return new com.google.crypto.tink.subtle.n(indCpaCipher, (Mac) cVar4.a(hmacKey), c0056h.getHmacKey().getParams().getTagSize());
                }
                throw new IllegalArgumentException("Requested primitive class " + Mac.class.getCanonicalName() + " not supported.");
            case 5:
                G0.r rVar = (G0.r) messageLite;
                return new com.google.crypto.tink.subtle.e(rVar.getKeyValue().k(), rVar.getParams().getIvSize());
            case 6:
                C0095x c0095x = (C0095x) messageLite;
                return new com.google.crypto.tink.subtle.f(c0095x.getKeyValue().k(), c0095x.getParams().getIvSize());
            case 7:
                return new com.google.crypto.tink.subtle.j(((J) messageLite).getKeyValue().k(), 0);
            case 8:
                return new C0911a(((N) messageLite).getKeyValue().k());
            case 9:
                return new com.google.crypto.tink.subtle.j(((W) messageLite).getKeyValue().k(), 1);
            case 10:
                String keyUri = ((t1) messageLite).getParams().getKeyUri();
                return com.google.crypto.tink.h.a(keyUri).getAead(keyUri);
            case 11:
                x1 x1Var = (x1) messageLite;
                String kekUri = x1Var.getParams().getKekUri();
                return new v0.s(x1Var.getParams().getDekTemplate(), com.google.crypto.tink.h.a(kekUri).getAead(kekUri));
            case 12:
                return new com.google.crypto.tink.subtle.j(((M1) messageLite).getKeyValue().k(), 2);
            default:
                return new com.google.crypto.tink.subtle.k(((S) messageLite).getKeyValue().k());
        }
    }
}
