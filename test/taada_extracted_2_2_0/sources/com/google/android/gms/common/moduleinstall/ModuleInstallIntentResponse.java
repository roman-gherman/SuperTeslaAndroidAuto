package com.google.android.gms.common.moduleinstall;

import A.h;
import a.AbstractC0132a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new h(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f1969a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f1969a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.m0(parcel, 1, this.f1969a, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
