package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import k0.AbstractC0573c;
import n0.C0695a;

/* JADX INFO: renamed from: com.google.android.material.datepicker.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0340c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f2413a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0.j f2414f;

    public C0340c(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, n0.j jVar, Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f2413a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f2414f = jVar;
    }

    public static C0340c a(Context context, int i) {
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, V.a.f1362p);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListA = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListA2 = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListA3 = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        n0.j jVarA = n0.j.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C0695a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new C0340c(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, jVarA, rect);
    }

    public final void b(TextView textView) {
        n0.f fVar = new n0.f();
        n0.f fVar2 = new n0.f();
        n0.j jVar = this.f2414f;
        fVar.setShapeAppearanceModel(jVar);
        fVar2.setShapeAppearanceModel(jVar);
        fVar.k(this.c);
        fVar.f4177a.f4169j = this.e;
        fVar.invalidateSelf();
        n0.e eVar = fVar.f4177a;
        ColorStateList colorStateList = eVar.d;
        ColorStateList colorStateList2 = this.d;
        if (colorStateList != colorStateList2) {
            eVar.d = colorStateList2;
            fVar.onStateChange(fVar.getState());
        }
        ColorStateList colorStateList3 = this.b;
        textView.setTextColor(colorStateList3);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3.withAlpha(30), fVar, fVar2);
        Rect rect = this.f2413a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
