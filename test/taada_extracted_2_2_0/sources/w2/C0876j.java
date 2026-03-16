package w2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: renamed from: w2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0876j extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0876j f5014a = new C0876j(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CallableMemberDescriptor it = (CallableMemberDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return Boolean.valueOf(io.ktor.utils.io.internal.t.l(it));
    }
}
