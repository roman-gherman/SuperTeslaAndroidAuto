package r4;

import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: renamed from: r4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0806b implements KEMParameters {
    public static final C0806b d = new C0806b("mceliece348864", 12, 3488, 64, false);
    public static final C0806b e = new C0806b("mceliece348864f", 12, 3488, 64, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0806b f4731f = new C0806b("mceliece460896", 13, 4608, 96, false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0806b f4732g = new C0806b("mceliece460896f", 13, 4608, 96, true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0806b f4733h = new C0806b("mceliece6688128", 13, 6688, 128, false);
    public static final C0806b i = new C0806b("mceliece6688128f", 13, 6688, 128, true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0806b f4734j = new C0806b("mceliece6960119", 13, 6960, 119, false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0806b f4735k = new C0806b("mceliece6960119f", 13, 6960, 119, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0806b f4736l = new C0806b("mceliece8192128", 13, 8192, 128, false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0806b f4737m = new C0806b("mceliece8192128f", 13, 8192, 128, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4738a;
    public final int b;
    public final C0805a c;

    public C0806b(String str, int i3, int i4, int i5, boolean z6) {
        this.f4738a = str;
        this.b = i5;
        C0805a c0805a = new C0805a();
        c0805a.f4730j = z6;
        c0805a.f4726a = i4;
        c0805a.b = i5;
        c0805a.c = i3;
        c0805a.d = i5 * 2;
        int i6 = i5 * i3;
        c0805a.e = i6;
        c0805a.f4727f = i4 - i6;
        c0805a.f4728g = (1 << i3) - 1;
        c0805a.f4729h = i3 == 12 ? new e(0) : new e(1);
        c0805a.i = i5 % 8 != 0;
        this.c = c0805a;
    }
}
