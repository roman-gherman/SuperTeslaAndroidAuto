package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f3580a;
    public DisposableHandle b;
    public final /* synthetic */ b c;

    public a(b bVar, Job job) {
        this.c = bVar;
        this.f3580a = job;
        DisposableHandle disposableHandleInvokeOnCompletion = job.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, this);
        if (job.isActive()) {
            this.b = disposableHandleInvokeOnCompletion;
        }
    }

    public final void a() {
        DisposableHandle disposableHandle = this.b;
        if (disposableHandle != null) {
            this.b = null;
            disposableHandle.dispose();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable th = (Throwable) obj;
        b bVar = this.c;
        bVar.getClass();
        do {
            atomicReferenceFieldUpdater = b.b;
            if (atomicReferenceFieldUpdater.compareAndSet(bVar, this, null)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(bVar) == this);
        a();
        if (th != null) {
            b.a(bVar, this.f3580a, th);
        }
        return N1.m.f1129a;
    }
}
