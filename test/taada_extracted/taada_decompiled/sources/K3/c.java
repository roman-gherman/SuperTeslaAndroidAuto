package k3;

import java.util.Iterator;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Sequence, DropTakeSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3780a = 1;
    public final int b;
    public final Sequence c;

    public c(c cVar, int i) {
        this.c = cVar;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence drop(int i) {
        switch (this.f3780a) {
            case 0:
                int i3 = this.b + i;
                return i3 < 0 ? new c((Sequence) this, i) : new c(this.c, i3);
            default:
                int i4 = this.b;
                return i >= i4 ? d.f3781a : new s((c) this.c, i, i4);
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.f3780a) {
            case 0:
                return new b(this);
            default:
                return new b(this, (byte) 0);
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take(int i) {
        switch (this.f3780a) {
            case 0:
                int i3 = this.b;
                int i4 = i3 + i;
                return i4 < 0 ? new c(this, i) : new s(this.c, i3, i4);
            default:
                return i >= this.b ? this : new c((c) this.c, i);
        }
    }

    public c(Sequence sequence, int i) {
        this.c = sequence;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }
}
