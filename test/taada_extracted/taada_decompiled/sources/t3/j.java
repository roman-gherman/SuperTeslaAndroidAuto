package t3;

import m3.AbstractC0690y;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h {
    public final Runnable c;

    public j(Runnable runnable, long j6, i iVar) {
        super(j6, iVar);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.run();
        } finally {
            this.b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0690y.e(runnable));
        sb.append(", ");
        sb.append(this.f4833a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(']');
        return sb.toString();
    }
}
