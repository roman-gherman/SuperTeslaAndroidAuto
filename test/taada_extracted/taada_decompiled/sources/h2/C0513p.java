package h2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: renamed from: h2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0513p extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallableMemberDescriptor f3425a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0513p(CallableMemberDescriptor callableMemberDescriptor, int i) {
        super(0);
        this.f3425a = callableMemberDescriptor;
        this.b = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ValueParameterDescriptor valueParameterDescriptor = this.f3425a.getValueParameters().get(this.b);
        kotlin.jvm.internal.h.e(valueParameterDescriptor, "descriptor.valueParameters[i]");
        return valueParameterDescriptor;
    }
}
