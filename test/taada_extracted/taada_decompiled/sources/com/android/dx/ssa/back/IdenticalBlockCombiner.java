package com.android.dx.ssa.back;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.util.IntList;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class IdenticalBlockCombiner {
    private final BasicBlockList blocks;
    private final BasicBlockList newBlocks;
    private final RopMethod ropMethod;

    public IdenticalBlockCombiner(RopMethod ropMethod) {
        this.ropMethod = ropMethod;
        BasicBlockList blocks = ropMethod.getBlocks();
        this.blocks = blocks;
        this.newBlocks = blocks.getMutableCopy();
    }

    private void combineBlocks(int i, IntList intList) {
        int size = intList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = intList.get(i3);
            IntList intListLabelToPredecessors = this.ropMethod.labelToPredecessors(this.blocks.labelToBlock(i4).getLabel());
            int size2 = intListLabelToPredecessors.size();
            for (int i5 = 0; i5 < size2; i5++) {
                replaceSucc(this.newBlocks.labelToBlock(intListLabelToPredecessors.get(i5)), i4, i);
            }
        }
    }

    private static boolean compareInsns(BasicBlock basicBlock, BasicBlock basicBlock2) {
        return basicBlock.getInsns().contentEquals(basicBlock2.getInsns());
    }

    private void replaceSucc(BasicBlock basicBlock, int i, int i3) {
        IntList intListMutableCopy = basicBlock.getSuccessors().mutableCopy();
        intListMutableCopy.set(intListMutableCopy.indexOf(i), i3);
        int primarySuccessor = basicBlock.getPrimarySuccessor();
        if (primarySuccessor != i) {
            i3 = primarySuccessor;
        }
        intListMutableCopy.setImmutable();
        BasicBlock basicBlock2 = new BasicBlock(basicBlock.getLabel(), basicBlock.getInsns(), intListMutableCopy, i3);
        BasicBlockList basicBlockList = this.newBlocks;
        basicBlockList.set(basicBlockList.indexOfLabel(basicBlock.getLabel()), basicBlock2);
    }

    public RopMethod process() {
        int size = this.blocks.size();
        BitSet bitSet = new BitSet(this.blocks.getMaxLabel());
        for (int i = 0; i < size; i++) {
            BasicBlock basicBlock = this.blocks.get(i);
            if (!bitSet.get(basicBlock.getLabel())) {
                IntList intListLabelToPredecessors = this.ropMethod.labelToPredecessors(basicBlock.getLabel());
                int size2 = intListLabelToPredecessors.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    int i4 = intListLabelToPredecessors.get(i3);
                    BasicBlock basicBlockLabelToBlock = this.blocks.labelToBlock(i4);
                    if (!bitSet.get(i4) && basicBlockLabelToBlock.getSuccessors().size() <= 1 && basicBlockLabelToBlock.getFirstInsn().getOpcode().getOpcode() != 55) {
                        IntList intList = new IntList();
                        for (int i5 = i3 + 1; i5 < size2; i5++) {
                            int i6 = intListLabelToPredecessors.get(i5);
                            BasicBlock basicBlockLabelToBlock2 = this.blocks.labelToBlock(i6);
                            if (basicBlockLabelToBlock2.getSuccessors().size() == 1 && compareInsns(basicBlockLabelToBlock, basicBlockLabelToBlock2)) {
                                intList.add(i6);
                                bitSet.set(i6);
                            }
                        }
                        combineBlocks(i4, intList);
                    }
                }
            }
        }
        for (int i7 = size - 1; i7 >= 0; i7--) {
            if (bitSet.get(this.newBlocks.get(i7).getLabel())) {
                this.newBlocks.set(i7, (BasicBlock) null);
            }
        }
        this.newBlocks.shrinkToFit();
        this.newBlocks.setImmutable();
        return new RopMethod(this.newBlocks, this.ropMethod.getFirstLabel());
    }
}
