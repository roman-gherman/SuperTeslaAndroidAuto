package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f6, float f7) {
            return f7 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f6, float f7) {
            return Math.abs(f7) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f6) {
            this.mFriction = f6 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f6) {
            this.mVelocityThreshold = f6 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f6, float f7, long j6) {
            float f8 = j6;
            this.mMassState.mVelocity = (float) (Math.exp((f8 / 1000.0f) * this.mFriction) * ((double) f7));
            DynamicAnimation.MassState massState = this.mMassState;
            float f9 = this.mFriction;
            massState.mValue = (float) ((Math.exp((f9 * f8) / 1000.0f) * ((double) (f7 / f9))) + ((double) (f6 - (f7 / f9))));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f6, float f7) {
        return this.mFlingForce.getAcceleration(f6, f7);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f6, float f7) {
        return f6 >= this.mMaxValue || f6 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f6, f7);
    }

    public FlingAnimation setFriction(float f6) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f6);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f6) {
        this.mFlingForce.setValueThreshold(f6);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j6) {
        DynamicAnimation.MassState massStateUpdateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j6);
        float f6 = massStateUpdateValueAndVelocity.mValue;
        this.mValue = f6;
        float f7 = massStateUpdateValueAndVelocity.mVelocity;
        this.mVelocity = f7;
        float f8 = this.mMinValue;
        if (f6 < f8) {
            this.mValue = f8;
            return true;
        }
        float f9 = this.mMaxValue;
        if (f6 <= f9) {
            return isAtEquilibrium(f6, f7);
        }
        this.mValue = f9;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f6) {
        super.setMaxValue(f6);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f6) {
        super.setMinValue(f6);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f6) {
        super.setStartVelocity(f6);
        return this;
    }

    public <K> FlingAnimation(K k6, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k6, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
