package P2;

import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.K;
import a3.M;
import a3.c0;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends g {
    public r(L2.b bVar, int i) {
        super(new p(new f(bVar, i)));
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        AbstractC0162z abstractC0162zC;
        kotlin.jvm.internal.h.f(module, "module");
        M.b.getClass();
        M m6 = M.c;
        k2.i builtIns = module.getBuiltIns();
        builtIns.getClass();
        ClassDescriptor classDescriptorI = builtIns.i(k2.o.f3734P.g());
        Object obj = this.f1217a;
        q qVar = (q) obj;
        if (qVar instanceof o) {
            abstractC0162zC = ((o) obj).f1221a;
        } else {
            if (!(qVar instanceof p)) {
                throw new C0.x();
            }
            f fVar = ((p) obj).f1222a;
            L2.b bVar = fVar.f1216a;
            ClassDescriptor classDescriptorD = AbstractC0718j.d(module, bVar);
            int i = fVar.b;
            if (classDescriptorD == null) {
                c3.i iVar = c3.i.UNRESOLVED_KCLASS_CONSTANT_VALUE;
                String string = bVar.toString();
                kotlin.jvm.internal.h.e(string, "classId.toString()");
                abstractC0162zC = c3.j.c(iVar, string, String.valueOf(i));
            } else {
                F defaultType = classDescriptorD.getDefaultType();
                kotlin.jvm.internal.h.e(defaultType, "descriptor.defaultType");
                c0 c0VarW0 = AbstractC0246d.w0(defaultType);
                for (int i3 = 0; i3 < i; i3++) {
                    c0VarW0 = module.getBuiltIns().g(c0VarW0);
                }
                abstractC0162zC = c0VarW0;
            }
        }
        return C.b(m6, classDescriptorI, Z.p(new K(abstractC0162zC)));
    }
}
