package X2;

import G2.d0;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1442a;
    public final /* synthetic */ r b;
    public final /* synthetic */ AbstractC0612m c;
    public final /* synthetic */ a d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d0 f1443f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, r rVar, AbstractC0612m abstractC0612m, a aVar, int i, d0 d0Var) {
        super(0);
        this.f1442a = oVar;
        this.b = rVar;
        this.c = abstractC0612m;
        this.d = aVar;
        this.e = i;
        this.f1443f = d0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AnnotationAndConstantLoader annotationAndConstantLoader = this.f1442a.f1444a.f1433a.e;
        a aVar = this.d;
        return kotlin.collections.m.o0(annotationAndConstantLoader.loadValueParameterAnnotations(this.b, this.c, aVar, this.e, this.f1443f));
    }
}
