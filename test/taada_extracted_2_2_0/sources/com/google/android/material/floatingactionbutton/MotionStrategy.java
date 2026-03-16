package com.google.android.material.floatingactionbutton;

import W.f;
import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface MotionStrategy {
    void addAnimationListener(Animator.AnimatorListener animatorListener);

    AnimatorSet createAnimator();

    f getCurrentMotionSpec();

    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    f getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(a aVar);

    void performNow();

    void removeAnimationListener(Animator.AnimatorListener animatorListener);

    void setMotionSpec(f fVar);

    boolean shouldCancel();
}
