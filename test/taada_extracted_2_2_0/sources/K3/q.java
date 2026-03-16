package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3792a;
    public final Object b;

    public /* synthetic */ q(Object obj, int i) {
        this.f3792a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f3792a) {
            case 0:
                return ((Sequence) this.b).iterator();
            case 1:
                return kotlin.jvm.internal.h.j((Object[]) this.b);
            default:
                return new b((Iterator) ((kotlin.jvm.internal.i) this.b).invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function0 function0) {
        this.f3792a = 2;
        this.b = (kotlin.jvm.internal.i) function0;
    }
}
