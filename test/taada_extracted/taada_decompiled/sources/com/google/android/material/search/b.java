package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2563a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f2563a) {
            case 0:
                return new SearchBar$SavedState(parcel, classLoader);
            default:
                return new SearchView$SavedState(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2563a) {
            case 0:
                return new SearchBar$SavedState[i];
            default:
                return new SearchView$SavedState[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2563a) {
            case 0:
                return new SearchBar$SavedState(parcel, null);
            default:
                return new SearchView$SavedState(parcel, null);
        }
    }
}
