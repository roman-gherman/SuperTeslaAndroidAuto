package androidx.core.graphics;

import android.graphics.Color;
import androidx.constraintlayout.core.motion.a;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f6 = fAlpha + fAlpha2;
            components2[componentCount] = f6;
            if (f6 > 0.0f) {
                fAlpha /= f6;
                fAlpha2 /= f6;
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components2[i] * fAlpha2) + (components[i] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float fAbs = (1.0f - Math.abs((f8 * 2.0f) - 1.0f)) * f7;
        float f9 = f8 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f6 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f6) / 60) {
            case 0:
                iRound = Math.round((fAbs + f9) * 255.0f);
                iRound2 = Math.round((fAbs2 + f9) * 255.0f);
                iRound3 = Math.round(f9 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f9) * 255.0f);
                iRound2 = Math.round((fAbs + f9) * 255.0f);
                iRound3 = Math.round(f9 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f9 * 255.0f);
                iRound2 = Math.round((fAbs + f9) * 255.0f);
                iRound3 = Math.round((fAbs2 + f9) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f9 * 255.0f);
                iRound2 = Math.round((fAbs2 + f9) * 255.0f);
                iRound3 = Math.round((fAbs + f9) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f9) * 255.0f);
                iRound2 = Math.round(f9 * 255.0f);
                iRound3 = Math.round((fAbs + f9) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f9) * 255.0f);
                iRound2 = Math.round(f9 * 255.0f);
                iRound3 = Math.round((fAbs2 + f9) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    public static int LABToColor(double d, double d6, double d7) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d6, d7, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(double d, double d6, double d7, double[] dArr) {
        double d8 = (d + 16.0d) / 116.0d;
        double d9 = (d6 / 500.0d) + d8;
        double d10 = d8 - (d7 / 200.0d);
        double dPow = Math.pow(d9, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d9 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d > 7.9996247999999985d ? Math.pow(d8, 3.0d) : d / XYZ_KAPPA;
        double dPow3 = Math.pow(d10, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d10 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    public static int M3HCTToColor(float f6, float f7, float f8) {
        return CamColor.toColor(f6, f7, f8);
    }

    public static void RGBToHSL(int i, int i3, int i4, float[] fArr) {
        float f6;
        float fAbs;
        float f7 = i / 255.0f;
        float f8 = i3 / 255.0f;
        float f9 = i4 / 255.0f;
        float fMax = Math.max(f7, Math.max(f8, f9));
        float fMin = Math.min(f7, Math.min(f8, f9));
        float f10 = fMax - fMin;
        float f11 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f6 = 0.0f;
            fAbs = 0.0f;
        } else {
            f6 = fMax == f7 ? ((f8 - f9) / f10) % 6.0f : fMax == f8 ? ((f9 - f7) / f10) + 2.0f : 4.0f + ((f7 - f8) / f10);
            fAbs = f10 / (1.0f - Math.abs((2.0f * f11) - 1.0f));
        }
        float f12 = (f6 * 60.0f) % 360.0f;
        if (f12 < 0.0f) {
            f12 += 360.0f;
        }
        fArr[0] = constrain(f12, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f11, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i, int i3, int i4, double[] dArr) {
        RGBToXYZ(i, i3, i4, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(int i, int i3, int i4, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) i) / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d6 = ((double) i3) / 255.0d;
        double dPow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = ((double) i4) / 255.0d;
        double dPow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[1] = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * XYZ_WHITE_REFERENCE_Y;
    }

    public static int XYZToColor(double d, double d6, double d7) {
        double d8 = (((-0.4986d) * d7) + (((-1.5372d) * d6) + (3.2406d * d))) / XYZ_WHITE_REFERENCE_Y;
        double d9 = ((0.0415d * d7) + ((1.8758d * d6) + ((-0.9689d) * d))) / XYZ_WHITE_REFERENCE_Y;
        double d10 = ((1.057d * d7) + (((-0.204d) * d6) + (0.0557d * d))) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(double d, double d6, double d7, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d6 / XYZ_WHITE_REFERENCE_Y);
        double dPivotXyzComponent3 = pivotXyzComponent(d7 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    public static int blendARGB(int i, int i3, float f6) {
        float f7 = 1.0f - f6;
        return Color.argb((int) ((Color.alpha(i3) * f6) + (Color.alpha(i) * f7)), (int) ((Color.red(i3) * f6) + (Color.red(i) * f7)), (int) ((Color.green(i3) * f6) + (Color.green(i) * f7)), (int) ((Color.blue(i3) * f6) + (Color.blue(i) * f7)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f6, float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f7 = 1.0f - f6;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f6);
        fArr3[1] = (fArr2[1] * f6) + (fArr[1] * f7);
        fArr3[2] = (fArr2[2] * f6) + (fArr[2] * f7);
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d, double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d6 = 1.0d - d;
        dArr3[0] = (dArr2[0] * d) + (dArr[0] * d6);
        dArr3[1] = (dArr2[1] * d) + (dArr[1] * d6);
        dArr3[2] = (dArr2[2] * d) + (dArr[2] * d6);
    }

    public static double calculateContrast(int i, int i3) {
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException(a.h(i3, new StringBuilder("background can not be translucent: #")));
        }
        if (Color.alpha(i) < 255) {
            i = compositeColors(i, i3);
        }
        double dCalculateLuminance = calculateLuminance(i) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i3) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(int i, int i3, float f6) {
        int i4 = 255;
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException(a.h(i3, new StringBuilder("background can not be translucent: #")));
        }
        double d = f6;
        if (calculateContrast(setAlphaComponent(i, 255), i3) < d) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
            int i7 = (i5 + i4) / 2;
            if (calculateContrast(setAlphaComponent(i, i7), i3) < d) {
                i5 = i7;
            } else {
                i4 = i7;
            }
        }
        return i4;
    }

    public static float circularInterpolate(float f6, float f7, float f8) {
        if (Math.abs(f7 - f6) > 180.0f) {
            if (f7 > f6) {
                f6 += 360.0f;
            } else {
                f7 += 360.0f;
            }
        }
        return (((f7 - f6) * f8) + f6) % 360.0f;
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToM3HCT(int i, float[] fArr) {
        CamColor.getM3HCTfromColor(i, fArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i3) {
        return 255 - (((255 - i) * (255 - i3)) / 255);
    }

    public static int compositeColors(int i, int i3) {
        int iAlpha = Color.alpha(i3);
        int iAlpha2 = Color.alpha(i);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i), iAlpha2, Color.red(i3), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i), iAlpha2, Color.green(i3), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i), iAlpha2, Color.blue(i3), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((255 - i3) * (i4 * i5)) + ((i * 255) * i3)) / (i6 * 255);
    }

    private static float constrain(float f6, float f7, float f8) {
        return f6 < f7 ? f7 : Math.min(f6, f8);
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static int setAlphaComponent(int i, int i3) {
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i3 << 24);
    }

    private static int constrain(int i, int i3, int i4) {
        return i < i3 ? i3 : Math.min(i, i4);
    }

    public static Color compositeColors(Color color, Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
