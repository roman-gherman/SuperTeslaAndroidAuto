package a3;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$ForkPointContext;

/* JADX INFO: loaded from: classes2.dex */
public final class N implements TypeCheckerState$ForkPointContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1534a;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$ForkPointContext
    public final void fork(Function0 block) {
        kotlin.jvm.internal.h.f(block, "block");
        if (this.f1534a) {
            return;
        }
        this.f1534a = ((Boolean) block.invoke()).booleanValue();
    }
}
