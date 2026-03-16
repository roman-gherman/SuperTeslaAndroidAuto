package m3;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f4145a = new ThreadLocal();

    public static K a() {
        ThreadLocal threadLocal = f4145a;
        K k6 = (K) threadLocal.get();
        if (k6 != null) {
            return k6;
        }
        C0670d c0670d = new C0670d(Thread.currentThread());
        threadLocal.set(c0670d);
        return c0670d;
    }
}
