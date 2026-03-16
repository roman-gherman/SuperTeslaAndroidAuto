package q3;

import kotlinx.coroutines.flow.StateFlow;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends p3.u implements StateFlow {
    public y(int i) {
        super(Integer.MAX_VALUE, EnumC0743a.b);
        tryEmit(Integer.valueOf(i));
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.f4498g;
            kotlin.jvm.internal.h.c(objArr);
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.f4499h + ((long) ((int) ((k() + ((long) this.f4500j)) - this.f4499h)))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void r(int i) {
        synchronized (this) {
            Object[] objArr = this.f4498g;
            kotlin.jvm.internal.h.c(objArr);
            tryEmit(Integer.valueOf(((Number) objArr[((int) ((this.f4499h + ((long) ((int) ((k() + ((long) this.f4500j)) - this.f4499h)))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
