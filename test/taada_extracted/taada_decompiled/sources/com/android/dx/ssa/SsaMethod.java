package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public final class SsaMethod {
    private boolean backMode = false;
    private ArrayList<SsaBasicBlock> blocks;
    private int borrowedSpareRegisters;
    private SsaInsn[] definitionList;
    private int entryBlockIndex;
    private int exitBlockIndex;
    private final boolean isStatic;
    private int maxLabel;
    private final int paramWidth;
    private int registerCount;
    private int spareRegisterBase;
    private List<SsaInsn>[] unmodifiableUseList;
    private ArrayList<SsaInsn>[] useList;

    private SsaMethod(RopMethod ropMethod, int i, boolean z6) {
        this.paramWidth = i;
        this.isStatic = z6;
        this.maxLabel = ropMethod.getBlocks().getMaxLabel();
        int regCount = ropMethod.getBlocks().getRegCount();
        this.registerCount = regCount;
        this.spareRegisterBase = regCount;
    }

    public static BitSet bitSetFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        BitSet bitSet = new BitSet(basicBlockList.size());
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            bitSet.set(basicBlockList.indexOfLabel(intList.get(i)));
        }
        return bitSet;
    }

    private void buildUseList() {
        if (this.backMode) {
            throw new RuntimeException("No use list in back mode");
        }
        this.useList = new ArrayList[this.registerCount];
        for (int i = 0; i < this.registerCount; i++) {
            this.useList[i] = new ArrayList<>();
        }
        forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.SsaMethod.2
            private void addToUses(SsaInsn ssaInsn) {
                RegisterSpecList sources = ssaInsn.getSources();
                int size = sources.size();
                for (int i3 = 0; i3 < size; i3++) {
                    SsaMethod.this.useList[sources.get(i3).getReg()].add(ssaInsn);
                }
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                addToUses(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                addToUses(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitPhiInsn(PhiInsn phiInsn) {
                addToUses(phiInsn);
            }
        });
        this.unmodifiableUseList = new List[this.registerCount];
        for (int i3 = 0; i3 < this.registerCount; i3++) {
            this.unmodifiableUseList[i3] = Collections.unmodifiableList(this.useList[i3]);
        }
    }

    private void convertRopToSsaBlocks(RopMethod ropMethod) {
        int size = ropMethod.getBlocks().size();
        this.blocks = new ArrayList<>(size + 2);
        for (int i = 0; i < size; i++) {
            this.blocks.add(SsaBasicBlock.newFromRop(ropMethod, i, this));
        }
        this.entryBlockIndex = this.blocks.get(ropMethod.getBlocks().indexOfLabel(ropMethod.getFirstLabel())).insertNewPredecessor().getIndex();
        this.exitBlockIndex = -1;
    }

    private static SsaInsn getGoto(SsaBasicBlock ssaBasicBlock) {
        return new NormalSsaInsn(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY), ssaBasicBlock);
    }

    public static IntList indexListFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        IntList intList2 = new IntList(intList.size());
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            intList2.add(basicBlockList.indexOfLabel(intList.get(i)));
        }
        return intList2;
    }

    public static SsaMethod newFromRopMethod(RopMethod ropMethod, int i, boolean z6) {
        SsaMethod ssaMethod = new SsaMethod(ropMethod, i, z6);
        ssaMethod.convertRopToSsaBlocks(ropMethod);
        return ssaMethod;
    }

    private void removeFromUseList(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        if (registerSpecList == null) {
            return;
        }
        int size = registerSpecList.size();
        for (int i = 0; i < size; i++) {
            if (!this.useList[registerSpecList.get(i).getReg()].remove(ssaInsn)) {
                throw new RuntimeException("use not found");
            }
        }
    }

    public int blockIndexToRopLabel(int i) {
        if (i < 0) {
            return -1;
        }
        return this.blocks.get(i).getRopLabel();
    }

    public int borrowSpareRegister(int i) {
        int i3 = this.spareRegisterBase;
        int i4 = this.borrowedSpareRegisters;
        int i5 = i3 + i4;
        this.borrowedSpareRegisters = i4 + i;
        this.registerCount = Math.max(this.registerCount, i + i5);
        return i5;
    }

    public BitSet computeReachability() {
        int size = this.blocks.size();
        BitSet bitSet = new BitSet(size);
        BitSet bitSet2 = new BitSet(size);
        bitSet.set(getEntryBlock().getIndex());
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(0);
            if (iNextSetBit == -1) {
                return bitSet2;
            }
            bitSet2.set(iNextSetBit);
            bitSet.or(this.blocks.get(iNextSetBit).getSuccessors());
            bitSet.andNot(bitSet2);
        }
    }

    public void deleteInsns(Set<SsaInsn> set) {
        for (SsaInsn ssaInsn : set) {
            SsaBasicBlock block = ssaInsn.getBlock();
            ArrayList<SsaInsn> insns = block.getInsns();
            int size = insns.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                SsaInsn ssaInsn2 = insns.get(size);
                if (ssaInsn == ssaInsn2) {
                    onInsnRemoved(ssaInsn2);
                    insns.remove(size);
                    break;
                }
                size--;
            }
            int size2 = insns.size();
            SsaInsn ssaInsn3 = size2 == 0 ? null : insns.get(size2 - 1);
            if (block != getExitBlock() && (size2 == 0 || ssaInsn3.getOriginalRopInsn() == null || ssaInsn3.getOriginalRopInsn().getOpcode().getBranchingness() == 1)) {
                insns.add(SsaInsn.makeFromRop(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY), block));
                BitSet successors = block.getSuccessors();
                for (int iNextSetBit = successors.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = successors.nextSetBit(iNextSetBit + 1)) {
                    if (iNextSetBit != block.getPrimarySuccessorIndex()) {
                        block.removeSuccessor(iNextSetBit);
                    }
                }
            }
        }
    }

    public void forEachBlockDepthFirst(boolean z6, SsaBasicBlock.Visitor visitor) {
        BitSet bitSet = new BitSet(this.blocks.size());
        Stack stack = new Stack();
        SsaBasicBlock exitBlock = z6 ? getExitBlock() : getEntryBlock();
        if (exitBlock == null) {
            return;
        }
        stack.add(null);
        stack.add(exitBlock);
        while (stack.size() > 0) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack.pop();
            SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) stack.pop();
            if (!bitSet.get(ssaBasicBlock.getIndex())) {
                BitSet predecessors = z6 ? ssaBasicBlock.getPredecessors() : ssaBasicBlock.getSuccessors();
                for (int iNextSetBit = predecessors.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = predecessors.nextSetBit(iNextSetBit + 1)) {
                    stack.add(ssaBasicBlock);
                    stack.add(this.blocks.get(iNextSetBit));
                }
                bitSet.set(ssaBasicBlock.getIndex());
                visitor.visitBlock(ssaBasicBlock, ssaBasicBlock2);
            }
        }
    }

    public void forEachBlockDepthFirstDom(SsaBasicBlock.Visitor visitor) {
        BitSet bitSet = new BitSet(getBlocks().size());
        Stack stack = new Stack();
        stack.add(getEntryBlock());
        while (stack.size() > 0) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack.pop();
            ArrayList<SsaBasicBlock> domChildren = ssaBasicBlock.getDomChildren();
            if (!bitSet.get(ssaBasicBlock.getIndex())) {
                for (int size = domChildren.size() - 1; size >= 0; size--) {
                    stack.add(domChildren.get(size));
                }
                bitSet.set(ssaBasicBlock.getIndex());
                visitor.visitBlock(ssaBasicBlock, null);
            }
        }
    }

    public void forEachInsn(SsaInsn.Visitor visitor) {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().forEachInsn(visitor);
        }
    }

    public void forEachPhiInsn(PhiInsn.Visitor visitor) {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().forEachPhiInsn(visitor);
        }
    }

    public ArrayList<SsaBasicBlock> getBlocks() {
        return this.blocks;
    }

    public SsaInsn getDefinitionForRegister(int i) {
        if (this.backMode) {
            throw new RuntimeException("No def list in back mode");
        }
        SsaInsn[] ssaInsnArr = this.definitionList;
        if (ssaInsnArr != null) {
            return ssaInsnArr[i];
        }
        this.definitionList = new SsaInsn[getRegCount()];
        forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.SsaMethod.1
            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                SsaMethod.this.definitionList[normalSsaInsn.getResult().getReg()] = normalSsaInsn;
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                if (normalSsaInsn.getResult() != null) {
                    SsaMethod.this.definitionList[normalSsaInsn.getResult().getReg()] = normalSsaInsn;
                }
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitPhiInsn(PhiInsn phiInsn) {
                SsaMethod.this.definitionList[phiInsn.getResult().getReg()] = phiInsn;
            }
        });
        return this.definitionList[i];
    }

    public SsaBasicBlock getEntryBlock() {
        return this.blocks.get(this.entryBlockIndex);
    }

    public int getEntryBlockIndex() {
        return this.entryBlockIndex;
    }

    public SsaBasicBlock getExitBlock() {
        int i = this.exitBlockIndex;
        if (i < 0) {
            return null;
        }
        return this.blocks.get(i);
    }

    public int getExitBlockIndex() {
        return this.exitBlockIndex;
    }

    public int getParamWidth() {
        return this.paramWidth;
    }

    public int getRegCount() {
        return this.registerCount;
    }

    public ArrayList<SsaInsn>[] getUseListCopy() {
        if (this.useList == null) {
            buildUseList();
        }
        ArrayList<SsaInsn>[] arrayListArr = new ArrayList[this.registerCount];
        for (int i = 0; i < this.registerCount; i++) {
            arrayListArr[i] = new ArrayList<>(this.useList[i]);
        }
        return arrayListArr;
    }

    public List<SsaInsn> getUseListForRegister(int i) {
        if (this.unmodifiableUseList == null) {
            buildUseList();
        }
        return this.unmodifiableUseList[i];
    }

    public boolean isRegALocal(RegisterSpec registerSpec) {
        SsaInsn definitionForRegister = getDefinitionForRegister(registerSpec.getReg());
        if (definitionForRegister == null) {
            return false;
        }
        if (definitionForRegister.getLocalAssignment() != null) {
            return true;
        }
        Iterator<SsaInsn> it = getUseListForRegister(registerSpec.getReg()).iterator();
        while (it.hasNext()) {
            Insn originalRopInsn = it.next().getOriginalRopInsn();
            if (originalRopInsn != null && originalRopInsn.getOpcode().getOpcode() == 54) {
                return true;
            }
        }
        return false;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    public void makeExitBlock() {
        if (this.exitBlockIndex >= 0) {
            throw new RuntimeException("must be called at most once");
        }
        this.exitBlockIndex = this.blocks.size();
        int i = this.exitBlockIndex;
        int i3 = this.maxLabel;
        this.maxLabel = i3 + 1;
        SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(i, i3, this);
        this.blocks.add(ssaBasicBlock);
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().exitBlockFixup(ssaBasicBlock);
        }
        if (ssaBasicBlock.getPredecessors().cardinality() == 0) {
            this.blocks.remove(this.exitBlockIndex);
            this.exitBlockIndex = -1;
            this.maxLabel--;
        }
    }

    public SsaBasicBlock makeNewGotoBlock() {
        int size = this.blocks.size();
        int i = this.maxLabel;
        this.maxLabel = i + 1;
        SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(size, i, this);
        ssaBasicBlock.getInsns().add(getGoto(ssaBasicBlock));
        this.blocks.add(ssaBasicBlock);
        return ssaBasicBlock;
    }

    public int makeNewSsaReg() {
        int i = this.registerCount;
        int i3 = i + 1;
        this.registerCount = i3;
        this.spareRegisterBase = i3;
        onInsnsChanged();
        return i;
    }

    public void mapRegisters(RegisterMapper registerMapper) {
        Iterator<SsaBasicBlock> it = getBlocks().iterator();
        while (it.hasNext()) {
            Iterator<SsaInsn> it2 = it.next().getInsns().iterator();
            while (it2.hasNext()) {
                it2.next().mapRegisters(registerMapper);
            }
        }
        int newRegisterCount = registerMapper.getNewRegisterCount();
        this.registerCount = newRegisterCount;
        this.spareRegisterBase = newRegisterCount;
    }

    public void onInsnAdded(SsaInsn ssaInsn) {
        onSourcesChanged(ssaInsn, null);
        updateOneDefinition(ssaInsn, null);
    }

    public void onInsnRemoved(SsaInsn ssaInsn) {
        if (this.useList != null) {
            removeFromUseList(ssaInsn, ssaInsn.getSources());
        }
        RegisterSpec result = ssaInsn.getResult();
        SsaInsn[] ssaInsnArr = this.definitionList;
        if (ssaInsnArr == null || result == null) {
            return;
        }
        ssaInsnArr[result.getReg()] = null;
    }

    public void onInsnsChanged() {
        this.definitionList = null;
        this.useList = null;
        this.unmodifiableUseList = null;
    }

    public void onSourceChanged(SsaInsn ssaInsn, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (this.useList == null) {
            return;
        }
        if (registerSpec != null) {
            this.useList[registerSpec.getReg()].remove(ssaInsn);
        }
        int reg = registerSpec2.getReg();
        ArrayList<SsaInsn>[] arrayListArr = this.useList;
        if (arrayListArr.length <= reg) {
            this.useList = null;
        } else {
            arrayListArr[reg].add(ssaInsn);
        }
    }

    public void onSourcesChanged(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        if (this.useList == null) {
            return;
        }
        if (registerSpecList != null) {
            removeFromUseList(ssaInsn, registerSpecList);
        }
        RegisterSpecList sources = ssaInsn.getSources();
        int size = sources.size();
        for (int i = 0; i < size; i++) {
            this.useList[sources.get(i).getReg()].add(ssaInsn);
        }
    }

    public void returnSpareRegisters() {
        this.borrowedSpareRegisters = 0;
    }

    public void setBackMode() {
        this.backMode = true;
        this.useList = null;
        this.definitionList = null;
    }

    public void setNewRegCount(int i) {
        this.registerCount = i;
        this.spareRegisterBase = i;
        onInsnsChanged();
    }

    public void updateOneDefinition(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        if (this.definitionList == null) {
            return;
        }
        if (registerSpec != null) {
            this.definitionList[registerSpec.getReg()] = null;
        }
        RegisterSpec result = ssaInsn.getResult();
        if (result != null) {
            int reg = result.getReg();
            SsaInsn[] ssaInsnArr = this.definitionList;
            if (ssaInsnArr[reg] != null) {
                throw new RuntimeException("Duplicate add of insn");
            }
            ssaInsnArr[result.getReg()] = ssaInsn;
        }
    }
}
