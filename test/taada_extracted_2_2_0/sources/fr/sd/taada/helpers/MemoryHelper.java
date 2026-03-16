package fr.sd.taada.helpers;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import java.text.DecimalFormat;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryHelper {
    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");
    private static final double MEMORY_CRITICAL_THRESHOLD = 0.9d;
    private static final double MEMORY_WARNING_THRESHOLD = 0.8d;
    private static final String TAG = "MemoryHelper";

    public static class MemoryInfo {
        public final long availableHeapSize;
        public final long availableSystemMemory;
        public final long freeHeapSize;
        public final boolean isLowMemory;
        public final long maxHeapSize;
        public final long totalHeapSize;
        public final long totalSystemMemory;
        public final long usedHeapSize;
        public final long usedSystemMemory;

        public MemoryInfo(long j6, long j7, long j8, boolean z6, long j9, long j10, long j11, long j12, long j13) {
            this.totalSystemMemory = j6;
            this.usedSystemMemory = j7;
            this.availableSystemMemory = j8;
            this.isLowMemory = z6;
            this.maxHeapSize = j9;
            this.totalHeapSize = j10;
            this.usedHeapSize = j11;
            this.freeHeapSize = j12;
            this.availableHeapSize = j13;
        }
    }

    public enum MemoryStatus {
        NORMAL("Normal"),
        WARNING("Warning"),
        CRITICAL("Critical");

        private final String description;

        MemoryStatus(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public static MemoryStatus checkMemoryStatus(Context context) {
        double d = r4.usedHeapSize / r4.maxHeapSize;
        return (getMemoryInfo(context).isLowMemory || d >= MEMORY_CRITICAL_THRESHOLD) ? MemoryStatus.CRITICAL : d >= MEMORY_WARNING_THRESHOLD ? MemoryStatus.WARNING : MemoryStatus.NORMAL;
    }

    public static String formatBytes(long j6) {
        if (j6 < 1024) {
            return j6 + " B";
        }
        if (j6 < 1048576) {
            return FORMAT.format(j6 / 1024.0d) + " KB";
        }
        if (j6 < 1073741824) {
            return FORMAT.format(j6 / 1048576.0d) + " MB";
        }
        return FORMAT.format(j6 / 1.073741824E9d) + " GB";
    }

    public static MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Runtime runtime = Runtime.getRuntime();
        long j6 = memoryInfo.totalMem;
        long j7 = memoryInfo.availMem;
        boolean z6 = memoryInfo.lowMemory;
        long jMaxMemory = runtime.maxMemory();
        long j8 = runtime.totalMemory();
        long jFreeMemory = runtime.freeMemory();
        long j9 = j8 - jFreeMemory;
        return new MemoryInfo(j6, j6 - j7, j7, z6, jMaxMemory, j8, j9, jFreeMemory, jMaxMemory - j9);
    }

    public static boolean isAllocationSafe(Context context, long j6) {
        long j7 = getMemoryInfo(context).availableHeapSize;
        double d = (r6.usedHeapSize + j6) / r6.maxHeapSize;
        boolean z6 = j7 > j6 && d < MEMORY_CRITICAL_THRESHOLD;
        if (!z6) {
            Log.w(TAG, "⚠️ Allocation unsafe - Requested: " + formatBytes(j6) + ", Available: " + formatBytes(j7) + ", Usage after: " + FORMAT.format(d * 100.0d) + "%");
        }
        return z6;
    }

    public static void logMemoryState(Context context, String str) {
        MemoryInfo memoryInfo = getMemoryInfo(context);
        formatBytes(memoryInfo.totalSystemMemory);
        formatBytes(memoryInfo.usedSystemMemory);
        DecimalFormat decimalFormat = FORMAT;
        decimalFormat.format((memoryInfo.usedSystemMemory / memoryInfo.totalSystemMemory) * 100.0d);
        formatBytes(memoryInfo.availableSystemMemory);
        formatBytes(memoryInfo.maxHeapSize);
        formatBytes(memoryInfo.totalHeapSize);
        formatBytes(memoryInfo.usedHeapSize);
        decimalFormat.format((memoryInfo.usedHeapSize / memoryInfo.maxHeapSize) * 100.0d);
        formatBytes(memoryInfo.freeHeapSize);
        formatBytes(memoryInfo.availableHeapSize);
        Objects.toString(checkMemoryStatus(context));
    }

    public static void requestMemoryCleanup(boolean z6) {
    }
}
