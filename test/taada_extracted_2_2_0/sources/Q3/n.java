package q3;

import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Channel f4661a;
    public byte[] b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Flow[] f4663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 f4664h;
    public final /* synthetic */ WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f4665j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Flow[] flowArr, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass2 anonymousClass2, WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 anonymousClass3, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f4663g = flowArr;
        this.f4664h = anonymousClass2;
        this.i = anonymousClass3;
        this.f4665j = flowCollector;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        WorkConstraintsTracker$track$$inlined$combine$1.AnonymousClass3 anonymousClass3 = this.i;
        n nVar = new n(this.f4663g, this.f4664h, anonymousClass3, this.f4665j, continuation);
        nVar.f4662f = obj;
        return nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((n) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0104, code lost:
    
        if (r14.invoke(r15, r11, r20) == r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011d, code lost:
    
        if (r14.invoke(r15, r5, r20) == r1) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4 A[PHI: r2 r8 r10 r11 r12 r13 r14
      0x00b4: PHI (r2v5 byte[] A[IMMUTABLE_TYPE]) = (r2v6 byte[]), (r2v9 byte[]) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r8v2 java.lang.Object) = (r8v4 java.lang.Object), (r8v0 java.lang.Object) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r10v3 int) = (r10v7 int), (r10v9 int) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r11v2 java.lang.Object[]) = (r11v3 java.lang.Object[]), (r11v6 java.lang.Object[]) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r12v4 kotlinx.coroutines.channels.Channel) = (r12v5 kotlinx.coroutines.channels.Channel), (r12v7 kotlinx.coroutines.channels.Channel) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r13v3 int) = (r13v6 int), (r13v10 int) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r14v1 java.lang.Object) = (r14v11 java.lang.Object), (r14v14 java.lang.Object) binds: [B:20:0x00b0, B:11:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[LOOP:0: B:29:0x00bf->B:41:0x00e2, LOOP_START, PHI: r10 r14
      0x00bf: PHI (r10v4 int) = (r10v3 int), (r10v5 int) binds: [B:27:0x00bc, B:41:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x00bf: PHI (r14v4 kotlin.collections.x) = (r14v3 kotlin.collections.x), (r14v9 kotlin.collections.x) binds: [B:27:0x00bc, B:41:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0107 -> B:19:0x009e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x011d -> B:52:0x0120). Please report as a decompilation issue!!! */
    @Override // U1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
