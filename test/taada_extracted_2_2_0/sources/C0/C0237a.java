package c0;

import android.animation.ValueAnimator;
import com.google.android.material.textfield.i;

/* JADX INFO: renamed from: c0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0237a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1724a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0237a(Object obj, int i) {
        this.f1724a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1724a) {
            case 0:
                C0239c c0239c = (C0239c) this.b;
                c0239c.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c0239c.f1730j.setAlpha((int) (255.0f * fFloatValue));
                c0239c.x = fFloatValue;
                break;
            default:
                i iVar = (i) this.b;
                iVar.getClass();
                iVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
