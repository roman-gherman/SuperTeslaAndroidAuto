package P1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Iterator, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1202a;
    public int b;
    public int c;
    public final /* synthetic */ int d;

    public c(e map, int i) {
        this.d = i;
        kotlin.jvm.internal.h.f(map, "map");
        this.f1202a = map;
        this.c = -1;
        a();
    }

    public final void a() {
        while (true) {
            int i = this.b;
            e eVar = this.f1202a;
            if (i >= eVar.f1205f || eVar.c[i] >= 0) {
                return;
            } else {
                this.b = i + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f1202a.f1205f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.d) {
            case 0:
                int i = this.b;
                e eVar = this.f1202a;
                if (i >= eVar.f1205f) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                this.c = i;
                d dVar = new d(eVar, i);
                a();
                return dVar;
            case 1:
                int i3 = this.b;
                e eVar2 = this.f1202a;
                if (i3 >= eVar2.f1205f) {
                    throw new NoSuchElementException();
                }
                this.b = i3 + 1;
                this.c = i3;
                Object obj = eVar2.f1204a[i3];
                a();
                return obj;
            default:
                int i4 = this.b;
                e eVar3 = this.f1202a;
                if (i4 >= eVar3.f1205f) {
                    throw new NoSuchElementException();
                }
                this.b = i4 + 1;
                this.c = i4;
                Object[] objArr = eVar3.b;
                kotlin.jvm.internal.h.c(objArr);
                Object obj2 = objArr[this.c];
                a();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        e eVar = this.f1202a;
        eVar.b();
        eVar.j(this.c);
        this.c = -1;
    }
}
