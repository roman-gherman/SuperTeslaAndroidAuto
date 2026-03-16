package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new z(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f2403a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f2404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2405g;

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = L.c(calendar);
        this.f2403a = calendarC;
        this.b = calendarC.get(2);
        this.c = calendarC.get(1);
        this.d = calendarC.getMaximum(7);
        this.e = calendarC.getActualMaximum(5);
        this.f2404f = calendarC.getTimeInMillis();
    }

    public static Month b(int i, int i3) {
        Calendar calendarG = L.g(null);
        calendarG.set(1, i);
        calendarG.set(2, i3);
        return new Month(calendarG);
    }

    public static Month c(long j6) {
        Calendar calendarG = L.g(null);
        calendarG.setTimeInMillis(j6);
        return new Month(calendarG);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.f2403a.compareTo(month.f2403a);
    }

    public final String d() {
        if (this.f2405g == null) {
            this.f2405g = L.b("yMMMM", Locale.getDefault()).format(new Date(this.f2403a.getTimeInMillis()));
        }
        return this.f2405g;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int e(Month month) {
        if (!(this.f2403a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.b - this.b) + ((month.c - this.c) * 12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.b == month.b && this.c == month.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}
