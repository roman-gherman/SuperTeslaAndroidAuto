package g1;

import N1.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.i;
import m1.AbstractC0647p;
import m1.C0633b;
import m1.C0646o;
import m1.r;
import org.slf4j.Logger;
import r1.C0793a;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends i implements Function1 {
    public static final c b = new c(1, 0);
    public static final c c = new c(1, 1);
    public static final c d = new c(1, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3289a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i, int i3) {
        super(i);
        this.f3289a = i3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        m mVar = m.f1129a;
        switch (this.f3289a) {
            case 0:
                f install = (f) obj;
                kotlin.jvm.internal.h.f(install, "$this$install");
                Logger logger = AbstractC0647p.f4061a;
                install.e.f(q1.e.f4519j, new C0633b(3, null, 1));
                E1.h hVar = C0793a.f4683k;
                C0646o c0646o = new C0646o(3, null);
                C0793a c0793a = install.f3294f;
                c0793a.f(hVar, c0646o);
                c0793a.f(hVar, new r(3, null));
                break;
            case 1:
                kotlin.jvm.internal.h.f((j1.g) obj, "$this$null");
                break;
            default:
                kotlin.jvm.internal.h.f(obj, "$this$null");
                break;
        }
        return mVar;
    }
}
