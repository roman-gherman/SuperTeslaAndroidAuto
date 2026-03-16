package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class W0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W0 f2859a;
    public static final W0 b;
    public static final W0 c;
    public static final W0 d;
    public static final W0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final W0 f2860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final W0 f2861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ W0[] f2862h;

    static {
        W0 w02 = new W0("NULL_VALUE", 0);
        f2859a = w02;
        W0 w03 = new W0("NUMBER_VALUE", 1);
        b = w03;
        W0 w04 = new W0("STRING_VALUE", 2);
        c = w04;
        W0 w05 = new W0("BOOL_VALUE", 3);
        d = w05;
        W0 w06 = new W0("STRUCT_VALUE", 4);
        e = w06;
        W0 w07 = new W0("LIST_VALUE", 5);
        f2860f = w07;
        W0 w08 = new W0("KIND_NOT_SET", 6);
        f2861g = w08;
        f2862h = new W0[]{w02, w03, w04, w05, w06, w07, w08};
    }

    public static W0 valueOf(String str) {
        return (W0) Enum.valueOf(W0.class, str);
    }

    public static W0[] values() {
        return (W0[]) f2862h.clone();
    }
}
