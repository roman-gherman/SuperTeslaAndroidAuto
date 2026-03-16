package o3;

import kotlinx.coroutines.CancellableContinuation;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f4339a = new w(-1, null, null, 0);
    public static final int b = AbstractC0800a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
    public static final int c = AbstractC0800a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
    public static final E1.h d = new E1.h("BUFFERED", 9);
    public static final E1.h e = new E1.h("SHOULD_BUFFER", 9);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final E1.h f4340f = new E1.h("S_RESUMING_BY_RCV", 9);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E1.h f4341g = new E1.h("RESUMING_BY_EB", 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final E1.h f4342h = new E1.h("POISONED", 9);
    public static final E1.h i = new E1.h("DONE_RCV", 9);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final E1.h f4343j = new E1.h("INTERRUPTED_SEND", 9);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final E1.h f4344k = new E1.h("INTERRUPTED_RCV", 9);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final E1.h f4345l = new E1.h("CHANNEL_CLOSED", 9);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final E1.h f4346m = new E1.h("SUSPEND", 9);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final E1.h f4347n = new E1.h("SUSPEND_NO_WAITER", 9);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final E1.h f4348o = new E1.h("FAILED", 9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final E1.h f4349p = new E1.h("NO_RECEIVE_RESULT", 9);
    public static final E1.h q = new E1.h("CLOSE_HANDLER_CLOSED", 9);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final E1.h f4350r = new E1.h("CLOSE_HANDLER_INVOKED", 9);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final E1.h f4351s = new E1.h("NO_CLOSE_CAUSE", 9);

    public static final boolean a(CancellableContinuation cancellableContinuation, Object obj, r3.p pVar) {
        Object objTryResume = cancellableContinuation.tryResume(obj, null, pVar);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }
}
