package M;

import B.g;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f989a;

    static {
        a aVar = new a();
        aVar.f989a = null;
        b = aVar;
    }

    public static g a(Context context) {
        g gVar;
        a aVar = b;
        synchronized (aVar) {
            try {
                if (aVar.f989a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    aVar.f989a = new g(context, 9);
                }
                gVar = aVar.f989a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }
}
