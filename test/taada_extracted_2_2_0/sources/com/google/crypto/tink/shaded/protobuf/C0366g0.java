package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0366g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0364f0 f2879a;

    public C0366g0(Y0 y02, a1 a1Var, X0 x02) {
        this.f2879a = new C0364f0(y02, a1Var, x02);
    }

    public static int a(C0364f0 c0364f0, Object obj, Object obj2) {
        return K.a(c0364f0.b, 2, obj2) + K.a(c0364f0.f2878a, 1, obj);
    }

    public static void b(AbstractC0398x abstractC0398x, C0364f0 c0364f0, Object obj, Object obj2) {
        K.e(abstractC0398x, c0364f0.f2878a, 1, obj);
        K.e(abstractC0398x, c0364f0.b, 2, obj2);
    }
}
