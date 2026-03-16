package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0386q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NewInstanceSchema f2908a;
    public static final C0384p0 b;

    static {
        NewInstanceSchema newInstanceSchema;
        try {
            newInstanceSchema = (NewInstanceSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            newInstanceSchema = null;
        }
        f2908a = newInstanceSchema;
        b = new C0384p0();
    }
}
