package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.textfield.i;
import com.google.android.material.transformation.ExpandableTransformationBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1494a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1494a = i;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1494a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.b).f2204h = null;
                break;
            case 1:
                i iVar = (i) this.b;
                iVar.q();
                iVar.f2670r.start();
                break;
            default:
                ((ExpandableTransformationBehavior) this.b).b = null;
                break;
        }
    }
}
