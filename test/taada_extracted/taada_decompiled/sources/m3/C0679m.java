package m3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CopyableThreadContextElement;

/* JADX INFO: renamed from: m3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0679m extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0679m f4136a = new C0679m(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        return element instanceof CopyableThreadContextElement ? coroutineContext.plus(((CopyableThreadContextElement) element).copyForChild()) : coroutineContext.plus(element);
    }
}
