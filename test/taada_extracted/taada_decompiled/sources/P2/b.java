package P2;

import a3.AbstractC0162z;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public class b extends g {
    public final kotlin.jvm.internal.i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List list, Function1 computeType) {
        super(list);
        kotlin.jvm.internal.h.f(computeType, "computeType");
        this.b = (kotlin.jvm.internal.i) computeType;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        AbstractC0162z abstractC0162z = (AbstractC0162z) this.b.invoke(module);
        if (!k2.i.x(abstractC0162z) && !k2.i.E(abstractC0162z) && !k2.i.A(abstractC0162z, k2.o.f3737V.i()) && !k2.i.A(abstractC0162z, k2.o.f3738W.i()) && !k2.i.A(abstractC0162z, k2.o.f3739X.i())) {
            k2.i.A(abstractC0162z, k2.o.f3740Y.i());
        }
        return abstractC0162z;
    }
}
