package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f3783a;
    public final boolean b;
    public final Object c;

    public f(Sequence sequence, boolean z6, Function1 predicate) {
        kotlin.jvm.internal.h.f(predicate, "predicate");
        this.f3783a = sequence;
        this.b = z6;
        this.c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new e(this);
    }
}
