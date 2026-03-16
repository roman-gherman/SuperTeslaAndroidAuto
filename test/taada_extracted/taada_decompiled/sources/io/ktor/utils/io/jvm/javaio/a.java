package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends U1.g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3594a;
    public final /* synthetic */ c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, Continuation continuation) {
        super(1, continuation);
        this.b = cVar;
    }

    @Override // U1.a
    public final Continuation create(Continuation continuation) {
        return new a(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((a) create((Continuation) obj)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3594a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            this.f3594a = 1;
            if (this.b.b(this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
        }
        return N1.m.f1129a;
    }
}
