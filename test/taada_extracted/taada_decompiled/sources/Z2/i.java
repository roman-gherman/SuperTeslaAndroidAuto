package Z2;

import A2.B;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public class i implements NullableLazyValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f1499a;
    public final Function0 b;
    public volatile Object c;

    public i(n nVar, Function0 function0) {
        if (function0 == null) {
            a(1);
            throw null;
        }
        this.c = m.f1501a;
        this.f1499a = nVar;
        this.b = function0;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i == 2 || i == 3) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 2) {
            objArr[1] = "recursionDetected";
        } else if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[1] = "renderDebugInformation";
        }
        if (i != 2 && i != 3) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public void b(Object obj) {
    }

    public B c(boolean z6) {
        B b = this.f1499a.b(null, "in a lazy value");
        if (b != null) {
            return b;
        }
        a(2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x0022, TRY_LEAVE, TryCatch #0 {all -> 0x0022, blocks: (B:7:0x0011, B:9:0x0017, B:16:0x002a, B:18:0x0035, B:20:0x003a, B:22:0x0043, B:23:0x0046, B:27:0x0055, B:29:0x005b, B:31:0x005f, B:32:0x0066, B:33:0x006e, B:34:0x006f, B:35:0x0075, B:24:0x0048), top: B:38:0x0011, inners: #1 }] */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke() throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            boolean r1 = r0 instanceof Z2.m
            if (r1 != 0) goto La
            j3.p.h(r0)
            return r0
        La:
            Z2.n r0 = r5.f1499a
            kotlin.reflect.jvm.internal.impl.storage.SimpleLock r0 = r0.f1502a
            r0.lock()
            java.lang.Object r0 = r5.c     // Catch: java.lang.Throwable -> L22
            boolean r1 = r0 instanceof Z2.m     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L24
            j3.p.h(r0)     // Catch: java.lang.Throwable -> L22
        L1a:
            Z2.n r1 = r5.f1499a
            kotlin.reflect.jvm.internal.impl.storage.SimpleLock r1 = r1.f1502a
            r1.unlock()
            return r0
        L22:
            r0 = move-exception
            goto L76
        L24:
            Z2.m r1 = Z2.m.b
            Z2.m r2 = Z2.m.c
            if (r0 != r1) goto L38
            r5.c = r2     // Catch: java.lang.Throwable -> L22
            r3 = 1
            A2.B r3 = r5.c(r3)     // Catch: java.lang.Throwable -> L22
            boolean r4 = r3.b     // Catch: java.lang.Throwable -> L22
            if (r4 != 0) goto L38
            java.lang.Object r0 = r3.c     // Catch: java.lang.Throwable -> L22
            goto L1a
        L38:
            if (r0 != r2) goto L46
            r0 = 0
            A2.B r0 = r5.c(r0)     // Catch: java.lang.Throwable -> L22
            boolean r2 = r0.b     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L46
            java.lang.Object r0 = r0.c     // Catch: java.lang.Throwable -> L22
            goto L1a
        L46:
            r5.c = r1     // Catch: java.lang.Throwable -> L22
            kotlin.jvm.functions.Function0 r0 = r5.b     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L54
            r5.b(r0)     // Catch: java.lang.Throwable -> L54
            r5.c = r0     // Catch: java.lang.Throwable -> L54
            goto L1a
        L54:
            r0 = move-exception
            boolean r2 = j3.p.f(r0)     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L6f
            java.lang.Object r2 = r5.c     // Catch: java.lang.Throwable -> L22
            if (r2 != r1) goto L66
            j3.o r1 = new j3.o     // Catch: java.lang.Throwable -> L22
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L22
            r5.c = r1     // Catch: java.lang.Throwable -> L22
        L66:
            Z2.n r1 = r5.f1499a     // Catch: java.lang.Throwable -> L22
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy r1 = r1.b     // Catch: java.lang.Throwable -> L22
            java.lang.RuntimeException r0 = r1.handleException(r0)     // Catch: java.lang.Throwable -> L22
            throw r0     // Catch: java.lang.Throwable -> L22
        L6f:
            Z2.m r1 = Z2.m.f1501a     // Catch: java.lang.Throwable -> L22
            r5.c = r1     // Catch: java.lang.Throwable -> L22
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L22
            throw r0     // Catch: java.lang.Throwable -> L22
        L76:
            Z2.n r1 = r5.f1499a
            kotlin.reflect.jvm.internal.impl.storage.SimpleLock r1 = r1.f1502a
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.i.invoke():java.lang.Object");
    }

    public final boolean isComputed() {
        return (this.c == m.f1501a || this.c == m.b) ? false : true;
    }
}
