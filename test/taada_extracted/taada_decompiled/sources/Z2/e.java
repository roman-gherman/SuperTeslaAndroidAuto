package Z2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends g implements CacheWithNotNullValues {
    public static /* synthetic */ void a(int i) {
        String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 3 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "computation";
        } else if (i != 3) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        }
        if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        } else {
            objArr[1] = "computeIfAbsent";
        }
        if (i == 2) {
            objArr[2] = "computeIfAbsent";
        } else if (i != 3) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i == 3) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
    public final Object computeIfAbsent(Object obj, Function0 function0) throws Throwable {
        if (function0 == null) {
            a(2);
            throw null;
        }
        Object objInvoke = invoke(new h(obj, function0));
        if (objInvoke != null) {
            return objInvoke;
        }
        a(3);
        throw null;
    }
}
