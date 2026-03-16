package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        public static int getType(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i, boolean z6) {
        return this.mWrapped.getBoolean(i, z6);
    }

    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int i, int i3) {
        return this.mWrapped.getColor(i, i3);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i) : colorStateList;
    }

    public float getDimension(int i, float f6) {
        return this.mWrapped.getDimension(i, f6);
    }

    public int getDimensionPixelOffset(int i, int i3) {
        return this.mWrapped.getDimensionPixelOffset(i, i3);
    }

    public int getDimensionPixelSize(int i, int i3) {
        return this.mWrapped.getDimensionPixelSize(i, i3);
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        return (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0) ? this.mWrapped.getDrawable(i) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i, float f6) {
        return this.mWrapped.getFloat(i, f6);
    }

    public Typeface getFont(int i, int i3, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i3, fontCallback);
    }

    public float getFraction(int i, int i3, int i4, float f6) {
        return this.mWrapped.getFraction(i, i3, i4, f6);
    }

    public int getIndex(int i) {
        return this.mWrapped.getIndex(i);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i, int i3) {
        return this.mWrapped.getInt(i, i3);
    }

    public int getInteger(int i, int i3) {
        return this.mWrapped.getInteger(i, i3);
    }

    public int getLayoutDimension(int i, String str) {
        return this.mWrapped.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.mWrapped.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i, int i3) {
        return this.mWrapped.getResourceId(i, i3);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i) {
        return this.mWrapped.getString(i);
    }

    public CharSequence getText(int i) {
        return this.mWrapped.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.mWrapped.getTextArray(i);
    }

    public int getType(int i) {
        return Api21Impl.getType(this.mWrapped, i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.mWrapped.getValue(i, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i) {
        return this.mWrapped.hasValue(i);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i) {
        return this.mWrapped.peekValue(i);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i3) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i3));
    }

    public int getLayoutDimension(int i, int i3) {
        return this.mWrapped.getLayoutDimension(i, i3);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }
}
