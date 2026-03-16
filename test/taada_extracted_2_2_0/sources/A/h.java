package A;

import a.AbstractC0132a;
import android.accounts.Account;
import android.app.PendingIntent;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import c4.AbstractC0246d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.internal.location.zzbe;
import com.google.android.gms.internal.location.zzj;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2a;

    public /* synthetic */ h(int i) {
        this.f2a = i;
    }

    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(getServiceRequest.f1948a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.c);
        AbstractC0132a.n0(parcel, 4, getServiceRequest.d);
        AbstractC0132a.l0(parcel, 5, getServiceRequest.e);
        AbstractC0132a.q0(parcel, 6, getServiceRequest.f1949f, i);
        AbstractC0132a.k0(parcel, 7, getServiceRequest.f1950g);
        AbstractC0132a.m0(parcel, 8, getServiceRequest.f1951h, i);
        AbstractC0132a.q0(parcel, 10, getServiceRequest.i, i);
        AbstractC0132a.q0(parcel, 11, getServiceRequest.f1952j, i);
        AbstractC0132a.u0(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f1953k ? 1 : 0);
        AbstractC0132a.u0(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f1954l);
        boolean z6 = getServiceRequest.f1955m;
        AbstractC0132a.u0(parcel, 14, 4);
        parcel.writeInt(z6 ? 1 : 0);
        AbstractC0132a.n0(parcel, 15, getServiceRequest.f1956n);
        AbstractC0132a.t0(parcel, iS0);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2a) {
            case 0:
                int iM0 = AbstractC0246d.M0(parcel);
                String strA = null;
                int iQ0 = 0;
                while (parcel.dataPosition() < iM0) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        iQ0 = AbstractC0246d.q0(parcel, i);
                    } else if (c != 2) {
                        AbstractC0246d.B0(parcel, i);
                    } else {
                        strA = AbstractC0246d.A(parcel, i);
                    }
                }
                AbstractC0246d.J(parcel, iM0);
                return new Scope(iQ0, strA);
            case 1:
                int iM02 = AbstractC0246d.M0(parcel);
                String strA2 = null;
                ConnectionResult connectionResult = null;
                int iQ02 = 0;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iM02) {
                    int i3 = parcel.readInt();
                    char c6 = (char) i3;
                    if (c6 == 1) {
                        iQ02 = AbstractC0246d.q0(parcel, i3);
                    } else if (c6 == 2) {
                        strA2 = AbstractC0246d.A(parcel, i3);
                    } else if (c6 == 3) {
                        pendingIntent = (PendingIntent) AbstractC0246d.x(parcel, i3, PendingIntent.CREATOR);
                    } else if (c6 != 4) {
                        AbstractC0246d.B0(parcel, i3);
                    } else {
                        connectionResult = (ConnectionResult) AbstractC0246d.x(parcel, i3, ConnectionResult.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM02);
                return new Status(iQ02, strA2, pendingIntent, connectionResult);
            case 2:
                int iM03 = AbstractC0246d.M0(parcel);
                int iQ03 = 0;
                ParcelFileDescriptor parcelFileDescriptor = null;
                int iQ04 = 0;
                while (parcel.dataPosition() < iM03) {
                    int i4 = parcel.readInt();
                    char c7 = (char) i4;
                    if (c7 == 1) {
                        iQ03 = AbstractC0246d.q0(parcel, i4);
                    } else if (c7 == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) AbstractC0246d.x(parcel, i4, ParcelFileDescriptor.CREATOR);
                    } else if (c7 != 3) {
                        AbstractC0246d.B0(parcel, i4);
                    } else {
                        iQ04 = AbstractC0246d.q0(parcel, i4);
                    }
                }
                AbstractC0246d.J(parcel, iM03);
                return new BitmapTeleporter(iQ03, parcelFileDescriptor, iQ04);
            case 3:
                int iM04 = AbstractC0246d.M0(parcel);
                String[] strArr = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleT = null;
                int iQ05 = 0;
                int iQ06 = 0;
                while (parcel.dataPosition() < iM04) {
                    int i5 = parcel.readInt();
                    char c8 = (char) i5;
                    if (c8 == 1) {
                        int iT0 = AbstractC0246d.t0(parcel, i5);
                        int iDataPosition = parcel.dataPosition();
                        if (iT0 == 0) {
                            strArr = null;
                        } else {
                            String[] strArrCreateStringArray = parcel.createStringArray();
                            parcel.setDataPosition(iDataPosition + iT0);
                            strArr = strArrCreateStringArray;
                        }
                    } else if (c8 == 2) {
                        cursorWindowArr = (CursorWindow[]) AbstractC0246d.D(parcel, i5, CursorWindow.CREATOR);
                    } else if (c8 == 3) {
                        iQ06 = AbstractC0246d.q0(parcel, i5);
                    } else if (c8 == 4) {
                        bundleT = AbstractC0246d.t(parcel, i5);
                    } else if (c8 != 1000) {
                        AbstractC0246d.B0(parcel, i5);
                    } else {
                        iQ05 = AbstractC0246d.q0(parcel, i5);
                    }
                }
                AbstractC0246d.J(parcel, iM04);
                DataHolder dataHolder = new DataHolder(iQ05, strArr, cursorWindowArr, iQ06, bundleT);
                dataHolder.c = new Bundle();
                int i6 = 0;
                while (true) {
                    String[] strArr2 = dataHolder.b;
                    if (i6 >= strArr2.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.d;
                        dataHolder.f1938g = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i7 = 0; i7 < cursorWindowArr2.length; i7++) {
                            dataHolder.f1938g[i7] = numRows;
                            numRows += cursorWindowArr2[i7].getNumRows() - (numRows - cursorWindowArr2[i7].getStartPosition());
                        }
                        return dataHolder;
                    }
                    dataHolder.c.putInt(strArr2[i6], i6);
                    i6++;
                }
                break;
            case 4:
                int iM05 = AbstractC0246d.M0(parcel);
                String strA3 = null;
                int iQ07 = 0;
                while (parcel.dataPosition() < iM05) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 1) {
                        iQ07 = AbstractC0246d.q0(parcel, i8);
                    } else if (c9 != 2) {
                        AbstractC0246d.B0(parcel, i8);
                    } else {
                        strA3 = AbstractC0246d.A(parcel, i8);
                    }
                }
                AbstractC0246d.J(parcel, iM05);
                return new ClientIdentity(iQ07, strA3);
            case 5:
                int iM06 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE = null;
                int iQ08 = 0;
                while (parcel.dataPosition() < iM06) {
                    int i9 = parcel.readInt();
                    char c10 = (char) i9;
                    if (c10 == 1) {
                        iQ08 = AbstractC0246d.q0(parcel, i9);
                    } else if (c10 != 2) {
                        AbstractC0246d.B0(parcel, i9);
                    } else {
                        arrayListE = AbstractC0246d.E(parcel, i9, MethodInvocation.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM06);
                return new TelemetryData(iQ08, arrayListE);
            case 6:
                int iM07 = AbstractC0246d.M0(parcel);
                int iQ09 = -1;
                int iQ010 = 0;
                int iQ011 = 0;
                int iQ012 = 0;
                int iQ013 = 0;
                String strA4 = null;
                String strA5 = null;
                long jR0 = 0;
                long jR02 = 0;
                while (parcel.dataPosition() < iM07) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iQ010 = AbstractC0246d.q0(parcel, i10);
                            break;
                        case 2:
                            iQ011 = AbstractC0246d.q0(parcel, i10);
                            break;
                        case 3:
                            iQ012 = AbstractC0246d.q0(parcel, i10);
                            break;
                        case 4:
                            jR0 = AbstractC0246d.r0(parcel, i10);
                            break;
                        case 5:
                            jR02 = AbstractC0246d.r0(parcel, i10);
                            break;
                        case 6:
                            strA4 = AbstractC0246d.A(parcel, i10);
                            break;
                        case 7:
                            strA5 = AbstractC0246d.A(parcel, i10);
                            break;
                        case '\b':
                            iQ013 = AbstractC0246d.q0(parcel, i10);
                            break;
                        case '\t':
                            iQ09 = AbstractC0246d.q0(parcel, i10);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i10);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM07);
                return new MethodInvocation(iQ010, iQ011, iQ012, jR0, jR02, strA4, strA5, iQ013, iQ09);
            case 7:
                int iM08 = AbstractC0246d.M0(parcel);
                Account account = null;
                int iQ014 = 0;
                int iQ015 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < iM08) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 1) {
                        iQ014 = AbstractC0246d.q0(parcel, i11);
                    } else if (c11 == 2) {
                        account = (Account) AbstractC0246d.x(parcel, i11, Account.CREATOR);
                    } else if (c11 == 3) {
                        iQ015 = AbstractC0246d.q0(parcel, i11);
                    } else if (c11 != 4) {
                        AbstractC0246d.B0(parcel, i11);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) AbstractC0246d.x(parcel, i11, GoogleSignInAccount.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM08);
                return new zat(iQ014, account, iQ015, googleSignInAccount);
            case 8:
                int iM09 = AbstractC0246d.M0(parcel);
                int iQ016 = 0;
                boolean zL0 = false;
                boolean zL02 = false;
                IBinder iBinderP0 = null;
                ConnectionResult connectionResult2 = null;
                while (parcel.dataPosition() < iM09) {
                    int i12 = parcel.readInt();
                    char c12 = (char) i12;
                    if (c12 == 1) {
                        iQ016 = AbstractC0246d.q0(parcel, i12);
                    } else if (c12 == 2) {
                        iBinderP0 = AbstractC0246d.p0(parcel, i12);
                    } else if (c12 == 3) {
                        connectionResult2 = (ConnectionResult) AbstractC0246d.x(parcel, i12, ConnectionResult.CREATOR);
                    } else if (c12 == 4) {
                        zL0 = AbstractC0246d.l0(parcel, i12);
                    } else if (c12 != 5) {
                        AbstractC0246d.B0(parcel, i12);
                    } else {
                        zL02 = AbstractC0246d.l0(parcel, i12);
                    }
                }
                AbstractC0246d.J(parcel, iM09);
                return new zav(iQ016, iBinderP0, connectionResult2, zL0, zL02);
            case 9:
                int iM010 = AbstractC0246d.M0(parcel);
                Scope[] scopeArr = null;
                int iQ017 = 0;
                int iQ018 = 0;
                int iQ019 = 0;
                while (parcel.dataPosition() < iM010) {
                    int i13 = parcel.readInt();
                    char c13 = (char) i13;
                    if (c13 == 1) {
                        iQ017 = AbstractC0246d.q0(parcel, i13);
                    } else if (c13 == 2) {
                        iQ018 = AbstractC0246d.q0(parcel, i13);
                    } else if (c13 == 3) {
                        iQ019 = AbstractC0246d.q0(parcel, i13);
                    } else if (c13 != 4) {
                        AbstractC0246d.B0(parcel, i13);
                    } else {
                        scopeArr = (Scope[]) AbstractC0246d.D(parcel, i13, Scope.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM010);
                return new zax(iQ017, iQ018, iQ019, scopeArr);
            case 10:
                int iM011 = AbstractC0246d.M0(parcel);
                int iQ020 = 0;
                boolean zL03 = false;
                boolean zL04 = false;
                int iQ021 = 0;
                int iQ022 = 0;
                while (parcel.dataPosition() < iM011) {
                    int i14 = parcel.readInt();
                    char c14 = (char) i14;
                    if (c14 == 1) {
                        iQ020 = AbstractC0246d.q0(parcel, i14);
                    } else if (c14 == 2) {
                        zL03 = AbstractC0246d.l0(parcel, i14);
                    } else if (c14 == 3) {
                        zL04 = AbstractC0246d.l0(parcel, i14);
                    } else if (c14 == 4) {
                        iQ021 = AbstractC0246d.q0(parcel, i14);
                    } else if (c14 != 5) {
                        AbstractC0246d.B0(parcel, i14);
                    } else {
                        iQ022 = AbstractC0246d.q0(parcel, i14);
                    }
                }
                AbstractC0246d.J(parcel, iM011);
                return new RootTelemetryConfiguration(iQ020, zL03, zL04, iQ021, iQ022);
            case 11:
                int iM012 = AbstractC0246d.M0(parcel);
                int iQ023 = 0;
                while (parcel.dataPosition() < iM012) {
                    int i15 = parcel.readInt();
                    if (((char) i15) != 1) {
                        AbstractC0246d.B0(parcel, i15);
                    } else {
                        iQ023 = AbstractC0246d.q0(parcel, i15);
                    }
                }
                AbstractC0246d.J(parcel, iM012);
                return new zzak(iQ023);
            case 12:
                return new BinderWrapper(parcel);
            case 13:
                int iM013 = AbstractC0246d.M0(parcel);
                Bundle bundleT2 = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int iQ024 = 0;
                Feature[] featureArr = null;
                while (parcel.dataPosition() < iM013) {
                    int i16 = parcel.readInt();
                    char c15 = (char) i16;
                    if (c15 == 1) {
                        bundleT2 = AbstractC0246d.t(parcel, i16);
                    } else if (c15 == 2) {
                        featureArr = (Feature[]) AbstractC0246d.D(parcel, i16, Feature.CREATOR);
                    } else if (c15 == 3) {
                        iQ024 = AbstractC0246d.q0(parcel, i16);
                    } else if (c15 != 4) {
                        AbstractC0246d.B0(parcel, i16);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) AbstractC0246d.x(parcel, i16, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM013);
                zzk zzkVar = new zzk();
                zzkVar.f1967a = bundleT2;
                zzkVar.b = featureArr;
                zzkVar.c = iQ024;
                zzkVar.d = connectionTelemetryConfiguration;
                return zzkVar;
            case 14:
                int iM014 = AbstractC0246d.M0(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrW = null;
                int[] iArrW2 = null;
                boolean zL05 = false;
                boolean zL06 = false;
                int iQ025 = 0;
                while (parcel.dataPosition() < iM014) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) AbstractC0246d.x(parcel, i17, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            zL05 = AbstractC0246d.l0(parcel, i17);
                            break;
                        case 3:
                            zL06 = AbstractC0246d.l0(parcel, i17);
                            break;
                        case 4:
                            iArrW = AbstractC0246d.w(parcel, i17);
                            break;
                        case 5:
                            iQ025 = AbstractC0246d.q0(parcel, i17);
                            break;
                        case 6:
                            iArrW2 = AbstractC0246d.w(parcel, i17);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i17);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM014);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zL05, zL06, iArrW, iQ025, iArrW2);
            case 15:
                int iM015 = AbstractC0246d.M0(parcel);
                Scope[] scopeArr2 = GetServiceRequest.f1946o;
                Bundle bundle = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.f1947p;
                Feature[] featureArr3 = featureArr2;
                String strA6 = null;
                IBinder iBinderP02 = null;
                Account account2 = null;
                String strA7 = null;
                int iQ026 = 0;
                int iQ027 = 0;
                int iQ028 = 0;
                boolean zL07 = false;
                int iQ029 = 0;
                boolean zL08 = false;
                while (parcel.dataPosition() < iM015) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            iQ026 = AbstractC0246d.q0(parcel, i18);
                            break;
                        case 2:
                            iQ027 = AbstractC0246d.q0(parcel, i18);
                            break;
                        case 3:
                            iQ028 = AbstractC0246d.q0(parcel, i18);
                            break;
                        case 4:
                            strA6 = AbstractC0246d.A(parcel, i18);
                            break;
                        case 5:
                            iBinderP02 = AbstractC0246d.p0(parcel, i18);
                            break;
                        case 6:
                            scopeArr2 = (Scope[]) AbstractC0246d.D(parcel, i18, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = AbstractC0246d.t(parcel, i18);
                            break;
                        case '\b':
                            account2 = (Account) AbstractC0246d.x(parcel, i18, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            AbstractC0246d.B0(parcel, i18);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) AbstractC0246d.D(parcel, i18, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) AbstractC0246d.D(parcel, i18, Feature.CREATOR);
                            break;
                        case '\f':
                            zL07 = AbstractC0246d.l0(parcel, i18);
                            break;
                        case '\r':
                            iQ029 = AbstractC0246d.q0(parcel, i18);
                            break;
                        case 14:
                            zL08 = AbstractC0246d.l0(parcel, i18);
                            break;
                        case 15:
                            strA7 = AbstractC0246d.A(parcel, i18);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM015);
                return new GetServiceRequest(iQ026, iQ027, iQ028, strA6, iBinderP02, scopeArr2, bundle, account2, featureArr2, featureArr3, zL07, iQ029, zL08, strA7);
            case 16:
                int iM016 = AbstractC0246d.M0(parcel);
                boolean zL09 = false;
                int iQ030 = 0;
                while (parcel.dataPosition() < iM016) {
                    int i19 = parcel.readInt();
                    char c16 = (char) i19;
                    if (c16 == 1) {
                        zL09 = AbstractC0246d.l0(parcel, i19);
                    } else if (c16 != 2) {
                        AbstractC0246d.B0(parcel, i19);
                    } else {
                        iQ030 = AbstractC0246d.q0(parcel, i19);
                    }
                }
                AbstractC0246d.J(parcel, iM016);
                return new ModuleAvailabilityResponse(iQ030, zL09);
            case 17:
                int iM017 = AbstractC0246d.M0(parcel);
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iM017) {
                    int i20 = parcel.readInt();
                    if (((char) i20) != 1) {
                        AbstractC0246d.B0(parcel, i20);
                    } else {
                        pendingIntent2 = (PendingIntent) AbstractC0246d.x(parcel, i20, PendingIntent.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM017);
                return new ModuleInstallIntentResponse(pendingIntent2);
            case 18:
                int iM018 = AbstractC0246d.M0(parcel);
                int iQ031 = 0;
                boolean zL010 = false;
                while (parcel.dataPosition() < iM018) {
                    int i21 = parcel.readInt();
                    char c17 = (char) i21;
                    if (c17 == 1) {
                        iQ031 = AbstractC0246d.q0(parcel, i21);
                    } else if (c17 != 2) {
                        AbstractC0246d.B0(parcel, i21);
                    } else {
                        zL010 = AbstractC0246d.l0(parcel, i21);
                    }
                }
                AbstractC0246d.J(parcel, iM018);
                return new ModuleInstallResponse(iQ031, zL010);
            case 19:
                int iM019 = AbstractC0246d.M0(parcel);
                int iQ032 = 0;
                int iQ033 = 0;
                int iQ034 = 0;
                Long lS0 = null;
                Long lS02 = null;
                while (parcel.dataPosition() < iM019) {
                    int i22 = parcel.readInt();
                    char c18 = (char) i22;
                    if (c18 == 1) {
                        iQ032 = AbstractC0246d.q0(parcel, i22);
                    } else if (c18 == 2) {
                        iQ033 = AbstractC0246d.q0(parcel, i22);
                    } else if (c18 == 3) {
                        lS0 = AbstractC0246d.s0(parcel, i22);
                    } else if (c18 == 4) {
                        lS02 = AbstractC0246d.s0(parcel, i22);
                    } else if (c18 != 5) {
                        AbstractC0246d.B0(parcel, i22);
                    } else {
                        iQ034 = AbstractC0246d.q0(parcel, i22);
                    }
                }
                AbstractC0246d.J(parcel, iM019);
                return new ModuleInstallStatusUpdate(iQ032, iQ033, lS0, lS02, iQ034);
            case 20:
                int iM020 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE2 = null;
                String strA8 = null;
                boolean zL011 = false;
                String strA9 = null;
                while (parcel.dataPosition() < iM020) {
                    int i23 = parcel.readInt();
                    char c19 = (char) i23;
                    if (c19 == 1) {
                        arrayListE2 = AbstractC0246d.E(parcel, i23, Feature.CREATOR);
                    } else if (c19 == 2) {
                        zL011 = AbstractC0246d.l0(parcel, i23);
                    } else if (c19 == 3) {
                        strA9 = AbstractC0246d.A(parcel, i23);
                    } else if (c19 != 4) {
                        AbstractC0246d.B0(parcel, i23);
                    } else {
                        strA8 = AbstractC0246d.A(parcel, i23);
                    }
                }
                AbstractC0246d.J(parcel, iM020);
                return new ApiFeatureRequest(arrayListE2, zL011, strA9, strA8);
            case 21:
                int iM021 = AbstractC0246d.M0(parcel);
                int iQ035 = 0;
                String strA10 = null;
                int iQ036 = 0;
                while (parcel.dataPosition() < iM021) {
                    int i24 = parcel.readInt();
                    char c20 = (char) i24;
                    if (c20 == 1) {
                        iQ035 = AbstractC0246d.q0(parcel, i24);
                    } else if (c20 == 2) {
                        strA10 = AbstractC0246d.A(parcel, i24);
                    } else if (c20 != 3) {
                        AbstractC0246d.B0(parcel, i24);
                    } else {
                        iQ036 = AbstractC0246d.q0(parcel, i24);
                    }
                }
                AbstractC0246d.J(parcel, iM021);
                return new FavaDiagnosticsEntity(iQ035, iQ036, strA10);
            case 22:
                int iM022 = AbstractC0246d.M0(parcel);
                StringToIntConverter stringToIntConverter = null;
                int iQ037 = 0;
                while (parcel.dataPosition() < iM022) {
                    int i25 = parcel.readInt();
                    char c21 = (char) i25;
                    if (c21 == 1) {
                        iQ037 = AbstractC0246d.q0(parcel, i25);
                    } else if (c21 != 2) {
                        AbstractC0246d.B0(parcel, i25);
                    } else {
                        stringToIntConverter = (StringToIntConverter) AbstractC0246d.x(parcel, i25, StringToIntConverter.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM022);
                return new zaa(iQ037, stringToIntConverter);
            case 23:
                int iM023 = AbstractC0246d.M0(parcel);
                ArrayList arrayListE3 = null;
                int iQ038 = 0;
                while (parcel.dataPosition() < iM023) {
                    int i26 = parcel.readInt();
                    char c22 = (char) i26;
                    if (c22 == 1) {
                        iQ038 = AbstractC0246d.q0(parcel, i26);
                    } else if (c22 != 2) {
                        AbstractC0246d.B0(parcel, i26);
                    } else {
                        arrayListE3 = AbstractC0246d.E(parcel, i26, zac.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM023);
                return new StringToIntConverter(iQ038, arrayListE3);
            case 24:
                int iM024 = AbstractC0246d.M0(parcel);
                int iQ039 = 0;
                String strA11 = null;
                int iQ040 = 0;
                while (parcel.dataPosition() < iM024) {
                    int i27 = parcel.readInt();
                    char c23 = (char) i27;
                    if (c23 == 1) {
                        iQ039 = AbstractC0246d.q0(parcel, i27);
                    } else if (c23 == 2) {
                        strA11 = AbstractC0246d.A(parcel, i27);
                    } else if (c23 != 3) {
                        AbstractC0246d.B0(parcel, i27);
                    } else {
                        iQ040 = AbstractC0246d.q0(parcel, i27);
                    }
                }
                AbstractC0246d.J(parcel, iM024);
                return new zac(iQ039, iQ040, strA11);
            case 25:
                int iM025 = AbstractC0246d.M0(parcel);
                Status status = null;
                while (parcel.dataPosition() < iM025) {
                    int i28 = parcel.readInt();
                    if (((char) i28) != 1) {
                        AbstractC0246d.B0(parcel, i28);
                    } else {
                        status = (Status) AbstractC0246d.x(parcel, i28, Status.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM025);
                return new zzaa(status);
            case 26:
                int iM026 = AbstractC0246d.M0(parcel);
                List listE = zzba.f2004l;
                LocationRequest locationRequest = null;
                String strA12 = null;
                String strA13 = null;
                String strA14 = null;
                boolean zL012 = false;
                boolean zL013 = false;
                boolean zL014 = false;
                boolean zL015 = false;
                boolean zL016 = false;
                long jR03 = Long.MAX_VALUE;
                while (parcel.dataPosition() < iM026) {
                    int i29 = parcel.readInt();
                    char c24 = (char) i29;
                    if (c24 != 1) {
                        switch (c24) {
                            case 5:
                                listE = AbstractC0246d.E(parcel, i29, ClientIdentity.CREATOR);
                                break;
                            case 6:
                                strA12 = AbstractC0246d.A(parcel, i29);
                                break;
                            case 7:
                                zL012 = AbstractC0246d.l0(parcel, i29);
                                break;
                            case '\b':
                                zL013 = AbstractC0246d.l0(parcel, i29);
                                break;
                            case '\t':
                                zL014 = AbstractC0246d.l0(parcel, i29);
                                break;
                            case '\n':
                                strA13 = AbstractC0246d.A(parcel, i29);
                                break;
                            case 11:
                                zL015 = AbstractC0246d.l0(parcel, i29);
                                break;
                            case '\f':
                                zL016 = AbstractC0246d.l0(parcel, i29);
                                break;
                            case '\r':
                                strA14 = AbstractC0246d.A(parcel, i29);
                                break;
                            case 14:
                                jR03 = AbstractC0246d.r0(parcel, i29);
                                break;
                            default:
                                AbstractC0246d.B0(parcel, i29);
                                break;
                        }
                    } else {
                        locationRequest = (LocationRequest) AbstractC0246d.x(parcel, i29, LocationRequest.CREATOR);
                    }
                }
                AbstractC0246d.J(parcel, iM026);
                return new zzba(locationRequest, listE, strA12, zL012, zL013, zL014, strA13, zL015, zL016, strA14, jR03);
            case 27:
                int iM027 = AbstractC0246d.M0(parcel);
                int iQ041 = 1;
                zzba zzbaVar = null;
                IBinder iBinderP03 = null;
                PendingIntent pendingIntent3 = null;
                IBinder iBinderP04 = null;
                IBinder iBinderP05 = null;
                while (parcel.dataPosition() < iM027) {
                    int i30 = parcel.readInt();
                    switch ((char) i30) {
                        case 1:
                            iQ041 = AbstractC0246d.q0(parcel, i30);
                            break;
                        case 2:
                            zzbaVar = (zzba) AbstractC0246d.x(parcel, i30, zzba.CREATOR);
                            break;
                        case 3:
                            iBinderP03 = AbstractC0246d.p0(parcel, i30);
                            break;
                        case 4:
                            pendingIntent3 = (PendingIntent) AbstractC0246d.x(parcel, i30, PendingIntent.CREATOR);
                            break;
                        case 5:
                            iBinderP04 = AbstractC0246d.p0(parcel, i30);
                            break;
                        case 6:
                            iBinderP05 = AbstractC0246d.p0(parcel, i30);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i30);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM027);
                return new zzbc(iQ041, zzbaVar, iBinderP03, pendingIntent3, iBinderP04, iBinderP05);
            case 28:
                int iM028 = AbstractC0246d.M0(parcel);
                String strA15 = null;
                int iQ042 = 0;
                short s3 = 0;
                int iQ043 = 0;
                double d = 0.0d;
                double d6 = 0.0d;
                float fN0 = 0.0f;
                long jR04 = 0;
                int iQ044 = -1;
                while (parcel.dataPosition() < iM028) {
                    int i31 = parcel.readInt();
                    switch ((char) i31) {
                        case 1:
                            strA15 = AbstractC0246d.A(parcel, i31);
                            break;
                        case 2:
                            jR04 = AbstractC0246d.r0(parcel, i31);
                            break;
                        case 3:
                            AbstractC0246d.P0(parcel, i31, 4);
                            s3 = (short) parcel.readInt();
                            break;
                        case 4:
                            AbstractC0246d.P0(parcel, i31, 8);
                            d = parcel.readDouble();
                            break;
                        case 5:
                            AbstractC0246d.P0(parcel, i31, 8);
                            d6 = parcel.readDouble();
                            break;
                        case 6:
                            fN0 = AbstractC0246d.n0(parcel, i31);
                            break;
                        case 7:
                            iQ042 = AbstractC0246d.q0(parcel, i31);
                            break;
                        case '\b':
                            iQ043 = AbstractC0246d.q0(parcel, i31);
                            break;
                        case '\t':
                            iQ044 = AbstractC0246d.q0(parcel, i31);
                            break;
                        default:
                            AbstractC0246d.B0(parcel, i31);
                            break;
                    }
                }
                AbstractC0246d.J(parcel, iM028);
                return new zzbe(strA15, iQ042, s3, d, d6, fN0, jR04, iQ043, iQ044);
            default:
                int iM029 = AbstractC0246d.M0(parcel);
                zzs zzsVar = zzj.e;
                List listE2 = zzj.d;
                String strA16 = null;
                while (parcel.dataPosition() < iM029) {
                    int i32 = parcel.readInt();
                    char c25 = (char) i32;
                    if (c25 == 1) {
                        zzsVar = (zzs) AbstractC0246d.x(parcel, i32, zzs.CREATOR);
                    } else if (c25 == 2) {
                        listE2 = AbstractC0246d.E(parcel, i32, ClientIdentity.CREATOR);
                    } else if (c25 != 3) {
                        AbstractC0246d.B0(parcel, i32);
                    } else {
                        strA16 = AbstractC0246d.A(parcel, i32);
                    }
                }
                AbstractC0246d.J(parcel, iM029);
                return new zzj(zzsVar, listE2, strA16);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f2a) {
            case 0:
                return new Scope[i];
            case 1:
                return new Status[i];
            case 2:
                return new BitmapTeleporter[i];
            case 3:
                return new DataHolder[i];
            case 4:
                return new ClientIdentity[i];
            case 5:
                return new TelemetryData[i];
            case 6:
                return new MethodInvocation[i];
            case 7:
                return new zat[i];
            case 8:
                return new zav[i];
            case 9:
                return new zax[i];
            case 10:
                return new RootTelemetryConfiguration[i];
            case 11:
                return new zzak[i];
            case 12:
                return new BinderWrapper[i];
            case 13:
                return new zzk[i];
            case 14:
                return new ConnectionTelemetryConfiguration[i];
            case 15:
                return new GetServiceRequest[i];
            case 16:
                return new ModuleAvailabilityResponse[i];
            case 17:
                return new ModuleInstallIntentResponse[i];
            case 18:
                return new ModuleInstallResponse[i];
            case 19:
                return new ModuleInstallStatusUpdate[i];
            case 20:
                return new ApiFeatureRequest[i];
            case 21:
                return new FavaDiagnosticsEntity[i];
            case 22:
                return new zaa[i];
            case 23:
                return new StringToIntConverter[i];
            case 24:
                return new zac[i];
            case 25:
                return new zzaa[i];
            case 26:
                return new zzba[i];
            case 27:
                return new zzbc[i];
            case 28:
                return new zzbe[i];
            default:
                return new zzj[i];
        }
    }
}
