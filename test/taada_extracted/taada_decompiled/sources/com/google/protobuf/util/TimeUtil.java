package com.google.protobuf.util;

import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class TimeUtil {
    public static final long DURATION_SECONDS_MAX = 315576000000L;
    public static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final BigInteger NANOS_PER_SECOND_BIG_INTEGER = new BigInteger(String.valueOf(NANOS_PER_SECOND));
    public static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    public static final long TIMESTAMP_SECONDS_MIN = -62135596800L;

    private TimeUtil() {
    }

    @Deprecated
    public static Timestamp add(Timestamp timestamp, Duration duration) {
        return Timestamps.add(timestamp, duration);
    }

    private static Duration createDurationFromBigInteger(BigInteger bigInteger) {
        return normalizedDuration(bigInteger.divide(new BigInteger(String.valueOf(NANOS_PER_SECOND))).longValue(), bigInteger.remainder(new BigInteger(String.valueOf(NANOS_PER_SECOND))).intValue());
    }

    @Deprecated
    public static Duration createDurationFromMicros(long j6) {
        return Durations.fromMicros(j6);
    }

    @Deprecated
    public static Duration createDurationFromMillis(long j6) {
        return Durations.fromMillis(j6);
    }

    @Deprecated
    public static Duration createDurationFromNanos(long j6) {
        return Durations.fromNanos(j6);
    }

    @Deprecated
    public static Timestamp createTimestampFromMicros(long j6) {
        return Timestamps.fromMicros(j6);
    }

    @Deprecated
    public static Timestamp createTimestampFromMillis(long j6) {
        return Timestamps.fromMillis(j6);
    }

    @Deprecated
    public static Timestamp createTimestampFromNanos(long j6) {
        return Timestamps.fromNanos(j6);
    }

    @Deprecated
    public static Duration distance(Timestamp timestamp, Timestamp timestamp2) {
        return Timestamps.between(timestamp, timestamp2);
    }

    public static Duration divide(Duration duration, double d) {
        return multiply(duration, 1.0d / d);
    }

    @Deprecated
    public static Timestamp getCurrentTime() {
        return Timestamps.fromMillis(System.currentTimeMillis());
    }

    @Deprecated
    public static Timestamp getEpoch() {
        return Timestamp.getDefaultInstance();
    }

    public static Duration multiply(Duration duration, double d) {
        double nanos = ((((double) duration.getNanos()) * d) / 1.0E9d) + (duration.getSeconds() * d);
        if (nanos < -9.223372036854776E18d || nanos > 9.223372036854776E18d) {
            throw new IllegalArgumentException("Result is out of valid range.");
        }
        long j6 = (long) nanos;
        return normalizedDuration(j6, (int) ((nanos - j6) * 1.0E9d));
    }

    private static Duration normalizedDuration(long j6, int i) {
        long j7 = i;
        if (j7 <= -1000000000 || j7 >= NANOS_PER_SECOND) {
            j6 += j7 / NANOS_PER_SECOND;
            i = (int) (j7 % NANOS_PER_SECOND);
        }
        if (j6 > 0 && i < 0) {
            i = (int) (((long) i) + NANOS_PER_SECOND);
            j6--;
        }
        if (j6 < 0 && i > 0) {
            i = (int) (((long) i) - NANOS_PER_SECOND);
            j6++;
        }
        if (j6 < DURATION_SECONDS_MIN || j6 > DURATION_SECONDS_MAX) {
            throw new IllegalArgumentException("Duration is out of valid range.");
        }
        return Duration.newBuilder().setSeconds(j6).setNanos(i).build();
    }

    @Deprecated
    public static Duration parseDuration(String str) {
        return Durations.parse(str);
    }

    @Deprecated
    public static Timestamp parseTimestamp(String str) {
        return Timestamps.parse(str);
    }

    public static Duration remainder(Duration duration, Duration duration2) {
        return createDurationFromBigInteger(toBigInteger(duration).remainder(toBigInteger(duration2)));
    }

    @Deprecated
    public static Timestamp subtract(Timestamp timestamp, Duration duration) {
        return Timestamps.subtract(timestamp, duration);
    }

    private static BigInteger toBigInteger(Duration duration) {
        return toBigInteger(duration.getSeconds()).multiply(NANOS_PER_SECOND_BIG_INTEGER).add(toBigInteger(duration.getNanos()));
    }

    @Deprecated
    public static long toMicros(Timestamp timestamp) {
        return Timestamps.toMicros(timestamp);
    }

    @Deprecated
    public static long toMillis(Timestamp timestamp) {
        return Timestamps.toMillis(timestamp);
    }

    @Deprecated
    public static long toNanos(Timestamp timestamp) {
        return Timestamps.toNanos(timestamp);
    }

    @Deprecated
    public static String toString(Timestamp timestamp) {
        return Timestamps.toString(timestamp);
    }

    @Deprecated
    public static Duration add(Duration duration, Duration duration2) {
        return Durations.add(duration, duration2);
    }

    public static Duration divide(Duration duration, long j6) {
        return createDurationFromBigInteger(toBigInteger(duration).divide(toBigInteger(j6)));
    }

    @Deprecated
    public static Duration subtract(Duration duration, Duration duration2) {
        return Durations.subtract(duration, duration2);
    }

    @Deprecated
    public static long toMicros(Duration duration) {
        return Durations.toMicros(duration);
    }

    @Deprecated
    public static long toMillis(Duration duration) {
        return Durations.toMillis(duration);
    }

    @Deprecated
    public static long toNanos(Duration duration) {
        return Durations.toNanos(duration);
    }

    @Deprecated
    public static String toString(Duration duration) {
        return Durations.toString(duration);
    }

    public static long divide(Duration duration, Duration duration2) {
        return toBigInteger(duration).divide(toBigInteger(duration2)).longValue();
    }

    public static Duration multiply(Duration duration, long j6) {
        return createDurationFromBigInteger(toBigInteger(duration).multiply(toBigInteger(j6)));
    }

    private static BigInteger toBigInteger(long j6) {
        return new BigInteger(String.valueOf(j6));
    }
}
