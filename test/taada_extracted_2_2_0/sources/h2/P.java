package h2;

import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0496A {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3378h;
    public final q0 c;
    public final q0 d;
    public final r0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r0 f3379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0 f3380g;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f3378h = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(P.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(P.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(P.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(P.class), "metadata", "getMetadata()Lkotlin/Triple;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(P.class), "members", "getMembers()Ljava/util/Collection;"))};
    }

    public P(S s3) {
        super(s3);
        this.c = s0.g(null, new M(s3, 0));
        this.d = s0.g(null, new O(this, 1));
        this.e = new r0(new N(this, s3));
        this.f3379f = new r0(new O(this, 0));
        this.f3380g = s0.g(null, new N(s3, this));
    }
}
