package c2;

import com.google.crypto.tink.subtle.p;
import java.security.GeneralSecurityException;
import java.util.Random;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1743a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f1743a) {
            case 0:
                return new Random();
            case 1:
                try {
                    return (Cipher) p.b.a("AES/GCM/NoPadding");
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            default:
                try {
                    return (Cipher) p.b.a("AES/GCM-SIV/NoPadding");
                } catch (GeneralSecurityException e6) {
                    throw new IllegalStateException(e6);
                }
        }
    }
}
