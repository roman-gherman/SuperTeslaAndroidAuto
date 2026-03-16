package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i = MotionKey.UNSET;
        this.mCurveFit = i;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f6, float f7, float f8, float f9) {
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f13 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f14 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f11) + (f12 * f10) + f6);
        this.mCalculatedPositionY = (int) ((f11 * f14) + (f10 * f13) + f7);
    }

    private void calcPathPosition(float f6, float f7, float f8, float f9) {
        float f10 = f8 - f6;
        float f11 = f9 - f7;
        float f12 = this.mPercentX;
        float f13 = (f10 * f12) + f6;
        float f14 = this.mPercentY;
        this.mCalculatedPositionX = ((-f11) * f14) + f13;
        this.mCalculatedPositionY = (f10 * f14) + (f11 * f12) + f7;
    }

    private void calcScreenPosition(int i, int i3) {
        float f6 = this.mPercentX;
        float f7 = 0;
        this.mCalculatedPositionX = (i * f6) + f7;
        this.mCalculatedPositionY = (i3 * f6) + f7;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> map) {
    }

    public void calcPosition(int i, int i3, float f6, float f7, float f8, float f9) {
        int i4 = this.mPositionType;
        if (i4 == 1) {
            calcPathPosition(f6, f7, f8, f9);
        } else if (i4 != 2) {
            calcCartesianPosition(f6, f7, f8, f9);
        } else {
            calcScreenPosition(i, i3);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return TypedValues.PositionType.getId(str);
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i, int i3, FloatRect floatRect, FloatRect floatRect2, float f6, float f7) {
        calcPosition(i, i3, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        return Math.abs(f6 - this.mCalculatedPositionX) < SELECTION_SLOPE && Math.abs(f7 - this.mCalculatedPositionY) < SELECTION_SLOPE;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f6, float f7, String[] strArr, float[] fArr) {
        int i = this.mPositionType;
        if (i == 1) {
            positionPathAttributes(floatRect, floatRect2, f6, f7, strArr, fArr);
        } else if (i != 2) {
            positionCartAttributes(floatRect, floatRect2, f6, f7, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f6, f7, strArr, fArr);
        }
    }

    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f6, float f7, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f6 - fCenterX) / fCenterX2;
            strArr[1] = "percentY";
            fArr[1] = (f7 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f6 - fCenterX) / fCenterX2;
            fArr[1] = (f7 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f6 - fCenterX) / fCenterX2;
            fArr[0] = (f7 - fCenterY) / fCenterY2;
        }
    }

    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f6, float f7, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f8 = fCenterX2 / fHypot;
        float f9 = fCenterY2 / fHypot;
        float f10 = f7 - fCenterY;
        float f11 = f6 - fCenterX;
        float f12 = ((f8 * f10) - (f11 * f9)) / fHypot;
        float f13 = ((f9 * f10) + (f8 * f11)) / fHypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f13;
                fArr[1] = f12;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f13;
        fArr[1] = f12;
    }

    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f6, float f7, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f6 / width;
            strArr[1] = "percentY";
            fArr[1] = f7 / height;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f6 / width;
            fArr[1] = f7 / height;
        } else {
            fArr[1] = f6 / width;
            fArr[0] = f7 / height;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i3) {
        if (i == 100) {
            this.mFramePosition = i3;
            return true;
        }
        if (i == 508) {
            this.mCurveFit = i3;
            return true;
        }
        if (i != 510) {
            return super.setValue(i, i3);
        }
        this.mPositionType = i3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public MotionKey mo7clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f6) {
        switch (i) {
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                this.mPercentWidth = f6;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                this.mPercentHeight = f6;
                return true;
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                this.mPercentWidth = f6;
                this.mPercentHeight = f6;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                this.mPercentX = f6;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                this.mPercentY = f6;
                return true;
            default:
                return super.setValue(i, f6);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 501) {
            return super.setValue(i, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
