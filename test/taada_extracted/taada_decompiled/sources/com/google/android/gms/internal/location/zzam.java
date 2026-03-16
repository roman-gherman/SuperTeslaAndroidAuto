package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzbq;

/* JADX INFO: loaded from: classes.dex */
public interface zzam extends IInterface {
    void zzd(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzak zzakVar);

    void zze(PendingIntent pendingIntent, zzak zzakVar, String str);

    void zzf(String[] strArr, zzak zzakVar, String str);

    void zzg(zzbq zzbqVar, zzak zzakVar);

    void zzh(long j6, boolean z6, PendingIntent pendingIntent);

    void zzi(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzj(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzk(PendingIntent pendingIntent);

    void zzl(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    @Deprecated
    Location zzm();

    Location zzn(String str);

    void zzo(zzbc zzbcVar);

    void zzp(boolean z6);

    void zzq(Location location);

    void zzr(zzai zzaiVar);

    LocationAvailability zzs(String str);

    void zzt(LocationSettingsRequest locationSettingsRequest, zzao zzaoVar, String str);

    void zzu(zzl zzlVar);

    void zzv(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback);
}
