package com.google.android.material.slider;

/* JADX INFO: loaded from: classes.dex */
public interface Slider$OnSliderTouchListener extends BaseOnSliderTouchListener<d> {
    /* JADX INFO: renamed from: onStartTrackingTouch, reason: avoid collision after fix types in other method */
    void onStartTrackingTouch2(d dVar);

    @Override // com.google.android.material.slider.BaseOnSliderTouchListener
    /* synthetic */ default void onStartTrackingTouch(d dVar) {
        if (dVar != null) {
            throw new ClassCastException();
        }
        onStartTrackingTouch2((d) null);
    }

    /* JADX INFO: renamed from: onStopTrackingTouch, reason: avoid collision after fix types in other method */
    void onStopTrackingTouch2(d dVar);

    @Override // com.google.android.material.slider.BaseOnSliderTouchListener
    /* synthetic */ default void onStopTrackingTouch(d dVar) {
        if (dVar != null) {
            throw new ClassCastException();
        }
        onStopTrackingTouch2((d) null);
    }
}
