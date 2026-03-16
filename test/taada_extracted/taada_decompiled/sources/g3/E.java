package g3;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends o {
    public final int c;

    /* JADX WARN: Illegal instructions before constructor call */
    public E(int i) {
        StringBuilder sbJ = B2.b.j(i, "must have at least ", " value parameter");
        sbJ.append(i > 1 ? "s" : "");
        super(sbJ.toString(), 1);
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        return functionDescriptor.getValueParameters().size() >= this.c;
    }
}
