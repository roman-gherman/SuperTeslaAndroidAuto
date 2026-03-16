package p066k2;

import android.content.Context;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class SSLHelper {
    private static final String KEYSTORE_TYPE_PKCS12 = "PKCS12";

    public static SSLContext createSSLContext(Context context, int i, String str) {
        logSecurityProviders(context);
        InputStream certificateInputStream = getCertificateInputStream(context, i);
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE_PKCS12);
            keyStore.load(certificateInputStream, str.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "aa".toCharArray());
            LogManager.getInstance(context).logDebug("SSL", "Before creating ssl context");
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            LogManager.getInstance(context).logDebug("SSL", "After creating ssl context");
            sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{new C2779c()}, new SecureRandom());
            LogManager.getInstance(context).logDebug("SSL", "After init");
            return sSLContext;
        } finally {
            certificateInputStream.close();
        }
    }

    public static SSLEngine createSSLEngine(Context context, int i, String str) throws IOException {
        InputStream certificateInputStream = getCertificateInputStream(context, i);
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE_PKCS12);
            keyStore.load(certificateInputStream, str.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "aa".toCharArray());
            LogManager.getInstance(context).logDebug("SSL", "Before creating ssl context");
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            LogManager.getInstance(context).logDebug("SSL", "After creating ssl context");
            sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{new C2779c()}, new SecureRandom());
            LogManager.getInstance(context).logDebug("SSL", "After init");
            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine();
            LogManager.getInstance(context).logDebug("SSL", "After create engine");
            try {
                sSLEngineCreateSSLEngine.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
                LogManager.getInstance(context).logDebug("SSL", "✅ Enabled protocols: TLSv1.3, TLSv1.2");
            } catch (Exception e) {
                LogManager.getInstance(context).logWarning("SSL", "TLSv1.3 not available, using TLSv1.2 only: " + e.getMessage());
                sSLEngineCreateSSLEngine.setEnabledProtocols(new String[]{"TLSv1.2"});
                LogManager.getInstance(context).logDebug("SSL", "✅ Enabled protocols: TLSv1.2 (fallback)");
            }
            LogManager.getInstance(context).logDebug("SSL", "After enable protocol");
            sSLEngineCreateSSLEngine.setNeedClientAuth(true);
            return sSLEngineCreateSSLEngine;
        } finally {
            certificateInputStream.close();
        }
    }

    private static InputStream getCertificateInputStream(Context context, int i) {
        if (i == R.raw.server_pbe) {
            try {
                File file = new File(context.getFilesDir(), "dynamic-server-cert.p12");
                if (file.exists()) {
                    LogManager.getInstance(context).logDebug("SSL", "Using dynamic certificate from " + file.getAbsolutePath());
                    return new FileInputStream(file);
                }
            } catch (Exception e) {
                LogManager.getInstance(context).logError("SSL", "Error checking for dynamic certificate, falling back to resource", e);
            }
        }
        LogManager.getInstance(context).logDebug("SSL", "Using default certificate from resources (ID: " + i + ")");
        return context.getResources().openRawResource(i);
    }

    public static void logSecurityProviders(Context context) {
        try {
            LogManager.getInstance(context).logDebug("SSL", "=== Security Providers Diagnostic ===");
            for (Provider provider : Security.getProviders()) {
                LogManager.getInstance(context).logDebug("SSL", "Provider: " + provider.getName() + " v" + provider.getVersion());
                if (provider.getService("KeyStore", KEYSTORE_TYPE_PKCS12) != null) {
                    LogManager.getInstance(context).logDebug("SSL", "  ✅ Supports PKCS12");
                    testCertificateLoading(context, provider.getName(), provider.getName());
                } else {
                    LogManager.getInstance(context).logDebug("SSL", "  ❌ No PKCS12 support");
                }
            }
        } catch (Exception e) {
            LogManager.getInstance(context).logError("SSL", "Error in security providers diagnostic: " + e.getMessage());
        }
    }

    private static void testCertificateLoading(Context context, String str, String str2) {
        LogManager logManager;
        StringBuilder sb;
        KeyStore keyStore;
        InputStream inputStreamOpenRawResource = null;
        try {
            try {
                try {
                    try {
                        try {
                            if (str != null) {
                                keyStore = KeyStore.getInstance(KEYSTORE_TYPE_PKCS12, str);
                                LogManager.getInstance(context).logDebug("SSL", "✅ KeyStore created with " + str2 + " provider (forced provider)");
                            } else {
                                keyStore = KeyStore.getInstance(KEYSTORE_TYPE_PKCS12);
                                LogManager.getInstance(context).logDebug("SSL", "✅ KeyStore created with " + str2 + " provider (provider by default)");
                            }
                            inputStreamOpenRawResource = context.getResources().openRawResource(R.raw.keystore);
                            LogManager.getInstance(context).logDebug("SSL", "✅ Certificate resource opened successfully");
                            keyStore.load(inputStreamOpenRawResource, "aa".toCharArray());
                            LogManager.getInstance(context).logDebug("SSL", "✅ Certificate loaded into KeyStore successfully");
                            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                            LogManager.getInstance(context).logDebug("SSL", "✅ KeyManagerFactory created: " + keyManagerFactory.getAlgorithm());
                            keyManagerFactory.init(keyStore, "aa".toCharArray());
                            LogManager.getInstance(context).logDebug("SSL", "✅ KeyManagerFactory initialized successfully");
                            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                            LogManager.getInstance(context).logDebug("SSL", "✅ SSLContext created: " + sSLContext.getProtocol());
                            sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{new C2779c()}, new SecureRandom());
                            LogManager.getInstance(context).logDebug("SSL", "✅ SSLContext initialized successfully");
                            SSLEngine sSLEngineCreateSSLEngine = sSLContext.createSSLEngine();
                            LogManager.getInstance(context).logDebug("SSL", "✅ SSLEngine created successfully");
                            String[] supportedProtocols = sSLEngineCreateSSLEngine.getSupportedProtocols();
                            LogManager.getInstance(context).logDebug("SSL", "✅ Supported protocols: " + Arrays.toString(supportedProtocols));
                            LogManager.getInstance(context).logInfo("SSL", "🎉 COMPLETE SUCCESS with " + str2 + " provider - All SSL operations work correctly!");
                            if (inputStreamOpenRawResource != null) {
                                try {
                                    inputStreamOpenRawResource.close();
                                } catch (IOException e) {
                                    e = e;
                                    logManager = LogManager.getInstance(context);
                                    sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                                    sb.append(e.getMessage());
                                    logManager.logWarning("SSL", sb.toString());
                                }
                            }
                        } catch (Throwable th) {
                            if (inputStreamOpenRawResource != null) {
                                try {
                                    inputStreamOpenRawResource.close();
                                } catch (IOException e6) {
                                    LogManager.getInstance(context).logWarning("SSL", "Warning: Failed to close certificate stream: " + e6.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " File I/O error: " + e7.getMessage());
                        if (inputStreamOpenRawResource != null) {
                            try {
                                inputStreamOpenRawResource.close();
                            } catch (IOException e8) {
                                e = e8;
                                logManager = LogManager.getInstance(context);
                                sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                                sb.append(e.getMessage());
                                logManager.logWarning("SSL", sb.toString());
                            }
                        }
                    }
                } catch (NoSuchProviderException e9) {
                    LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " provider not available: " + e9.getMessage());
                    if (inputStreamOpenRawResource != null) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (IOException e10) {
                            e = e10;
                            logManager = LogManager.getInstance(context);
                            sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                            sb.append(e.getMessage());
                            logManager.logWarning("SSL", sb.toString());
                        }
                    }
                } catch (UnrecoverableKeyException e11) {
                    LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " Key recovery error: " + e11.getMessage());
                    if (inputStreamOpenRawResource != null) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (IOException e12) {
                            e = e12;
                            logManager = LogManager.getInstance(context);
                            sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                            sb.append(e.getMessage());
                            logManager.logWarning("SSL", sb.toString());
                        }
                    }
                }
            } catch (KeyStoreException e13) {
                LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " KeyStore error: " + e13.getMessage());
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException e14) {
                        e = e14;
                        logManager = LogManager.getInstance(context);
                        sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                        sb.append(e.getMessage());
                        logManager.logWarning("SSL", sb.toString());
                    }
                }
            } catch (Exception e15) {
                LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " Unexpected error: " + e15.getClass().getSimpleName() + " - " + e15.getMessage());
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException e16) {
                        e = e16;
                        logManager = LogManager.getInstance(context);
                        sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                        sb.append(e.getMessage());
                        logManager.logWarning("SSL", sb.toString());
                    }
                }
            }
        } catch (NoSuchAlgorithmException e17) {
            LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " Algorithm not found: " + e17.getMessage());
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e18) {
                    e = e18;
                    logManager = LogManager.getInstance(context);
                    sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                    sb.append(e.getMessage());
                    logManager.logWarning("SSL", sb.toString());
                }
            }
        } catch (CertificateException e19) {
            LogManager.getInstance(context).logError("SSL", "❌ " + str2 + " Certificate error: " + e19.getMessage());
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e20) {
                    e = e20;
                    logManager = LogManager.getInstance(context);
                    sb = new StringBuilder("Warning: Failed to close certificate stream: ");
                    sb.append(e.getMessage());
                    logManager.logWarning("SSL", sb.toString());
                }
            }
        }
    }
}
