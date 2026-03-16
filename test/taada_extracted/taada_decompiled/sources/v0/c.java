package v0;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Aead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.crypto.tink.l f4894a;
    public final MonitoringClient.Logger b;
    public final MonitoringClient.Logger c;

    public c(com.google.crypto.tink.l lVar) {
        this.f4894a = lVar;
        if (lVar.c.f344a.isEmpty()) {
            C0.g gVar = C0.h.f144a;
            this.b = gVar;
            this.c = gVar;
        } else {
            MonitoringClient monitoringClient = (MonitoringClient) C0.j.b.f145a.get();
            monitoringClient = monitoringClient == null ? C0.j.c : monitoringClient;
            F0.c cVarA = C0.h.a(lVar);
            this.b = monitoringClient.createLogger(cVarA, "aead", "encrypt");
            this.c = monitoringClient.createLogger(cVarA, "aead", "decrypt");
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        com.google.crypto.tink.l lVar = this.f4894a;
        MonitoringClient.Logger logger = this.c;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (com.google.crypto.tink.j jVar : lVar.a(bArrCopyOf)) {
                try {
                    byte[] bArrDecrypt = ((Aead) jVar.b).decrypt(bArrCopyOfRange, bArr2);
                    logger.log(jVar.f2799f, bArrCopyOfRange.length);
                    return bArrDecrypt;
                } catch (GeneralSecurityException e) {
                    d.f4895a.info("ciphertext prefix matches a key, but cannot decrypt: " + e);
                }
            }
        }
        for (com.google.crypto.tink.j jVar2 : lVar.a(com.google.crypto.tink.a.f2791a)) {
            try {
                byte[] bArrDecrypt2 = ((Aead) jVar2.b).decrypt(bArr, bArr2);
                logger.log(jVar2.f2799f, bArr.length);
                return bArrDecrypt2;
            } catch (GeneralSecurityException unused) {
            }
        }
        logger.logFailure();
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        MonitoringClient.Logger logger = this.b;
        com.google.crypto.tink.l lVar = this.f4894a;
        try {
            byte[] bArr3 = lVar.b.c;
            byte[] bArrB = com.google.crypto.tink.subtle.q.b(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((Aead) lVar.b.b).encrypt(bArr, bArr2));
            logger.log(lVar.b.f2799f, bArr.length);
            return bArrB;
        } catch (GeneralSecurityException e) {
            logger.logFailure();
            throw e;
        }
    }
}
