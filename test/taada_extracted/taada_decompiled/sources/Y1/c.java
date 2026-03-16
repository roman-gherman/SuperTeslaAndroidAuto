package y1;

import N1.j;
import N1.m;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.i;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteReadChannel f5130a;
    public final /* synthetic */ Charset b;
    public final /* synthetic */ g c;
    public final /* synthetic */ F1.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ByteReadChannel byteReadChannel, Charset charset, g gVar, F1.a aVar, Continuation continuation) {
        super(2, continuation);
        this.f5130a = byteReadChannel;
        this.b = charset;
        this.c = gVar;
        this.d = aVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new c(this.f5130a, this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        l.e0(obj);
        j jVar = io.ktor.utils.io.jvm.javaio.e.f3599a;
        ByteReadChannel byteReadChannel = this.f5130a;
        h.f(byteReadChannel, "<this>");
        return this.c.f5134a.c(new InputStreamReader(new i(null, byteReadChannel), this.b), new com.google.gson.reflect.a(this.d.b));
    }
}
