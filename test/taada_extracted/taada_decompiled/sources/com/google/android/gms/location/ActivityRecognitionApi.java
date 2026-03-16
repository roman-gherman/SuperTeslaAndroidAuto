package com.google.android.gms.location;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ActivityRecognitionApi {
    A.e removeActivityUpdates(A.d dVar, PendingIntent pendingIntent);

    A.e requestActivityUpdates(A.d dVar, long j6, PendingIntent pendingIntent);
}
