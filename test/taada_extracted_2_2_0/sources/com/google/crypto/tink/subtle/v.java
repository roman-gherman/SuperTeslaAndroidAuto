package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2970a = new d(3);

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f2970a.get()).nextBytes(bArr);
        return bArr;
    }
}
