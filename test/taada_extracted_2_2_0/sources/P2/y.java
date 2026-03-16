package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends n {
    public y(int i) {
        super(Integer.valueOf(i));
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        ClassDescriptor classDescriptorD = AbstractC0718j.d(module, k2.o.f3737T);
        F defaultType = classDescriptorD != null ? classDescriptorD.getDefaultType() : null;
        return defaultType == null ? c3.j.c(c3.i.NOT_FOUND_UNSIGNED_TYPE, "UInt") : defaultType;
    }

    @Override // P2.g
    public final String toString() {
        return ((Number) this.f1217a).intValue() + ".toUInt()";
    }
}
