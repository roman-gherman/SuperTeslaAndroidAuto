package androidx.core.widget;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public interface AutoSizeableTextView {

    @Deprecated
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    static {
        PLATFORM_SUPPORTS_AUTOSIZE = Build.VERSION.SDK_INT >= 27;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i3, int i4, int i5);

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i);

    void setAutoSizeTextTypeWithDefaults(int i);
}
