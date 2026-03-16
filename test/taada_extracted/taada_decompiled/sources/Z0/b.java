package z0;

import C0.g;
import C0.h;
import C0.j;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.l;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.subtle.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements DeterministicAead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f5168a;
    public final MonitoringClient.Logger b;
    public final MonitoringClient.Logger c;

    public b(l lVar) {
        this.f5168a = lVar;
        if (lVar.c.f344a.isEmpty()) {
            g gVar = h.f144a;
            this.b = gVar;
            this.c = gVar;
        } else {
            MonitoringClient monitoringClient = (MonitoringClient) j.b.f145a.get();
            monitoringClient = monitoringClient == null ? j.c : monitoringClient;
            F0.c cVarA = h.a(lVar);
            this.b = monitoringClient.createLogger(cVarA, "daead", "encrypt");
            this.c = monitoringClient.createLogger(cVarA, "daead", "decrypt");
        }
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        l lVar = this.f5168a;
        MonitoringClient.Logger logger = this.c;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (com.google.crypto.tink.j jVar : lVar.a(bArrCopyOf)) {
                try {
                    byte[] bArrDecryptDeterministically = ((DeterministicAead) jVar.b).decryptDeterministically(bArrCopyOfRange, bArr2);
                    logger.log(jVar.f2799f, bArrCopyOfRange.length);
                    return bArrDecryptDeterministically;
                } catch (GeneralSecurityException e) {
                    c.f5169a.info("ciphertext prefix matches a key, but cannot decrypt: " + e);
                }
            }
        }
        for (com.google.crypto.tink.j jVar2 : lVar.a(com.google.crypto.tink.a.f2791a)) {
            try {
                byte[] bArrDecryptDeterministically2 = ((DeterministicAead) jVar2.b).decryptDeterministically(bArr, bArr2);
                logger.log(jVar2.f2799f, bArr.length);
                return bArrDecryptDeterministically2;
            } catch (GeneralSecurityException unused) {
            }
        }
        logger.logFailure();
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        MonitoringClient.Logger logger = this.b;
        l lVar = this.f5168a;
        try {
            byte[] bArr3 = lVar.b.c;
            byte[] bArrB = q.b(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((DeterministicAead) lVar.b.b).encryptDeterministically(bArr, bArr2));
            logger.log(lVar.b.f2799f, bArr.length);
            return bArrB;
        } catch (GeneralSecurityException e) {
            logger.logFailure();
            throw e;
        }
    }
}
