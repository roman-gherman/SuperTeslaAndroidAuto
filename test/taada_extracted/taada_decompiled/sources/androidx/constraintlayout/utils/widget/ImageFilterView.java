package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    float mPanX;
    float mPanY;
    private Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;

    public static class ImageMatrix {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float[] f1592m = new float[20];
        ColorMatrix mColorMatrix = new ColorMatrix();
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mBrightness = 1.0f;
        float mSaturation = 1.0f;
        float mContrast = 1.0f;
        float mWarmth = 1.0f;

        private void brightness(float f6) {
            float[] fArr = this.f1592m;
            fArr[0] = f6;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f6;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f6) {
            float f7 = 1.0f - f6;
            float f8 = 0.2999f * f7;
            float f9 = 0.587f * f7;
            float f10 = f7 * 0.114f;
            float[] fArr = this.f1592m;
            fArr[0] = f8 + f6;
            fArr[1] = f9;
            fArr[2] = f10;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f8;
            fArr[6] = f9 + f6;
            fArr[7] = f10;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f8;
            fArr[11] = f9;
            fArr[12] = f10 + f6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void warmth(float f6) {
            float fLog;
            float fPow;
            if (f6 <= 0.0f) {
                f6 = 0.01f;
            }
            float f7 = (5000.0f / f6) / 100.0f;
            if (f7 > 66.0f) {
                double d = f7 - 60.0f;
                fPow = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f7)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            float fLog2 = f7 < 66.0f ? f7 > 19.0f ? (((float) Math.log(f7 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f1592m;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void updateMatrix(ImageView imageView) {
            boolean z6;
            this.mColorMatrix.reset();
            float f6 = this.mSaturation;
            boolean z7 = true;
            if (f6 != 1.0f) {
                saturation(f6);
                this.mColorMatrix.set(this.f1592m);
                z6 = true;
            } else {
                z6 = false;
            }
            float f7 = this.mContrast;
            if (f7 != 1.0f) {
                this.mTmpColorMatrix.setScale(f7, f7, f7, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z6 = true;
            }
            float f8 = this.mWarmth;
            if (f8 != 1.0f) {
                warmth(f8);
                this.mTmpColorMatrix.set(this.f1592m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z6 = true;
            }
            float f9 = this.mBrightness;
            if (f9 != 1.0f) {
                brightness(f9);
                this.mTmpColorMatrix.set(this.f1592m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            } else {
                z7 = z6;
            }
            if (z7) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.mAltDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.mPanX));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.mPanY));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.mRotate));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.mZoom));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.mDrawable = drawable;
            if (this.mAltDrawable == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawable = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.mLayers;
                    Drawable drawableMutate = drawable2.mutate();
                    this.mDrawable = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.mLayers;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.mDrawable = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.mLayers[1] = this.mAltDrawable.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            super.setImageDrawable(this.mLayer);
        }
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            return;
        }
        float f6 = Float.isNaN(this.mPanX) ? 0.0f : this.mPanX;
        float f7 = Float.isNaN(this.mPanY) ? 0.0f : this.mPanY;
        float f8 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f9 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f10 = f8 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f10, f10);
        float f11 = intrinsicWidth * f10;
        float f12 = f10 * intrinsicHeight;
        matrix.postTranslate(((((width - f11) * f6) + width) - f11) * 0.5f, ((((height - f12) * f7) + height) - f12) * 0.5f);
        matrix.postRotate(f9, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void setOverlay(boolean z6) {
        this.mOverlay = z6;
    }

    private void updateViewMatrix() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setMatrix();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    @Override // android.view.View
    public void layout(int i, int i3, int i4, int i5) {
        super.layout(i, i3, i4, i5);
        setMatrix();
    }

    public void setAltImageResource(int i) {
        Drawable drawableMutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.mAltDrawable = drawableMutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = this.mDrawable;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mBrightness = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setContrast(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mContrast = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f6) {
        this.mCrossfade = f6;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.mDrawable = drawableMutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.mAltDrawable;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setImagePanX(float f6) {
        this.mPanX = f6;
        updateViewMatrix();
    }

    public void setImagePanY(float f6) {
        this.mPanY = f6;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.mAltDrawable == null) {
            super.setImageResource(i);
            return;
        }
        Drawable drawableMutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.mDrawable = drawableMutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.mAltDrawable;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setImageRotate(float f6) {
        this.mRotate = f6;
        updateViewMatrix();
    }

    public void setImageZoom(float f6) {
        this.mZoom = f6;
        updateViewMatrix();
    }

    public void setRound(float f6) {
        if (Float.isNaN(f6)) {
            this.mRound = f6;
            float f7 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f7);
            return;
        }
        boolean z6 = this.mRound != f6;
        this.mRound = f6;
        if (f6 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f8 = this.mRound;
            path.addRoundRect(rectF, f8, f8, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z6) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f6) {
        boolean z6 = this.mRoundPercent != f6;
        this.mRoundPercent = f6;
        if (f6 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (ImageFilterView.this.mRoundPercent * Math.min(r3, r4)) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z6) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mSaturation = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mWarmth = f6;
        imageMatrix.updateMatrix(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }
}
