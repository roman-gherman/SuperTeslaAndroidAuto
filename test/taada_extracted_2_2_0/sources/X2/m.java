package X2;

import G2.H;
import a3.AbstractC0162z;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1441a;
    public final /* synthetic */ o b;
    public final /* synthetic */ H c;
    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(o oVar, H h3, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar, int i) {
        super(0);
        this.f1441a = i;
        this.b = oVar;
        this.c = h3;
        this.d = nVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f1441a) {
            case 0:
                o oVar = this.b;
                r rVarA = oVar.a(oVar.f1444a.c);
                kotlin.jvm.internal.h.c(rVarA);
                AnnotationAndConstantLoader annotationAndConstantLoader = oVar.f1444a.f1433a.e;
                AbstractC0162z returnType = this.d.getReturnType();
                kotlin.jvm.internal.h.e(returnType, "property.returnType");
                return (P2.g) annotationAndConstantLoader.loadPropertyConstant(rVarA, this.c, returnType);
            case 1:
                o oVar2 = this.b;
                return oVar2.f1444a.f1433a.f1418a.createNullableLazyValue(new m(oVar2, this.c, this.d, 0));
            case 2:
                o oVar3 = this.b;
                r rVarA2 = oVar3.a(oVar3.f1444a.c);
                kotlin.jvm.internal.h.c(rVarA2);
                AnnotationAndConstantLoader annotationAndConstantLoader2 = oVar3.f1444a.f1433a.e;
                AbstractC0162z returnType2 = this.d.getReturnType();
                kotlin.jvm.internal.h.e(returnType2, "property.returnType");
                return (P2.g) annotationAndConstantLoader2.loadAnnotationDefaultValue(rVarA2, this.c, returnType2);
            default:
                o oVar4 = this.b;
                return oVar4.f1444a.f1433a.f1418a.createNullableLazyValue(new m(oVar4, this.c, this.d, 2));
        }
    }
}
