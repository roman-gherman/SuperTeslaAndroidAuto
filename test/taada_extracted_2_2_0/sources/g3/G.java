package g3;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends o {
    public static final G d = new G("must have no value parameters", 0);
    public static final G e = new G("must have a single value parameter", 1);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G(String str, int i) {
        super(str, 1);
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                return functionDescriptor.getValueParameters().isEmpty();
            default:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                return functionDescriptor.getValueParameters().size() == 1;
        }
    }
}
