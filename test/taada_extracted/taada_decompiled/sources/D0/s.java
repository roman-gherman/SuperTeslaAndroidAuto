package D0;

import G0.A1;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Mac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.crypto.tink.l f246a;
    public final MonitoringClient.Logger b;
    public final MonitoringClient.Logger c;

    public s(com.google.crypto.tink.l lVar) {
        this.f246a = lVar;
        if (lVar.c.f344a.isEmpty()) {
            C0.g gVar = C0.h.f144a;
            this.b = gVar;
            this.c = gVar;
        } else {
            MonitoringClient monitoringClient = (MonitoringClient) C0.j.b.f145a.get();
            monitoringClient = monitoringClient == null ? C0.j.c : monitoringClient;
            F0.c cVarA = C0.h.a(lVar);
            this.b = monitoringClient.createLogger(cVarA, "mac", "compute");
            this.c = monitoringClient.createLogger(cVarA, "mac", "verify");
        }
    }

    @Override // com.google.crypto.tink.Mac
    public final byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        MonitoringClient.Logger logger = this.b;
        com.google.crypto.tink.l lVar = this.f246a;
        if (lVar.b.e.equals(A1.LEGACY)) {
            bArr = com.google.crypto.tink.subtle.q.b(bArr, t.b);
        }
        try {
            byte[] bArr2 = lVar.b.c;
            byte[] bArrB = com.google.crypto.tink.subtle.q.b(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length), ((Mac) lVar.b.b).computeMac(bArr));
            logger.log(lVar.b.f2799f, bArr.length);
            return bArrB;
        } catch (GeneralSecurityException e) {
            logger.logFailure();
            throw e;
        }
    }

    @Override // com.google.crypto.tink.Mac
    public final void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        MonitoringClient.Logger logger = this.c;
        if (length <= 5) {
            logger.logFailure();
            throw new GeneralSecurityException("tag too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
        com.google.crypto.tink.l lVar = this.f246a;
        for (com.google.crypto.tink.j jVar : lVar.a(bArrCopyOf)) {
            try {
                ((Mac) jVar.b).verifyMac(bArrCopyOfRange, jVar.e.equals(A1.LEGACY) ? com.google.crypto.tink.subtle.q.b(bArr2, t.b) : bArr2);
                logger.log(jVar.f2799f, r5.length);
                return;
            } catch (GeneralSecurityException e) {
                t.f247a.info("tag prefix matches a key, but cannot verify: " + e);
            }
        }
        for (com.google.crypto.tink.j jVar2 : lVar.a(com.google.crypto.tink.a.f2791a)) {
            try {
                ((Mac) jVar2.b).verifyMac(bArr, bArr2);
                logger.log(jVar2.f2799f, bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        logger.logFailure();
        throw new GeneralSecurityException("invalid MAC");
    }
}
