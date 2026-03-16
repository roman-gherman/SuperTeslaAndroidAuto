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
    public j f4166a;
    public C0492a b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f4167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f4168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4169h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4174n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4175o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint.Style f4176p;

    public e(j jVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f4167f = PorterDuff.Mode.SRC_IN;
        this.f4168g = null;
        this.f4169h = 1.0f;
        this.i = 1.0f;
        this.f4171k = 255;
        this.f4172l = 0.0f;
        this.f4173m = 0.0f;
        this.f4174n = 0;
        this.f4175o = 0;
        this.f4176p = Paint.Style.FILL_AND_STROKE;
        this.f4166a = jVar;
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
        this.f4167f = PorterDuff.Mode.SRC_IN;
        this.f4168g = null;
        this.f4169h = 1.0f;
        this.i = 1.0f;
        this.f4171k = 255;
        this.f4172l = 0.0f;
        this.f4173m = 0.0f;
        this.f4174n = 0;
        this.f4175o = 0;
        this.f4176p = Paint.Style.FILL_AND_STROKE;
        this.f4166a = eVar.f4166a;
        this.b = eVar.b;
        this.f4170j = eVar.f4170j;
        this.c = eVar.c;
        this.d = eVar.d;
        this.f4167f = eVar.f4167f;
        this.e = eVar.e;
        this.f4171k = eVar.f4171k;
        this.f4169h = eVar.f4169h;
        this.f4175o = eVar.f4175o;
        this.i = eVar.i;
        this.f4172l = eVar.f4172l;
        this.f4173m = eVar.f4173m;
        this.f4174n = eVar.f4174n;
        this.f4176p = eVar.f4176p;
        if (eVar.f4168g != null) {
            this.f4168g = new Rect(eVar.f4168g);
        }
    }
}
