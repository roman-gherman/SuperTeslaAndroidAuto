package x1;

import N1.m;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p3.h;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5108a;
    public final /* synthetic */ Charset b;
    public final /* synthetic */ F1.a c;
    public final /* synthetic */ ByteReadChannel d;

    public d(h hVar, Charset charset, F1.a aVar, ByteReadChannel byteReadChannel) {
        this.f5108a = hVar;
        this.b = charset;
        this.c = aVar;
        this.d = byteReadChannel;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.f5108a.collect(new c(flowCollector, this.b, this.c, this.d), continuation);
        return objCollect == T1.a.f1304a ? objCollect : m.f1129a;
    }
}
