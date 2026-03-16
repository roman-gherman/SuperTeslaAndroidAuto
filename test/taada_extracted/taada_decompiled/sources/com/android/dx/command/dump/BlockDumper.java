package com.android.dx.command.dump;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.cf.code.BasicBlocker;
import com.android.dx.cf.code.ByteBlock;
import com.android.dx.cf.code.ByteBlockList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.CodeObserver;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.CstType;
import com.android.dx.ssa.Optimizer;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class BlockDumper extends BaseDumper {
    protected DirectClassFile classFile;
    private boolean first;
    private final boolean optimize;
    private final boolean rop;
    protected boolean suppressDump;

    public BlockDumper(byte[] bArr, PrintStream printStream, String str, boolean z6, Args args) {
        super(bArr, printStream, str, args);
        this.rop = z6;
        this.classFile = null;
        this.suppressDump = true;
        this.first = true;
        this.optimize = args.optimize;
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, boolean z6, Args args) {
        new BlockDumper(bArr, printStream, str, z6, args).dump();
    }

    private void regularDump(ConcreteMethod concreteMethod) {
        BytecodeArray code = concreteMethod.getCode();
        ByteArray bytes = code.getBytes();
        ByteBlockList byteBlockListIdentifyBlocks = BasicBlocker.identifyBlocks(concreteMethod);
        int size = byteBlockListIdentifyBlocks.size();
        CodeObserver codeObserver = new CodeObserver(bytes, this);
        this.suppressDump = false;
        int i = 0;
        int i3 = 0;
        while (i < size) {
            ByteBlock byteBlock = byteBlockListIdentifyBlocks.get(i);
            int start = byteBlock.getStart();
            int end = byteBlock.getEnd();
            if (i3 < start) {
                parsed(bytes, i3, start - i3, "dead code " + Hex.u2(i3) + ".." + Hex.u2(start));
            }
            StringBuilder sb = new StringBuilder("block ");
            sb.append(Hex.u2(byteBlock.getLabel()));
            sb.append(": ");
            sb.append(Hex.u2(start));
            sb.append("..");
            parsed(bytes, start, 0, a.z(end, sb));
            changeIndent(1);
            while (start < end) {
                int instruction = code.parseInstruction(start, codeObserver);
                codeObserver.setPreviousOffset(start);
                start += instruction;
            }
            IntList successors = byteBlock.getSuccessors();
            int size2 = successors.size();
            if (size2 == 0) {
                parsed(bytes, end, 0, "returns");
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    parsed(bytes, end, 0, a.z(successors.get(i4), new StringBuilder("next ")));
                }
            }
            ByteCatchList catches = byteBlock.getCatches();
            int size3 = catches.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ByteCatchList.Item item = catches.get(i5);
                CstType exceptionClass = item.getExceptionClass();
                StringBuilder sb2 = new StringBuilder("catch ");
                sb2.append(exceptionClass == CstType.OBJECT ? "<any>" : exceptionClass.toHuman());
                sb2.append(" -> ");
                sb2.append(Hex.u2(item.getHandlerPc()));
                parsed(bytes, end, 0, sb2.toString());
            }
            changeIndent(-1);
            i++;
            i3 = end;
        }
        int size4 = bytes.size();
        if (i3 < size4) {
            parsed(bytes, i3, size4 - i3, "dead code " + Hex.u2(i3) + ".." + Hex.u2(size4));
        }
        this.suppressDump = true;
    }

    private void ropDump(ConcreteMethod concreteMethod) {
        DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
        ByteArray bytes = concreteMethod.getCode().getBytes();
        RopMethod ropMethodConvert = Ropper.convert(concreteMethod, dexTranslationAdvice, this.classFile.getMethods(), this.dexOptions);
        StringBuilder sb = new StringBuilder(2000);
        if (this.optimize) {
            boolean zIsStatic = AccessFlags.isStatic(concreteMethod.getAccessFlags());
            ropMethodConvert = Optimizer.optimize(ropMethodConvert, BaseDumper.computeParamWidth(concreteMethod, zIsStatic), zIsStatic, true, dexTranslationAdvice);
        }
        BasicBlockList blocks = ropMethodConvert.getBlocks();
        int[] labelsInOrder = blocks.getLabelsInOrder();
        sb.append("first " + Hex.u2(ropMethodConvert.getFirstLabel()) + "\n");
        for (int i : labelsInOrder) {
            BasicBlock basicBlock = blocks.get(blocks.indexOfLabel(i));
            sb.append("block ");
            sb.append(Hex.u2(i));
            sb.append("\n");
            IntList intListLabelToPredecessors = ropMethodConvert.labelToPredecessors(i);
            int size = intListLabelToPredecessors.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append("  pred ");
                sb.append(Hex.u2(intListLabelToPredecessors.get(i3)));
                sb.append("\n");
            }
            InsnList insns = basicBlock.getInsns();
            int size2 = insns.size();
            for (int i4 = 0; i4 < size2; i4++) {
                insns.get(i4);
                sb.append("  ");
                sb.append(insns.get(i4).toHuman());
                sb.append("\n");
            }
            IntList successors = basicBlock.getSuccessors();
            int size3 = successors.size();
            if (size3 == 0) {
                sb.append("  returns\n");
            } else {
                int primarySuccessor = basicBlock.getPrimarySuccessor();
                for (int i5 = 0; i5 < size3; i5++) {
                    int i6 = successors.get(i5);
                    sb.append("  next ");
                    sb.append(Hex.u2(i6));
                    if (size3 != 1 && i6 == primarySuccessor) {
                        sb.append(" *");
                    }
                    sb.append("\n");
                }
            }
        }
        this.suppressDump = false;
        parsed(bytes, 0, bytes.size(), sb.toString());
        this.suppressDump = true;
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void changeIndent(int i) {
        if (this.suppressDump) {
            return;
        }
        super.changeIndent(i);
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
        if ((member instanceof Method) && shouldDumpMethod(str) && (member.getAccessFlags() & 1280) == 0) {
            ConcreteMethod concreteMethod = new ConcreteMethod((Method) member, this.classFile, true, true);
            if (this.rop) {
                ropDump(concreteMethod);
            } else {
                regularDump(concreteMethod);
            }
        }
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void parsed(ByteArray byteArray, int i, int i3, String str) {
        if (this.suppressDump) {
            return;
        }
        super.parsed(byteArray, i, i3, str);
    }

    public boolean shouldDumpMethod(String str) {
        String str2 = this.args.method;
        return str2 == null || str2.equals(str);
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void startParsingMember(ByteArray byteArray, int i, String str, String str2) {
        if (str2.indexOf(40) >= 0 && shouldDumpMethod(str)) {
            this.suppressDump = false;
            if (this.first) {
                this.first = false;
            } else {
                parsed(byteArray, i, 0, "\n");
            }
            parsed(byteArray, i, 0, a.r("method ", str, " ", str2));
            this.suppressDump = true;
        }
    }

    public void dump() {
        ByteArray byteArray = new ByteArray(getBytes());
        DirectClassFile directClassFile = new DirectClassFile(byteArray, getFilePath(), getStrictParse());
        this.classFile = directClassFile;
        StdAttributeFactory stdAttributeFactory = StdAttributeFactory.THE_ONE;
        directClassFile.setAttributeFactory(stdAttributeFactory);
        this.classFile.getMagic();
        DirectClassFile directClassFile2 = new DirectClassFile(byteArray, getFilePath(), getStrictParse());
        directClassFile2.setAttributeFactory(stdAttributeFactory);
        directClassFile2.setObserver(this);
        directClassFile2.getMagic();
    }
}
