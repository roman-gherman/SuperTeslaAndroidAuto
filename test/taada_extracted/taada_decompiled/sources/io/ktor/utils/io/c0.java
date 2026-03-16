package io.ktor.utils.io;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import m3.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements ReaderJob, WriterJob, Job {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f3562a;
    public final U b;

    public c0(s0 s0Var, U u) {
        this.f3562a = s0Var;
        this.b = u;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob child) {
        kotlin.jvm.internal.h.f(child, "child");
        return this.f3562a.attachChild(child);
    }

    @Override // kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        this.f3562a.cancel(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        kotlin.jvm.internal.h.f(operation, "operation");
        return kotlin.coroutines.a.a(this.f3562a, obj, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        kotlin.jvm.internal.h.f(key, "key");
        return kotlin.coroutines.a.b(this.f3562a, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        return this.f3562a.getCancellationException();
    }

    @Override // io.ktor.utils.io.WriterJob
    public final ByteReadChannel getChannel() {
        return this.b;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return this.f3562a.getChildren();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        return this.f3562a.getOnJoin();
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        return this.f3562a.getParent();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z6, boolean z7, Function1 handler) {
        kotlin.jvm.internal.h.f(handler, "handler");
        return this.f3562a.invokeOnCompletion(z6, z7, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isActive() {
        return this.f3562a.isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return this.f3562a.isCancelled();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return this.f3562a.isCompleted();
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation continuation) {
        return this.f3562a.join(continuation);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        kotlin.jvm.internal.h.f(key, "key");
        return kotlin.coroutines.a.c(this.f3562a, key);
    }

    @Override // kotlinx.coroutines.Job
    public final Job plus(Job other) {
        kotlin.jvm.internal.h.f(other, "other");
        return other;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return this.f3562a.start();
    }

    public final String toString() {
        return "ChannelJob[" + this.f3562a + ']';
    }

    @Override // kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) throws IllegalAccessException, InvocationTargetException {
        this.f3562a.cancel(th);
        return true;
    }

    @Override // io.ktor.utils.io.ReaderJob
    /* JADX INFO: renamed from: getChannel, reason: collision with other method in class */
    public final ByteWriteChannel mo97getChannel() {
        return this.b;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 handler) {
        kotlin.jvm.internal.h.f(handler, "handler");
        return this.f3562a.invokeOnCompletion(false, true, handler);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        kotlin.jvm.internal.h.f(context, "context");
        return kotlin.coroutines.a.d(this.f3562a, context);
    }

    @Override // kotlinx.coroutines.Job
    public final /* synthetic */ void cancel() throws IllegalAccessException, InvocationTargetException {
        this.f3562a.cancel((CancellationException) null);
    }
}
