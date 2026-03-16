package M2;

import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements ReadWriteProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1078a;
    public final /* synthetic */ x b;

    public v(Object obj, x xVar) {
        this.b = xVar;
        this.f1078a = obj;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty property) {
        kotlin.jvm.internal.h.f(property, "property");
        return this.f1078a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object obj, KProperty property, Object obj2) {
        kotlin.jvm.internal.h.f(property, "property");
        if (this.b.f1095a) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        this.f1078a = obj2;
    }
}
