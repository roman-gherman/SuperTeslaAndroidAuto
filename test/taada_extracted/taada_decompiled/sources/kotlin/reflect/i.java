package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements TypeVariable, TypeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KTypeParameter f3827a;

    public i(KTypeParameter typeParameter) {
        kotlin.jvm.internal.h.f(typeParameter, "typeParameter");
        this.f3827a = typeParameter;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable) || !kotlin.jvm.internal.h.a(this.f3827a.getName(), ((TypeVariable) obj).getName())) {
            return false;
        }
        getGenericDeclaration();
        throw null;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        List<KType> upperBounds = this.f3827a.getUpperBounds();
        ArrayList arrayList = new ArrayList(o.D(upperBounds));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(l.k((KType) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new N1.d(androidx.constraintlayout.core.motion.a.p("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f3827a), 0);
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return this.f3827a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        return this.f3827a.getName();
    }

    public final int hashCode() {
        this.f3827a.getName().hashCode();
        getGenericDeclaration();
        throw null;
    }

    public final String toString() {
        return this.f3827a.getName();
    }
}
