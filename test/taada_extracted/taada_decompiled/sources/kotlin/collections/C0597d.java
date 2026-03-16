package kotlin.collections;

import java.util.RandomAccess;

/* JADX INFO: renamed from: kotlin.collections.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0597d extends AbstractC0598e implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0598e f3799a;
    public final int b;
    public final int c;

    public C0597d(AbstractC0598e abstractC0598e, int i, int i3) {
        this.f3799a = abstractC0598e;
        this.b = i;
        io.ktor.utils.io.jvm.javaio.q.d(i, i3, abstractC0598e.a());
        this.c = i3 - i;
    }

    @Override // kotlin.collections.AbstractC0594a
    public final int a() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i3 = this.c;
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        return this.f3799a.get(this.b + i);
    }
}
