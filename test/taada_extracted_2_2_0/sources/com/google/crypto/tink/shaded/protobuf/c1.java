package com.google.crypto.tink.shaded.protobuf;

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
/* JADX INFO: loaded from: classes.dex */
public class c1 {
    public static final Y0 c;
    public static final Z0 d;
    public static final a1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ c1[] f2866f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f2867a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    c1 EF10;

    /* JADX INFO: Fake field, exist only in values array */
    c1 EF11;

    /* JADX INFO: Fake field, exist only in values array */
    c1 EF12;

    static {
        c1 c1Var = new c1("DOUBLE", 0, d1.DOUBLE, 1);
        c1 c1Var2 = new c1("FLOAT", 1, d1.FLOAT, 5);
        d1 d1Var = d1.LONG;
        c1 c1Var3 = new c1("INT64", 2, d1Var, 0);
        c1 c1Var4 = new c1("UINT64", 3, d1Var, 0);
        d1 d1Var2 = d1.INT;
        c1 c1Var5 = new c1("INT32", 4, d1Var2, 0);
        c1 c1Var6 = new c1("FIXED64", 5, d1Var, 1);
        c1 c1Var7 = new c1("FIXED32", 6, d1Var2, 5);
        c1 c1Var8 = new c1("BOOL", 7, d1.BOOLEAN, 0);
        Y0 y02 = new Y0("STRING", 8, d1.STRING, 2);
        c = y02;
        d1 d1Var3 = d1.MESSAGE;
        Z0 z02 = new Z0("GROUP", 9, d1Var3, 3);
        d = z02;
        a1 a1Var = new a1("MESSAGE", 10, d1Var3, 2);
        e = a1Var;
        f2866f = new c1[]{c1Var, c1Var2, c1Var3, c1Var4, c1Var5, c1Var6, c1Var7, c1Var8, y02, z02, a1Var, new b1("BYTES", 11, d1.BYTE_STRING, 2), new c1("UINT32", 12, d1Var2, 0), new c1("ENUM", 13, d1.ENUM, 0), new c1("SFIXED32", 14, d1Var2, 5), new c1("SFIXED64", 15, d1Var, 1), new c1("SINT32", 16, d1Var2, 0), new c1("SINT64", 17, d1Var, 0)};
    }

    public c1(String str, int i, d1 d1Var, int i3) {
        this.f2867a = d1Var;
        this.b = i3;
    }

    public static c1 valueOf(String str) {
        return (c1) Enum.valueOf(c1.class, str);
    }

    public static c1[] values() {
        return (c1[]) f2866f.clone();
    }
}
