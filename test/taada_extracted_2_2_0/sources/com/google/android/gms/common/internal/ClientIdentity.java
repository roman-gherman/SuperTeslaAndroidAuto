package com.google.android.gms.common.internal;

import A.h;
import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new h(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1943a;
    public final String b;

    public ClientIdentity(int i, String str) {
        this.f1943a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f1943a == this.f1943a && j.f(clientIdentity.b, this.b);
    }

    public final int hashCode() {
        return this.f1943a;
    }

    public final String toString() {
        return this.f1943a + ":" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1943a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.t0(parcel, iS0);
    }
}
