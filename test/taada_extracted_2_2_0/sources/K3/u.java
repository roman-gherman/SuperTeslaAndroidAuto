package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f3796a;
    public final Function1 b;

    public u(Sequence sequence, Function1 transformer) {
        kotlin.jvm.internal.h.f(transformer, "transformer");
        this.f3796a = sequence;
        this.b = transformer;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new t(this);
    }
}
