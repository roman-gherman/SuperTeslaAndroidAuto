package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0391t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0391t0 f2916a;
    public static final EnumC0391t0 b;
    public static final /* synthetic */ EnumC0391t0[] c;

    static {
        EnumC0391t0 enumC0391t0 = new EnumC0391t0("PROTO2", 0);
        f2916a = enumC0391t0;
        EnumC0391t0 enumC0391t02 = new EnumC0391t0("PROTO3", 1);
        b = enumC0391t02;
        c = new EnumC0391t0[]{enumC0391t0, enumC0391t02};
    }

    public static EnumC0391t0 valueOf(String str) {
        return (EnumC0391t0) Enum.valueOf(EnumC0391t0.class, str);
    }

    public static EnumC0391t0[] values() {
        return (EnumC0391t0[]) c.clone();
    }
}
