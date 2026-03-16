package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 + 1;
                double d = dArr[i5] - dArr[i4];
                double[] dArr5 = dArr3[i4];
                double d6 = (dArr2[i5][i3] - dArr2[i4][i3]) / d;
                dArr5[i3] = d6;
                if (i4 == 0) {
                    dArr4[i4][i3] = d6;
                } else {
                    dArr4[i4][i3] = (dArr3[i4 - 1][i3] + d6) * 0.5d;
                }
                i4 = i5;
            }
            dArr4[i][i3] = dArr3[length - 2][i3];
        }
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = 0; i7 < length2; i7++) {
                double d7 = dArr3[i6][i7];
                if (d7 == 0.0d) {
                    dArr4[i6][i7] = 0.0d;
                    dArr4[i6 + 1][i7] = 0.0d;
                } else {
                    double d8 = dArr4[i6][i7] / d7;
                    int i8 = i6 + 1;
                    double d9 = dArr4[i8][i7] / d7;
                    double dHypot = Math.hypot(d8, d9);
                    if (dHypot > 9.0d) {
                        double d10 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i6];
                        double[] dArr7 = dArr3[i6];
                        dArr6[i7] = d8 * d10 * dArr7[i7];
                        dArr4[i8][i7] = d10 * d9 * dArr7[i7];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i = 0;
        while (iIndexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i + 1));
    }

    private static double diff(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d6 * 6.0d;
        double d13 = 6.0d * d11 * d7;
        double d14 = (d13 + ((d12 * d8) + (((-6.0d) * d11) * d8))) - (d12 * d7);
        double d15 = 3.0d * d;
        return (d * d9) + (((((d15 * d9) * d11) + (((d15 * d10) * d11) + d14)) - (((2.0d * d) * d10) * d6)) - (((4.0d * d) * d9) * d6));
    }

    private static double interpolate(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d11 * d6;
        double d13 = 3.0d * d11;
        double d14 = d12 * 2.0d * d7;
        double d15 = ((d14 + ((d13 * d8) + (((-2.0d) * d12) * d8))) - (d13 * d7)) + d7;
        double d16 = d * d10;
        double d17 = (d16 * d12) + d15;
        double d18 = d * d9;
        return (d18 * d6) + ((((d12 * d18) + d17) - (d16 * d11)) - (((d * 2.0d) * d9) * d11));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr2[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = ((d - this.mT[0]) * this.mSlopeTemp[i3]) + this.mY[0][i3];
                }
                return;
            }
            int i4 = length - 1;
            double d7 = dArr2[i4];
            if (d >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d - this.mT[i4]) * this.mSlopeTemp[i]) + this.mY[i4][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr2[i6]) {
                while (i < length2) {
                    dArr[i] = this.mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.mY[i7][i8];
                }
            }
            double[] dArr3 = this.mT;
            int i9 = i7 + 1;
            double d8 = dArr3[i9];
            if (d < d8) {
                double d9 = dArr3[i7];
                double d10 = d8 - d9;
                double d11 = (d - d9) / d10;
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    double d12 = dArr4[i7][i];
                    double d13 = dArr4[i9][i];
                    double[][] dArr5 = this.mTangent;
                    dArr[i] = interpolate(d10, d11, d12, d13, dArr5[i7][i], dArr5[i9][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d6 = dArr2[0];
        if (d > d6) {
            d6 = dArr2[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.mT;
            int i3 = i + 1;
            double d7 = dArr3[i3];
            if (d6 <= d7) {
                double d8 = dArr3[i];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.mY;
                    double d11 = dArr4[i][i4];
                    double d12 = dArr4[i3][i4];
                    double[][] dArr5 = this.mTangent;
                    dArr[i4] = diff(d9, d10, d11, d12, dArr5[i][i4], dArr5[i3][i4]) / d9;
                }
                return;
            }
            i = i3;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d6 = dArr[i];
            int i3 = i + length2;
            dArr2[i3][0] = d6;
            double d7 = ((double) i) * d;
            dArr3[i3] = d7;
            if (i > 0) {
                int i4 = (length2 * 2) + i;
                dArr2[i4][0] = d6 + 1.0d;
                dArr3[i4] = d7 + 1.0d;
                int i5 = i - 1;
                dArr2[i5][0] = (d6 - 1.0d) - d;
                dArr3[i5] = (d7 - 1.0d) - d;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        double d6 = dArr[0];
        if (d >= d6) {
            d6 = dArr[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            int i4 = i3 + 1;
            double d7 = dArr2[i4];
            if (d6 <= d7) {
                double d8 = dArr2[i3];
                double d9 = d7 - d8;
                double[][] dArr3 = this.mY;
                double d10 = dArr3[i3][i];
                double d11 = dArr3[i4][i];
                double[][] dArr4 = this.mTangent;
                return diff(d9, (d6 - d8) / d9, d10, d11, dArr4[i3][i], dArr4[i4][i]) / d9;
            }
            i3 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) (((d - this.mT[0]) * this.mSlopeTemp[i3]) + this.mY[0][i3]);
                }
                return;
            }
            int i4 = length - 1;
            double d7 = dArr[i4];
            if (d >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d - this.mT[i4]) * this.mSlopeTemp[i]) + this.mY[i4][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr[i6]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.mY[i7][i8];
                }
            }
            double[] dArr2 = this.mT;
            int i9 = i7 + 1;
            double d8 = dArr2[i9];
            if (d < d8) {
                double d9 = dArr2[i7];
                double d10 = d8 - d9;
                double d11 = (d - d9) / d10;
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    double d12 = dArr3[i7][i];
                    double d13 = dArr3[i9][i];
                    double[][] dArr4 = this.mTangent;
                    fArr[i] = (float) interpolate(d10, d11, d12, d13, dArr4[i7][i], dArr4[i9][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                return (getSlope(d6, i) * (d - d6)) + this.mY[0][i];
            }
            int i4 = length - 1;
            double d7 = dArr[i4];
            if (d >= d7) {
                return (getSlope(d7, i) * (d - d7)) + this.mY[i4][i];
            }
        } else {
            if (d <= dArr[0]) {
                return this.mY[0][i];
            }
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                return this.mY[i5][i];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            double d8 = dArr2[i3];
            if (d == d8) {
                return this.mY[i3][i];
            }
            int i6 = i3 + 1;
            double d9 = dArr2[i6];
            if (d < d9) {
                double d10 = d9 - d8;
                double d11 = (d - d8) / d10;
                double[][] dArr3 = this.mY;
                double d12 = dArr3[i3][i];
                double d13 = dArr3[i6][i];
                double[][] dArr4 = this.mTangent;
                return interpolate(d10, d11, d12, d13, dArr4[i3][i], dArr4[i6][i]);
            }
            i3 = i6;
        }
        return 0.0d;
    }
}
