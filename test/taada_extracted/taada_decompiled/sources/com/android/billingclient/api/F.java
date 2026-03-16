package com.android.billingclient.api;

import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class F implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (((C0255f) obj) == null) {
            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
        }
    }
}
