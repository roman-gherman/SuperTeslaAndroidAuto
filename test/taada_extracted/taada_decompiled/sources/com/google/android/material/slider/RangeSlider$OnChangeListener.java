package com.google.android.material.slider;

/* JADX INFO: loaded from: classes.dex */
public interface RangeSlider$OnChangeListener extends BaseOnChangeListener<c> {
    /* JADX INFO: renamed from: onValueChange, reason: avoid collision after fix types in other method */
    void onValueChange2(c cVar, float f6, boolean z6);

    @Override // com.google.android.material.slider.BaseOnChangeListener
    /* synthetic */ default void onValueChange(c cVar, float f6, boolean z6) {
        if (cVar != null) {
            throw new ClassCastException();
        }
        onValueChange2((c) null, f6, z6);
    }
}
