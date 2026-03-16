package n2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: n2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0711c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0711c f4228a;
    public static final EnumC0711c b;
    public static final EnumC0711c c;
    public static final EnumC0711c d;
    public static final EnumC0711c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0711c f4229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumC0711c[] f4230g;

    static {
        EnumC0711c enumC0711c = new EnumC0711c("CLASS", 0);
        f4228a = enumC0711c;
        EnumC0711c enumC0711c2 = new EnumC0711c("INTERFACE", 1);
        b = enumC0711c2;
        EnumC0711c enumC0711c3 = new EnumC0711c("ENUM_CLASS", 2);
        c = enumC0711c3;
        EnumC0711c enumC0711c4 = new EnumC0711c("ENUM_ENTRY", 3);
        d = enumC0711c4;
        EnumC0711c enumC0711c5 = new EnumC0711c("ANNOTATION_CLASS", 4);
        e = enumC0711c5;
        EnumC0711c enumC0711c6 = new EnumC0711c("OBJECT", 5);
        f4229f = enumC0711c6;
        f4230g = new EnumC0711c[]{enumC0711c, enumC0711c2, enumC0711c3, enumC0711c4, enumC0711c5, enumC0711c6};
    }

    public static EnumC0711c valueOf(String str) {
        return (EnumC0711c) Enum.valueOf(EnumC0711c.class, str);
    }

    public static EnumC0711c[] values() {
        return (EnumC0711c[]) f4230g.clone();
    }

    public final boolean a() {
        return this == f4229f || this == d;
    }
}
