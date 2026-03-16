package k3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: k3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0590a implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f3778a;

    public C0590a(Sequence sequence) {
        this.f3778a = new AtomicReference(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Sequence sequence = (Sequence) this.f3778a.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
