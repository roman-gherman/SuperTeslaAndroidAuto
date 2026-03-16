package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c4.AbstractC0246d;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iM0 = AbstractC0246d.M0(parcel);
        String strA = null;
        String strA2 = null;
        zaa zaaVar = null;
        int iQ0 = 0;
        int iQ02 = 0;
        boolean zL0 = false;
        int iQ03 = 0;
        boolean zL02 = false;
        int iQ04 = 0;
        while (parcel.dataPosition() < iM0) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iQ0 = AbstractC0246d.q0(parcel, i);
                    break;
                case 2:
                    iQ02 = AbstractC0246d.q0(parcel, i);
                    break;
                case 3:
                    zL0 = AbstractC0246d.l0(parcel, i);
                    break;
                case 4:
                    iQ03 = AbstractC0246d.q0(parcel, i);
                    break;
                case 5:
                    zL02 = AbstractC0246d.l0(parcel, i);
                    break;
                case 6:
                    strA = AbstractC0246d.A(parcel, i);
                    break;
                case 7:
                    iQ04 = AbstractC0246d.q0(parcel, i);
                    break;
                case '\b':
                    strA2 = AbstractC0246d.A(parcel, i);
                    break;
                case '\t':
                    zaaVar = (zaa) AbstractC0246d.x(parcel, i, zaa.CREATOR);
                    break;
                default:
                    AbstractC0246d.B0(parcel, i);
                    break;
            }
        }
        AbstractC0246d.J(parcel, iM0);
        return new FastJsonResponse$Field(iQ0, iQ02, zL0, iQ03, zL02, strA, iQ04, strA2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FastJsonResponse$Field[i];
    }
}
