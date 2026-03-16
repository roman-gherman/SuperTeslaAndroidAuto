package androidx.core.content.res;

import B2.b;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class CamUtils {
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};
    static final float[][] SRGB_TO_XYZ = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    private CamUtils() {
    }

    public static int intFromLStar(float f6) {
        if (f6 < 1.0f) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (f6 > 99.0f) {
            return -1;
        }
        float f7 = (f6 + 16.0f) / 116.0f;
        float f8 = f6 > 8.0f ? f7 * f7 * f7 : f6 / 903.2963f;
        float f9 = f7 * f7 * f7;
        boolean z6 = f9 > 0.008856452f;
        float f10 = z6 ? f9 : ((f7 * 116.0f) - 16.0f) / 903.2963f;
        if (!z6) {
            f9 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(f10 * fArr[0], f8 * fArr[1], f9 * fArr[2]);
    }

    public static float lStarFromInt(int i) {
        return lStarFromY(yFromInt(i));
    }

    public static float lStarFromY(float f6) {
        float f7 = f6 / 100.0f;
        return f7 <= 0.008856452f ? f7 * 903.2963f : (((float) Math.cbrt(f7)) * 116.0f) - 16.0f;
    }

    public static float lerp(float f6, float f7, float f8) {
        return b.a(f7, f6, f8, f6);
    }

    public static float linearized(int i) {
        float f6 = i / 255.0f;
        return (f6 <= 0.04045f ? f6 / 12.92f : (float) Math.pow((f6 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static void xyzFromInt(int i, float[] fArr) {
        float fLinearized = linearized(Color.red(i));
        float fLinearized2 = linearized(Color.green(i));
        float fLinearized3 = linearized(Color.blue(i));
        float[][] fArr2 = SRGB_TO_XYZ;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[2] * fLinearized3) + (fArr3[1] * fLinearized2) + (fArr3[0] * fLinearized);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[2] * fLinearized3) + (fArr4[1] * fLinearized2) + (fArr4[0] * fLinearized);
        float[] fArr5 = fArr2[2];
        fArr[2] = (fLinearized3 * fArr5[2]) + (fLinearized2 * fArr5[1]) + (fLinearized * fArr5[0]);
    }

    public static float yFromInt(int i) {
        float fLinearized = linearized(Color.red(i));
        float fLinearized2 = linearized(Color.green(i));
        float fLinearized3 = linearized(Color.blue(i));
        float[] fArr = SRGB_TO_XYZ[1];
        return (fLinearized3 * fArr[2]) + (fLinearized2 * fArr[1]) + (fLinearized * fArr[0]);
    }

    public static float yFromLStar(float f6) {
        return (f6 > 8.0f ? (float) Math.pow((((double) f6) + 16.0d) / 116.0d, 3.0d) : f6 / 903.2963f) * 100.0f;
    }
}
