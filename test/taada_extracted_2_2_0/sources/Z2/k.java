package Z2;

import A2.B;
import j3.p;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public class k implements MemoizedFunctionToNullable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f1500a;
    public final ConcurrentHashMap b;
    public final Function1 c;

    public k(n nVar, ConcurrentHashMap concurrentHashMap, Function1 function1) {
        this.f1500a = nVar;
        this.b = concurrentHashMap;
        this.c = function1;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "compute";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 3) {
            objArr[1] = "recursionDetected";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[1] = "raceCondition";
        }
        if (i != 3 && i != 4) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final AssertionError b(Object obj, Object obj2) {
        AssertionError assertionError = new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + this.f1500a);
        n.c(assertionError);
        return assertionError;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) throws Throwable {
        ConcurrentHashMap concurrentHashMap = this.b;
        Object obj2 = concurrentHashMap.get(obj);
        m mVar = m.b;
        Object obj3 = p.f3675a;
        if (obj2 != null && obj2 != mVar) {
            p.h(obj2);
            if (obj2 == obj3) {
                return null;
            }
            return obj2;
        }
        n nVar = this.f1500a;
        SimpleLock simpleLock = nVar.f1502a;
        simpleLock.lock();
        try {
            Object obj4 = concurrentHashMap.get(obj);
            m mVar2 = m.c;
            if (obj4 == mVar) {
                B b = nVar.b(obj, "");
                if (b == null) {
                    a(3);
                    throw null;
                }
                if (!b.b) {
                    Object obj5 = b.c;
                    simpleLock.unlock();
                    return obj5;
                }
                obj4 = mVar2;
            }
            if (obj4 == mVar2) {
                B b2 = nVar.b(obj, "");
                if (b2 == null) {
                    a(3);
                    throw null;
                }
                if (!b2.b) {
                    Object obj6 = b2.c;
                    simpleLock.unlock();
                    return obj6;
                }
            }
            if (obj4 != null) {
                p.h(obj4);
                assertionErrorB = obj4 != obj3 ? obj4 : null;
                simpleLock.unlock();
                return assertionErrorB;
            }
            try {
                concurrentHashMap.put(obj, mVar);
                Object objInvoke = this.c.invoke(obj);
                if (objInvoke != null) {
                    obj3 = objInvoke;
                }
                Object objPut = concurrentHashMap.put(obj, obj3);
                if (objPut == mVar) {
                    simpleLock.unlock();
                    return objInvoke;
                }
                assertionErrorB = b(obj, objPut);
                throw assertionErrorB;
            } catch (Throwable th) {
                if (p.f(th)) {
                    concurrentHashMap.remove(obj);
                    throw th;
                }
                LockBasedStorageManager$ExceptionHandlingStrategy lockBasedStorageManager$ExceptionHandlingStrategy = nVar.b;
                if (th == assertionErrorB) {
                    throw lockBasedStorageManager$ExceptionHandlingStrategy.handleException(th);
                }
                Object objPut2 = concurrentHashMap.put(obj, new j3.o(th));
                if (objPut2 != mVar) {
                    throw b(obj, objPut2);
                }
                throw lockBasedStorageManager$ExceptionHandlingStrategy.handleException(th);
            }
        } catch (Throwable th2) {
            simpleLock.unlock();
            throw th2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
    public final boolean isComputed(Object obj) {
        Object obj2 = this.b.get(obj);
        return (obj2 == null || obj2 == m.b) ? false : true;
    }
}
