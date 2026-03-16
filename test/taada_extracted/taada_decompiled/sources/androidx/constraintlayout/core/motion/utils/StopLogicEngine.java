package androidx.constraintlayout.core.motion.utils;

import B2.b;

/* JADX INFO: loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f6) {
        this.mDone = false;
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            float f8 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f8) * f6) * f6) / (f7 * 2.0f)) + (f8 * f6);
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return this.mStage1EndPosition;
        }
        float f9 = f6 - f7;
        float f10 = this.mStage2Duration;
        if (f9 < f10) {
            float f11 = this.mStage1EndPosition;
            float f12 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f12) * f9) * f9) / (f10 * 2.0f)) + (f12 * f9) + f11;
        }
        if (i == 2) {
            return this.mStage2EndPosition;
        }
        float f13 = f9 - f10;
        float f14 = this.mStage3Duration;
        if (f13 > f14) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f15 = this.mStage2EndPosition;
        float f16 = this.mStage3Velocity;
        return ((f16 * f13) + f15) - (((f16 * f13) * f13) / (f14 * 2.0f));
    }

    private void setup(float f6, float f7, float f8, float f9, float f10) {
        this.mDone = false;
        if (f6 == 0.0f) {
            f6 = 1.0E-4f;
        }
        this.mStage1Velocity = f6;
        float f11 = f6 / f8;
        float f12 = (f11 * f6) / 2.0f;
        if (f6 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f7 - ((((-f6) / f8) * f6) / 2.0f)) * f8);
            if (fSqrt < f9) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f6;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f13 = (fSqrt - f6) / f8;
                this.mStage1Duration = f13;
                this.mStage2Duration = fSqrt / f8;
                this.mStage1EndPosition = ((f6 + fSqrt) * f13) / 2.0f;
                this.mStage2EndPosition = f7;
                this.mStage3EndPosition = f7;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f9;
            this.mStage3Velocity = f9;
            float f14 = (f9 - f6) / f8;
            this.mStage1Duration = f14;
            float f15 = f9 / f8;
            this.mStage3Duration = f15;
            float f16 = ((f6 + f9) * f14) / 2.0f;
            float f17 = (f15 * f9) / 2.0f;
            this.mStage2Duration = ((f7 - f16) - f17) / f9;
            this.mStage1EndPosition = f16;
            this.mStage2EndPosition = f7 - f17;
            this.mStage3EndPosition = f7;
            return;
        }
        if (f12 >= f7) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f7;
            this.mStage1Duration = (2.0f * f7) / f6;
            return;
        }
        float f18 = f7 - f12;
        float f19 = f18 / f6;
        if (f19 + f11 < f10) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f6;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f18;
            this.mStage2EndPosition = f7;
            this.mStage1Duration = f19;
            this.mStage2Duration = f11;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f6 * f6) / 2.0f) + (f8 * f7));
        float f20 = (fSqrt2 - f6) / f8;
        this.mStage1Duration = f20;
        float f21 = fSqrt2 / f8;
        this.mStage2Duration = f21;
        if (fSqrt2 < f9) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f20;
            this.mStage2Duration = f21;
            this.mStage1EndPosition = ((f6 + fSqrt2) * f20) / 2.0f;
            this.mStage2EndPosition = f7;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f6;
        this.mStage2Velocity = f9;
        this.mStage3Velocity = f9;
        float f22 = (f9 - f6) / f8;
        this.mStage1Duration = f22;
        float f23 = f9 / f8;
        this.mStage3Duration = f23;
        float f24 = ((f6 + f9) * f22) / 2.0f;
        float f25 = (f23 * f9) / 2.0f;
        this.mStage2Duration = ((f7 - f24) - f25) / f9;
        this.mStage1EndPosition = f24;
        this.mStage2EndPosition = f7 - f25;
        this.mStage3EndPosition = f7;
    }

    public void config(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.mDone = false;
        this.mStartPosition = f6;
        boolean z6 = f6 > f7;
        this.mBackwards = z6;
        if (z6) {
            setup(-f8, f6 - f7, f10, f11, f9);
        } else {
            setup(f8, f7 - f6, f10, f11, f9);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f6) {
        StringBuilder sbL = b.l(b.h(b.l(str, " ===== "), this.mType, "\n"), str);
        sbL.append(this.mBackwards ? "backwards" : "forward ");
        sbL.append(" time = ");
        sbL.append(f6);
        sbL.append("  stages ");
        String str2 = b.g(sbL, "\n", this.mNumberOfStages) + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str2 = str2 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str2 = str2 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            return b.f(str2, str, "stage 0\n");
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return b.f(str2, str, "end stage 0\n");
        }
        float f8 = f6 - f7;
        float f9 = this.mStage2Duration;
        return f8 < f9 ? b.f(str2, str, " stage 1\n") : i == 2 ? b.f(str2, str, "end stage 1\n") : f8 - f9 < this.mStage3Duration ? b.f(str2, str, " stage 2\n") : b.f(str2, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f6) {
        float fCalcY = calcY(f6);
        this.mLastPosition = f6;
        return this.mBackwards ? this.mStartPosition - fCalcY : this.mStartPosition + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f6) {
        float f7;
        float f8;
        float f9 = this.mStage1Duration;
        if (f6 <= f9) {
            f7 = this.mStage1Velocity;
            f8 = this.mStage2Velocity;
        } else {
            int i = this.mNumberOfStages;
            if (i == 1) {
                return 0.0f;
            }
            f6 -= f9;
            f9 = this.mStage2Duration;
            if (f6 >= f9) {
                if (i == 2) {
                    return this.mStage2EndPosition;
                }
                float f10 = f6 - f9;
                float f11 = this.mStage3Duration;
                if (f10 >= f11) {
                    return this.mStage3EndPosition;
                }
                float f12 = this.mStage3Velocity;
                return f12 - ((f10 * f12) / f11);
            }
            f7 = this.mStage2Velocity;
            f8 = this.mStage3Velocity;
        }
        return (((f8 - f7) * f6) / f9) + f7;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
