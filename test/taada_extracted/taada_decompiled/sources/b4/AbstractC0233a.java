package b4;

import java.math.BigInteger;

/* JADX INFO: renamed from: b4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0233a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f1712a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);

    static {
        BigInteger.valueOf(3L);
    }

    public static void a(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'candidate' must be non-null and >= 2");
        }
    }
}
