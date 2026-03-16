package q3;

import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import net.bytebuddy.pool.TypePool;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements FusibleFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f4656a;
    public final int b;
    public final EnumC0743a c;

    public g(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        this.f4656a = coroutineContext;
        this.b = i;
        this.c = enumC0743a;
    }

    public abstract Object a(ProducerScope producerScope, Continuation continuation);

    public abstract g b(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a);

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        C0788e c0788e = new C0788e(flowCollector, this, null);
        r3.t tVar = new r3.t(continuation, continuation.getContext());
        Object objQ = io.ktor.utils.io.internal.t.q(tVar, tVar, c0788e);
        return objQ == T1.a.f1304a ? objQ : N1.m.f1129a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.flow.Flow fuse(kotlin.coroutines.CoroutineContext r5, int r6, o3.EnumC0743a r7) {
        /*
            r4 = this;
            kotlin.coroutines.CoroutineContext r0 = r4.f4656a
            kotlin.coroutines.CoroutineContext r5 = r5.plus(r0)
            o3.a r1 = o3.EnumC0743a.f4321a
            o3.a r2 = r4.c
            int r3 = r4.b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.h.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            q3.g r5 = r4.b(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.g.fuse(kotlin.coroutines.CoroutineContext, int, o3.a):kotlinx.coroutines.flow.Flow");
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        S1.g gVar = S1.g.f1282a;
        CoroutineContext coroutineContext = this.f4656a;
        if (coroutineContext != gVar) {
            arrayList.add("context=" + coroutineContext);
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        EnumC0743a enumC0743a = EnumC0743a.f4321a;
        EnumC0743a enumC0743a2 = this.c;
        if (enumC0743a2 != enumC0743a) {
            arrayList.add("onBufferOverflow=" + enumC0743a2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        return androidx.constraintlayout.core.motion.a.s(sb, kotlin.collections.m.V(arrayList, ", ", null, null, null, 62), ']');
    }
}
