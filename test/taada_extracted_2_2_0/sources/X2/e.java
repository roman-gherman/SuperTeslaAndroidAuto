package X2;

import A2.C0019a;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final Set c = io.ktor.utils.io.internal.t.p(L2.b.j(k2.o.c.g()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1416a;
    public final MemoizedFunctionToNullable b;

    public e(g components) {
        kotlin.jvm.internal.h.f(components, "components");
        this.f1416a = components;
        this.b = components.f1418a.createMemoizedFunctionWithNullableValues(new C0019a(this, 10));
    }

    public final ClassDescriptor a(L2.b classId, c cVar) {
        kotlin.jvm.internal.h.f(classId, "classId");
        return (ClassDescriptor) this.b.invoke(new d(classId, cVar));
    }
}
