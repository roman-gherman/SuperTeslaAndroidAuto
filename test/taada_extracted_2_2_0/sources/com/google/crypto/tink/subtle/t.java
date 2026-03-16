package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class t extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.A f2968a;

    public t(com.android.billingclient.api.A a6) {
        this.f2968a = a6;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        com.android.billingclient.api.A a6 = this.f2968a;
        try {
            p pVar = p.c;
            Mac mac = (Mac) pVar.f2966a.getInstance((String) a6.c);
            mac.init((SecretKeySpec) a6.d);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
