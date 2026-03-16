package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface BillingClient$FeatureType {
    public static final String ALTERNATIVE_BILLING_ONLY = "jjj";
    public static final String BILLING_CONFIG = "ggg";
    public static final String EXTERNAL_OFFER = "kkk";
    public static final String IN_APP_MESSAGING = "bbb";
    public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
    public static final String PRODUCT_DETAILS = "fff";
    public static final String SUBSCRIPTIONS = "subscriptions";
    public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";
}
