package k3;

import java.util.Iterator;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Sequence, DropTakeSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3781a = new d();

    @Override // kotlin.sequences.DropTakeSequence
    public final /* bridge */ /* synthetic */ Sequence drop(int i) {
        return f3781a;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return kotlin.collections.t.f3803a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final /* bridge */ /* synthetic */ Sequence take(int i) {
        return f3781a;
    }
}
