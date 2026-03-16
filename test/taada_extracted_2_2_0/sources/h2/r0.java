package h2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends s0 {
    public final kotlin.jvm.internal.i b;
    public volatile Object c = null;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(Function0 function0) {
        this.b = (kotlin.jvm.internal.i) function0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    public final Object invoke() {
        Object obj = this.c;
        Object obj2 = s0.f3431a;
        if (obj != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objInvoke = this.b.invoke();
        if (objInvoke != null) {
            obj2 = objInvoke;
        }
        this.c = obj2;
        return objInvoke;
    }
}
