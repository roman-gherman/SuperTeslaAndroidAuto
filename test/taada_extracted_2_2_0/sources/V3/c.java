package V3;

import Y3.e;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Z4.a {
    public static final HashSet b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_512);
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_768);
        hashSet.add(NISTObjectIdentifiers.id_alg_ml_kem_1024);
    }

    public c() {
        super(b);
    }

    @Override // Z4.a, java.security.KeyFactorySpi
    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        z4.d dVar;
        if (!(keySpec instanceof Y3.d)) {
            return super.engineGeneratePrivate(keySpec);
        }
        Y3.d dVar2 = (Y3.d) keySpec;
        z4.c cVar = (z4.c) d.f1376a.get(dVar2.c.f1489a);
        byte[] bArr = dVar2.f1490a;
        boolean z6 = dVar2.d;
        if (z6) {
            if (!z6) {
                throw new IllegalStateException("KeySpec represents long form");
            }
            dVar = new z4.d(cVar, g5.c.c(bArr), null);
        } else {
            if (z6) {
                throw new IllegalStateException("KeySpec represents seed");
            }
            z4.d dVar3 = new z4.d(cVar, g5.c.c(bArr), null);
            if (z6) {
                throw new IllegalStateException("KeySpec represents long form");
            }
            byte[] bArrC = g5.c.c(dVar2.b);
            if (bArrC != null && !g5.c.g(bArrC, g5.c.e(dVar3.f5213f, dVar3.f5214g))) {
                throw new InvalidKeySpecException("public key data does not match private key data");
            }
            dVar = dVar3;
        }
        return new a(dVar);
    }

    @Override // Z4.a, java.security.KeyFactorySpi
    public final PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (!(keySpec instanceof e)) {
            return super.engineGeneratePublic(keySpec);
        }
        e eVar = (e) keySpec;
        return new b(new z4.e((z4.c) d.f1376a.get(eVar.f1491a.f1489a), g5.c.c(eVar.b)));
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof a) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(((a) key).getEncoded());
            }
            if (Y3.d.class.isAssignableFrom(cls)) {
                a aVar = (a) key;
                byte[] seed = aVar.getSeed();
                return seed != null ? new Y3.d(aVar.getParameterSpec(), seed) : new Y3.d(aVar.getParameterSpec(), aVar.f1374a.getEncoded(), ((b) aVar.getPublicKey()).f1375a.getEncoded());
            }
            if (e.class.isAssignableFrom(cls)) {
                a aVar2 = (a) key;
                return new e(aVar2.getParameterSpec(), ((b) aVar2.getPublicKey()).f1375a.getEncoded());
            }
        } else {
            if (!(key instanceof b)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(((b) key).getEncoded());
            }
            if (e.class.isAssignableFrom(cls)) {
                b bVar = (b) key;
                return new e(bVar.getParameterSpec(), bVar.f1375a.getEncoded());
            }
        }
        throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "unknown key specification: ", "."));
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof a) || (key instanceof b)) {
            return key;
        }
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PrivateKey generatePrivate(C3.a aVar) {
        a aVar2 = new a();
        aVar2.a(aVar);
        return aVar2;
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PublicKey generatePublic(H3.d dVar) {
        b bVar = new b();
        z4.e eVar = (z4.e) I4.b.a(dVar);
        bVar.f1375a = eVar;
        bVar.b = g5.e.c(Y3.c.a(((z4.c) eVar.b).f5212a).f1489a);
        return bVar;
    }
}
