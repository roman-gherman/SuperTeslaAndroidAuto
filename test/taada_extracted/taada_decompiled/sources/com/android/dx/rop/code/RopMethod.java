package com.android.dx.rop.code;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.util.IntList;

/* JADX INFO: loaded from: classes.dex */
public final class RopMethod {
    private final BasicBlockList blocks;
    private IntList exitPredecessors;
    private final int firstLabel;
    private IntList[] predecessors;

    public RopMethod(BasicBlockList basicBlockList, int i) {
        if (basicBlockList == null) {
            throw new NullPointerException("blocks == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("firstLabel < 0");
        }
        this.blocks = basicBlockList;
        this.firstLabel = i;
        this.predecessors = null;
        this.exitPredecessors = null;
    }

    private void calcPredecessors() {
        int maxLabel = this.blocks.getMaxLabel();
        IntList[] intListArr = new IntList[maxLabel];
        IntList intList = new IntList(10);
        int size = this.blocks.size();
        for (int i = 0; i < size; i++) {
            BasicBlock basicBlock = this.blocks.get(i);
            int label = basicBlock.getLabel();
            IntList successors = basicBlock.getSuccessors();
            int size2 = successors.size();
            if (size2 == 0) {
                intList.add(label);
            } else {
                for (int i3 = 0; i3 < size2; i3++) {
                    int i4 = successors.get(i3);
                    IntList intList2 = intListArr[i4];
                    if (intList2 == null) {
                        intList2 = new IntList(10);
                        intListArr[i4] = intList2;
                    }
                    intList2.add(label);
                }
            }
        }
        for (int i5 = 0; i5 < maxLabel; i5++) {
            IntList intList3 = intListArr[i5];
            if (intList3 != null) {
                intList3.sort();
                intList3.setImmutable();
            }
        }
        intList.sort();
        intList.setImmutable();
        int i6 = this.firstLabel;
        if (intListArr[i6] == null) {
            intListArr[i6] = IntList.EMPTY;
        }
        this.predecessors = intListArr;
        this.exitPredecessors = intList;
    }

    public BasicBlockList getBlocks() {
        return this.blocks;
    }

    public IntList getExitPredecessors() {
        if (this.exitPredecessors == null) {
            calcPredecessors();
        }
        return this.exitPredecessors;
    }

    public int getFirstLabel() {
        return this.firstLabel;
    }

    public IntList labelToPredecessors(int i) {
        if (this.exitPredecessors == null) {
            calcPredecessors();
        }
        IntList intList = this.predecessors[i];
        if (intList != null) {
            return intList;
        }
        throw new RuntimeException(a.z(i, new StringBuilder("no such block: ")));
    }

    public RopMethod withRegisterOffset(int i) {
        RopMethod ropMethod = new RopMethod(this.blocks.withRegisterOffset(i), this.firstLabel);
        IntList intList = this.exitPredecessors;
        if (intList != null) {
            ropMethod.exitPredecessors = intList;
            ropMethod.predecessors = this.predecessors;
        }
        return ropMethod;
    }
}
