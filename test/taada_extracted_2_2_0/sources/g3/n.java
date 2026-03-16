package g3;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends o {
    public static final n d = new n("must be a member function", 0);
    public static final n e = new n("must be a member or an extension function", 1);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, int i) {
        super(str, 0);
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                return functionDescriptor.getDispatchReceiverParameter() != null;
            default:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                return (functionDescriptor.getDispatchReceiverParameter() == null && functionDescriptor.getExtensionReceiverParameter() == null) ? false : true;
        }
    }
}
