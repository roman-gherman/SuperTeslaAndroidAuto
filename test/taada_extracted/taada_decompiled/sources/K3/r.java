package k3;

import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r extends kotlin.jvm.internal.f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f3792a = new r(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Sequence p02 = (Sequence) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return p02.iterator();
    }
}
