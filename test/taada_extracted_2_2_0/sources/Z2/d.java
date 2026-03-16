package Z2;

import A2.B;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends i implements NotNullLazyValue {
    public volatile B.h d;
    public final /* synthetic */ Function1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f1497f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n nVar, Function0 function0, Function1 function1, Function1 function12) {
        super(nVar, function0);
        this.e = function1;
        this.f1497f = function12;
        if (function0 == null) {
            d(1);
            throw null;
        }
        this.d = null;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 2 ? 2 : 3];
        if (i != 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        } else {
            objArr[0] = "value";
        }
        if (i != 2) {
            objArr[1] = "recursionDetected";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        }
        if (i == 2) {
            objArr[2] = "doPostCompute";
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static /* synthetic */ void d(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        } else {
            objArr[1] = "invoke";
        }
        if (i != 2) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // Z2.i
    public final void b(Object obj) {
        this.d = new B.h(obj, 12);
        try {
            if (obj != null) {
                this.f1497f.invoke(obj);
            } else {
                a(2);
                throw null;
            }
        } finally {
            this.d = null;
        }
    }

    @Override // Z2.i
    public final B c(boolean z6) {
        Function1 function1 = this.e;
        if (function1 == null) {
            return super.c(z6);
        }
        return new B(function1.invoke(Boolean.valueOf(z6)), 2, false);
    }

    @Override // Z2.i, kotlin.jvm.functions.Function0
    public final Object invoke() throws Throwable {
        Object objInvoke;
        B.h hVar = this.d;
        if (hVar == null || ((Thread) hVar.c) != Thread.currentThread()) {
            objInvoke = super.invoke();
        } else {
            if (((Thread) hVar.c) != Thread.currentThread()) {
                throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
            }
            objInvoke = hVar.b;
        }
        if (objInvoke != null) {
            return objInvoke;
        }
        d(2);
        throw null;
    }
}
