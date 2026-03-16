package g4;

import java.math.BigInteger;

/* JADX INFO: renamed from: g4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0491a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f3339a;
    public final BigInteger b;
    public final BigInteger c;
    public final BigInteger d;
    public final BigInteger e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BigInteger f3340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3341g;

    public C0491a(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        a(bigIntegerArr, "v1");
        a(bigIntegerArr2, "v2");
        this.f3339a = bigIntegerArr[0];
        this.b = bigIntegerArr[1];
        this.c = bigIntegerArr2[0];
        this.d = bigIntegerArr2[1];
        this.e = bigInteger;
        this.f3340f = bigInteger2;
        this.f3341g = i;
    }

    public static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.q("'", str, "' must consist of exactly 2 (non-null) values"));
        }
    }
}
