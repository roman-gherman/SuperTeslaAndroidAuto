package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: e2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0426b implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3131a;
    public final int b;
    public boolean c;
    public int d;

    public C0426b(char c, char c6, int i) {
        this.f3131a = i;
        this.b = c6;
        boolean z6 = false;
        if (i <= 0 ? h.h(c, c6) >= 0 : h.h(c, c6) <= 0) {
            z6 = true;
        }
        this.c = z6;
        this.d = z6 ? c : c6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f3131a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return Character.valueOf((char) i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
