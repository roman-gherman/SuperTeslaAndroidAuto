package s0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: renamed from: s0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0807a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4754a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public C0807a(boolean z6, View view, View view2) {
        this.f4754a = z6;
        this.b = view;
        this.c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f4754a) {
            return;
        }
        this.b.setVisibility(4);
        View view = this.c;
        view.setAlpha(1.0f);
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f4754a) {
            this.b.setVisibility(0);
            View view = this.c;
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }
}
