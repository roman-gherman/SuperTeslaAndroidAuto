package B0;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.C;
import com.google.crypto.tink.subtle.v;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes.dex */
public final class d implements KmsClient {
    public static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KeyStore f120a;

    public d() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f120a = keyStore;
        } catch (IOException | GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public static boolean a(String str) {
        d dVar = new d();
        synchronized (b) {
            try {
                if (dVar.c(str)) {
                    return false;
                }
                b(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        String strB = C.b(str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strB, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    public final synchronized boolean c(String str) {
        String strB;
        strB = C.b(str);
        try {
        } catch (NullPointerException unused) {
            Log.w("d", "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f120a = keyStore;
                keyStore.load(null);
                return this.f120a.containsAlias(strB);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        }
        return this.f120a.containsAlias(strB);
    }

    @Override // com.google.crypto.tink.KmsClient
    public final synchronized boolean doesSupport(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    @Override // com.google.crypto.tink.KmsClient
    public final synchronized Aead getAead(String str) {
        c cVar;
        cVar = new c(C.b(str), this.f120a);
        byte[] bArrA = v.a(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(bArrA, cVar.decrypt(cVar.encrypt(bArrA, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return cVar;
    }

    @Override // com.google.crypto.tink.KmsClient
    public final KmsClient withCredentials(String str) {
        return new d();
    }

    @Override // com.google.crypto.tink.KmsClient
    public final KmsClient withDefaultCredentials() {
        return new d();
    }
}
