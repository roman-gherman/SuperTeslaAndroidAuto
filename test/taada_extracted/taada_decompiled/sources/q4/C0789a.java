package q4;

import D.d;
import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: renamed from: q4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0789a implements KEMParameters {
    public static final C0789a c = new C0789a("bike128", 12323);
    public static final C0789a d = new C0789a("bike192", 24659);
    public static final C0789a e = new C0789a("bike256", 40973);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4675a;
    public final int b;

    public C0789a(String str, int i) {
        this.f4675a = str;
        this.b = i;
        new d(i);
    }
}
