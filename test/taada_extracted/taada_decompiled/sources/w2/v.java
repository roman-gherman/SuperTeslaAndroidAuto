package w2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.c f5022a;
    public static final L2.c[] b;
    public static final B.h c;
    public static final w d;

    static {
        L2.c cVar = new L2.c("org.jspecify.nullness");
        L2.c cVar2 = new L2.c("org.jspecify.annotations");
        f5022a = cVar2;
        L2.c cVar3 = new L2.c("io.reactivex.rxjava3.annotations");
        L2.c cVar4 = new L2.c("org.checkerframework.checker.nullness.compatqual");
        String strB = cVar3.b();
        b = new L2.c[]{new L2.c(strB.concat(".Nullable")), new L2.c(strB.concat(".NonNull"))};
        L2.c cVar5 = new L2.c("org.jetbrains.annotations");
        w wVar = w.d;
        N1.e eVar = new N1.e(cVar5, wVar);
        N1.e eVar2 = new N1.e(new L2.c("androidx.annotation"), wVar);
        N1.e eVar3 = new N1.e(new L2.c("android.support.annotation"), wVar);
        N1.e eVar4 = new N1.e(new L2.c("android.annotation"), wVar);
        N1.e eVar5 = new N1.e(new L2.c("com.android.annotations"), wVar);
        N1.e eVar6 = new N1.e(new L2.c("org.eclipse.jdt.annotation"), wVar);
        N1.e eVar7 = new N1.e(new L2.c("org.checkerframework.checker.nullness.qual"), wVar);
        N1.e eVar8 = new N1.e(cVar4, wVar);
        N1.e eVar9 = new N1.e(new L2.c("javax.annotation"), wVar);
        N1.e eVar10 = new N1.e(new L2.c("edu.umd.cs.findbugs.annotations"), wVar);
        N1.e eVar11 = new N1.e(new L2.c("io.reactivex.annotations"), wVar);
        L2.c cVar6 = new L2.c("androidx.annotation.RecentlyNullable");
        G g6 = G.WARN;
        N1.e eVar12 = new N1.e(cVar6, new w(g6, 4));
        N1.e eVar13 = new N1.e(new L2.c("androidx.annotation.RecentlyNonNull"), new w(g6, 4));
        N1.e eVar14 = new N1.e(new L2.c("lombok"), wVar);
        N1.c cVar7 = new N1.c(9, 0);
        G g7 = G.STRICT;
        c = new B.h(kotlin.collections.A.I(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar12, eVar13, eVar14, new N1.e(cVar, new w(g6, cVar7, g7)), new N1.e(cVar2, new w(g6, new N1.c(9, 0), g7)), new N1.e(cVar3, new w(g6, new N1.c(8, 0), g7))));
        d = new w(g6, 4);
    }
}
