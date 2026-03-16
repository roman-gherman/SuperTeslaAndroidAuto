package k1;

import N1.m;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.jvm.internal.i implements Function1 {
    public static final g b = new g(1, 0);
    public static final g c = new g(1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3698a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i, int i3) {
        super(i);
        this.f3698a = i3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3698a) {
            case 0:
                kotlin.jvm.internal.h.f((HttpURLConnection) obj, "$this$null");
                break;
            default:
                HttpsURLConnection it = (HttpsURLConnection) obj;
                kotlin.jvm.internal.h.f(it, "it");
                break;
        }
        return m.f1129a;
    }
}
