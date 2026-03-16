package n2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: n2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0709a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0709a f4226a;
    public static final EnumC0709a b;
    public static final EnumC0709a c;
    public static final EnumC0709a d;
    public static final /* synthetic */ EnumC0709a[] e;

    static {
        EnumC0709a enumC0709a = new EnumC0709a("DECLARATION", 0);
        f4226a = enumC0709a;
        EnumC0709a enumC0709a2 = new EnumC0709a("FAKE_OVERRIDE", 1);
        b = enumC0709a2;
        EnumC0709a enumC0709a3 = new EnumC0709a("DELEGATION", 2);
        c = enumC0709a3;
        EnumC0709a enumC0709a4 = new EnumC0709a("SYNTHESIZED", 3);
        d = enumC0709a4;
        e = new EnumC0709a[]{enumC0709a, enumC0709a2, enumC0709a3, enumC0709a4};
    }

    public static EnumC0709a valueOf(String str) {
        return (EnumC0709a) Enum.valueOf(EnumC0709a.class, str);
    }

    public static EnumC0709a[] values() {
        return (EnumC0709a[]) e.clone();
    }
}
