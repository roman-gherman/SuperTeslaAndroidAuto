package L4;

import E1.k;
import H3.d;
import J4.q;
import J4.r;
import J4.v;
import J4.w;
import a5.C0165a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import o4.g;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.crypto.sphincsplus.f;
import q4.C0790b;
import q4.C0791c;
import w3.AbstractC0899q;
import w4.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends KeyFactorySpi implements AsymmetricKeyInfoConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f988a;

    public /* synthetic */ c(int i) {
        this.f988a = i;
    }

    @Override // java.security.KeyFactorySpi
    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        switch (this.f988a) {
            case 0:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e) {
                        throw new InvalidKeySpecException(e.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 1:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e6) {
                        throw new InvalidKeySpecException(e6.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 2:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e7) {
                        throw new InvalidKeySpecException(e7.toString(), e7);
                    }
                }
                throw new InvalidKeySpecException("unsupported key specification: " + keySpec.getClass() + ".");
            case 3:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e8) {
                        throw new InvalidKeySpecException(e8.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 4:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e9) {
                        throw new InvalidKeySpecException(e9.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 5:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e10) {
                        throw new InvalidKeySpecException(e10.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 6:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e11) {
                        throw new InvalidKeySpecException(e11.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 7:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e12) {
                        throw new InvalidKeySpecException(e12.toString());
                    }
                }
                throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
            case 8:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e13) {
                        throw new InvalidKeySpecException(e13.toString());
                    }
                }
                throw new InvalidKeySpecException("unsupported key specification: " + keySpec.getClass() + ".");
            default:
                if (keySpec instanceof PKCS8EncodedKeySpec) {
                    try {
                        return generatePrivate(C3.a.b(AbstractC0899q.g(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
                    } catch (Exception e14) {
                        throw new InvalidKeySpecException(e14.toString());
                    }
                }
                throw new InvalidKeySpecException("unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    @Override // java.security.KeyFactorySpi
    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        switch (this.f988a) {
            case 0:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e) {
                        throw new InvalidKeySpecException(e.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 1:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e6) {
                        throw new InvalidKeySpecException(e6.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 2:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e7) {
                        throw new InvalidKeySpecException(e7.toString(), e7);
                    }
                }
                throw new InvalidKeySpecException("unknown key specification: " + keySpec + ".");
            case 3:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e8) {
                        throw new InvalidKeySpecException(e8.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 4:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e9) {
                        throw new InvalidKeySpecException(e9.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 5:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e10) {
                        throw new InvalidKeySpecException(e10.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 6:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e11) {
                        throw new InvalidKeySpecException(e11.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 7:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e12) {
                        throw new InvalidKeySpecException(e12.toString());
                    }
                }
                throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
            case 8:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e13) {
                        throw new InvalidKeySpecException(e13.toString());
                    }
                }
                throw new InvalidKeySpecException("unknown key specification: " + keySpec + ".");
            default:
                if (keySpec instanceof X509EncodedKeySpec) {
                    try {
                        return generatePublic(d.b(((X509EncodedKeySpec) keySpec).getEncoded()));
                    } catch (Exception e14) {
                        throw new InvalidKeySpecException(e14.toString());
                    }
                }
                throw new InvalidKeySpecException("unknown key specification: " + keySpec + ".");
        }
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        switch (this.f988a) {
            case 0:
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
            case 1:
                if (key instanceof M4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((M4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof M4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((M4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 2:
                if (key instanceof R4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((R4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof R4.b)) {
                        throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((R4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "unknown key specification: ", "."));
            case 3:
                if (key instanceof T4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((T4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof T4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((T4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 4:
                if (key instanceof U4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((U4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof U4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((U4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 5:
                if (key instanceof V4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((V4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof V4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((V4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 6:
                if (key instanceof X4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((X4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof X4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((X4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 7:
                if (key instanceof Y4.a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((Y4.a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof Y4.b)) {
                        throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((Y4.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "Unknown key specification: ", "."));
            case 8:
                if (key instanceof a5.c) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((a5.c) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof a5.d)) {
                        throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((a5.d) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "unknown key specification: ", "."));
            default:
                if (key instanceof C0165a) {
                    if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new PKCS8EncodedKeySpec(((C0165a) key).getEncoded());
                    }
                } else {
                    if (!(key instanceof a5.b)) {
                        throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + ".");
                    }
                    if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                        return new X509EncodedKeySpec(((a5.b) key).getEncoded());
                    }
                }
                throw new InvalidKeySpecException(androidx.constraintlayout.core.motion.a.k(cls, "unknown key specification: ", "."));
        }
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        switch (this.f988a) {
            case 0:
                if ((key instanceof a) || (key instanceof b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 1:
                if ((key instanceof M4.a) || (key instanceof M4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 2:
                if ((key instanceof R4.a) || (key instanceof R4.b)) {
                    return key;
                }
                throw new InvalidKeyException("unsupported key type");
            case 3:
                if ((key instanceof T4.a) || (key instanceof T4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 4:
                if ((key instanceof U4.a) || (key instanceof U4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 5:
                if ((key instanceof V4.a) || (key instanceof V4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 6:
                if ((key instanceof X4.a) || (key instanceof X4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 7:
                if ((key instanceof Y4.a) || (key instanceof Y4.b)) {
                    return key;
                }
                throw new InvalidKeyException("Unsupported key type");
            case 8:
                if ((key instanceof a5.c) || (key instanceof a5.d)) {
                    return key;
                }
                throw new InvalidKeyException("unsupported key type");
            default:
                if ((key instanceof C0165a) || (key instanceof a5.b)) {
                    return key;
                }
                throw new InvalidKeyException("unsupported key type");
        }
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PrivateKey generatePrivate(C3.a aVar) {
        switch (this.f988a) {
            case 0:
                a aVar2 = new a();
                aVar2.b = aVar.d;
                aVar2.f986a = (C0790b) k.t(aVar);
                return aVar2;
            case 1:
                M4.a aVar3 = new M4.a();
                aVar3.b = aVar.d;
                aVar3.f1115a = (r4.c) k.t(aVar);
                return aVar3;
            case 2:
                R4.a aVar4 = new R4.a();
                aVar4.b = aVar.d;
                aVar4.f1274a = (j) k.t(aVar);
                return aVar4;
            case 3:
                T4.a aVar5 = new T4.a();
                aVar5.b = aVar.d;
                aVar5.f1307a = (A4.a) k.t(aVar);
                return aVar5;
            case 4:
                U4.a aVar6 = new U4.a();
                aVar6.b = aVar.d;
                aVar6.f1345a = (B4.c) k.t(aVar);
                return aVar6;
            case 5:
                V4.a aVar7 = new V4.a();
                aVar7.b = aVar.d;
                aVar7.f1377a = (D4.b) k.t(aVar);
                return aVar7;
            case 6:
                X4.a aVar8 = new X4.a();
                aVar8.c = aVar.d;
                aVar8.f1460a = g.b(aVar.b.b).b.f747a;
                aVar8.b = (H4.b) k.t(aVar);
                return aVar8;
            case 7:
                Y4.a aVar9 = new Y4.a();
                aVar9.b = aVar.d;
                aVar9.f1492a = (f) k.t(aVar);
                return aVar9;
            case 8:
                a5.c cVar = new a5.c();
                cVar.c = aVar.d;
                cVar.b = o4.j.b(aVar.b.b).c.f747a;
                cVar.f1564a = (v) k.t(aVar);
                return cVar;
            default:
                C0165a c0165a = new C0165a();
                c0165a.c = aVar.d;
                c0165a.f1562a = o4.k.b(aVar.b.b).d.f747a;
                c0165a.b = (q) k.t(aVar);
                return c0165a;
        }
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public final PublicKey generatePublic(d dVar) {
        switch (this.f988a) {
            case 0:
                b bVar = new b();
                bVar.f987a = (C0791c) I4.b.a(dVar);
                return bVar;
            case 1:
                M4.b bVar2 = new M4.b();
                bVar2.f1116a = (r4.d) I4.b.a(dVar);
                return bVar2;
            case 2:
                R4.b bVar3 = new R4.b();
                bVar3.f1275a = (j) I4.b.a(dVar);
                return bVar3;
            case 3:
                T4.b bVar4 = new T4.b();
                bVar4.f1308a = (A4.b) I4.b.a(dVar);
                return bVar4;
            case 4:
                U4.b bVar5 = new U4.b();
                bVar5.f1346a = (B4.d) I4.b.a(dVar);
                return bVar5;
            case 5:
                V4.b bVar6 = new V4.b();
                bVar6.f1378a = (D4.c) I4.b.a(dVar);
                return bVar6;
            case 6:
                X4.b bVar7 = new X4.b();
                bVar7.f1461a = g.b(dVar.f748a.b).b.f747a;
                bVar7.b = (H4.c) I4.b.a(dVar);
                return bVar7;
            case 7:
                Y4.b bVar8 = new Y4.b();
                bVar8.f1493a = (org.bouncycastle.pqc.crypto.sphincsplus.g) I4.b.a(dVar);
                return bVar8;
            case 8:
                a5.d dVar2 = new a5.d();
                w wVar = (w) I4.b.a(dVar);
                dVar2.f1565a = wVar;
                dVar2.b = C5.f.E(wVar.b);
                return dVar2;
            default:
                a5.b bVar9 = new a5.b();
                r rVar = (r) I4.b.a(dVar);
                bVar9.b = rVar;
                bVar9.f1563a = C5.f.E(rVar.b);
                return bVar9;
        }
    }
}
