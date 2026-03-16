package l1;

import N1.m;
import U1.g;
import androidx.core.location.LocationRequestCompat;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.V;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.b0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3960a;
    public final /* synthetic */ ByteChannel b;
    public final /* synthetic */ V c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ByteChannel byteChannel, V v6, Continuation continuation) {
        super(2, continuation);
        this.b = byteChannel;
        this.c = v6;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new c(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((c) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f3960a;
        ByteChannel byteChannel = this.b;
        try {
            if (i == 0) {
                l.e0(obj);
                V v6 = this.c;
                this.f3960a = 1;
                if (b0.g(byteChannel, v6, LocationRequestCompat.PASSIVE_INTERVAL, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
            }
        } catch (Throwable th) {
            byteChannel.cancel(th);
        }
        return m.f1129a;
    }
}
