package m3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CopyableThreadContextElement;

/* JADX INFO: renamed from: m3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0680n extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f4138a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0680n(kotlin.jvm.internal.v vVar, boolean z6) {
        super(2);
        this.f4138a = vVar;
        this.b = z6;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        kotlin.jvm.internal.v vVar = this.f4138a;
        CoroutineContext.Element element2 = ((CoroutineContext) vVar.f3816a).get(element.getKey());
        if (element2 != null) {
            vVar.f3816a = ((CoroutineContext) vVar.f3816a).minusKey(element.getKey());
            return coroutineContext.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
        }
        CopyableThreadContextElement copyableThreadContextElementCopyForChild = (CopyableThreadContextElement) element;
        if (this.b) {
            copyableThreadContextElementCopyForChild = copyableThreadContextElementCopyForChild.copyForChild();
        }
        return coroutineContext.plus(copyableThreadContextElementCopyForChild);
    }
}
