package e2;

import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;

/* JADX INFO: renamed from: e2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0430f extends C0428d implements ClosedRange, OpenEndRange {
    public static final C0430f d = new C0430f(1, 0, 1);

    public final boolean b(int i) {
        return this.f3132a <= i && i <= this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).intValue());
    }

    @Override // e2.C0428d
    public final boolean equals(Object obj) {
        if (!(obj instanceof C0430f)) {
            return false;
        }
        if (isEmpty() && ((C0430f) obj).isEmpty()) {
            return true;
        }
        C0430f c0430f = (C0430f) obj;
        if (this.f3132a == c0430f.f3132a) {
            return this.b == c0430f.b;
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getEndExclusive() {
        int i = this.b;
        if (i != Integer.MAX_VALUE) {
            return Integer.valueOf(i + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Integer.valueOf(this.f3132a);
    }

    @Override // e2.C0428d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3132a * 31) + this.b;
    }

    @Override // e2.C0428d, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return this.f3132a > this.b;
    }

    @Override // e2.C0428d
    public final String toString() {
        return this.f3132a + ".." + this.b;
    }
}
