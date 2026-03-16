package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g extends kotlin.jvm.internal.f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f3825a = new g(1, l.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Type p02 = (Type) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return l.c(p02);
    }
}
