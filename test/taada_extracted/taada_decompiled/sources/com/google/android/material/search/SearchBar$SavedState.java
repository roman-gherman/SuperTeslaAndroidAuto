package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
class SearchBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SearchBar$SavedState> CREATOR = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2561a;

    public SearchBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2561a = parcel.readString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2561a);
    }
}
