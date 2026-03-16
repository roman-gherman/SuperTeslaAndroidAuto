package com.android.dx.ssa;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SsaBasicBlock {
    public static final Comparator<SsaBasicBlock> LABEL_COMPARATOR = new LabelComparator();
    private final int index;
    private IntSet liveIn;
    private IntSet liveOut;
    private final SsaMethod parent;
    private BitSet predecessors;
    private final int ropLabel;
    private BitSet successors;
    private int primarySuccessor = -1;
    private int movesFromPhisAtEnd = 0;
    private int movesFromPhisAtBeginning = 0;
    private final ArrayList<SsaInsn> insns = new ArrayList<>();
    private IntList successorList = new IntList();
    private final ArrayList<SsaBasicBlock> domChildren = new ArrayList<>();

    public static final class LabelComparator implements Comparator<SsaBasicBlock> {
        @Override // java.util.Comparator
        public int compare(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            int i = ssaBasicBlock.ropLabel;
            int i3 = ssaBasicBlock2.ropLabel;
            if (i < i3) {
                return -1;
            }
            return i > i3 ? 1 : 0;
        }
    }

    public interface Visitor {
        void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2);
    }

    public SsaBasicBlock(int i, int i3, SsaMethod ssaMethod) {
        this.parent = ssaMethod;
        this.index = i;
        this.ropLabel = i3;
        this.predecessors = new BitSet(ssaMethod.getBlocks().size());
        this.successors = new BitSet(ssaMethod.getBlocks().size());
    }

    private static boolean checkRegUsed(BitSet bitSet, RegisterSpec registerSpec) {
        int reg = registerSpec.getReg();
        return bitSet.get(reg) || (registerSpec.getCategory() == 2 && bitSet.get(reg + 1));
    }

    private int getCountPhiInsns() {
        int size = this.insns.size();
        int i = 0;
        while (i < size && (this.insns.get(i) instanceof PhiInsn)) {
            i++;
        }
        return i;
    }

    public static SsaBasicBlock newFromRop(RopMethod ropMethod, int i, SsaMethod ssaMethod) {
        BasicBlockList blocks = ropMethod.getBlocks();
        BasicBlock basicBlock = blocks.get(i);
        SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(i, basicBlock.getLabel(), ssaMethod);
        InsnList insns = basicBlock.getInsns();
        ssaBasicBlock.insns.ensureCapacity(insns.size());
        int size = insns.size();
        for (int i3 = 0; i3 < size; i3++) {
            ssaBasicBlock.insns.add(new NormalSsaInsn(insns.get(i3), ssaBasicBlock));
        }
        ssaBasicBlock.predecessors = SsaMethod.bitSetFromLabelList(blocks, ropMethod.labelToPredecessors(basicBlock.getLabel()));
        ssaBasicBlock.successors = SsaMethod.bitSetFromLabelList(blocks, basicBlock.getSuccessors());
        IntList intListIndexListFromLabelList = SsaMethod.indexListFromLabelList(blocks, basicBlock.getSuccessors());
        ssaBasicBlock.successorList = intListIndexListFromLabelList;
        if (intListIndexListFromLabelList.size() != 0) {
            int primarySuccessor = basicBlock.getPrimarySuccessor();
            ssaBasicBlock.primarySuccessor = primarySuccessor < 0 ? -1 : blocks.indexOfLabel(primarySuccessor);
        }
        return ssaBasicBlock;
    }

    private void scheduleUseBeforeAssigned(List<SsaInsn> list) {
        SsaInsn ssaInsn;
        BitSet bitSet = new BitSet(this.parent.getRegCount());
        BitSet bitSet2 = new BitSet(this.parent.getRegCount());
        int size = list.size();
        int i = 0;
        while (i < size) {
            for (int i3 = i; i3 < size; i3++) {
                setRegsUsed(bitSet, list.get(i3).getSources().get(0));
                setRegsUsed(bitSet2, list.get(i3).getResult());
            }
            int i4 = i;
            int i5 = i4;
            while (i4 < size) {
                if (!checkRegUsed(bitSet, list.get(i4).getResult())) {
                    Collections.swap(list, i4, i5);
                    i5++;
                }
                i4++;
            }
            if (i == i5) {
                int i6 = i5;
                while (true) {
                    if (i6 >= size) {
                        ssaInsn = null;
                        break;
                    }
                    ssaInsn = list.get(i6);
                    if (checkRegUsed(bitSet, ssaInsn.getResult()) && checkRegUsed(bitSet2, ssaInsn.getSources().get(0))) {
                        Collections.swap(list, i5, i6);
                        break;
                    }
                    i6++;
                }
                RegisterSpec result = ssaInsn.getResult();
                RegisterSpec registerSpecWithReg = result.withReg(this.parent.borrowSpareRegister(result.getCategory()));
                Rop ropOpMove = Rops.opMove(result.getType());
                SourcePosition sourcePosition = SourcePosition.NO_INFO;
                NormalSsaInsn normalSsaInsn = new NormalSsaInsn(new PlainInsn(ropOpMove, sourcePosition, registerSpecWithReg, ssaInsn.getSources()), this);
                int i7 = i5 + 1;
                list.add(i5, normalSsaInsn);
                list.set(i7, new NormalSsaInsn(new PlainInsn(Rops.opMove(result.getType()), sourcePosition, result, RegisterSpecList.make(registerSpecWithReg)), this));
                size = list.size();
                i = i7;
            } else {
                i = i5;
            }
            bitSet.clear();
            bitSet2.clear();
        }
    }

    private static void setRegsUsed(BitSet bitSet, RegisterSpec registerSpec) {
        bitSet.set(registerSpec.getReg());
        if (registerSpec.getCategory() > 1) {
            bitSet.set(registerSpec.getReg() + 1);
        }
    }

    public void addDomChild(SsaBasicBlock ssaBasicBlock) {
        this.domChildren.add(ssaBasicBlock);
    }

    public void addInsnToHead(Insn insn) {
        SsaInsn ssaInsnMakeFromRop = SsaInsn.makeFromRop(insn, this);
        this.insns.add(getCountPhiInsns(), ssaInsnMakeFromRop);
        this.parent.onInsnAdded(ssaInsnMakeFromRop);
    }

    public void addLiveIn(int i) {
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveIn.add(i);
    }

    public void addLiveOut(int i) {
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveOut.add(i);
    }

    public void addMoveToBeginning(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (registerSpec.getReg() == registerSpec2.getReg()) {
            return;
        }
        this.insns.add(getCountPhiInsns(), new NormalSsaInsn(new PlainInsn(Rops.opMove(registerSpec.getType()), SourcePosition.NO_INFO, registerSpec, RegisterSpecList.make(registerSpec2)), this));
        this.movesFromPhisAtBeginning++;
    }

    public void addMoveToEnd(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (this.successors.cardinality() > 1) {
            throw new IllegalStateException("Inserting a move to a block with multiple successors");
        }
        if (registerSpec.getReg() == registerSpec2.getReg()) {
            return;
        }
        NormalSsaInsn normalSsaInsn = (NormalSsaInsn) a.g(1, this.insns);
        if (normalSsaInsn.getResult() != null || normalSsaInsn.getSources().size() > 0) {
            int iNextSetBit = this.successors.nextSetBit(0);
            while (iNextSetBit >= 0) {
                this.parent.getBlocks().get(iNextSetBit).addMoveToBeginning(registerSpec, registerSpec2);
                iNextSetBit = this.successors.nextSetBit(iNextSetBit + 1);
            }
            return;
        }
        NormalSsaInsn normalSsaInsn2 = new NormalSsaInsn(new PlainInsn(Rops.opMove(registerSpec.getType()), SourcePosition.NO_INFO, registerSpec, RegisterSpecList.make(registerSpec2)), this);
        ArrayList<SsaInsn> arrayList = this.insns;
        arrayList.add(arrayList.size() - 1, normalSsaInsn2);
        this.movesFromPhisAtEnd++;
    }

    public void addPhiInsnForReg(int i) {
        this.insns.add(0, new PhiInsn(i, this));
    }

    public void exitBlockFixup(SsaBasicBlock ssaBasicBlock) {
        if (this != ssaBasicBlock && this.successorList.size() == 0) {
            this.successors.set(ssaBasicBlock.index);
            this.successorList.add(ssaBasicBlock.index);
            this.primarySuccessor = ssaBasicBlock.index;
            ssaBasicBlock.predecessors.set(this.index);
        }
    }

    public void forEachInsn(SsaInsn.Visitor visitor) {
        int size = this.insns.size();
        for (int i = 0; i < size; i++) {
            this.insns.get(i).accept(visitor);
        }
    }

    public void forEachPhiInsn(PhiInsn.Visitor visitor) {
        int size = this.insns.size();
        for (int i = 0; i < size; i++) {
            SsaInsn ssaInsn = this.insns.get(i);
            if (!(ssaInsn instanceof PhiInsn)) {
                return;
            }
            visitor.visitPhiInsn((PhiInsn) ssaInsn);
        }
    }

    public ArrayList<SsaBasicBlock> getDomChildren() {
        return this.domChildren;
    }

    public int getIndex() {
        return this.index;
    }

    public ArrayList<SsaInsn> getInsns() {
        return this.insns;
    }

    public IntSet getLiveInRegs() {
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveIn;
    }

    public IntSet getLiveOutRegs() {
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveOut;
    }

    public SsaMethod getParent() {
        return this.parent;
    }

    public List<SsaInsn> getPhiInsns() {
        return this.insns.subList(0, getCountPhiInsns());
    }

    public BitSet getPredecessors() {
        return this.predecessors;
    }

    public SsaBasicBlock getPrimarySuccessor() {
        if (this.primarySuccessor < 0) {
            return null;
        }
        return this.parent.getBlocks().get(this.primarySuccessor);
    }

    public int getPrimarySuccessorIndex() {
        return this.primarySuccessor;
    }

    public int getPrimarySuccessorRopLabel() {
        return this.parent.blockIndexToRopLabel(this.primarySuccessor);
    }

    public int getRopLabel() {
        return this.ropLabel;
    }

    public String getRopLabelString() {
        return Hex.u2(this.ropLabel);
    }

    public IntList getRopLabelSuccessorList() {
        IntList intList = new IntList(this.successorList.size());
        int size = this.successorList.size();
        for (int i = 0; i < size; i++) {
            intList.add(this.parent.blockIndexToRopLabel(this.successorList.get(i)));
        }
        return intList;
    }

    public IntList getSuccessorList() {
        return this.successorList;
    }

    public BitSet getSuccessors() {
        return this.successors;
    }

    public SsaBasicBlock insertNewPredecessor() {
        SsaBasicBlock ssaBasicBlockMakeNewGotoBlock = this.parent.makeNewGotoBlock();
        ssaBasicBlockMakeNewGotoBlock.predecessors = this.predecessors;
        ssaBasicBlockMakeNewGotoBlock.successors.set(this.index);
        ssaBasicBlockMakeNewGotoBlock.successorList.add(this.index);
        ssaBasicBlockMakeNewGotoBlock.primarySuccessor = this.index;
        BitSet bitSet = new BitSet(this.parent.getBlocks().size());
        this.predecessors = bitSet;
        bitSet.set(ssaBasicBlockMakeNewGotoBlock.index);
        for (int iNextSetBit = ssaBasicBlockMakeNewGotoBlock.predecessors.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = ssaBasicBlockMakeNewGotoBlock.predecessors.nextSetBit(iNextSetBit + 1)) {
            this.parent.getBlocks().get(iNextSetBit).replaceSuccessor(this.index, ssaBasicBlockMakeNewGotoBlock.index);
        }
        return ssaBasicBlockMakeNewGotoBlock;
    }

    public SsaBasicBlock insertNewSuccessor(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlockMakeNewGotoBlock = this.parent.makeNewGotoBlock();
        if (!this.successors.get(ssaBasicBlock.index)) {
            throw new RuntimeException("Block " + ssaBasicBlock.getRopLabelString() + " not successor of " + getRopLabelString());
        }
        ssaBasicBlockMakeNewGotoBlock.predecessors.set(this.index);
        ssaBasicBlockMakeNewGotoBlock.successors.set(ssaBasicBlock.index);
        ssaBasicBlockMakeNewGotoBlock.successorList.add(ssaBasicBlock.index);
        ssaBasicBlockMakeNewGotoBlock.primarySuccessor = ssaBasicBlock.index;
        for (int size = this.successorList.size() - 1; size >= 0; size--) {
            if (this.successorList.get(size) == ssaBasicBlock.index) {
                this.successorList.set(size, ssaBasicBlockMakeNewGotoBlock.index);
            }
        }
        int i = this.primarySuccessor;
        int i3 = ssaBasicBlock.index;
        if (i == i3) {
            this.primarySuccessor = ssaBasicBlockMakeNewGotoBlock.index;
        }
        this.successors.clear(i3);
        this.successors.set(ssaBasicBlockMakeNewGotoBlock.index);
        ssaBasicBlock.predecessors.set(ssaBasicBlockMakeNewGotoBlock.index);
        ssaBasicBlock.predecessors.set(this.index, this.successors.get(ssaBasicBlock.index));
        return ssaBasicBlockMakeNewGotoBlock;
    }

    public boolean isExitBlock() {
        return this.index == this.parent.getExitBlockIndex();
    }

    public void removeAllPhiInsns() {
        this.insns.subList(0, getCountPhiInsns()).clear();
    }

    public void removeSuccessor(int i) {
        int i3 = 0;
        for (int size = this.successorList.size() - 1; size >= 0; size--) {
            if (this.successorList.get(size) == i) {
                i3 = size;
            } else {
                this.primarySuccessor = this.successorList.get(size);
            }
        }
        this.successorList.removeIndex(i3);
        this.successors.clear(i);
        this.parent.getBlocks().get(i).predecessors.clear(this.index);
    }

    public void replaceLastInsn(Insn insn) {
        if (insn.getOpcode().getBranchingness() == 1) {
            throw new IllegalArgumentException("last insn must branch");
        }
        SsaInsn ssaInsn = (SsaInsn) a.g(1, this.insns);
        SsaInsn ssaInsnMakeFromRop = SsaInsn.makeFromRop(insn, this);
        ArrayList<SsaInsn> arrayList = this.insns;
        arrayList.set(arrayList.size() - 1, ssaInsnMakeFromRop);
        this.parent.onInsnRemoved(ssaInsn);
        this.parent.onInsnAdded(ssaInsnMakeFromRop);
    }

    public void replaceSuccessor(int i, int i3) {
        if (i == i3) {
            return;
        }
        this.successors.set(i3);
        if (this.primarySuccessor == i) {
            this.primarySuccessor = i3;
        }
        for (int size = this.successorList.size() - 1; size >= 0; size--) {
            if (this.successorList.get(size) == i) {
                this.successorList.set(size, i3);
            }
        }
        this.successors.clear(i);
        this.parent.getBlocks().get(i3).predecessors.set(this.index);
        this.parent.getBlocks().get(i).predecessors.clear(this.index);
    }

    public void scheduleMovesFromPhis() {
        int i = this.movesFromPhisAtBeginning;
        if (i > 1) {
            scheduleUseBeforeAssigned(this.insns.subList(0, i));
            if (this.insns.get(this.movesFromPhisAtBeginning).isMoveException()) {
                throw new RuntimeException("Unexpected: moves from phis before move-exception");
            }
        }
        if (this.movesFromPhisAtEnd > 1) {
            ArrayList<SsaInsn> arrayList = this.insns;
            scheduleUseBeforeAssigned(arrayList.subList((arrayList.size() - this.movesFromPhisAtEnd) - 1, this.insns.size() - 1));
        }
        this.parent.returnSpareRegisters();
    }

    public String toString() {
        return "{" + this.index + ":" + Hex.u2(this.ropLabel) + '}';
    }

    public void addPhiInsnForReg(RegisterSpec registerSpec) {
        this.insns.add(0, new PhiInsn(registerSpec, this));
    }
}
