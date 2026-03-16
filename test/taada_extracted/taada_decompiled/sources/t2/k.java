package t2;

import java.lang.reflect.Member;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f4808a = new k(1);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return kotlin.jvm.internal.w.f3817a.b(Member.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Member p02 = (Member) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return Boolean.valueOf(p02.isSynthetic());
    }
}
