package com.google.protobuf.util;

import C5.f;
import E1.k;
import a.AbstractC0132a;
import c4.AbstractC0246d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Duration;
import java.text.ParseException;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class Durations {
    static final long DURATION_SECONDS_MAX = 315576000000L;
    static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long SECONDS_PER_DAY = 86400;
    private static final long SECONDS_PER_HOUR = 3600;
    private static final long SECONDS_PER_MINUTE = 60;
    public static final Duration MIN_VALUE = Duration.newBuilder().setSeconds(-315576000000L).setNanos(-999999999).build();
    public static final Duration MAX_VALUE = Duration.newBuilder().setSeconds(315576000000L).setNanos(999999999).build();
    public static final Duration ZERO = Duration.newBuilder().setSeconds(0).setNanos(0).build();
    private static final Comparator<Duration> COMPARATOR = new Comparator<Duration>() { // from class: com.google.protobuf.util.Durations.1
        @Override // java.util.Comparator
        public int compare(Duration duration, Duration duration2) {
            Durations.checkValid(duration);
            Durations.checkValid(duration2);
            int iCompare = Long.compare(duration.getSeconds(), duration2.getSeconds());
            return iCompare != 0 ? iCompare : Integer.compare(duration.getNanos(), duration2.getNanos());
        }
    };

    private Durations() {
    }

    public static Duration add(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        long jH = AbstractC0246d.h(duration.getSeconds(), duration2.getSeconds());
        int nanos = duration.getNanos();
        int nanos2 = duration2.getNanos();
        long j6 = ((long) nanos) + ((long) nanos2);
        int i = (int) j6;
        AbstractC0132a.l("checkedAdd", nanos, nanos2, j6 == ((long) i));
        return normalizedDuration(jH, i);
    }

    @CanIgnoreReturnValue
    public static Duration checkNotNegative(Duration duration) {
        checkValid(duration);
        boolean zIsNegative = isNegative(duration);
        String string = toString(duration);
        if (zIsNegative) {
            throw new IllegalArgumentException(f.R("duration (%s) must not be negative", string));
        }
        return duration;
    }

    @CanIgnoreReturnValue
    public static Duration checkPositive(Duration duration) {
        checkValid(duration);
        boolean z6 = (isNegative(duration) || duration.equals(ZERO)) ? false : true;
        String string = toString(duration);
        if (z6) {
            return duration;
        }
        throw new IllegalArgumentException(f.R("duration (%s) must be positive", string));
    }

    @CanIgnoreReturnValue
    public static Duration checkValid(Duration duration) {
        long seconds = duration.getSeconds();
        int nanos = duration.getNanos();
        if (isValid(seconds, nanos)) {
            return duration;
        }
        throw new IllegalArgumentException("Duration is not valid. See proto definition for valid values. Seconds (" + seconds + ") must be in range [-315,576,000,000, +315,576,000,000]. Nanos (" + nanos + ") must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds");
    }

    public static Comparator<Duration> comparator() {
        return COMPARATOR;
    }

    public static int compare(Duration duration, Duration duration2) {
        return COMPARATOR.compare(duration, duration2);
    }

    public static Duration fromDays(long j6) {
        return Duration.newBuilder().setSeconds(AbstractC0246d.i(j6, SECONDS_PER_DAY)).setNanos(0).build();
    }

    public static Duration fromHours(long j6) {
        return Duration.newBuilder().setSeconds(AbstractC0246d.i(j6, SECONDS_PER_HOUR)).setNanos(0).build();
    }

    public static Duration fromMicros(long j6) {
        return normalizedDuration(j6 / 1000000, (int) ((j6 % 1000000) * 1000));
    }

    public static Duration fromMillis(long j6) {
        return normalizedDuration(j6 / 1000, (int) ((j6 % 1000) * 1000000));
    }

    public static Duration fromMinutes(long j6) {
        return Duration.newBuilder().setSeconds(AbstractC0246d.i(j6, SECONDS_PER_MINUTE)).setNanos(0).build();
    }

    public static Duration fromNanos(long j6) {
        return normalizedDuration(j6 / 1000000000, (int) (j6 % 1000000000));
    }

    public static Duration fromSeconds(long j6) {
        return normalizedDuration(j6, 0);
    }

    public static boolean isNegative(Duration duration) {
        checkValid(duration);
        return duration.getSeconds() == 0 ? duration.getNanos() < 0 : duration.getSeconds() < 0;
    }

    public static boolean isValid(long j6, int i) {
        if (j6 >= -315576000000L && j6 <= 315576000000L) {
            long j7 = i;
            if (j7 >= -999999999 && j7 < 1000000000) {
                if (j6 >= 0 && i >= 0) {
                    return true;
                }
                if (j6 <= 0 && i <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Duration normalizedDuration(long j6, int i) {
        long j7 = i;
        if (j7 <= -1000000000 || j7 >= 1000000000) {
            j6 = AbstractC0246d.h(j6, j7 / 1000000000);
            i = (int) (j7 % 1000000000);
        }
        if (j6 > 0 && i < 0) {
            i = (int) (((long) i) + 1000000000);
            j6--;
        }
        if (j6 < 0 && i > 0) {
            i = (int) (((long) i) - 1000000000);
            j6++;
        }
        return checkValid(Duration.newBuilder().setSeconds(j6).setNanos(i).build());
    }

    public static Duration parse(String str) throws ParseException {
        boolean z6;
        String strSubstring;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z6 = true;
        } else {
            z6 = false;
        }
        String strSubstring2 = str.substring(0, str.length() - 1);
        int iIndexOf = strSubstring2.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j6 = Long.parseLong(strSubstring2);
        int nanos = strSubstring.isEmpty() ? 0 : Timestamps.parseNanos(strSubstring);
        if (j6 < 0) {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (z6) {
            j6 = -j6;
            nanos = -nanos;
        }
        try {
            return normalizedDuration(j6, nanos);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static Duration subtract(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        return normalizedDuration(AbstractC0246d.j(duration.getSeconds(), duration2.getSeconds()), k.j(duration.getNanos(), duration2.getNanos()));
    }

    public static long toDays(Duration duration) {
        return checkValid(duration).getSeconds() / SECONDS_PER_DAY;
    }

    public static long toHours(Duration duration) {
        return checkValid(duration).getSeconds() / SECONDS_PER_HOUR;
    }

    public static long toMicros(Duration duration) {
        checkValid(duration);
        return AbstractC0246d.h(AbstractC0246d.i(duration.getSeconds(), 1000000L), ((long) duration.getNanos()) / 1000);
    }

    public static long toMillis(Duration duration) {
        checkValid(duration);
        return AbstractC0246d.h(AbstractC0246d.i(duration.getSeconds(), 1000L), ((long) duration.getNanos()) / 1000000);
    }

    public static long toMinutes(Duration duration) {
        return checkValid(duration).getSeconds() / SECONDS_PER_MINUTE;
    }

    public static long toNanos(Duration duration) {
        checkValid(duration);
        return AbstractC0246d.h(AbstractC0246d.i(duration.getSeconds(), 1000000000L), duration.getNanos());
    }

    public static long toSeconds(Duration duration) {
        return checkValid(duration).getSeconds();
    }

    public static double toSecondsAsDouble(Duration duration) {
        checkValid(duration);
        return (((double) duration.getNanos()) / 1.0E9d) + duration.getSeconds();
    }

    public static String toString(Duration duration) {
        checkValid(duration);
        long seconds = duration.getSeconds();
        int nanos = duration.getNanos();
        StringBuilder sb = new StringBuilder();
        if (seconds < 0 || nanos < 0) {
            sb.append("-");
            seconds = -seconds;
            nanos = -nanos;
        }
        sb.append(seconds);
        if (nanos != 0) {
            sb.append(".");
            sb.append(Timestamps.formatNanos(nanos));
        }
        sb.append("s");
        return sb.toString();
    }

    public static boolean isValid(Duration duration) {
        return isValid(duration.getSeconds(), duration.getNanos());
    }

    public static Duration checkValid(Duration.Builder builder) {
        return checkValid(builder.build());
    }
}
