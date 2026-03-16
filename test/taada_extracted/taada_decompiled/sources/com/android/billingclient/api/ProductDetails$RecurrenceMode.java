package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ProductDetails$RecurrenceMode {
    public static final int FINITE_RECURRING = 2;
    public static final int INFINITE_RECURRING = 1;
    public static final int NON_RECURRING = 3;
}
