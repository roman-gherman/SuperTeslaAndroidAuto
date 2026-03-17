package com.supertesla.aa.core.util

/**
 * Monitors JVM heap utilization and reports status thresholds.
 * Used to trigger cleanup or OOM recovery before actual OOM occurs.
 */
object MemoryMonitor {

    enum class Status { OK, WARNING, CRITICAL }

    /**
     * Check current memory status.
     * WARNING at >80% utilization, CRITICAL at >90%.
     */
    fun check(): Status {
        val runtime = Runtime.getRuntime()
        val used = runtime.totalMemory() - runtime.freeMemory()
        val max = runtime.maxMemory()
        val ratio = used.toDouble() / max
        return when {
            ratio > 0.9 -> Status.CRITICAL
            ratio > 0.8 -> Status.WARNING
            else -> Status.OK
        }
    }
}
