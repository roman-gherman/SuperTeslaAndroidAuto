package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends g {
    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        F fG = module.getBuiltIns().m().g(true);
        if (fG != null) {
            return fG;
        }
        k2.i.a(49);
        throw null;
    }
}
