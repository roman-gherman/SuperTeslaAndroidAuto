package n0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public final class p extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RectF f4215h = new RectF();
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4217g;

    public p(float f6, float f7, float f8, float f9) {
        this.b = f6;
        this.c = f7;
        this.d = f8;
        this.e = f9;
    }

    @Override // n0.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4218a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f4215h;
        rectF.set(this.b, this.c, this.d, this.e);
        path.arcTo(rectF, this.f4216f, this.f4217g, false);
        path.transform(matrix);
    }
}
