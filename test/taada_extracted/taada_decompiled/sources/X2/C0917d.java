package x2;

import a3.AbstractC0162z;
import k2.o;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: renamed from: x2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0917d extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0917d f5113a = new C0917d(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ModuleDescriptor module = (ModuleDescriptor) obj;
        kotlin.jvm.internal.h.f(module, "module");
        ValueParameterDescriptor valueParameterDescriptorI = k1.j.i(AbstractC0916c.b, module.getBuiltIns().i(o.f3758t));
        AbstractC0162z type = valueParameterDescriptorI != null ? valueParameterDescriptorI.getType() : null;
        return type == null ? c3.j.c(c3.i.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]) : type;
    }
}
