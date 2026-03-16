package org.mockito;

import org.mockito.internal.matchers.ArrayEquals;
import org.mockito.internal.matchers.CompareEqual;
import org.mockito.internal.matchers.EqualsWithDelta;
import org.mockito.internal.matchers.Find;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.internal.matchers.LessOrEqual;
import org.mockito.internal.matchers.LessThan;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

/* JADX INFO: loaded from: classes.dex */
public final class AdditionalMatchers {
    private AdditionalMatchers() {
    }

    public static boolean and(boolean z6, boolean z7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return false;
    }

    public static <T> T[] aryEq(T[] tArr) {
        reportMatcher(new ArrayEquals(tArr));
        return null;
    }

    public static <T extends Comparable<T>> T cmpEq(T t6) {
        reportMatcher(new CompareEqual(t6));
        return null;
    }

    public static double eq(double d, double d6) {
        reportMatcher(new EqualsWithDelta(Double.valueOf(d), Double.valueOf(d6)));
        return 0.0d;
    }

    public static String find(String str) {
        reportMatcher(new Find(str));
        return null;
    }

    public static <T extends Comparable<T>> T geq(T t6) {
        reportMatcher(new GreaterOrEqual(t6));
        return null;
    }

    public static <T extends Comparable<T>> T gt(T t6) {
        reportMatcher(new GreaterThan(t6));
        return null;
    }

    public static <T extends Comparable<T>> T leq(T t6) {
        reportMatcher(new LessOrEqual(t6));
        return null;
    }

    public static <T extends Comparable<T>> T lt(T t6) {
        reportMatcher(new LessThan(t6));
        return null;
    }

    public static <T> T not(T t6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return null;
    }

    public static boolean or(boolean z6, boolean z7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return false;
    }

    private static void reportMatcher(ArgumentMatcher<?> argumentMatcher) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportMatcher(argumentMatcher);
    }

    public static byte and(byte b, byte b2) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return (byte) 0;
    }

    public static short[] aryEq(short[] sArr) {
        reportMatcher(new ArrayEquals(sArr));
        return null;
    }

    public static float eq(float f6, float f7) {
        reportMatcher(new EqualsWithDelta(Float.valueOf(f6), Float.valueOf(f7)));
        return 0.0f;
    }

    public static byte geq(byte b) {
        reportMatcher(new GreaterOrEqual(Byte.valueOf(b)));
        return (byte) 0;
    }

    public static byte gt(byte b) {
        reportMatcher(new GreaterThan(Byte.valueOf(b)));
        return (byte) 0;
    }

    public static byte leq(byte b) {
        reportMatcher(new LessOrEqual(Byte.valueOf(b)));
        return (byte) 0;
    }

    public static byte lt(byte b) {
        reportMatcher(new LessThan(Byte.valueOf(b)));
        return (byte) 0;
    }

    public static short not(short s3) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return (short) 0;
    }

    public static <T> T or(T t6, T t7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return null;
    }

    public static char and(char c, char c6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return (char) 0;
    }

    public static long[] aryEq(long[] jArr) {
        reportMatcher(new ArrayEquals(jArr));
        return null;
    }

    public static double geq(double d) {
        reportMatcher(new GreaterOrEqual(Double.valueOf(d)));
        return 0.0d;
    }

    public static double gt(double d) {
        reportMatcher(new GreaterThan(Double.valueOf(d)));
        return 0.0d;
    }

    public static double leq(double d) {
        reportMatcher(new LessOrEqual(Double.valueOf(d)));
        return 0.0d;
    }

    public static double lt(double d) {
        reportMatcher(new LessThan(Double.valueOf(d)));
        return 0.0d;
    }

    public static int not(int i) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static short or(short s3, short s6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return (short) 0;
    }

    public static double and(double d, double d6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0.0d;
    }

    public static int[] aryEq(int[] iArr) {
        reportMatcher(new ArrayEquals(iArr));
        return null;
    }

    public static float geq(float f6) {
        reportMatcher(new GreaterOrEqual(Float.valueOf(f6)));
        return 0.0f;
    }

    public static float gt(float f6) {
        reportMatcher(new GreaterThan(Float.valueOf(f6)));
        return 0.0f;
    }

    public static float leq(float f6) {
        reportMatcher(new LessOrEqual(Float.valueOf(f6)));
        return 0.0f;
    }

    public static float lt(float f6) {
        reportMatcher(new LessThan(Float.valueOf(f6)));
        return 0.0f;
    }

    public static long not(long j6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0L;
    }

    public static long or(long j6, long j7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0L;
    }

    public static float and(float f6, float f7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0.0f;
    }

    public static float[] aryEq(float[] fArr) {
        reportMatcher(new ArrayEquals(fArr));
        return null;
    }

    public static int geq(int i) {
        reportMatcher(new GreaterOrEqual(Integer.valueOf(i)));
        return 0;
    }

    public static int gt(int i) {
        reportMatcher(new GreaterThan(Integer.valueOf(i)));
        return 0;
    }

    public static int leq(int i) {
        reportMatcher(new LessOrEqual(Integer.valueOf(i)));
        return 0;
    }

    public static int lt(int i) {
        reportMatcher(new LessThan(Integer.valueOf(i)));
        return 0;
    }

    public static float not(float f6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0.0f;
    }

    public static int or(int i, int i3) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }

    public static int and(int i, int i3) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static double[] aryEq(double[] dArr) {
        reportMatcher(new ArrayEquals(dArr));
        return null;
    }

    public static long geq(long j6) {
        reportMatcher(new GreaterOrEqual(Long.valueOf(j6)));
        return 0L;
    }

    public static long gt(long j6) {
        reportMatcher(new GreaterThan(Long.valueOf(j6)));
        return 0L;
    }

    public static long leq(long j6) {
        reportMatcher(new LessOrEqual(Long.valueOf(j6)));
        return 0L;
    }

    public static long lt(long j6) {
        reportMatcher(new LessThan(Long.valueOf(j6)));
        return 0L;
    }

    public static double not(double d) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0.0d;
    }

    public static float or(float f6, float f7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0.0f;
    }

    public static long and(long j6, long j7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0L;
    }

    public static char[] aryEq(char[] cArr) {
        reportMatcher(new ArrayEquals(cArr));
        return null;
    }

    public static short geq(short s3) {
        reportMatcher(new GreaterOrEqual(Short.valueOf(s3)));
        return (short) 0;
    }

    public static short gt(short s3) {
        reportMatcher(new GreaterThan(Short.valueOf(s3)));
        return (short) 0;
    }

    public static short leq(short s3) {
        reportMatcher(new LessOrEqual(Short.valueOf(s3)));
        return (short) 0;
    }

    public static short lt(short s3) {
        reportMatcher(new LessThan(Short.valueOf(s3)));
        return (short) 0;
    }

    public static char not(char c) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return (char) 0;
    }

    public static double or(double d, double d6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0.0d;
    }

    public static short and(short s3, short s6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return (short) 0;
    }

    public static byte[] aryEq(byte[] bArr) {
        reportMatcher(new ArrayEquals(bArr));
        return null;
    }

    public static boolean not(boolean z6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return false;
    }

    public static char or(char c, char c6) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return (char) 0;
    }

    public static <T> T and(T t6, T t7) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return null;
    }

    public static boolean[] aryEq(boolean[] zArr) {
        reportMatcher(new ArrayEquals(zArr));
        return null;
    }

    public static byte not(byte b) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return (byte) 0;
    }

    public static byte or(byte b, byte b2) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return (byte) 0;
    }
}
