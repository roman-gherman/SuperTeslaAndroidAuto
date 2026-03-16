package k3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3786a;
    public int b;
    public Object c;
    public final /* synthetic */ Sequence d;

    public i(s sVar) {
        this.f3786a = 1;
        this.d = sVar;
        this.c = sVar.f3793a.iterator();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    public void a() {
        Object objInvoke;
        int i = this.b;
        j jVar = (j) this.d;
        if (i == -2) {
            objInvoke = jVar.b.invoke();
        } else {
            Object obj = this.c;
            kotlin.jvm.internal.h.c(obj);
            objInvoke = ((Function1) jVar.c).invoke(obj);
        }
        this.c = objInvoke;
        this.b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        s sVar;
        Iterator it;
        switch (this.f3786a) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                return this.b == 1;
        }
        while (true) {
            int i = this.b;
            sVar = (s) this.d;
            it = (Iterator) this.c;
            if (i < sVar.b && it.hasNext()) {
                it.next();
                this.b++;
            }
        }
        return this.b < sVar.c && it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        s sVar;
        Iterator it;
        switch (this.f3786a) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.c;
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return obj;
        }
        while (true) {
            int i = this.b;
            sVar = (s) this.d;
            it = (Iterator) this.c;
            if (i < sVar.b && it.hasNext()) {
                it.next();
                this.b++;
            }
        }
        int i3 = this.b;
        if (i3 >= sVar.c) {
            throw new NoSuchElementException();
        }
        this.b = i3 + 1;
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3786a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(j jVar) {
        this.f3786a = 0;
        this.d = jVar;
        this.b = -2;
    }
}
