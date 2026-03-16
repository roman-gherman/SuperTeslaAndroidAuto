package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class e extends n0.e {
    public final RectF q;

    public e(n0.j jVar, RectF rectF) {
        super(jVar);
        this.q = rectF;
    }

    @Override // n0.e, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        f fVar = new f(this);
        fVar.x = this;
        fVar.invalidateSelf();
        return fVar;
    }

    public e(e eVar) {
        super(eVar);
        this.q = eVar.q;
    }
}
