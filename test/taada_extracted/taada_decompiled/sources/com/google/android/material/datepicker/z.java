package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2437a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2437a) {
            case 0:
                return Month.b(parcel.readInt(), parcel.readInt());
            case 1:
                return new DateValidatorPointBackward(parcel.readLong());
            case 2:
                return new DateValidatorPointForward(parcel.readLong());
            case 3:
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.c = null;
                rangeDateSelector.d = null;
                rangeDateSelector.e = null;
                rangeDateSelector.f2409f = null;
                rangeDateSelector.c = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.d = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            default:
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.b = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2437a) {
            case 0:
                return new Month[i];
            case 1:
                return new DateValidatorPointBackward[i];
            case 2:
                return new DateValidatorPointForward[i];
            case 3:
                return new RangeDateSelector[i];
            default:
                return new SingleDateSelector[i];
        }
    }
}
