package k3;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3790a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n(Object obj, int i) {
        this.f3790a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [U1.f, kotlin.jvm.functions.Function2] */
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.f3790a) {
            case 0:
                ?? r02 = (U1.f) this.b;
                k kVar = new k();
                kVar.d = C5.f.r(kVar, kVar, r02);
                return kVar;
            case 1:
                return (Iterator) this.b;
            case 2:
                return kotlin.jvm.internal.h.j((Object[]) this.b);
            default:
                return ((Iterable) this.b).iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function2 function2) {
        this.f3790a = 0;
        this.b = (U1.f) function2;
    }
}
