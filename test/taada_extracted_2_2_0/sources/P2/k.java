package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends n {
    public k(int i) {
        super(Integer.valueOf(i));
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        k2.i builtIns = module.getBuiltIns();
        builtIns.getClass();
        F fR = builtIns.r(k2.k.INT);
        if (fR != null) {
            return fR;
        }
        k2.i.a(58);
        throw null;
    }
}
