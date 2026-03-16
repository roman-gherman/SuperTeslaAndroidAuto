package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f2805a = new n();

    public static void a(n nVar) throws GeneralSecurityException {
        if (nVar == null) {
            throw new GeneralSecurityException("SecretKeyAccess is required");
        }
    }
}
