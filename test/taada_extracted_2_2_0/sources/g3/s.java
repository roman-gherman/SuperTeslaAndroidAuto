package g3;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f3321a = new s(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        FunctionDescriptor $receiver = (FunctionDescriptor) obj;
        kotlin.jvm.internal.h.f($receiver, "$this$$receiver");
        List<ValueParameterDescriptor> valueParameters = $receiver.getValueParameters();
        kotlin.jvm.internal.h.e(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) kotlin.collections.m.Y(valueParameters);
        boolean z6 = false;
        if (valueParameterDescriptor != null && !R2.e.a(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
            z6 = true;
        }
        List list = v.b;
        if (z6) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }
}
