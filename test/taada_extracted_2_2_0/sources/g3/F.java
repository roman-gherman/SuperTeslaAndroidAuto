package g3;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends o {
    public final int c;

    public F(int i) {
        super(B2.b.d(i, "must have exactly ", " value parameters"), 1);
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        return functionDescriptor.getValueParameters().size() == this.c;
    }
}
