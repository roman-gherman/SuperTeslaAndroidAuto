package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public final class s extends ArrayAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f2712a;
    public ColorStateList b;
    public final /* synthetic */ t c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.c = tVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        t tVar = this.c;
        ColorStateList colorStateList2 = tVar.f2715g;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.b = colorStateList;
        if (tVar.f2714f != 0 && tVar.f2715g != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{ColorUtils.compositeColors(tVar.f2715g.getColorForState(iArr3, 0), tVar.f2714f), ColorUtils.compositeColors(tVar.f2715g.getColorForState(iArr2, 0), tVar.f2714f), tVar.f2714f});
        }
        this.f2712a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            t tVar = this.c;
            Drawable rippleDrawable = null;
            if (tVar.getText().toString().contentEquals(textView.getText()) && tVar.f2714f != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(tVar.f2714f);
                if (this.b != null) {
                    DrawableCompat.setTintList(colorDrawable, this.f2712a);
                    rippleDrawable = new RippleDrawable(this.b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            ViewCompat.setBackground(textView, rippleDrawable);
        }
        return view2;
    }
}
