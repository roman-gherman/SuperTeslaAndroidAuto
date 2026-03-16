package n0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import m0.C0630a;

/* JADX INFO: loaded from: classes.dex */
public final class o extends s {
    public final q c;
    public final float d;
    public final float e;

    public o(q qVar, float f6, float f7) {
        this.c = qVar;
        this.d = f6;
        this.e = f7;
    }

    @Override // n0.s
    public final void a(Matrix matrix, C0630a c0630a, int i, Canvas canvas) {
        q qVar = this.c;
        float f6 = qVar.c;
        float f7 = this.e;
        float f8 = qVar.b;
        float f9 = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f6 - f7, f8 - f9), 0.0f);
        Matrix matrix2 = this.f4219a;
        matrix2.set(matrix);
        matrix2.preTranslate(f9, f7);
        matrix2.preRotate(b());
        c0630a.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = C0630a.i;
        iArr[0] = c0630a.f4023f;
        iArr[1] = c0630a.e;
        iArr[2] = c0630a.d;
        Paint paint = c0630a.c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, C0630a.f4019j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        q qVar = this.c;
        return (float) Math.toDegrees(Math.atan((qVar.c - this.e) / (qVar.b - this.d)));
    }
}
