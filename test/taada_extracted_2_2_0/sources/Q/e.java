package Q;

import kotlin.reflect.l;

/* JADX INFO: loaded from: classes.dex */
public final class e extends f {
    public final transient int c;
    public final transient int d;
    public final /* synthetic */ f e;

    public e(f fVar, int i, int i3) {
        this.e = fVar;
        this.c = i;
        this.d = i3;
    }

    @Override // Q.c
    public final Object[] a() {
        return this.e.a();
    }

    @Override // Q.c
    public final int b() {
        return this.e.b() + this.c;
    }

    @Override // Q.c
    public final int c() {
        return this.e.b() + this.c + this.d;
    }

    @Override // Q.c
    public final boolean d() {
        return true;
    }

    @Override // Q.f, java.util.List
    /* JADX INFO: renamed from: f */
    public final f subList(int i, int i3) {
        l.p0(i, i3, this.d);
        int i4 = this.c;
        return this.e.subList(i + i4, i3 + i4);
    }

    @Override // java.util.List
    public final Object get(int i) {
        l.o0(i, this.d);
        return this.e.get(i + this.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
