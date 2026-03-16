package O4;

import E1.k;
import H3.d;
import g5.e;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import t4.C0829a;
import t4.C0830b;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Z4.a {
    public static final HashSet b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add(BCObjectIdentifiers.falcon_512);
        hashSet.add(BCObjectIdentifiers.falcon_1024);
    }

    public c() {
        super(b);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof a) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(((a) key).getEncoded());
            }
        } else {
            if (!(key instanceof b)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(((b) key).getEncoded());
            }
        }
        throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof a) || (key instanceof b)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PrivateKey generatePrivate(C3.a aVar) {
        a aVar2 = new a();
        C0830b c0830b = (C0830b) k.t(aVar);
        aVar2.d = aVar.d;
        aVar2.f1192a = c0830b;
        aVar2.b = e.c(((C0829a) c0830b.b).f4842a);
        return aVar2;
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PublicKey generatePublic(d dVar) {
        b bVar = new b();
        t4.c cVar = (t4.c) I4.b.a(dVar);
        bVar.f1193a = cVar;
        bVar.b = e.c(((C0829a) cVar.b).f4842a);
        return bVar;
    }
}
