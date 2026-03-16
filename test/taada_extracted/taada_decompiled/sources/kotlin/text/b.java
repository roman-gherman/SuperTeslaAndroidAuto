package kotlin.text;

import e2.C0430f;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3943a = -1;
    public int b;
    public int c;
    public C0430f d;
    public final /* synthetic */ k3.j e;

    public b(k3.j jVar) {
        this.e = jVar;
        int length = ((String) jVar.c).length();
        if (length < 0) {
            throw new IllegalArgumentException(B2.b.d(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.b = length;
        this.c = length;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.i] */
    public final void a() {
        N1.e eVar;
        int i = this.c;
        if (i < 0) {
            this.f3943a = 0;
            this.d = null;
            return;
        }
        k3.j jVar = this.e;
        String str = (String) jVar.c;
        if (i <= str.length() && (eVar = (N1.e) jVar.b.mo5invoke(str, Integer.valueOf(this.c))) != null) {
            int iIntValue = ((Number) eVar.f1121a).intValue();
            int iIntValue2 = ((Number) eVar.b).intValue();
            this.d = E1.k.s0(this.b, iIntValue);
            int i3 = iIntValue + iIntValue2;
            this.b = i3;
            this.c = i3 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.d = new C0430f(this.b, i.F(str), 1);
            this.c = -1;
        }
        this.f3943a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3943a == -1) {
            a();
        }
        return this.f3943a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3943a == -1) {
            a();
        }
        if (this.f3943a == 0) {
            throw new NoSuchElementException();
        }
        C0430f c0430f = this.d;
        kotlin.jvm.internal.h.d(c0430f, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.f3943a = -1;
        return c0430f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
