package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f2797a = new CopyOnWriteArrayList();

    public static KmsClient a(String str) throws GeneralSecurityException {
        for (KmsClient kmsClient : f2797a) {
            if (kmsClient.doesSupport(str)) {
                return kmsClient;
            }
        }
        throw new GeneralSecurityException(androidx.constraintlayout.core.motion.a.p("No KMS client does support: ", str));
    }
}
