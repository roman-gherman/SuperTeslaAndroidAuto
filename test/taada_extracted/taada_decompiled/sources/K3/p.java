package k3;

import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.jvm.internal.i implements Function1 {
    public static final p b = new p(1, 0);
    public static final p c = new p(1, 1);
    public static final p d = new p(1, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3790a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(int i, int i3) {
        super(i);
        this.f3790a = i3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3790a) {
            case 0:
                Sequence it = (Sequence) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return it.iterator();
            case 1:
                return obj;
            default:
                return Boolean.valueOf(obj == null);
        }
    }
}
