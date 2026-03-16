package N3;

import android.util.SparseArray;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.textfield.m;
import org.bouncycastle.crypto.CryptoServiceProperties;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements CryptoServiceProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1170a;
    public final int b;
    public final Object c;
    public final Object d;

    public h(int i, int i3, String str, L3.c cVar) {
        this.f1170a = i;
        this.b = i3;
        this.c = str;
        this.d = cVar;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public int bitsOfSecurity() {
        return ((L3.c) this.d) == L3.c.c ? this.b : this.f1170a;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public Object getParams() {
        return null;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public L3.c getPurpose() {
        return (L3.c) this.d;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        return (String) this.c;
    }

    public h(m mVar, TintTypedArray tintTypedArray) {
        this.c = new SparseArray();
        this.d = mVar;
        this.f1170a = tintTypedArray.getResourceId(26, 0);
        this.b = tintTypedArray.getResourceId(50, 0);
    }
}
