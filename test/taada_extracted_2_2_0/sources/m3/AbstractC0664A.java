package m3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import n3.C0729d;

/* JADX INFO: renamed from: m3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0664A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Delay f4102a;

    static {
        String property;
        Delay delay;
        int i = r3.w.f4722a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            t3.d dVar = G.f4105a;
            CoroutineContext.Element element = r3.o.f4719a;
            C0729d c0729d = ((C0729d) element).c;
            delay = !(element instanceof Delay) ? RunnableC0691z.f4155h : (Delay) element;
        } else {
            delay = RunnableC0691z.f4155h;
        }
        f4102a = delay;
    }
}
