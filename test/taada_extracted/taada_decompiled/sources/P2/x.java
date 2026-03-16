package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends n {
    public final /* synthetic */ int b = 0;

    public x(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        switch (this.b) {
            case 0:
                kotlin.jvm.internal.h.f(module, "module");
                ClassDescriptor classDescriptorD = AbstractC0718j.d(module, k2.o.R);
                F defaultType = classDescriptorD != null ? classDescriptorD.getDefaultType() : null;
                return defaultType == null ? c3.j.c(c3.i.NOT_FOUND_UNSIGNED_TYPE, "UByte") : defaultType;
            case 1:
                kotlin.jvm.internal.h.f(module, "module");
                ClassDescriptor classDescriptorD2 = AbstractC0718j.d(module, k2.o.U);
                F defaultType2 = classDescriptorD2 != null ? classDescriptorD2.getDefaultType() : null;
                return defaultType2 == null ? c3.j.c(c3.i.NOT_FOUND_UNSIGNED_TYPE, "ULong") : defaultType2;
            default:
                kotlin.jvm.internal.h.f(module, "module");
                ClassDescriptor classDescriptorD3 = AbstractC0718j.d(module, k2.o.S);
                F defaultType3 = classDescriptorD3 != null ? classDescriptorD3.getDefaultType() : null;
                return defaultType3 == null ? c3.j.c(c3.i.NOT_FOUND_UNSIGNED_TYPE, "UShort") : defaultType3;
        }
    }

    @Override // P2.g
    public final String toString() {
        switch (this.b) {
            case 0:
                return ((Number) this.f1217a).intValue() + ".toUByte()";
            case 1:
                return ((Number) this.f1217a).longValue() + ".toULong()";
            default:
                return ((Number) this.f1217a).intValue() + ".toUShort()";
        }
    }

    public x(short s3) {
        super(Short.valueOf(s3));
    }

    public x(long j6) {
        super(Long.valueOf(j6));
    }
}
