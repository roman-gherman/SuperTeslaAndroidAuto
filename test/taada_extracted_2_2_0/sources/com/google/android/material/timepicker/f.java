package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2754a;
    public int b;
    public final n0.f c;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.e] */
    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        n0.f fVar = new n0.f();
        this.c = fVar;
        n0.g gVar = new n0.g(0.5f);
        n0.i iVarE = fVar.f4178a.f4166a.e();
        iVarE.e = gVar;
        iVarE.f4195f = gVar;
        iVarE.f4196g = gVar;
        iVarE.f4197h = gVar;
        fVar.setShapeAppearanceModel(iVarE.a());
        this.c.k(ColorStateList.valueOf(-1));
        ViewCompat.setBackground(this, this.c);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.f1368z, R.attr.materialClockStyle, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2754a = new Runnable() { // from class: com.google.android.material.timepicker.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f2753a.a();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void a();

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f2754a;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f2754a;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.c.k(ColorStateList.valueOf(i));
    }
}
