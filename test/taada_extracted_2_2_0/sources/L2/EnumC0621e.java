package l2;

import k2.p;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: l2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0621e {
    public static final n0.d c;
    public static final EnumC0621e d;
    public static final EnumC0621e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0621e f3971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC0621e f3972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC0621e[] f3973h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.c f3974a;
    public final String b;

    static {
        EnumC0621e enumC0621e = new EnumC0621e("Function", 0, p.f3768k, "Function");
        d = enumC0621e;
        EnumC0621e enumC0621e2 = new EnumC0621e("SuspendFunction", 1, p.e, "SuspendFunction");
        e = enumC0621e2;
        L2.c cVar = p.f3766h;
        EnumC0621e enumC0621e3 = new EnumC0621e("KFunction", 2, cVar, "KFunction");
        f3971f = enumC0621e3;
        EnumC0621e enumC0621e4 = new EnumC0621e("KSuspendFunction", 3, cVar, "KSuspendFunction");
        f3972g = enumC0621e4;
        f3973h = new EnumC0621e[]{enumC0621e, enumC0621e2, enumC0621e3, enumC0621e4};
        c = new n0.d(9);
    }

    public EnumC0621e(String str, int i, L2.c cVar, String str2) {
        this.f3974a = cVar;
        this.b = str2;
    }

    public static EnumC0621e valueOf(String str) {
        return (EnumC0621e) Enum.valueOf(EnumC0621e.class, str);
    }

    public static EnumC0621e[] values() {
        return (EnumC0621e[]) f3973h.clone();
    }

    public final L2.f a(int i) {
        return L2.f.e(this.b + i);
    }
}
