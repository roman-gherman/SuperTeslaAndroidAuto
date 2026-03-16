package A2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;

/* JADX INFO: renamed from: A2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0030l extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0030l f52a = new C0030l(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JavaMember it = (JavaMember) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return Boolean.valueOf(!it.isStatic());
    }
}
