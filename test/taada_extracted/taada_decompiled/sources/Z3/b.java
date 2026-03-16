package Z3;

import com.android.billingclient.api.C0257h;
import org.bouncycastle.crypto.CryptoServiceProperties;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements CryptoServiceProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1505a;
    public String b;

    public b(String str, int i) {
        this.b = str;
        this.f1505a = i;
    }

    public C0257h a() {
        C0257h c0257h = new C0257h();
        c0257h.f1844a = this.f1505a;
        c0257h.b = this.b;
        return c0257h;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public int bitsOfSecurity() {
        return this.f1505a;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public Object getParams() {
        return null;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public L3.c getPurpose() {
        return L3.c.d;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        return this.b;
    }
}
