package o3;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import m3.AbstractC0665a;
import m3.C0668b0;
import m3.o0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends AbstractC0665a implements Channel {
    public final n d;

    public r(CoroutineContext coroutineContext, n nVar) {
        super(coroutineContext, true);
        this.d = nVar;
    }

    @Override // m3.o0, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new C0668b0(g(), null, this);
        }
        e(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        return this.d.f(th, false);
    }

    @Override // m3.o0
    public final void e(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        CancellationException cancellationExceptionD = o0.D(this, cancellationException);
        this.d.f(cancellationExceptionD, true);
        d(cancellationExceptionD);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        return this.d.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveCatching() {
        return this.d.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveOrNull() {
        return this.d.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        return this.d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 function1) {
        this.d.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return this.d.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        n nVar = this.d;
        nVar.getClass();
        return new C0744b(nVar);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(Object obj) {
        return this.d.offer(obj);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object poll() {
        return this.d.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) {
        return this.d.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo104receiveCatchingJP2dKIU(Continuation continuation) {
        n nVar = this.d;
        nVar.getClass();
        return n.v(nVar, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveOrNull(Continuation continuation) {
        n nVar = this.d;
        nVar.getClass();
        return k1.j.m(nVar, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) {
        return this.d.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo105tryReceivePtdJZtk() {
        return this.d.mo105tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo106trySendJP2dKIU(Object obj) {
        return this.d.mo106trySendJP2dKIU(obj);
    }

    @Override // m3.o0, kotlinx.coroutines.Job
    public final /* synthetic */ void cancel() throws IllegalAccessException, InvocationTargetException {
        e(new C0668b0(g(), null, this));
    }

    @Override // m3.o0, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) throws IllegalAccessException, InvocationTargetException {
        e(new C0668b0(g(), null, this));
        return true;
    }
}
