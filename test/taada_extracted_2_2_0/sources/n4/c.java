package N4;

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
import s4.C0814a;
import s4.C0815b;
import s4.C0816c;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Z4.a {
    public static final HashSet b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add(BCObjectIdentifiers.dilithium2);
        hashSet.add(BCObjectIdentifiers.dilithium3);
        hashSet.add(BCObjectIdentifiers.dilithium5);
        hashSet.add(BCObjectIdentifiers.dilithium2_aes);
        hashSet.add(BCObjectIdentifiers.dilithium3_aes);
        hashSet.add(BCObjectIdentifiers.dilithium5_aes);
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
        C0815b c0815b = (C0815b) k.t(aVar);
        aVar2.d = aVar.d;
        aVar2.f1171a = c0815b;
        aVar2.b = e.c(((C0814a) c0815b.b).b);
        return aVar2;
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PublicKey generatePublic(d dVar) {
        b bVar = new b();
        C0816c c0816c = (C0816c) I4.b.a(dVar);
        bVar.f1172a = c0816c;
        bVar.b = e.c(((C0814a) c0816c.b).b);
        return bVar;
    }
}
