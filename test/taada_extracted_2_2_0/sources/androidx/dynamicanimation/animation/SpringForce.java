package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new DynamicAnimation.MassState();
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == UNSET) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.mDampingRatio;
        if (d > 1.0d) {
            double d6 = this.mNaturalFreq;
            this.mGammaPlus = (Math.sqrt((d * d) - 1.0d) * d6) + ((-d) * d6);
            double d7 = this.mDampingRatio;
            double d8 = this.mNaturalFreq;
            this.mGammaMinus = ((-d7) * d8) - (Math.sqrt((d7 * d7) - 1.0d) * d8);
        } else if (d >= 0.0d && d < 1.0d) {
            this.mDampedFreq = Math.sqrt(1.0d - (d * d)) * this.mNaturalFreq;
        }
        this.mInitialized = true;
    }

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float f6, float f7) {
        float finalPosition = f6 - getFinalPosition();
        double d = this.mNaturalFreq;
        return (float) (((-(d * d)) * ((double) finalPosition)) - (((d * 2.0d) * this.mDampingRatio) * ((double) f7)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d = this.mNaturalFreq;
        return (float) (d * d);
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float f6, float f7) {
        return ((double) Math.abs(f7)) < this.mVelocityThreshold && ((double) Math.abs(f6 - getFinalPosition())) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.mDampingRatio = f6;
        this.mInitialized = false;
        return this;
    }

    public SpringForce setFinalPosition(float f6) {
        this.mFinalPosition = f6;
        return this;
    }

    public SpringForce setStiffness(float f6) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = Math.sqrt(f6);
        this.mInitialized = false;
        return this;
    }

    public void setValueThreshold(double d) {
        double dAbs = Math.abs(d);
        this.mValueThreshold = dAbs;
        this.mVelocityThreshold = dAbs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation.MassState updateValues(double d, double d6, long j6) {
        double dSin;
        double dCos;
        init();
        double d7 = j6 / 1000.0d;
        double d8 = d - this.mFinalPosition;
        double d9 = this.mDampingRatio;
        if (d9 > 1.0d) {
            double d10 = this.mGammaMinus;
            double d11 = this.mGammaPlus;
            double d12 = d8 - (((d10 * d8) - d6) / (d10 - d11));
            double d13 = ((d8 * d10) - d6) / (d10 - d11);
            dSin = (Math.pow(2.718281828459045d, this.mGammaPlus * d7) * d13) + (Math.pow(2.718281828459045d, d10 * d7) * d12);
            double d14 = this.mGammaMinus;
            double dPow = Math.pow(2.718281828459045d, d14 * d7) * d12 * d14;
            double d15 = this.mGammaPlus;
            dCos = (Math.pow(2.718281828459045d, d15 * d7) * d13 * d15) + dPow;
        } else if (d9 == 1.0d) {
            double d16 = this.mNaturalFreq;
            double d17 = (d16 * d8) + d6;
            double d18 = (d17 * d7) + d8;
            double dPow2 = Math.pow(2.718281828459045d, (-d16) * d7) * d18;
            double dPow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d7) * d18;
            double d19 = this.mNaturalFreq;
            dCos = (Math.pow(2.718281828459045d, (-d19) * d7) * d17) + (dPow3 * (-d19));
            dSin = dPow2;
        } else {
            double d20 = 1.0d / this.mDampedFreq;
            double d21 = this.mNaturalFreq;
            double d22 = ((d9 * d21 * d8) + d6) * d20;
            dSin = ((Math.sin(this.mDampedFreq * d7) * d22) + (Math.cos(this.mDampedFreq * d7) * d8)) * Math.pow(2.718281828459045d, (-d9) * d21 * d7);
            double d23 = this.mNaturalFreq;
            double d24 = this.mDampingRatio;
            double d25 = (-d23) * dSin * d24;
            double dPow4 = Math.pow(2.718281828459045d, (-d24) * d23 * d7);
            double d26 = this.mDampedFreq;
            double dSin2 = Math.sin(d26 * d7) * (-d26) * d8;
            double d27 = this.mDampedFreq;
            dCos = (((Math.cos(d27 * d7) * d22 * d27) + dSin2) * dPow4) + d25;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (dSin + this.mFinalPosition);
        massState.mVelocity = (float) dCos;
        return massState;
    }

    public SpringForce(float f6) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f6;
    }
}
