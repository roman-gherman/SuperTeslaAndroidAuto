package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.g;
import com.google.android.material.shape.Shapeable;
import fr.sd.taada.R;
import l0.AbstractC0615a;
import n0.f;
import n0.j;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f2273a;
    public j b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2276h;
    public PorterDuff.Mode i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f2277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f2279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f2280m;
    public boolean q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RippleDrawable f2285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2286t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2281n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2282o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2283p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2284r = true;

    public b(MaterialButton materialButton, j jVar) {
        this.f2273a = materialButton;
        this.b = jVar;
    }

    public final Shapeable a() {
        RippleDrawable rippleDrawable = this.f2285s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f2285s.getNumberOfLayers() > 2 ? (Shapeable) this.f2285s.getDrawable(2) : (Shapeable) this.f2285s.getDrawable(1);
    }

    public final f b(boolean z6) {
        RippleDrawable rippleDrawable = this.f2285s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (f) ((LayerDrawable) ((InsetDrawable) this.f2285s.getDrawable(0)).getDrawable()).getDrawable(!z6 ? 1 : 0);
    }

    public final void c(j jVar) {
        this.b = jVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(jVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(jVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void d(int i, int i3) {
        MaterialButton materialButton = this.f2273a;
        int paddingStart = ViewCompat.getPaddingStart(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i4 = this.e;
        int i5 = this.f2274f;
        this.f2274f = i3;
        this.e = i;
        if (!this.f2282o) {
            e();
        }
        ViewCompat.setPaddingRelative(materialButton, paddingStart, (paddingTop + i) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void e() {
        f fVar = new f(this.b);
        MaterialButton materialButton = this.f2273a;
        fVar.i(materialButton.getContext());
        DrawableCompat.setTintList(fVar, this.f2277j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            DrawableCompat.setTintMode(fVar, mode);
        }
        float f6 = this.f2276h;
        ColorStateList colorStateList = this.f2278k;
        fVar.f4178a.f4170j = f6;
        fVar.invalidateSelf();
        n0.e eVar = fVar.f4178a;
        if (eVar.d != colorStateList) {
            eVar.d = colorStateList;
            fVar.onStateChange(fVar.getState());
        }
        f fVar2 = new f(this.b);
        fVar2.setTint(0);
        float f7 = this.f2276h;
        int iF = this.f2281n ? g.f(materialButton, R.attr.colorSurface) : 0;
        fVar2.f4178a.f4170j = f7;
        fVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iF);
        n0.e eVar2 = fVar2.f4178a;
        if (eVar2.d != colorStateListValueOf) {
            eVar2.d = colorStateListValueOf;
            fVar2.onStateChange(fVar2.getState());
        }
        f fVar3 = new f(this.b);
        this.f2280m = fVar3;
        DrawableCompat.setTint(fVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(AbstractC0615a.b(this.f2279l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{fVar2, fVar}), this.c, this.e, this.d, this.f2274f), this.f2280m);
        this.f2285s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        f fVarB = b(false);
        if (fVarB != null) {
            fVarB.j(this.f2286t);
            fVarB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        f fVarB = b(false);
        f fVarB2 = b(true);
        if (fVarB != null) {
            float f6 = this.f2276h;
            ColorStateList colorStateList = this.f2278k;
            fVarB.f4178a.f4170j = f6;
            fVarB.invalidateSelf();
            n0.e eVar = fVarB.f4178a;
            if (eVar.d != colorStateList) {
                eVar.d = colorStateList;
                fVarB.onStateChange(fVarB.getState());
            }
            if (fVarB2 != null) {
                float f7 = this.f2276h;
                int iF = this.f2281n ? g.f(this.f2273a, R.attr.colorSurface) : 0;
                fVarB2.f4178a.f4170j = f7;
                fVarB2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iF);
                n0.e eVar2 = fVarB2.f4178a;
                if (eVar2.d != colorStateListValueOf) {
                    eVar2.d = colorStateListValueOf;
                    fVarB2.onStateChange(fVarB2.getState());
                }
            }
        }
    }
}
