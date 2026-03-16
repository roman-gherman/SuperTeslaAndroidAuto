package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f2877a;
    public static final e1 b;
    public static final /* synthetic */ e1[] c;

    static {
        e1 e1Var = new e1("ASCENDING", 0);
        f2877a = e1Var;
        e1 e1Var2 = new e1("DESCENDING", 1);
        b = e1Var2;
        c = new e1[]{e1Var, e1Var2};
    }

    public static e1 valueOf(String str) {
        return (e1) Enum.valueOf(e1.class, str);
    }

    public static e1[] values() {
        return (e1[]) c.clone();
    }
}
