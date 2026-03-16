package com.google.android.material.slider;

/* JADX INFO: loaded from: classes.dex */
public interface Slider$OnChangeListener extends BaseOnChangeListener<d> {
    /* JADX INFO: renamed from: onValueChange, reason: avoid collision after fix types in other method */
    void onValueChange2(d dVar, float f6, boolean z6);

    @Override // com.google.android.material.slider.BaseOnChangeListener
    /* synthetic */ default void onValueChange(d dVar, float f6, boolean z6) {
        if (dVar != null) {
            throw new ClassCastException();
        }
        onValueChange2((d) null, f6, z6);
    }
}
