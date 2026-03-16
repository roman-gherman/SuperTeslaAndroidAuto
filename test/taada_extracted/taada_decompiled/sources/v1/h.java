package v1;

import N1.m;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends U1.g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public io.ktor.utils.io.jvm.javaio.k f4928a;
    public int b;
    public final /* synthetic */ ByteWriteChannel c;
    public final /* synthetic */ i d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ByteWriteChannel byteWriteChannel, i iVar, Continuation continuation) {
        super(1, continuation);
        this.c = byteWriteChannel;
        this.d = iVar;
    }

    @Override // U1.a
    public final Continuation create(Continuation continuation) {
        return new h(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((h) create((Continuation) obj)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        io.ktor.utils.io.jvm.javaio.k kVar;
        T1.a aVar = T1.a.f1304a;
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = this.f4928a;
            try {
                l.e0(obj);
                C5.f.l(kVar, null);
                return m.f1129a;
            } catch (Throwable th) {
                th = th;
                try {
                    throw th;
                } catch (Throwable th2) {
                    C5.f.l(kVar, th);
                    throw th2;
                }
            }
        }
        l.e0(obj);
        N1.j jVar = io.ktor.utils.io.jvm.javaio.e.f3599a;
        ByteWriteChannel byteWriteChannel = this.c;
        kotlin.jvm.internal.h.f(byteWriteChannel, "<this>");
        io.ktor.utils.io.jvm.javaio.k kVar2 = new io.ktor.utils.io.jvm.javaio.k(byteWriteChannel);
        try {
            y1.f fVar = this.d.f4929a;
            this.f4928a = kVar2;
            this.b = 1;
            if (fVar.mo5invoke(kVar2, this) == aVar) {
                return aVar;
            }
            kVar = kVar2;
            C5.f.l(kVar, null);
            return m.f1129a;
        } catch (Throwable th3) {
            th = th3;
            kVar = kVar2;
            throw th;
        }
    }
}
