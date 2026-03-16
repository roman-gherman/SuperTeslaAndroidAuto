package k3;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public abstract void a(Object obj, U1.f fVar);

    public final Object b(Sequence sequence, U1.f fVar) {
        Object obj;
        Iterator it = sequence.iterator();
        k kVar = (k) this;
        boolean zHasNext = it.hasNext();
        T1.a aVar = T1.a.f1304a;
        N1.m mVar = N1.m.f1129a;
        if (zHasNext) {
            kVar.c = it;
            kVar.f3789a = 2;
            kVar.d = fVar;
            obj = aVar;
        } else {
            obj = mVar;
        }
        return obj == aVar ? obj : mVar;
    }
}
