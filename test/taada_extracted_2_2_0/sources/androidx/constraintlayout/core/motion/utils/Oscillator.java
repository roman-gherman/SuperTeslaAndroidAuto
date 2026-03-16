package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f6) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d;
        this.mPeriod[iBinarySearch] = f6;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= 0.0d) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i = -iBinarySearch;
        int i3 = i - 1;
        float[] fArr = this.mPeriod;
        float f6 = fArr[i3];
        int i4 = i - 2;
        float f7 = fArr[i4];
        double[] dArr = this.mPosition;
        double d6 = dArr[i3];
        double d7 = dArr[i4];
        double d8 = ((double) (f6 - f7)) / (d6 - d7);
        return (((double) f7) - (d8 * d7)) + (d * d8);
    }

    public double getP(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i = -iBinarySearch;
        int i3 = i - 1;
        float[] fArr = this.mPeriod;
        float f6 = fArr[i3];
        int i4 = i - 2;
        float f7 = fArr[i4];
        double[] dArr = this.mPosition;
        double d6 = dArr[i3];
        double d7 = dArr[i4];
        double d8 = ((double) (f6 - f7)) / (d6 - d7);
        return ((((d * d) - (d7 * d7)) * d8) / 2.0d) + ((d - d7) * (((double) f7) - (d8 * d7))) + this.mArea[i4];
    }

    public double getSlope(double d, double d6, double d7) {
        double d8;
        double dSignum;
        double p5 = getP(d) + d6;
        double dp = getDP(d) + d7;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d8 = dp * 4.0d;
                dSignum = Math.signum((((p5 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d9 = this.PI2;
                return Math.sin(d9 * p5) * (-d9) * dp;
            case 6:
                return ((((p5 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p5 % 1.0d, 0);
            default:
                double d10 = this.PI2;
                d8 = dp * d10;
                dSignum = Math.cos(d10 * p5);
                break;
        }
        return dSignum * d8;
    }

    public double getValue(double d, double d6) {
        double dAbs;
        double p5 = getP(d) + d6;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p5 % 1.0d));
            case 2:
                dAbs = Math.abs((((p5 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p5 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((p5 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d6 + p5) * this.PI2);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((p5 * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p5 % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p5);
        }
        return 1.0d - dAbs;
    }

    public void normalize() {
        double d = 0.0d;
        int i = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i >= fArr.length) {
                break;
            }
            d += (double) fArr[i];
            i++;
        }
        double d6 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i3 >= fArr2.length) {
                break;
            }
            int i4 = i3 - 1;
            float f6 = (fArr2[i4] + fArr2[i3]) / 2.0f;
            double[] dArr = this.mPosition;
            d6 += (dArr[i3] - dArr[i4]) * ((double) f6);
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i5 >= fArr3.length) {
                break;
            }
            fArr3[i5] = (float) (((double) fArr3[i5]) * (d / d6));
            i5++;
        }
        this.mArea[0] = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i6 >= fArr4.length) {
                this.mNormalized = true;
                return;
            }
            int i7 = i6 - 1;
            float f7 = (fArr4[i7] + fArr4[i6]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d7 = dArr2[i6] - dArr2[i7];
            double[] dArr3 = this.mArea;
            dArr3[i6] = (d7 * ((double) f7)) + dArr3[i7];
            i6++;
        }
    }

    public void setType(int i, String str) {
        this.mType = i;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
