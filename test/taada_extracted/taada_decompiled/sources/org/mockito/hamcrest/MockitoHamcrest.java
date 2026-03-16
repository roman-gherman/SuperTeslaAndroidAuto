package org.mockito.hamcrest;

import org.hamcrest.Matcher;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.mockito.internal.hamcrest.MatcherGenericTypeExtractor;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.Primitives;

/* JADX INFO: loaded from: classes.dex */
public final class MockitoHamcrest {
    private MockitoHamcrest() {
    }

    public static <T> T argThat(Matcher<T> matcher) {
        reportMatcher(matcher);
        return (T) Primitives.defaultValue(MatcherGenericTypeExtractor.genericTypeOfMatcher(matcher.getClass()));
    }

    public static boolean booleanThat(Matcher<Boolean> matcher) {
        reportMatcher(matcher);
        return false;
    }

    public static byte byteThat(Matcher<Byte> matcher) {
        reportMatcher(matcher);
        return (byte) 0;
    }

    public static char charThat(Matcher<Character> matcher) {
        reportMatcher(matcher);
        return (char) 0;
    }

    public static double doubleThat(Matcher<Double> matcher) {
        reportMatcher(matcher);
        return 0.0d;
    }

    public static float floatThat(Matcher<Float> matcher) {
        reportMatcher(matcher);
        return 0.0f;
    }

    public static int intThat(Matcher<Integer> matcher) {
        reportMatcher(matcher);
        return 0;
    }

    public static long longThat(Matcher<Long> matcher) {
        reportMatcher(matcher);
        return 0L;
    }

    private static <T> void reportMatcher(Matcher<T> matcher) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportMatcher(new HamcrestArgumentMatcher(matcher));
    }

    public static short shortThat(Matcher<Short> matcher) {
        reportMatcher(matcher);
        return (short) 0;
    }
}
