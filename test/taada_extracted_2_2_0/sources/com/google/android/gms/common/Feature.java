package com.google.android.gms.common;

import B.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.i;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new i(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1924a;
    public final int b;
    public final long c;

    public Feature() {
        this.f1924a = "CLIENT_TELEMETRY";
        this.c = 1L;
        this.b = -1;
    }

    public final long b() {
        long j6 = this.c;
        return j6 == -1 ? this.b : j6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f1924a;
            if (((str != null && str.equals(feature.f1924a)) || (str == null && feature.f1924a == null)) && b() == feature.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1924a, Long.valueOf(b())});
    }

    public final String toString() {
        h hVar = new h(this, 4);
        hVar.a(this.f1924a, "name");
        hVar.a(Long.valueOf(b()), "version");
        return hVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.n0(parcel, 1, this.f1924a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        long jB = b();
        AbstractC0132a.u0(parcel, 3, 8);
        parcel.writeLong(jB);
        AbstractC0132a.t0(parcel, iS0);
    }

    public Feature(String str, int i, long j6) {
        this.f1924a = str;
        this.b = i;
        this.c = j6;
    }
}
