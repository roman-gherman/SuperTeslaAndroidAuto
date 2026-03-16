package A2;

import a3.AbstractC0162z;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O extends G {
    @Override // A2.G
    public void g(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
    }

    @Override // A2.G
    public final ReceiverParameterDescriptor i() {
        return null;
    }

    @Override // A2.G
    public final A l(JavaMethod method, ArrayList arrayList, AbstractC0162z abstractC0162z, List list) {
        kotlin.jvm.internal.h.f(method, "method");
        return new A(abstractC0162z, null, list, arrayList, kotlin.collections.u.f3804a);
    }
}
