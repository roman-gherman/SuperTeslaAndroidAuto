package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    public static class Api17Impl {
        private Api17Impl() {
        }

        public static boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        public static void setHasMipMap(Bitmap bitmap, boolean z6) {
            bitmap.setHasMipMap(z6);
        }
    }

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    public static class Api27Impl {
        private Api27Impl() {
        }

        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config hardwareBitmapConfig = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                hardwareBitmapConfig = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(hardwareBitmapConfig, true);
        }

        public static Bitmap createBitmapWithSourceColorspace(int i, int i3, Bitmap bitmap, boolean z6) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z6 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i3, config, bitmap.hasAlpha(), colorSpace);
        }

        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i3, Rect rect, boolean z6) {
        float f6;
        int i4;
        double dFloor;
        Bitmap bitmapCreateBitmap;
        int i5;
        int i6;
        boolean z7;
        char c;
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        int i7 = Build.VERSION.SDK_INT;
        Bitmap bitmapCopyBitmapIfHardware = i7 >= 27 ? Api27Impl.copyBitmapIfHardware(bitmap) : bitmap;
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f7 = i / iWidth;
        float f8 = i3 / iHeight;
        int i8 = rect != null ? rect.left : 0;
        int i9 = rect != null ? rect.top : 0;
        if (i8 == 0 && i9 == 0 && i == bitmap.getWidth() && i3 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapCopyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : bitmapCopyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        if (i7 >= 29) {
            Api29Impl.setPaintBlendMode(paint);
        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (iWidth == i && iHeight == i3) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i3, bitmapCopyBitmapIfHardware.getConfig());
            new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapCopyBitmapIfHardware, -i8, -i9, paint);
            return bitmapCreateBitmap2;
        }
        double dLog = Math.log(2.0d);
        if (f7 > 1.0f) {
            f6 = 1.0f;
            i4 = i8;
            dFloor = Math.ceil(Math.log(f7) / dLog);
        } else {
            f6 = 1.0f;
            i4 = i8;
            dFloor = Math.floor(Math.log(f7) / dLog);
        }
        int i10 = (int) dFloor;
        int iCeil = (int) (f8 > f6 ? Math.ceil(Math.log(f8) / dLog) : Math.floor(Math.log(f8) / dLog));
        if (!z6 || i7 < 27 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmapCreateBitmap = null;
            i5 = i4;
            i6 = 0;
        } else {
            Bitmap bitmapCreateBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(i10 > 0 ? sizeAtStep(iWidth, i, 1, i10) : iWidth, iCeil > 0 ? sizeAtStep(iHeight, i3, 1, iCeil) : iHeight, bitmap, true);
            new Canvas(bitmapCreateBitmapWithSourceColorspace).drawBitmap(bitmapCopyBitmapIfHardware, -i4, -i9, paint);
            Bitmap bitmap2 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmapWithSourceColorspace;
            bitmapCreateBitmap = bitmap2;
            i6 = 1;
            i9 = 0;
            i5 = 0;
        }
        Rect rect2 = new Rect(i5, i9, iWidth, iHeight);
        Rect rect3 = new Rect();
        int i11 = i10;
        int i12 = iCeil;
        while (true) {
            if (i11 == 0 && i12 == 0) {
                break;
            }
            if (i11 < 0) {
                i11++;
            } else if (i11 > 0) {
                i11--;
            }
            if (i12 < 0) {
                i12++;
            } else if (i12 > 0) {
                i12--;
            }
            int i13 = i12;
            int i14 = i6;
            int i15 = i11;
            rect3.set(0, 0, sizeAtStep(iWidth, i, i11, i10), sizeAtStep(iHeight, i3, i13, iCeil));
            boolean z8 = i15 == 0 && i13 == 0;
            boolean z9 = bitmapCreateBitmap != null && bitmapCreateBitmap.getWidth() == i && bitmapCreateBitmap.getHeight() == i3;
            if (bitmapCreateBitmap == null || bitmapCreateBitmap == bitmap) {
                z7 = z8;
            } else {
                if (z6) {
                    z7 = z8;
                    if (Build.VERSION.SDK_INT < 27 || Api27Impl.isAlreadyF16AndLinear(bitmapCreateBitmap)) {
                    }
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                    rect2.set(rect3);
                    Bitmap bitmap3 = bitmapCopyBitmapIfHardware;
                    bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                    bitmapCreateBitmap = bitmap3;
                    i12 = i13;
                    i6 = i14;
                    i11 = i15;
                } else {
                    z7 = z8;
                }
                if (!z7 || (z9 && i14 == 0)) {
                    c = 27;
                }
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                rect2.set(rect3);
                Bitmap bitmap32 = bitmapCopyBitmapIfHardware;
                bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                bitmapCreateBitmap = bitmap32;
                i12 = i13;
                i6 = i14;
                i11 = i15;
            }
            if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
                bitmapCreateBitmap.recycle();
            }
            int iSizeAtStep = sizeAtStep(iWidth, i, i15 > 0 ? i14 : i15, i10);
            int iSizeAtStep2 = sizeAtStep(iHeight, i3, i13 > 0 ? i14 : i13, iCeil);
            c = 27;
            if (Build.VERSION.SDK_INT >= 27) {
                bitmapCreateBitmap = Api27Impl.createBitmapWithSourceColorspace(iSizeAtStep, iSizeAtStep2, bitmap, z6 && !z7);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iSizeAtStep, iSizeAtStep2, bitmapCopyBitmapIfHardware.getConfig());
            }
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
            rect2.set(rect3);
            Bitmap bitmap322 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
            bitmapCreateBitmap = bitmap322;
            i12 = i13;
            i6 = i14;
            i11 = i15;
        }
        if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCopyBitmapIfHardware;
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return Api19Impl.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return Api17Impl.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z6) {
        Api17Impl.setHasMipMap(bitmap, z6);
    }

    public static int sizeAtStep(int i, int i3, int i4, int i5) {
        return i4 == 0 ? i3 : i4 > 0 ? i * (1 << (i5 - i4)) : i3 << ((-i4) - 1);
    }
}
