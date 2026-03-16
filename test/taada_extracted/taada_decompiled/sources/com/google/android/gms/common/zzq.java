package com.google.android.gms.common;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.i;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new i(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2001a;
    public final String b;
    public final int c;
    public final int d;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r8.d = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzq(java.lang.String r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = 2
            r1 = 3
            r2 = 6
            r3 = 1
            r8.<init>()
            r8.f2001a = r12
            r8.b = r9
            int[] r9 = new int[r2]
            r9 = {x003e: FILL_ARRAY_DATA , data: [1, 2, 3, 4, 5, 6} // fill-array
            r12 = 0
            r4 = r12
        L12:
            r5 = 0
            if (r4 >= r2) goto L21
            r6 = r9[r4]
            int r7 = r6 + (-1)
            if (r6 == 0) goto L20
            if (r7 != r10) goto L1e
            goto L22
        L1e:
            int r4 = r4 + r3
            goto L12
        L20:
            throw r5
        L21:
            r6 = r3
        L22:
            int r6 = r6 + (-1)
            r8.c = r6
            int[] r9 = new int[]{r3, r0, r1}
        L2a:
            if (r12 >= r1) goto L39
            r10 = r9[r12]
            int r0 = r10 + (-1)
            if (r10 == 0) goto L38
            if (r0 != r11) goto L36
            r3 = r10
            goto L39
        L36:
            int r12 = r12 + r3
            goto L2a
        L38:
            throw r5
        L39:
            int r3 = r3 + (-1)
            r8.d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzq.<init>(java.lang.String, int, int, boolean):void");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2001a ? 1 : 0);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
