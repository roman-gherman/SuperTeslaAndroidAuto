package n0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import m0.C0630a;

/* JADX INFO: loaded from: classes.dex */
public final class n extends s {
    public final p c;

    public n(p pVar) {
        this.c = pVar;
    }

    @Override // n0.s
    public final void a(Matrix matrix, C0630a c0630a, int i, Canvas canvas) {
        p pVar = this.c;
        float f6 = pVar.f4216f;
        float f7 = pVar.f4217g;
        RectF rectF = new RectF(pVar.b, pVar.c, pVar.d, pVar.e);
        c0630a.getClass();
        boolean z6 = f7 < 0.0f;
        Path path = c0630a.f4024g;
        int[] iArr = C0630a.f4020k;
        if (z6) {
            iArr[0] = 0;
            iArr[1] = c0630a.f4023f;
            iArr[2] = c0630a.e;
            iArr[3] = c0630a.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f6, f7);
            path.close();
            float f8 = -i;
            rectF.inset(f8, f8);
            iArr[0] = 0;
            iArr[1] = c0630a.d;
            iArr[2] = c0630a.e;
            iArr[3] = c0630a.f4023f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f9 = 1.0f - (i / fWidth);
        float[] fArr = C0630a.f4021l;
        fArr[1] = f9;
        fArr[2] = ((1.0f - f9) / 2.0f) + f9;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = c0630a.b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z6) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c0630a.f4025h);
        }
        canvas.drawArc(rectF, f6, f7, true, paint);
        canvas.restore();
    }
}
