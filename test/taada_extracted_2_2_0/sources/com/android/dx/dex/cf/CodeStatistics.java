package com.android.dx.dex.cf;

import com.android.dx.dex.code.DalvCode;
import com.android.dx.rop.code.RopMethod;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public final class CodeStatistics {
    private static final boolean DEBUG = false;
    public int runningDeltaRegisters = 0;
    public int runningDeltaInsns = 0;
    public int runningTotalInsns = 0;
    public int dexRunningDeltaRegisters = 0;
    public int dexRunningDeltaInsns = 0;
    public int dexRunningTotalInsns = 0;
    public int runningOriginalBytes = 0;

    public void dumpStatistics(PrintStream printStream) {
        printStream.printf("Optimizer Delta Rop Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(this.runningDeltaInsns), Integer.valueOf(this.runningTotalInsns), Double.valueOf(((double) (this.runningDeltaInsns / (Math.abs(r2) + this.runningTotalInsns))) * 100.0d), Integer.valueOf(this.runningDeltaRegisters));
        printStream.printf("Optimizer Delta Dex Insns: Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(this.dexRunningDeltaInsns), Integer.valueOf(this.dexRunningTotalInsns), Double.valueOf(((double) (this.dexRunningDeltaInsns / (Math.abs(r2) + this.dexRunningTotalInsns))) * 100.0d), Integer.valueOf(this.dexRunningDeltaRegisters));
        printStream.printf("Original bytecode byte count: %d\n", Integer.valueOf(this.runningOriginalBytes));
    }

    public void updateDexStatistics(DalvCode dalvCode, DalvCode dalvCode2) {
        this.dexRunningDeltaInsns = (dalvCode2.getInsns().codeSize() - dalvCode.getInsns().codeSize()) + this.dexRunningDeltaInsns;
        this.dexRunningDeltaRegisters = (dalvCode2.getInsns().getRegistersSize() - dalvCode.getInsns().getRegistersSize()) + this.dexRunningDeltaRegisters;
        this.dexRunningTotalInsns = dalvCode2.getInsns().codeSize() + this.dexRunningTotalInsns;
    }

    public void updateOriginalByteCount(int i) {
        this.runningOriginalBytes += i;
    }

    public void updateRopStatistics(RopMethod ropMethod, RopMethod ropMethod2) {
        int effectiveInstructionCount = ropMethod.getBlocks().getEffectiveInstructionCount();
        int regCount = ropMethod.getBlocks().getRegCount();
        int effectiveInstructionCount2 = ropMethod2.getBlocks().getEffectiveInstructionCount();
        this.runningDeltaInsns = (effectiveInstructionCount2 - effectiveInstructionCount) + this.runningDeltaInsns;
        this.runningDeltaRegisters = (ropMethod2.getBlocks().getRegCount() - regCount) + this.runningDeltaRegisters;
        this.runningTotalInsns += effectiveInstructionCount2;
    }
}
