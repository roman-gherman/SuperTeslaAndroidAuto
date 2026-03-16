package com.google.android.material.slider;

/* JADX INFO: loaded from: classes.dex */
public interface RangeSlider$OnSliderTouchListener extends BaseOnSliderTouchListener<c> {
    /* JADX INFO: renamed from: onStartTrackingTouch, reason: avoid collision after fix types in other method */
    void onStartTrackingTouch2(c cVar);

    @Override // com.google.android.material.slider.BaseOnSliderTouchListener
    /* synthetic */ default void onStartTrackingTouch(c cVar) {
        if (cVar != null) {
            throw new ClassCastException();
        }
        onStartTrackingTouch2((c) null);
    }

    /* JADX INFO: renamed from: onStopTrackingTouch, reason: avoid collision after fix types in other method */
    void onStopTrackingTouch2(c cVar);

    @Override // com.google.android.material.slider.BaseOnSliderTouchListener
    /* synthetic */ default void onStopTrackingTouch(c cVar) {
        if (cVar != null) {
            throw new ClassCastException();
        }
        onStopTrackingTouch2((c) null);
    }
}
