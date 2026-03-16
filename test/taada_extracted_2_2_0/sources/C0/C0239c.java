package c0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import c4.AbstractC0246d;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.R;
import io.ktor.utils.io.jvm.javaio.q;
import l0.AbstractC0615a;
import n0.C0695a;
import n0.f;
import n0.h;
import n0.i;
import n0.j;

/* JADX INFO: renamed from: c0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0239c {
    public static final double y = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ColorDrawable f1725z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f1726a;
    public final f c;
    public final f d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1729h;
    public Drawable i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f1730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f1731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f1732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f1733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f1734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RippleDrawable f1735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayerDrawable f1736p;
    public f q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1738s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f1739t;
    public final TimeInterpolator u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1740v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1741w;
    public final Rect b = new Rect();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1737r = false;
    public float x = 0.0f;

    static {
        f1725z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public C0239c(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i3) {
        this.f1726a = materialCardView;
        f fVar = new f(materialCardView.getContext(), attributeSet, i, i3);
        this.c = fVar;
        fVar.i(materialCardView.getContext());
        fVar.m();
        i iVarE = fVar.f4178a.f4166a.e();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, V.a.d, i, R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            iVarE.e = new C0695a(dimension);
            iVarE.f4195f = new C0695a(dimension);
            iVarE.f4196g = new C0695a(dimension);
            iVarE.f4197h = new C0695a(dimension);
        }
        this.d = new f();
        h(iVarE.a());
        this.u = AbstractC0246d.y0(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, W.a.f1379a);
        this.f1740v = AbstractC0246d.x0(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.f1741w = AbstractC0246d.x0(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(q qVar, float f6) {
        if (qVar instanceof h) {
            return (float) ((1.0d - y) * ((double) f6));
        }
        if (qVar instanceof n0.c) {
            return f6 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        q qVar = this.f1733m.f4201a;
        f fVar = this.c;
        return Math.max(Math.max(b(qVar, fVar.g()), b(this.f1733m.b, fVar.f4178a.f4166a.f4202f.getCornerSize(fVar.f()))), Math.max(b(this.f1733m.c, fVar.f4178a.f4166a.f4203g.getCornerSize(fVar.f())), b(this.f1733m.d, fVar.f4178a.f4166a.f4204h.getCornerSize(fVar.f()))));
    }

    public final LayerDrawable c() {
        if (this.f1735o == null) {
            int[] iArr = AbstractC0615a.f3957a;
            this.q = new f(this.f1733m);
            this.f1735o = new RippleDrawable(this.f1731k, null, this.q);
        }
        if (this.f1736p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f1735o, this.d, this.f1730j});
            this.f1736p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f1736p;
    }

    public final C0238b d(Drawable drawable) {
        int iCeil;
        int i;
        if (this.f1726a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new C0238b(drawable, iCeil, i, iCeil, i);
    }

    public final void e(int i, int i3) {
        int iCeil;
        int iCeil2;
        int i4;
        int i5;
        if (this.f1736p != null) {
            MaterialCardView materialCardView = this.f1726a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i6 = this.f1728g;
            int i7 = (i6 & GravityCompat.END) == 8388613 ? ((i - this.e) - this.f1727f) - iCeil2 : this.e;
            int i8 = (i6 & 80) == 80 ? this.e : ((i3 - this.e) - this.f1727f) - iCeil;
            int i9 = (i6 & GravityCompat.END) == 8388613 ? this.e : ((i - this.e) - this.f1727f) - iCeil2;
            int i10 = (i6 & 80) == 80 ? ((i3 - this.e) - this.f1727f) - iCeil : this.e;
            if (ViewCompat.getLayoutDirection(materialCardView) == 1) {
                i5 = i9;
                i4 = i7;
            } else {
                i4 = i9;
                i5 = i7;
            }
            this.f1736p.setLayerInset(2, i5, i10, i4, i8);
        }
    }

    public final void f(boolean z6, boolean z7) {
        Drawable drawable = this.f1730j;
        if (drawable != null) {
            if (!z7) {
                drawable.setAlpha(z6 ? 255 : 0);
                this.x = z6 ? 1.0f : 0.0f;
                return;
            }
            float f6 = z6 ? 1.0f : 0.0f;
            float f7 = z6 ? 1.0f - this.x : this.x;
            ValueAnimator valueAnimator = this.f1739t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f1739t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.x, f6);
            this.f1739t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new C0237a(this, 0));
            this.f1739t.setInterpolator(this.u);
            this.f1739t.setDuration((long) ((z6 ? this.f1740v : this.f1741w) * f7));
            this.f1739t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f1730j = drawableMutate;
            DrawableCompat.setTintList(drawableMutate, this.f1732l);
            f(this.f1726a.isChecked(), false);
        } else {
            this.f1730j = f1725z;
        }
        LayerDrawable layerDrawable = this.f1736p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f1730j);
        }
    }

    public final void h(j jVar) {
        this.f1733m = jVar;
        f fVar = this.c;
        fVar.setShapeAppearanceModel(jVar);
        fVar.f4192v = !fVar.f4178a.f4166a.d(fVar.f());
        f fVar2 = this.d;
        if (fVar2 != null) {
            fVar2.setShapeAppearanceModel(jVar);
        }
        f fVar3 = this.q;
        if (fVar3 != null) {
            fVar3.setShapeAppearanceModel(jVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f1726a;
        if (!materialCardView.getPreventCornerOverlap()) {
            return false;
        }
        f fVar = this.c;
        return fVar.f4178a.f4166a.d(fVar.f()) && materialCardView.getUseCompatPadding();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            r6 = this;
            com.google.android.material.card.MaterialCardView r0 = r6.f1726a
            boolean r1 = r0.getPreventCornerOverlap()
            if (r1 == 0) goto L1a
            n0.f r1 = r6.c
            n0.e r2 = r1.f4178a
            n0.j r2 = r2.f4166a
            android.graphics.RectF r1 = r1.f()
            boolean r1 = r2.d(r1)
            if (r1 != 0) goto L1a
            r1 = 1
            goto L1b
        L1a:
            r1 = 0
        L1b:
            r2 = 0
            if (r1 != 0) goto L27
            boolean r1 = r6.i()
            if (r1 == 0) goto L25
            goto L27
        L25:
            r1 = r2
            goto L2b
        L27:
            float r1 = r6.a()
        L2b:
            boolean r3 = r0.getPreventCornerOverlap()
            if (r3 == 0) goto L43
            boolean r3 = r0.getUseCompatPadding()
            if (r3 == 0) goto L43
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = c0.C0239c.y
            double r2 = r2 - r4
            float r4 = r0.getCardViewRadius()
            double r4 = (double) r4
            double r2 = r2 * r4
            float r2 = (float) r2
        L43:
            float r1 = r1 - r2
            int r1 = (int) r1
            android.graphics.Rect r2 = r6.b
            int r3 = r2.left
            int r3 = r3 + r1
            int r4 = r2.top
            int r4 = r4 + r1
            int r5 = r2.right
            int r5 = r5 + r1
            int r2 = r2.bottom
            int r2 = r2 + r1
            r0.setAncestorContentPadding(r3, r4, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.C0239c.j():void");
    }

    public final void k() {
        boolean z6 = this.f1737r;
        MaterialCardView materialCardView = this.f1726a;
        if (!z6) {
            materialCardView.setBackgroundInternal(d(this.c));
        }
        materialCardView.setForeground(d(this.i));
    }
}
