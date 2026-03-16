package k3;

import java.util.Iterator;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements Sequence, DropTakeSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f3794a;
    public final int b;
    public final int c;

    public s(Sequence sequence, int i, int i3) {
        this.f3794a = sequence;
        this.b = i;
        this.c = i3;
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "startIndex should be non-negative, but is ").toString());
        }
        if (i3 < 0) {
            throw new IllegalArgumentException(B2.b.c(i3, "endIndex should be non-negative, but is ").toString());
        }
        if (i3 < i) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.n("endIndex should be not less than startIndex, but was ", i3, " < ", i).toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence drop(int i) {
        int i3 = this.c;
        int i4 = this.b;
        if (i >= i3 - i4) {
            return d.f3782a;
        }
        return new s(this.f3794a, i4 + i, i3);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new i(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take(int i) {
        int i3 = this.c;
        int i4 = this.b;
        if (i >= i3 - i4) {
            return this;
        }
        return new s(this.f3794a, i4, i + i4);
    }
}
