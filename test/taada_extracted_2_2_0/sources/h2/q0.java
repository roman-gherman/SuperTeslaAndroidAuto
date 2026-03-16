package h2;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends s0 implements Function0 {
    public final kotlin.jvm.internal.i b;
    public volatile SoftReference c;

    /* JADX WARN: Multi-variable type inference failed */
    public q0(CallableMemberDescriptor callableMemberDescriptor, Function0 function0) {
        if (function0 == 0) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
        }
        this.c = null;
        this.b = (kotlin.jvm.internal.i) function0;
        if (callableMemberDescriptor != null) {
            this.c = new SoftReference(callableMemberDescriptor);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj;
        SoftReference softReference = this.c;
        Object obj2 = s0.f3431a;
        if (softReference != null && (obj = softReference.get()) != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objInvoke = this.b.invoke();
        if (objInvoke != null) {
            obj2 = objInvoke;
        }
        this.c = new SoftReference(obj2);
        return objInvoke;
    }
}
