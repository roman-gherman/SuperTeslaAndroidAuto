package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;
    private float x;
    private float y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    LinkedHashMap<String, CustomVariable> mCustomVariable = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float f6, float f7) {
        return (Float.isNaN(f6) || Float.isNaN(f7)) ? Float.isNaN(f6) != Float.isNaN(f7) : Math.abs(f6 - f7) > 1.0E-6f;
    }

    public void addValues(HashMap<String, SplineSet> map, int i) {
        SplineSet splineSet;
        for (String str : map.keySet()) {
            splineSet = map.get(str);
            str.getClass();
            switch (str) {
                case "rotationX":
                    splineSet.setPoint(i, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case "rotationY":
                    splineSet.setPoint(i, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case "rotationZ":
                    splineSet.setPoint(i, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case "translationX":
                    splineSet.setPoint(i, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case "translationY":
                    splineSet.setPoint(i, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case "translationZ":
                    splineSet.setPoint(i, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                case "progress":
                    splineSet.setPoint(i, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case "pivotX":
                    splineSet.setPoint(i, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case "pivotY":
                    splineSet.setPoint(i, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case "scaleX":
                    splineSet.setPoint(i, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case "scaleY":
                    splineSet.setPoint(i, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case "alpha":
                    splineSet.setPoint(i, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                case "pathRotate":
                    splineSet.setPoint(i, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Utils.loge("MotionPaths", "UNKNOWN spline ".concat(str));
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (this.mCustomVariable.containsKey(str2)) {
                            CustomVariable customVariable = this.mCustomVariable.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i, customVariable);
                            } else {
                                Utils.loge("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i + ", value" + customVariable.getValueToInterpolate() + splineSet);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.visibility = motionWidget.getVisibility();
        this.alpha = motionWidget.getVisibility() != 4 ? 0.0f : motionWidget.getAlpha();
        this.applyElevation = false;
        this.rotation = motionWidget.getRotationZ();
        this.rotationX = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.scaleX = motionWidget.getScaleX();
        this.scaleY = motionWidget.getScaleY();
        this.mPivotX = motionWidget.getPivotX();
        this.mPivotY = motionWidget.getPivotY();
        this.translationX = motionWidget.getTranslationX();
        this.translationY = motionWidget.getTranslationY();
        this.translationZ = motionWidget.getTranslationZ();
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomVariable.put(str, customAttribute);
            }
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("translationZ");
        }
        int i = this.visibility;
        int i3 = motionConstrainedPoint.visibility;
        if (i != i3 && this.mVisibilityMode == 0 && (i == 4 || i3 == 4)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        int i = 0;
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        for (int i3 : iArr) {
            if (i3 < 18) {
                dArr[i] = fArr[r4];
                i++;
            }
        }
    }

    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.mCustomVariable.get(str);
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        int i3 = 0;
        while (i3 < iNumberOfInterpolatedValues) {
            dArr[i] = r1[i3];
            i3++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        return this.mCustomVariable.get(str).numberOfInterpolatedValues();
    }

    public boolean hasCustomData(String str) {
        return this.mCustomVariable.containsKey(str);
    }

    public void setBounds(float f6, float f7, float f8, float f9) {
        this.x = f6;
        this.y = f7;
        this.width = f8;
        this.height = f9;
    }

    public void setState(MotionWidget motionWidget) {
        setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i, float f6) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(motionWidget);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i == 1) {
            this.rotation = f6 - 90.0f;
        } else {
            if (i != 2) {
                return;
            }
            this.rotation = f6 + 90.0f;
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
        zArr[1] = zArr[1] | diff(this.x, motionConstrainedPoint.x);
        zArr[2] = zArr[2] | diff(this.y, motionConstrainedPoint.y);
        zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
        zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
    }
}
