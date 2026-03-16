package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends g {
    public final /* synthetic */ int b = 1;

    public /* synthetic */ c(Object obj) {
        super(obj);
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        switch (this.b) {
            case 0:
                kotlin.jvm.internal.h.f(module, "module");
                k2.i builtIns = module.getBuiltIns();
                builtIns.getClass();
                F fR = builtIns.r(k2.k.BOOLEAN);
                if (fR != null) {
                    return fR;
                }
                k2.i.a(63);
                throw null;
            case 1:
                kotlin.jvm.internal.h.f(module, "module");
                k2.i builtIns2 = module.getBuiltIns();
                builtIns2.getClass();
                F fR2 = builtIns2.r(k2.k.DOUBLE);
                if (fR2 != null) {
                    return fR2;
                }
                k2.i.a(61);
                throw null;
            default:
                kotlin.jvm.internal.h.f(module, "module");
                k2.i builtIns3 = module.getBuiltIns();
                builtIns3.getClass();
                F fR3 = builtIns3.r(k2.k.FLOAT);
                if (fR3 != null) {
                    return fR3;
                }
                k2.i.a(60);
                throw null;
        }
    }

    @Override // P2.g
    public String toString() {
        switch (this.b) {
            case 1:
                return ((Number) this.f1217a).doubleValue() + ".toDouble()";
            case 2:
                return ((Number) this.f1217a).floatValue() + ".toFloat()";
            default:
                return super.toString();
        }
    }

    public c(double d) {
        super(Double.valueOf(d));
    }

    public c(float f6) {
        super(Float.valueOf(f6));
    }
}
