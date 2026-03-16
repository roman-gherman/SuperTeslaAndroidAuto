package q2;

import kotlin.jvm.functions.Function1;
import v2.EnumC0851b;

/* JADX INFO: renamed from: q2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0779p implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4604a;
    public final /* synthetic */ r b;

    public /* synthetic */ C0779p(r rVar, int i) {
        this.f4604a = i;
        this.b = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4604a) {
            case 0:
                L2.f fVar = (L2.f) obj;
                r rVar = this.b;
                if (fVar != null) {
                    return rVar.c(fVar, rVar.b().getContributedFunctions(fVar, EnumC0851b.f4934f));
                }
                rVar.getClass();
                r.a(8);
                throw null;
            default:
                L2.f fVar2 = (L2.f) obj;
                r rVar2 = this.b;
                if (fVar2 != null) {
                    return rVar2.c(fVar2, rVar2.b().getContributedVariables(fVar2, EnumC0851b.f4934f));
                }
                rVar2.getClass();
                r.a(4);
                throw null;
        }
    }
}
