package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SsaDumper extends BlockDumper {
    private SsaDumper(byte[] bArr, PrintStream printStream, String str, Args args) {
        super(bArr, printStream, str, true, args);
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, Args args) {
        new SsaDumper(bArr, printStream, str, args).dump();
    }

    @Override // com.android.dx.command.dump.BlockDumper, com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
        if (!(member instanceof Method) || !shouldDumpMethod(str) || (member.getAccessFlags() & 1280) != 0) {
            return;
        }
        ConcreteMethod concreteMethod = new ConcreteMethod((Method) member, this.classFile, true, true);
        DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
        RopMethod ropMethodConvert = Ropper.convert(concreteMethod, dexTranslationAdvice, this.classFile.getMethods(), this.dexOptions);
        boolean zIsStatic = AccessFlags.isStatic(concreteMethod.getAccessFlags());
        int iComputeParamWidth = BaseDumper.computeParamWidth(concreteMethod, zIsStatic);
        String str3 = this.args.ssaStep;
        SsaMethod ssaMethodDebugNoRegisterAllocation = str3 == null ? Optimizer.debugNoRegisterAllocation(ropMethodConvert, iComputeParamWidth, zIsStatic, true, dexTranslationAdvice, EnumSet.allOf(Optimizer.OptionalStep.class)) : "edge-split".equals(str3) ? Optimizer.debugEdgeSplit(ropMethodConvert, iComputeParamWidth, zIsStatic, true, dexTranslationAdvice) : "phi-placement".equals(this.args.ssaStep) ? Optimizer.debugPhiPlacement(ropMethodConvert, iComputeParamWidth, zIsStatic, true, dexTranslationAdvice) : "renaming".equals(this.args.ssaStep) ? Optimizer.debugRenaming(ropMethodConvert, iComputeParamWidth, zIsStatic, true, dexTranslationAdvice) : "dead-code".equals(this.args.ssaStep) ? Optimizer.debugDeadCodeRemover(ropMethodConvert, iComputeParamWidth, zIsStatic, true, dexTranslationAdvice) : null;
        StringBuilder sb = new StringBuilder(2000);
        sb.append("first ");
        sb.append(Hex.u2(ssaMethodDebugNoRegisterAllocation.blockIndexToRopLabel(ssaMethodDebugNoRegisterAllocation.getEntryBlockIndex())));
        sb.append('\n');
        ArrayList arrayList = (ArrayList) ssaMethodDebugNoRegisterAllocation.getBlocks().clone();
        Collections.sort(arrayList, SsaBasicBlock.LABEL_COMPARATOR);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.suppressDump = false;
                parsed(byteArray, 0, byteArray.size(), sb.toString());
                this.suppressDump = true;
                return;
            }
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
            sb.append("block ");
            sb.append(Hex.u2(ssaBasicBlock.getRopLabel()));
            sb.append('\n');
            BitSet predecessors = ssaBasicBlock.getPredecessors();
            for (int iNextSetBit = predecessors.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = predecessors.nextSetBit(iNextSetBit + 1)) {
                sb.append("  pred ");
                sb.append(Hex.u2(ssaMethodDebugNoRegisterAllocation.blockIndexToRopLabel(iNextSetBit)));
                sb.append('\n');
            }
            sb.append("  live in:" + ssaBasicBlock.getLiveInRegs());
            sb.append("\n");
            for (SsaInsn ssaInsn : ssaBasicBlock.getInsns()) {
                sb.append("  ");
                sb.append(ssaInsn.toHuman());
                sb.append('\n');
            }
            if (ssaBasicBlock.getSuccessors().cardinality() == 0) {
                sb.append("  returns\n");
            } else {
                int primarySuccessorRopLabel = ssaBasicBlock.getPrimarySuccessorRopLabel();
                IntList ropLabelSuccessorList = ssaBasicBlock.getRopLabelSuccessorList();
                int size = ropLabelSuccessorList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    sb.append("  next ");
                    sb.append(Hex.u2(ropLabelSuccessorList.get(i3)));
                    if (size != 1 && primarySuccessorRopLabel == ropLabelSuccessorList.get(i3)) {
                        sb.append(" *");
                    }
                    sb.append('\n');
                }
            }
            sb.append("  live out:" + ssaBasicBlock.getLiveOutRegs());
            sb.append("\n");
        }
    }
}
