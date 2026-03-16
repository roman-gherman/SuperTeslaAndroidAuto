package U0;

import B.g;
import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends V0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1311a;
    public final g b;
    public Y0.b c;
    public Y0.b d;

    public c(Context context, g gVar) {
        this.f1311a = context;
        this.b = gVar;
    }

    @Override // com.tenjin.android.params.base.ParamProvider
    public final Map apply(Map map) {
        if (!this.b.getBoolean("tenjinInstallReferrerSent", false)) {
            Y0.b bVar = this.c;
            if (bVar != null) {
                bVar.a(map);
            }
            Y0.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.a(map);
            }
        }
        return map;
    }
}
