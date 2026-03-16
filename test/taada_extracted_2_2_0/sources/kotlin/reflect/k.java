package kotlin.reflect;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k extends kotlin.jvm.internal.f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3941a = new k(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Class p02 = (Class) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return p02.getComponentType();
    }
}
