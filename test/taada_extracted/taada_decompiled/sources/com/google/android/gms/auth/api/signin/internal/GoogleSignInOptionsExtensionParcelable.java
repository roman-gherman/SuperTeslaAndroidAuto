package com.google.android.gms.auth.api.signin.internal;

import a.AbstractC0132a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.i;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new i(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1922a;
    public final int b;
    public final Bundle c;

    public GoogleSignInOptionsExtensionParcelable(int i, int i3, Bundle bundle) {
        this.f1922a = i;
        this.b = i3;
        this.c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1922a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.k0(parcel, 3, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
