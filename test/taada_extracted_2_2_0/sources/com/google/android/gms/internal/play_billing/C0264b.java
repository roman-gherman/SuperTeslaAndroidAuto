package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0264b extends P.a implements zzan {
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zza(int i, String str, String str2) {
        Parcel parcelB = b();
        parcelB.writeInt(3);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        Parcel parcelC = c(parcelB, 5);
        int i3 = parcelC.readInt();
        parcelC.recycle();
        return i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zzc(int i, String str, String str2, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 10);
        int i4 = parcelC.readInt();
        parcelC.recycle();
        return i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(9);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, TypedValues.Custom.TYPE_COLOR);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zze(int i, String str, String str2, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(9);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 12);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) {
        Parcel parcelB = b();
        parcelB.writeInt(3);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        parcelB.writeString(null);
        Parcel parcelC = c(parcelB, 3);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        parcelB.writeString(null);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 8);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(6);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 9);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzi(int i, String str, String str2, String str3) {
        Parcel parcelB = b();
        parcelB.writeInt(3);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        Parcel parcelC = c(parcelB, 4);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 11);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzk(int i, String str, String str2, Bundle bundle) {
        Parcel parcelB = b();
        parcelB.writeInt(3);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, 2);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzl(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeInt(1);
        bundle2.writeToParcel(parcelB, 0);
        Parcel parcelC = c(parcelB, TypedValues.Custom.TYPE_FLOAT);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle3 = (Bundle) AbstractC0270d.a(parcelC);
        parcelC.recycle();
        return bundle3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzm(int i, String str, Bundle bundle, zzy zzyVar) {
        Parcel parcelB = b();
        parcelB.writeInt(21);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzyVar);
        e(parcelB, 1501);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzn(int i, String str, Bundle bundle, zzaa zzaaVar) {
        Parcel parcelB = b();
        parcelB.writeInt(22);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzaaVar);
        e(parcelB, 1801);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzo(int i, String str, Bundle bundle, zzac zzacVar) {
        Parcel parcelB = b();
        parcelB.writeInt(21);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzacVar);
        e(parcelB, 1601);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzp(int i, String str, Bundle bundle, zzae zzaeVar) {
        Parcel parcelB = b();
        parcelB.writeInt(18);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzaeVar);
        d(parcelB, 1301);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzq(int i, String str, Bundle bundle, zzag zzagVar) {
        Parcel parcelB = b();
        parcelB.writeInt(22);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzagVar);
        e(parcelB, 1901);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzr(int i, String str, Bundle bundle, zzai zzaiVar) {
        Parcel parcelB = b();
        parcelB.writeInt(21);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzaiVar);
        e(parcelB, 1401);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzs(int i, String str, Bundle bundle, zzak zzakVar) {
        Parcel parcelB = b();
        parcelB.writeInt(22);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzakVar);
        e(parcelB, 1701);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzt(int i, String str, Bundle bundle, zzap zzapVar) {
        Parcel parcelB = b();
        parcelB.writeInt(12);
        parcelB.writeString(str);
        int i3 = AbstractC0270d.f2074a;
        parcelB.writeInt(1);
        bundle.writeToParcel(parcelB, 0);
        parcelB.writeStrongBinder(zzapVar);
        d(parcelB, 1201);
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zzy(int i, String str, String str2) {
        Parcel parcelB = b();
        parcelB.writeInt(i);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        Parcel parcelC = c(parcelB, 1);
        int i3 = parcelC.readInt();
        parcelC.recycle();
        return i3;
    }
}
