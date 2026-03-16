package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f6, float f7, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f6, float f7, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i3, int i4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f6, float f7, float f8) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f6, float f7, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f6, float f7, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f6, float f7, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f6, float f7) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
