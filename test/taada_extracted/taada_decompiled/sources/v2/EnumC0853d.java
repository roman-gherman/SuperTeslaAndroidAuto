package v2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: v2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0853d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0853d f4938a;
    public static final EnumC0853d b;
    public static final /* synthetic */ EnumC0853d[] c;

    static {
        EnumC0853d enumC0853d = new EnumC0853d("PACKAGE", 0);
        f4938a = enumC0853d;
        EnumC0853d enumC0853d2 = new EnumC0853d("CLASSIFIER", 1);
        b = enumC0853d2;
        c = new EnumC0853d[]{enumC0853d, enumC0853d2};
    }

    public static EnumC0853d valueOf(String str) {
        return (EnumC0853d) Enum.valueOf(EnumC0853d.class, str);
    }

    public static EnumC0853d[] values() {
        return (EnumC0853d[]) c.clone();
    }
}
