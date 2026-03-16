package q3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f4671a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(s sVar) {
        super(2);
        this.f4671a = sVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        int iIntValue = ((Number) obj).intValue();
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.f4671a.b.get(key);
        if (key != Job.Key) {
            return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : iIntValue + 1);
        }
        Job job = (Job) element2;
        Job parent = (Job) element;
        while (true) {
            if (parent != null) {
                if (parent == job || !(parent instanceof r3.t)) {
                    break;
                }
                parent = parent.getParent();
            } else {
                parent = null;
                break;
            }
        }
        if (parent == job) {
            if (job != null) {
                iIntValue++;
            }
            return Integer.valueOf(iIntValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + parent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
