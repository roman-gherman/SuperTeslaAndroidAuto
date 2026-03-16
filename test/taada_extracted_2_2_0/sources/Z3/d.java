package Z3;

import L3.f;
import L3.h;
import a4.C0163a;
import c4.AbstractC0246d;
import java.security.spec.DSAParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ProviderConfiguration {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final X3.a f1514g = new X3.a(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final X3.a f1515h = new X3.a(ConfigurableProvider.EC_IMPLICITLY_CA);
    public static final X3.a i = new X3.a(ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final X3.a f1516j = new X3.a(ConfigurableProvider.DH_DEFAULT_PARAMS);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final X3.a f1517k = new X3.a(ConfigurableProvider.ACCEPTABLE_EC_CURVES);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final X3.a f1518l = new X3.a(ConfigurableProvider.ADDITIONAL_EC_PARAMETERS);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadLocal f1519a;
    public ThreadLocal b;
    public volatile C0163a c;
    public volatile Object d;
    public volatile Set e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Map f1520f;

    public final void a(String str, Object obj) {
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(f1514g);
            }
            C0163a c0163aR = ((obj instanceof C0163a) || obj == null) ? (C0163a) obj : AbstractC0246d.r((ECParameterSpec) obj);
            if (c0163aR == null) {
                this.f1519a.remove();
                return;
            } else {
                this.f1519a.set(c0163aR);
                return;
            }
        }
        if (str.equals(ConfigurableProvider.EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(f1515h);
            }
            if ((obj instanceof C0163a) || obj == null) {
                this.c = (C0163a) obj;
                return;
            } else {
                this.c = AbstractC0246d.r((ECParameterSpec) obj);
                return;
            }
        }
        if (str.equals(ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(i);
            }
            if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            ThreadLocal threadLocal = this.b;
            if (obj == null) {
                threadLocal.remove();
                return;
            } else {
                threadLocal.set(obj);
                return;
            }
        }
        if (str.equals(ConfigurableProvider.DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(f1516j);
            }
            if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
            }
            this.d = obj;
            return;
        }
        if (str.equals(ConfigurableProvider.ACCEPTABLE_EC_CURVES)) {
            if (securityManager != null) {
                securityManager.checkPermission(f1517k);
            }
            this.e = (Set) obj;
        } else if (str.equals(ConfigurableProvider.ADDITIONAL_EC_PARAMETERS)) {
            if (securityManager != null) {
                securityManager.checkPermission(f1518l);
            }
            this.f1520f = (Map) obj;
        }
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public final Set getAcceptableNamedCurves() {
        return Collections.unmodifiableSet(this.e);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public final Map getAdditionalECParameters() {
        return Collections.unmodifiableMap(this.f1520f);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public final DHParameterSpec getDHDefaultParameters(int i3) {
        Object obj = this.b.get();
        if (obj == null) {
            obj = this.d;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i3) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i4 = 0; i4 != dHParameterSpecArr.length; i4++) {
                if (dHParameterSpecArr[i4].getP().bitLength() == i3) {
                    return dHParameterSpecArr[i4];
                }
            }
        }
        Q3.b bVar = (Q3.b) h.b(f.c, i3);
        if (bVar != null) {
            return new Y3.a(bVar.b, bVar.f1236a, 0);
        }
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public final DSAParameterSpec getDSADefaultParameters(int i3) {
        Q3.c cVar = (Q3.c) h.b(f.d, i3);
        if (cVar != null) {
            return new DSAParameterSpec(cVar.c, cVar.b, cVar.f1237a);
        }
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public final C0163a getEcImplicitlyCa() {
        C0163a c0163a = (C0163a) this.f1519a.get();
        return c0163a != null ? c0163a : this.c;
    }
}
