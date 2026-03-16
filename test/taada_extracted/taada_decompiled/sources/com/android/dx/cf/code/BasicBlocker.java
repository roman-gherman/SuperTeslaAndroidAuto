package com.android.dx.cf.code;

import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInvokeDynamic;
import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstMethodHandle;
import com.android.dx.rop.cst.CstProtoRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BasicBlocker implements BytecodeArray.Visitor {
    private final int[] blockSet;
    private final ByteCatchList[] catchLists;
    private final int[] liveSet;
    private final ConcreteMethod method;
    private int previousOffset;
    private final IntList[] targetLists;
    private final int[] workSet;

    private BasicBlocker(ConcreteMethod concreteMethod) {
        if (concreteMethod == null) {
            throw new NullPointerException("method == null");
        }
        this.method = concreteMethod;
        int size = concreteMethod.getCode().size() + 1;
        this.workSet = Bits.makeBitSet(size);
        this.liveSet = Bits.makeBitSet(size);
        this.blockSet = Bits.makeBitSet(size);
        this.targetLists = new IntList[size];
        this.catchLists = new ByteCatchList[size];
        this.previousOffset = -1;
    }

    private void addWorkIfNecessary(int i, boolean z6) {
        if (!Bits.get(this.liveSet, i)) {
            Bits.set(this.workSet, i);
        }
        if (z6) {
            Bits.set(this.blockSet, i);
        }
    }

    private void doit() {
        BytecodeArray code = this.method.getCode();
        ByteCatchList catches = this.method.getCatches();
        int size = catches.size();
        Bits.set(this.workSet, 0);
        Bits.set(this.blockSet, 0);
        while (!Bits.isEmpty(this.workSet)) {
            try {
                code.processWorkSet(this.workSet, this);
                for (int i = 0; i < size; i++) {
                    ByteCatchList.Item item = catches.get(i);
                    int startPc = item.getStartPc();
                    int endPc = item.getEndPc();
                    if (Bits.anyInRange(this.liveSet, startPc, endPc)) {
                        Bits.set(this.blockSet, startPc);
                        Bits.set(this.blockSet, endPc);
                        addWorkIfNecessary(item.getHandlerPc(), true);
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new SimException("flow of control falls off end of method", e);
            }
        }
    }

    private ByteBlockList getBlockList() {
        ByteCatchList byteCatchList;
        ByteBlock[] byteBlockArr = new ByteBlock[this.method.getCode().size()];
        int i = 0;
        int i3 = 0;
        while (true) {
            int iFindFirst = Bits.findFirst(this.blockSet, i + 1);
            if (iFindFirst < 0) {
                break;
            }
            if (Bits.get(this.liveSet, i)) {
                int i4 = iFindFirst - 1;
                IntList intListMakeImmutable = null;
                while (true) {
                    if (i4 < i) {
                        i4 = -1;
                        break;
                    }
                    intListMakeImmutable = this.targetLists[i4];
                    if (intListMakeImmutable != null) {
                        break;
                    }
                    i4--;
                }
                if (intListMakeImmutable == null) {
                    intListMakeImmutable = IntList.makeImmutable(iFindFirst);
                    byteCatchList = ByteCatchList.EMPTY;
                } else {
                    byteCatchList = this.catchLists[i4];
                    if (byteCatchList == null) {
                        byteCatchList = ByteCatchList.EMPTY;
                    }
                }
                byteBlockArr[i3] = new ByteBlock(i, i, iFindFirst, intListMakeImmutable, byteCatchList);
                i3++;
            }
            i = iFindFirst;
        }
        ByteBlockList byteBlockList = new ByteBlockList(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            byteBlockList.set(i5, byteBlockArr[i5]);
        }
        return byteBlockList;
    }

    public static ByteBlockList identifyBlocks(ConcreteMethod concreteMethod) {
        BasicBlocker basicBlocker = new BasicBlocker(concreteMethod);
        basicBlocker.doit();
        return basicBlocker.getBlockList();
    }

    private void visitCommon(int i, int i3, boolean z6) {
        Bits.set(this.liveSet, i);
        if (z6) {
            addWorkIfNecessary(i + i3, false);
        } else {
            Bits.set(this.blockSet, i + i3);
        }
    }

    private void visitThrowing(int i, int i3, boolean z6) {
        int i4 = i3 + i;
        if (z6) {
            addWorkIfNecessary(i4, true);
        }
        ByteCatchList byteCatchListListFor = this.method.getCatches().listFor(i);
        this.catchLists[i] = byteCatchListListFor;
        IntList[] intListArr = this.targetLists;
        if (!z6) {
            i4 = -1;
        }
        intListArr[i] = byteCatchListListFor.toTargetList(i4);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public int getPreviousOffset() {
        return this.previousOffset;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void setPreviousOffset(int i) {
        this.previousOffset = i;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitBranch(int i, int i3, int i4, int i5) {
        if (i != 167) {
            if (i == 168) {
                addWorkIfNecessary(i3, true);
            }
            int i6 = i3 + i4;
            visitCommon(i3, i4, true);
            addWorkIfNecessary(i6, true);
            this.targetLists[i3] = IntList.makeImmutable(i6, i5);
        } else {
            visitCommon(i3, i4, false);
            this.targetLists[i3] = IntList.makeImmutable(i5);
        }
        addWorkIfNecessary(i5, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitConstant(int i, int i3, int i4, Constant constant, int i5) {
        visitCommon(i3, i4, true);
        if ((constant instanceof CstMemberRef) || (constant instanceof CstType) || (constant instanceof CstString) || (constant instanceof CstInvokeDynamic) || (constant instanceof CstMethodHandle) || (constant instanceof CstProtoRef)) {
            visitThrowing(i3, i4, true);
        }
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitInvalid(int i, int i3, int i4) {
        visitCommon(i3, i4, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitLocal(int i, int i3, int i4, int i5, Type type, int i6) {
        if (i != 169) {
            visitCommon(i3, i4, true);
        } else {
            visitCommon(i3, i4, false);
            this.targetLists[i3] = IntList.EMPTY;
        }
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNewarray(int i, int i3, CstType cstType, ArrayList<Constant> arrayList) {
        visitCommon(i, i3, true);
        visitThrowing(i, i3, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNoArgs(int i, int i3, int i4, Type type) {
        if (i == 108 || i == 112) {
            visitCommon(i3, i4, true);
            if (type == Type.INT || type == Type.LONG) {
                visitThrowing(i3, i4, true);
                return;
            }
            return;
        }
        if (i == 172 || i == 177) {
            visitCommon(i3, i4, false);
            this.targetLists[i3] = IntList.EMPTY;
            return;
        }
        if (i != 190) {
            if (i == 191) {
                visitCommon(i3, i4, false);
                visitThrowing(i3, i4, false);
                return;
            } else if (i != 194 && i != 195) {
                switch (i) {
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                        break;
                    default:
                        switch (i) {
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 83:
                            case 84:
                            case 85:
                            case 86:
                                break;
                            default:
                                visitCommon(i3, i4, true);
                                break;
                        }
                        return;
                }
            }
        }
        visitCommon(i3, i4, true);
        visitThrowing(i3, i4, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitSwitch(int i, int i3, int i4, SwitchList switchList, int i5) {
        visitCommon(i3, i4, false);
        addWorkIfNecessary(switchList.getDefaultTarget(), true);
        int size = switchList.size();
        for (int i6 = 0; i6 < size; i6++) {
            addWorkIfNecessary(switchList.getTarget(i6), true);
        }
        this.targetLists[i3] = switchList.getTargets();
    }
}
