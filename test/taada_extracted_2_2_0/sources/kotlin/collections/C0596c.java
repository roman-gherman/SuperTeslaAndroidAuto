package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.collections.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0596c extends C0595b implements ListIterator {
    public final /* synthetic */ AbstractC0598e d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0596c(AbstractC0598e abstractC0598e, int i) {
        super(abstractC0598e);
        this.d = abstractC0598e;
        int iA = abstractC0598e.a();
        if (i < 0 || i > iA) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", iA));
        }
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return this.d.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
