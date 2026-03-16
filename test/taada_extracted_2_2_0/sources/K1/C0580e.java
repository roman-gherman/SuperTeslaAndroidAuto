package k1;

import N1.m;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;

/* JADX INFO: renamed from: k1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0580e extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3696a;
    public /* synthetic */ Object b;
    public final /* synthetic */ v1.g c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0580e(v1.g gVar, Continuation continuation) {
        super(2, continuation);
        this.c = gVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0580e c0580e = new C0580e(this.c, continuation);
        c0580e.b = obj;
        return c0580e;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0580e) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3696a;
        if (i == 0) {
            l.e0(obj);
            WriterScope writerScope = (WriterScope) this.b;
            v1.i iVar = (v1.i) this.c;
            ByteWriteChannel byteWriteChannelMo98getChannel = writerScope.mo98getChannel();
            this.f3696a = 1;
            if (iVar.d(byteWriteChannelMo98getChannel, this) == aVar) {
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
