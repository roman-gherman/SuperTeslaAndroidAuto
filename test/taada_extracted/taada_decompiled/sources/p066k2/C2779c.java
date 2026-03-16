package p066k2;

import fr.sd.taada.helpers.LogManager;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
final class C2779c implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        LogManager.getInstance(null).logDebug("NaiveTrustManager", "Check client: " + Arrays.toString(x509CertificateArr));
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
