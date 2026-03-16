package e2;

import kotlin.jvm.internal.h;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.OpenEndRange;

/* JADX INFO: renamed from: e2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0427c extends AbstractC0425a implements ClosedRange, OpenEndRange {
    static {
        new C0427c((char) 1, (char) 0);
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        char cCharValue = ((Character) comparable).charValue();
        return h.h(this.f3130a, cCharValue) <= 0 && h.h(cCharValue, this.b) <= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0427c)) {
            return false;
        }
        if (isEmpty() && ((C0427c) obj).isEmpty()) {
            return true;
        }
        C0427c c0427c = (C0427c) obj;
        return this.f3130a == c0427c.f3130a && this.b == c0427c.b;
    }

    @Override // kotlin.ranges.OpenEndRange
    public final Comparable getEndExclusive() {
        char c = this.b;
        if (c != 65535) {
            return Character.valueOf((char) (c + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Character.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Character.valueOf(this.f3130a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3130a * 31) + this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return h.h(this.f3130a, this.b) > 0;
    }

    public final String toString() {
        return this.f3130a + ".." + this.b;
    }
}
