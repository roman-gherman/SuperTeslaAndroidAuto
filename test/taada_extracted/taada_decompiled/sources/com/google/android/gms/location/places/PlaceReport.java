package com.google.android.gms.location.places;

import D.j;
import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new h(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2163a;
    public final String b;
    public final String c;
    public final String d;

    public PlaceReport(int i, String str, String str2, String str3) {
        this.f2163a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return j.f(this.b, placeReport.b) && j.f(this.c, placeReport.c) && j.f(this.d, placeReport.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d});
    }

    public final String toString() {
        B.h hVar = new B.h(this, 4);
        hVar.a(this.b, "placeId");
        hVar.a(this.c, "tag");
        String str = this.d;
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(str)) {
            hVar.a(str, "source");
        }
        return hVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2163a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
