package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void onPull(EdgeEffect edgeEffect, float f6, float f7) {
            edgeEffect.onPull(f6, f7);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f6, float f7) {
            try {
                return edgeEffect.onPullDistance(f6, f7);
            } catch (Throwable unused) {
                edgeEffect.onPull(f6, f7);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f6, float f7) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.onPullDistance(edgeEffect, f6, f7);
        }
        onPull(edgeEffect, f6, f7);
        return f6;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f6) {
        this.mEdgeEffect.onPull(f6);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i3) {
        this.mEdgeEffect.setSize(i, i3);
    }

    @Deprecated
    public boolean onPull(float f6, float f7) {
        onPull(this.mEdgeEffect, f6, f7);
        return true;
    }

    public static void onPull(EdgeEffect edgeEffect, float f6, float f7) {
        Api21Impl.onPull(edgeEffect, f6, f7);
    }
}
