package d3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: d3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0418b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0418b f3119a;
    public static final /* synthetic */ EnumC0418b[] b;

    static {
        EnumC0418b enumC0418b = new EnumC0418b("FOR_SUBTYPING", 0);
        f3119a = enumC0418b;
        b = new EnumC0418b[]{enumC0418b, new EnumC0418b("FOR_INCORPORATION", 1), new EnumC0418b("FROM_EXPRESSION", 2)};
    }

    public static EnumC0418b valueOf(String str) {
        return (EnumC0418b) Enum.valueOf(EnumC0418b.class, str);
    }

    public static EnumC0418b[] values() {
        return (EnumC0418b[]) b.clone();
    }
}
