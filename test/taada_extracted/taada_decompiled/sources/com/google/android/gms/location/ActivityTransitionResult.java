package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new i(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2142a;
    public final Bundle b;

    public ActivityTransitionResult(ArrayList arrayList, Bundle bundle) {
        this.b = null;
        j.d(arrayList, "transitionEvents list can't be null.");
        if (!arrayList.isEmpty()) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (((ActivityTransitionEvent) arrayList.get(i)).c < ((ActivityTransitionEvent) arrayList.get(i - 1)).c) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.f2142a = Collections.unmodifiableList(arrayList);
        this.b = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2142a.equals(((ActivityTransitionResult) obj).f2142a);
    }

    public final int hashCode() {
        return this.f2142a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.r0(parcel, 1, this.f2142a);
        AbstractC0132a.k0(parcel, 2, this.b);
        AbstractC0132a.t0(parcel, iS0);
    }
}
