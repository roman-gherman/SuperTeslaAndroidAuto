package P2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import n2.AbstractC0718j;
import n2.EnumC0711c;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends g {
    public final L2.b b;
    public final L2.f c;

    public i(L2.b bVar, L2.f fVar) {
        super(new N1.e(bVar, fVar));
        this.b = bVar;
        this.c = fVar;
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        L2.b bVar = this.b;
        ClassDescriptor classDescriptorD = AbstractC0718j.d(module, bVar);
        F defaultType = null;
        if (classDescriptorD != null) {
            if (!N2.f.n(classDescriptorD, EnumC0711c.c)) {
                classDescriptorD = null;
            }
            if (classDescriptorD != null) {
                defaultType = classDescriptorD.getDefaultType();
            }
        }
        if (defaultType != null) {
            return defaultType;
        }
        c3.i iVar = c3.i.ERROR_ENUM_TYPE;
        String string = bVar.toString();
        kotlin.jvm.internal.h.e(string, "enumClassId.toString()");
        String str = this.c.f962a;
        kotlin.jvm.internal.h.e(str, "enumEntryName.toString()");
        return c3.j.c(iVar, string, str);
    }

    @Override // P2.g
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.i());
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb.append(this.c);
        return sb.toString();
    }
}
