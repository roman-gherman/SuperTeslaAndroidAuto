package i1;

import N1.m;
import U1.g;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;
import v1.i;

/* JADX INFO: renamed from: i1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0526a extends g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3462a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C0527b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0526a(C0527b c0527b, Continuation continuation) {
        super(2, continuation);
        this.c = c0527b;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0526a c0526a = new C0526a(this.c, continuation);
        c0526a.b = obj;
        return c0526a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0526a) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3462a;
        if (i == 0) {
            l.e0(obj);
            WriterScope writerScope = (WriterScope) this.b;
            i iVar = (i) this.c.f3463a;
            ByteWriteChannel byteWriteChannelMo98getChannel = writerScope.mo98getChannel();
            this.f3462a = 1;
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
