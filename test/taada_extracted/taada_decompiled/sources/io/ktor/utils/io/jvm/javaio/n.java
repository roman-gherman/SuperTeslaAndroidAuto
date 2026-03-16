package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3609a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ ObjectPool d;
    public final /* synthetic */ InputStream e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ObjectPool objectPool, InputStream inputStream, Continuation continuation) {
        super(2, continuation);
        this.d = objectPool;
        this.e = inputStream;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        n nVar = new n(this.d, this.e, continuation);
        nVar.c = obj;
        return nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((n) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) throws IOException {
        byte[] bArr;
        WriterScope writerScope;
        T1.a aVar = T1.a.f1304a;
        int i = this.b;
        InputStream inputStream = this.e;
        ObjectPool objectPool = this.d;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            WriterScope writerScope2 = (WriterScope) this.c;
            bArr = (byte[]) objectPool.borrow();
            writerScope = writerScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bArr = this.f3609a;
            writerScope = (WriterScope) this.c;
            try {
                kotlin.reflect.l.e0(obj);
            } catch (Throwable th) {
                try {
                    writerScope.mo98getChannel().close(th);
                    objectPool.recycle(bArr);
                } catch (Throwable th2) {
                    objectPool.recycle(bArr);
                    inputStream.close();
                    throw th2;
                }
            }
        }
        while (true) {
            int i3 = inputStream.read(bArr, 0, bArr.length);
            if (i3 < 0) {
                objectPool.recycle(bArr);
                break;
            }
            if (i3 != 0) {
                ByteWriteChannel byteWriteChannelMo98getChannel = writerScope.mo98getChannel();
                this.c = writerScope;
                this.f3609a = bArr;
                this.b = 1;
                if (byteWriteChannelMo98getChannel.writeFully(bArr, 0, i3, this) == aVar) {
                    return aVar;
                }
            }
        }
        inputStream.close();
        return N1.m.f1129a;
    }
}
