package m3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f4112a = new S(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof T) {
            return (T) element;
        }
        return null;
    }
}
