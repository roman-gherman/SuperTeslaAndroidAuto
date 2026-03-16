package com.google.android.gms.location;

import android.accounts.Account;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c4.AbstractC0246d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2162a;

    public /* synthetic */ i(int i) {
        this.f2162a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2162a) {
            case 0:
                int iM0 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE = null;
                Bundle bundleT = null;
                while (parcel.dataPosition() < iM0) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        arrayListE = AbstractC0246d.E(parcel, i, ActivityTransitionEvent.CREATOR);
                    } else if (c != 2) {
                        AbstractC0246d.B0(parcel, i);
                    } else {
                        bundleT = AbstractC0246d.t(parcel, i);
                    }
                }
                AbstractC0246d.J(parcel, iM0);
                return new ActivityTransitionResult(arrayListE, bundleT);
            case 1:
                int iM02 = AbstractC0246d.M0(parcel);
                int iQ0 = 0;
                int iQ02 = 0;
                while (parcel.dataPosition() < iM02) {
                    int i3 = parcel.readInt();
                    char c6 = (char) i3;
                    if (c6 == 1) {
                        iQ0 = AbstractC0246d.q0(parcel, i3);
                    } else if (c6 != 2) {
                        AbstractC0246d.B0(parcel, i3);
                    } else {
                        iQ02 = AbstractC0246d.q0(parcel, i3);
                    }
                }
                AbstractC0246d.J(parcel, iM02);
                DetectedActivity detectedActivity = new DetectedActivity();
                detectedActivity.f2143a = iQ0;
                detectedActivity.b = iQ02;
                return detectedActivity;
            case 2:
                int iM03 = AbstractC0246d.M0(parcel);
                boolean zL0 = true;
                long jR0 = 50;
                float fN0 = 0.0f;
                long jR02 = Long.MAX_VALUE;
                int iQ03 = Integer.MAX_VALUE;
                while (parcel.dataPosition() < iM03) {
                    int i4 = parcel.readInt();
                    char c7 = (char) i4;
                    if (c7 == 1) {
                        zL0 = AbstractC0246d.l0(parcel, i4);
                    } else if (c7 == 2) {
                        jR0 = AbstractC0246d.r0(parcel, i4);
                    } else if (c7 == 3) {
                        fN0 = AbstractC0246d.n0(parcel, i4);
                    } else if (c7 == 4) {
                        jR02 = AbstractC0246d.r0(parcel, i4);
                    } else if (c7 != 5) {
                        AbstractC0246d.B0(parcel, i4);
                    } else {
                        iQ03 = AbstractC0246d.q0(parcel, i4);
                    }
                }
                AbstractC0246d.J(parcel, iM03);
                return new zzs(zL0, jR0, fN0, jR02, iQ03);
            case 3:
                int i5 = parcel.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i5);
                int[] iArr = new int[i5];
                boolean[] zArr = new boolean[i5];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                for (int i6 = 0; i6 < i5; i6++) {
                    parcelableSparseBooleanArray.put(iArr[i6], zArr[i6]);
                }
                return parcelableSparseBooleanArray;
            case 4:
                int i7 = parcel.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i7);
                int[] iArr2 = new int[i7];
                int[] iArr3 = new int[i7];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                for (int i8 = 0; i8 < i7; i8++) {
                    parcelableSparseIntArray.put(iArr2[i8], iArr3[i8]);
                }
                return parcelableSparseIntArray;
            case 5:
                int iM04 = AbstractC0246d.M0(parcel);
                String strA = null;
                String strA2 = null;
                String strA3 = null;
                String strA4 = null;
                Uri uri = null;
                String strA5 = null;
                String strA6 = null;
                ArrayList arrayListE2 = null;
                String strA7 = null;
                String strA8 = null;
                long jR03 = 0;
                int iQ04 = 0;
                while (parcel.dataPosition() < iM04) {
                    int i9 = parcel.readInt();
                    switch ((char) i9) {
                        case 1:
                            iQ04 = AbstractC0246d.q0(parcel, i9);
                            break;
                        case 2:
                            strA = AbstractC0246d.A(parcel, i9);
                            break;
                        case 3:
                            strA2 = AbstractC0246d.A(parcel, i9);
                            break;
                        case 4:
                            strA3 = AbstractC0246d.A(parcel, i9);
                            break;
                        case 5:
                            strA4 = AbstractC0246d.A(parcel, i9);
                            break;
                        case 6:
                            uri = (Uri) AbstractC0246d.x(parcel, i9, Uri.CREATOR);
                            break;
                        case 7:
                            strA5 = AbstractC0246d.A(parcel, i9);
                            break;
                        case '\b':
                            jR03 = AbstractC0246d.r0(parcel, i9);
                            break;
                        case '\t':
                            strA6 = AbstractC0246d.A(parcel, i9);
                            break;
                        case '\n':
                            arrayListE2 = AbstractC0246d.E(parcel, i9, Scope.CREATOR);
                            break;
                        case 11:
                            strA7 = AbstractC0246d.A(parcel, i9);
                            break;
                        case '\f':
                            strA8 = AbstractC0246d.A(parcel, i9);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i9);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM04);
                return new GoogleSignInAccount(iQ04, strA, strA2, strA3, strA4, uri, strA5, jR03, strA6, arrayListE2, strA7, strA8);
            case 6:
                int iM05 = AbstractC0246d.M0(parcel);
                ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListE3 = null;
                ArrayList arrayListE4 = null;
                Account account = null;
                String strA9 = null;
                String strA10 = null;
                String strA11 = null;
                int iQ05 = 0;
                boolean zL02 = false;
                boolean zL03 = false;
                boolean zL04 = false;
                while (parcel.dataPosition() < iM05) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iQ05 = AbstractC0246d.q0(parcel, i10);
                            break;
                        case 2:
                            arrayListE4 = AbstractC0246d.E(parcel, i10, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) AbstractC0246d.x(parcel, i10, Account.CREATOR);
                            break;
                        case 4:
                            zL02 = AbstractC0246d.l0(parcel, i10);
                            break;
                        case 5:
                            zL03 = AbstractC0246d.l0(parcel, i10);
                            break;
                        case 6:
                            zL04 = AbstractC0246d.l0(parcel, i10);
                            break;
                        case 7:
                            strA9 = AbstractC0246d.A(parcel, i10);
                            break;
                        case '\b':
                            strA10 = AbstractC0246d.A(parcel, i10);
                            break;
                        case '\t':
                            arrayListE3 = AbstractC0246d.E(parcel, i10, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            strA11 = AbstractC0246d.A(parcel, i10);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i10);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM05);
                HashMap map = new HashMap();
                if (arrayListE3 != null) {
                    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListE3) {
                        map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.b), googleSignInOptionsExtensionParcelable);
                    }
                }
                return new GoogleSignInOptions(iQ05, arrayListE4, account, zL02, zL03, zL04, strA9, strA10, map, strA11);
            case 7:
                int iM06 = AbstractC0246d.M0(parcel);
                Bundle bundleT2 = null;
                int iQ06 = 0;
                int iQ07 = 0;
                while (parcel.dataPosition() < iM06) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        iQ06 = AbstractC0246d.q0(parcel, i11);
                    } else if (c8 == 2) {
                        iQ07 = AbstractC0246d.q0(parcel, i11);
                    } else if (c8 != 3) {
                        AbstractC0246d.B0(parcel, i11);
                    } else {
                        bundleT2 = AbstractC0246d.t(parcel, i11);
                    }
                }
                AbstractC0246d.J(parcel, iM06);
                return new GoogleSignInOptionsExtensionParcelable(iQ06, iQ07, bundleT2);
            case 8:
                int iM07 = AbstractC0246d.M0(parcel);
                PendingIntent pendingIntent = null;
                int iQ08 = 0;
                int iQ09 = 0;
                String strA12 = null;
                while (parcel.dataPosition() < iM07) {
                    int i12 = parcel.readInt();
                    char c9 = (char) i12;
                    if (c9 == 1) {
                        iQ08 = AbstractC0246d.q0(parcel, i12);
                    } else if (c9 == 2) {
                        iQ09 = AbstractC0246d.q0(parcel, i12);
                    } else if (c9 == 3) {
                        pendingIntent = (PendingIntent) AbstractC0246d.x(parcel, i12, PendingIntent.CREATOR);
                    } else if (c9 != 4) {
                        AbstractC0246d.B0(parcel, i12);
                    } else {
                        strA12 = AbstractC0246d.A(parcel, i12);
                    }
                }
                AbstractC0246d.J(parcel, iM07);
                return new ConnectionResult(iQ08, iQ09, pendingIntent, strA12);
            case 9:
                int iM08 = AbstractC0246d.M0(parcel);
                long jR04 = -1;
                int iQ010 = 0;
                String strA13 = null;
                while (parcel.dataPosition() < iM08) {
                    int i13 = parcel.readInt();
                    char c10 = (char) i13;
                    if (c10 == 1) {
                        strA13 = AbstractC0246d.A(parcel, i13);
                    } else if (c10 == 2) {
                        iQ010 = AbstractC0246d.q0(parcel, i13);
                    } else if (c10 != 3) {
                        AbstractC0246d.B0(parcel, i13);
                    } else {
                        jR04 = AbstractC0246d.r0(parcel, i13);
                    }
                }
                AbstractC0246d.J(parcel, iM08);
                return new Feature(strA13, iQ010, jR04);
            case 10:
                int iM09 = AbstractC0246d.M0(parcel);
                boolean zL05 = false;
                boolean zL06 = false;
                boolean zL07 = false;
                boolean zL08 = false;
                String strA14 = null;
                IBinder iBinderP0 = null;
                while (parcel.dataPosition() < iM09) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 1:
                            strA14 = AbstractC0246d.A(parcel, i14);
                            break;
                        case 2:
                            zL05 = AbstractC0246d.l0(parcel, i14);
                            break;
                        case 3:
                            zL06 = AbstractC0246d.l0(parcel, i14);
                            break;
                        case 4:
                            iBinderP0 = AbstractC0246d.p0(parcel, i14);
                            break;
                        case 5:
                            zL07 = AbstractC0246d.l0(parcel, i14);
                            break;
                        case 6:
                            zL08 = AbstractC0246d.l0(parcel, i14);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i14);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM09);
                return new zzo(strA14, zL05, zL06, iBinderP0, zL07, zL08);
            case 11:
                int iM010 = AbstractC0246d.M0(parcel);
                boolean zL09 = false;
                int iQ011 = 0;
                String strA15 = null;
                int iQ012 = 0;
                while (parcel.dataPosition() < iM010) {
                    int i15 = parcel.readInt();
                    char c11 = (char) i15;
                    if (c11 == 1) {
                        zL09 = AbstractC0246d.l0(parcel, i15);
                    } else if (c11 == 2) {
                        strA15 = AbstractC0246d.A(parcel, i15);
                    } else if (c11 == 3) {
                        iQ012 = AbstractC0246d.q0(parcel, i15);
                    } else if (c11 != 4) {
                        AbstractC0246d.B0(parcel, i15);
                    } else {
                        iQ011 = AbstractC0246d.q0(parcel, i15);
                    }
                }
                AbstractC0246d.J(parcel, iM010);
                return new zzq(strA15, iQ012, iQ011, zL09);
            default:
                int iM011 = AbstractC0246d.M0(parcel);
                boolean zL010 = false;
                String strA16 = null;
                IBinder iBinderP02 = null;
                boolean zL011 = false;
                while (parcel.dataPosition() < iM011) {
                    int i16 = parcel.readInt();
                    char c12 = (char) i16;
                    if (c12 == 1) {
                        strA16 = AbstractC0246d.A(parcel, i16);
                    } else if (c12 == 2) {
                        iBinderP02 = AbstractC0246d.p0(parcel, i16);
                    } else if (c12 == 3) {
                        zL010 = AbstractC0246d.l0(parcel, i16);
                    } else if (c12 != 4) {
                        AbstractC0246d.B0(parcel, i16);
                    } else {
                        zL011 = AbstractC0246d.l0(parcel, i16);
                    }
                }
                AbstractC0246d.J(parcel, iM011);
                return new com.google.android.gms.common.zzs(strA16, iBinderP02, zL010, zL011);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2162a) {
            case 0:
                return new ActivityTransitionResult[i];
            case 1:
                return new DetectedActivity[i];
            case 2:
                return new zzs[i];
            case 3:
                return new ParcelableSparseBooleanArray[i];
            case 4:
                return new ParcelableSparseIntArray[i];
            case 5:
                return new GoogleSignInAccount[i];
            case 6:
                return new GoogleSignInOptions[i];
            case 7:
                return new GoogleSignInOptionsExtensionParcelable[i];
            case 8:
                return new ConnectionResult[i];
            case 9:
                return new Feature[i];
            case 10:
                return new zzo[i];
            case 11:
                return new zzq[i];
            default:
                return new com.google.android.gms.common.zzs[i];
        }
    }
}
