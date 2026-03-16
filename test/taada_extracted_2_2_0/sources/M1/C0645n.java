package m1;

import androidx.core.location.LocationRequestCompat;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.Z;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import m3.AbstractC0689x;

/* JADX INFO: renamed from: m1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0645n extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4060a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ r1.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0645n(Object obj, r1.b bVar, Continuation continuation) {
        super(2, continuation);
        this.c = obj;
        this.d = bVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0645n c0645n = new C0645n(this.c, this.d, continuation);
        c0645n.b = obj;
        return c0645n;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0645n) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4060a;
        r1.b bVar = this.d;
        try {
            if (i != 0) {
                try {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                } catch (Throwable th) {
                    r1.e.b(bVar);
                    throw th;
                }
            } else {
                kotlin.reflect.l.e0(obj);
                WriterScope writerScope = (WriterScope) this.b;
                ByteReadChannel byteReadChannel = (ByteReadChannel) this.c;
                ByteWriteChannel byteWriteChannelMo98getChannel = writerScope.mo98getChannel();
                this.f4060a = 1;
                if (Z.d(byteReadChannel, byteWriteChannelMo98getChannel, LocationRequestCompat.PASSIVE_INTERVAL, this) == aVar) {
                    return aVar;
                }
            }
            r1.e.b(bVar);
            return N1.m.f1129a;
        } catch (CancellationException e) {
            AbstractC0689x.b(bVar, e);
            throw e;
        } catch (Throwable th2) {
            CancellationException cancellationException = new CancellationException("Receive failed");
            cancellationException.initCause(th2);
            AbstractC0689x.b(bVar, cancellationException);
            throw th2;
        }
    }
}
