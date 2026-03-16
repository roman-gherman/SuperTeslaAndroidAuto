package androidx.transition;

import B2.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    private static float toTangent(float f6) {
        if (f6 < 0.0f || f6 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f6 / 2.0f));
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f6, float f7, float f8, float f9) {
        float fA;
        float fA2;
        float f10;
        Path path = new Path();
        path.moveTo(f6, f7);
        float f11 = f8 - f6;
        float f12 = f9 - f7;
        float f13 = (f12 * f12) + (f11 * f11);
        float f14 = (f6 + f8) / 2.0f;
        float f15 = (f7 + f9) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z6 = f7 > f9;
        if (Math.abs(f11) < Math.abs(f12)) {
            float fAbs = Math.abs(f13 / (f12 * 2.0f));
            if (z6) {
                fA2 = fAbs + f9;
                fA = f8;
            } else {
                fA2 = fAbs + f7;
                fA = f6;
            }
            f10 = this.mMinimumVerticalTangent;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z6) {
                fA2 = f7;
                fA = f17 + f6;
            } else {
                fA = f8 - f17;
                fA2 = f9;
            }
            f10 = this.mMinimumHorizontalTangent;
        }
        float f18 = f16 * f10 * f10;
        float f19 = f14 - fA;
        float f20 = f15 - fA2;
        float f21 = (f20 * f20) + (f19 * f19);
        float f22 = this.mMaximumTangent;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f18 / f21);
            fA = b.a(fA, f14, fSqrt, f14);
            fA2 = b.a(fA2, f15, fSqrt, f15);
        }
        path.cubicTo((f6 + fA) / 2.0f, (f7 + fA2) / 2.0f, (fA + f8) / 2.0f, (fA2 + f9) / 2.0f, f8, f9);
        return path;
    }

    public void setMaximumAngle(float f6) {
        this.mMaximumAngle = f6;
        this.mMaximumTangent = toTangent(f6);
    }

    public void setMinimumHorizontalAngle(float f6) {
        this.mMinimumHorizontalAngle = f6;
        this.mMinimumHorizontalTangent = toTangent(f6);
    }

    public void setMinimumVerticalAngle(float f6) {
        this.mMinimumVerticalAngle = f6;
        this.mMinimumVerticalTangent = toTangent(f6);
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        typedArrayObtainStyledAttributes.recycle();
    }
}
