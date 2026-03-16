package com.google.android.gms.common.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface BaseGmsClient$BaseConnectionCallbacks {
    public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);
}
