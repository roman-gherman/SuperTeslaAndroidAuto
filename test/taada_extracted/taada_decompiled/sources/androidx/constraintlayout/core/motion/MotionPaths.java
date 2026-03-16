package androidx.constraintlayout.core.motion;

import B2.b;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
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

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
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
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
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
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
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
        CustomVariable customVariable = this.customAttributes.get(str);
        int i3 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i3 < iNumberOfInterpolatedValues) {
            dArr[i] = r2[i3];
            i3++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
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
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
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
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
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
        float f22 = Float.isNaN(motionKeyPosition.mPercentX) ? f17 : motionKeyPosition.mPercentX;
        float f23 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f17 = motionKeyPosition.mPercentY;
        }
        float f24 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((f24 * f19) + ((f22 * f18) + motionPaths.x)) - f20);
        this.y = (int) (((f19 * f17) + ((f18 * f23) + motionPaths.y)) - f21);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.width - motionPaths.width;
        float f10 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f6 = motionKeyPosition.mPercentX;
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
        float f22 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f23 = (int) ((motionPaths.x + f18) - f19);
        float f24 = (int) ((motionPaths.y + f20) - f21);
        this.x = f23 + ((-f17) * f22);
        this.y = f24 + (f16 * f22);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fA;
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = motionPaths2.height;
        float f12 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f9 - f10) * f7) + f10);
        this.height = (int) (((f11 - f12) * f8) + f12);
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            float f13 = Float.isNaN(motionKeyPosition.mPercentX) ? f6 : motionKeyPosition.mPercentX;
            float f14 = motionPaths2.x;
            float f15 = motionPaths.x;
            this.x = b.a(f14, f15, f13, f15);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f6 = motionKeyPosition.mPercentY;
            }
            float f16 = motionPaths2.y;
            float f17 = motionPaths.y;
            this.y = b.a(f16, f17, f6, f17);
        } else if (i4 != 2) {
            float f18 = Float.isNaN(motionKeyPosition.mPercentX) ? f6 : motionKeyPosition.mPercentX;
            float f19 = motionPaths2.x;
            float f20 = motionPaths.x;
            this.x = b.a(f19, f20, f18, f20);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f6 = motionKeyPosition.mPercentY;
            }
            float f21 = motionPaths2.y;
            float f22 = motionPaths.y;
            this.y = b.a(f21, f22, f6, f22);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f23 = motionPaths2.x;
                float f24 = motionPaths.x;
                fMin = b.a(f23, f24, f6, f24);
            } else {
                fMin = Math.min(f8, f7) * motionKeyPosition.mPercentX;
            }
            this.x = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f25 = motionPaths2.y;
                float f26 = motionPaths.y;
                fA = b.a(f25, f26, f6, f26);
            } else {
                fA = motionKeyPosition.mPercentY;
            }
            this.y = fA;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
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
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.x = (int) (motionKeyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.y = (int) (motionKeyPosition.mPercentY * ((int) (i3 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
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

    public void setView(float f6, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
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
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f6, fArr, fArr2);
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
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin2, f22)) + ((double) f17)));
            }
        } else if (!Float.isNaN(f17)) {
            motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2((f14 / 2.0f) + f12, (f13 / 2.0f) + f11)) + ((double) f17) + ((double) 0.0f)));
        }
        float f23 = fSin + 0.5f;
        float f24 = fCos + 0.5f;
        motionWidget.layout((int) f23, (int) f24, (int) (f23 + f8), (int) (f24 + f9));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (((this.width / 2.0f) + this.x) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d6 = (((this.height / 2.0f) + this.y) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
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

    public MotionPaths(int i, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i, i3, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i4 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i3, motionKeyPosition, motionPaths, motionPaths2);
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
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
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
