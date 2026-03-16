package K4;

import java.security.AccessController;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Provider implements ConfigurableProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f945a = new HashMap();
    public static final String[] b = {"SPHINCS", "LMS", "NH", "XMSS", "SPHINCSPlus", "CMCE", "Frodo", "SABER", "Picnic", "NTRU", "Falcon", "Kyber", "Dilithium", "NTRUPrime", "BIKE", "HQC", "Rainbow", "Mayo", "Snova"};

    public c() {
        super("BCPQC", 1.81d, "BouncyCastle Post-Quantum Security Provider v1.81");
        AccessController.doPrivileged(new a(this));
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
        HashMap map = f945a;
        synchronized (map) {
            map.put(c0896n, asymmetricKeyInfoConverter);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final AsymmetricKeyInfoConverter getKeyInfoConverter(C0896n c0896n) {
        return (AsymmetricKeyInfoConverter) f945a.get(c0896n);
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
        throw null;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, String str2, Map map) {
        addAlgorithm(str, str2);
        addAttributes(str, map);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public final void addAlgorithm(String str, C0896n c0896n, String str2) {
        if (!containsKey(str + "." + str2)) {
            throw new IllegalStateException("primary key (" + str + "." + str2 + ") not found");
        }
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
