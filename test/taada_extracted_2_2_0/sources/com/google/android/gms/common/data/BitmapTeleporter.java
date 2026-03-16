package com.google.android.gms.common.data;

import A.h;
import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new h(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1935a;
    public ParcelFileDescriptor b;
    public final int c;

    public BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i3) {
        this.f1935a = i;
        this.b = parcelFileDescriptor;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.b == null) {
            j.c(null);
            throw null;
        }
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1935a);
        AbstractC0132a.m0(parcel, 2, this.b, i | 1);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.t0(parcel, iS0);
        this.b = null;
    }
}
