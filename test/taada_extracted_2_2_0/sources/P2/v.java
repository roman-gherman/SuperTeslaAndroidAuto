package P2;

import a3.AbstractC0162z;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String value) {
        super(value);
        kotlin.jvm.internal.h.f(value, "value");
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        return module.getBuiltIns().t();
    }

    @Override // P2.g
    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("\""), (String) this.f1217a, '\"');
    }
}
