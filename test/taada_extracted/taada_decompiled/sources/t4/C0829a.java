package t4;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: renamed from: t4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0829a implements CipherParameters {
    public static final C0829a c = new C0829a("falcon-512", 9);
    public static final C0829a d = new C0829a("falcon-1024", 10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4841a;
    public final int b;

    public C0829a(String str, int i) {
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("Log N degree should be between 1 and 10");
        }
        this.f4841a = str;
        this.b = i;
    }
}
