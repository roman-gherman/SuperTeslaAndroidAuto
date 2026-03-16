package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new C0338a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f2361a;
    public final Month b;
    public final DateValidator c;
    public final Month d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2363g;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j6);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f2361a = month;
        this.b = month2;
        this.d = month3;
        this.e = i;
        this.c = dateValidator;
        if (month3 != null && month.f2403a.compareTo(month3.f2403a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f2403a.compareTo(month2.f2403a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > L.g(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f2363g = month.e(month2) + 1;
        this.f2362f = (month2.c - month.c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f2361a.equals(calendarConstraints.f2361a) && this.b.equals(calendarConstraints.b) && ObjectsCompat.equals(this.d, calendarConstraints.d) && this.e == calendarConstraints.e && this.c.equals(calendarConstraints.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2361a, this.b, this.d, Integer.valueOf(this.e), this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2361a, 0);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeInt(this.e);
    }
}
