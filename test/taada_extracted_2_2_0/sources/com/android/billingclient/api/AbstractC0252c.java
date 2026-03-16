package com.android.billingclient.api;

import android.app.Activity;
import fr.sd.taada.billing.BillingManager;

/* JADX INFO: renamed from: com.android.billingclient.api.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0252c {
    public abstract void a(E1.h hVar, R0.d dVar);

    public abstract void b();

    public abstract boolean c();

    public abstract C0257h d(Activity activity, C0256g c0256g);

    public abstract void e(o oVar, ProductDetailsResponseListener productDetailsResponseListener);

    public abstract void f(E1.h hVar, PurchasesResponseListener purchasesResponseListener);

    public abstract void g(BillingManager billingManager);
}
