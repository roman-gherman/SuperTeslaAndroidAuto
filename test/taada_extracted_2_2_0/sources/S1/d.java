package S1;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends i implements Function2 {
    public static final d b = new d(2, 0);
    public static final d c = new d(2, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1279a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i3) {
        super(i);
        this.f1279a = i3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        e eVar;
        switch (this.f1279a) {
            case 0:
                String acc = (String) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                h.f(acc, "acc");
                h.f(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            default:
                CoroutineContext acc2 = (CoroutineContext) obj;
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                h.f(acc2, "acc");
                h.f(element2, "element");
                CoroutineContext coroutineContextMinusKey = acc2.minusKey(element2.getKey());
                g gVar = g.f1282a;
                if (coroutineContextMinusKey == gVar) {
                    return element2;
                }
                f fVar = ContinuationInterceptor.Key;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(fVar);
                if (continuationInterceptor == null) {
                    eVar = new e(element2, coroutineContextMinusKey);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(fVar);
                    if (coroutineContextMinusKey2 == gVar) {
                        return new e(continuationInterceptor, element2);
                    }
                    eVar = new e(continuationInterceptor, new e(element2, coroutineContextMinusKey2));
                }
                return eVar;
        }
    }
}
