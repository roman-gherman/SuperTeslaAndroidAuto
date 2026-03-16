package fr.sd.taada.helpers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import fr.sd.taada.helpers.MemoryHelper;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryDiagnostic {
    private static final String TAG = "MemoryDiagnostic";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showToastSafe$0(Context context, String str, int i) {
        try {
            Toast.makeText(context, str, i).show();
        } catch (Exception e) {
            Log.e(TAG, "Error showing toast: " + e.getMessage());
        }
    }

    public static void runMemoryDiagnostic(Context context) {
        testInitialMemoryState(context);
        testSafeAllocations(context);
        testLargeAllocationResilience(context);
        testMemoryCleanup(context);
    }

    public static void runMemoryStressTest(Context context) {
        Log.w(TAG, "⚡ === MEMORY STRESS TEST START ===");
        Log.w(TAG, "⚠️ This test may cause temporary performance degradation");
        int i = 0;
        int i3 = 0;
        for (int i4 = 1; i4 <= 20; i4++) {
            int i5 = 5242880 * i4;
            long j6 = i5;
            try {
                if (MemoryHelper.isAllocationSafe(context, j6)) {
                    ByteBuffer.allocate(i5);
                    i++;
                    MemoryHelper.formatBytes(j6);
                } else {
                    Log.w(TAG, "⚠️ Stress allocation " + i4 + " skipped (unsafe): " + MemoryHelper.formatBytes(j6));
                    i3++;
                }
                if (i4 % 5 == 0) {
                    MemoryHelper.requestMemoryCleanup(false);
                }
            } catch (OutOfMemoryError unused) {
                StringBuilder sbJ = B2.b.j(i4, "❌ Stress allocation ", " failed: ");
                sbJ.append(MemoryHelper.formatBytes(j6));
                Log.e(TAG, sbJ.toString());
                i3++;
                MemoryHelper.requestMemoryCleanup(true);
            }
        }
        int i6 = (i * 100) / (i + i3);
        MemoryHelper.logMemoryState(context, TAG);
        Log.w(TAG, "⚡ === MEMORY STRESS TEST END ===");
    }

    private static void showToastSafe(Context context, String str, int i) {
        new Handler(Looper.getMainLooper()).post(new androidx.profileinstaller.a(context, i, str));
    }

    private static void testBufferResize(Context context, int i) {
        long j6 = i;
        MemoryHelper.formatBytes(j6);
        try {
            if (MemoryHelper.isAllocationSafe(context, j6)) {
                ByteBuffer.allocate(i);
                MemoryHelper.formatBytes(j6);
            } else {
                Log.w(TAG, "⚠️ Allocation deemed unsafe for " + MemoryHelper.formatBytes(j6));
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "❌ OutOfMemoryError for " + MemoryHelper.formatBytes(j6), e);
            MemoryHelper.requestMemoryCleanup(true);
        }
    }

    private static void testInitialMemoryState(Context context) {
        MemoryHelper.logMemoryState(context, TAG);
        Objects.toString(MemoryHelper.checkMemoryStatus(context));
    }

    private static void testLargeAllocationResilience(Context context) {
        try {
            testBufferResize(context, 32768);
            testBufferResize(context, 1048576);
            testBufferResize(context, 10485760);
            testBufferResize(context, 104857600);
        } catch (Exception e) {
            Log.e(TAG, "Error during large allocation test", e);
        }
    }

    private static void testMemoryCleanup(Context context) {
        MemoryHelper.MemoryInfo memoryInfo = MemoryHelper.getMemoryInfo(context);
        MemoryHelper.formatBytes(memoryInfo.usedHeapSize);
        MemoryHelper.formatBytes(memoryInfo.maxHeapSize);
        MemoryHelper.requestMemoryCleanup(true);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
        MemoryHelper.MemoryInfo memoryInfo2 = MemoryHelper.getMemoryInfo(context);
        MemoryHelper.formatBytes(memoryInfo2.usedHeapSize);
        MemoryHelper.formatBytes(memoryInfo2.maxHeapSize);
        long j6 = memoryInfo.usedHeapSize - memoryInfo2.usedHeapSize;
        if (j6 > 0) {
            MemoryHelper.formatBytes(j6);
        }
    }

    private static void testSafeAllocations(Context context) {
        long[] jArr = {1024, 1048576, 10485760, 52428800, 104857600};
        for (int i = 0; i < 5; i++) {
            long j6 = jArr[i];
            MemoryHelper.isAllocationSafe(context, j6);
            MemoryHelper.formatBytes(j6);
        }
    }
}
