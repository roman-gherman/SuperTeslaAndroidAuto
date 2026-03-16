package com.google.android.gms.common.internal;

import A.h;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new h(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1942a;

    public /* synthetic */ BinderWrapper(Parcel parcel) {
        this.f1942a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f1942a);
    }
}
