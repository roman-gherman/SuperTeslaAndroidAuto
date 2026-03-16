package com.android.dx.cf.code;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.dex.DexOptions;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Bits;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Ropper {
    private static final int PARAM_ASSIGNMENT = -1;
    private static final int RETURN = -2;
    private static final int SPECIAL_LABEL_COUNT = 7;
    private static final int SYNCH_CATCH_1 = -6;
    private static final int SYNCH_CATCH_2 = -7;
    private static final int SYNCH_RETURN = -3;
    private static final int SYNCH_SETUP_1 = -4;
    private static final int SYNCH_SETUP_2 = -5;
    private final ByteBlockList blocks;
    private final CatchInfo[] catchInfos;
    private final ExceptionSetupLabelAllocator exceptionSetupLabelAllocator;
    private boolean hasSubroutines;
    private final RopperMachine machine;
    private final int maxLabel;
    private final int maxLocals;
    private final ConcreteMethod method;
    private final ArrayList<BasicBlock> result;
    private final ArrayList<IntList> resultSubroutines;
    private final Simulator sim;
    private final Frame[] startFrames;
    private final Subroutine[] subroutines;
    private boolean synchNeedsExceptionHandler;

    public class CatchInfo {
        private final Map<Type, ExceptionHandlerSetup> setups;

        private CatchInfo() {
            this.setups = new HashMap();
        }

        public ExceptionHandlerSetup getSetup(Type type) {
            ExceptionHandlerSetup exceptionHandlerSetup = this.setups.get(type);
            if (exceptionHandlerSetup != null) {
                return exceptionHandlerSetup;
            }
            ExceptionHandlerSetup exceptionHandlerSetup2 = new ExceptionHandlerSetup(type, Ropper.this.exceptionSetupLabelAllocator.getNextLabel());
            this.setups.put(type, exceptionHandlerSetup2);
            return exceptionHandlerSetup2;
        }

        public Collection<ExceptionHandlerSetup> getSetups() {
            return this.setups.values();
        }
    }

    public static class ExceptionHandlerSetup {
        private Type caughtType;
        private int label;

        public ExceptionHandlerSetup(Type type, int i) {
            this.caughtType = type;
            this.label = i;
        }

        public Type getCaughtType() {
            return this.caughtType;
        }

        public int getLabel() {
            return this.label;
        }
    }

    public class ExceptionSetupLabelAllocator extends LabelAllocator {
        int maxSetupLabel;

        public ExceptionSetupLabelAllocator() {
            super(Ropper.this.maxLabel);
            this.maxSetupLabel = Ropper.this.method.getCatches().size() + Ropper.this.maxLabel;
        }

        @Override // com.android.dx.cf.code.Ropper.LabelAllocator
        public int getNextLabel() {
            int i = this.nextAvailableLabel;
            if (i >= this.maxSetupLabel) {
                throw new IndexOutOfBoundsException();
            }
            this.nextAvailableLabel = i + 1;
            return i;
        }
    }

    public static class LabelAllocator {
        int nextAvailableLabel;

        public LabelAllocator(int i) {
            this.nextAvailableLabel = i;
        }

        public int getNextLabel() {
            int i = this.nextAvailableLabel;
            this.nextAvailableLabel = i + 1;
            return i;
        }
    }

    public class SubroutineInliner {
        private final LabelAllocator labelAllocator;
        private final ArrayList<IntList> labelToSubroutines;
        private final HashMap<Integer, Integer> origLabelToCopiedLabel = new HashMap<>();
        private int subroutineStart;
        private int subroutineSuccessor;
        private final BitSet workList;

        public SubroutineInliner(LabelAllocator labelAllocator, ArrayList<IntList> arrayList) {
            this.workList = new BitSet(Ropper.this.maxLabel);
            this.labelAllocator = labelAllocator;
            this.labelToSubroutines = arrayList;
        }

        private void copyBlock(int i, int i3) {
            IntList intListMakeImmutable;
            BasicBlock basicBlockLabelToBlock = Ropper.this.labelToBlock(i);
            IntList successors = basicBlockLabelToBlock.getSuccessors();
            int i4 = -1;
            if (Ropper.this.isSubroutineCaller(basicBlockLabelToBlock)) {
                intListMakeImmutable = IntList.makeImmutable(mapOrAllocateLabel(successors.get(0)), successors.get(1));
            } else {
                Subroutine subroutineSubroutineFromRetBlock = Ropper.this.subroutineFromRetBlock(i);
                if (subroutineSubroutineFromRetBlock == null) {
                    int primarySuccessor = basicBlockLabelToBlock.getPrimarySuccessor();
                    int size = successors.size();
                    IntList intList = new IntList(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        int i6 = successors.get(i5);
                        int iMapOrAllocateLabel = mapOrAllocateLabel(i6);
                        intList.add(iMapOrAllocateLabel);
                        if (primarySuccessor == i6) {
                            i4 = iMapOrAllocateLabel;
                        }
                    }
                    intList.setImmutable();
                    intListMakeImmutable = intList;
                } else {
                    if (subroutineSubroutineFromRetBlock.startBlock != this.subroutineStart) {
                        StringBuilder sb = new StringBuilder("ret instruction returns to label ");
                        sb.append(Hex.u2(subroutineSubroutineFromRetBlock.startBlock));
                        sb.append(" expected: ");
                        throw new RuntimeException(a.z(this.subroutineStart, sb));
                    }
                    intListMakeImmutable = IntList.makeImmutable(this.subroutineSuccessor);
                    i4 = this.subroutineSuccessor;
                }
            }
            Ropper ropper = Ropper.this;
            ropper.addBlock(new BasicBlock(i3, ropper.filterMoveReturnAddressInsns(basicBlockLabelToBlock.getInsns()), intListMakeImmutable, i4), this.labelToSubroutines.get(i3));
        }

        private boolean involvedInSubroutine(int i, int i3) {
            IntList intList = this.labelToSubroutines.get(i);
            return intList != null && intList.size() > 0 && intList.top() == i3;
        }

        private int mapOrAllocateLabel(int i) {
            Integer num = this.origLabelToCopiedLabel.get(Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
            if (!involvedInSubroutine(i, this.subroutineStart)) {
                return i;
            }
            int nextLabel = this.labelAllocator.getNextLabel();
            this.workList.set(i);
            this.origLabelToCopiedLabel.put(Integer.valueOf(i), Integer.valueOf(nextLabel));
            while (this.labelToSubroutines.size() <= nextLabel) {
                this.labelToSubroutines.add(null);
            }
            ArrayList<IntList> arrayList = this.labelToSubroutines;
            arrayList.set(nextLabel, arrayList.get(i));
            return nextLabel;
        }

        public void inlineSubroutineCalledFrom(BasicBlock basicBlock) {
            this.subroutineSuccessor = basicBlock.getSuccessors().get(0);
            int i = basicBlock.getSuccessors().get(1);
            this.subroutineStart = i;
            int iMapOrAllocateLabel = mapOrAllocateLabel(i);
            int iNextSetBit = this.workList.nextSetBit(0);
            while (iNextSetBit >= 0) {
                this.workList.clear(iNextSetBit);
                int iIntValue = this.origLabelToCopiedLabel.get(Integer.valueOf(iNextSetBit)).intValue();
                copyBlock(iNextSetBit, iIntValue);
                Ropper ropper = Ropper.this;
                if (ropper.isSubroutineCaller(ropper.labelToBlock(iNextSetBit))) {
                    Ropper.this.new SubroutineInliner(this.labelAllocator, this.labelToSubroutines).inlineSubroutineCalledFrom(Ropper.this.labelToBlock(iIntValue));
                }
                iNextSetBit = this.workList.nextSetBit(0);
            }
            Ropper.this.addOrReplaceBlockNoDelete(new BasicBlock(basicBlock.getLabel(), basicBlock.getInsns(), IntList.makeImmutable(iMapOrAllocateLabel), iMapOrAllocateLabel), this.labelToSubroutines.get(basicBlock.getLabel()));
        }
    }

    private Ropper(ConcreteMethod concreteMethod, TranslationAdvice translationAdvice, MethodList methodList, DexOptions dexOptions) {
        if (concreteMethod == null) {
            throw new NullPointerException("method == null");
        }
        if (translationAdvice == null) {
            throw new NullPointerException("advice == null");
        }
        this.method = concreteMethod;
        ByteBlockList byteBlockListIdentifyBlocks = BasicBlocker.identifyBlocks(concreteMethod);
        this.blocks = byteBlockListIdentifyBlocks;
        int maxLabel = byteBlockListIdentifyBlocks.getMaxLabel();
        this.maxLabel = maxLabel;
        int maxLocals = concreteMethod.getMaxLocals();
        this.maxLocals = maxLocals;
        RopperMachine ropperMachine = new RopperMachine(this, concreteMethod, translationAdvice, methodList);
        this.machine = ropperMachine;
        this.sim = new Simulator(ropperMachine, concreteMethod, dexOptions);
        Frame[] frameArr = new Frame[maxLabel];
        this.startFrames = frameArr;
        this.subroutines = new Subroutine[maxLabel];
        this.result = new ArrayList<>((byteBlockListIdentifyBlocks.size() * 2) + 10);
        this.resultSubroutines = new ArrayList<>((byteBlockListIdentifyBlocks.size() * 2) + 10);
        this.catchInfos = new CatchInfo[maxLabel];
        this.synchNeedsExceptionHandler = false;
        frameArr[0] = new Frame(maxLocals, concreteMethod.getMaxStack());
        this.exceptionSetupLabelAllocator = new ExceptionSetupLabelAllocator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBlock(BasicBlock basicBlock, IntList intList) {
        if (basicBlock == null) {
            throw new NullPointerException("block == null");
        }
        this.result.add(basicBlock);
        intList.throwIfMutable();
        this.resultSubroutines.add(intList);
    }

    private void addExceptionSetupBlocks() {
        int length = this.catchInfos.length;
        for (int i = 0; i < length; i++) {
            CatchInfo catchInfo = this.catchInfos[i];
            if (catchInfo != null) {
                for (ExceptionHandlerSetup exceptionHandlerSetup : catchInfo.getSetups()) {
                    SourcePosition position = labelToBlock(i).getFirstInsn().getPosition();
                    InsnList insnList = new InsnList(2);
                    Rop ropOpMoveException = Rops.opMoveException(exceptionHandlerSetup.getCaughtType());
                    RegisterSpec registerSpecMake = RegisterSpec.make(this.maxLocals, exceptionHandlerSetup.getCaughtType());
                    RegisterSpecList registerSpecList = RegisterSpecList.EMPTY;
                    insnList.set(0, new PlainInsn(ropOpMoveException, position, registerSpecMake, registerSpecList));
                    insnList.set(1, new PlainInsn(Rops.GOTO, position, (RegisterSpec) null, registerSpecList));
                    insnList.setImmutable();
                    addBlock(new BasicBlock(exceptionHandlerSetup.getLabel(), insnList, IntList.makeImmutable(i), i), this.startFrames[i].getSubroutines());
                }
            }
        }
    }

    private boolean addOrReplaceBlock(BasicBlock basicBlock, IntList intList) {
        boolean z6;
        if (basicBlock == null) {
            throw new NullPointerException("block == null");
        }
        int iLabelToResultIndex = labelToResultIndex(basicBlock.getLabel());
        if (iLabelToResultIndex < 0) {
            z6 = false;
        } else {
            removeBlockAndSpecialSuccessors(iLabelToResultIndex);
            z6 = true;
        }
        this.result.add(basicBlock);
        intList.throwIfMutable();
        this.resultSubroutines.add(intList);
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addOrReplaceBlockNoDelete(BasicBlock basicBlock, IntList intList) {
        boolean z6;
        if (basicBlock == null) {
            throw new NullPointerException("block == null");
        }
        int iLabelToResultIndex = labelToResultIndex(basicBlock.getLabel());
        if (iLabelToResultIndex < 0) {
            z6 = false;
        } else {
            this.result.remove(iLabelToResultIndex);
            this.resultSubroutines.remove(iLabelToResultIndex);
            z6 = true;
        }
        this.result.add(basicBlock);
        intList.throwIfMutable();
        this.resultSubroutines.add(intList);
        return z6;
    }

    private void addReturnBlock() {
        Rop returnOp = this.machine.getReturnOp();
        if (returnOp == null) {
            return;
        }
        SourcePosition returnPosition = this.machine.getReturnPosition();
        int specialLabel = getSpecialLabel(-2);
        if (isSynchronized()) {
            InsnList insnList = new InsnList(1);
            insnList.set(0, new ThrowingInsn(Rops.MONITOR_EXIT, returnPosition, RegisterSpecList.make(getSynchReg()), StdTypeList.EMPTY));
            insnList.setImmutable();
            int specialLabel2 = getSpecialLabel(-3);
            addBlock(new BasicBlock(specialLabel, insnList, IntList.makeImmutable(specialLabel2), specialLabel2), IntList.EMPTY);
            specialLabel = specialLabel2;
        }
        InsnList insnList2 = new InsnList(1);
        TypeList sources = returnOp.getSources();
        insnList2.set(0, new PlainInsn(returnOp, returnPosition, (RegisterSpec) null, sources.size() == 0 ? RegisterSpecList.EMPTY : RegisterSpecList.make(RegisterSpec.make(0, sources.getType(0)))));
        insnList2.setImmutable();
        IntList intList = IntList.EMPTY;
        addBlock(new BasicBlock(specialLabel, insnList2, intList, -1), intList);
    }

    private void addSetupBlocks() {
        InsnList insnList;
        LocalVariableList localVariables = this.method.getLocalVariables();
        SourcePosition sourcePositionMakeSourcePosistion = this.method.makeSourcePosistion(0);
        StdTypeList parameterTypes = this.method.getEffectiveDescriptor().getParameterTypes();
        int size = parameterTypes.size();
        InsnList insnList2 = new InsnList(size + 1);
        int category = 0;
        for (int i = 0; i < size; i++) {
            Type type = parameterTypes.get(i);
            LocalVariableList.Item itemPcAndIndexToLocal = localVariables.pcAndIndexToLocal(0, category);
            insnList2.set(i, new PlainCstInsn(Rops.opMoveParam(type), sourcePositionMakeSourcePosistion, itemPcAndIndexToLocal == null ? RegisterSpec.make(category, type) : RegisterSpec.makeLocalOptional(category, type, itemPcAndIndexToLocal.getLocalItem()), RegisterSpecList.EMPTY, CstInteger.make(category)));
            category += type.getCategory();
        }
        Rop rop = Rops.GOTO;
        RegisterSpecList registerSpecList = RegisterSpecList.EMPTY;
        insnList2.set(size, new PlainInsn(rop, sourcePositionMakeSourcePosistion, (RegisterSpec) null, registerSpecList));
        insnList2.setImmutable();
        boolean zIsSynchronized = isSynchronized();
        int specialLabel = zIsSynchronized ? getSpecialLabel(-4) : 0;
        BasicBlock basicBlock = new BasicBlock(getSpecialLabel(-1), insnList2, IntList.makeImmutable(specialLabel), specialLabel);
        IntList intList = IntList.EMPTY;
        addBlock(basicBlock, intList);
        if (zIsSynchronized) {
            RegisterSpec synchReg = getSynchReg();
            if (isStatic()) {
                ThrowingCstInsn throwingCstInsn = new ThrowingCstInsn(Rops.CONST_OBJECT, sourcePositionMakeSourcePosistion, registerSpecList, StdTypeList.EMPTY, this.method.getDefiningClass());
                insnList = new InsnList(1);
                insnList.set(0, throwingCstInsn);
            } else {
                InsnList insnList3 = new InsnList(2);
                PlainCstInsn plainCstInsn = new PlainCstInsn(Rops.MOVE_PARAM_OBJECT, sourcePositionMakeSourcePosistion, synchReg, registerSpecList, CstInteger.VALUE_0);
                registerSpecList = registerSpecList;
                insnList3.set(0, plainCstInsn);
                insnList3.set(1, new PlainInsn(rop, sourcePositionMakeSourcePosistion, (RegisterSpec) null, registerSpecList));
                insnList = insnList3;
            }
            int specialLabel2 = getSpecialLabel(-5);
            insnList.setImmutable();
            addBlock(new BasicBlock(specialLabel, insnList, IntList.makeImmutable(specialLabel2), specialLabel2), intList);
            InsnList insnList4 = new InsnList(isStatic() ? 2 : 1);
            if (isStatic()) {
                insnList4.set(0, new PlainInsn(Rops.opMoveResultPseudo(synchReg), sourcePositionMakeSourcePosistion, synchReg, registerSpecList));
            }
            insnList4.set(isStatic() ? 1 : 0, new ThrowingInsn(Rops.MONITOR_ENTER, sourcePositionMakeSourcePosistion, RegisterSpecList.make(synchReg), StdTypeList.EMPTY));
            insnList4.setImmutable();
            addBlock(new BasicBlock(specialLabel2, insnList4, IntList.makeImmutable(0), 0), intList);
        }
    }

    private void addSynchExceptionHandlerBlock() {
        if (this.synchNeedsExceptionHandler) {
            SourcePosition sourcePositionMakeSourcePosistion = this.method.makeSourcePosistion(0);
            Type type = Type.THROWABLE;
            RegisterSpec registerSpecMake = RegisterSpec.make(0, type);
            InsnList insnList = new InsnList(2);
            insnList.set(0, new PlainInsn(Rops.opMoveException(type), sourcePositionMakeSourcePosistion, registerSpecMake, RegisterSpecList.EMPTY));
            Rop rop = Rops.MONITOR_EXIT;
            RegisterSpecList registerSpecListMake = RegisterSpecList.make(getSynchReg());
            StdTypeList stdTypeList = StdTypeList.EMPTY;
            insnList.set(1, new ThrowingInsn(rop, sourcePositionMakeSourcePosistion, registerSpecListMake, stdTypeList));
            insnList.setImmutable();
            int specialLabel = getSpecialLabel(-7);
            BasicBlock basicBlock = new BasicBlock(getSpecialLabel(-6), insnList, IntList.makeImmutable(specialLabel), specialLabel);
            IntList intList = IntList.EMPTY;
            addBlock(basicBlock, intList);
            InsnList insnList2 = new InsnList(1);
            insnList2.set(0, new ThrowingInsn(Rops.THROW, sourcePositionMakeSourcePosistion, RegisterSpecList.make(registerSpecMake), stdTypeList));
            insnList2.setImmutable();
            addBlock(new BasicBlock(specialLabel, insnList2, intList, -1), intList);
        }
    }

    public static RopMethod convert(ConcreteMethod concreteMethod, TranslationAdvice translationAdvice, MethodList methodList, DexOptions dexOptions) {
        try {
            Ropper ropper = new Ropper(concreteMethod, translationAdvice, methodList, dexOptions);
            ropper.doit();
            return ropper.getRopMethod();
        } catch (SimException e) {
            e.addContext("...while working on method " + concreteMethod.getNat().toHuman());
            throw e;
        }
    }

    private void deleteUnreachableBlocks() {
        final IntList intList = new IntList(this.result.size());
        this.resultSubroutines.clear();
        forEachNonSubBlockDepthFirst(getSpecialLabel(-1), new BasicBlock.Visitor() { // from class: com.android.dx.cf.code.Ropper.2
            @Override // com.android.dx.rop.code.BasicBlock.Visitor
            public void visitBlock(BasicBlock basicBlock) {
                intList.add(basicBlock.getLabel());
            }
        });
        intList.sort();
        for (int size = this.result.size() - 1; size >= 0; size--) {
            if (intList.indexOf(this.result.get(size).getLabel()) < 0) {
                this.result.remove(size);
            }
        }
    }

    private void doit() {
        int[] iArrMakeBitSet = Bits.makeBitSet(this.maxLabel);
        Bits.set(iArrMakeBitSet, 0);
        addSetupBlocks();
        setFirstFrame();
        while (true) {
            int iFindFirst = Bits.findFirst(iArrMakeBitSet, 0);
            if (iFindFirst < 0) {
                break;
            }
            Bits.clear(iArrMakeBitSet, iFindFirst);
            try {
                processBlock(this.blocks.labelToBlock(iFindFirst), this.startFrames[iFindFirst], iArrMakeBitSet);
            } catch (SimException e) {
                e.addContext("...while working on block " + Hex.u2(iFindFirst));
                throw e;
            }
        }
        addReturnBlock();
        addSynchExceptionHandlerBlock();
        addExceptionSetupBlocks();
        if (this.hasSubroutines) {
            inlineSubroutines();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InsnList filterMoveReturnAddressInsns(InsnList insnList) {
        int size = insnList.size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (insnList.get(i3).getOpcode() != Rops.MOVE_RETURN_ADDRESS) {
                i++;
            }
        }
        if (i == size) {
            return insnList;
        }
        InsnList insnList2 = new InsnList(i);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Insn insn = insnList.get(i5);
            if (insn.getOpcode() != Rops.MOVE_RETURN_ADDRESS) {
                insnList2.set(i4, insn);
                i4++;
            }
        }
        insnList2.setImmutable();
        return insnList2;
    }

    private void forEachNonSubBlockDepthFirst(int i, BasicBlock.Visitor visitor) {
        forEachNonSubBlockDepthFirst0(labelToBlock(i), visitor, new BitSet(this.maxLabel));
    }

    private void forEachNonSubBlockDepthFirst0(BasicBlock basicBlock, BasicBlock.Visitor visitor, BitSet bitSet) {
        int iLabelToResultIndex;
        visitor.visitBlock(basicBlock);
        bitSet.set(basicBlock.getLabel());
        IntList successors = basicBlock.getSuccessors();
        int size = successors.size();
        for (int i = 0; i < size; i++) {
            int i3 = successors.get(i);
            if (!bitSet.get(i3) && ((!isSubroutineCaller(basicBlock) || i <= 0) && (iLabelToResultIndex = labelToResultIndex(i3)) >= 0)) {
                forEachNonSubBlockDepthFirst0(this.result.get(iLabelToResultIndex), visitor, bitSet);
            }
        }
    }

    private int getAvailableLabel() {
        int minimumUnreservedLabel = getMinimumUnreservedLabel();
        Iterator<BasicBlock> it = this.result.iterator();
        while (it.hasNext()) {
            int label = it.next().getLabel();
            if (label >= minimumUnreservedLabel) {
                minimumUnreservedLabel = label + 1;
            }
        }
        return minimumUnreservedLabel;
    }

    private int getMinimumUnreservedLabel() {
        return this.method.getCatches().size() + this.maxLabel + 7;
    }

    private int getNormalRegCount() {
        return this.method.getMaxStack() + this.maxLocals;
    }

    private RopMethod getRopMethod() {
        int size = this.result.size();
        BasicBlockList basicBlockList = new BasicBlockList(size);
        for (int i = 0; i < size; i++) {
            basicBlockList.set(i, this.result.get(i));
        }
        basicBlockList.setImmutable();
        return new RopMethod(basicBlockList, getSpecialLabel(-1));
    }

    private int getSpecialLabel(int i) {
        return this.method.getCatches().size() + this.maxLabel + (~i);
    }

    private RegisterSpec getSynchReg() {
        int normalRegCount = getNormalRegCount();
        if (normalRegCount < 1) {
            normalRegCount = 1;
        }
        return RegisterSpec.make(normalRegCount, Type.OBJECT);
    }

    private void inlineSubroutines() {
        final IntList intList = new IntList(4);
        forEachNonSubBlockDepthFirst(0, new BasicBlock.Visitor() { // from class: com.android.dx.cf.code.Ropper.1
            @Override // com.android.dx.rop.code.BasicBlock.Visitor
            public void visitBlock(BasicBlock basicBlock) {
                if (Ropper.this.isSubroutineCaller(basicBlock)) {
                    intList.add(basicBlock.getLabel());
                }
            }
        });
        int availableLabel = getAvailableLabel();
        ArrayList arrayList = new ArrayList(availableLabel);
        for (int i = 0; i < availableLabel; i++) {
            arrayList.add(null);
        }
        for (int i3 = 0; i3 < this.result.size(); i3++) {
            BasicBlock basicBlock = this.result.get(i3);
            if (basicBlock != null) {
                arrayList.set(basicBlock.getLabel(), this.resultSubroutines.get(i3));
            }
        }
        int size = intList.size();
        for (int i4 = 0; i4 < size; i4++) {
            new SubroutineInliner(new LabelAllocator(getAvailableLabel()), arrayList).inlineSubroutineCalledFrom(labelToBlock(intList.get(i4)));
        }
        deleteUnreachableBlocks();
    }

    private boolean isStatic() {
        return (this.method.getAccessFlags() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSubroutineCaller(BasicBlock basicBlock) {
        IntList successors = basicBlock.getSuccessors();
        if (successors.size() < 2) {
            return false;
        }
        int i = successors.get(1);
        Subroutine[] subroutineArr = this.subroutines;
        return i < subroutineArr.length && subroutineArr[i] != null;
    }

    private boolean isSynchronized() {
        return (this.method.getAccessFlags() & 32) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBlock labelToBlock(int i) {
        int iLabelToResultIndex = labelToResultIndex(i);
        if (iLabelToResultIndex >= 0) {
            return this.result.get(iLabelToResultIndex);
        }
        throw new IllegalArgumentException(a.z(i, new StringBuilder("no such label ")));
    }

    private int labelToResultIndex(int i) {
        int size = this.result.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.result.get(i3).getLabel() == i) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAndWorkAsNecessary(int i, int i3, Subroutine subroutine, Frame frame, int[] iArr) {
        Frame[] frameArr = this.startFrames;
        Frame frame2 = frameArr[i];
        if (frame2 == null) {
            if (subroutine != null) {
                frameArr[i] = frame.makeNewSubroutineStartFrame(i, i3);
            } else {
                frameArr[i] = frame;
            }
            Bits.set(iArr, i);
            return;
        }
        Frame frameMergeWithSubroutineCaller = subroutine != null ? frame2.mergeWithSubroutineCaller(frame, subroutine.getStartBlock(), i3) : frame2.mergeWith(frame);
        if (frameMergeWithSubroutineCaller != frame2) {
            this.startFrames[i] = frameMergeWithSubroutineCaller;
            Bits.set(iArr, i);
        }
    }

    private void processBlock(ByteBlock byteBlock, Frame frame, int[] iArr) {
        int[] iArr2;
        IntList intList;
        Subroutine subroutine;
        int size;
        int i;
        int primarySuccessorIndex;
        Frame frame2;
        int i3;
        IntList intListMakeImmutable;
        ByteCatchList catches = byteBlock.getCatches();
        this.machine.startBlock(catches.toRopCatchList());
        Frame frameCopy = frame.copy();
        this.sim.simulate(byteBlock, frameCopy);
        frameCopy.setImmutable();
        int extraBlockCount = this.machine.getExtraBlockCount();
        ArrayList<Insn> insns = this.machine.getInsns();
        int size2 = insns.size();
        int size3 = catches.size();
        IntList successors = byteBlock.getSuccessors();
        if (this.machine.hasJsr()) {
            int i4 = successors.get(1);
            Subroutine[] subroutineArr = this.subroutines;
            if (subroutineArr[i4] == null) {
                subroutineArr[i4] = new Subroutine(i4);
            }
            this.subroutines[i4].addCallerBlock(byteBlock.getLabel());
            iArr2 = iArr;
            intList = successors;
            subroutine = this.subroutines[i4];
            size = 1;
        } else {
            if (this.machine.hasRet()) {
                int subroutineAddress = this.machine.getReturnAddress().getSubroutineAddress();
                Subroutine[] subroutineArr2 = this.subroutines;
                Subroutine subroutine2 = subroutineArr2[subroutineAddress];
                if (subroutine2 == null) {
                    subroutineArr2[subroutineAddress] = new Subroutine(this, subroutineAddress, byteBlock.getLabel());
                } else {
                    subroutine2.addRetBlock(byteBlock.getLabel());
                }
                IntList successors2 = this.subroutines[subroutineAddress].getSuccessors();
                iArr2 = iArr;
                this.subroutines[subroutineAddress].mergeToSuccessors(frameCopy, iArr2);
                size = successors2.size();
                intList = successors2;
            } else {
                iArr2 = iArr;
                if (this.machine.wereCatchesUsed()) {
                    intList = successors;
                    size = size3;
                } else {
                    intList = successors;
                    subroutine = null;
                    size = 0;
                }
            }
            subroutine = null;
        }
        int size4 = intList.size();
        while (size < size4) {
            int i5 = size;
            int i6 = intList.get(i5);
            int i7 = size4;
            try {
                mergeAndWorkAsNecessary(i6, byteBlock.getLabel(), subroutine, frameCopy, iArr2);
                iArr2 = iArr;
                frameCopy = frameCopy;
                size = i5 + 1;
                size4 = i7;
            } catch (SimException e) {
                e.addContext("...while merging to block " + Hex.u2(i6));
                throw e;
            }
        }
        int i8 = size4;
        Frame frame3 = frameCopy;
        if (i8 == 0 && this.machine.returns()) {
            intList = IntList.makeImmutable(getSpecialLabel(-2));
            i = 1;
        } else {
            i = i8;
        }
        if (i == 0) {
            primarySuccessorIndex = -1;
        } else {
            primarySuccessorIndex = this.machine.getPrimarySuccessorIndex();
            if (primarySuccessorIndex >= 0) {
                primarySuccessorIndex = intList.get(primarySuccessorIndex);
            }
        }
        int i9 = primarySuccessorIndex;
        boolean z6 = isSynchronized() && this.machine.canThrow();
        if (z6 || size3 != 0) {
            intList = new IntList(i);
            int i10 = 0;
            boolean z7 = false;
            while (i10 < size3) {
                ByteCatchList.Item item = catches.get(i10);
                CstType exceptionClass = item.getExceptionClass();
                int handlerPc = item.getHandlerPc();
                boolean z8 = (exceptionClass == CstType.OBJECT) | z7;
                Frame frameMakeExceptionHandlerStartFrame = frame3.makeExceptionHandlerStartFrame(exceptionClass);
                int i11 = i10;
                try {
                    Frame frame4 = frame3;
                    i3 = handlerPc;
                    try {
                        mergeAndWorkAsNecessary(i3, byteBlock.getLabel(), null, frameMakeExceptionHandlerStartFrame, iArr);
                        CatchInfo catchInfo = this.catchInfos[i3];
                        if (catchInfo == null) {
                            catchInfo = new CatchInfo();
                            this.catchInfos[i3] = catchInfo;
                        }
                        intList.add(catchInfo.getSetup(exceptionClass.getClassType()).getLabel());
                        i10 = i11 + 1;
                        z7 = z8;
                        frame3 = frame4;
                    } catch (SimException e6) {
                        e = e6;
                        e.addContext("...while merging exception to block " + Hex.u2(i3));
                        throw e;
                    }
                } catch (SimException e7) {
                    e = e7;
                    i3 = handlerPc;
                }
            }
            frame2 = frame3;
            if (z6 && !z7) {
                intList.add(getSpecialLabel(-6));
                this.synchNeedsExceptionHandler = true;
                for (int i12 = (size2 - extraBlockCount) - 1; i12 < size2; i12++) {
                    Insn insn = insns.get(i12);
                    if (insn.canThrow()) {
                        insns.set(i12, insn.withAddedCatch(Type.OBJECT));
                    }
                }
            }
            if (i9 >= 0) {
                intList.add(i9);
            }
            intList.setImmutable();
        } else {
            frame2 = frame3;
        }
        int iIndexOf = intList.indexOf(i9);
        while (extraBlockCount > 0) {
            size2--;
            Insn insn2 = insns.get(size2);
            boolean z9 = insn2.getOpcode().getBranchingness() == 1;
            InsnList insnList = new InsnList(z9 ? 2 : 1);
            insnList.set(0, insn2);
            if (z9) {
                insnList.set(1, new PlainInsn(Rops.GOTO, insn2.getPosition(), (RegisterSpec) null, RegisterSpecList.EMPTY));
                intListMakeImmutable = IntList.makeImmutable(i9);
            } else {
                intListMakeImmutable = intList;
            }
            insnList.setImmutable();
            int availableLabel = getAvailableLabel();
            addBlock(new BasicBlock(availableLabel, insnList, intListMakeImmutable, i9), frame2.getSubroutines());
            intList = intList.mutableCopy();
            intList.set(iIndexOf, availableLabel);
            intList.setImmutable();
            extraBlockCount--;
            i9 = availableLabel;
        }
        Insn insn3 = size2 == 0 ? null : insns.get(size2 - 1);
        if (insn3 == null || insn3.getOpcode().getBranchingness() == 1) {
            insns.add(new PlainInsn(Rops.GOTO, insn3 == null ? SourcePosition.NO_INFO : insn3.getPosition(), (RegisterSpec) null, RegisterSpecList.EMPTY));
            size2++;
        }
        InsnList insnList2 = new InsnList(size2);
        for (int i13 = 0; i13 < size2; i13++) {
            insnList2.set(i13, insns.get(i13));
        }
        insnList2.setImmutable();
        addOrReplaceBlock(new BasicBlock(byteBlock.getLabel(), insnList2, intList, i9), frame2.getSubroutines());
    }

    private void removeBlockAndSpecialSuccessors(int i) {
        int minimumUnreservedLabel = getMinimumUnreservedLabel();
        IntList successors = this.result.get(i).getSuccessors();
        int size = successors.size();
        this.result.remove(i);
        this.resultSubroutines.remove(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = successors.get(i3);
            if (i4 >= minimumUnreservedLabel) {
                int iLabelToResultIndex = labelToResultIndex(i4);
                if (iLabelToResultIndex < 0) {
                    throw new RuntimeException(a.z(i4, new StringBuilder("Invalid label ")));
                }
                removeBlockAndSpecialSuccessors(iLabelToResultIndex);
            }
        }
    }

    private void setFirstFrame() {
        this.startFrames[0].initializeWithParameters(this.method.getEffectiveDescriptor().getParameterTypes());
        this.startFrames[0].setImmutable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Subroutine subroutineFromRetBlock(int i) {
        for (int length = this.subroutines.length - 1; length >= 0; length--) {
            Subroutine subroutine = this.subroutines[length];
            if (subroutine != null && subroutine.retBlocks.get(i)) {
                return subroutine;
            }
        }
        return null;
    }

    public int getFirstTempStackReg() {
        int normalRegCount = getNormalRegCount();
        return isSynchronized() ? normalRegCount + 1 : normalRegCount;
    }

    public class Subroutine {
        private BitSet callerBlocks;
        private BitSet retBlocks;
        private int startBlock;

        public Subroutine(int i) {
            this.startBlock = i;
            this.retBlocks = new BitSet(Ropper.this.maxLabel);
            this.callerBlocks = new BitSet(Ropper.this.maxLabel);
            Ropper.this.hasSubroutines = true;
        }

        public void addCallerBlock(int i) {
            this.callerBlocks.set(i);
        }

        public void addRetBlock(int i) {
            this.retBlocks.set(i);
        }

        public int getStartBlock() {
            return this.startBlock;
        }

        public IntList getSuccessors() {
            IntList intList = new IntList(this.callerBlocks.size());
            int iNextSetBit = this.callerBlocks.nextSetBit(0);
            while (iNextSetBit >= 0) {
                intList.add(Ropper.this.labelToBlock(iNextSetBit).getSuccessors().get(0));
                iNextSetBit = this.callerBlocks.nextSetBit(iNextSetBit + 1);
            }
            intList.setImmutable();
            return intList;
        }

        public void mergeToSuccessors(Frame frame, int[] iArr) {
            int[] iArr2;
            int iNextSetBit = this.callerBlocks.nextSetBit(0);
            while (iNextSetBit >= 0) {
                int i = Ropper.this.labelToBlock(iNextSetBit).getSuccessors().get(0);
                Frame frameSubFrameForLabel = frame.subFrameForLabel(this.startBlock, iNextSetBit);
                if (frameSubFrameForLabel != null) {
                    iArr2 = iArr;
                    Ropper.this.mergeAndWorkAsNecessary(i, -1, null, frameSubFrameForLabel, iArr2);
                } else {
                    iArr2 = iArr;
                    Bits.set(iArr2, iNextSetBit);
                }
                iNextSetBit = this.callerBlocks.nextSetBit(iNextSetBit + 1);
                iArr = iArr2;
            }
        }

        public Subroutine(Ropper ropper, int i, int i3) {
            this(i);
            addRetBlock(i3);
        }
    }
}
