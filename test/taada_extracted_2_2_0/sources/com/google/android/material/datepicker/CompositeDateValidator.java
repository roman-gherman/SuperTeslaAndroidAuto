package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Operator f2364a;
    public final List b;
    public static final C0342e c = new C0342e();
    public static final C0343f d = new C0343f();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new C0344g();

    public interface Operator {
        int getId();

        boolean isValid(List<CalendarConstraints.DateValidator> list, long j6);
    }

    public CompositeDateValidator(List list, Operator operator) {
        this.b = list;
        this.f2364a = operator;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.b.equals(compositeDateValidator.b) && this.f2364a.getId() == compositeDateValidator.f2364a.getId();
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean isValid(long j6) {
        return this.f2364a.isValid(this.b, j6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.b);
        parcel.writeInt(this.f2364a.getId());
    }
}
