package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2584a;

    public /* synthetic */ a(int i) {
        this.f2584a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        switch (this.f2584a) {
            case 0:
                BaseSlider$SliderState baseSlider$SliderState = new BaseSlider$SliderState(parcel);
                baseSlider$SliderState.f2582a = parcel.readFloat();
                baseSlider$SliderState.b = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                baseSlider$SliderState.c = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                baseSlider$SliderState.d = parcel.readFloat();
                baseSlider$SliderState.e = parcel.createBooleanArray()[0];
                return baseSlider$SliderState;
            default:
                return new AbsSavedState(parcel) { // from class: com.google.android.material.slider.RangeSlider$RangeSliderState
                    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a(1);

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final float f2583a;
                    public final int b;

                    {
                        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
                        this.f2583a = parcel.readFloat();
                        this.b = parcel.readInt();
                    }

                    @Override // android.view.AbsSavedState, android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        super.writeToParcel(parcel2, i);
                        parcel2.writeFloat(this.f2583a);
                        parcel2.writeInt(this.b);
                    }
                };
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2584a) {
            case 0:
                return new BaseSlider$SliderState[i];
            default:
                return new RangeSlider$RangeSliderState[i];
        }
    }
}
