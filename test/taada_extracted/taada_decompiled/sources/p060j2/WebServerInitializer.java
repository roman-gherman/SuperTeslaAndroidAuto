package p060j2;

import android.content.Context;
import fr.sd.taada.R;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.helpers.LogManager;
import java.io.IOException;
import java.net.BindException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import p066k2.SSLHelper;

/* JADX INFO: loaded from: classes.dex */
public class WebServerInitializer implements Runnable {
    private static final int DEFAULT_HTTPS_PORT = 8081;
    private static final int MAX_PORT_RETRIES = 5;
    private static final String TAG = "WebServerInitializer";
    private static final Object serverLock = new Object();
    private static volatile boolean serverStarted = false;
    Context context;
    private LogManager logManager;

    public WebServerInitializer(Context context) {
        this.context = context;
        synchronized (serverLock) {
            try {
                if (serverStarted) {
                    getLogManager().logWarning(TAG, "HTTPS server already started, skipping initialization");
                    return;
                }
                getLogManager().logDebug(TAG, "Initializing HTTPS server");
                new Thread(this).start();
                serverStarted = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void acceptConnections(SSLServerSocket sSLServerSocket) {
        while (!Thread.currentThread().isInterrupted() && serverStarted) {
            try {
                new HttpRequestHandler(sSLServerSocket.accept(), this.context).start();
            } catch (IOException e) {
                getLogManager().logError(TAG, "Error accepting client connection on port " + sSLServerSocket.getLocalPort() + " - client connection failed", e);
            } catch (SecurityException e6) {
                getLogManager().logError(TAG, "Security error while accepting connections - check network permissions", e6);
                return;
            } catch (Exception e7) {
                getLogManager().logError(TAG, "Unexpected error while accepting connections", e7);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SSLServerSocket attemptCreateServerSocket(int i) throws Throwable {
        SSLServerSocket sSLServerSocket;
        SSLServerSocket sSLServerSocket2 = 0;
        try {
            try {
                try {
                    getLogManager().logDebug(TAG, "Attempting to start HTTPS server on port: " + i);
                    sSLServerSocket = (SSLServerSocket) SSLHelper.createSSLContext(this.context, R.raw.server_pbe, "aa").getServerSocketFactory().createServerSocket(i);
                    try {
                        sSLServerSocket.setReuseAddress(true);
                        getLogManager().logInfo(TAG, "HTTPS server successfully started on port " + i);
                        return sSLServerSocket;
                    } catch (BindException unused) {
                        getLogManager().logWarning(TAG, "Port " + i + " already in use - another service may be running on this port. Trying next port...");
                        if (sSLServerSocket != null) {
                            try {
                                sSLServerSocket.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return null;
                    } catch (IOException e) {
                        e = e;
                        getLogManager().logError(TAG, "IO error creating HTTPS server on port " + i + " - check network connectivity and permissions", e);
                        throw e;
                    } catch (KeyManagementException e6) {
                        e = e6;
                        getLogManager().logError(TAG, "SSL key management error on port " + i + " - check certificate password and format", e);
                        throw e;
                    } catch (KeyStoreException e7) {
                        e = e7;
                        getLogManager().logError(TAG, "SSL keystore error on port " + i + " - check certificate file integrity (server_pbe.p12)", e);
                        throw e;
                    } catch (NoSuchAlgorithmException e8) {
                        e = e8;
                        getLogManager().logError(TAG, "SSL algorithm not available on port " + i + " - check Android SSL provider support", e);
                        throw e;
                    } catch (CertificateException e9) {
                        e = e9;
                        getLogManager().logError(TAG, "SSL certificate error on port " + i + " - check certificate validity and format", e);
                        throw e;
                    } catch (Exception e10) {
                        e = e10;
                        getLogManager().logError(TAG, "Unexpected error creating HTTPS server on port " + i + " - check SSL configuration and system resources", e);
                        throw e;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (sSLServerSocket2 != 0) {
                        try {
                            sSLServerSocket2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (BindException unused4) {
                sSLServerSocket = null;
            } catch (IOException e11) {
                e = e11;
            } catch (KeyManagementException e12) {
                e = e12;
            } catch (KeyStoreException e13) {
                e = e13;
            } catch (NoSuchAlgorithmException e14) {
                e = e14;
            } catch (CertificateException e15) {
                e = e15;
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Throwable th2) {
            th = th2;
            sSLServerSocket2 = "Attempting to start HTTPS server on port: ";
        }
    }

    private void closeServerSocket(SSLServerSocket sSLServerSocket) {
        if (sSLServerSocket == null || sSLServerSocket.isClosed()) {
            return;
        }
        try {
            sSLServerSocket.close();
            getLogManager().logDebug(TAG, "HTTPS server socket closed successfully");
        } catch (IOException e) {
            getLogManager().logError(TAG, "Error closing HTTPS server socket - resource cleanup failed", e);
        }
    }

    private SSLServerSocket createServerSocket() throws Throwable {
        getLogManager().logDebug(TAG, "Starting HTTPS server initialization");
        for (int i = 0; i < 5; i++) {
            SSLServerSocket sSLServerSocketAttemptCreateServerSocket = attemptCreateServerSocket(i + DEFAULT_HTTPS_PORT);
            if (sSLServerSocketAttemptCreateServerSocket != null) {
                return sSLServerSocketAttemptCreateServerSocket;
            }
            if (i == 4) {
                getLogManager().logError(TAG, "No available port found for HTTPS server after 5 attempts starting from 8081. Check for conflicting services or port usage.");
                return null;
            }
        }
        return null;
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.context);
        }
        return this.logManager;
    }

    private void resetServerFlag() {
        synchronized (serverLock) {
            serverStarted = false;
        }
    }

    public static void stopServer() {
        synchronized (serverLock) {
            serverStarted = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        SSLServerSocket sSLServerSocketCreateServerSocket = createServerSocket();
                        if (sSLServerSocketCreateServerSocket == null) {
                            getLogManager().logError(TAG, "Failed to create HTTPS server after all attempts - no ports available");
                            return;
                        }
                        try {
                            getLogManager().logInfo(TAG, "HTTPS server successfully started on port " + sSLServerSocketCreateServerSocket.getLocalPort());
                            if (TelemetryManager.isInitialized()) {
                                TelemetryManager.getInstance().log(FunnelEvent.HTTP_SERVER_CONNECTED);
                            }
                            acceptConnections(sSLServerSocketCreateServerSocket);
                            closeServerSocket(sSLServerSocketCreateServerSocket);
                        } catch (Throwable th) {
                            closeServerSocket(sSLServerSocketCreateServerSocket);
                            throw th;
                        }
                    } catch (IOException e) {
                        getLogManager().logError(TAG, "IO error during HTTPS server operation - network connectivity issue", e);
                    }
                } catch (InterruptedException unused) {
                    getLogManager().logInfo(TAG, "HTTPS server thread interrupted - shutting down gracefully");
                    Thread.currentThread().interrupt();
                }
            } catch (SecurityException e6) {
                getLogManager().logError(TAG, "Security error during HTTPS server initialization - check SSL certificates and permissions", e6);
            } catch (Exception e7) {
                getLogManager().logError(TAG, "Unexpected error in HTTPS server operation", e7);
                e7.printStackTrace();
            }
        } finally {
            resetServerFlag();
        }
    }
}
