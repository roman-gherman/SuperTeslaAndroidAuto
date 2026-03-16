package n0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.Shapeable;
import h0.C0492a;
import java.util.BitSet;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import m0.C0630a;

/* JADX INFO: loaded from: classes.dex */
public class f extends Drawable implements TintAwareDrawable, Shapeable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Paint f4176w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f4177a;
    public final s[] b;
    public final s[] c;
    public final BitSet d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f4178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f4179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f4180h;
    public final RectF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f4181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Region f4182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Region f4183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f4184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f4185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f4186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0630a f4187p;
    public final v q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f4188r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PorterDuffColorFilter f4189s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f4190t;
    public final RectF u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4191v;

    static {
        Paint paint = new Paint(1);
        f4176w = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public f() {
        this(new j());
    }

    public final void a(RectF rectF, Path path) {
        e eVar = this.f4177a;
        this.f4188r.a(eVar.f4165a, eVar.i, rectF, this.q, path);
        if (this.f4177a.f4168h != 1.0f) {
            Matrix matrix = this.f4178f;
            matrix.reset();
            float f6 = this.f4177a.f4168h;
            matrix.setScale(f6, f6, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.u, true);
    }

    public final int b(int i) {
        int i3;
        e eVar = this.f4177a;
        float f6 = eVar.f4172m + 0.0f + eVar.f4171l;
        C0492a c0492a = eVar.b;
        if (c0492a == null || !c0492a.f3350a || ColorUtils.setAlphaComponent(i, 255) != c0492a.d) {
            return i;
        }
        float fMin = (c0492a.e <= 0.0f || f6 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f6 / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iG = com.google.android.material.color.g.g(ColorUtils.setAlphaComponent(i, 255), c0492a.b, fMin);
        if (fMin > 0.0f && (i3 = c0492a.c) != 0) {
            iG = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i3, C0492a.f3349f), iG);
        }
        return ColorUtils.setAlphaComponent(iG, iAlpha);
    }

    public final void c(Canvas canvas) {
        if (this.d.cardinality() > 0) {
            Log.w("f", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.f4177a.f4174o;
        Path path = this.f4179g;
        C0630a c0630a = this.f4187p;
        if (i != 0) {
            canvas.drawPath(path, c0630a.f4022a);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            s sVar = this.b[i3];
            int i4 = this.f4177a.f4173n;
            Matrix matrix = s.b;
            sVar.a(matrix, c0630a, i4, canvas);
            this.c[i3].a(matrix, c0630a, this.f4177a.f4173n, canvas);
        }
        if (this.f4191v) {
            double d = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d)) * ((double) this.f4177a.f4174o));
            int iCos = (int) (Math.cos(Math.toRadians(d)) * ((double) this.f4177a.f4174o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f4176w);
            canvas.translate(iSin, iCos);
        }
    }

    public final void d(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (!jVar.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = jVar.f4201f.getCornerSize(rectF) * this.f4177a.i;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f4185n;
        paint.setColorFilter(this.f4189s);
        int alpha = paint.getAlpha();
        int i = this.f4177a.f4170k;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.f4186o;
        paint2.setColorFilter(this.f4190t);
        paint2.setStrokeWidth(this.f4177a.f4169j);
        int alpha2 = paint2.getAlpha();
        int i3 = this.f4177a.f4170k;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z6 = this.e;
        Path path = this.f4179g;
        if (z6) {
            float f6 = -(h() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            j jVar = this.f4177a.f4165a;
            i iVarE = jVar.e();
            CornerSize bVar = jVar.e;
            if (!(bVar instanceof g)) {
                bVar = new b(f6, bVar);
            }
            iVarE.e = bVar;
            CornerSize bVar2 = jVar.f4201f;
            if (!(bVar2 instanceof g)) {
                bVar2 = new b(f6, bVar2);
            }
            iVarE.f4194f = bVar2;
            CornerSize bVar3 = jVar.f4203h;
            if (!(bVar3 instanceof g)) {
                bVar3 = new b(f6, bVar3);
            }
            iVarE.f4196h = bVar3;
            CornerSize bVar4 = jVar.f4202g;
            if (!(bVar4 instanceof g)) {
                bVar4 = new b(f6, bVar4);
            }
            iVarE.f4195g = bVar4;
            j jVarA = iVarE.a();
            this.f4184m = jVarA;
            float f7 = this.f4177a.i;
            RectF rectF = this.f4181j;
            rectF.set(f());
            float strokeWidth = h() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.f4188r.a(jVarA, f7, rectF, null, this.f4180h);
            a(f(), path);
            this.e = false;
        }
        e eVar = this.f4177a;
        eVar.getClass();
        if (eVar.f4173n > 0) {
            int i4 = Build.VERSION.SDK_INT;
            if (!this.f4177a.f4165a.d(f()) && !path.isConvex() && i4 < 29) {
                canvas.save();
                double d = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d)) * ((double) this.f4177a.f4174o)), (int) (Math.cos(Math.toRadians(d)) * ((double) this.f4177a.f4174o)));
                if (this.f4191v) {
                    RectF rectF2 = this.u;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f4177a.f4173n * 2) + ((int) rectF2.width()) + iWidth, (this.f4177a.f4173n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f8 = (getBounds().left - this.f4177a.f4173n) - iWidth;
                    float f9 = (getBounds().top - this.f4177a.f4173n) - iHeight;
                    canvas2.translate(-f8, -f9);
                    c(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f8, f9, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    c(canvas);
                    canvas.restore();
                }
            }
        }
        e eVar2 = this.f4177a;
        Paint.Style style = eVar2.f4175p;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            d(canvas, paint, path, eVar2.f4165a, f());
        }
        if (h()) {
            e(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public void e(Canvas canvas) {
        Paint paint = this.f4186o;
        Path path = this.f4180h;
        j jVar = this.f4184m;
        RectF rectF = this.f4181j;
        rectF.set(f());
        float strokeWidth = h() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        d(canvas, paint, path, jVar, rectF);
    }

    public final RectF f() {
        RectF rectF = this.i;
        rectF.set(getBounds());
        return rectF;
    }

    public final float g() {
        return this.f4177a.f4165a.e.getCornerSize(f());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4177a.f4170k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4177a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f4177a.getClass();
        if (this.f4177a.f4165a.d(f())) {
            outline.setRoundRect(getBounds(), g() * this.f4177a.i);
            return;
        }
        RectF rectFF = f();
        Path path = this.f4179g;
        a(rectFF, path);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            outline.setPath(path);
            return;
        }
        if (i >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f4177a.f4167g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final j getShapeAppearanceModel() {
        return this.f4177a.f4165a;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f4182k;
        region.set(bounds);
        RectF rectFF = f();
        Path path = this.f4179g;
        a(rectFF, path);
        Region region2 = this.f4183l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean h() {
        Paint.Style style = this.f4177a.f4175p;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f4186o.getStrokeWidth() > 0.0f;
    }

    public final void i(Context context) {
        this.f4177a.b = new C0492a(context);
        p();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f4177a.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f4177a.getClass();
        ColorStateList colorStateList2 = this.f4177a.d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f4177a.c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(float f6) {
        e eVar = this.f4177a;
        if (eVar.f4172m != f6) {
            eVar.f4172m = f6;
            p();
        }
    }

    public final void k(ColorStateList colorStateList) {
        e eVar = this.f4177a;
        if (eVar.c != colorStateList) {
            eVar.c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void l(float f6) {
        e eVar = this.f4177a;
        if (eVar.i != f6) {
            eVar.i = f6;
            this.e = true;
            invalidateSelf();
        }
    }

    public final void m() {
        this.f4187p.a(-12303292);
        this.f4177a.getClass();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f4177a = new e(this.f4177a);
        return this;
    }

    public final boolean n(int[] iArr) {
        boolean z6;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f4177a.c == null || color2 == (colorForState2 = this.f4177a.c.getColorForState(iArr, (color2 = (paint2 = this.f4185n).getColor())))) {
            z6 = false;
        } else {
            paint2.setColor(colorForState2);
            z6 = true;
        }
        if (this.f4177a.d == null || color == (colorForState = this.f4177a.d.getColorForState(iArr, (color = (paint = this.f4186o).getColor())))) {
            return z6;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean o() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f4189s;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f4190t;
        e eVar = this.f4177a;
        ColorStateList colorStateList = eVar.e;
        PorterDuff.Mode mode = eVar.f4166f;
        Paint paint = this.f4185n;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int iB = b(color);
            porterDuffColorFilter = iB != color ? new PorterDuffColorFilter(iB, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(b(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.f4189s = porterDuffColorFilter;
        this.f4177a.getClass();
        this.f4190t = null;
        this.f4177a.getClass();
        return (ObjectsCompat.equals(porterDuffColorFilter2, this.f4189s) && ObjectsCompat.equals(porterDuffColorFilter3, this.f4190t)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z6 = n(iArr) || o();
        if (z6) {
            invalidateSelf();
        }
        return z6;
    }

    public final void p() {
        e eVar = this.f4177a;
        float f6 = eVar.f4172m + 0.0f;
        eVar.f4173n = (int) Math.ceil(0.75f * f6);
        this.f4177a.f4174o = (int) Math.ceil(f6 * 0.25f);
        o();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        e eVar = this.f4177a;
        if (eVar.f4170k != i) {
            eVar.f4170k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4177a.getClass();
        super.invalidateSelf();
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(j jVar) {
        this.f4177a.f4165a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4177a.e = colorStateList;
        o();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        e eVar = this.f4177a;
        if (eVar.f4166f != mode) {
            eVar.f4166f = mode;
            o();
            super.invalidateSelf();
        }
    }

    public f(Context context, AttributeSet attributeSet, int i, int i3) {
        this(j.b(context, attributeSet, i, i3).a());
    }

    public f(j jVar) {
        this(new e(jVar));
    }

    public f(e eVar) {
        l lVar;
        this.b = new s[4];
        this.c = new s[4];
        this.d = new BitSet(8);
        this.f4178f = new Matrix();
        this.f4179g = new Path();
        this.f4180h = new Path();
        this.i = new RectF();
        this.f4181j = new RectF();
        this.f4182k = new Region();
        this.f4183l = new Region();
        Paint paint = new Paint(1);
        this.f4185n = paint;
        Paint paint2 = new Paint(1);
        this.f4186o = paint2;
        this.f4187p = new C0630a(ViewCompat.MEASURED_STATE_MASK);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = k.f4207a;
        } else {
            lVar = new l();
        }
        this.f4188r = lVar;
        this.u = new RectF();
        this.f4191v = true;
        this.f4177a = eVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        o();
        n(getState());
        this.q = new v(this);
    }
}
