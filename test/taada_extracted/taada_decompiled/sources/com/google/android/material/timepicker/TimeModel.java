package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2746a;
    public final int b;
    public final int c;
    public final int d;

    public TimeModel(int i) {
        this(0, 0, 10, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.b == timeModel.b && this.c == timeModel.c && this.f2746a == timeModel.f2746a && this.d == timeModel.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2746a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f2746a);
    }

    public TimeModel(int i, int i3, int i4, int i5) {
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.f2746a = i5;
        new d(59);
        new d(i5 == 1 ? 23 : 12);
    }
}
