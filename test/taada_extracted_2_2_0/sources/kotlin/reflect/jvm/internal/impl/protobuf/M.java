package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF12' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public class M {
    public static final M c;
    public static final M d;
    public static final J e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final K f3849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final M f3850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ M[] f3851h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f3852a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    M EF10;

    /* JADX INFO: Fake field, exist only in values array */
    M EF11;

    /* JADX INFO: Fake field, exist only in values array */
    M EF12;

    static {
        M m6 = new M("DOUBLE", 0, N.DOUBLE, 1);
        M m7 = new M("FLOAT", 1, N.FLOAT, 5);
        N n6 = N.LONG;
        M m8 = new M("INT64", 2, n6, 0);
        M m9 = new M("UINT64", 3, n6, 0);
        N n7 = N.INT;
        M m10 = new M("INT32", 4, n7, 0);
        c = m10;
        M m11 = new M("FIXED64", 5, n6, 1);
        M m12 = new M("FIXED32", 6, n7, 5);
        M m13 = new M("BOOL", 7, N.BOOLEAN, 0);
        d = m13;
        I i = new I("STRING", 8, N.STRING, 2);
        N n8 = N.MESSAGE;
        J j6 = new J("GROUP", 9, n8, 3);
        e = j6;
        K k6 = new K("MESSAGE", 10, n8, 2);
        f3849f = k6;
        L l6 = new L("BYTES", 11, N.BYTE_STRING, 2);
        M m14 = new M("UINT32", 12, n7, 0);
        M m15 = new M("ENUM", 13, N.ENUM, 0);
        f3850g = m15;
        f3851h = new M[]{m6, m7, m8, m9, m10, m11, m12, m13, i, j6, k6, l6, m14, m15, new M("SFIXED32", 14, n7, 5), new M("SFIXED64", 15, n6, 1), new M("SINT32", 16, n7, 0), new M("SINT64", 17, n6, 0)};
    }

    public M(String str, int i, N n6, int i3) {
        this.f3852a = n6;
        this.b = i3;
    }

    public static M valueOf(String str) {
        return (M) Enum.valueOf(M.class, str);
    }

    public static M[] values() {
        return (M[]) f3851h.clone();
    }

    public boolean a() {
        return !(this instanceof I);
    }
}
