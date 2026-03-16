package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class L {
    public static final L b;
    public static final L c;
    public static final L[] d;
    public static final Type[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ L[] f2836f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2837a;

    /* JADX INFO: Fake field, exist only in values array */
    L EF0;

    static {
        W w5 = W.DOUBLE;
        L l6 = new L("DOUBLE", 0, 0, 1, w5);
        W w6 = W.FLOAT;
        L l7 = new L("FLOAT", 1, 1, 1, w6);
        W w7 = W.LONG;
        L l8 = new L("INT64", 2, 2, 1, w7);
        L l9 = new L("UINT64", 3, 3, 1, w7);
        W w8 = W.INT;
        L l10 = new L("INT32", 4, 4, 1, w8);
        L l11 = new L("FIXED64", 5, 5, 1, w7);
        L l12 = new L("FIXED32", 6, 6, 1, w8);
        W w9 = W.BOOLEAN;
        L l13 = new L("BOOL", 7, 7, 1, w9);
        W w10 = W.STRING;
        L l14 = new L("STRING", 8, 8, 1, w10);
        W w11 = W.MESSAGE;
        L l15 = new L("MESSAGE", 9, 9, 1, w11);
        W w12 = W.BYTE_STRING;
        L l16 = new L("BYTES", 10, 10, 1, w12);
        L l17 = new L("UINT32", 11, 11, 1, w8);
        W w13 = W.ENUM;
        L l18 = new L("ENUM", 12, 12, 1, w13);
        L l19 = new L("SFIXED32", 13, 13, 1, w8);
        L l20 = new L("SFIXED64", 14, 14, 1, w7);
        L l21 = new L("SINT32", 15, 15, 1, w8);
        L l22 = new L("SINT64", 16, 16, 1, w7);
        L l23 = new L("GROUP", 17, 17, 1, w11);
        L l24 = new L("DOUBLE_LIST", 18, 18, 2, w5);
        L l25 = new L("FLOAT_LIST", 19, 19, 2, w6);
        L l26 = new L("INT64_LIST", 20, 20, 2, w7);
        L l27 = new L("UINT64_LIST", 21, 21, 2, w7);
        L l28 = new L("INT32_LIST", 22, 22, 2, w8);
        L l29 = new L("FIXED64_LIST", 23, 23, 2, w7);
        L l30 = new L("FIXED32_LIST", 24, 24, 2, w8);
        L l31 = new L("BOOL_LIST", 25, 25, 2, w9);
        L l32 = new L("STRING_LIST", 26, 26, 2, w10);
        L l33 = new L("MESSAGE_LIST", 27, 27, 2, w11);
        L l34 = new L("BYTES_LIST", 28, 28, 2, w12);
        L l35 = new L("UINT32_LIST", 29, 29, 2, w8);
        L l36 = new L("ENUM_LIST", 30, 30, 2, w13);
        L l37 = new L("SFIXED32_LIST", 31, 31, 2, w8);
        L l38 = new L("SFIXED64_LIST", 32, 32, 2, w7);
        L l39 = new L("SINT32_LIST", 33, 33, 2, w8);
        L l40 = new L("SINT64_LIST", 34, 34, 2, w7);
        L l41 = new L("DOUBLE_LIST_PACKED", 35, 35, 3, w5);
        b = l41;
        L l42 = new L("FLOAT_LIST_PACKED", 36, 36, 3, w6);
        L l43 = new L("INT64_LIST_PACKED", 37, 37, 3, w7);
        L l44 = new L("UINT64_LIST_PACKED", 38, 38, 3, w7);
        L l45 = new L("INT32_LIST_PACKED", 39, 39, 3, w8);
        L l46 = new L("FIXED64_LIST_PACKED", 40, 40, 3, w7);
        L l47 = new L("FIXED32_LIST_PACKED", 41, 41, 3, w8);
        L l48 = new L("BOOL_LIST_PACKED", 42, 42, 3, w9);
        L l49 = new L("UINT32_LIST_PACKED", 43, 43, 3, w8);
        L l50 = new L("ENUM_LIST_PACKED", 44, 44, 3, w13);
        L l51 = new L("SFIXED32_LIST_PACKED", 45, 45, 3, w8);
        L l52 = new L("SFIXED64_LIST_PACKED", 46, 46, 3, w7);
        L l53 = new L("SINT32_LIST_PACKED", 47, 47, 3, w8);
        L l54 = new L("SINT64_LIST_PACKED", 48, 48, 3, w7);
        c = l54;
        f2836f = new L[]{l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50, l51, l52, l53, l54, new L("GROUP_LIST", 49, 49, 2, w11), new L("MAP", 50, 50, 4, W.VOID)};
        e = new Type[0];
        L[] lArrValues = values();
        d = new L[lArrValues.length];
        for (L l55 : lArrValues) {
            d[l55.f2837a] = l55;
        }
    }

    public L(String str, int i, int i3, int i4, W w5) {
        this.f2837a = i3;
        int iB = f.s.b(i4);
        if (iB == 1 || iB == 3) {
            w5.getClass();
        }
        if (i4 == 1) {
            w5.ordinal();
        }
    }

    public static L valueOf(String str) {
        return (L) Enum.valueOf(L.class, str);
    }

    public static L[] values() {
        return (L[]) f2836f.clone();
    }
}
