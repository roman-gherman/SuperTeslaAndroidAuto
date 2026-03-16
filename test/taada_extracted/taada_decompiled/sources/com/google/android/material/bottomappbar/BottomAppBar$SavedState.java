package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
class BottomAppBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<BottomAppBar$SavedState> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2212a;
    public final boolean b;

    public BottomAppBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2212a = parcel.readInt();
        this.b = parcel.readInt() != 0;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2212a);
        parcel.writeInt(this.b ? 1 : 0);
    }
}
