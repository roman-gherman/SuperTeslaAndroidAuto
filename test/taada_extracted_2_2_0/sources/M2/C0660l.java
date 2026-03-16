package m2;

import A2.C0019a;
import P2.v;
import a3.F;
import io.ktor.utils.io.Z;
import java.util.List;
import kotlin.collections.A;
import kotlin.collections.u;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import q2.C0763B;

/* JADX INFO: renamed from: m2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0660l extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4095a;
    public final /* synthetic */ C0661m b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0660l(C0661m c0661m, int i) {
        super(0);
        this.f4095a = i;
        this.b = c0661m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0661m c0661m = this.b;
        switch (this.f4095a) {
            case 0:
                F fE = c0661m.f4097a.d.e();
                kotlin.jvm.internal.h.e(fE, "moduleDescriptor.builtIns.anyType");
                return fE;
            default:
                C0763B c0763b = c0661m.f4097a;
                L2.f fVar = o2.d.f4288a;
                k2.i iVar = c0763b.d;
                kotlin.jvm.internal.h.f(iVar, "<this>");
                o2.h hVar = new o2.h(iVar, k2.o.f3755o, A.I(new N1.e(o2.d.d, new v((Object) "")), new N1.e(o2.d.e, new P2.b(u.f3805a, new C0019a(iVar, 26)))));
                o2.h hVar2 = new o2.h(iVar, k2.o.f3753m, A.I(new N1.e(o2.d.f4288a, new v((Object) "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version")), new N1.e(o2.d.b, new P2.a((Object) hVar)), new N1.e(o2.d.c, new P2.i(L2.b.j(k2.o.f3754n), L2.f.e("WARNING")))));
                o2.f fVar2 = Annotations.Companion;
                List listP = Z.p(hVar2);
                fVar2.getClass();
                return o2.f.a(listP);
        }
    }
}
