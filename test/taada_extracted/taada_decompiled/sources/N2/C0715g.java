package n2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: n2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0715g extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0715g f4243a = new C0715g(1);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return kotlin.jvm.internal.w.f3817a.b(L2.b.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        L2.b p02 = (L2.b) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return p02.f();
    }
}
