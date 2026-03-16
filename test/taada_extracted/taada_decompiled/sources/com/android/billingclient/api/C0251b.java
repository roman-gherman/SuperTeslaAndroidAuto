package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import fr.sd.taada.billing.BillingManager;

/* JADX INFO: renamed from: com.android.billingclient.api.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0251b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile n0.d f1825a;
    public final Context b;
    public volatile BillingManager c;

    public /* synthetic */ C0251b(Context context) {
        this.b = context;
    }

    public final boolean a() {
        Context context = this.b;
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
        } catch (Exception e) {
            AbstractC0289j0.g("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
            return false;
        }
    }
}
