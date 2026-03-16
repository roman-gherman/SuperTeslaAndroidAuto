package m2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: m2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0658j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0658j f4092a;
    public static final EnumC0658j b;
    public static final EnumC0658j c;
    public static final EnumC0658j d;
    public static final /* synthetic */ EnumC0658j[] e;

    static {
        EnumC0658j enumC0658j = new EnumC0658j("HIDDEN", 0);
        f4092a = enumC0658j;
        EnumC0658j enumC0658j2 = new EnumC0658j("VISIBLE", 1);
        b = enumC0658j2;
        EnumC0658j enumC0658j3 = new EnumC0658j("NOT_CONSIDERED", 2);
        c = enumC0658j3;
        EnumC0658j enumC0658j4 = new EnumC0658j("DROP", 3);
        d = enumC0658j4;
        e = new EnumC0658j[]{enumC0658j, enumC0658j2, enumC0658j3, enumC0658j4};
    }

    public static EnumC0658j valueOf(String str) {
        return (EnumC0658j) Enum.valueOf(EnumC0658j.class, str);
    }

    public static EnumC0658j[] values() {
        return (EnumC0658j[]) e.clone();
    }
}
