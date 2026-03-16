package g1;

import N1.m;
import io.ktor.client.plugins.Sender;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import m1.v;

/* JADX INFO: renamed from: g1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0478b extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3289a;
    public int b;
    public /* synthetic */ Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0478b(Object obj, Continuation continuation, int i) {
        super(3, continuation);
        this.f3289a = i;
        this.e = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f3289a) {
            case 0:
                C0478b c0478b = new C0478b((f) this.e, (Continuation) obj3, 0);
                c0478b.d = (E1.f) obj;
                c0478b.c = obj2;
                return c0478b.invokeSuspend(m.f1129a);
            case 1:
                C0478b c0478b2 = new C0478b((v) this.e, (Continuation) obj3, 1);
                c0478b2.c = (E1.f) obj;
                c0478b2.d = obj2;
                return c0478b2.invokeSuspend(m.f1129a);
            case 2:
                C0478b c0478b3 = new C0478b((v) this.e, (Continuation) obj3, 2);
                c0478b3.c = (E1.f) obj;
                c0478b3.d = (r1.c) obj2;
                return c0478b3.invokeSuspend(m.f1129a);
            case 3:
                C0478b c0478b4 = new C0478b((v) this.e, (Continuation) obj3, 3);
                c0478b4.c = (Sender) obj;
                c0478b4.d = (q1.c) obj2;
                return c0478b4.invokeSuspend(m.f1129a);
            default:
                C0478b c0478b5 = new C0478b((o1.g) this.e, (Continuation) obj3, 4);
                c0478b5.d = (E1.f) obj;
                c0478b5.c = (r1.c) obj2;
                return c0478b5.invokeSuspend(m.f1129a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    @Override // U1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.C0478b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
