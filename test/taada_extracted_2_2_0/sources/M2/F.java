package M2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f1046a;
    public static final D b;
    public static final /* synthetic */ F[] c;

    static {
        E e = new E();
        f1046a = e;
        D d = new D();
        b = d;
        c = new F[]{e, d};
    }

    public static F valueOf(String str) {
        return (F) Enum.valueOf(F.class, str);
    }

    public static F[] values() {
        return (F[]) c.clone();
    }

    public abstract String a(String str);
}
