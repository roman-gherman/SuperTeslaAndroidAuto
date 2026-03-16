package com.google.android.gms.common.moduleinstall.internal;

import A.h;
import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new h(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1972a;
    public final boolean b;
    public final String c;
    public final String d;

    public ApiFeatureRequest(ArrayList arrayList, boolean z6, String str, String str2) {
        j.c(arrayList);
        this.f1972a = arrayList;
        this.b = z6;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.b == apiFeatureRequest.b && j.f(this.f1972a, apiFeatureRequest.f1972a) && j.f(this.c, apiFeatureRequest.c) && j.f(this.d, apiFeatureRequest.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.b), this.f1972a, this.c, this.d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.r0(parcel, 1, this.f1972a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
