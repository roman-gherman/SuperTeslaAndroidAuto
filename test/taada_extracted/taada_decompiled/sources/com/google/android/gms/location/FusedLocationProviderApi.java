package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface FusedLocationProviderApi {

    @Deprecated
    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    public static final String KEY_MOCK_LOCATION = "mockLocation";

    A.e flushLocations(A.d dVar);

    Location getLastLocation(A.d dVar);

    LocationAvailability getLocationAvailability(A.d dVar);

    A.e removeLocationUpdates(A.d dVar, PendingIntent pendingIntent);

    A.e removeLocationUpdates(A.d dVar, LocationListener locationListener);

    A.e removeLocationUpdates(A.d dVar, a aVar);

    A.e requestLocationUpdates(A.d dVar, LocationRequest locationRequest, PendingIntent pendingIntent);

    A.e requestLocationUpdates(A.d dVar, LocationRequest locationRequest, LocationListener locationListener);

    A.e requestLocationUpdates(A.d dVar, LocationRequest locationRequest, LocationListener locationListener, Looper looper);

    A.e requestLocationUpdates(A.d dVar, LocationRequest locationRequest, a aVar, Looper looper);

    A.e setMockLocation(A.d dVar, Location location);

    A.e setMockMode(A.d dVar, boolean z6);
}
