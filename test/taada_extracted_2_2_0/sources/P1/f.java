package P1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.collections.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1211a;
    public final e b;

    public /* synthetic */ f(e eVar, int i) {
        this.f1211a = i;
        this.b = eVar;
    }

    @Override // kotlin.collections.g
    public final int a() {
        switch (this.f1211a) {
        }
        return this.b.f1207h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f1211a) {
            case 0:
                Map.Entry element = (Map.Entry) obj;
                kotlin.jvm.internal.h.f(element, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        switch (this.f1211a) {
            case 0:
                kotlin.jvm.internal.h.f(elements, "elements");
                throw new UnsupportedOperationException();
            default:
                kotlin.jvm.internal.h.f(elements, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f1211a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f1211a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry element = (Map.Entry) obj;
                kotlin.jvm.internal.h.f(element, "element");
                return this.b.d(element);
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        switch (this.f1211a) {
            case 0:
                kotlin.jvm.internal.h.f(elements, "elements");
                return this.b.c(elements);
            default:
                return super.containsAll(elements);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f1211a) {
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f1211a) {
            case 0:
                e eVar = this.b;
                eVar.getClass();
                return new c(eVar, 0);
            default:
                e eVar2 = this.b;
                eVar2.getClass();
                return new c(eVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f1211a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry element = (Map.Entry) obj;
                kotlin.jvm.internal.h.f(element, "element");
                e eVar = this.b;
                eVar.getClass();
                eVar.b();
                int iF = eVar.f(element.getKey());
                if (iF < 0) {
                    return false;
                }
                Object[] objArr = eVar.b;
                kotlin.jvm.internal.h.c(objArr);
                if (!kotlin.jvm.internal.h.a(objArr[iF], element.getValue())) {
                    return false;
                }
                eVar.j(iF);
                return true;
            default:
                e eVar2 = this.b;
                eVar2.b();
                int iF2 = eVar2.f(obj);
                if (iF2 < 0) {
                    iF2 = -1;
                } else {
                    eVar2.j(iF2);
                }
                return iF2 >= 0;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        switch (this.f1211a) {
            case 0:
                kotlin.jvm.internal.h.f(elements, "elements");
                this.b.b();
                break;
            default:
                kotlin.jvm.internal.h.f(elements, "elements");
                this.b.b();
                break;
        }
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        switch (this.f1211a) {
            case 0:
                kotlin.jvm.internal.h.f(elements, "elements");
                this.b.b();
                break;
            default:
                kotlin.jvm.internal.h.f(elements, "elements");
                this.b.b();
                break;
        }
        return super.retainAll(elements);
    }
}
