package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface IStatusCallback extends IInterface {
    void onResult(Status status);
}
