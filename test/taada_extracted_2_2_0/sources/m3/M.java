package m3;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends N {
    public final Runnable c;

    public M(long j6, Runnable runnable) {
        super(j6);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }

    @Override // m3.N
    public final String toString() {
        return super.toString() + this.c;
    }
}
