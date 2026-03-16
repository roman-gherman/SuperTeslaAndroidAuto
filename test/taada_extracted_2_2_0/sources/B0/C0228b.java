package b0;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0228b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1689a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0228b(Object obj, int i) {
        this.f1689a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1689a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                n0.f fVar = ((BottomSheetBehavior) this.b).i;
                if (fVar != null) {
                    fVar.l(fFloatValue);
                }
                break;
            case 1:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) this.b;
                textView.setScaleX(fFloatValue2);
                textView.setScaleY(fFloatValue2);
                break;
            case 2:
                ((TextInputLayout) this.b).f2638s0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                ((View) this.b).invalidate();
                break;
        }
    }
}
