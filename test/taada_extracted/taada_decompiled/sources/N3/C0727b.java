package n3;

import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: n3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0727b extends S1.a implements CoroutineExceptionHandler {

    @Nullable
    private volatile Object _preHandler;

    public C0727b() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleException(kotlin.coroutines.CoroutineContext r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 28
            if (r5 >= r0) goto L4b
            java.lang.Object r5 = r4._preHandler
            r0 = 0
            r1 = 0
            if (r5 == r4) goto Lf
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5
            goto L31
        Lf:
            java.lang.Class<java.lang.Thread> r5 = java.lang.Thread.class
            java.lang.String r2 = "getUncaughtExceptionPreHandler"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L2e
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r2, r3)     // Catch: java.lang.Throwable -> L2e
            int r2 = r5.getModifiers()     // Catch: java.lang.Throwable -> L2e
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L2e
            int r2 = r5.getModifiers()     // Catch: java.lang.Throwable -> L2e
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L2e
            goto L2f
        L2e:
            r5 = r1
        L2f:
            r4._preHandler = r5
        L31:
            if (r5 == 0) goto L3a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Object r5 = r5.invoke(r1, r0)
            goto L3b
        L3a:
            r5 = r1
        L3b:
            boolean r0 = r5 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r0 == 0) goto L42
            r1 = r5
            java.lang.Thread$UncaughtExceptionHandler r1 = (java.lang.Thread.UncaughtExceptionHandler) r1
        L42:
            if (r1 == 0) goto L4b
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r1.uncaughtException(r5, r6)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.C0727b.handleException(kotlin.coroutines.CoroutineContext, java.lang.Throwable):void");
    }
}
