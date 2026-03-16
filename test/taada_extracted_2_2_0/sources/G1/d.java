package g1;

import N1.m;
import h1.C0494b;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import kotlin.reflect.l;
import m1.AbstractC0635d;
import m3.q0;
import p1.C0754a;
import p1.C0755b;
import r3.k;
import s1.AbstractC0809b;
import u1.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3291a;
    public int b;
    public /* synthetic */ E1.f c;
    public /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, Continuation continuation) {
        super(i, continuation);
        this.f3291a = 1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        E1.f fVar = (E1.f) obj;
        switch (this.f3291a) {
            case 0:
                d dVar = new d((f) this.d, (Continuation) obj3, 0);
                dVar.c = fVar;
                return dVar.invokeSuspend(m.f1129a);
            case 1:
                d dVar2 = new d(3, (Continuation) obj3);
                dVar2.c = fVar;
                dVar2.d = (r1.b) obj2;
                return dVar2.invokeSuspend(m.f1129a);
            default:
                d dVar3 = new d((o1.g) this.d, (Continuation) obj3, 2);
                dVar3.c = fVar;
                return dVar3.invokeSuspend(m.f1129a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [E1.f] */
    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        E1.f fVar;
        Object obj2 = m.f1129a;
        T1.a aVar = T1.a.f1304a;
        switch (this.f3291a) {
            case 0:
                ?? r02 = this.b;
                try {
                    if (r02 == 0) {
                        l.e0(obj);
                        E1.f fVar2 = this.c;
                        this.c = fVar2;
                        this.b = 1;
                        Object objC = fVar2.c(this);
                        r02 = fVar2;
                        if (objC == aVar) {
                            obj2 = aVar;
                            r02 = fVar2;
                        }
                    } else {
                        if (r02 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        E1.f fVar3 = this.c;
                        l.e0(obj);
                        r02 = fVar3;
                    }
                    return obj2;
                } catch (Throwable th) {
                    v vVar = ((f) this.d).f3298j;
                    z.e eVar = AbstractC0809b.d;
                    ((C0494b) r02.f289a).d();
                    vVar.getClass();
                    q0 q0Var = (q0) ((B1.a) vVar.f3878a).a(eVar);
                    if (q0Var != null) {
                        Object objC2 = q0Var.c();
                        kotlin.jvm.internal.h.d(objC2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        for (k kVarD = (k) objC2; !kVarD.equals(q0Var); kVarD = kVarD.d()) {
                        }
                    }
                    throw th;
                }
            case 1:
                int i = this.b;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                    return obj2;
                }
                l.e0(obj);
                E1.f fVar4 = this.c;
                r1.b bVar = (r1.b) this.d;
                Function3 function3 = (Function3) bVar.getCall().c().getAttributes().getOrNull(AbstractC0635d.b);
                if (function3 == null) {
                    return obj2;
                }
                ByteReadChannel byteReadChannelA = bVar.a();
                CoroutineContext coroutineContext = bVar.getCoroutineContext();
                Headers headers = bVar.getHeaders();
                List list = q.f4870a;
                String str = headers.get("Content-Length");
                ByteChannel byteChannelA = AbstractC0809b.a(byteReadChannelA, coroutineContext, str != null ? Long.valueOf(Long.parseLong(str)) : null, function3);
                C0494b call = bVar.getCall();
                kotlin.jvm.internal.h.f(call, "<this>");
                C0754a c0754a = new C0754a(call.f3353a);
                c0754a.b = new h1.e(c0754a, call.c());
                c0754a.c = new C0755b(c0754a, byteChannelA, call.d());
                r1.b bVarD = c0754a.d();
                this.c = null;
                this.b = 1;
                return fVar4.d(bVarD, this) == aVar ? aVar : obj2;
            default:
                int i3 = this.b;
                if (i3 == 0) {
                    l.e0(obj);
                    fVar = this.c;
                    q1.c cVar = (q1.c) fVar.f289a;
                    Object objB = fVar.b();
                    this.c = fVar;
                    this.b = 1;
                    obj = ((o1.g) this.d).a(cVar, objB, this);
                    if (obj != aVar) {
                    }
                    return aVar;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                    return obj2;
                }
                fVar = this.c;
                l.e0(obj);
                if (obj == null) {
                    return obj2;
                }
                this.c = null;
                this.b = 2;
                if (fVar.d(obj, this) != aVar) {
                    return obj2;
                }
                return aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, Continuation continuation, int i) {
        super(3, continuation);
        this.f3291a = i;
        this.d = obj;
    }
}
