package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: io.ktor.utils.io.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0559z extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3643a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ U c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0559z(U u, Continuation continuation, Function2 function2) {
        super(2, continuation);
        this.b = function2;
        this.c = u;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0559z(this.c, continuation, this.b);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0559z) create((LookAheadSuspendSession) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3643a;
        M3.a aVar2 = this.c.f3538f;
        try {
            if (i == 0) {
                kotlin.reflect.l.e0(obj);
                Function2 function2 = this.b;
                this.f3643a = 1;
                if (function2.mo5invoke(aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.reflect.l.e0(obj);
            }
            aVar2.b();
            return N1.m.f1129a;
        } catch (Throwable th) {
            aVar2.b();
            throw th;
        }
    }
}
