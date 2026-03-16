package com.android.billingclient.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.android.gms.internal.play_billing.A f1854a;

    public /* synthetic */ o(o oVar) {
        this.f1854a = oVar.f1854a;
    }

    public void a(List list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty.");
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (!"play_pass_subs".equals(pVar.b)) {
                hashSet.add(pVar.b);
            }
        }
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("All products should be of the same product type.");
        }
        this.f1854a = com.google.android.gms.internal.play_billing.A.j(list);
    }
}
