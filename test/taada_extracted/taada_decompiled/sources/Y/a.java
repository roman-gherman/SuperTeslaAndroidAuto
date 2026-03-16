package Y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import fr.sd.taada.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import n0.C0695a;
import n0.f;
import n0.i;
import n0.j;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable implements TextDrawableHelper$TextDrawableDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1462a;
    public final f b;
    public final l c;
    public final Rect d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1465h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference f1468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference f1469m;

    public a(Context context, BadgeState$State badgeState$State) {
        k0.f fVar;
        WeakReference weakReference = new WeakReference(context);
        this.f1462a = weakReference;
        o.c(context, o.b, "Theme.MaterialComponents");
        this.d = new Rect();
        l lVar = new l(this);
        this.c = lVar;
        TextPaint textPaint = lVar.f2503a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        b bVar = new b(context, badgeState$State);
        this.e = bVar;
        boolean zA = bVar.a();
        BadgeState$State badgeState$State2 = bVar.b;
        f fVar2 = new f(j.a(context, zA ? badgeState$State2.f2187g.intValue() : badgeState$State2.e.intValue(), bVar.a() ? badgeState$State2.f2188h.intValue() : badgeState$State2.f2186f.intValue(), new C0695a(0)).a());
        this.b = fVar2;
        c();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && lVar.f2504f != (fVar = new k0.f(context2, badgeState$State2.d.intValue()))) {
            lVar.b(fVar, context2);
            textPaint.setColor(badgeState$State2.c.intValue());
            invalidateSelf();
            e();
            invalidateSelf();
        }
        this.f1465h = ((int) Math.pow(10.0d, ((double) badgeState$State2.f2190k) - 1.0d)) - 1;
        lVar.d = true;
        e();
        invalidateSelf();
        lVar.d = true;
        c();
        e();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(badgeState$State2.b.intValue());
        if (fVar2.f4177a.c != colorStateListValueOf) {
            fVar2.k(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(badgeState$State2.c.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f1468l;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f1468l.get();
            WeakReference weakReference3 = this.f1469m;
            d(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        e();
        setVisible(badgeState$State2.q.booleanValue(), false);
    }

    public final String a() {
        int iB = b();
        int i = this.f1465h;
        b bVar = this.e;
        if (iB <= i) {
            return NumberFormat.getInstance(bVar.b.f2191l).format(b());
        }
        Context context = (Context) this.f1462a.get();
        return context == null ? "" : String.format(bVar.b.f2191l, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f1465h), Marker.ANY_NON_NULL_MARKER);
    }

    public final int b() {
        b bVar = this.e;
        if (bVar.a()) {
            return bVar.b.f2189j;
        }
        return 0;
    }

    public final void c() {
        Context context = (Context) this.f1462a.get();
        if (context == null) {
            return;
        }
        b bVar = this.e;
        boolean zA = bVar.a();
        BadgeState$State badgeState$State = bVar.b;
        this.b.setShapeAppearanceModel(j.a(context, zA ? badgeState$State.f2187g.intValue() : badgeState$State.e.intValue(), bVar.a() ? badgeState$State.f2188h.intValue() : badgeState$State.f2186f.intValue(), new C0695a(0)).a());
        invalidateSelf();
    }

    public final void d(View view, FrameLayout frameLayout) {
        this.f1468l = new WeakReference(view);
        this.f1469m = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        e();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (this.e.a()) {
            Rect rect = new Rect();
            String strA = a();
            l lVar = this.c;
            lVar.f2503a.getTextBounds(strA, 0, strA.length(), rect);
            canvas.drawText(strA, this.f1463f, this.f1464g + (rect.height() / 2), lVar.f2503a);
        }
    }

    public final void e() {
        Context context = (Context) this.f1462a.get();
        WeakReference weakReference = this.f1468l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.d;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference2 = this.f1469m;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect3);
        }
        b bVar = this.e;
        float f6 = !bVar.a() ? bVar.c : bVar.d;
        this.i = f6;
        if (f6 != -1.0f) {
            this.f1467k = f6;
            this.f1466j = f6;
        } else {
            this.f1467k = Math.round((!bVar.a() ? bVar.f1471f : bVar.f1473h) / 2.0f);
            this.f1466j = Math.round((!bVar.a() ? bVar.e : bVar.f1472g) / 2.0f);
        }
        if (b() > 9) {
            this.f1466j = Math.max(this.f1466j, (this.c.a(a()) / 2.0f) + bVar.i);
        }
        boolean zA = bVar.a();
        BadgeState$State badgeState$State = bVar.b;
        int iIntValue = zA ? badgeState$State.u.intValue() : badgeState$State.f2197s.intValue();
        int i = bVar.f1476l;
        if (i == 0) {
            iIntValue -= Math.round(this.f1467k);
        }
        int iIntValue2 = badgeState$State.f2200w.intValue() + iIntValue;
        int iIntValue3 = badgeState$State.f2195p.intValue();
        if (iIntValue3 == 8388691 || iIntValue3 == 8388693) {
            this.f1464g = rect3.bottom - iIntValue2;
        } else {
            this.f1464g = rect3.top + iIntValue2;
        }
        int iIntValue4 = bVar.a() ? badgeState$State.f2198t.intValue() : badgeState$State.f2196r.intValue();
        if (i == 1) {
            iIntValue4 += bVar.a() ? bVar.f1475k : bVar.f1474j;
        }
        int iIntValue5 = badgeState$State.f2199v.intValue() + iIntValue4;
        int iIntValue6 = badgeState$State.f2195p.intValue();
        if (iIntValue6 == 8388659 || iIntValue6 == 8388691) {
            this.f1463f = ViewCompat.getLayoutDirection(view) == 0 ? (rect3.left - this.f1466j) + iIntValue5 : (rect3.right + this.f1466j) - iIntValue5;
        } else {
            this.f1463f = ViewCompat.getLayoutDirection(view) == 0 ? (rect3.right + this.f1466j) - iIntValue5 : (rect3.left - this.f1466j) + iIntValue5;
        }
        float f7 = this.f1463f;
        float f8 = this.f1464g;
        float f9 = this.f1466j;
        float f10 = this.f1467k;
        rect2.set((int) (f7 - f9), (int) (f8 - f10), (int) (f7 + f9), (int) (f8 + f10));
        float f11 = this.i;
        f fVar = this.b;
        if (f11 != -1.0f) {
            i iVarE = fVar.f4177a.f4165a.e();
            iVarE.e = new C0695a(f11);
            iVarE.f4194f = new C0695a(f11);
            iVarE.f4195g = new C0695a(f11);
            iVarE.f4196h = new C0695a(f11);
            fVar.setShapeAppearanceModel(iVarE.a());
        }
        if (rect.equals(rect2)) {
            return;
        }
        fVar.setBounds(rect2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.e.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate
    public final void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        b bVar = this.e;
        bVar.f1470a.i = i;
        bVar.b.i = i;
        this.c.f2503a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
