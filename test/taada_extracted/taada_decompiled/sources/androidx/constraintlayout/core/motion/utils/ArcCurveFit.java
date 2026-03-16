package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i, double d, double d6, double d7, double d8, double d9, double d10) {
            this.linear = false;
            this.mVertical = i == 1;
            this.mTime1 = d;
            this.mTime2 = d6;
            this.mOneOverDeltaTime = 1.0d / (d6 - d);
            if (3 == i) {
                this.linear = true;
            }
            double d11 = d9 - d7;
            double d12 = d10 - d8;
            if (!this.linear && Math.abs(d11) >= EPSILON && Math.abs(d12) >= EPSILON) {
                this.mLut = new double[101];
                boolean z6 = this.mVertical;
                this.mEllipseA = d11 * ((double) (z6 ? -1 : 1));
                this.mEllipseB = d12 * ((double) (z6 ? 1 : -1));
                this.mEllipseCenterX = z6 ? d9 : d7;
                this.mEllipseCenterY = z6 ? d8 : d10;
                buildTable(d7, d8, d9, d10);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d7;
            this.mX2 = d9;
            this.mY1 = d8;
            this.mY2 = d10;
            double dHypot = Math.hypot(d12, d11);
            this.mArcDistance = dHypot;
            this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
            double d13 = this.mTime2;
            double d14 = this.mTime1;
            this.mEllipseCenterX = d11 / (d13 - d14);
            this.mEllipseCenterY = d12 / (d13 - d14);
        }

        private void buildTable(double d, double d6, double d7, double d8) {
            double d9 = d7 - d;
            double d10 = d6 - d8;
            int i = 0;
            double dHypot = 0.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            while (true) {
                if (i >= ourPercent.length) {
                    break;
                }
                int i3 = i;
                double radians = Math.toRadians((((double) i) * 90.0d) / ((double) (r15.length - 1)));
                double dSin = Math.sin(radians) * d9;
                double dCos = Math.cos(radians) * d10;
                if (i3 > 0) {
                    dHypot += Math.hypot(dSin - d11, dCos - d12);
                    ourPercent[i3] = dHypot;
                }
                i = i3 + 1;
                d11 = dSin;
                d12 = dCos;
            }
            this.mArcDistance = dHypot;
            int i4 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i4 >= dArr.length) {
                    break;
                }
                dArr[i4] = dArr[i4] / dHypot;
                i4++;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= this.mLut.length) {
                    return;
                }
                double length = ((double) i5) / ((double) (r1.length - 1));
                int iBinarySearch = Arrays.binarySearch(ourPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i5] = ((double) iBinarySearch) / ((double) (ourPercent.length - 1));
                } else if (iBinarySearch == -1) {
                    this.mLut[i5] = 0.0d;
                } else {
                    int i6 = -iBinarySearch;
                    int i7 = i6 - 2;
                    double[] dArr2 = ourPercent;
                    double d13 = dArr2[i7];
                    this.mLut[i5] = (((length - d13) / (dArr2[i6 - 1] - d13)) + ((double) i7)) / ((double) (dArr2.length - 1));
                }
                i5++;
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * dHypot : d * dHypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d6 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, d6);
            return this.mVertical ? (-d6) * dHypot : d6 * dHypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mX1;
            return ((this.mX2 - d7) * d6) + d7;
        }

        public double getLinearY(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mY1;
            return ((this.mY2 - d7) * d6) + d7;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * ((double) (dArr.length - 1));
            int i = (int) length;
            double d6 = length - ((double) i);
            double d7 = dArr[i];
            return ((dArr[i + 1] - d7) * d6) + d7;
        }

        public void setPoint(double d) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcCurveFit(int[] r24, double[] r25, double[][] r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r0.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.mArcs = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L55
            r8 = r24[r4]
            r9 = 3
            if (r8 == 0) goto L32
            if (r8 == r2) goto L30
            r10 = 2
            if (r8 == r10) goto L2e
            if (r8 == r9) goto L29
            r9 = r6
            goto L32
        L29:
            if (r5 != r2) goto L30
            goto L2e
        L2c:
            r9 = r5
            goto L32
        L2e:
            r5 = r10
            goto L2c
        L30:
            r5 = r2
            goto L2c
        L32:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r26[r4]
            r15 = r14[r3]
            r17 = r14[r2]
            r14 = r26[r6]
            r19 = r14[r3]
            r21 = r14[r2]
            r14 = r15
            r16 = r17
            r18 = r19
            r20 = r21
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L16
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.linear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d6) * d7) + arc.getLinearX(d6);
                    dArr[1] = (d7 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6);
                    return;
                }
                arc.setPoint(d6);
                dArr[0] = (this.mArcs[0].getDX() * d7) + this.mArcs[0].getX();
                dArr[1] = (d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d8) * d9) + arc2.getLinearX(d8);
                    dArr[1] = (d9 * this.mArcs[length].getLinearDY(d8)) + this.mArcs[length].getLinearY(d8);
                    return;
                }
                arc2.setPoint(d);
                dArr[0] = (this.mArcs[length].getDX() * d9) + this.mArcs[length].getX();
                dArr[1] = (d9 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            }
            if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i];
            if (d <= arc3.mTime2) {
                if (arc3.linear) {
                    dArr[0] = arc3.getLinearX(d);
                    dArr[1] = this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d);
                    dArr[1] = this.mArcs[i].getLinearDY(d);
                    return;
                } else {
                    arc.setPoint(d);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        }
        if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i3];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    if (i == 0) {
                        return arc.getLinearDX(d);
                    }
                    return arc.getLinearDY(d);
                }
                arc.setPoint(d);
                if (i == 0) {
                    return this.mArcs[i3].getDX();
                }
                return this.mArcs[i3].getDY();
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.linear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d6) * d7) + arc.getLinearX(d6));
                    fArr[1] = (float) ((d7 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6));
                    return;
                }
                arc.setPoint(d6);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d7) + this.mArcs[0].getX());
                fArr[1] = (float) ((d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d8) * d9) + arc2.getLinearX(d8));
                    fArr[1] = (float) ((d9 * this.mArcs[length].getLinearDY(d8)) + this.mArcs[length].getLinearY(d8));
                    return;
                }
                arc2.setPoint(d);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i];
            if (d <= arc3.mTime2) {
                if (arc3.linear) {
                    fArr[0] = (float) arc3.getLinearX(d);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        int i3 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.linear) {
                    if (i == 0) {
                        return (d7 * this.mArcs[0].getLinearDX(d6)) + arc.getLinearX(d6);
                    }
                    return (d7 * this.mArcs[0].getLinearDY(d6)) + arc.getLinearY(d6);
                }
                arc.setPoint(d6);
                if (i == 0) {
                    return (d7 * this.mArcs[0].getDX()) + this.mArcs[0].getX();
                }
                return (d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                if (i == 0) {
                    return (d9 * this.mArcs[length].getLinearDX(d8)) + arcArr[length].getLinearX(d8);
                }
                return (d9 * this.mArcs[length].getLinearDY(d8)) + arcArr[length].getLinearY(d8);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i3 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i3];
            if (d <= arc2.mTime2) {
                if (arc2.linear) {
                    if (i == 0) {
                        return arc2.getLinearX(d);
                    }
                    return arc2.getLinearY(d);
                }
                arc2.setPoint(d);
                if (i == 0) {
                    return this.mArcs[i3].getX();
                }
                return this.mArcs[i3].getY();
            }
            i3++;
        }
    }
}
