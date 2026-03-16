package com.google.android.material.transformation;

import Z.a;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    public AnimatorSet b;

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void a(View view, View view2, boolean z6, boolean z7) {
        AnimatorSet animatorSet = this.b;
        boolean z8 = animatorSet != null;
        if (z8) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetB = b(view, view2, z6, z8);
        this.b = animatorSetB;
        animatorSetB.addListener(new a(this, 2));
        this.b.start();
        if (z7) {
            return;
        }
        this.b.end();
    }

    public abstract AnimatorSet b(View view, View view2, boolean z6, boolean z7);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
