package D2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f252a;
    public static final f b;
    public static final /* synthetic */ f[] c;

    static {
        f fVar = new f("READ_ONLY", 0);
        f252a = fVar;
        f fVar2 = new f("MUTABLE", 1);
        b = fVar2;
        c = new f[]{fVar, fVar2};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) c.clone();
    }
}
