package p054i2;

import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.VideoCodecResolutionType;

/* JADX INFO: loaded from: classes.dex */
public abstract class VideoResolutionHelper {
    public static int screenHeight;
    private static float screenRatio;
    public static int screenWidth;

    public static Integer calculateHorizontalOffset(int i) {
        int i3;
        int iIntValue = getVideoHeight(i).intValue();
        int iIntValue2 = getVideoWidth(i).intValue();
        if (iIntValue > screenHeight && iIntValue2 > (i3 = screenWidth)) {
            return Integer.valueOf(iIntValue2 - i3);
        }
        float f6 = iIntValue2;
        float f7 = iIntValue;
        float f8 = f6 / f7;
        float f9 = screenRatio;
        return Integer.valueOf(f9 <= f8 ? Math.round(f6 - (f7 * f9)) : 0);
    }

    public static Integer calculateVerticalOffset(int i) {
        int iIntValue = getVideoHeight(i).intValue();
        int iIntValue2 = getVideoWidth(i).intValue();
        int i3 = screenHeight;
        if (iIntValue > i3 && iIntValue2 > screenWidth) {
            return Integer.valueOf(iIntValue - i3);
        }
        float f6 = iIntValue2;
        float f7 = f6 / iIntValue;
        float f8 = screenRatio;
        return Integer.valueOf(f8 > f7 ? iIntValue - Math.round(f6 / f8) : 0);
    }

    public static VideoCodecResolutionType getVideoCodecResolutionType(int i) {
        return VideoCodecResolutionType.forNumber(i + 1);
    }

    public static Integer getVideoHeight(int i) {
        int i3;
        switch (i) {
            case 0:
                i3 = 480;
                break;
            case 1:
                i3 = 720;
                break;
            case 2:
                i3 = 1080;
                break;
            case 3:
                i3 = 1440;
                break;
            case 4:
                i3 = 2160;
                break;
            case 5:
                i3 = 1280;
                break;
            case 6:
                i3 = 1920;
                break;
            case 7:
                i3 = 2560;
                break;
            default:
                i3 = 3840;
                break;
        }
        return Integer.valueOf(i3);
    }

    public static Integer getVideoWidth(int i) {
        int i3;
        switch (i) {
            case 0:
                i3 = 800;
                break;
            case 1:
                i3 = 1280;
                break;
            case 2:
                i3 = 1920;
                break;
            case 3:
                i3 = 2560;
                break;
            case 4:
                i3 = 3840;
                break;
            case 5:
                i3 = 720;
                break;
            case 6:
                i3 = 1080;
                break;
            case 7:
                i3 = 1440;
                break;
            default:
                i3 = 2160;
                break;
        }
        return Integer.valueOf(i3);
    }

    public static void setScreenDimensions(int i, int i3) {
        screenRatio = i / i3;
        LogManager.getInstance(null).logDebug("CarScreen", "Screen ratio: " + screenRatio + " width: " + i + " height: " + i3);
        screenWidth = i;
        screenHeight = i3;
    }
}
