package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF3' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class G1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ G1[] f2029a;

    /* JADX INFO: Fake field, exist only in values array */
    G1 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    G1 EF2;

    /* JADX INFO: Fake field, exist only in values array */
    G1 EF3;

    static {
        G1 g12 = new G1("DOUBLE", 0, H1.d);
        G1 g13 = new G1("FLOAT", 1, H1.c);
        H1 h12 = H1.b;
        G1 g14 = new G1("INT64", 2, h12);
        G1 g15 = new G1("UINT64", 3, h12);
        H1 h13 = H1.f2031a;
        G1 g16 = new G1("INT32", 4, h13);
        G1 g17 = new G1("FIXED64", 5, h12);
        G1 g18 = new G1("FIXED32", 6, h13);
        G1 g19 = new G1("BOOL", 7, H1.e);
        G1 g110 = new G1("STRING", 8, H1.f2032f);
        H1 h14 = H1.i;
        f2029a = new G1[]{g12, g13, g14, g15, g16, g17, g18, g19, g110, new G1("GROUP", 9, h14), new G1("MESSAGE", 10, h14), new G1("BYTES", 11, H1.f2033g), new G1("UINT32", 12, h13), new G1("ENUM", 13, H1.f2034h), new G1("SFIXED32", 14, h13), new G1("SFIXED64", 15, h12), new G1("SINT32", 16, h13), new G1("SINT64", 17, h12)};
    }

    public G1(String str, int i, H1 h12) {
    }

    public static G1[] values() {
        return (G1[]) f2029a.clone();
    }
}
