package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new Q.h(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2144a;
    public final int b;
    public final String c;
    public final String d;

    public @interface InitialTrigger {
    }

    public GeofencingRequest(ArrayList arrayList, int i, String str, String str2) {
        this.f2144a = arrayList;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeofencingRequest[geofences=");
        sb.append(this.f2144a);
        sb.append(", initialTrigger=");
        sb.append(this.b);
        sb.append(", tag=");
        sb.append(this.c);
        sb.append(", attributionTag=");
        return B2.b.h(sb, this.d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.r0(parcel, 1, this.f2144a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
