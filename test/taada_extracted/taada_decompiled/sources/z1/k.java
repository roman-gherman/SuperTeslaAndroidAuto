package z1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f5179a;

    static {
        String property = System.getProperty("io.ktor.development");
        boolean z6 = false;
        if (property != null && Boolean.parseBoolean(property)) {
            z6 = true;
        }
        f5179a = z6;
    }
}
