package Z2;

import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends k implements MemoizedFunctionToNotNull {
    @Override // Z2.k, kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        Object objInvoke = super.invoke(obj);
        if (objInvoke != null) {
            return objInvoke;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "invoke"));
    }
}
