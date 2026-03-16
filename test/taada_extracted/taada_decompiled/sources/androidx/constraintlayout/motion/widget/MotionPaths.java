package androidx.constraintlayout.motion.widget;

import B2.b;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths() {
        int i = Key.UNSET;
        this.mPathMotionArc = i;
        this.mAnimateRelativeTo = i;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f6, float f7) {
        return (Float.isNaN(f6) || Float.isNaN(f7)) ? Float.isNaN(f6) != Float.isNaN(f7) : Math.abs(f6 - f7) > 1.0E-6f;
    }

    private static final float xRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return (((f10 - f8) * f7) - ((f11 - f9) * f6)) + f8;
    }

    private static final float yRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return ((f11 - f9) * f7) + ((f10 - f8) * f6) + f9;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z6) {
        boolean zDiff = diff(this.x, motionPaths.x);
        boolean zDiff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z7 = zDiff | zDiff2 | z6;
        zArr[1] = zArr[1] | z7;
        zArr[2] = z7 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i3 : iArr) {
            if (i3 < 6) {
                dArr[i] = fArr[r2];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f6 = this.width;
        float f7 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f8 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 3) {
                f6 = f8;
            } else if (i4 == 4) {
                f7 = f8;
            }
        }
        fArr[i] = f6;
        fArr[i + 1] = f7;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.x;
        float fCos = this.y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f8 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fSin = f8;
            } else if (i4 == 2) {
                fCos = f8;
            } else if (i4 == 3) {
                f6 = f8;
            } else if (i4 == 4) {
                f7 = f8;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = f9;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f6 / 2.0f)));
            fCos = (float) ((((double) f10) - (Math.cos(d8) * d7)) - ((double) (f7 / 2.0f)));
        }
        fArr[i] = (f6 / 2.0f) + fSin + 0.0f;
        fArr[i + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.x;
        float fCos = this.y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f8 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fSin = f8;
            } else if (i4 == 2) {
                fCos = f8;
            } else if (i4 == 3) {
                f6 = f8;
            } else if (i4 == 4) {
                f7 = f8;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = f9;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f6 / 2.0f)));
            fCos = (float) ((((double) f10) - (Math.cos(d8) * d7)) - ((double) (f7 / 2.0f)));
        }
        fArr[i] = (f6 / 2.0f) + fSin + 0.0f;
        fArr[i + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        int i3 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        constraintAttribute.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i3 < iNumberOfInterpolatedValues) {
            dArr[i] = r2[i3];
            i3++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f6 = this.x;
        float fCos = this.y;
        float f7 = this.width;
        float f8 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f9 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f6 = f9;
            } else if (i4 == 2) {
                fCos = f9;
            } else if (i4 == 3) {
                f7 = f9;
            } else if (i4 == 4) {
                f8 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = f6;
            double d6 = fCos;
            float fSin = (float) (((Math.sin(d6) * d) + ((double) centerX)) - ((double) (f7 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d6) * d)) - ((double) (f8 / 2.0f)));
            f6 = fSin;
        }
        float f10 = f7 + f6;
        float f11 = f8 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f6 + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f10 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f10 + 0.0f;
        fArr[i + 5] = f11 + 0.0f;
        fArr[i + 6] = f6 + 0.0f;
        fArr[i + 7] = f11 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = f9 - f10;
        float f12 = motionPaths2.height;
        float f13 = motionPaths.height;
        float f14 = f12 - f13;
        this.position = this.time;
        float f15 = motionPaths.x;
        float f16 = motionPaths.y;
        float f17 = f6;
        float f18 = ((f9 / 2.0f) + motionPaths2.x) - ((f10 / 2.0f) + f15);
        float f19 = ((f12 / 2.0f) + motionPaths2.y) - ((f13 / 2.0f) + f16);
        float f20 = (f11 * f7) / 2.0f;
        this.x = (int) (((f18 * f17) + f15) - f20);
        float f21 = (f14 * f8) / 2.0f;
        this.y = (int) (((f19 * f17) + f16) - f21);
        this.width = (int) (f10 + r9);
        this.height = (int) (f13 + r12);
        float f22 = Float.isNaN(keyPosition.mPercentX) ? f17 : keyPosition.mPercentX;
        float f23 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f17 = keyPosition.mPercentY;
        }
        float f24 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((f24 * f19) + ((f22 * f18) + motionPaths.x)) - f20);
        this.y = (int) (((f19 * f17) + ((f18 * f23) + motionPaths.y)) - f21);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width - motionPaths.width;
        float f10 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f6 = keyPosition.mPercentX;
        }
        float f11 = motionPaths.x;
        float f12 = motionPaths.width;
        float f13 = motionPaths.y;
        float f14 = motionPaths.height;
        float f15 = f6;
        float f16 = ((motionPaths2.width / 2.0f) + motionPaths2.x) - ((f12 / 2.0f) + f11);
        float f17 = ((motionPaths2.height / 2.0f) + motionPaths2.y) - ((f14 / 2.0f) + f13);
        float f18 = f16 * f15;
        float f19 = (f9 * f7) / 2.0f;
        this.x = (int) ((f11 + f18) - f19);
        float f20 = f17 * f15;
        float f21 = (f10 * f8) / 2.0f;
        this.y = (int) ((f13 + f20) - f21);
        this.width = (int) (f12 + r7);
        this.height = (int) (f14 + r8);
        float f22 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f23 = (int) ((motionPaths.x + f18) - f19);
        float f24 = (int) ((motionPaths.y + f20) - f21);
        this.x = f23 + ((-f17) * f22);
        this.y = f24 + (f16 * f22);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPolar(int i, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fA;
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = motionPaths2.height;
        float f12 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f9 - f10) * f7) + f10);
        this.height = (int) (((f11 - f12) * f8) + f12);
        int i4 = keyPosition.mPositionType;
        if (i4 == 1) {
            float f13 = Float.isNaN(keyPosition.mPercentX) ? f6 : keyPosition.mPercentX;
            float f14 = motionPaths2.x;
            float f15 = motionPaths.x;
            this.x = b.a(f14, f15, f13, f15);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f6 = keyPosition.mPercentY;
            }
            float f16 = motionPaths2.y;
            float f17 = motionPaths.y;
            this.y = b.a(f16, f17, f6, f17);
        } else if (i4 != 2) {
            float f18 = Float.isNaN(keyPosition.mPercentX) ? f6 : keyPosition.mPercentX;
            float f19 = motionPaths2.x;
            float f20 = motionPaths.x;
            this.x = b.a(f19, f20, f18, f20);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f6 = keyPosition.mPercentY;
            }
            float f21 = motionPaths2.y;
            float f22 = motionPaths.y;
            this.y = b.a(f21, f22, f6, f22);
        } else {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f23 = motionPaths2.x;
                float f24 = motionPaths.x;
                fMin = b.a(f23, f24, f6, f24);
            } else {
                fMin = Math.min(f8, f7) * keyPosition.mPercentX;
            }
            this.x = fMin;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f25 = motionPaths2.y;
                float f26 = motionPaths.y;
                fA = b.a(f25, f26, f6, f26);
            } else {
                fA = keyPosition.mPercentY;
            }
            this.y = fA;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f6 : keyPosition.mPercentWidth;
        float f8 = Float.isNaN(keyPosition.mPercentHeight) ? f6 : keyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = f9 - motionPaths.width;
        float f11 = motionPaths2.height;
        float f12 = f11 - motionPaths.height;
        this.position = this.time;
        float f13 = motionPaths.x;
        float f14 = motionPaths.y;
        float f15 = (f9 / 2.0f) + motionPaths2.x;
        float f16 = (f11 / 2.0f) + motionPaths2.y;
        float f17 = f10 * f7;
        this.x = (int) ((((f15 - ((r8 / 2.0f) + f13)) * f6) + f13) - (f17 / 2.0f));
        float f18 = f12 * f8;
        this.y = (int) ((((f16 - ((r11 / 2.0f) + f14)) * f6) + f14) - (f18 / 2.0f));
        this.width = (int) (r8 + f17);
        this.height = (int) (r11 + f18);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.x = (int) (keyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.y = (int) (keyPosition.mPercentY * ((int) (i3 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f6, float f7, float f8, float f9) {
        this.x = f6;
        this.y = f7;
        this.width = f8;
        this.height = f9;
    }

    public void setDpDt(float f6, float f7, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f12 = (float) dArr[i];
            double d = dArr2[i];
            int i3 = iArr[i];
            if (i3 == 1) {
                f8 = f12;
            } else if (i3 == 2) {
                f10 = f12;
            } else if (i3 == 3) {
                f9 = f12;
            } else if (i3 == 4) {
                f11 = f12;
            }
        }
        float f13 = f8 - ((0.0f * f9) / 2.0f);
        float f14 = f10 - ((0.0f * f11) / 2.0f);
        fArr[0] = (((f9 * 1.0f) + f13) * f6) + ((1.0f - f6) * f13) + 0.0f;
        fArr[1] = (((f11 * 1.0f) + f14) * f7) + ((1.0f - f7) * f14) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float f6, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z6) {
        float f7;
        float fSin = this.x;
        float fCos = this.y;
        float f8 = this.width;
        float f9 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            double[] dArr4 = this.mTempValue;
            int i4 = iArr[i3];
            dArr4[i4] = dArr[i3];
            this.mTempDelta[i4] = dArr2[i3];
        }
        float f10 = Float.NaN;
        int i5 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i5 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i5]) && (dArr3 == null || dArr3[i5] == 0.0d)) {
                f7 = f10;
            } else {
                double d = dArr3 != null ? dArr3[i5] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i5])) {
                    d = this.mTempValue[i5] + d;
                }
                f7 = f10;
                float f15 = (float) d;
                float f16 = (float) this.mTempDelta[i5];
                if (i5 == 1) {
                    f10 = f7;
                    f11 = f16;
                    fSin = f15;
                } else if (i5 == 2) {
                    f10 = f7;
                    f12 = f16;
                    fCos = f15;
                } else if (i5 == 3) {
                    f10 = f7;
                    f13 = f16;
                    f8 = f15;
                } else if (i5 == 4) {
                    f10 = f7;
                    f14 = f16;
                    f9 = f15;
                } else if (i5 == 5) {
                    f10 = f15;
                }
                i5++;
            }
            f10 = f7;
            i5++;
        }
        float f17 = f10;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f6, fArr, fArr2);
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr2[0];
            float f21 = fArr2[1];
            double d6 = f18;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f19) - (Math.cos(d8) * d7)) - ((double) (f9 / 2.0f)));
            double d9 = f20;
            double d10 = f11;
            double dSin = (Math.sin(d8) * d10) + d9;
            double dCos = Math.cos(d8) * d7;
            double d11 = f12;
            float f22 = (float) ((dCos * d11) + dSin);
            float fSin2 = (float) ((Math.sin(d8) * d7 * d11) + (((double) f21) - (Math.cos(d8) * d10)));
            if (dArr2.length >= 2) {
                dArr2[0] = f22;
                dArr2[1] = fSin2;
            }
            if (!Float.isNaN(f17)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2(fSin2, f22)) + ((double) f17)));
            }
        } else if (!Float.isNaN(f17)) {
            view.setRotation((float) (Math.toDegrees(Math.atan2((f14 / 2.0f) + f12, (f13 / 2.0f) + f11)) + ((double) f17) + ((double) 0.0f)));
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(fSin, fCos, f8 + fSin, f9 + fCos);
            return;
        }
        float f23 = fSin + 0.5f;
        int i6 = (int) f23;
        float f24 = fCos + 0.5f;
        int i7 = (int) f24;
        int i8 = (int) (f23 + f8);
        int i9 = (int) (f24 + f9);
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        if (i10 != view.getMeasuredWidth() || i11 != view.getMeasuredHeight() || z6) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY));
        }
        view.layout(i6, i7, i8, i9);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d = (((this.width / 2.0f) + this.x) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d6 = (((this.height / 2.0f) + this.y) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motionController;
        this.x = (float) Math.hypot(d6, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d6, d) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i4 = Key.UNSET;
        this.mPathMotionArc = i4;
        this.mAnimateRelativeTo = i4;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i, i3, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i5 = keyPosition.mPositionType;
        if (i5 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i5 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i3, keyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f6;
        float fSin = this.x;
        float fCos = this.y;
        float f7 = this.width;
        float f8 = this.height;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f13 = (float) dArr[i];
            float f14 = (float) dArr2[i];
            int i3 = iArr[i];
            if (i3 == 1) {
                fSin = f13;
                f9 = f14;
            } else if (i3 == 2) {
                fCos = f13;
                f11 = f14;
            } else if (i3 == 3) {
                f7 = f13;
                f10 = f14;
            } else if (i3 == 4) {
                f8 = f13;
                f12 = f14;
            }
        }
        float f15 = (f10 / 2.0f) + f9;
        float fSin2 = (f12 / 2.0f) + f11;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d, fArr3, fArr4);
            float f16 = fArr3[0];
            float f17 = fArr3[1];
            float f18 = fArr4[0];
            float f19 = fArr4[1];
            f6 = 2.0f;
            double d6 = fSin;
            double d7 = fCos;
            fSin = (float) (((Math.sin(d7) * d6) + ((double) f16)) - ((double) (f7 / 2.0f)));
            fCos = (float) ((((double) f17) - (Math.cos(d7) * d6)) - ((double) (f8 / 2.0f)));
            double d8 = f9;
            double dSin = (Math.sin(d7) * d8) + ((double) f18);
            double d9 = f11;
            float fCos2 = (float) ((Math.cos(d7) * d9) + dSin);
            fSin2 = (float) ((Math.sin(d7) * d9) + (((double) f19) - (Math.cos(d7) * d8)));
            f15 = fCos2;
        } else {
            f6 = 2.0f;
        }
        fArr[0] = (f7 / f6) + fSin + 0.0f;
        fArr[1] = (f8 / f6) + fCos + 0.0f;
        fArr2[0] = f15;
        fArr2[1] = fSin2;
    }
}
