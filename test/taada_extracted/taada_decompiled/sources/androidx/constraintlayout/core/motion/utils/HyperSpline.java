package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d6, double d7, double d8) {
            this.mA = d;
            this.mB = d6;
            this.mC = d7;
            this.mD = d8;
        }

        public double eval(double d) {
            return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
        }

        public double vel(double d) {
            return (((this.mC * 2.0d) + (this.mD * 3.0d * d)) * d) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i, double[] dArr) {
        double[] dArr2 = new double[i];
        double[] dArr3 = new double[i];
        double[] dArr4 = new double[i];
        int i3 = i - 1;
        int i4 = 0;
        dArr2[0] = 0.5d;
        int i5 = 1;
        for (int i6 = 1; i6 < i3; i6++) {
            dArr2[i6] = 1.0d / (4.0d - dArr2[i6 - 1]);
        }
        int i7 = i - 2;
        dArr2[i3] = 1.0d / (2.0d - dArr2[i7]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i5 < i3) {
            int i8 = i5 + 1;
            int i9 = i5 - 1;
            dArr3[i5] = (((dArr[i8] - dArr[i9]) * 3.0d) - dArr3[i9]) * dArr2[i5];
            i5 = i8;
        }
        double d = (((dArr[i3] - dArr[i7]) * 3.0d) - dArr3[i7]) * dArr2[i3];
        dArr3[i3] = d;
        dArr4[i3] = d;
        while (i7 >= 0) {
            dArr4[i7] = dArr3[i7] - (dArr2[i7] * dArr4[i7 + 1]);
            i7--;
        }
        Cubic[] cubicArr = new Cubic[i3];
        while (i4 < i3) {
            double d6 = dArr[i4];
            double d7 = dArr4[i4];
            int i10 = i4 + 1;
            double d8 = dArr[i10];
            double d9 = dArr4[i10];
            cubicArr[i4] = new Cubic((float) d6, d7, (((d8 - d6) * 3.0d) - (d7 * 2.0d)) - d9, ((d6 - d8) * 2.0d) + d7 + d9);
            i4 = i10;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d = 0.0d;
        double d6 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i = 0;
            if (d6 >= 1.0d) {
                break;
            }
            double d7 = 0.0d;
            while (i < cubicArr.length) {
                double d8 = dArr[i];
                double dEval = cubicArr[i].eval(d6);
                dArr[i] = dEval;
                double d9 = d8 - dEval;
                d7 += d9 * d9;
                i++;
            }
            if (d6 > 0.0d) {
                dSqrt += Math.sqrt(d7);
            }
            d6 += 0.1d;
        }
        while (i < cubicArr.length) {
            double d10 = dArr[i];
            double dEval2 = cubicArr[i].eval(1.0d);
            dArr[i] = dEval2;
            double d11 = d10 - dEval2;
            d += d11 * d11;
            i++;
        }
        return Math.sqrt(d) + dSqrt;
    }

    public void getPos(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i++;
        }
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr[i3] = this.mCurve[i3][i].eval(d6 / this.mCurveLength[i]);
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i++;
        }
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr[i3] = this.mCurve[i3][i].vel(d6 / this.mCurveLength[i]);
        }
    }

    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i3 = 0; i3 < this.mDimensionality; i3++) {
            for (int i4 = 0; i4 < this.mPoints; i4++) {
                this.mCtl[i3][i4] = dArr[i4][i3];
            }
        }
        int i5 = 0;
        while (true) {
            i = this.mDimensionality;
            if (i5 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i5];
            cubicArr[i5] = calcNaturalCubic(dArr2.length, dArr2);
            i5++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i];
        for (int i6 = 0; i6 < this.mCurveLength.length; i6++) {
            for (int i7 = 0; i7 < this.mDimensionality; i7++) {
                cubicArr2[i7] = this.mCurve[i7][i6];
            }
            double d = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double dApproxLength = approxLength(cubicArr2);
            dArr3[i6] = dApproxLength;
            this.mTotalLength = d + dApproxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d, float[] fArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i++;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = (float) this.mCurve[i3][i].eval(d6 / this.mCurveLength[i]);
        }
    }

    public double getPos(double d, int i) {
        double[] dArr;
        double d6 = d * this.mTotalLength;
        int i3 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i3 >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i3];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i3++;
        }
        return this.mCurve[i][i3].eval(d6 / dArr[i3]);
    }
}
