package com.google.android.gms.location;

import a.AbstractC0132a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new Q.h(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q.f f2166a;
    public final PendingIntent b;
    public final String c;

    public zzbq(ArrayList arrayList, PendingIntent pendingIntent, String str) {
        Q.g gVar;
        if (arrayList == null) {
            Q.d dVar = Q.f.b;
            gVar = Q.g.e;
        } else {
            Q.d dVar2 = Q.f.b;
            Object[] array = arrayList.toArray();
            int length = array.length;
            for (int i = 0; i < length; i++) {
                if (array[i] == null) {
                    StringBuilder sb = new StringBuilder(20);
                    sb.append("at index ");
                    sb.append(i);
                    throw new NullPointerException(sb.toString());
                }
            }
            gVar = length == 0 ? Q.g.e : new Q.g(array, length);
        }
        this.f2166a = gVar;
        this.b = pendingIntent;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.o0(parcel, 1, this.f2166a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
