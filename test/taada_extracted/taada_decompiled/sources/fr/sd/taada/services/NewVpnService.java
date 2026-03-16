package fr.sd.taada.services;

import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import fr.sd.taada.analytics.telemetry.VpnTelemetryHelper;
import fr.sd.taada.billing.SubscriptionGuard;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class NewVpnService extends VpnService {
    private static final String TAG = "HU-NewVpnService";
    private DatagramChannel udpChannel;
    private ParcelFileDescriptor vpnInterface;
    private Thread vpnThread;
    VpnService.Builder vpnBuilder = new VpnService.Builder(this);
    private final CountDownLatch shutdownLatch = new CountDownLatch(1);

    public class RunnableC2740a implements Runnable {
        public RunnableC2740a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    NewVpnService newVpnService = NewVpnService.this;
                    newVpnService.vpnInterface = newVpnService.vpnBuilder.setSession("MyVPNService_2").addAddress("89.83.67.208", 24).addDnsServer("8.8.8.8").addAllowedApplication("android.net.ConnectivityManager").addRoute("0.0.0.0", 0).establish();
                } catch (Exception e) {
                    Log.e(NewVpnService.TAG, "Error in secondary VPN service: " + e.getMessage(), e);
                }
                if (NewVpnService.this.vpnInterface == null) {
                    Log.e(NewVpnService.TAG, "❌ Failed to establish VPN 2: Permission denied or revoked");
                    VpnTelemetryHelper.logVpnConnectionFailed("NewVpnService");
                    NewVpnService.this.stopSelf();
                    return;
                }
                VpnTelemetryHelper.logVpnConnected("NewVpnService");
                NewVpnService.this.udpChannel = DatagramChannel.open();
                NewVpnService.this.udpChannel.connect(new InetSocketAddress("127.0.0.1", 8089));
                NewVpnService newVpnService2 = NewVpnService.this;
                newVpnService2.protect(newVpnService2.udpChannel.socket());
                try {
                    NewVpnService.this.shutdownLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                NewVpnService.this.cleanup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanup() {
        DatagramChannel datagramChannel = this.udpChannel;
        if (datagramChannel != null) {
            try {
                datagramChannel.close();
                this.udpChannel = null;
            } catch (IOException e) {
                Log.e(TAG, "Error closing UDP channel: " + e.getMessage());
            }
        }
        ParcelFileDescriptor parcelFileDescriptor = this.vpnInterface;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                this.vpnInterface = null;
            } catch (IOException e6) {
                Log.e(TAG, "Error closing secondary VPN interface: " + e6.getMessage());
            }
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
                    Log.w(TAG, "Secondary VPN thread still alive after timeout");
                }
            } catch (InterruptedException unused) {
                Log.e(TAG, "Interrupted while waiting for secondary VPN thread to finish");
            }
        }
        cleanup();
        VpnTelemetryHelper.logVpnDisconnected("NewVpnService");
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
        if (!SubscriptionGuard.canAccessServicesSync(this, "NewVpnService")) {
            Log.w(TAG, "❌ Secondary VPN Service start blocked - No active subscription");
            SubscriptionGuard.logAccessAttempt(this, "NewVpnService", false, "Secondary VPN Service Start");
            stopSelf();
            return 2;
        }
        SubscriptionGuard.logAccessAttempt(this, "NewVpnService", true, "Secondary VPN Service Start");
        Thread thread = new Thread(new RunnableC2740a(), "MyVpnRunnable");
        this.vpnThread = thread;
        thread.start();
        return 2;
    }
}
