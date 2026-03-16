package fr.sd.taada;

import fr.sd.taada.helpers.LogManager;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;
import p024d2.ToastHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectionWaitRunnable implements Runnable {
    private static final String TAG = "HU-ConnectionWait";
    private final LogManager logManager;
    private final TransporterService service;

    public ConnectionWaitRunnable(TransporterService transporterService) {
        this.service = transporterService;
        this.logManager = transporterService.getLogManager();
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        ServerSocket serverSocket;
        ServerSocket serverSocket2 = null;
        try {
            try {
                try {
                    this.logManager.logInfo(TAG, "[TIMING] Creating ServerSocket on port 5288 for Android Auto");
                    serverSocket = new ServerSocket(5288);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                serverSocket.setReuseAddress(true);
                this.logManager.logInfo(TAG, "[TIMING] ServerSocket created - NOW LISTENING on port 5288 - Waiting for Android Auto to connect");
                Socket socketAccept = serverSocket.accept();
                this.logManager.logInfo(TAG, "[TIMING] *** ANDROID AUTO CONNECTED *** from " + socketAccept.getRemoteSocketAddress());
                this.service.getCommunicationHandler().setupConnection(socketAccept);
                serverSocket.close();
            } catch (IOException e6) {
                e = e6;
                serverSocket2 = serverSocket;
                this.logManager.logError(TAG, "Connection wait error", e);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", "error");
                    jSONObject.put("message", this.service.getString(R.string.cantconnect));
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                ToastHelper.showToast(e.getMessage(), this.service);
                if (serverSocket2 != null) {
                    serverSocket2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                serverSocket2 = serverSocket;
                if (serverSocket2 != null) {
                    try {
                        serverSocket2.close();
                    } catch (IOException e8) {
                        this.logManager.logError(TAG, "Error closing server socket", e8);
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            this.logManager.logError(TAG, "Error closing server socket", e9);
        }
    }
}
