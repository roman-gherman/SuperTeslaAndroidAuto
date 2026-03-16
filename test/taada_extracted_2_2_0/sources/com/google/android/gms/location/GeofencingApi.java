package com.google.android.gms.location;

import android.app.PendingIntent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface GeofencingApi {
    A.e addGeofences(A.d dVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent);

    @Deprecated
    A.e addGeofences(A.d dVar, List<Geofence> list, PendingIntent pendingIntent);

    A.e removeGeofences(A.d dVar, PendingIntent pendingIntent);

    A.e removeGeofences(A.d dVar, List<String> list);
}
