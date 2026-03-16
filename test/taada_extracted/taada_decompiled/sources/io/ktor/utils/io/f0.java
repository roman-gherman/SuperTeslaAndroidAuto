package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import m3.AbstractC0684s;
import m3.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3571a;
    public /* synthetic */ Object b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ U d;
    public final /* synthetic */ U1.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0684s f3572f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public f0(boolean z6, U u, Function2 function2, AbstractC0684s abstractC0684s, Continuation continuation) {
        super(2, continuation);
        this.c = z6;
        this.d = u;
        this.e = (U1.g) function2;
        this.f3572f = abstractC0684s;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [U1.g, kotlin.jvm.functions.Function2] */
    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        ?? r32 = this.e;
        f0 f0Var = new f0(this.c, this.d, r32, this.f3572f, continuation);
        f0Var.b = obj;
        return f0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((f0) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [U1.g, kotlin.jvm.functions.Function2] */
    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3571a;
        U u = this.d;
        try {
            if (i == 0) {
                kotlin.reflect.l.e0(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                if (this.c) {
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.Key);
                    kotlin.jvm.internal.h.c(element);
                    u.attachJob((Job) element);
                }
                d0 d0Var = new d0(coroutineScope, u);
                ?? r6 = this.e;
                this.f3571a = 1;
                if (r6.mo5invoke(d0Var, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.reflect.l.e0(obj);
            }
        } catch (Throwable th) {
            x0 x0Var = m3.G.b;
            AbstractC0684s abstractC0684s = this.f3572f;
            if (!kotlin.jvm.internal.h.a(abstractC0684s, x0Var) && abstractC0684s != null) {
                throw th;
            }
            u.close(th);
        }
        return N1.m.f1129a;
    }
}
