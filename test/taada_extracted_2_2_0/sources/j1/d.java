package j1;

import A2.C0019a;
import androidx.core.location.LocationRequestCompat;
import e2.C0429e;
import g1.C0477a;
import h1.C0494b;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.Sender;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.utils.io.ByteReadChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.w;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import m1.C0632a;
import m1.D;
import m1.E;
import m1.J;
import m1.K;
import m1.L;
import m1.M;
import m1.N;
import m1.O;
import m1.P;
import m3.AbstractC0690y;
import s1.AbstractC0809b;
import u1.C0832A;
import u1.C0835D;
import u1.q;
import u1.r;
import u1.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3649a;
    public int b;
    public final /* synthetic */ g1.f c;
    public /* synthetic */ Object d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3650f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g1.f fVar, e eVar, Continuation continuation) {
        super(3, continuation);
        this.f3649a = 0;
        this.c = fVar;
        this.f3650f = eVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f3649a) {
            case 0:
                d dVar = new d(this.c, (e) this.f3650f, (Continuation) obj3);
                dVar.d = (E1.f) obj;
                dVar.e = obj2;
                return dVar.invokeSuspend(N1.m.f1129a);
            case 1:
                g1.f fVar = this.c;
                d dVar2 = new d((D) this.f3650f, fVar, (Continuation) obj3, 1);
                dVar2.d = (Sender) obj;
                dVar2.e = (q1.c) obj2;
                return dVar2.invokeSuspend(N1.m.f1129a);
            case 2:
                g1.f fVar2 = this.c;
                d dVar3 = new d((L) this.f3650f, fVar2, (Continuation) obj3, 2);
                dVar3.d = (E1.f) obj;
                dVar3.e = obj2;
                return dVar3.invokeSuspend(N1.m.f1129a);
            default:
                g1.f fVar3 = this.c;
                d dVar4 = new d((P) this.f3650f, fVar3, (Continuation) obj3, 3);
                dVar4.d = (Sender) obj;
                dVar4.e = (q1.c) obj2;
                return dVar4.invokeSuspend(N1.m.f1129a);
        }
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        E1.f fVar;
        q1.d requestData;
        e eVar;
        Object objA;
        HttpClientEngineCapability httpClientEngineCapability;
        Sender sender;
        q1.c cVar;
        Object objExecute;
        E1.f fVar2;
        Object objExecute2;
        String strSubstring;
        N1.m mVar = N1.m.f1129a;
        v1.d dVar = v1.d.f4928a;
        g1.f fVar3 = this.c;
        Object obj2 = this.f3650f;
        T1.a aVar = T1.a.f1304a;
        switch (this.f3649a) {
            case 0:
                int i = this.b;
                v vVar = fVar3.f3298j;
                if (i == 0) {
                    kotlin.reflect.l.e0(obj);
                    fVar = (E1.f) this.d;
                    Object obj3 = this.e;
                    q1.c cVar2 = new q1.c();
                    cVar2.b((q1.c) fVar.f289a);
                    if (obj3 == null) {
                        cVar2.d = dVar;
                        KType kTypeA = w.a(Object.class);
                        cVar2.a(kotlin.reflect.l.i0(kotlin.reflect.l.F(kTypeA), w.f3818a.b(Object.class), kTypeA));
                    } else if (obj3 instanceof v1.g) {
                        cVar2.d = obj3;
                        cVar2.a(null);
                    } else {
                        cVar2.d = obj3;
                        KType kTypeA2 = w.a(Object.class);
                        cVar2.a(kotlin.reflect.l.i0(kotlin.reflect.l.F(kTypeA2), w.f3818a.b(Object.class), kTypeA2));
                    }
                    vVar.d(AbstractC0809b.b);
                    C0835D c0835dB = cVar2.f4513a.b();
                    r rVar = cVar2.b;
                    u1.n nVar = new u1.n((Map) cVar2.c.f4280a);
                    Object obj4 = cVar2.d;
                    v1.g gVar = obj4 instanceof v1.g ? (v1.g) obj4 : null;
                    if (gVar == null) {
                        throw new IllegalStateException(("No request transformation found: " + cVar2.d).toString());
                    }
                    CompletableJob completableJob = cVar2.e;
                    z1.f fVar4 = cVar2.f4514f;
                    requestData = new q1.d(c0835dB, rVar, nVar, gVar, completableJob, fVar4);
                    fVar4.put(h.b, fVar3.f3299k);
                    Set setNames = nVar.names();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj5 : setNames) {
                        if (q.f4870a.contains((String) obj5)) {
                            arrayList.add(obj5);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        String header = arrayList.toString();
                        kotlin.jvm.internal.h.f(header, "header");
                        throw new u("Header(s) " + header + " are controlled by the engine and cannot be set explicitly");
                    }
                    Iterator it = requestData.f4517g.iterator();
                    do {
                        eVar = (e) obj2;
                        if (!it.hasNext()) {
                            this.d = fVar;
                            this.e = requestData;
                            this.b = 1;
                            objA = AbstractC0561a.a(eVar, requestData, this);
                            if (objA != aVar) {
                            }
                            return aVar;
                        }
                        httpClientEngineCapability = (HttpClientEngineCapability) it.next();
                    } while (eVar.getSupportedCapabilities().contains(httpClientEngineCapability));
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return mVar;
                }
                q1.d dVar2 = (q1.d) this.e;
                fVar = (E1.f) this.d;
                kotlin.reflect.l.e0(obj);
                requestData = dVar2;
                objA = obj;
                q1.f responseData = (q1.f) objA;
                kotlin.jvm.internal.h.f(requestData, "requestData");
                kotlin.jvm.internal.h.f(responseData, "responseData");
                C0494b c0494b = new C0494b(fVar3);
                c0494b.b = new q1.a(c0494b, requestData);
                c0494b.c = new h1.f(c0494b, responseData);
                ByteReadChannel byteReadChannel = responseData.e;
                if (byteReadChannel == null) {
                    c0494b.c().getAttributes().put(C0494b.e, byteReadChannel);
                }
                r1.b bVarD = c0494b.d();
                vVar.d(AbstractC0809b.c);
                CoroutineContext coroutineContext = bVarD.getCoroutineContext();
                Job job = (Job) coroutineContext.get(Job.Key);
                if (job == null) {
                    throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
                }
                job.invokeOnCompletion(new C0477a(fVar3, bVarD));
                this.d = null;
                this.e = null;
                this.b = 2;
                if (fVar.d(c0494b, this) != aVar) {
                    return mVar;
                }
                return aVar;
            case 1:
                int i3 = this.b;
                if (i3 == 0) {
                    kotlin.reflect.l.e0(obj);
                    sender = (Sender) this.d;
                    cVar = (q1.c) this.e;
                    this.d = sender;
                    this.e = cVar;
                    this.b = 1;
                    objExecute = sender.execute(cVar, this);
                    if (objExecute != aVar) {
                    }
                    return aVar;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return obj;
                }
                cVar = (q1.c) this.e;
                sender = (Sender) this.d;
                kotlin.reflect.l.e0(obj);
                objExecute = obj;
                C0494b c0494b2 = (C0494b) objExecute;
                ((D) obj2).getClass();
                if (!E.f4036a.contains(c0494b2.c().getMethod())) {
                    return c0494b2;
                }
                C0632a c0632a = D.f4035a;
                this.d = null;
                this.e = null;
                this.b = 2;
                Object objA2 = C0632a.a(sender, cVar, c0494b2, fVar3, this);
                if (objA2 != aVar) {
                    return objA2;
                }
                return aVar;
            case 2:
                int i4 = this.b;
                if (i4 == 0) {
                    kotlin.reflect.l.e0(obj);
                    fVar2 = (E1.f) this.d;
                    Object obj6 = this.e;
                    if (obj6 instanceof v1.g) {
                        q1.c cVar3 = (q1.c) fVar2.f289a;
                        if (obj6 == null) {
                            cVar3.getClass();
                            cVar3.d = dVar;
                            KType kTypeA3 = w.a(v1.g.class);
                            cVar3.a(kotlin.reflect.l.i0(kotlin.reflect.l.F(kTypeA3), w.f3818a.b(v1.g.class), kTypeA3));
                        } else if (obj6 != null) {
                            cVar3.getClass();
                            kotlin.jvm.internal.h.f(obj6, "<set-?>");
                            cVar3.d = obj6;
                            cVar3.a(null);
                        } else {
                            cVar3.getClass();
                            kotlin.jvm.internal.h.f(obj6, "<set-?>");
                            cVar3.d = obj6;
                            KType kTypeA4 = w.a(v1.g.class);
                            cVar3.a(kotlin.reflect.l.i0(kotlin.reflect.l.F(kTypeA4), w.f3818a.b(v1.g.class), kTypeA4));
                        }
                        L l6 = (L) obj2;
                        l6.getClass();
                        Sender j6 = new J(fVar3);
                        ArrayList arrayList2 = l6.f4043a;
                        int iX = kotlin.collections.n.x(arrayList2);
                        C0429e c0429e = new C0429e(iX, E1.k.L(iX, 0, -1), -1);
                        while (c0429e.c) {
                            j6 = new K((Function3) arrayList2.get(c0429e.nextInt()), j6);
                        }
                        q1.c cVar4 = (q1.c) fVar2.f289a;
                        this.d = fVar2;
                        this.b = 1;
                        objExecute2 = j6.execute(cVar4, this);
                        if (objExecute2 != aVar) {
                        }
                        return aVar;
                    }
                    String str = "\n|Fail to prepare request body for sending. \n|The body type is: " + w.f3818a.b(obj6.getClass()) + ", with Content-Type: " + k1.j.e((HttpMessageBuilder) fVar2.f289a) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.";
                    kotlin.jvm.internal.h.f(str, "<this>");
                    if (kotlin.text.r.y("|")) {
                        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
                    }
                    List listN = kotlin.text.i.N(str);
                    int length = str.length();
                    listN.size();
                    int iX2 = kotlin.collections.n.x(listN);
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    for (Object obj7 : listN) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            kotlin.collections.n.C();
                            throw null;
                        }
                        String str2 = (String) obj7;
                        if ((i5 == 0 || i5 == iX2) && kotlin.text.r.y(str2)) {
                            str2 = null;
                        } else {
                            int length2 = str2.length();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= length2) {
                                    i7 = -1;
                                } else if (io.ktor.utils.io.jvm.javaio.q.m(str2.charAt(i7))) {
                                    i7++;
                                }
                            }
                            if (i7 != -1 && str2.startsWith("|", i7)) {
                                strSubstring = str2.substring(i7 + 1);
                                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                            } else {
                                strSubstring = null;
                            }
                            if (strSubstring != null) {
                                kotlin.text.j.f3950a.getClass();
                                str2 = strSubstring;
                            }
                        }
                        if (str2 != null) {
                            arrayList3.add(str2);
                        }
                        i5 = i6;
                    }
                    StringBuilder sb = new StringBuilder(length);
                    kotlin.collections.m.U(arrayList3, sb, "\n", null, null, null, 124);
                    String string = sb.toString();
                    kotlin.jvm.internal.h.e(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
                    throw new IllegalStateException(string.toString());
                }
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return mVar;
                }
                E1.f fVar5 = (E1.f) this.d;
                kotlin.reflect.l.e0(obj);
                fVar2 = fVar5;
                objExecute2 = obj;
                this.d = null;
                this.b = 2;
                if (fVar2.d((C0494b) objExecute2, this) != aVar) {
                    return mVar;
                }
                return aVar;
            default:
                int i8 = this.b;
                if (i8 != 0) {
                    if (i8 != 1 && i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return obj;
                }
                kotlin.reflect.l.e0(obj);
                Sender sender2 = (Sender) this.d;
                q1.c cVar5 = (q1.c) this.e;
                C0832A c0832a = cVar5.f4513a.f4879a;
                kotlin.jvm.internal.h.f(c0832a, "<this>");
                String str3 = c0832a.f4846a;
                if (str3.equals("ws") || str3.equals("wss")) {
                    this.d = null;
                    this.b = 1;
                    Object objExecute3 = sender2.execute(cVar5, this);
                    if (objExecute3 != aVar) {
                        return objExecute3;
                    }
                } else {
                    O o6 = P.d;
                    z1.a aVar2 = f.f3652a;
                    z1.f fVar6 = cVar5.f4514f;
                    Map map = (Map) fVar6.getOrNull(aVar2);
                    M m6 = (M) (map != null ? map.get(o6) : null);
                    P p5 = (P) obj2;
                    if (m6 == null && (p5.f4046a != null || p5.b != null || p5.c != null)) {
                        m6 = new M();
                        ((Map) fVar6.computeIfAbsent(aVar2, q1.b.f4512a)).put(o6, m6);
                    }
                    if (m6 != null) {
                        Long l7 = m6.b;
                        if (l7 == null) {
                            l7 = p5.b;
                        }
                        M.a(l7);
                        m6.b = l7;
                        Long l8 = m6.c;
                        if (l8 == null) {
                            l8 = p5.c;
                        }
                        M.a(l8);
                        m6.c = l8;
                        Long l9 = m6.f4044a;
                        if (l9 == null) {
                            l9 = p5.f4046a;
                        }
                        M.a(l9);
                        m6.f4044a = l9;
                        if (l9 == null) {
                            l9 = p5.f4046a;
                        }
                        if (l9 != null && l9.longValue() != LocationRequestCompat.PASSIVE_INTERVAL) {
                            cVar5.e.invokeOnCompletion(new C0019a(AbstractC0690y.g(fVar3, null, new N(l9, cVar5, cVar5.e, null), 3), 25));
                        }
                    }
                    this.d = null;
                    this.b = 2;
                    Object objExecute4 = sender2.execute(cVar5, this);
                    if (objExecute4 != aVar) {
                        return objExecute4;
                    }
                }
                return aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, g1.f fVar, Continuation continuation, int i) {
        super(3, continuation);
        this.f3649a = i;
        this.f3650f = obj;
        this.c = fVar;
    }
}
