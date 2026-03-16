package P2;

import a3.AbstractC0162z;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AnnotationDescriptor value) {
        super(value);
        kotlin.jvm.internal.h.f(value, "value");
    }

    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        return ((AnnotationDescriptor) this.f1217a).getType();
    }
}
