package fr.sd.taada.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import fr.sd.taada.R;
import java.nio.ByteBuffer;
import org.greenrobot.eventbus.EventBus;
import p024d2.ProtocolMessage;

/* JADX INFO: loaded from: classes2.dex */
public class MicActivity extends Activity {
    private static final String TAG = "MicActivity";
    public static volatile boolean isRecording;
    private AudioManager audioManager;
    private AudioRecord audioRecord;
    private Thread recordingThread;
    private BroadcastReceiver scoStateReceiver = new C2466a();
    private final Object audioRecordLock = new Object();

    public class C2466a extends BroadcastReceiver {

        public class RunnableC2467a implements Runnable {
            final int bufferSize;

            public RunnableC2467a(int i) {
                this.bufferSize = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:108:0x011f A[Catch: all -> 0x0115, TRY_LEAVE, TryCatch #8 {, blocks: (B:100:0x010b, B:102:0x0111, B:108:0x011f, B:107:0x0118), top: B:117:0x010b, inners: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:75:0x00d0 A[Catch: all -> 0x00c6, DONT_GENERATE, TryCatch #1 {, blocks: (B:67:0x00bc, B:69:0x00c2, B:75:0x00d0, B:74:0x00c9), top: B:114:0x00ba, inners: #11 }] */
            /* JADX WARN: Removed duplicated region for block: B:93:0x00fc A[Catch: all -> 0x00f2, TryCatch #6 {, blocks: (B:85:0x00e8, B:87:0x00ee, B:93:0x00fc, B:92:0x00f5), top: B:112:0x00e8, inners: #0 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 291
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.activities.MicActivity.C2466a.RunnableC2467a.run():void");
            }
        }

        public C2466a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int minBufferSize;
            if (1 == intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1)) {
                synchronized (MicActivity.this.audioRecordLock) {
                    try {
                        minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
                    } catch (Exception e) {
                        Log.e(MicActivity.TAG, "Erreur lors de l'initialisation de l'AudioRecord", e);
                    }
                    if (minBufferSize == -2) {
                        Log.e(MicActivity.TAG, "Impossible de déterminer la taille du buffer");
                        return;
                    }
                    MicActivity.this.audioRecord = new AudioRecord.Builder().setAudioSource(9).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(16000).setChannelMask(16).build()).setBufferSizeInBytes(minBufferSize).build();
                    if (MicActivity.this.audioRecord.getState() != 1) {
                        Log.e(MicActivity.TAG, "AudioRecord non initialisé correctement");
                        MicActivity.this.audioRecord.release();
                        MicActivity.this.audioRecord = null;
                    } else {
                        MicActivity.this.unregisterReceiver(this);
                        MicActivity.this.recordingThread = new Thread(new RunnableC2467a(minBufferSize));
                        MicActivity.this.recordingThread.setPriority(10);
                        MicActivity.this.recordingThread.start();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAudioDataOptimized(byte[] bArr, int i, ByteBuffer byteBuffer, byte[] bArr2) {
        try {
            byteBuffer.clear();
            byteBuffer.put(bArr2[0]);
            byteBuffer.put(bArr2[1]);
            byteBuffer.putLong(SystemClock.currentThreadTimeMillis());
            byteBuffer.put(bArr, 0, i);
            byte[] bArrArray = byteBuffer.array();
            Math.random();
            int i3 = i + 10;
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArrArray, 0, bArr3, 0, i3);
            EventBus.getDefault().post(new ProtocolMessage((byte) 4, (byte) 3, 0, bArr3));
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'envoi optimisé des données audio", e);
        }
    }

    public void m2644f(byte[] bArr) {
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 10);
            byteBufferAllocate.put(new byte[]{0, 0});
            byteBufferAllocate.putLong(SystemClock.currentThreadTimeMillis());
            byteBufferAllocate.put(bArr);
            EventBus.getDefault().post(new ProtocolMessage((byte) 4, (byte) 3, 0, byteBufferAllocate.array()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m2645e(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setFlags(268435456);
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("fr.sd.taada.STOP".equalsIgnoreCase(getIntent().getAction())) {
            finish();
        }
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        } else {
            getWindow().addFlags(6816897);
        }
        setContentView(R.layout.mic);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: all -> 0x0040, Exception -> 0x0059, TRY_LEAVE, TryCatch #3 {Exception -> 0x0059, blocks: (B:23:0x004a, B:25:0x0053), top: B:46:0x004a, outer: #0 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDestroy() {
        /*
            r4 = this;
            super.onDestroy()
            r0 = 0
            fr.sd.taada.activities.MicActivity.isRecording = r0
            java.lang.Thread r0 = r4.recordingThread
            if (r0 == 0) goto L2c
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L2c
            java.lang.Thread r0 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L25
            r1 = 500(0x1f4, double:2.47E-321)
            r0.join(r1)     // Catch: java.lang.InterruptedException -> L25
            java.lang.Thread r0 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L25
            boolean r0 = r0.isAlive()     // Catch: java.lang.InterruptedException -> L25
            if (r0 == 0) goto L2c
            java.lang.Thread r0 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L25
            r0.interrupt()     // Catch: java.lang.InterruptedException -> L25
            goto L2c
        L25:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L2c:
            java.lang.Object r0 = r4.audioRecordLock
            monitor-enter(r0)
            android.media.AudioRecord r1 = r4.audioRecord     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L64
            int r1 = r1.getRecordingState()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2 = 3
            if (r1 != r2) goto L4a
            android.media.AudioRecord r1 = r4.audioRecord     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r1.stop()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            goto L4a
        L40:
            r1 = move-exception
            goto L76
        L42:
            r1 = move-exception
            java.lang.String r2 = "MicActivity"
            java.lang.String r3 = "Erreur lors du stop dans onDestroy"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L40
        L4a:
            android.media.AudioRecord r1 = r4.audioRecord     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L59
            int r1 = r1.getState()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L59
            r2 = 1
            if (r1 != r2) goto L61
            android.media.AudioRecord r1 = r4.audioRecord     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L59
            r1.release()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L59
            goto L61
        L59:
            r1 = move-exception
            java.lang.String r2 = "MicActivity"
            java.lang.String r3 = "Erreur lors du release dans onDestroy"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L40
        L61:
            r1 = 0
            r4.audioRecord = r1     // Catch: java.lang.Throwable -> L40
        L64:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L40
            android.media.AudioManager r0 = r4.audioManager
            if (r0 == 0) goto L75
            r0.stopBluetoothSco()     // Catch: java.lang.Exception -> L6d
            goto L75
        L6d:
            r0 = move-exception
            java.lang.String r1 = "MicActivity"
            java.lang.String r2 = "Erreur lors de l'arrêt du Bluetooth SCO dans onDestroy"
            android.util.Log.e(r1, r2, r0)
        L75:
            return
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L40
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.activities.MicActivity.onDestroy():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[Catch: all -> 0x0059, Exception -> 0x006e, TRY_LEAVE, TryCatch #0 {Exception -> 0x006e, blocks: (B:26:0x0063, B:28:0x006a), top: B:44:0x0063, outer: #1 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onNewIntent(android.content.Intent r5) {
        /*
            r4 = this;
            super.onNewIntent(r5)
            java.lang.String r0 = "fr.sd.taada.STOP"
            java.lang.String r5 = r5.getAction()
            boolean r5 = r0.equalsIgnoreCase(r5)
            if (r5 == 0) goto L90
            r5 = 0
            fr.sd.taada.activities.MicActivity.isRecording = r5
            java.lang.Thread r5 = r4.recordingThread
            if (r5 == 0) goto L47
            boolean r5 = r5.isAlive()
            if (r5 == 0) goto L47
            java.lang.Thread r5 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L38
            r0 = 1000(0x3e8, double:4.94E-321)
            r5.join(r0)     // Catch: java.lang.InterruptedException -> L38
            java.lang.Thread r5 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L38
            boolean r5 = r5.isAlive()     // Catch: java.lang.InterruptedException -> L38
            if (r5 == 0) goto L47
            java.lang.String r5 = "MicActivity"
            java.lang.String r0 = "Le thread d'enregistrement ne s'est pas arrêté à temps"
            android.util.Log.w(r5, r0)     // Catch: java.lang.InterruptedException -> L38
            java.lang.Thread r5 = r4.recordingThread     // Catch: java.lang.InterruptedException -> L38
            r5.interrupt()     // Catch: java.lang.InterruptedException -> L38
            goto L47
        L38:
            r5 = move-exception
            java.lang.String r0 = "MicActivity"
            java.lang.String r1 = "Interruption lors de l'attente du thread"
            android.util.Log.e(r0, r1, r5)
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L47:
            java.lang.Object r5 = r4.audioRecordLock
            monitor-enter(r5)
            android.media.AudioRecord r0 = r4.audioRecord     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L79
            int r1 = r0.getRecordingState()     // Catch: java.lang.Throwable -> L59 java.lang.IllegalStateException -> L5b
            r2 = 3
            if (r1 != r2) goto L63
            r0.stop()     // Catch: java.lang.Throwable -> L59 java.lang.IllegalStateException -> L5b
            goto L63
        L59:
            r0 = move-exception
            goto L8e
        L5b:
            r1 = move-exception
            java.lang.String r2 = "MicActivity"
            java.lang.String r3 = "Erreur lors du stop de l'AudioRecord"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L59
        L63:
            int r1 = r0.getState()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L6e
            r2 = 1
            if (r1 != r2) goto L76
            r0.release()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L6e
            goto L76
        L6e:
            r0 = move-exception
            java.lang.String r1 = "MicActivity"
            java.lang.String r2 = "Erreur lors du release de l'AudioRecord"
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L59
        L76:
            r0 = 0
            r4.audioRecord = r0     // Catch: java.lang.Throwable -> L59
        L79:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L59
            android.media.AudioManager r5 = r4.audioManager
            if (r5 == 0) goto L8a
            r5.stopBluetoothSco()     // Catch: java.lang.Exception -> L82
            goto L8a
        L82:
            r5 = move-exception
            java.lang.String r0 = "MicActivity"
            java.lang.String r1 = "Erreur lors de l'arrêt du Bluetooth SCO"
            android.util.Log.e(r0, r1, r5)
        L8a:
            r4.finish()
            goto L90
        L8e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L59
            throw r0
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.activities.MicActivity.onNewIntent(android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.audioManager = (AudioManager) getSystemService("audio");
        isRecording = true;
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
            registerReceiver(this.scoStateReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
            this.audioManager.startBluetoothSco();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.RECORD_AUDIO")) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 2);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppDialogTheme);
            builder.setTitle(getResources().getString(R.string.alert_permission_denied_title));
            builder.setMessage(getResources().getString(R.string.alert_need_mic));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: fr.sd.taada.activities.MicActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MicActivity.this.m2645e(dialogInterface, i);
                }
            });
            builder.show();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            unregisterReceiver(this.scoStateReceiver);
        } catch (Exception unused) {
        }
    }
}
