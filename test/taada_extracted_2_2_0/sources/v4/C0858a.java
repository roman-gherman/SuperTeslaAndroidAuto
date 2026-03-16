package v4;

import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: renamed from: v4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0858a implements KEMParameters {
    public static final C0858a b = new C0858a("hqc-128", 384);
    public static final C0858a c = new C0858a("hqc-192", 640);
    public static final C0858a d = new C0858a("hqc-256", 640);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4955a;

    public C0858a(String str, int i) {
        this.f4955a = str;
        Math.ceil(i / 128);
    }
}
