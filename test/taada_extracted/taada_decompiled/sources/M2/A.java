package M2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f1043a;
    public static final A b;
    public static final /* synthetic */ A[] c;

    static {
        A a6 = new A("RENDER_OVERRIDE", 0);
        f1043a = a6;
        A a7 = new A("RENDER_OPEN", 1);
        b = a7;
        c = new A[]{a6, a7, new A("RENDER_OPEN_OVERRIDE", 2)};
    }

    public static A valueOf(String str) {
        return (A) Enum.valueOf(A.class, str);
    }

    public static A[] values() {
        return (A[]) c.clone();
    }
}
