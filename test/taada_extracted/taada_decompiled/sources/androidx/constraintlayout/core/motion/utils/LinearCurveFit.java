package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i = 0;
        double d = 0.0d;
        while (true) {
            double d6 = d;
            if (i >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d7 = dArr2[i][0];
            if (i > 0) {
                Math.hypot(d7 - d, d7 - d6);
            }
            i++;
            d = d7;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d <= dArr[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d >= dArr[i]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i3 = 0;
        while (i3 < i) {
            double[] dArr2 = this.mY[i3];
            double d8 = dArr2[0];
            double d9 = dArr2[1];
            if (i3 > 0) {
                dHypot += Math.hypot(d8 - d6, d9 - d7);
            }
            double[] dArr3 = this.mT;
            double d10 = dArr3[i3];
            if (d == d10) {
                return dHypot;
            }
            int i4 = i3 + 1;
            double d11 = dArr3[i4];
            if (d < d11) {
                double d12 = (d - d10) / (d11 - d10);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i3];
                double d13 = dArr5[0];
                double[] dArr6 = dArr4[i4];
                double d14 = dArr6[0];
                double d15 = 1.0d - d12;
                return Math.hypot(d9 - ((dArr6[1] * d12) + (dArr5[1] * d15)), d8 - ((d14 * d12) + (d13 * d15))) + dHypot;
            }
            i3 = i4;
            d6 = d8;
            d7 = d9;
        }
        return 0.0d;
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
                double d10 = (d - d9) / (d8 - d9);
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i] = (dArr4[i9][i] * d10) + ((1.0d - d10) * dArr4[i7][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r13 = r4[r0]
            double r6 = r6 - r13
        L2c:
            if (r3 >= r2) goto L41
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
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
                double d10 = (d - d9) / (d8 - d9);
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i] = (float) ((dArr3[i9][i] * d10) + ((1.0d - d10) * dArr3[i7][i]));
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double d6;
        double d7;
        double slope;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (this.mExtrapolate) {
            double d8 = dArr[0];
            if (d <= d8) {
                d6 = this.mY[0][i];
                d7 = d - d8;
                slope = getSlope(d8, i);
            } else {
                int i4 = length - 1;
                double d9 = dArr[i4];
                if (d >= d9) {
                    d6 = this.mY[i4][i];
                    d7 = d - d9;
                    slope = getSlope(d9, i);
                }
            }
            return (slope * d7) + d6;
        }
        if (d <= dArr[0]) {
            return this.mY[0][i];
        }
        int i5 = length - 1;
        if (d >= dArr[i5]) {
            return this.mY[i5][i];
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            double d10 = dArr2[i3];
            if (d == d10) {
                return this.mY[i3][i];
            }
            int i6 = i3 + 1;
            double d11 = dArr2[i6];
            if (d < d11) {
                double d12 = (d - d10) / (d11 - d10);
                double[][] dArr3 = this.mY;
                return (dArr3[i6][i] * d12) + ((1.0d - d12) * dArr3[i3][i]);
            }
            i3 = i6;
        }
        return 0.0d;
    }
}
