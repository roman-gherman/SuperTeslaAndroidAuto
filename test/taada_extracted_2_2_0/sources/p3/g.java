package p3;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4480a;
    public int b;
    public final /* synthetic */ h c;
    public FlowCollector d;
    public Iterator e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, Continuation continuation) {
        super(continuation);
        this.c = hVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4480a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
