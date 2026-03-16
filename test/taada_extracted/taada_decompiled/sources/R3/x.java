package r3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f4722a = new x(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (!(element instanceof ThreadContextElement)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? element : Integer.valueOf(iIntValue + 1);
    }
}
