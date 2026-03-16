package com.google.android.gms.common.moduleinstall;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new h(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1970a;
    public final boolean b;

    public ModuleInstallResponse(int i, boolean z6) {
        this.f1970a = i;
        this.b = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1970a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }

    public ModuleInstallResponse(int i) {
        this(i, false);
    }
}
