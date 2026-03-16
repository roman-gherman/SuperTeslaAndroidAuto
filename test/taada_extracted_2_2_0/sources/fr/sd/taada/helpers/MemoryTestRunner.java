package fr.sd.taada.helpers;

import X0.h;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import fr.sd.taada.helpers.MemoryHelper;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryTestRunner {
    private static final String TAG = "MemoryTestRunner";

    public interface TestCallback {
        void onTestComplete(String str);

        void onTestError(String str);

        void onTestStart(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryCleanup$10(TestCallback testCallback) {
        testCallback.onTestError("❌ Test interrompu");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryCleanup$11(Context context, MemoryHelper.MemoryInfo memoryInfo, Handler handler, TestCallback testCallback) {
        try {
            Thread.sleep(500L);
            long j6 = memoryInfo.usedHeapSize - MemoryHelper.getMemoryInfo(context).usedHeapSize;
            String str = "✅ Nettoyage terminé";
            if (j6 > 0) {
                str = "✅ Nettoyage terminé\n🗑️ " + MemoryHelper.formatBytes(j6) + " libérés";
            }
            handler.post(new h(17, testCallback, str));
        } catch (InterruptedException unused) {
            handler.post(new f(testCallback, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryCleanup$8(TestCallback testCallback) {
        testCallback.onTestStart("🧹 Nettoyage mémoire...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryDiagnostic$0(TestCallback testCallback) {
        testCallback.onTestStart("🔍 Diagnostic mémoire en cours...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryDiagnostic$1(TestCallback testCallback) {
        testCallback.onTestComplete("✅ Diagnostic mémoire terminé");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryDiagnostic$2(TestCallback testCallback) {
        testCallback.onTestError("❌ Erreur lors du diagnostic");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryDiagnostic$3(Context context, Handler handler, TestCallback testCallback) {
        try {
            MemoryDiagnostic.runMemoryDiagnostic(context);
            handler.post(new f(testCallback, 0));
        } catch (Exception e) {
            Log.e(TAG, "Error during memory diagnostic", e);
            handler.post(new f(testCallback, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryStressTest$4(TestCallback testCallback) {
        testCallback.onTestStart("⚡ Stress test mémoire en cours...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryStressTest$5(TestCallback testCallback) {
        testCallback.onTestComplete("✅ Stress test terminé");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryStressTest$6(TestCallback testCallback) {
        testCallback.onTestError("❌ Erreur lors du stress test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runMemoryStressTest$7(Context context, Handler handler, TestCallback testCallback) {
        try {
            MemoryDiagnostic.runMemoryStressTest(context);
            handler.post(new f(testCallback, 3));
        } catch (Exception e) {
            Log.e(TAG, "Error during stress test", e);
            handler.post(new f(testCallback, 4));
        }
    }

    public static void runMemoryCleanup(Context context, TestCallback testCallback) {
        TestCallback testCallback2;
        MemoryHelper.MemoryInfo memoryInfo;
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new f(testCallback, 5));
        try {
            memoryInfo = MemoryHelper.getMemoryInfo(context);
            MemoryHelper.requestMemoryCleanup(true);
            testCallback2 = testCallback;
        } catch (Exception e) {
            e = e;
            testCallback2 = testCallback;
        }
        try {
            new Thread(new androidx.work.impl.d(context, memoryInfo, handler, testCallback2, 3)).start();
        } catch (Exception e6) {
            e = e6;
            Log.e(TAG, "Error during memory cleanup", e);
            testCallback2.onTestError("❌ Erreur lors du nettoyage");
        }
    }

    public static void runMemoryDiagnostic(Context context, TestCallback testCallback) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new f(testCallback, 7));
        new Thread(new g(context, handler, testCallback, 1)).start();
    }

    public static void runMemoryStressTest(Context context, TestCallback testCallback) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new f(testCallback, 6));
        new Thread(new g(context, handler, testCallback, 0)).start();
    }
}
