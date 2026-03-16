package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f3063a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final /* synthetic */ y[] e;

    static {
        y yVar = new y("ALLOW", 0);
        f3063a = yVar;
        y yVar2 = new y("INDECISIVE", 1);
        b = yVar2;
        y yVar3 = new y("BLOCK_INACCESSIBLE", 2);
        c = yVar3;
        y yVar4 = new y("BLOCK_ALL", 3);
        d = yVar4;
        e = new y[]{yVar, yVar2, yVar3, yVar4};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) e.clone();
    }
}
