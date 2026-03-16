package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        double f1587x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        double f1588x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        double f1589y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        double f1590y2;

        public CubicEasing(String str) {
            this.str = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f1587x1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i);
            this.f1589y1 = Double.parseDouble(str.substring(i, iIndexOf3).trim());
            int i3 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i3);
            this.f1588x2 = Double.parseDouble(str.substring(i3, iIndexOf4).trim());
            int i4 = iIndexOf4 + 1;
            this.f1590y2 = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double getDiffX(double d) {
            double d6 = 1.0d - d;
            double d7 = this.f1587x1;
            double d8 = d6 * 3.0d * d6 * d7;
            double d9 = this.f1588x2;
            return ((1.0d - d9) * 3.0d * d * d) + ((d9 - d7) * d6 * 6.0d * d) + d8;
        }

        private double getDiffY(double d) {
            double d6 = 1.0d - d;
            double d7 = this.f1589y1;
            double d8 = d6 * 3.0d * d6 * d7;
            double d9 = this.f1590y2;
            return ((1.0d - d9) * 3.0d * d * d) + ((d9 - d7) * d6 * 6.0d * d) + d8;
        }

        private double getX(double d) {
            double d6 = 1.0d - d;
            double d7 = 3.0d * d6;
            double d8 = d6 * d7 * d;
            double d9 = d7 * d * d;
            return (this.f1588x2 * d9) + (this.f1587x1 * d8) + (d * d * d);
        }

        private double getY(double d) {
            double d6 = 1.0d - d;
            double d7 = 3.0d * d6;
            double d8 = d6 * d7 * d;
            double d9 = d7 * d * d;
            return (this.f1590y2 * d9) + (this.f1589y1 * d8) + (d * d * d);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > error) {
                d6 *= 0.5d;
                d7 = getX(d7) < d ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double x = getX(d8);
            double d9 = d7 + d6;
            double x6 = getX(d9);
            double y = getY(d8);
            return (((d - x) * (getY(d9) - y)) / (x6 - x)) + y;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d) {
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > d_error) {
                d6 *= 0.5d;
                d7 = getX(d7) < d ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double d9 = d7 + d6;
            return (getY(d9) - getY(d8)) / (getX(d9) - getX(d8));
        }

        public void setup(double d, double d6, double d7, double d8) {
            this.f1587x1 = d;
            this.f1589y1 = d6;
            this.f1588x2 = d7;
            this.f1590y2 = d8;
        }

        public CubicEasing(double d, double d6, double d7, double d8) {
            setup(d, d6, d7, d8);
        }
    }
}
