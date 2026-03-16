package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeParameterDescriptor f1540a;
    public final B2.a b;

    public T(TypeParameterDescriptor typeParameter, B2.a typeAttr) {
        kotlin.jvm.internal.h.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.h.f(typeAttr, "typeAttr");
        this.f1540a = typeParameter;
        this.b = typeAttr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof T)) {
            return false;
        }
        T t6 = (T) obj;
        return kotlin.jvm.internal.h.a(t6.f1540a, this.f1540a) && kotlin.jvm.internal.h.a(t6.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = this.f1540a.hashCode();
        return this.b.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public final String toString() {
        return "DataToEraseUpperBound(typeParameter=" + this.f1540a + ", typeAttr=" + this.b + ')';
    }
}
