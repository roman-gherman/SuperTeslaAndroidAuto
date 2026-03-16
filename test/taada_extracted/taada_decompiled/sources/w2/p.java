package w2;

import c4.AbstractC0246d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public final N2.g getContract() {
        return N2.g.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public final N2.h isOverridable(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.h.f(subDescriptor, "subDescriptor");
        boolean z6 = subDescriptor instanceof PropertyDescriptor;
        N2.h hVar = N2.h.c;
        if (!z6 || !(superDescriptor instanceof PropertyDescriptor)) {
            return hVar;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) subDescriptor;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) superDescriptor;
        return !kotlin.jvm.internal.h.a(propertyDescriptor.getName(), propertyDescriptor2.getName()) ? hVar : (AbstractC0246d.Y(propertyDescriptor) && AbstractC0246d.Y(propertyDescriptor2)) ? N2.h.f1137a : (AbstractC0246d.Y(propertyDescriptor) || AbstractC0246d.Y(propertyDescriptor2)) ? N2.h.b : hVar;
    }
}
