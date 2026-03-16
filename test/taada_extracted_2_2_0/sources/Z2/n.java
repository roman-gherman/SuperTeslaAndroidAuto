package Z2;

import A2.B;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public class n implements StorageManager {
    public static final String d;
    public static final b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleLock f1502a;
    public final LockBasedStorageManager$ExceptionHandlingStrategy b;
    public final String c;

    static {
        String strSubstring;
        String canonicalName = n.class.getCanonicalName();
        kotlin.jvm.internal.h.f(canonicalName, "<this>");
        int iL = kotlin.text.i.L(6, canonicalName, ".");
        if (iL == -1) {
            strSubstring = "";
        } else {
            strSubstring = canonicalName.substring(0, iL);
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        d = strSubstring;
        e = new b("NO_LOCKS", LockBasedStorageManager$ExceptionHandlingStrategy.THROW, a.f1496a);
    }

    public n(String str, LockBasedStorageManager$ExceptionHandlingStrategy lockBasedStorageManager$ExceptionHandlingStrategy, SimpleLock simpleLock) {
        if (lockBasedStorageManager$ExceptionHandlingStrategy == null) {
            a(5);
            throw null;
        }
        this.f1502a = simpleLock;
        this.b = lockBasedStorageManager$ExceptionHandlingStrategy;
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.n.a(int):void");
    }

    public static void c(AssertionError assertionError) {
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!stackTrace[i].getClassName().startsWith(d)) {
                break;
            } else {
                i++;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i, length);
        assertionError.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
    }

    public B b(Object obj, String str) {
        StringBuilder sb = new StringBuilder("Recursion detected ");
        sb.append(str);
        sb.append(obj == null ? "" : androidx.constraintlayout.core.motion.a.m(obj, "on input: "));
        sb.append(" under ");
        sb.append(this);
        AssertionError assertionError = new AssertionError(sb.toString());
        c(assertionError);
        throw assertionError;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final Object compute(Function0 function0) {
        if (function0 == null) {
            a(34);
            throw null;
        }
        this.f1502a.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final CacheWithNotNullValues createCacheWithNotNullValues() {
        return new e(this, new ConcurrentHashMap(3, 1.0f, 2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final CacheWithNullableValues createCacheWithNullableValues() {
        return new g(this, new ConcurrentHashMap(3, 1.0f, 2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final NotNullLazyValue createLazyValue(Function0 function0) {
        if (function0 != null) {
            return new j(this, function0);
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final NotNullLazyValue createLazyValueWithPostCompute(Function0 function0, Function1 function1, Function1 function12) {
        if (function0 == null) {
            a(28);
            throw null;
        }
        if (function12 != null) {
            return new d(this, function0, function1, function12);
        }
        a(29);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final MemoizedFunctionToNotNull createMemoizedFunction(Function1 function1) {
        if (function1 != null) {
            return new l(this, new ConcurrentHashMap(3, 1.0f, 2), function1);
        }
        a(9);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final MemoizedFunctionToNullable createMemoizedFunctionWithNullableValues(Function1 function1) {
        if (function1 != null) {
            return new k(this, new ConcurrentHashMap(3, 1.0f, 2), function1);
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final NullableLazyValue createNullableLazyValue(Function0 function0) {
        if (function0 != null) {
            return new i(this, function0);
        }
        a(30);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public final NotNullLazyValue createRecursionTolerantLazyValue(Function0 function0, Object obj) {
        if (function0 == null) {
            a(26);
            throw null;
        }
        if (obj != null) {
            return new c(this, function0, obj);
        }
        a(27);
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return B2.b.h(sb, this.c, ")");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n(String str) {
        LockBasedStorageManager$ExceptionHandlingStrategy lockBasedStorageManager$ExceptionHandlingStrategy = LockBasedStorageManager$ExceptionHandlingStrategy.THROW;
        SimpleLock.Companion.getClass();
        this(str, lockBasedStorageManager$ExceptionHandlingStrategy, new B.g(new ReentrantLock(), 20));
    }
}
