package M2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f1045a;
    public static final C b;
    public static final /* synthetic */ C[] c;

    /* JADX INFO: Fake field, exist only in values array */
    C EF0;

    static {
        C c6 = new C("PRETTY", 0);
        C c7 = new C("DEBUG", 1);
        f1045a = c7;
        C c8 = new C("NONE", 2);
        b = c8;
        c = new C[]{c6, c7, c8};
    }

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) c.clone();
    }
}
