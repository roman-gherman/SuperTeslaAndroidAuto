package com.android.dx.ssa.back;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.InterferenceRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.IntIterator;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class FirstFitLocalCombiningAllocator extends RegisterAllocator {
    private static final boolean DEBUG = false;
    private final ArrayList<NormalSsaInsn> invokeRangeInsns;
    private final Map<LocalItem, ArrayList<RegisterSpec>> localVariables;
    private final InterferenceRegisterMapper mapper;
    private final boolean minimizeRegisters;
    private final ArrayList<NormalSsaInsn> moveResultPseudoInsns;
    private final int paramRangeEnd;
    private final ArrayList<PhiInsn> phiInsns;
    private final BitSet reservedRopRegs;
    private final BitSet ssaRegsMapped;
    private final BitSet usedRopRegs;

    public enum Alignment {
        EVEN { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.1
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            public int nextClearBit(BitSet bitSet, int i) {
                int iNextClearBit = bitSet.nextClearBit(i);
                while (!FirstFitLocalCombiningAllocator.isEven(iNextClearBit)) {
                    iNextClearBit = bitSet.nextClearBit(iNextClearBit + 1);
                }
                return iNextClearBit;
            }
        },
        ODD { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.2
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            public int nextClearBit(BitSet bitSet, int i) {
                int iNextClearBit = bitSet.nextClearBit(i);
                while (FirstFitLocalCombiningAllocator.isEven(iNextClearBit)) {
                    iNextClearBit = bitSet.nextClearBit(iNextClearBit + 1);
                }
                return iNextClearBit;
            }
        },
        UNSPECIFIED { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.3
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            public int nextClearBit(BitSet bitSet, int i) {
                return bitSet.nextClearBit(i);
            }
        };

        public abstract int nextClearBit(BitSet bitSet, int i);
    }

    public static class Multiset {
        private final int[] count;
        private final int[] reg;
        private int size = 0;

        public Multiset(int i) {
            this.reg = new int[i];
            this.count = new int[i];
        }

        public void add(int i) {
            int i3 = 0;
            while (true) {
                int i4 = this.size;
                if (i3 >= i4) {
                    this.reg[i4] = i;
                    this.count[i4] = 1;
                    this.size = i4 + 1;
                    return;
                } else {
                    if (this.reg[i3] == i) {
                        int[] iArr = this.count;
                        iArr[i3] = iArr[i3] + 1;
                        return;
                    }
                    i3++;
                }
            }
        }

        public int getAndRemoveHighestCount() {
            int i = -1;
            int i3 = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < this.size; i5++) {
                int i6 = this.count[i5];
                if (i4 < i6) {
                    i3 = this.reg[i5];
                    i = i5;
                    i4 = i6;
                }
            }
            this.count[i] = 0;
            return i3;
        }

        public int getSize() {
            return this.size;
        }
    }

    public FirstFitLocalCombiningAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph, boolean z6) {
        super(ssaMethod, interferenceGraph);
        this.ssaRegsMapped = new BitSet(ssaMethod.getRegCount());
        this.mapper = new InterferenceRegisterMapper(interferenceGraph, ssaMethod.getRegCount());
        this.minimizeRegisters = z6;
        int paramWidth = ssaMethod.getParamWidth();
        this.paramRangeEnd = paramWidth;
        BitSet bitSet = new BitSet(paramWidth * 2);
        this.reservedRopRegs = bitSet;
        bitSet.set(0, paramWidth);
        this.usedRopRegs = new BitSet(paramWidth * 2);
        this.localVariables = new TreeMap();
        this.moveResultPseudoInsns = new ArrayList<>();
        this.invokeRangeInsns = new ArrayList<>();
        this.phiInsns = new ArrayList<>();
    }

    private void addMapping(RegisterSpec registerSpec, int i) {
        int reg = registerSpec.getReg();
        if (this.ssaRegsMapped.get(reg) || !canMapReg(registerSpec, i)) {
            throw new RuntimeException("attempt to add invalid register mapping");
        }
        int category = registerSpec.getCategory();
        this.mapper.addMapping(registerSpec.getReg(), i, category);
        this.ssaRegsMapped.set(reg);
        this.usedRopRegs.set(i, category + i);
    }

    private void adjustAndMapSourceRangeRange(NormalSsaInsn normalSsaInsn) {
        int iFindRangeAndAdjust = findRangeAndAdjust(normalSsaInsn);
        RegisterSpecList sources = normalSsaInsn.getSources();
        int size = sources.size();
        int i = 0;
        while (i < size) {
            RegisterSpec registerSpec = sources.get(i);
            int reg = registerSpec.getReg();
            int category = registerSpec.getCategory();
            int i3 = iFindRangeAndAdjust + category;
            if (!this.ssaRegsMapped.get(reg)) {
                LocalItem localItemForReg = getLocalItemForReg(reg);
                addMapping(registerSpec, iFindRangeAndAdjust);
                if (localItemForReg != null) {
                    markReserved(iFindRangeAndAdjust, category);
                    ArrayList<RegisterSpec> arrayList = this.localVariables.get(localItemForReg);
                    int size2 = arrayList.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        RegisterSpec registerSpec2 = arrayList.get(i4);
                        if (-1 == sources.indexOfRegister(registerSpec2.getReg())) {
                            tryMapReg(registerSpec2, iFindRangeAndAdjust, category);
                        }
                    }
                }
            }
            i++;
            iFindRangeAndAdjust = i3;
        }
    }

    private void analyzeInstructions() {
        this.ssaMeth.forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.1
            private void processInsn(SsaInsn ssaInsn) {
                RegisterSpec localAssignment = ssaInsn.getLocalAssignment();
                if (localAssignment != null) {
                    LocalItem localItem = localAssignment.getLocalItem();
                    ArrayList arrayList = (ArrayList) FirstFitLocalCombiningAllocator.this.localVariables.get(localItem);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        FirstFitLocalCombiningAllocator.this.localVariables.put(localItem, arrayList);
                    }
                    arrayList.add(localAssignment);
                }
                if (!(ssaInsn instanceof NormalSsaInsn)) {
                    if (ssaInsn instanceof PhiInsn) {
                        FirstFitLocalCombiningAllocator.this.phiInsns.add((PhiInsn) ssaInsn);
                    }
                } else if (ssaInsn.getOpcode().getOpcode() == 56) {
                    FirstFitLocalCombiningAllocator.this.moveResultPseudoInsns.add((NormalSsaInsn) ssaInsn);
                } else if (Optimizer.getAdvice().requiresSourcesInOrder(ssaInsn.getOriginalRopInsn().getOpcode(), ssaInsn.getSources())) {
                    FirstFitLocalCombiningAllocator.this.invokeRangeInsns.add((NormalSsaInsn) ssaInsn);
                }
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitPhiInsn(PhiInsn phiInsn) {
                processInsn(phiInsn);
            }
        });
    }

    private boolean canMapReg(RegisterSpec registerSpec, int i) {
        return (spansParamRange(i, registerSpec.getCategory()) || this.mapper.interferes(registerSpec, i)) ? false : true;
    }

    private boolean canMapRegs(ArrayList<RegisterSpec> arrayList, int i) {
        for (RegisterSpec registerSpec : arrayList) {
            if (!this.ssaRegsMapped.get(registerSpec.getReg()) && !canMapReg(registerSpec, i)) {
                return false;
            }
        }
        return true;
    }

    private int findAnyFittingRange(NormalSsaInsn normalSsaInsn, int i, int[] iArr, BitSet bitSet) {
        Alignment alignment = Alignment.UNSPECIFIED;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 : iArr) {
            if (i6 == 2) {
                if (isEven(i5)) {
                    i4++;
                } else {
                    i3++;
                }
                i5 += 2;
            } else {
                i5++;
            }
        }
        if (i3 > i4) {
            alignment = isEven(this.paramRangeEnd) ? Alignment.ODD : Alignment.EVEN;
        } else if (i4 > 0) {
            alignment = isEven(this.paramRangeEnd) ? Alignment.EVEN : Alignment.ODD;
        }
        int i7 = this.paramRangeEnd;
        while (true) {
            int iFindNextUnreservedRopReg = findNextUnreservedRopReg(i7, i, alignment);
            if (fitPlanForRange(iFindNextUnreservedRopReg, normalSsaInsn, iArr, bitSet) >= 0) {
                return iFindNextUnreservedRopReg;
            }
            i7 = iFindNextUnreservedRopReg + 1;
            bitSet.clear();
        }
    }

    private int findNextUnreservedRopReg(int i, int i3) {
        return findNextUnreservedRopReg(i, i3, getAlignment(i3));
    }

    private int findRangeAndAdjust(NormalSsaInsn normalSsaInsn) {
        int iOldToNew;
        BitSet bitSet;
        int iFitPlanForRange;
        RegisterSpecList sources = normalSsaInsn.getSources();
        int size = sources.size();
        int[] iArr = new int[size];
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int category = sources.get(i3).getCategory();
            iArr[i3] = category;
            i += category;
        }
        int i4 = Integer.MIN_VALUE;
        BitSet bitSet2 = null;
        int iFindAnyFittingRange = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            int reg = sources.get(i6).getReg();
            if (i6 != 0) {
                i5 -= iArr[i6 - 1];
            }
            if (this.ssaRegsMapped.get(reg) && (iOldToNew = this.mapper.oldToNew(reg) + i5) >= 0 && !spansParamRange(iOldToNew, i) && (iFitPlanForRange = fitPlanForRange(iOldToNew, normalSsaInsn, iArr, (bitSet = new BitSet(size)))) >= 0) {
                int iCardinality = iFitPlanForRange - bitSet.cardinality();
                if (iCardinality > i4) {
                    i4 = iCardinality;
                    iFindAnyFittingRange = iOldToNew;
                    bitSet2 = bitSet;
                }
                if (iFitPlanForRange == i) {
                    break;
                }
            }
        }
        if (iFindAnyFittingRange == -1) {
            bitSet2 = new BitSet(size);
            iFindAnyFittingRange = findAnyFittingRange(normalSsaInsn, i, iArr, bitSet2);
        }
        for (int iNextSetBit = bitSet2.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = bitSet2.nextSetBit(iNextSetBit + 1)) {
            normalSsaInsn.changeOneSource(iNextSetBit, insertMoveBefore(normalSsaInsn, sources.get(iNextSetBit)));
        }
        return iFindAnyFittingRange;
    }

    private int findRopRegForLocal(int i, int i3) {
        Alignment alignment = getAlignment(i3);
        int iNextClearBit = alignment.nextClearBit(this.usedRopRegs, i);
        while (true) {
            int i4 = 1;
            while (i4 < i3 && !this.usedRopRegs.get(iNextClearBit + i4)) {
                i4++;
            }
            if (i4 == i3) {
                return iNextClearBit;
            }
            iNextClearBit = alignment.nextClearBit(this.usedRopRegs, iNextClearBit + i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int fitPlanForRange(int r11, com.android.dx.ssa.NormalSsaInsn r12, int[] r13, java.util.BitSet r14) {
        /*
            r10 = this;
            com.android.dx.rop.code.RegisterSpecList r0 = r12.getSources()
            int r1 = r0.size()
            com.android.dx.ssa.SsaBasicBlock r12 = r12.getBlock()
            com.android.dx.util.IntSet r12 = r12.getLiveOutRegs()
            com.android.dx.rop.code.RegisterSpecList r12 = r10.ssaSetToSpecs(r12)
            java.util.BitSet r2 = new java.util.BitSet
            com.android.dx.ssa.SsaMethod r3 = r10.ssaMeth
            int r3 = r3.getRegCount()
            r2.<init>(r3)
            r3 = 0
            r4 = r3
        L21:
            if (r3 >= r1) goto L7d
            com.android.dx.rop.code.RegisterSpec r5 = r0.get(r3)
            int r6 = r5.getReg()
            r7 = r13[r3]
            if (r3 == 0) goto L34
            int r8 = r3 + (-1)
            r8 = r13[r8]
            int r11 = r11 + r8
        L34:
            java.util.BitSet r8 = r10.ssaRegsMapped
            boolean r8 = r8.get(r6)
            if (r8 == 0) goto L46
            com.android.dx.ssa.InterferenceRegisterMapper r8 = r10.mapper
            int r8 = r8.oldToNew(r6)
            if (r8 != r11) goto L46
        L44:
            int r4 = r4 + r7
            goto L76
        L46:
            boolean r8 = r10.rangeContainsReserved(r11, r7)
            r9 = -1
            if (r8 == 0) goto L4e
            return r9
        L4e:
            java.util.BitSet r8 = r10.ssaRegsMapped
            boolean r8 = r8.get(r6)
            if (r8 != 0) goto L63
            boolean r5 = r10.canMapReg(r5, r11)
            if (r5 == 0) goto L63
            boolean r5 = r2.get(r6)
            if (r5 != 0) goto L63
            goto L44
        L63:
            com.android.dx.ssa.InterferenceRegisterMapper r5 = r10.mapper
            boolean r5 = r5.areAnyPinned(r12, r11, r7)
            if (r5 != 0) goto L7c
            com.android.dx.ssa.InterferenceRegisterMapper r5 = r10.mapper
            boolean r5 = r5.areAnyPinned(r0, r11, r7)
            if (r5 != 0) goto L7c
            r14.set(r3)
        L76:
            r2.set(r6)
            int r3 = r3 + 1
            goto L21
        L7c:
            return r9
        L7d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.fitPlanForRange(int, com.android.dx.ssa.NormalSsaInsn, int[], java.util.BitSet):int");
    }

    private Alignment getAlignment(int i) {
        return i == 2 ? isEven(this.paramRangeEnd) ? Alignment.EVEN : Alignment.ODD : Alignment.UNSPECIFIED;
    }

    private LocalItem getLocalItemForReg(int i) {
        for (Map.Entry<LocalItem, ArrayList<RegisterSpec>> entry : this.localVariables.entrySet()) {
            Iterator<RegisterSpec> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (it.next().getReg() == i) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private int getParameterIndexForReg(int i) {
        Rop opcode;
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
        if (definitionForRegister == null || (opcode = definitionForRegister.getOpcode()) == null || opcode.getOpcode() != 3) {
            return -1;
        }
        return ((CstInteger) ((CstInsn) definitionForRegister.getOriginalRopInsn()).getConstant()).getValue();
    }

    private void handleCheckCastResults() {
        for (NormalSsaInsn normalSsaInsn : this.moveResultPseudoInsns) {
            RegisterSpec result = normalSsaInsn.getResult();
            int reg = result.getReg();
            BitSet predecessors = normalSsaInsn.getBlock().getPredecessors();
            if (predecessors.cardinality() == 1) {
                SsaInsn ssaInsn = (SsaInsn) a.g(1, this.ssaMeth.getBlocks().get(predecessors.nextSetBit(0)).getInsns());
                if (ssaInsn.getOpcode().getOpcode() == 43) {
                    RegisterSpec registerSpec = ssaInsn.getSources().get(0);
                    int reg2 = registerSpec.getReg();
                    int category = registerSpec.getCategory();
                    boolean zTryMapReg = this.ssaRegsMapped.get(reg);
                    boolean zTryMapReg2 = this.ssaRegsMapped.get(reg2);
                    if ((!zTryMapReg2) & zTryMapReg) {
                        zTryMapReg2 = tryMapReg(registerSpec, this.mapper.oldToNew(reg), category);
                    }
                    if ((!zTryMapReg) & zTryMapReg2) {
                        zTryMapReg = tryMapReg(result, this.mapper.oldToNew(reg2), category);
                    }
                    if (!zTryMapReg || !zTryMapReg2) {
                        int iFindNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
                        ArrayList<RegisterSpec> arrayList = new ArrayList<>(2);
                        arrayList.add(result);
                        arrayList.add(registerSpec);
                        while (!tryMapRegs(arrayList, iFindNextUnreservedRopReg, category, false)) {
                            iFindNextUnreservedRopReg = findNextUnreservedRopReg(iFindNextUnreservedRopReg + 1, category);
                        }
                    }
                    boolean z6 = ssaInsn.getOriginalRopInsn().getCatches().size() != 0;
                    int iOldToNew = this.mapper.oldToNew(reg);
                    if (iOldToNew != this.mapper.oldToNew(reg2) && !z6) {
                        ((NormalSsaInsn) ssaInsn).changeOneSource(0, insertMoveBefore(ssaInsn, registerSpec));
                        addMapping(ssaInsn.getSources().get(0), iOldToNew);
                    }
                }
            }
        }
    }

    private void handleInvokeRangeInsns() {
        Iterator<NormalSsaInsn> it = this.invokeRangeInsns.iterator();
        while (it.hasNext()) {
            adjustAndMapSourceRangeRange(it.next());
        }
    }

    private void handleLocalAssociatedOther() {
        for (ArrayList<RegisterSpec> arrayList : this.localVariables.values()) {
            int i = this.paramRangeEnd;
            boolean zTryMapRegs = false;
            do {
                int size = arrayList.size();
                int i3 = 1;
                for (int i4 = 0; i4 < size; i4++) {
                    RegisterSpec registerSpec = arrayList.get(i4);
                    int category = registerSpec.getCategory();
                    if (!this.ssaRegsMapped.get(registerSpec.getReg()) && category > i3) {
                        i3 = category;
                    }
                }
                int iFindRopRegForLocal = findRopRegForLocal(i, i3);
                if (canMapRegs(arrayList, iFindRopRegForLocal)) {
                    zTryMapRegs = tryMapRegs(arrayList, iFindRopRegForLocal, i3, true);
                }
                i = iFindRopRegForLocal + 1;
            } while (!zTryMapRegs);
        }
    }

    private void handleLocalAssociatedParams() {
        for (ArrayList<RegisterSpec> arrayList : this.localVariables.values()) {
            int size = arrayList.size();
            int category = 0;
            int i = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                RegisterSpec registerSpec = arrayList.get(i3);
                int parameterIndexForReg = getParameterIndexForReg(registerSpec.getReg());
                if (parameterIndexForReg >= 0) {
                    category = registerSpec.getCategory();
                    addMapping(registerSpec, parameterIndexForReg);
                    i = parameterIndexForReg;
                    break;
                }
                i3++;
                i = parameterIndexForReg;
            }
            if (i >= 0) {
                tryMapRegs(arrayList, i, category, true);
            }
        }
    }

    private void handleNormalUnassociated() {
        RegisterSpec definitionSpecForSsaReg;
        int regCount = this.ssaMeth.getRegCount();
        for (int i = 0; i < regCount; i++) {
            if (!this.ssaRegsMapped.get(i) && (definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i)) != null) {
                int category = definitionSpecForSsaReg.getCategory();
                int iFindNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
                while (!canMapReg(definitionSpecForSsaReg, iFindNextUnreservedRopReg)) {
                    iFindNextUnreservedRopReg = findNextUnreservedRopReg(iFindNextUnreservedRopReg + 1, category);
                }
                addMapping(definitionSpecForSsaReg, iFindNextUnreservedRopReg);
            }
        }
    }

    private void handlePhiInsns() {
        Iterator<PhiInsn> it = this.phiInsns.iterator();
        while (it.hasNext()) {
            processPhiInsn(it.next());
        }
    }

    private void handleUnassociatedParameters() {
        int regCount = this.ssaMeth.getRegCount();
        for (int i = 0; i < regCount; i++) {
            if (!this.ssaRegsMapped.get(i)) {
                int parameterIndexForReg = getParameterIndexForReg(i);
                RegisterSpec definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i);
                if (parameterIndexForReg >= 0) {
                    addMapping(definitionSpecForSsaReg, parameterIndexForReg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEven(int i) {
        return (i & 1) == 0;
    }

    private boolean isThisPointerReg(int i) {
        return i == 0 && !this.ssaMeth.isStatic();
    }

    private void markReserved(int i, int i3) {
        this.reservedRopRegs.set(i, i3 + i, true);
    }

    private void printLocalVars() {
        System.out.println("Printing local vars");
        for (Map.Entry<LocalItem, ArrayList<RegisterSpec>> entry : this.localVariables.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            sb.append(' ');
            for (RegisterSpec registerSpec : entry.getValue()) {
                sb.append('v');
                sb.append(registerSpec.getReg());
                sb.append(' ');
            }
            sb.append('}');
            System.out.printf("Local: %s Registers: %s\n", entry.getKey(), sb);
        }
    }

    private void processPhiInsn(PhiInsn phiInsn) {
        RegisterSpec result = phiInsn.getResult();
        int reg = result.getReg();
        int category = result.getCategory();
        RegisterSpecList sources = phiInsn.getSources();
        int size = sources.size();
        ArrayList<RegisterSpec> arrayList = new ArrayList<>();
        Multiset multiset = new Multiset(size + 1);
        if (this.ssaRegsMapped.get(reg)) {
            multiset.add(this.mapper.oldToNew(reg));
        } else {
            arrayList.add(result);
        }
        for (int i = 0; i < size; i++) {
            RegisterSpec result2 = this.ssaMeth.getDefinitionForRegister(sources.get(i).getReg()).getResult();
            int reg2 = result2.getReg();
            if (this.ssaRegsMapped.get(reg2)) {
                multiset.add(this.mapper.oldToNew(reg2));
            } else {
                arrayList.add(result2);
            }
        }
        for (int i3 = 0; i3 < multiset.getSize(); i3++) {
            tryMapRegs(arrayList, multiset.getAndRemoveHighestCount(), category, false);
        }
        int iFindNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
        while (!tryMapRegs(arrayList, iFindNextUnreservedRopReg, category, false)) {
            iFindNextUnreservedRopReg = findNextUnreservedRopReg(iFindNextUnreservedRopReg + 1, category);
        }
    }

    private boolean rangeContainsReserved(int i, int i3) {
        for (int i4 = i; i4 < i + i3; i4++) {
            if (this.reservedRopRegs.get(i4)) {
                return true;
            }
        }
        return false;
    }

    private boolean spansParamRange(int i, int i3) {
        int i4 = this.paramRangeEnd;
        return i < i4 && i + i3 > i4;
    }

    private boolean tryMapReg(RegisterSpec registerSpec, int i, int i3) {
        if (registerSpec.getCategory() > i3 || this.ssaRegsMapped.get(registerSpec.getReg()) || !canMapReg(registerSpec, i)) {
            return false;
        }
        addMapping(registerSpec, i);
        return true;
    }

    private boolean tryMapRegs(ArrayList<RegisterSpec> arrayList, int i, int i3, boolean z6) {
        boolean z7 = false;
        for (RegisterSpec registerSpec : arrayList) {
            if (!this.ssaRegsMapped.get(registerSpec.getReg())) {
                boolean zTryMapReg = tryMapReg(registerSpec, i, i3);
                z7 = !zTryMapReg || z7;
                if (zTryMapReg && z6) {
                    markReserved(i, registerSpec.getCategory());
                }
            }
        }
        return !z7;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public RegisterMapper allocateRegisters() {
        analyzeInstructions();
        handleLocalAssociatedParams();
        handleUnassociatedParameters();
        handleInvokeRangeInsns();
        handleLocalAssociatedOther();
        handleCheckCastResults();
        handlePhiInsns();
        handleNormalUnassociated();
        return this.mapper;
    }

    public RegisterSpecList ssaSetToSpecs(IntSet intSet) {
        RegisterSpecList registerSpecList = new RegisterSpecList(intSet.elements());
        IntIterator it = intSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            registerSpecList.set(i, getDefinitionSpecForSsaReg(it.next()));
            i++;
        }
        return registerSpecList;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public boolean wantsParamsMovedHigh() {
        return true;
    }

    private int findNextUnreservedRopReg(int i, int i3, Alignment alignment) {
        int iNextClearBit = alignment.nextClearBit(this.reservedRopRegs, i);
        while (true) {
            int i4 = 1;
            while (i4 < i3 && !this.reservedRopRegs.get(iNextClearBit + i4)) {
                i4++;
            }
            if (i4 == i3) {
                return iNextClearBit;
            }
            iNextClearBit = alignment.nextClearBit(this.reservedRopRegs, iNextClearBit + i4);
        }
    }
}
