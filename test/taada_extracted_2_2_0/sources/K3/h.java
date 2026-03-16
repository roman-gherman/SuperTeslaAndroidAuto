package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f3786a;
    public final Function1 b;
    public final Object c;

    public h(Sequence sequence, Function1 transformer, Function1 iterator) {
        kotlin.jvm.internal.h.f(transformer, "transformer");
        kotlin.jvm.internal.h.f(iterator, "iterator");
        this.f3786a = sequence;
        this.b = transformer;
        this.c = iterator;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new g(this);
    }
}
