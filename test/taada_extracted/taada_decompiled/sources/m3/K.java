package m3;

import java.lang.reflect.InvocationTargetException;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K extends AbstractC0684s {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4108a;
    public boolean b;
    public kotlin.collections.i c;

    public final void a(boolean z6) {
        long j6 = this.f4108a - (z6 ? 4294967296L : 1L);
        this.f4108a = j6;
        if (j6 <= 0 && this.b) {
            shutdown();
        }
    }

    public final void b(F f6) {
        kotlin.collections.i iVar = this.c;
        if (iVar == null) {
            iVar = new kotlin.collections.i();
            this.c = iVar;
        }
        iVar.addLast(f6);
    }

    public final void c(boolean z6) {
        this.f4108a = (z6 ? 4294967296L : 1L) + this.f4108a;
        if (z6) {
            return;
        }
        this.b = true;
    }

    public abstract long d();

    public final boolean e() throws IllegalAccessException, InvocationTargetException {
        kotlin.collections.i iVar = this.c;
        if (iVar == null) {
            return false;
        }
        F f6 = (F) (iVar.isEmpty() ? null : iVar.removeFirst());
        if (f6 == null) {
            return false;
        }
        f6.run();
        return true;
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        AbstractC0800a.a(i);
        return this;
    }

    public abstract void shutdown();
}
