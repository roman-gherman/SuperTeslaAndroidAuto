package androidx.core.util;

import java.io.PrintWriter;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i, int i3, boolean z6, int i4) {
        if (i > 99 || (z6 && i4 >= 3)) {
            return i3 + 3;
        }
        if (i > 9 || (z6 && i4 >= 2)) {
            return i3 + 2;
        }
        if (z6 || i > 0) {
            return i3 + 1;
        }
        return 0;
    }

    public static void formatDuration(long j6, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j6, 0));
        }
    }

    private static int formatDurationLocked(long j6, int i) {
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        long j7 = j6;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j7 == 0) {
            int i7 = i - 1;
            while (i7 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j7 > 0) {
            c = SignatureVisitor.EXTENDS;
        } else {
            j7 = -j7;
            c = SignatureVisitor.SUPER;
        }
        int i8 = (int) (j7 % 1000);
        int iFloor = (int) Math.floor(j7 / 1000);
        if (iFloor > SECONDS_PER_DAY) {
            i3 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i3;
        } else {
            i3 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i4 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i4 * SECONDS_PER_HOUR;
        } else {
            i4 = 0;
        }
        if (iFloor > 60) {
            int i9 = iFloor / 60;
            iFloor -= i9 * 60;
            i5 = i9;
        } else {
            i5 = 0;
        }
        if (i != 0) {
            int iAccumField = accumField(i3, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i4, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i5, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(iFloor, 1, iAccumField3 > 0, 2);
            i6 = 0;
            for (int iAccumField5 = accumField(i8, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i; iAccumField5++) {
                cArr[i6] = ' ';
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i10 = i6 + 1;
        boolean z6 = i != 0;
        int iPrintField = printField(cArr, i3, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, i10, false, 0);
        int iPrintField2 = printField(cArr, i4, 'h', iPrintField, iPrintField != i10, z6 ? 2 : 0);
        int iPrintField3 = printField(cArr, i5, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, iPrintField2, iPrintField2 != i10, z6 ? 2 : 0);
        int iPrintField4 = printField(cArr, iFloor, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, iPrintField3, iPrintField3 != i10, z6 ? 2 : 0);
        int iPrintField5 = printField(cArr, i8, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, iPrintField4, true, (!z6 || iPrintField4 == i10) ? 0 : 3);
        cArr[iPrintField5] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c, int i3, boolean z6, int i4) {
        int i5;
        if (!z6 && i <= 0) {
            return i3;
        }
        if ((!z6 || i4 < 3) && i <= 99) {
            i5 = i3;
        } else {
            int i6 = i / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i -= i6 * 100;
        }
        if ((z6 && i4 >= 2) || i > 9 || i3 != i5) {
            int i7 = i / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i -= i7 * 10;
        }
        cArr[i5] = (char) (i + 48);
        cArr[i5 + 1] = c;
        return i5 + 2;
    }

    public static void formatDuration(long j6, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j6, i)));
        }
    }

    public static void formatDuration(long j6, PrintWriter printWriter) {
        formatDuration(j6, printWriter, 0);
    }

    public static void formatDuration(long j6, long j7, PrintWriter printWriter) {
        if (j6 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j6 - j7, printWriter, 0);
        }
    }
}
