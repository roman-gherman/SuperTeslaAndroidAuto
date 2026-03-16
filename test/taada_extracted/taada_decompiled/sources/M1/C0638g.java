package m1;

import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;
import u1.C0832A;
import u1.C0835D;

/* JADX INFO: renamed from: m1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0638g extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ E1.f f4052a;
    public final /* synthetic */ C0639h b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0638g(C0639h c0639h, Continuation continuation) {
        super(3, continuation);
        this.b = c0639h;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C0638g c0638g = new C0638g(this.b, (Continuation) obj3);
        c0638g.f4052a = (E1.f) obj;
        N1.m mVar = N1.m.f1129a;
        c0638g.invokeSuspend(mVar);
        return mVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        kotlin.reflect.l.e0(obj);
        E1.f fVar = this.f4052a;
        String string = ((q1.c) fVar.f289a).f4512a.toString();
        C0637f c0637f = new C0637f();
        q1.c cVar = (q1.c) fVar.f289a;
        u1.m mVar = cVar.c;
        u1.m mVar2 = c0637f.f4051a;
        io.ktor.utils.io.jvm.javaio.q.b(mVar2, mVar);
        this.b.f4053a.invoke(c0637f);
        C0835D c0835dB = c0637f.b.b();
        C0632a c0632a = C0639h.b;
        u1.y yVar = cVar.f4512a;
        boolean zA = kotlin.jvm.internal.h.a(yVar.f4878a, C0832A.c);
        C0832A c0832a = c0835dB.f4848a;
        if (zA) {
            kotlin.jvm.internal.h.f(c0832a, "<set-?>");
            yVar.f4878a = c0832a;
        }
        if (yVar.b.length() <= 0) {
            u1.y yVar2 = new u1.y();
            kotlin.jvm.internal.h.f(c0832a, "<set-?>");
            yVar2.f4878a = c0832a;
            String str = c0835dB.b;
            kotlin.jvm.internal.h.f(str, "<set-?>");
            yVar2.b = str;
            int i = c0835dB.c;
            Integer numValueOf = Integer.valueOf(i);
            if (i == 0) {
                numValueOf = null;
            }
            yVar2.c = numValueOf != null ? numValueOf.intValue() : c0832a.b;
            io.ktor.utils.io.internal.t.o(yVar2, (String) c0835dB.f4852j.getValue());
            yVar2.e = (String) c0835dB.f4854l.getValue();
            yVar2.f4879f = (String) c0835dB.f4855m.getValue();
            u1.w wVarA = Z.a();
            wVarA.appendAll(b0.y((String) c0835dB.f4853k.getValue()));
            yVar2.i = wVarA;
            yVar2.f4882j = new A2.B(wVarA);
            String str2 = (String) c0835dB.f4856n.getValue();
            kotlin.jvm.internal.h.f(str2, "<set-?>");
            yVar2.f4880g = str2;
            yVar2.d = c0835dB.f4851h;
            C0832A c0832a2 = yVar.f4878a;
            kotlin.jvm.internal.h.f(c0832a2, "<set-?>");
            yVar2.f4878a = c0832a2;
            int i3 = yVar.c;
            if (i3 != 0) {
                yVar2.c = i3;
            }
            List list = yVar2.f4881h;
            List list2 = yVar.f4881h;
            if (!list2.isEmpty()) {
                if (list.isEmpty() || ((CharSequence) kotlin.collections.m.P(list2)).length() == 0) {
                    list = list2;
                } else {
                    P1.b bVar = new P1.b((list2.size() + list.size()) - 1);
                    int size = list.size() - 1;
                    for (int i4 = 0; i4 < size; i4++) {
                        bVar.add(list.get(i4));
                    }
                    bVar.addAll(list2);
                    Z.b(bVar);
                    list = bVar;
                }
            }
            kotlin.jvm.internal.h.f(list, "<set-?>");
            yVar2.f4881h = list;
            if (yVar.f4880g.length() > 0) {
                String str3 = yVar.f4880g;
                kotlin.jvm.internal.h.f(str3, "<set-?>");
                yVar2.f4880g = str3;
            }
            u1.w wVarA2 = Z.a();
            io.ktor.utils.io.jvm.javaio.q.b(wVarA2, yVar2.i);
            u1.w value = yVar.i;
            kotlin.jvm.internal.h.f(value, "value");
            yVar2.i = value;
            yVar2.f4882j = new A2.B(value);
            for (Map.Entry entry : wVarA2.entries()) {
                String str4 = (String) entry.getKey();
                List list3 = (List) entry.getValue();
                if (!yVar2.i.contains(str4)) {
                    yVar2.i.appendAll(str4, list3);
                }
            }
            io.ktor.utils.io.jvm.javaio.q.q(yVar, yVar2);
        }
        z1.f fVar2 = c0637f.c;
        for (z1.a aVar : fVar2.getAllKeys()) {
            if (!cVar.f4513f.contains(aVar)) {
                cVar.f4513f.put(aVar, fVar2.get(aVar));
            }
        }
        cVar.c.clear();
        cVar.c.appendAll(new u1.n((Map) mVar2.f4279a));
        Logger logger = AbstractC0640i.f4054a;
        StringBuilder sbM = B2.b.m("Applied DefaultRequest to ", string, ". New url: ");
        sbM.append(cVar.f4512a);
        logger.trace(sbM.toString());
        return N1.m.f1129a;
    }
}
