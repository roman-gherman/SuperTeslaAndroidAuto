package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0257h f1806a;
    public static final C0257h b;
    public static final C0257h c;
    public static final C0257h d;
    public static final C0257h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0257h f1807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0257h f1808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0257h f1809h;
    public static final C0257h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0257h f1810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0257h f1811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0257h f1812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0257h f1813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0257h f1814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0257h f1815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0257h f1816p;
    public static final C0257h q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0257h f1817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0257h f1818s;

    static {
        Z3.b bVarA = C0257h.a();
        bVarA.f1505a = 3;
        bVarA.b = "Google Play In-app Billing API version is less than 3";
        f1806a = bVarA.a();
        Z3.b bVarA2 = C0257h.a();
        bVarA2.f1505a = 3;
        bVarA2.b = "Google Play In-app Billing API version is less than 9";
        b = bVarA2.a();
        Z3.b bVarA3 = C0257h.a();
        bVarA3.f1505a = 3;
        bVarA3.b = "Billing service unavailable on device.";
        c = bVarA3.a();
        Z3.b bVarA4 = C0257h.a();
        bVarA4.f1505a = 2;
        bVarA4.b = "Billing service unavailable on device.";
        d = bVarA4.a();
        Z3.b bVarA5 = C0257h.a();
        bVarA5.f1505a = 5;
        bVarA5.b = "Client is already in the process of connecting to billing service.";
        e = bVarA5.a();
        Z3.b bVarA6 = C0257h.a();
        bVarA6.f1505a = 5;
        bVarA6.b = "The list of SKUs can't be empty.";
        bVarA6.a();
        Z3.b bVarA7 = C0257h.a();
        bVarA7.f1505a = 5;
        bVarA7.b = "SKU type can't be empty.";
        bVarA7.a();
        Z3.b bVarA8 = C0257h.a();
        bVarA8.f1505a = 5;
        bVarA8.b = "Product type can't be empty.";
        f1807f = bVarA8.a();
        Z3.b bVarA9 = C0257h.a();
        bVarA9.f1505a = -2;
        bVarA9.b = "Client does not support extra params.";
        f1808g = bVarA9.a();
        Z3.b bVarA10 = C0257h.a();
        bVarA10.f1505a = 5;
        bVarA10.b = "Invalid purchase token.";
        f1809h = bVarA10.a();
        Z3.b bVarA11 = C0257h.a();
        bVarA11.f1505a = 6;
        bVarA11.b = "An internal error occurred.";
        i = bVarA11.a();
        Z3.b bVarA12 = C0257h.a();
        bVarA12.f1505a = 5;
        bVarA12.b = "SKU can't be null.";
        bVarA12.a();
        Z3.b bVarA13 = C0257h.a();
        bVarA13.f1505a = 0;
        f1810j = bVarA13.a();
        Z3.b bVarA14 = C0257h.a();
        bVarA14.f1505a = -1;
        bVarA14.b = "Service connection is disconnected.";
        f1811k = bVarA14.a();
        Z3.b bVarA15 = C0257h.a();
        bVarA15.f1505a = 2;
        bVarA15.b = "Timeout communicating with service.";
        f1812l = bVarA15.a();
        Z3.b bVarA16 = C0257h.a();
        bVarA16.f1505a = -2;
        bVarA16.b = "Client does not support subscriptions.";
        f1813m = bVarA16.a();
        Z3.b bVarA17 = C0257h.a();
        bVarA17.f1505a = -2;
        bVarA17.b = "Client does not support subscriptions update.";
        bVarA17.a();
        Z3.b bVarA18 = C0257h.a();
        bVarA18.f1505a = -2;
        bVarA18.b = "Client does not support get purchase history.";
        bVarA18.a();
        Z3.b bVarA19 = C0257h.a();
        bVarA19.f1505a = -2;
        bVarA19.b = "Client does not support price change confirmation.";
        bVarA19.a();
        Z3.b bVarA20 = C0257h.a();
        bVarA20.f1505a = -2;
        bVarA20.b = "Play Store version installed does not support cross selling products.";
        bVarA20.a();
        Z3.b bVarA21 = C0257h.a();
        bVarA21.f1505a = -2;
        bVarA21.b = "Client does not support multi-item purchases.";
        f1814n = bVarA21.a();
        Z3.b bVarA22 = C0257h.a();
        bVarA22.f1505a = -2;
        bVarA22.b = "Client does not support offer_id_token.";
        f1815o = bVarA22.a();
        Z3.b bVarA23 = C0257h.a();
        bVarA23.f1505a = -2;
        bVarA23.b = "Client does not support ProductDetails.";
        f1816p = bVarA23.a();
        Z3.b bVarA24 = C0257h.a();
        bVarA24.f1505a = -2;
        bVarA24.b = "Client does not support in-app messages.";
        bVarA24.a();
        Z3.b bVarA25 = C0257h.a();
        bVarA25.f1505a = -2;
        bVarA25.b = "Client does not support user choice billing.";
        bVarA25.a();
        Z3.b bVarA26 = C0257h.a();
        bVarA26.f1505a = -2;
        bVarA26.b = "Play Store version installed does not support external offer.";
        bVarA26.a();
        Z3.b bVarA27 = C0257h.a();
        bVarA27.f1505a = -2;
        bVarA27.b = "Play Store version installed does not support multi-item purchases with season pass in one cart.";
        bVarA27.a();
        Z3.b bVarA28 = C0257h.a();
        bVarA28.f1505a = 5;
        bVarA28.b = "Unknown feature";
        bVarA28.a();
        Z3.b bVarA29 = C0257h.a();
        bVarA29.f1505a = -2;
        bVarA29.b = "Play Store version installed does not support get billing config.";
        bVarA29.a();
        Z3.b bVarA30 = C0257h.a();
        bVarA30.f1505a = -2;
        bVarA30.b = "Query product details with serialized docid is not supported.";
        bVarA30.a();
        Z3.b bVarA31 = C0257h.a();
        bVarA31.f1505a = 4;
        bVarA31.b = "Item is unavailable for purchase.";
        q = bVarA31.a();
        Z3.b bVarA32 = C0257h.a();
        bVarA32.f1505a = -2;
        bVarA32.b = "Query product details with developer specified account is not supported.";
        bVarA32.a();
        Z3.b bVarA33 = C0257h.a();
        bVarA33.f1505a = -2;
        bVarA33.b = "Play Store version installed does not support alternative billing only.";
        bVarA33.a();
        Z3.b bVarA34 = C0257h.a();
        bVarA34.f1505a = 5;
        bVarA34.b = "To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.";
        f1817r = bVarA34.a();
        Z3.b bVarA35 = C0257h.a();
        bVarA35.f1505a = 6;
        bVarA35.b = "An error occurred while retrieving billing override.";
        f1818s = bVarA35.a();
    }

    public static C0257h a(int i3, String str) {
        Z3.b bVarA = C0257h.a();
        bVarA.f1505a = i3;
        bVarA.b = str;
        return bVarA.a();
    }
}
