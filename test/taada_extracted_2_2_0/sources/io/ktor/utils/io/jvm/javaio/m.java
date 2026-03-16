package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f3609a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ K1.c d;
    public final /* synthetic */ BufferedInputStream e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(K1.c cVar, BufferedInputStream bufferedInputStream, Continuation continuation) {
        super(2, continuation);
        this.d = cVar;
        this.e = bufferedInputStream;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        m mVar = new m(this.d, this.e, continuation);
        mVar.c = obj;
        return mVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((m) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) throws IOException {
        ByteBuffer byteBuffer;
        WriterScope writerScope;
        T1.a aVar = T1.a.f1304a;
        int i = this.b;
        BufferedInputStream bufferedInputStream = this.e;
        K1.c cVar = this.d;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            WriterScope writerScope2 = (WriterScope) this.c;
            byteBuffer = (ByteBuffer) cVar.borrow();
            writerScope = writerScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteBuffer = this.f3609a;
            writerScope = (WriterScope) this.c;
            try {
                kotlin.reflect.l.e0(obj);
            } finally {
                try {
                } finally {
                }
            }
        }
        while (true) {
            byteBuffer.clear();
            int i3 = bufferedInputStream.read(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            if (i3 < 0) {
                break;
            }
            if (i3 != 0) {
                byteBuffer.position(byteBuffer.position() + i3);
                byteBuffer.flip();
                ByteWriteChannel byteWriteChannelMo98getChannel = writerScope.mo98getChannel();
                this.c = writerScope;
                this.f3609a = byteBuffer;
                this.b = 1;
                if (byteWriteChannelMo98getChannel.writeFully(byteBuffer, this) == aVar) {
                    return aVar;
                }
            }
        }
        return N1.m.f1129a;
    }
}
