package j1;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: j1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0563c extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3648a;
    public final /* synthetic */ HttpClientEngine b;
    public final /* synthetic */ q1.d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0563c(HttpClientEngine httpClientEngine, q1.d dVar, Continuation continuation) {
        super(2, continuation);
        this.b = httpClientEngine;
        this.c = dVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0563c(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0563c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3648a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
            return obj;
        }
        kotlin.reflect.l.e0(obj);
        HttpClientEngine httpClientEngine = this.b;
        Job job = (Job) httpClientEngine.getCoroutineContext().get(Job.Key);
        if (!(job != null ? job.isActive() : false)) {
            throw new com.google.android.gms.tasks.a("Client already closed", 2);
        }
        this.f3648a = 1;
        Object objExecute = httpClientEngine.execute(this.c, this);
        return objExecute == aVar ? aVar : objExecute;
    }
}
