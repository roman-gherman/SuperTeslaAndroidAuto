package B;

import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f108a;
    public final Feature b;

    public /* synthetic */ n(a aVar, Feature feature) {
        this.f108a = aVar;
        this.b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof n)) {
            n nVar = (n) obj;
            if (D.j.f(this.f108a, nVar.f108a) && D.j.f(this.b, nVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f108a, this.b});
    }

    public final String toString() {
        h hVar = new h(this, 4);
        hVar.a(this.f108a, "key");
        hVar.a(this.b, "feature");
        return hVar.toString();
    }
}
