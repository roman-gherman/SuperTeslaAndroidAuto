package androidx.constraintlayout.core.motion.utils;

import B2.b;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    public static class CoreSpline extends KeyCycleOscillator {
        String type;
        int typeId;

        public CoreSpline(String str) {
            this.type = str;
            this.typeId = TypedValues.CycleType.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f6) {
            motionWidget.setValue(this.typeId, get(f6));
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        CurveFit mCurveFit;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        float[] mPhase;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i, String str, int i3, int i4) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = i;
            this.mVariesBy = i3;
            oscillator.setType(i, str);
            this.mValues = new float[i4];
            this.mPosition = new double[i4];
            this.mPeriod = new float[i4];
            this.mOffset = new float[i4];
            this.mPhase = new float[i4];
            this.mScale = new float[i4];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d = f6;
                curveFit.getSlope(d, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d6 = f6;
            double value = this.mOscillator.getValue(d6, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d6, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f6, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mPhase[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f6, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i, int i3, float f6, float f7, float f8, float f9) {
            this.mPosition[i] = ((double) i3) / 100.0d;
            this.mPeriod[i] = f6;
            this.mOffset[i] = f7;
            this.mPhase[i] = f8;
            this.mValues[i] = f9;
        }

        public void setup(float f6) {
            this.mPathLength = f6;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                double[] dArr3 = dArr[i];
                dArr3[0] = this.mOffset[i];
                dArr3[1] = this.mPhase[i];
                dArr3[2] = this.mValues[i];
                this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i, int i3) {
            int i4 = iArr[i3];
            int i5 = i;
            while (i < i3) {
                if (iArr[i] <= i4) {
                    swap(iArr, fArr, i5, i);
                    i5++;
                }
                i++;
            }
            swap(iArr, fArr, i5, i3);
            return i5;
        }

        public static void sort(int[] iArr, float[] fArr, int i, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = iArr2[i4 - 1];
                int i6 = i4 - 2;
                int i7 = iArr2[i6];
                if (i5 < i7) {
                    int iPartition = partition(iArr, fArr, i5, i7);
                    iArr2[i6] = iPartition - 1;
                    iArr2[i4 - 1] = i5;
                    int i8 = i4 + 1;
                    iArr2[i4] = i7;
                    i4 += 2;
                    iArr2[i8] = iPartition + 1;
                } else {
                    i4 = i6;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, int i, int i3) {
            int i4 = iArr[i];
            iArr[i] = iArr[i3];
            iArr[i3] = i4;
            float f6 = fArr[i];
            fArr[i] = fArr[i3];
            fArr[i3] = f6;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i, int i3) {
            int i4 = iArr[i3];
            int i5 = i;
            while (i < i3) {
                if (iArr[i] <= i4) {
                    swap(iArr, fArr, fArr2, i5, i);
                    i5++;
                }
                i++;
            }
            swap(iArr, fArr, fArr2, i5, i3);
            return i5;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = iArr2[i4 - 1];
                int i6 = i4 - 2;
                int i7 = iArr2[i6];
                if (i5 < i7) {
                    int iPartition = partition(iArr, fArr, fArr2, i5, i7);
                    iArr2[i6] = iPartition - 1;
                    iArr2[i4 - 1] = i5;
                    int i8 = i4 + 1;
                    iArr2[i4] = i7;
                    i4 += 2;
                    iArr2[i8] = iPartition + 1;
                } else {
                    i4 = i6;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i, int i3) {
            int i4 = iArr[i];
            iArr[i] = iArr[i3];
            iArr[i3] = i4;
            float f6 = fArr[i];
            fArr[i] = fArr[i3];
            fArr[i3] = f6;
            float f7 = fArr2[i];
            fArr2[i] = fArr2[i3];
            fArr2[i3] = f7;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String type;
        int typeId;

        public PathRotateSet(String str) {
            this.type = str;
            this.typeId = TypedValues.CycleType.getId(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f6, double d, double d6) {
            motionWidget.setRotationZ(get(f6) + ((float) Math.toDegrees(Math.atan2(d6, d))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f6) {
            motionWidget.setValue(this.typeId, get(f6));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i, float f6, float f7, float f8, float f9) {
            this.mPosition = i;
            this.mValue = f9;
            this.mOffset = f7;
            this.mPeriod = f6;
            this.mPhase = f8;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f6) {
        return (float) this.mCycleOscillator.getValues(f6);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f6) {
        return (float) this.mCycleOscillator.getSlope(f6);
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i, int i3, String str, int i4, float f6, float f7, float f8, float f9, Object obj) {
        this.mWavePoints.add(new WavePoint(i, f6, f7, f8, f9));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f6) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f6) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        int i = 0;
        for (WavePoint wavePoint : this.mWavePoints) {
            float f7 = wavePoint.mPeriod;
            dArr[i] = ((double) f7) * 0.01d;
            double[] dArr3 = dArr2[i];
            float f8 = wavePoint.mValue;
            dArr3[0] = f8;
            float f9 = wavePoint.mOffset;
            dArr3[1] = f9;
            float f10 = wavePoint.mPhase;
            dArr3[2] = f10;
            this.mCycleOscillator.setPoint(i, wavePoint.mPosition, f7, f9, f10, f8);
            i++;
        }
        this.mCycleOscillator.setup(f6);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (WavePoint wavePoint : this.mWavePoints) {
            StringBuilder sbL = b.l(string, "[");
            sbL.append(wavePoint.mPosition);
            sbL.append(" , ");
            sbL.append(decimalFormat.format(wavePoint.mValue));
            sbL.append("] ");
            string = sbL.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i, int i3, String str, int i4, float f6, float f7, float f8, float f9) {
        this.mWavePoints.add(new WavePoint(i, f6, f7, f8, f9));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
        this.mWaveString = str;
    }
}
