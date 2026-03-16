package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.CompositeDateValidator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.material.datepicker.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0344g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
        int i = parcel.readInt();
        CompositeDateValidator.Operator operator = CompositeDateValidator.d;
        if (i != 2 && i == 1) {
            operator = CompositeDateValidator.c;
        }
        return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), operator);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new CompositeDateValidator[i];
    }
}
