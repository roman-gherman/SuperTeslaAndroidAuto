package y1;

import N1.m;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5134a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Charset c;
    public final /* synthetic */ g d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Charset charset, g gVar, Object obj, Continuation continuation) {
        super(2, continuation);
        this.c = charset;
        this.d = gVar;
        this.e = obj;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        f fVar = new f(this.c, this.d, this.e, continuation);
        fVar.b = obj;
        return fVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((f) create((OutputStream) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f5134a;
        if (i == 0) {
            l.e0(obj);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream) this.b, this.c);
            Object obj2 = this.e;
            h.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<*>");
            this.f5134a = 1;
            if (g.a(this.d, (Flow) obj2, outputStreamWriter, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.e0(obj);
        }
        return m.f1129a;
    }
}
