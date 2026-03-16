package Q;

import D.j;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c4.AbstractC0246d;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.internal.location.zzbe;
import com.google.android.gms.internal.location.zzj;
import com.google.android.gms.internal.location.zzl;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.SleepClassifyEvent;
import com.google.android.gms.location.SleepSegmentEvent;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.zzbj;
import com.google.android.gms.location.zzbo;
import com.google.android.gms.location.zzbq;
import com.google.android.gms.location.zzbx;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.material.badge.BadgeState$State;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1231a;

    public /* synthetic */ h(int i) {
        this.f1231a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1231a) {
            case 0:
                int iM0 = AbstractC0246d.M0(parcel);
                zzj zzjVar = null;
                int iQ0 = 1;
                IBinder iBinderP0 = null;
                IBinder iBinderP02 = null;
                while (parcel.dataPosition() < iM0) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        iQ0 = AbstractC0246d.q0(parcel, i);
                    } else if (c == 2) {
                        zzjVar = (zzj) AbstractC0246d.x(parcel, i, zzj.CREATOR);
                    } else if (c == 3) {
                        iBinderP0 = AbstractC0246d.p0(parcel, i);
                    } else if (c != 4) {
                        AbstractC0246d.B0(parcel, i);
                    } else {
                        iBinderP02 = AbstractC0246d.p0(parcel, i);
                    }
                }
                AbstractC0246d.J(parcel, iM0);
                return new zzl(iQ0, zzjVar, iBinderP0, iBinderP02);
            case 1:
                int iM02 = AbstractC0246d.M0(parcel);
                int iQ02 = 0;
                String strA = null;
                String strA2 = null;
                String strA3 = null;
                while (parcel.dataPosition() < iM02) {
                    int i3 = parcel.readInt();
                    char c6 = (char) i3;
                    if (c6 == 1) {
                        iQ02 = AbstractC0246d.q0(parcel, i3);
                    } else if (c6 == 2) {
                        strA = AbstractC0246d.A(parcel, i3);
                    } else if (c6 == 3) {
                        strA2 = AbstractC0246d.A(parcel, i3);
                    } else if (c6 != 4) {
                        AbstractC0246d.B0(parcel, i3);
                    } else {
                        strA3 = AbstractC0246d.A(parcel, i3);
                    }
                }
                AbstractC0246d.J(parcel, iM02);
                return new PlaceReport(iQ02, strA, strA2, strA3);
            case 2:
                int iM03 = AbstractC0246d.M0(parcel);
                Intent intent = null;
                int iQ03 = 0;
                int iQ04 = 0;
                while (parcel.dataPosition() < iM03) {
                    int i4 = parcel.readInt();
                    char c7 = (char) i4;
                    if (c7 == 1) {
                        iQ03 = AbstractC0246d.q0(parcel, i4);
                    } else if (c7 == 2) {
                        iQ04 = AbstractC0246d.q0(parcel, i4);
                    } else if (c7 != 3) {
                        AbstractC0246d.B0(parcel, i4);
                    } else {
                        intent = (Intent) AbstractC0246d.x(parcel, i4, Intent.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM03);
                return new zaa(iQ03, iQ04, intent);
            case 3:
                int iM04 = AbstractC0246d.M0(parcel);
                ArrayList arrayListB = null;
                String strA4 = null;
                while (parcel.dataPosition() < iM04) {
                    int i5 = parcel.readInt();
                    char c8 = (char) i5;
                    if (c8 == 1) {
                        arrayListB = AbstractC0246d.B(parcel, i5);
                    } else if (c8 != 2) {
                        AbstractC0246d.B0(parcel, i5);
                    } else {
                        strA4 = AbstractC0246d.A(parcel, i5);
                    }
                }
                AbstractC0246d.J(parcel, iM04);
                return new zag(arrayListB, strA4);
            case 4:
                int iM05 = AbstractC0246d.M0(parcel);
                zat zatVar = null;
                int iQ05 = 0;
                while (parcel.dataPosition() < iM05) {
                    int i6 = parcel.readInt();
                    char c9 = (char) i6;
                    if (c9 == 1) {
                        iQ05 = AbstractC0246d.q0(parcel, i6);
                    } else if (c9 != 2) {
                        AbstractC0246d.B0(parcel, i6);
                    } else {
                        zatVar = (zat) AbstractC0246d.x(parcel, i6, zat.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM05);
                return new zai(iQ05, zatVar);
            case 5:
                int iM06 = AbstractC0246d.M0(parcel);
                ConnectionResult connectionResult = null;
                int iQ06 = 0;
                zav zavVar = null;
                while (parcel.dataPosition() < iM06) {
                    int i7 = parcel.readInt();
                    char c10 = (char) i7;
                    if (c10 == 1) {
                        iQ06 = AbstractC0246d.q0(parcel, i7);
                    } else if (c10 == 2) {
                        connectionResult = (ConnectionResult) AbstractC0246d.x(parcel, i7, ConnectionResult.CREATOR);
                    } else if (c10 != 3) {
                        AbstractC0246d.B0(parcel, i7);
                    } else {
                        zavVar = (zav) AbstractC0246d.x(parcel, i7, zav.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM06);
                return new zak(iQ06, connectionResult, zavVar);
            case 6:
                BadgeState$State badgeState$State = new BadgeState$State();
                badgeState$State.i = 255;
                badgeState$State.f2189j = -2;
                badgeState$State.f2190k = -2;
                badgeState$State.q = Boolean.TRUE;
                badgeState$State.f2185a = parcel.readInt();
                badgeState$State.b = (Integer) parcel.readSerializable();
                badgeState$State.c = (Integer) parcel.readSerializable();
                badgeState$State.d = (Integer) parcel.readSerializable();
                badgeState$State.e = (Integer) parcel.readSerializable();
                badgeState$State.f2186f = (Integer) parcel.readSerializable();
                badgeState$State.f2187g = (Integer) parcel.readSerializable();
                badgeState$State.f2188h = (Integer) parcel.readSerializable();
                badgeState$State.i = parcel.readInt();
                badgeState$State.f2189j = parcel.readInt();
                badgeState$State.f2190k = parcel.readInt();
                badgeState$State.f2192m = parcel.readString();
                badgeState$State.f2193n = parcel.readInt();
                badgeState$State.f2195p = (Integer) parcel.readSerializable();
                badgeState$State.f2196r = (Integer) parcel.readSerializable();
                badgeState$State.f2197s = (Integer) parcel.readSerializable();
                badgeState$State.f2198t = (Integer) parcel.readSerializable();
                badgeState$State.u = (Integer) parcel.readSerializable();
                badgeState$State.f2199v = (Integer) parcel.readSerializable();
                badgeState$State.f2200w = (Integer) parcel.readSerializable();
                badgeState$State.q = (Boolean) parcel.readSerializable();
                badgeState$State.f2191l = (Locale) parcel.readSerializable();
                return badgeState$State;
            case 7:
                int iM07 = AbstractC0246d.M0(parcel);
                int iQ07 = 0;
                int iQ08 = 0;
                Uri uri = null;
                int iQ09 = 0;
                while (parcel.dataPosition() < iM07) {
                    int i8 = parcel.readInt();
                    char c11 = (char) i8;
                    if (c11 == 1) {
                        iQ07 = AbstractC0246d.q0(parcel, i8);
                    } else if (c11 == 2) {
                        uri = (Uri) AbstractC0246d.x(parcel, i8, Uri.CREATOR);
                    } else if (c11 == 3) {
                        iQ09 = AbstractC0246d.q0(parcel, i8);
                    } else if (c11 != 4) {
                        AbstractC0246d.B0(parcel, i8);
                    } else {
                        iQ08 = AbstractC0246d.q0(parcel, i8);
                    }
                }
                AbstractC0246d.J(parcel, iM07);
                return new WebImage(iQ07, uri, iQ09, iQ08);
            case 8:
                int iM08 = AbstractC0246d.M0(parcel);
                String strA5 = null;
                int iQ010 = 0;
                FastJsonResponse$Field fastJsonResponse$Field = null;
                while (parcel.dataPosition() < iM08) {
                    int i9 = parcel.readInt();
                    char c12 = (char) i9;
                    if (c12 == 1) {
                        iQ010 = AbstractC0246d.q0(parcel, i9);
                    } else if (c12 == 2) {
                        strA5 = AbstractC0246d.A(parcel, i9);
                    } else if (c12 != 3) {
                        AbstractC0246d.B0(parcel, i9);
                    } else {
                        fastJsonResponse$Field = (FastJsonResponse$Field) AbstractC0246d.x(parcel, i9, FastJsonResponse$Field.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM08);
                return new zam(iQ010, strA5, fastJsonResponse$Field);
            case 9:
                int iM09 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE = null;
                int iQ011 = 0;
                String strA6 = null;
                while (parcel.dataPosition() < iM09) {
                    int i10 = parcel.readInt();
                    char c13 = (char) i10;
                    if (c13 == 1) {
                        iQ011 = AbstractC0246d.q0(parcel, i10);
                    } else if (c13 == 2) {
                        arrayListE = AbstractC0246d.E(parcel, i10, zal.CREATOR);
                    } else if (c13 != 3) {
                        AbstractC0246d.B0(parcel, i10);
                    } else {
                        strA6 = AbstractC0246d.A(parcel, i10);
                    }
                }
                AbstractC0246d.J(parcel, iM09);
                return new zan(iQ011, strA6, arrayListE);
            case 10:
                int iM010 = AbstractC0246d.M0(parcel);
                String strA7 = null;
                int iQ012 = 0;
                ArrayList arrayListE2 = null;
                while (parcel.dataPosition() < iM010) {
                    int i11 = parcel.readInt();
                    char c14 = (char) i11;
                    if (c14 == 1) {
                        iQ012 = AbstractC0246d.q0(parcel, i11);
                    } else if (c14 == 2) {
                        strA7 = AbstractC0246d.A(parcel, i11);
                    } else if (c14 != 3) {
                        AbstractC0246d.B0(parcel, i11);
                    } else {
                        arrayListE2 = AbstractC0246d.E(parcel, i11, zam.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM010);
                return new zal(iQ012, strA7, arrayListE2);
            case 11:
                int iM011 = AbstractC0246d.M0(parcel);
                int iQ013 = 0;
                Parcel parcel2 = null;
                zan zanVar = null;
                while (parcel.dataPosition() < iM011) {
                    int i12 = parcel.readInt();
                    char c15 = (char) i12;
                    if (c15 == 1) {
                        iQ013 = AbstractC0246d.q0(parcel, i12);
                    } else if (c15 == 2) {
                        int iT0 = AbstractC0246d.t0(parcel, i12);
                        int iDataPosition = parcel.dataPosition();
                        if (iT0 == 0) {
                            parcel2 = null;
                        } else {
                            Parcel parcelObtain = Parcel.obtain();
                            parcelObtain.appendFrom(parcel, iDataPosition, iT0);
                            parcel.setDataPosition(iDataPosition + iT0);
                            parcel2 = parcelObtain;
                        }
                    } else if (c15 != 3) {
                        AbstractC0246d.B0(parcel, i12);
                    } else {
                        zanVar = (zan) AbstractC0246d.x(parcel, i12, zan.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM011);
                return new SafeParcelResponse(iQ013, parcel2, zanVar);
            case 12:
                int iM012 = AbstractC0246d.M0(parcel);
                String strA8 = "";
                ArrayList arrayListE3 = null;
                int iQ014 = 0;
                String strA9 = null;
                while (parcel.dataPosition() < iM012) {
                    int i13 = parcel.readInt();
                    char c16 = (char) i13;
                    if (c16 == 1) {
                        arrayListE3 = AbstractC0246d.E(parcel, i13, zzbe.CREATOR);
                    } else if (c16 == 2) {
                        iQ014 = AbstractC0246d.q0(parcel, i13);
                    } else if (c16 == 3) {
                        strA8 = AbstractC0246d.A(parcel, i13);
                    } else if (c16 != 4) {
                        AbstractC0246d.B0(parcel, i13);
                    } else {
                        strA9 = AbstractC0246d.A(parcel, i13);
                    }
                }
                AbstractC0246d.J(parcel, iM012);
                return new GeofencingRequest(arrayListE3, iQ014, strA8, strA9);
            case 13:
                int iM013 = AbstractC0246d.M0(parcel);
                int iQ015 = 1000;
                long jR0 = 0;
                zzbo[] zzboVarArr = null;
                int iQ016 = 1;
                int iQ017 = 1;
                while (parcel.dataPosition() < iM013) {
                    int i14 = parcel.readInt();
                    char c17 = (char) i14;
                    if (c17 == 1) {
                        iQ016 = AbstractC0246d.q0(parcel, i14);
                    } else if (c17 == 2) {
                        iQ017 = AbstractC0246d.q0(parcel, i14);
                    } else if (c17 == 3) {
                        jR0 = AbstractC0246d.r0(parcel, i14);
                    } else if (c17 == 4) {
                        iQ015 = AbstractC0246d.q0(parcel, i14);
                    } else if (c17 != 5) {
                        AbstractC0246d.B0(parcel, i14);
                    } else {
                        zzboVarArr = (zzbo[]) AbstractC0246d.D(parcel, i14, zzbo.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM013);
                LocationAvailability locationAvailability = new LocationAvailability();
                locationAvailability.d = iQ015;
                locationAvailability.f2145a = iQ016;
                locationAvailability.b = iQ017;
                locationAvailability.c = jR0;
                locationAvailability.e = zzboVarArr;
                return locationAvailability;
            case 14:
                int iM014 = AbstractC0246d.M0(parcel);
                int iQ018 = 102;
                long jR02 = 3600000;
                long jR03 = 600000;
                boolean zL0 = false;
                long jR04 = 0;
                float fN0 = 0.0f;
                int iQ019 = Integer.MAX_VALUE;
                long jR05 = Long.MAX_VALUE;
                boolean zL02 = false;
                while (parcel.dataPosition() < iM014) {
                    int i15 = parcel.readInt();
                    boolean z6 = zL02;
                    switch ((char) i15) {
                        case 1:
                            iQ018 = AbstractC0246d.q0(parcel, i15);
                            break;
                        case 2:
                            jR02 = AbstractC0246d.r0(parcel, i15);
                            break;
                        case 3:
                            jR03 = AbstractC0246d.r0(parcel, i15);
                            break;
                        case 4:
                            zL0 = AbstractC0246d.l0(parcel, i15);
                            break;
                        case 5:
                            jR05 = AbstractC0246d.r0(parcel, i15);
                            break;
                        case 6:
                            iQ019 = AbstractC0246d.q0(parcel, i15);
                            break;
                        case 7:
                            fN0 = AbstractC0246d.n0(parcel, i15);
                            break;
                        case '\b':
                            jR04 = AbstractC0246d.r0(parcel, i15);
                            break;
                        case '\t':
                            zL02 = AbstractC0246d.l0(parcel, i15);
                            continue;
                        default:
                            AbstractC0246d.B0(parcel, i15);
                            break;
                    }
                    zL02 = z6;
                }
                AbstractC0246d.J(parcel, iM014);
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.f2146a = iQ018;
                locationRequest.b = jR02;
                locationRequest.c = jR03;
                locationRequest.d = zL0;
                locationRequest.e = jR05;
                locationRequest.f2147f = iQ019;
                locationRequest.f2148g = fN0;
                locationRequest.f2149h = jR04;
                locationRequest.i = zL02;
                return locationRequest;
            case 15:
                int iM015 = AbstractC0246d.M0(parcel);
                List listE = LocationResult.b;
                while (parcel.dataPosition() < iM015) {
                    int i16 = parcel.readInt();
                    if (((char) i16) != 1) {
                        AbstractC0246d.B0(parcel, i16);
                    } else {
                        listE = AbstractC0246d.E(parcel, i16, Location.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM015);
                return new LocationResult(listE);
            case 16:
                int iM016 = AbstractC0246d.M0(parcel);
                String strA10 = "";
                String strA11 = "";
                String strA12 = strA11;
                while (parcel.dataPosition() < iM016) {
                    int i17 = parcel.readInt();
                    char c18 = (char) i17;
                    if (c18 == 1) {
                        strA11 = AbstractC0246d.A(parcel, i17);
                    } else if (c18 == 2) {
                        strA12 = AbstractC0246d.A(parcel, i17);
                    } else if (c18 != 5) {
                        AbstractC0246d.B0(parcel, i17);
                    } else {
                        strA10 = AbstractC0246d.A(parcel, i17);
                    }
                }
                AbstractC0246d.J(parcel, iM016);
                return new zzbj(strA10, strA11, strA12);
            case 17:
                int iM017 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE4 = null;
                boolean zL03 = false;
                boolean zL04 = false;
                zzbj zzbjVar = null;
                while (parcel.dataPosition() < iM017) {
                    int i18 = parcel.readInt();
                    char c19 = (char) i18;
                    if (c19 == 1) {
                        arrayListE4 = AbstractC0246d.E(parcel, i18, LocationRequest.CREATOR);
                    } else if (c19 == 2) {
                        zL03 = AbstractC0246d.l0(parcel, i18);
                    } else if (c19 == 3) {
                        zL04 = AbstractC0246d.l0(parcel, i18);
                    } else if (c19 != 5) {
                        AbstractC0246d.B0(parcel, i18);
                    } else {
                        zzbjVar = (zzbj) AbstractC0246d.x(parcel, i18, zzbj.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM017);
                return new LocationSettingsRequest(arrayListE4, zL03, zL04, zzbjVar);
            case 18:
                int iM018 = AbstractC0246d.M0(parcel);
                Status status = null;
                LocationSettingsStates locationSettingsStates = null;
                while (parcel.dataPosition() < iM018) {
                    int i19 = parcel.readInt();
                    char c20 = (char) i19;
                    if (c20 == 1) {
                        status = (Status) AbstractC0246d.x(parcel, i19, Status.CREATOR);
                    } else if (c20 != 2) {
                        AbstractC0246d.B0(parcel, i19);
                    } else {
                        locationSettingsStates = (LocationSettingsStates) AbstractC0246d.x(parcel, i19, LocationSettingsStates.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM018);
                return new LocationSettingsResult(status, locationSettingsStates);
            case 19:
                int iM019 = AbstractC0246d.M0(parcel);
                boolean zL05 = false;
                boolean zL06 = false;
                boolean zL07 = false;
                boolean zL08 = false;
                boolean zL09 = false;
                boolean zL010 = false;
                while (parcel.dataPosition() < iM019) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            zL05 = AbstractC0246d.l0(parcel, i20);
                            break;
                        case 2:
                            zL06 = AbstractC0246d.l0(parcel, i20);
                            break;
                        case 3:
                            zL07 = AbstractC0246d.l0(parcel, i20);
                            break;
                        case 4:
                            zL08 = AbstractC0246d.l0(parcel, i20);
                            break;
                        case 5:
                            zL09 = AbstractC0246d.l0(parcel, i20);
                            break;
                        case 6:
                            zL010 = AbstractC0246d.l0(parcel, i20);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i20);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM019);
                return new LocationSettingsStates(zL05, zL06, zL07, zL08, zL09, zL010);
            case 20:
                int iM020 = AbstractC0246d.M0(parcel);
                int iQ020 = 1;
                int iQ021 = 1;
                long jR06 = -1;
                long jR07 = -1;
                while (parcel.dataPosition() < iM020) {
                    int i21 = parcel.readInt();
                    char c21 = (char) i21;
                    if (c21 == 1) {
                        iQ020 = AbstractC0246d.q0(parcel, i21);
                    } else if (c21 == 2) {
                        iQ021 = AbstractC0246d.q0(parcel, i21);
                    } else if (c21 == 3) {
                        jR06 = AbstractC0246d.r0(parcel, i21);
                    } else if (c21 != 4) {
                        AbstractC0246d.B0(parcel, i21);
                    } else {
                        jR07 = AbstractC0246d.r0(parcel, i21);
                    }
                }
                AbstractC0246d.J(parcel, iM020);
                return new zzbo(iQ020, iQ021, jR06, jR07);
            case 21:
                int iM021 = AbstractC0246d.M0(parcel);
                String strA13 = "";
                ArrayList arrayListB2 = null;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iM021) {
                    int i22 = parcel.readInt();
                    char c22 = (char) i22;
                    if (c22 == 1) {
                        arrayListB2 = AbstractC0246d.B(parcel, i22);
                    } else if (c22 == 2) {
                        pendingIntent = (PendingIntent) AbstractC0246d.x(parcel, i22, PendingIntent.CREATOR);
                    } else if (c22 != 3) {
                        AbstractC0246d.B0(parcel, i22);
                    } else {
                        strA13 = AbstractC0246d.A(parcel, i22);
                    }
                }
                AbstractC0246d.J(parcel, iM021);
                return new zzbq(arrayListB2, pendingIntent, strA13);
            case 22:
                int iM022 = AbstractC0246d.M0(parcel);
                int iQ022 = 0;
                int iQ023 = 0;
                int iQ024 = 0;
                int iQ025 = 0;
                int iQ026 = 0;
                int iQ027 = 0;
                int iQ028 = 0;
                int iQ029 = 0;
                boolean zL011 = false;
                while (parcel.dataPosition() < iM022) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 1:
                            iQ022 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 2:
                            iQ023 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 3:
                            iQ024 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 4:
                            iQ025 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 5:
                            iQ026 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 6:
                            iQ027 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case 7:
                            iQ028 = AbstractC0246d.q0(parcel, i23);
                            break;
                        case '\b':
                            zL011 = AbstractC0246d.l0(parcel, i23);
                            break;
                        case '\t':
                            iQ029 = AbstractC0246d.q0(parcel, i23);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i23);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM022);
                return new SleepClassifyEvent(iQ022, iQ023, iQ024, iQ025, iQ026, iQ027, iQ028, iQ029, zL011);
            case 23:
                int iM023 = AbstractC0246d.M0(parcel);
                long jR08 = 0;
                long jR09 = 0;
                int iQ030 = 0;
                int iQ031 = 0;
                int iQ032 = 0;
                while (parcel.dataPosition() < iM023) {
                    int i24 = parcel.readInt();
                    char c23 = (char) i24;
                    if (c23 == 1) {
                        jR08 = AbstractC0246d.r0(parcel, i24);
                    } else if (c23 == 2) {
                        jR09 = AbstractC0246d.r0(parcel, i24);
                    } else if (c23 == 3) {
                        iQ030 = AbstractC0246d.q0(parcel, i24);
                    } else if (c23 == 4) {
                        iQ031 = AbstractC0246d.q0(parcel, i24);
                    } else if (c23 != 5) {
                        AbstractC0246d.B0(parcel, i24);
                    } else {
                        iQ032 = AbstractC0246d.q0(parcel, i24);
                    }
                }
                AbstractC0246d.J(parcel, iM023);
                return new SleepSegmentEvent(iQ030, iQ031, iQ032, jR08, jR09);
            case 24:
                int iM024 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE5 = null;
                int iQ033 = 0;
                while (parcel.dataPosition() < iM024) {
                    int i25 = parcel.readInt();
                    char c24 = (char) i25;
                    if (c24 == 1) {
                        arrayListE5 = AbstractC0246d.E(parcel, i25, zzbx.CREATOR);
                    } else if (c24 != 2) {
                        AbstractC0246d.B0(parcel, i25);
                    } else {
                        iQ033 = AbstractC0246d.q0(parcel, i25);
                    }
                }
                AbstractC0246d.J(parcel, iM024);
                return new SleepSegmentRequest(iQ033, arrayListE5);
            case 25:
                int iM025 = AbstractC0246d.M0(parcel);
                int iQ034 = 0;
                int iQ035 = 0;
                int iQ036 = 0;
                int iQ037 = 0;
                while (parcel.dataPosition() < iM025) {
                    int i26 = parcel.readInt();
                    char c25 = (char) i26;
                    if (c25 == 1) {
                        iQ034 = AbstractC0246d.q0(parcel, i26);
                    } else if (c25 == 2) {
                        iQ035 = AbstractC0246d.q0(parcel, i26);
                    } else if (c25 == 3) {
                        iQ036 = AbstractC0246d.q0(parcel, i26);
                    } else if (c25 != 4) {
                        AbstractC0246d.B0(parcel, i26);
                    } else {
                        iQ037 = AbstractC0246d.q0(parcel, i26);
                    }
                }
                AbstractC0246d.J(parcel, iM025);
                return new zzbx(iQ034, iQ035, iQ036, iQ037);
            case 26:
                int iM026 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE6 = null;
                boolean z7 = false;
                Bundle bundleT = null;
                long jR010 = 0;
                long jR011 = 0;
                int iQ038 = 0;
                while (parcel.dataPosition() < iM026) {
                    int i27 = parcel.readInt();
                    char c26 = (char) i27;
                    if (c26 == 1) {
                        arrayListE6 = AbstractC0246d.E(parcel, i27, DetectedActivity.CREATOR);
                    } else if (c26 == 2) {
                        jR010 = AbstractC0246d.r0(parcel, i27);
                    } else if (c26 == 3) {
                        jR011 = AbstractC0246d.r0(parcel, i27);
                    } else if (c26 == 4) {
                        iQ038 = AbstractC0246d.q0(parcel, i27);
                    } else if (c26 != 5) {
                        AbstractC0246d.B0(parcel, i27);
                    } else {
                        bundleT = AbstractC0246d.t(parcel, i27);
                    }
                }
                AbstractC0246d.J(parcel, iM026);
                ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult();
                j.a("Must have at least 1 detected activity", arrayListE6 != null && arrayListE6.size() > 0);
                if (jR010 > 0 && jR011 > 0) {
                    z7 = true;
                }
                j.a("Must set times", z7);
                activityRecognitionResult.f2138a = arrayListE6;
                activityRecognitionResult.b = jR010;
                activityRecognitionResult.c = jR011;
                activityRecognitionResult.d = iQ038;
                activityRecognitionResult.e = bundleT;
                return activityRecognitionResult;
            case 27:
                int iM027 = AbstractC0246d.M0(parcel);
                int iQ039 = 0;
                int iQ040 = 0;
                while (parcel.dataPosition() < iM027) {
                    int i28 = parcel.readInt();
                    char c27 = (char) i28;
                    if (c27 == 1) {
                        iQ039 = AbstractC0246d.q0(parcel, i28);
                    } else if (c27 != 2) {
                        AbstractC0246d.B0(parcel, i28);
                    } else {
                        iQ040 = AbstractC0246d.q0(parcel, i28);
                    }
                }
                AbstractC0246d.J(parcel, iM027);
                return new ActivityTransition(iQ039, iQ040);
            case 28:
                int iM028 = AbstractC0246d.M0(parcel);
                int iQ041 = 0;
                long jR012 = 0;
                int iQ042 = 0;
                while (parcel.dataPosition() < iM028) {
                    int i29 = parcel.readInt();
                    char c28 = (char) i29;
                    if (c28 == 1) {
                        iQ041 = AbstractC0246d.q0(parcel, i29);
                    } else if (c28 == 2) {
                        iQ042 = AbstractC0246d.q0(parcel, i29);
                    } else if (c28 != 3) {
                        AbstractC0246d.B0(parcel, i29);
                    } else {
                        jR012 = AbstractC0246d.r0(parcel, i29);
                    }
                }
                AbstractC0246d.J(parcel, iM028);
                return new ActivityTransitionEvent(iQ041, iQ042, jR012);
            default:
                int iM029 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE7 = null;
                String strA14 = null;
                ArrayList arrayListE8 = null;
                String strA15 = null;
                while (parcel.dataPosition() < iM029) {
                    int i30 = parcel.readInt();
                    char c29 = (char) i30;
                    if (c29 == 1) {
                        arrayListE7 = AbstractC0246d.E(parcel, i30, ActivityTransition.CREATOR);
                    } else if (c29 == 2) {
                        strA14 = AbstractC0246d.A(parcel, i30);
                    } else if (c29 == 3) {
                        arrayListE8 = AbstractC0246d.E(parcel, i30, ClientIdentity.CREATOR);
                    } else if (c29 != 4) {
                        AbstractC0246d.B0(parcel, i30);
                    } else {
                        strA15 = AbstractC0246d.A(parcel, i30);
                    }
                }
                AbstractC0246d.J(parcel, iM029);
                return new ActivityTransitionRequest(arrayListE7, strA14, arrayListE8, strA15);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f1231a) {
            case 0:
                return new zzl[i];
            case 1:
                return new PlaceReport[i];
            case 2:
                return new zaa[i];
            case 3:
                return new zag[i];
            case 4:
                return new zai[i];
            case 5:
                return new zak[i];
            case 6:
                return new BadgeState$State[i];
            case 7:
                return new WebImage[i];
            case 8:
                return new zam[i];
            case 9:
                return new zan[i];
            case 10:
                return new zal[i];
            case 11:
                return new SafeParcelResponse[i];
            case 12:
                return new GeofencingRequest[i];
            case 13:
                return new LocationAvailability[i];
            case 14:
                return new LocationRequest[i];
            case 15:
                return new LocationResult[i];
            case 16:
                return new zzbj[i];
            case 17:
                return new LocationSettingsRequest[i];
            case 18:
                return new LocationSettingsResult[i];
            case 19:
                return new LocationSettingsStates[i];
            case 20:
                return new zzbo[i];
            case 21:
                return new zzbq[i];
            case 22:
                return new SleepClassifyEvent[i];
            case 23:
                return new SleepSegmentEvent[i];
            case 24:
                return new SleepSegmentRequest[i];
            case 25:
                return new zzbx[i];
            case 26:
                return new ActivityRecognitionResult[i];
            case 27:
                return new ActivityTransition[i];
            case 28:
                return new ActivityTransitionEvent[i];
            default:
                return new ActivityTransitionRequest[i];
        }
    }
}
