package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends n {
    public d(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        k2.i builtIns = module.getBuiltIns();
        builtIns.getClass();
        F fR = builtIns.r(k2.k.BYTE);
        if (fR != null) {
            return fR;
        }
        k2.i.a(56);
        throw null;
    }

    @Override // P2.g
    public final String toString() {
        return ((Number) this.f1217a).intValue() + ".toByte()";
    }
}
