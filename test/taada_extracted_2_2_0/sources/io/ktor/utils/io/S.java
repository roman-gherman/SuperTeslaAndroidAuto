package io.ktor.utils.io;

import a.AbstractC0132a;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3525a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S(Object obj, int i) {
        super(1);
        this.f3525a = i;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        switch (this.f3525a) {
            case 0:
                Continuation ucont = (Continuation) obj;
                kotlin.jvm.internal.h.f(ucont, "ucont");
                int i = ((U) this.b).writeSuspensionSize;
                while (true) {
                    io.ktor.utils.io.internal.c cVarA = U.a((U) this.b);
                    if (cVarA != null) {
                        AbstractC0132a.b(cVarA.a());
                        throw null;
                    }
                    if (((U) this.b).k0(i)) {
                        U u = (U) this.b;
                        Continuation continuationJ = C5.f.J(ucont);
                        U u2 = (U) this.b;
                        while (((Continuation) u._writeOp) == null) {
                            if (!u2.k0(i)) {
                            }
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U.f3537n;
                            while (!atomicReferenceFieldUpdater.compareAndSet(u, null, continuationJ)) {
                                if (atomicReferenceFieldUpdater.get(u) != null) {
                                }
                                break;
                            }
                            if (!u2.k0(i)) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = U.f3537n;
                                while (!atomicReferenceFieldUpdater2.compareAndSet(u, continuationJ, null)) {
                                    if (atomicReferenceFieldUpdater2.get(u) != continuationJ) {
                                    }
                                }
                            }
                            break;
                        }
                        throw new IllegalStateException("Operation is already in progress");
                    }
                    ucont.resumeWith(N1.m.f1129a);
                }
                ((U) this.b).m(i);
                ((U) this.b).getClass();
                return T1.a.f1304a;
            case 1:
                Throwable th = (Throwable) obj;
                U u6 = (U) this.b;
                u6.attachedJob = null;
                if (th != null) {
                    Throwable th2 = th;
                    while (th2 instanceof CancellationException) {
                        if (th2.equals(th2.getCause())) {
                            u6.close(th);
                        } else {
                            Throwable cause = th2.getCause();
                            if (cause == null) {
                                th = th2;
                                u6.close(th);
                            } else {
                                th2 = cause;
                            }
                        }
                    }
                    th = th2;
                    u6.close(th);
                }
                return N1.m.f1129a;
            case 2:
                ((U) this.b).close((Throwable) obj);
                return N1.m.f1129a;
            default:
                ByteBuffer it = (ByteBuffer) obj;
                kotlin.jvm.internal.h.f(it, "it");
                if (it.get(it.position()) == 10) {
                    it.position(it.position() + 1);
                    ((kotlin.jvm.internal.s) this.b).f3814a = true;
                }
                return N1.m.f1129a;
        }
    }
}
