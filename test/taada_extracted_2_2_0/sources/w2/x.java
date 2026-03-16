package w2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class x extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f5025a = new x(1);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "getDefaultReportLevelForAnnotation";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return kotlin.jvm.internal.w.f3818a.c(v.class, "compiler.common.jvm");
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        L2.c p02 = (L2.c) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        L2.c cVar = v.f5023a;
        NullabilityAnnotationStates.Companion.getClass();
        B.h configuredReportLevels = F.b;
        N1.c cVar2 = new N1.c(7, 20);
        kotlin.jvm.internal.h.f(configuredReportLevels, "configuredReportLevels");
        G g6 = (G) configuredReportLevels.get(p02);
        if (g6 != null) {
            return g6;
        }
        w wVar = (w) v.c.get(p02);
        if (wVar == null) {
            return G.IGNORE;
        }
        N1.c cVar3 = wVar.b;
        return (cVar3 == null || cVar3.d - cVar2.d > 0) ? wVar.f5024a : wVar.c;
    }
}
