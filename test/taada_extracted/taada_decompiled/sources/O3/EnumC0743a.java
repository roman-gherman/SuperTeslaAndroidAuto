package o3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: o3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0743a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0743a f4320a;
    public static final EnumC0743a b;
    public static final EnumC0743a c;
    public static final /* synthetic */ EnumC0743a[] d;

    static {
        EnumC0743a enumC0743a = new EnumC0743a("SUSPEND", 0);
        f4320a = enumC0743a;
        EnumC0743a enumC0743a2 = new EnumC0743a("DROP_OLDEST", 1);
        b = enumC0743a2;
        EnumC0743a enumC0743a3 = new EnumC0743a("DROP_LATEST", 2);
        c = enumC0743a3;
        d = new EnumC0743a[]{enumC0743a, enumC0743a2, enumC0743a3};
    }

    public static EnumC0743a valueOf(String str) {
        return (EnumC0743a) Enum.valueOf(EnumC0743a.class, str);
    }

    public static EnumC0743a[] values() {
        return (EnumC0743a[]) d.clone();
    }
}
