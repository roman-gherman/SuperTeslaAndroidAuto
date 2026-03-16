package g3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: g3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0485b implements Iterator, KMappedMarker {
    public Object b;
    public final /* synthetic */ C0486c d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3307a = 2;
    public int c = -1;

    public C0485b(C0486c c0486c) {
        this.d = c0486c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Object[] objArr;
        int i3 = this.f3307a;
        if (i3 == 4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int iB = f.s.b(i3);
        if (iB != 0) {
            if (iB == 2) {
                return false;
            }
            this.f3307a = 4;
            do {
                i = this.c + 1;
                this.c = i;
                objArr = this.d.f3308a;
                if (i >= objArr.length) {
                    break;
                }
            } while (objArr[i] == null);
            if (i >= objArr.length) {
                this.f3307a = 3;
            } else {
                Object obj = objArr[i];
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                this.b = obj;
                this.f3307a = 1;
            }
            if (this.f3307a != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3307a = 2;
        return this.b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
