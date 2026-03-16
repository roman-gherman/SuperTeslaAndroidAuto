package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: kotlin.collections.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0595b implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3798a = 0;
    public int b;
    public final Object c;

    public C0595b(Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        this.c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3798a) {
            case 0:
                if (this.b < ((AbstractC0598e) this.c).a()) {
                }
                break;
            default:
                if (this.b < ((Object[]) this.c).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3798a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.b;
                this.b = i + 1;
                return ((AbstractC0598e) this.c).get(i);
            default:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i3 = this.b;
                    this.b = i3 + 1;
                    return objArr[i3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3798a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0595b(AbstractC0598e abstractC0598e) {
        this.c = abstractC0598e;
    }
}
