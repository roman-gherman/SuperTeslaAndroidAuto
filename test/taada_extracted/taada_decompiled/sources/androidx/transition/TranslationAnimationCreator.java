package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
class TranslationAnimationCreator {

    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        public TransitionPositionListener(View view, View view2, int i, int i3, float f6, float f7) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i - Math.round(view.getTranslationX());
            this.mStartY = i3 - Math.round(view.getTranslationY());
            this.mTerminalX = f6;
            this.mTerminalY = f7;
            int[] iArr = (int[]) view2.getTag(R.id.transition_position);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(this.mMovingView.getTranslationX() + this.mStartX);
            this.mTransitionPosition[1] = Math.round(this.mMovingView.getTranslationY() + this.mStartY);
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    private TranslationAnimationCreator() {
    }

    public static Animator createAnimation(View view, TransitionValues transitionValues, int i, int i3, float f6, float f7, float f8, float f9, TimeInterpolator timeInterpolator, Transition transition) {
        float f10;
        float f11;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transition_position)) != null) {
            f10 = (r5[0] - i) + translationX;
            f11 = (r5[1] - i3) + translationY;
        } else {
            f10 = f6;
            f11 = f7;
        }
        int iRound = Math.round(f10 - translationX) + i;
        int iRound2 = Math.round(f11 - translationY) + i3;
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        if (f10 == f8 && f11 == f9) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f10, f8), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f11, f9));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, iRound, iRound2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.addPauseListener(objectAnimatorOfPropertyValuesHolder, transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
