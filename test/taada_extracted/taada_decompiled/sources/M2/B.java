package M2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f1044a;
    public static final B b;
    public static final B c;
    public static final /* synthetic */ B[] d;

    static {
        B b2 = new B("ALL", 0);
        f1044a = b2;
        B b6 = new B("ONLY_NON_SYNTHESIZED", 1);
        b = b6;
        B b7 = new B("NONE", 2);
        c = b7;
        d = new B[]{b2, b6, b7};
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) d.clone();
    }
}
