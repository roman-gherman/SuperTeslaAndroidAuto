package n0;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import h0.C0492a;

/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4165a;
    public C0492a b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f4166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f4167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4168h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint.Style f4175p;

    public e(j jVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f4166f = PorterDuff.Mode.SRC_IN;
        this.f4167g = null;
        this.f4168h = 1.0f;
        this.i = 1.0f;
        this.f4170k = 255;
        this.f4171l = 0.0f;
        this.f4172m = 0.0f;
        this.f4173n = 0;
        this.f4174o = 0;
        this.f4175p = Paint.Style.FILL_AND_STROKE;
        this.f4165a = jVar;
        this.b = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        f fVar = new f(this);
        fVar.e = true;
        return fVar;
    }

    public e(e eVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f4166f = PorterDuff.Mode.SRC_IN;
        this.f4167g = null;
        this.f4168h = 1.0f;
        this.i = 1.0f;
        this.f4170k = 255;
        this.f4171l = 0.0f;
        this.f4172m = 0.0f;
        this.f4173n = 0;
        this.f4174o = 0;
        this.f4175p = Paint.Style.FILL_AND_STROKE;
        this.f4165a = eVar.f4165a;
        this.b = eVar.b;
        this.f4169j = eVar.f4169j;
        this.c = eVar.c;
        this.d = eVar.d;
        this.f4166f = eVar.f4166f;
        this.e = eVar.e;
        this.f4170k = eVar.f4170k;
        this.f4168h = eVar.f4168h;
        this.f4174o = eVar.f4174o;
        this.i = eVar.i;
        this.f4171l = eVar.f4171l;
        this.f4172m = eVar.f4172m;
        this.f4173n = eVar.f4173n;
        this.f4175p = eVar.f4175p;
        if (eVar.f4167g != null) {
            this.f4167g = new Rect(eVar.f4167g);
        }
    }
}
