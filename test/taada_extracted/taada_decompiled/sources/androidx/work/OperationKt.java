package androidx.work;

import C5.f;
import T1.a;
import U1.c;
import U1.d;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.h;
import m3.C0672f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.work.OperationKt", f = "Operation.kt", i = {0}, l = {39}, m = "await", n = {"$this$await$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object await(androidx.work.Operation r4, kotlin.coroutines.Continuation<? super androidx.work.Operation.State.SUCCESS> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            com.google.common.util.concurrent.ListenableFuture r4 = (com.google.common.util.concurrent.ListenableFuture) r4
            kotlin.reflect.l.e0(r5)
            goto L7d
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.reflect.l.e0(r5)
            com.google.common.util.concurrent.ListenableFuture r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.h.e(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L54
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L4a
            goto L7e
        L4a:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L52
            goto L53
        L52:
            r4 = r5
        L53:
            throw r4
        L54:
            r0.L$0 = r4
            r0.label = r3
            m3.f r5 = new m3.f
            kotlin.coroutines.Continuation r0 = C5.f.J(r0)
            r5.<init>(r3, r0)
            r5.initCancellability()
            androidx.work.ListenableFutureKt$await$2$1 r0 = new androidx.work.ListenableFutureKt$await$2$1
            r0.<init>(r5, r4)
            androidx.work.DirectExecutor r2 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r0, r2)
            androidx.work.ListenableFutureKt$await$2$2 r0 = new androidx.work.ListenableFutureKt$await$2$2
            r0.<init>(r4)
            r5.invokeOnCancellation(r0)
            java.lang.Object r5 = r5.m()
            if (r5 != r1) goto L7d
            return r1
        L7d:
            r4 = r5
        L7e:
            java.lang.String r5 = "result.await()"
            kotlin.jvm.internal.h.e(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        Object objM;
        ListenableFuture<Operation.State.SUCCESS> result = operation.getResult();
        h.e(result, "result");
        if (result.isDone()) {
            try {
                objM = result.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            C0672f c0672f = new C0672f(1, f.J(continuation));
            c0672f.initCancellability();
            result.addListener(new ListenableFutureKt$await$2$1(c0672f, result), DirectExecutor.INSTANCE);
            c0672f.invokeOnCancellation(new ListenableFutureKt$await$2$2(result));
            objM = c0672f.m();
            if (objM == a.f1304a) {
                d.a(continuation);
            }
        }
        h.e(objM, "result.await()");
        return objM;
    }
}
