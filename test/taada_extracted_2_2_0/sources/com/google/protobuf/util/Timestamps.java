package com.google.protobuf.util;

import E1.k;
import a.AbstractC0132a;
import androidx.constraintlayout.core.motion.a;
import c4.AbstractC0246d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class Timestamps {
    static final long MICROS_PER_SECOND = 1000000;
    static final long MILLIS_PER_SECOND = 1000;
    static final long NANOS_PER_MICROSECOND = 1000;
    static final long NANOS_PER_MILLISECOND = 1000000;
    static final long NANOS_PER_SECOND = 1000000000;
    static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
    public static final Timestamp MIN_VALUE = Timestamp.newBuilder().setSeconds(-62135596800L).setNanos(0).build();
    public static final Timestamp MAX_VALUE = Timestamp.newBuilder().setSeconds(253402300799L).setNanos(999999999).build();
    public static final Timestamp EPOCH = Timestamp.newBuilder().setSeconds(0).setNanos(0).build();
    private static final ThreadLocal<SimpleDateFormat> timestampFormat = new ThreadLocal<SimpleDateFormat>() { // from class: com.google.protobuf.util.Timestamps.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return Timestamps.createTimestampFormat();
        }
    };
    private static final Comparator<Timestamp> COMPARATOR = new Comparator<Timestamp>() { // from class: com.google.protobuf.util.Timestamps.2
        @Override // java.util.Comparator
        public int compare(Timestamp timestamp, Timestamp timestamp2) {
            Timestamps.checkValid(timestamp);
            Timestamps.checkValid(timestamp2);
            int iCompare = Long.compare(timestamp.getSeconds(), timestamp2.getSeconds());
            return iCompare != 0 ? iCompare : Integer.compare(timestamp.getNanos(), timestamp2.getNanos());
        }
    };

    private Timestamps() {
    }

    public static Timestamp add(Timestamp timestamp, Duration duration) {
        checkValid(timestamp);
        Durations.checkValid(duration);
        long jH = AbstractC0246d.h(timestamp.getSeconds(), duration.getSeconds());
        int nanos = timestamp.getNanos();
        int nanos2 = duration.getNanos();
        long j6 = ((long) nanos) + ((long) nanos2);
        int i = (int) j6;
        AbstractC0132a.l("checkedAdd", nanos, nanos2, j6 == ((long) i));
        return normalizedTimestamp(jH, i);
    }

    public static Duration between(Timestamp timestamp, Timestamp timestamp2) {
        checkValid(timestamp);
        checkValid(timestamp2);
        return Durations.normalizedDuration(AbstractC0246d.j(timestamp2.getSeconds(), timestamp.getSeconds()), k.j(timestamp2.getNanos(), timestamp.getNanos()));
    }

    @CanIgnoreReturnValue
    public static Timestamp checkValid(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        if (isValid(seconds, nanos)) {
            return timestamp;
        }
        throw new IllegalArgumentException("Timestamp is not valid. See proto definition for valid values. Seconds (" + seconds + ") must be in range [-62,135,596,800, +253,402,300,799]. Nanos (" + nanos + ") must be in range [0, +999,999,999].");
    }

    public static Comparator<Timestamp> comparator() {
        return COMPARATOR;
    }

    public static int compare(Timestamp timestamp, Timestamp timestamp2) {
        return COMPARATOR.compare(timestamp, timestamp2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SimpleDateFormat createTimestampFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }

    public static String formatNanos(int i) {
        long j6 = i;
        return j6 % 1000000 == 0 ? String.format(Locale.ENGLISH, "%1$03d", Long.valueOf(j6 / 1000000)) : j6 % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Long.valueOf(j6 / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(i));
    }

    public static Timestamp fromMicros(long j6) {
        return normalizedTimestamp(j6 / 1000000, (int) ((j6 % 1000000) * 1000));
    }

    public static Timestamp fromMillis(long j6) {
        return normalizedTimestamp(j6 / 1000, (int) ((j6 % 1000) * 1000000));
    }

    public static Timestamp fromNanos(long j6) {
        return normalizedTimestamp(j6 / NANOS_PER_SECOND, (int) (j6 % NANOS_PER_SECOND));
    }

    public static Timestamp fromSeconds(long j6) {
        return normalizedTimestamp(j6, 0);
    }

    public static boolean isValid(long j6, int i) {
        return j6 >= -62135596800L && j6 <= 253402300799L && i >= 0 && ((long) i) < NANOS_PER_SECOND;
    }

    public static Timestamp normalizedTimestamp(long j6, int i) {
        long j7 = i;
        if (j7 <= -1000000000 || j7 >= NANOS_PER_SECOND) {
            j6 = AbstractC0246d.h(j6, j7 / NANOS_PER_SECOND);
            i = (int) (j7 % NANOS_PER_SECOND);
        }
        if (i < 0) {
            i = (int) (((long) i) + NANOS_PER_SECOND);
            j6 = AbstractC0246d.j(j6, 1L);
        }
        return checkValid(Timestamp.newBuilder().setSeconds(j6).setNanos(i).build());
    }

    public static Timestamp parse(String str) throws ParseException {
        String strSubstring;
        int iIndexOf = str.indexOf(84);
        if (iIndexOf == -1) {
            throw new ParseException(a.q("Failed to parse timestamp: invalid timestamp \"", str, "\""), 0);
        }
        int iIndexOf2 = str.indexOf(90, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(43, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(45, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        String strSubstring2 = str.substring(0, iIndexOf2);
        int iIndexOf3 = strSubstring2.indexOf(46);
        if (iIndexOf3 != -1) {
            String strSubstring3 = strSubstring2.substring(0, iIndexOf3);
            strSubstring = strSubstring2.substring(iIndexOf3 + 1);
            strSubstring2 = strSubstring3;
        } else {
            strSubstring = "";
        }
        long time = timestampFormat.get().parse(strSubstring2).getTime() / 1000;
        int nanos = strSubstring.isEmpty() ? 0 : parseNanos(strSubstring);
        if (str.charAt(iIndexOf2) != 'Z') {
            long timezoneOffset = parseTimezoneOffset(str.substring(iIndexOf2 + 1));
            time = str.charAt(iIndexOf2) == '+' ? time - timezoneOffset : time + timezoneOffset;
        } else if (str.length() != iIndexOf2 + 1) {
            throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(iIndexOf2) + "\"", 0);
        }
        try {
            return normalizedTimestamp(time, nanos);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Failed to parse timestamp: timestamp is out of range.", 0);
        }
    }

    public static int parseNanos(String str) throws ParseException {
        int iCharAt = 0;
        for (int i = 0; i < 9; i++) {
            iCharAt *= 10;
            if (i < str.length()) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt = (str.charAt(i) - '0') + iCharAt;
            }
        }
        return iCharAt;
    }

    private static long parseTimezoneOffset(String str) throws ParseException {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid offset value: ".concat(str), 0);
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        return (Long.parseLong(strSubstring2) + (Long.parseLong(strSubstring) * 60)) * 60;
    }

    public static Timestamp subtract(Timestamp timestamp, Duration duration) {
        checkValid(timestamp);
        Durations.checkValid(duration);
        return normalizedTimestamp(AbstractC0246d.j(timestamp.getSeconds(), duration.getSeconds()), k.j(timestamp.getNanos(), duration.getNanos()));
    }

    public static long toMicros(Timestamp timestamp) {
        checkValid(timestamp);
        return AbstractC0246d.h(AbstractC0246d.i(timestamp.getSeconds(), 1000000L), ((long) timestamp.getNanos()) / 1000);
    }

    public static long toMillis(Timestamp timestamp) {
        checkValid(timestamp);
        return AbstractC0246d.h(AbstractC0246d.i(timestamp.getSeconds(), 1000L), ((long) timestamp.getNanos()) / 1000000);
    }

    public static long toNanos(Timestamp timestamp) {
        checkValid(timestamp);
        return AbstractC0246d.h(AbstractC0246d.i(timestamp.getSeconds(), NANOS_PER_SECOND), timestamp.getNanos());
    }

    public static long toSeconds(Timestamp timestamp) {
        return checkValid(timestamp).getSeconds();
    }

    public static String toString(Timestamp timestamp) {
        checkValid(timestamp);
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        StringBuilder sb = new StringBuilder();
        sb.append(timestampFormat.get().format(new Date(seconds * 1000)));
        if (nanos != 0) {
            sb.append(".");
            sb.append(formatNanos(nanos));
        }
        sb.append("Z");
        return sb.toString();
    }

    public static boolean isValid(Timestamp timestamp) {
        return isValid(timestamp.getSeconds(), timestamp.getNanos());
    }

    public static Timestamp checkValid(Timestamp.Builder builder) {
        return checkValid(builder.build());
    }
}
