package com.google.android.gms.common.data;

import A.h;
import a.AbstractC0132a;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new h(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1936a;
    public final String[] b;
    public Bundle c;
    public final CursorWindow[] d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f1937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f1938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1939h = false;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f1936a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i3;
        this.f1937f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f1939h) {
                    this.f1939h = true;
                    int i = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.d;
                        if (i >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i].close();
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z6;
        try {
            if (this.d.length > 0) {
                synchronized (this) {
                    z6 = this.f1939h;
                }
                if (!z6) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        String[] strArr = this.b;
        if (strArr != null) {
            int iS02 = AbstractC0132a.s0(parcel, 1);
            parcel.writeStringArray(strArr);
            AbstractC0132a.t0(parcel, iS02);
        }
        AbstractC0132a.q0(parcel, 2, this.d, i);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.k0(parcel, 4, this.f1937f);
        AbstractC0132a.u0(parcel, 1000, 4);
        parcel.writeInt(this.f1936a);
        AbstractC0132a.t0(parcel, iS0);
        if ((i & 1) != 0) {
            close();
        }
    }
}
