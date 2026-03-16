package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    private final WeakReference<View> mView;
    Runnable mStartAction = null;
    Runnable mEndAction = null;
    int mOldLayerType = -1;

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static ViewPropertyAnimator withEndAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        public static ViewPropertyAnimator withLayer(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        public static ViewPropertyAnimator withStartAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    public static class Api18Impl {
        private Api18Impl() {
        }

        public static Interpolator getInterpolator(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.translationZ(f6);
        }

        public static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.translationZBy(f6);
        }

        public static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.z(f6);
        }

        public static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f6) {
            return viewPropertyAnimator.zBy(f6);
        }
    }

    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        public ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.mVpa.mOldLayerType;
            if (i > -1) {
                view.setLayerType(i, null);
                this.mVpa.mOldLayerType = -1;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mEndAction = null;
                runnable.run();
            }
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            this.mAnimEndCalled = false;
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(2, null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mStartAction = null;
                runnable.run();
            }
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f6);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return Api18Impl.getInterpolator(view.animate());
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.mView.get();
        if (view != null) {
            Api19Impl.setUpdateListener(view.animate(), viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            } : null);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZ(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZBy(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withEndAction(view.animate(), runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withLayer(view.animate());
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.withStartAction(view.animate(), runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.z(view.animate(), f6);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f6) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.zBy(view.animate(), f6);
        }
        return this;
    }
}
