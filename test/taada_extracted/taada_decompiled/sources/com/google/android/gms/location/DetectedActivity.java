package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new i(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2143a;
    public int b;

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f2143a == detectedActivity.f2143a && this.b == detectedActivity.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2143a), Integer.valueOf(this.b)});
    }

    public final String toString() {
        int i = this.f2143a;
        if (i > 22 || i < 0) {
            i = 4;
        }
        String string = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 7 ? i != 8 ? i != 16 ? i != 17 ? Integer.toString(i) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 48);
        B2.b.r(sb, "DetectedActivity [type=", string, ", confidence=");
        return B2.b.g(sb, "]", this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2143a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.t0(parcel, iS0);
    }
}
