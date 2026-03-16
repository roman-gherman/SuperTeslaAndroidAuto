package androidx.constraintlayout.core.motion.utils;

import B2.b;
import fr.sd.taada.proto.MessageStatus;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static DebugHandle ourHandle;

    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i) {
        int i3 = (i & (~(i >> 31))) + MessageStatus.STATUS_OUT_OF_MEMORY_VALUE;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        System.out.println(str + " : " + str2);
    }

    public static void logStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i, stackTrace.length - 1);
        String strE = " ";
        for (int i3 = 1; i3 <= iMin; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            String str2 = ".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName();
            strE = b.e(strE, " ");
            System.out.println(str + strE + str2 + strE);
        }
    }

    public static void loge(String str, String str2) {
        System.err.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f6, float f7, float f8, float f9) {
        int iClamp = clamp((int) (f6 * 255.0f));
        int iClamp2 = clamp((int) (f7 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f9 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f8 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        ourHandle = debugHandle;
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String strSubstring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + strSubstring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = ourHandle;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }
}
