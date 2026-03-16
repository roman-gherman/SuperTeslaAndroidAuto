package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2953a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f2953a) {
            case 0:
                try {
                    return (Cipher) p.b.f2966a.getInstance("AES/CTR/NoPadding");
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            case 1:
                try {
                    return (Cipher) p.b.f2966a.getInstance("AES/ECB/NOPADDING");
                } catch (GeneralSecurityException e6) {
                    throw new IllegalStateException(e6);
                }
            case 2:
                try {
                    return (Cipher) p.b.f2966a.getInstance("AES/CTR/NOPADDING");
                } catch (GeneralSecurityException e7) {
                    throw new IllegalStateException(e7);
                }
            default:
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextLong();
                return secureRandom;
        }
    }
}
