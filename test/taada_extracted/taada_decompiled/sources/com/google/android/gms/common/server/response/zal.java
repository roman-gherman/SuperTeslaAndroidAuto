package com.google.android.gms.common.server.response;

import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new h(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1986a;
    public final String b;
    public final ArrayList c;

    public zal(int i, String str, ArrayList arrayList) {
        this.f1986a = i;
        this.b = str;
        this.c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1986a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.r0(parcel, 3, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f1986a = 1;
        this.b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse$Field) map.get(str2)));
            }
        }
        this.c = arrayList;
    }
}
