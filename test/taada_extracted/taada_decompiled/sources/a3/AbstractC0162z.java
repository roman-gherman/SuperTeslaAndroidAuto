package a3;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: renamed from: a3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0162z implements Annotated, KotlinTypeMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1560a;

    public abstract List a();

    public abstract M b();

    public abstract TypeConstructor c();

    public abstract boolean d();

    public abstract AbstractC0162z e(b3.d dVar);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0162z)) {
            return false;
        }
        AbstractC0162z abstractC0162z = (AbstractC0162z) obj;
        if (d() == abstractC0162z.d()) {
            return C5.f.f0(b3.k.f1707a, f(), abstractC0162z.f());
        }
        return false;
    }

    public abstract c0 f();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return AbstractC0149l.a(b());
    }

    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int iHashCode;
        int i = this.f1560a;
        if (i != 0) {
            return i;
        }
        if (kotlin.reflect.l.O(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (d() ? 1 : 0) + ((a().hashCode() + (c().hashCode() * 31)) * 31);
        }
        this.f1560a = iHashCode;
        return iHashCode;
    }
}
