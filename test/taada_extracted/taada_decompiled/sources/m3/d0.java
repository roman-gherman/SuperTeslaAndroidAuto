package m3;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends o0 implements CompletableJob {
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Job job) {
        super(true);
        boolean z6 = true;
        s(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o0.b;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        C0675i c0675i = childHandle instanceof C0675i ? (C0675i) childHandle : null;
        if (c0675i == null) {
            z6 = false;
            break;
        }
        o0 o0VarF = c0675i.f();
        while (!o0VarF.m()) {
            ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(o0VarF);
            C0675i c0675i2 = childHandle2 instanceof C0675i ? (C0675i) childHandle2 : null;
            if (c0675i2 == null) {
                z6 = false;
                break;
            }
            o0VarF = c0675i2.f();
        }
        this.c = z6;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean complete() throws IllegalAccessException, InvocationTargetException {
        Object objE;
        N1.m mVar = N1.m.f1129a;
        do {
            objE = E(p(), mVar);
            if (objE == AbstractC0690y.d) {
                return false;
            }
            if (objE == AbstractC0690y.e) {
                return true;
            }
        } while (objE == AbstractC0690y.f4150f);
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean completeExceptionally(Throwable th) throws IllegalAccessException, InvocationTargetException {
        Object objE;
        C0677k c0677k = new C0677k(th, false);
        do {
            objE = E(p(), c0677k);
            if (objE == AbstractC0690y.d) {
                return false;
            }
            if (objE == AbstractC0690y.e) {
                return true;
            }
        } while (objE == AbstractC0690y.f4150f);
        return true;
    }

    @Override // m3.o0
    public final boolean m() {
        return this.c;
    }

    @Override // m3.o0
    public final boolean n() {
        return true;
    }
}
