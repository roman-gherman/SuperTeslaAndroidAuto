package W4;

import E1.k;
import H3.d;
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

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Z4.a {
    public static final HashSet b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_esk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_24_5_5_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_25_8_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_ssk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_esk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_29_6_5_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_8_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_37_17_2_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_49_11_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_56_25_2_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_ssk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_esk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_60_10_4_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_ssk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_esk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_66_15_3_shake_esk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_ssk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_esk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_shake_ssk);
        hashSet.add(BCObjectIdentifiers.snova_75_33_2_shake_esk);
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
        aVar2.b = aVar.d;
        aVar2.f1400a = (G4.b) k.t(aVar);
        return aVar2;
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PublicKey generatePublic(d dVar) {
        b bVar = new b();
        bVar.f1401a = (G4.c) I4.b.a(dVar);
        return bVar;
    }
}
