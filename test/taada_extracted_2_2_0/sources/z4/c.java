package z4;

import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements KEMParameters {
    public static final c c = new c("ML-KEM-512", 2);
    public static final c d = new c("ML-KEM-768", 3);
    public static final c e = new c("ML-KEM-1024", 4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5212a;
    public final int b;

    public c(String str, int i) {
        this.f5212a = str;
        this.b = i;
    }
}
