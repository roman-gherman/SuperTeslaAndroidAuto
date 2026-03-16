package o2;

import io.ktor.utils.io.Z;
import java.util.Iterator;
import java.util.List;
import k3.m;
import kotlin.collections.t;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.r;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Annotations {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4290a;
    public final Object b;

    public /* synthetic */ g(List list, int i) {
        this.f4290a = i;
        this.b = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final AnnotationDescriptor findAnnotation(L2.c fqName) {
        switch (this.f4290a) {
            case 0:
                return Z.h(this, fqName);
            case 1:
                kotlin.jvm.internal.h.f(fqName, "fqName");
                return (AnnotationDescriptor) m.y(m.E(kotlin.collections.m.K((List) this.b), new r(fqName, 1)));
            default:
                kotlin.jvm.internal.h.f(fqName, "fqName");
                if (fqName.equals((L2.c) this.b)) {
                    return D2.b.f249a;
                }
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean hasAnnotation(L2.c fqName) {
        switch (this.f4290a) {
            case 1:
                kotlin.jvm.internal.h.f(fqName, "fqName");
                Iterator it = ((Iterable) kotlin.collections.m.K((List) this.b).b).iterator();
                while (it.hasNext()) {
                    if (((Annotations) it.next()).hasAnnotation(fqName)) {
                        break;
                    }
                }
                break;
        }
        return Z.n(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean isEmpty() {
        switch (this.f4290a) {
            case 0:
                return ((List) this.b).isEmpty();
            case 1:
                List list = (List) this.b;
                if (list != null && list.isEmpty()) {
                    return true;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((Annotations) it.next()).isEmpty()) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<AnnotationDescriptor> iterator() {
        switch (this.f4290a) {
            case 0:
                return ((List) this.b).iterator();
            case 1:
                return new k3.g(m.z(kotlin.collections.m.K((List) this.b), i.f4292a));
            default:
                return t.f3804a;
        }
    }

    public String toString() {
        switch (this.f4290a) {
            case 0:
                return ((List) this.b).toString();
            default:
                return super.toString();
        }
    }

    public g(Annotations[] annotationsArr) {
        this.f4290a = 1;
        this.b = kotlin.collections.j.L(annotationsArr);
    }

    public g(L2.c fqNameToMatch) {
        this.f4290a = 2;
        kotlin.jvm.internal.h.f(fqNameToMatch, "fqNameToMatch");
        this.b = fqNameToMatch;
    }
}
