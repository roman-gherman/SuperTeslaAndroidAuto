package x1;

import N1.m;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5110a;
    public final /* synthetic */ ByteReadChannel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ByteReadChannel byteReadChannel, Continuation continuation) {
        super(2, continuation);
        this.b = byteReadChannel;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        f fVar = new f(this.b, continuation);
        fVar.f5110a = obj;
        return fVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((f) create(obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        l.e0(obj);
        return Boolean.valueOf(this.f5110a != null || this.b.isClosedForRead());
    }
}
