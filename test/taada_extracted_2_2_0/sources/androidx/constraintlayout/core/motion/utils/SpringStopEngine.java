package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d) {
        double d6 = this.mStiffness;
        double d7 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d6 / ((double) this.mMass)) * d) * 4.0d)) + 1.0d);
        double d8 = d / ((double) iSqrt);
        int i = 0;
        while (i < iSqrt) {
            float f6 = this.mPos;
            double d9 = this.mTargetPos;
            float f7 = this.mV;
            double d10 = d6;
            double d11 = ((-d6) * (((double) f6) - d9)) - (((double) f7) * d7);
            float f8 = this.mMass;
            double d12 = d7;
            double d13 = (((d11 / ((double) f8)) * d8) / 2.0d) + ((double) f7);
            double d14 = ((((-((((d8 * d13) / 2.0d) + ((double) f6)) - d9)) * d10) - (d13 * d12)) / ((double) f8)) * d8;
            float f9 = (float) (((double) f7) + d14);
            this.mV = f9;
            float f10 = (float) ((((d14 / 2.0d) + ((double) f7)) * d8) + ((double) f6));
            this.mPos = f10;
            int i3 = this.mBoundaryMode;
            if (i3 > 0) {
                if (f10 < 0.0f && (i3 & 1) == 1) {
                    this.mPos = -f10;
                    this.mV = -f9;
                }
                float f11 = this.mPos;
                if (f11 > 1.0f && (i3 & 2) == 2) {
                    this.mPos = 2.0f - f11;
                    this.mV = -this.mV;
                }
            }
            i++;
            d6 = d10;
            d7 = d12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f6) {
        return null;
    }

    public float getAcceleration() {
        double d = this.mStiffness;
        return ((float) (((-d) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f6) {
        compute(f6 - this.mLastTime);
        this.mLastTime = f6;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = ((double) this.mPos) - this.mTargetPos;
        double d6 = this.mStiffness;
        double d7 = this.mV;
        return Math.sqrt((((d6 * d) * d) + ((d7 * d7) * ((double) this.mMass))) / d6) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f6, float f7, float f8, float f9, float f10, float f11, float f12, int i) {
        this.mTargetPos = f7;
        this.mDamping = f11;
        this.mInitialized = false;
        this.mPos = f6;
        this.mLastVelocity = f8;
        this.mStiffness = f10;
        this.mMass = f9;
        this.mStopThreshold = f12;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f6) {
        return this.mV;
    }
}
