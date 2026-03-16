package n0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import kotlin.reflect.jvm.internal.impl.protobuf.v;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t[] f4208a = new t[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f4209f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f4210g = new t();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f4211h = new float[2];
    public final float[] i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f4212j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f4213k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4214l = true;

    public l() {
        for (int i = 0; i < 4; i++) {
            this.f4208a[i] = new t();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    public final void a(j jVar, float f6, RectF rectF, v vVar, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        t[] tVarArr;
        int i;
        float[] fArr;
        int i3;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f4209f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i4 = 0;
        while (true) {
            matrixArr = this.c;
            matrixArr2 = this.b;
            tVarArr = this.f4208a;
            fArr = this.f4211h;
            if (i4 >= 4) {
                break;
            }
            CornerSize cornerSize = i4 != 1 ? i4 != 2 ? i4 != 3 ? jVar.f4201f : jVar.e : jVar.f4203h : jVar.f4202g;
            io.ktor.utils.io.jvm.javaio.q qVar = i4 != 1 ? i4 != 2 ? i4 != 3 ? jVar.b : jVar.f4200a : jVar.d : jVar.c;
            t tVar = tVarArr[i4];
            qVar.getClass();
            qVar.i(tVar, f6, cornerSize.getCornerSize(rectF));
            int i5 = i4 + 1;
            float f7 = (i5 % 4) * 90;
            matrixArr2[i4].reset();
            PointF pointF = this.d;
            if (i4 == 1) {
                i3 = i4;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i4 == 2) {
                i3 = i4;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i4 != 3) {
                i3 = i4;
                pointF.set(rectF.right, rectF.top);
            } else {
                i3 = i4;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i3].setTranslate(pointF.x, pointF.y);
            matrixArr2[i3].preRotate(f7);
            t tVar2 = tVarArr[i3];
            fArr[0] = tVar2.b;
            fArr[1] = tVar2.c;
            matrixArr2[i3].mapPoints(fArr);
            matrixArr[i3].reset();
            matrixArr[i3].setTranslate(fArr[0], fArr[1]);
            matrixArr[i3].preRotate(f7);
            i4 = i5;
        }
        int i6 = 0;
        for (i = 4; i6 < i; i = 4) {
            t tVar3 = tVarArr[i6];
            tVar3.getClass();
            fArr[0] = 0.0f;
            fArr[1] = tVar3.f4220a;
            matrixArr2[i6].mapPoints(fArr);
            if (i6 == 0) {
                path.moveTo(fArr[0], fArr[1]);
            } else {
                path.lineTo(fArr[0], fArr[1]);
            }
            tVarArr[i6].b(matrixArr2[i6], path);
            if (vVar != null) {
                vVar.onCornerPathCreated(tVarArr[i6], matrixArr2[i6], i6);
            }
            int i7 = i6 + 1;
            int i8 = i7 % 4;
            t tVar4 = tVarArr[i6];
            fArr[0] = tVar4.b;
            fArr[1] = tVar4.c;
            matrixArr2[i6].mapPoints(fArr);
            t tVar5 = tVarArr[i8];
            tVar5.getClass();
            float[] fArr2 = this.i;
            fArr2[0] = 0.0f;
            fArr2[1] = tVar5.f4220a;
            matrixArr2[i8].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr2;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            t tVar6 = tVarArr[i6];
            fArr[0] = tVar6.b;
            fArr[1] = tVar6.c;
            matrixArr3[i6].mapPoints(fArr);
            if (i6 == 1 || i6 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            t tVar7 = this.f4210g;
            tVar7.d(0.0f, 270.0f, 0.0f);
            (i6 != 1 ? i6 != 2 ? i6 != 3 ? jVar.f4204j : jVar.i : jVar.f4206l : jVar.f4205k).getClass();
            tVar7.c(fMax, 0.0f);
            Path path4 = this.f4212j;
            path4.reset();
            tVar7.b(matrixArr[i6], path4);
            if (this.f4214l && (b(path4, i6) || b(path4, i8))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = tVar7.f4220a;
                matrixArr[i6].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                tVar7.b(matrixArr[i6], path2);
            } else {
                tVar7.b(matrixArr[i6], path);
            }
            if (vVar != null) {
                vVar.onEdgePathCreated(tVar7, matrixArr[i6], i6);
            }
            matrixArr2 = matrixArr3;
            i6 = i7;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.f4213k;
        path2.reset();
        this.f4208a[i].b(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
