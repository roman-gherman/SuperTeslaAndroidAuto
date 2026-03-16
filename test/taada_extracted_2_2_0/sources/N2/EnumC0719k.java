package n2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: n2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0719k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0719k f4248a;
    public static final EnumC0719k b;
    public static final EnumC0719k c;
    public static final EnumC0719k d;
    public static final /* synthetic */ EnumC0719k[] e;

    static {
        EnumC0719k enumC0719k = new EnumC0719k("FINAL", 0);
        f4248a = enumC0719k;
        EnumC0719k enumC0719k2 = new EnumC0719k("SEALED", 1);
        b = enumC0719k2;
        EnumC0719k enumC0719k3 = new EnumC0719k("OPEN", 2);
        c = enumC0719k3;
        EnumC0719k enumC0719k4 = new EnumC0719k("ABSTRACT", 3);
        d = enumC0719k4;
        e = new EnumC0719k[]{enumC0719k, enumC0719k2, enumC0719k3, enumC0719k4};
    }

    public static EnumC0719k valueOf(String str) {
        return (EnumC0719k) Enum.valueOf(EnumC0719k.class, str);
    }

    public static EnumC0719k[] values() {
        return (EnumC0719k[]) e.clone();
    }
}
