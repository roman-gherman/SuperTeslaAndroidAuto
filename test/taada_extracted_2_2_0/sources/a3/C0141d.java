package a3;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$ForkPointContext;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: renamed from: a3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0141d extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1545a;
    public final /* synthetic */ Q b;
    public final /* synthetic */ ClassicTypeSystemContext c;
    public final /* synthetic */ SimpleTypeMarker d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0141d(ArrayList arrayList, Q q, ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        super(1);
        this.f1545a = arrayList;
        this.b = q;
        this.c = classicTypeSystemContext;
        this.d = simpleTypeMarker;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TypeCheckerState$ForkPointContext runForkingPoint = (TypeCheckerState$ForkPointContext) obj;
        kotlin.jvm.internal.h.f(runForkingPoint, "$this$runForkingPoint");
        Iterator it = this.f1545a.iterator();
        while (it.hasNext()) {
            runForkingPoint.fork(new C0140c(this.b, this.c, (SimpleTypeMarker) it.next(), this.d));
        }
        return N1.m.f1129a;
    }
}
