package W;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f1379a = new LinearInterpolator();
    public static final FastOutSlowInInterpolator b = new FastOutSlowInInterpolator();
    public static final FastOutLinearInInterpolator c = new FastOutLinearInInterpolator();
    public static final LinearOutSlowInInterpolator d = new LinearOutSlowInInterpolator();

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f6, float f7, float f8) {
        return B2.b.a(f7, f6, f8, f6);
    }

    public static float b(float f6, float f7, float f8, float f9, float f10) {
        return f10 <= f8 ? f6 : f10 >= f9 ? f7 : a(f6, f7, (f10 - f8) / (f9 - f8));
    }

    public static int c(int i, int i3, float f6) {
        return Math.round(f6 * (i3 - i)) + i;
    }
}
