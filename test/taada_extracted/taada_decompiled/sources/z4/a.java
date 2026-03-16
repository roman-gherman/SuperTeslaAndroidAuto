package Z4;

import H3.d;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends KeyFactorySpi implements AsymmetricKeyInfoConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f1521a;

    public a(HashSet hashSet) {
        this.f1521a = hashSet;
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            C3.a aVarB = C3.a.b(((PKCS8EncodedKeySpec) keySpec).getEncoded());
            C0896n c0896n = aVarB.b.f747a;
            if (this.f1521a.contains(c0896n)) {
                return generatePrivate(aVarB);
            }
            throw new InvalidKeySpecException("incorrect algorithm OID for key: " + c0896n);
        } catch (IllegalStateException e) {
            throw new InvalidKeySpecException(e.getMessage());
        } catch (InvalidKeySpecException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new InvalidKeySpecException(e7.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
        }
        try {
            d dVarB = d.b(((X509EncodedKeySpec) keySpec).getEncoded());
            C0896n c0896n = dVarB.f748a.f747a;
            if (this.f1521a.contains(c0896n)) {
                return generatePublic(dVarB);
            }
            throw new InvalidKeySpecException("incorrect algorithm OID for key: " + c0896n);
        } catch (InvalidKeySpecException e) {
            throw e;
        } catch (Exception e6) {
            throw new InvalidKeySpecException(e6.toString());
        }
    }
}
