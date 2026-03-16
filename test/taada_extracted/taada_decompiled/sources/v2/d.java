package V2;

import a3.AbstractC0162z;
import a3.F;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ImplicitReceiver, ThisClassReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassDescriptor f1373a;
    public final ClassDescriptor b;

    public d(ClassDescriptor classDescriptor) {
        h.f(classDescriptor, "classDescriptor");
        this.f1373a = classDescriptor;
        this.b = classDescriptor;
    }

    public final boolean equals(Object obj) {
        d dVar = obj instanceof d ? (d) obj : null;
        return h.a(this.f1373a, dVar != null ? dVar.f1373a : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.f1373a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public final AbstractC0162z getType() {
        F defaultType = this.f1373a.getDefaultType();
        h.e(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public final int hashCode() {
        return this.f1373a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Class{");
        F defaultType = this.f1373a.getDefaultType();
        h.e(defaultType, "classDescriptor.defaultType");
        sb.append(defaultType);
        sb.append('}');
        return sb.toString();
    }
}
