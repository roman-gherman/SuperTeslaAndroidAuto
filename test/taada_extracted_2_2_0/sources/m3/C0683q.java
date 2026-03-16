package m3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: m3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0683q extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0683q f4143a = new C0683q(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof AbstractC0684s) {
            return (AbstractC0684s) element;
        }
        return null;
    }
}
