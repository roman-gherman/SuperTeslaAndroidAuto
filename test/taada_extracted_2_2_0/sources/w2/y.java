package w2;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final y d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f5026a;
    public final x b;
    public final boolean c;

    static {
        L2.c cVar = v.f5023a;
        N1.c configuredKotlinVersion = N1.c.e;
        kotlin.jvm.internal.h.f(configuredKotlinVersion, "configuredKotlinVersion");
        w wVar = v.d;
        N1.c cVar2 = wVar.b;
        G globalReportLevel = (cVar2 == null || cVar2.d - configuredKotlinVersion.d > 0) ? wVar.f5024a : wVar.c;
        kotlin.jvm.internal.h.f(globalReportLevel, "globalReportLevel");
        d = new y(new B(globalReportLevel, globalReportLevel == G.WARN ? null : globalReportLevel), x.f5025a);
    }

    public y(B b, x getReportLevelForAnnotation) {
        kotlin.jvm.internal.h.f(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f5026a = b;
        this.b = getReportLevelForAnnotation;
        this.c = b.d || getReportLevelForAnnotation.invoke(v.f5023a) == G.IGNORE;
    }

    public final String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f5026a + ", getReportLevelForAnnotation=" + this.b + ')';
    }
}
