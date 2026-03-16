package com.google.android.gms.internal.location;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzbe> CREATOR = new h(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2013a;
    public final long b;
    public final short c;
    public final double d;
    public final double e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2016h;
    public final int i;

    public zzbe(String str, int i, short s3, double d, double d6, float f6, long j6, int i3, int i4) {
        if (str == null || str.length() > 100) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "requestId is null or too long: ".concat(strValueOf) : new String("requestId is null or too long: "));
        }
        if (f6 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f6);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d > 90.0d || d < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d6 > 180.0d || d6 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d6);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i5 = i & 7;
        if (i5 == 0) {
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.c = s3;
        this.f2013a = str;
        this.d = d;
        this.e = d6;
        this.f2014f = f6;
        this.b = j6;
        this.f2015g = i5;
        this.f2016h = i3;
        this.i = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (this.f2014f == zzbeVar.f2014f && this.d == zzbeVar.d && this.e == zzbeVar.e && this.c == zzbeVar.c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.f2013a;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.e);
        return ((((Float.floatToIntBits(this.f2014f) + ((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31)) * 31) + this.c) * 31) + this.f2015g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        short s3 = this.c;
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", s3 != -1 ? s3 != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID", this.f2013a.replaceAll("\\p{C}", TypeDescription.Generic.OfWildcardType.SYMBOL), Integer.valueOf(this.f2015g), Double.valueOf(this.d), Double.valueOf(this.e), Float.valueOf(this.f2014f), Integer.valueOf(this.f2016h / 1000), Integer.valueOf(this.i), Long.valueOf(this.b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.n0(parcel, 1, this.f2013a);
        AbstractC0132a.u0(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 8);
        parcel.writeDouble(this.d);
        AbstractC0132a.u0(parcel, 5, 8);
        parcel.writeDouble(this.e);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeFloat(this.f2014f);
        AbstractC0132a.u0(parcel, 7, 4);
        parcel.writeInt(this.f2015g);
        AbstractC0132a.u0(parcel, 8, 4);
        parcel.writeInt(this.f2016h);
        AbstractC0132a.u0(parcel, 9, 4);
        parcel.writeInt(this.i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
