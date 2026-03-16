package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        public static Interpolator createPathInterpolator(float f6, float f7) {
            return new PathInterpolator(f6, f7);
        }

        public static Interpolator createPathInterpolator(float f6, float f7, float f8, float f9) {
            return new PathInterpolator(f6, f7, f8, f9);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    public static Interpolator create(float f6, float f7) {
        return Api21Impl.createPathInterpolator(f6, f7);
    }

    public static Interpolator create(float f6, float f7, float f8, float f9) {
        return Api21Impl.createPathInterpolator(f6, f7, f8, f9);
    }
}
