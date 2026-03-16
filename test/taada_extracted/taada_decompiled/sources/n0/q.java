package n0;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public final class q extends r {
    public float b;
    public float c;

    @Override // n0.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4218a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.b, this.c);
        path.transform(matrix);
    }
}
