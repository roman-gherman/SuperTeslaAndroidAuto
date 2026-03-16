package r1;

import N1.m;
import h1.C0494b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4693a;
    public /* synthetic */ Object b;

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        h hVar = new h(2, continuation);
        hVar.b = obj;
        return hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((h) create((b) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4693a;
        if (i == 0) {
            l.e0(obj);
            C0494b call = ((b) this.b).getCall();
            this.f4693a = 1;
            obj = l.b0(call, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.e0(obj);
        }
        return ((C0494b) obj).d();
    }
}
