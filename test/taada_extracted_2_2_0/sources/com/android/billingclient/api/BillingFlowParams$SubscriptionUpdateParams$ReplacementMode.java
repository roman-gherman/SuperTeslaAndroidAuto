package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface BillingFlowParams$SubscriptionUpdateParams$ReplacementMode {
    public static final int CHARGE_FULL_PRICE = 5;
    public static final int CHARGE_PRORATED_PRICE = 2;
    public static final int DEFERRED = 6;
    public static final int UNKNOWN_REPLACEMENT_MODE = 0;
    public static final int WITHOUT_PRORATION = 3;
    public static final int WITH_TIME_PRORATION = 1;
}
