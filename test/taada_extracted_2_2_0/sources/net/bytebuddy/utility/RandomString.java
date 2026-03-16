package net.bytebuddy.utility;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Random;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public class RandomString {
    public static final int DEFAULT_LENGTH = 8;
    private static final int KEY_BITS;
    private static final char[] SYMBOL;
    private final int length;
    private final Random random;

    static {
        StringBuilder sb = new StringBuilder();
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            sb.append(c);
        }
        for (char c6 = 'a'; c6 <= 'z'; c6 = (char) (c6 + 1)) {
            sb.append(c6);
        }
        for (char c7 = 'A'; c7 <= 'Z'; c7 = (char) (c7 + 1)) {
            sb.append(c7);
        }
        char[] charArray = sb.toString().toCharArray();
        SYMBOL = charArray;
        int iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(charArray.length);
        KEY_BITS = iNumberOfLeadingZeros - (Integer.bitCount(charArray.length) == iNumberOfLeadingZeros ? 0 : 1);
    }

    public RandomString() {
        this(8);
    }

    public static String hashOf(@MaybeNull Object obj) {
        int iIdentityHashCode;
        if (obj == null) {
            iIdentityHashCode = 0;
        } else {
            iIdentityHashCode = System.identityHashCode(obj) ^ obj.getClass().hashCode();
        }
        return hashOf(iIdentityHashCode);
    }

    public static String make() {
        return make(8);
    }

    @SuppressFBWarnings(justification = "Random value is used on each invocation.", value = {"DMI_RANDOM_USED_ONLY_ONCE"})
    public String nextString() {
        char[] cArr = new char[this.length];
        for (int i = 0; i < this.length; i++) {
            char[] cArr2 = SYMBOL;
            cArr[i] = cArr2[this.random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public RandomString(int i) {
        this(i, new Random());
    }

    public static String make(int i) {
        return new RandomString(i).nextString();
    }

    public RandomString(int i, Random random) {
        if (i > 0) {
            this.length = i;
            this.random = random;
            return;
        }
        throw new IllegalArgumentException("A random string's length cannot be zero or negative");
    }

    public static String hashOf(int i) {
        int i3 = KEY_BITS;
        int i4 = (32 / i3) + (32 % i3 == 0 ? 0 : 1);
        char[] cArr = new char[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            char[] cArr2 = SYMBOL;
            int i6 = KEY_BITS;
            cArr[i5] = cArr2[((-1) >>> (32 - i6)) & (i >>> (i5 * i6))];
        }
        return new String(cArr);
    }
}
