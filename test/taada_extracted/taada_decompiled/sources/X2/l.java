package X2;

import G2.H;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1440a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ H c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(o oVar, boolean z6, H h3) {
        super(0);
        this.f1440a = oVar;
        this.b = z6;
        this.c = h3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        List listO0;
        o oVar = this.f1440a;
        r rVarA = oVar.a(oVar.f1444a.c);
        if (rVarA != null) {
            i iVar = oVar.f1444a;
            boolean z6 = this.b;
            H h3 = this.c;
            listO0 = z6 ? kotlin.collections.m.o0(iVar.f1433a.e.loadPropertyDelegateFieldAnnotations(rVarA, h3)) : kotlin.collections.m.o0(iVar.f1433a.e.loadPropertyBackingFieldAnnotations(rVarA, h3));
        } else {
            listO0 = null;
        }
        return listO0 == null ? kotlin.collections.u.f3804a : listO0;
    }
}
