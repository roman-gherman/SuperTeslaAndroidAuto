package fr.sd.taada.services;

import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import fr.sd.taada.analytics.telemetry.VpnTelemetryHelper;
import fr.sd.taada.billing.SubscriptionGuard;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class MyVpnService extends VpnService {
    private static final String TAG = "HU-VpnService";
    private ParcelFileDescriptor vpnInterface;
    private Thread vpnThread;
    VpnService.Builder vpnBuilder = new VpnService.Builder(this);
    private final CountDownLatch shutdownLatch = new CountDownLatch(1);

    public class RunnableC2739a implements Runnable {
        public RunnableC2739a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    MyVpnService myVpnService = MyVpnService.this;
                    myVpnService.vpnInterface = myVpnService.vpnBuilder.setSession("MyVPNService").addAddress("51.75.29.16", 24).addDnsServer("8.8.8.8").addDisallowedApplication("com.google.android.projection.gearhead").addRoute("0.0.0.0", 0).establish();
                } catch (Exception e) {
                    Log.e(MyVpnService.TAG, "Error in VPN service: " + e.getMessage(), e);
                    MyVpnService.this.stopSelf();
                }
                if (MyVpnService.this.vpnInterface == null) {
                    Log.e(MyVpnService.TAG, "❌ Failed to establish VPN: Permission denied or revoked");
                    VpnTelemetryHelper.logVpnConnectionFailed("MyVpnService");
                    MyVpnService.this.stopSelf();
                } else {
                    VpnTelemetryHelper.logVpnConnected("MyVpnService");
                    MyVpnService.this.startService(new Intent(MyVpnService.this.getApplicationContext(), (Class<?>) NewVpnService.class));
                    try {
                        MyVpnService.this.shutdownLatch.await();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            } finally {
                MyVpnService.this.cleanup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanup() {
        ParcelFileDescriptor parcelFileDescriptor = this.vpnInterface;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                this.vpnInterface = null;
            } catch (IOException e) {
                Log.e(TAG, "Error closing VPN interface: " + e.getMessage());
            }
        }
        try {
            stopService(new Intent(this, (Class<?>) NewVpnService.class));
        } catch (Exception e6) {
            Log.e(TAG, "Error stopping secondary VPN service: " + e6.getMessage(), e6);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.shutdownLatch.countDown();
        Thread thread = this.vpnThread;
        if (thread != null && thread.isAlive()) {
            try {
                this.vpnThread.join(1000L);
                if (this.vpnThread.isAlive()) {
                    Log.w(TAG, "VPN thread still alive after timeout");
                }
            } catch (InterruptedException unused) {
                Log.e(TAG, "Interrupted while waiting for VPN thread to finish");
            }
        }
        cleanup();
        VpnTelemetryHelper.logVpnDisconnected("MyVpnService");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        if (intent != null) {
            new StringBuilder(" with action: ").append(intent.getAction());
        }
        if (intent != null && "fr.sd.taada.exit".equals(intent.getAction())) {
            this.shutdownLatch.countDown();
            stopSelf();
            return 2;
        }
        if (!SubscriptionGuard.canAccessServicesSync(this, "MyVpnService")) {
            Log.w(TAG, "❌ VPN Service start blocked - No active subscription");
            SubscriptionGuard.logAccessAttempt(this, "MyVpnService", false, "VPN Service Start");
            stopSelf();
            return 2;
        }
        SubscriptionGuard.logAccessAttempt(this, "MyVpnService", true, "VPN Service Start");
        Thread thread = new Thread(new RunnableC2739a(), "MyVpnRunnable");
        this.vpnThread = thread;
        thread.start();
        return 2;
    }
}
