package Z3;

import M0.x;
import g5.e;
import io.ktor.utils.io.Z;
import java.security.AccessController;
import java.security.Provider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Provider implements ConfigurableProvider {
    public static final String b;
    public static final d c;
    public static final HashMap d;
    public static final Class e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f1506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CryptoServiceProperties[] f1508h;
    public static final String[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f1509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f1510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f1511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f1512m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1513a;

    static {
        Logger.getLogger(c.class.getName());
        b = "BouncyCastle Security Provider v1.81";
        d dVar = new d();
        dVar.f1519a = new ThreadLocal();
        dVar.b = new ThreadLocal();
        dVar.e = new HashSet();
        dVar.f1520f = new HashMap();
        c = dVar;
        d = new HashMap();
        e = Z.q("java.security.cert.PKIXRevocationChecker");
        f1506f = new String[]{"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
        f1507g = new String[]{"SipHash", "SipHash128", "Poly1305"};
        f1508h = new CryptoServiceProperties[]{new b("AES", 256), new b("ARC4", 20), new b("ARIA", 256), new b("Blowfish", 128), new b("Camellia", 256), new b("CAST5", 128), new b("CAST6", 256), new b("ChaCha", 128), new b("DES", 56), new b("DESede", 112), new b("GOST28147", 128), new b("Grainv1", 128), new b("Grain128", 128), new b("HC128", 128), new b("HC256", 256), new b("IDEA", 128), new b("Noekeon", 128), new b("RC2", 128), new b("RC5", 128), new b("RC6", 256), new b("Rijndael", 256), new b("Salsa20", 128), new b("SEED", 128), new b("Serpent", 256), new b("Shacal2", 128), new b("Skipjack", 80), new b("SM4", 128), new b("TEA", 128), new b("Twofish", 256), new b("Threefish", 128), new b("VMPC", 128), new b("VMPCKSA3", 128), new b("XTEA", 128), new b("XSalsa20", 128), new b("OpenSSLPBKDF", 128), new b("DSTU7624", 256), new b("GOST3412_2015", 256), new b("Zuc", 128)};
        i = new String[]{"X509", "IES", "COMPOSITE", "EXTERNAL", "CompositeSignatures", "NoSig"};
        f1509j = new String[]{"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC", "LMS", "SPHINCSPlus", "Dilithium", "Falcon", "NTRU", "CONTEXT", "SLHDSA", "MLDSA", "MLKEM"};
        f1510k = new String[]{"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka", "Blake3"};
        f1511l = new String[]{"BC", "BCFKS", "PKCS12"};
        f1512m = new String[]{"DRBG"};
    }

    public c() {
        super("BC", 1.81d, b);
        this.f1513a = new ConcurrentHashMap();
        AccessController.doPrivileged(new x(this, 1));
    }

    public static void c(String str, String[] strArr) {
        for (int i3 = 0; i3 != strArr.length; i3++) {
            d(str, strArr[i3]);
        }
    }

    public static void d(String str, String str2) {
        Class clsQ = Z.q(str + str2 + "$Mappings");
        if (clsQ == null) {
            return;
        }
        try {
            if (clsQ.newInstance() != null) {
                throw new ClassCastException();
            }
            throw null;
        } catch (Exception e6) {
            throw new InternalError("cannot create instance of " + str + str2 + "$Mappings : " + e6);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, String str2) {
        if (containsKey(str)) {
            throw new IllegalStateException(androidx.constraintlayout.core.motion.a.q("duplicate provider key (", str, ") found"));
        }
        put(str, str2);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAttributes(String str, Map map) {
        put(str + " ImplementedIn", "Software");
        for (String str2 : map.keySet()) {
            String strF = B2.b.f(str, " ", str2);
            if (containsKey(strF)) {
                throw new IllegalStateException(androidx.constraintlayout.core.motion.a.q("duplicate provider attribute key (", strF, ") found"));
            }
            put(strF, map.get(str2));
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addKeyInfoConverter(C0896n c0896n, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        HashMap map = d;
        synchronized (map) {
            map.put(c0896n, asymmetricKeyInfoConverter);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final AsymmetricKeyInfoConverter getKeyInfoConverter(C0896n c0896n) {
        return (AsymmetricKeyInfoConverter) d.get(c0896n);
    }

    @Override // java.security.Provider
    public final Provider.Service getService(String str, String str2) {
        Provider.Service service;
        String strF = B2.b.f(str, ".", e.c(str2));
        Provider.Service service2 = (Provider.Service) this.f1513a.get(strF);
        if (service2 != null) {
            return service2;
        }
        synchronized (this) {
            try {
                service = (Provider.Service) (!this.f1513a.containsKey(strF) ? AccessController.doPrivileged(new a(this, str, str2, strF)) : this.f1513a.get(strF));
            } catch (Throwable th) {
                throw th;
            }
        }
        return service;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final boolean hasAlgorithm(String str, String str2) {
        if (containsKey(str + "." + str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("Alg.Alias.");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        return containsKey(sb.toString());
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void setParameter(String str, Object obj) {
        d dVar = c;
        synchronized (dVar) {
            dVar.a(str, obj);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, String str2, Map map) {
        addAlgorithm(str, str2);
        addAttributes(str, map);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, C0896n c0896n, String str2) {
        addAlgorithm(str + "." + c0896n, str2);
        addAlgorithm(str + ".OID." + c0896n, str2);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, C0896n c0896n, String str2, Map map) {
        addAlgorithm(str, c0896n, str2);
        addAttributes(str + "." + c0896n, map);
        addAttributes(str + ".OID." + c0896n, map);
    }
}
