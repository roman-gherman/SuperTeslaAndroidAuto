package W1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1391a;
    public static final /* synthetic */ d[] b;

    static {
        d dVar = new d("LANGUAGE_VERSION", 0);
        f1391a = dVar;
        b = new d[]{dVar, new d("COMPILER_VERSION", 1), new d("API_VERSION", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) b.clone();
    }
}
