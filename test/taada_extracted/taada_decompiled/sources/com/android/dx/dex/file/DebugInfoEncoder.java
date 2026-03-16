package com.android.dx.dex.file;

import B2.b;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import g.C0476a;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class DebugInfoEncoder {
    private static final boolean DEBUG = false;
    private AnnotatedOutput annotateTo;
    private final int codeSize;
    private PrintWriter debugPrint;
    private final Prototype desc;
    private final DexFile file;
    private final boolean isStatic;
    private final LocalList.Entry[] lastEntryForReg;
    private final LocalList locals;
    private final PositionList positions;
    private String prefix;
    private final int regSize;
    private boolean shouldConsume;
    private int address = 0;
    private int line = 1;
    private final ByteArrayAnnotatedOutput output = new ByteArrayAnnotatedOutput();

    public DebugInfoEncoder(PositionList positionList, LocalList localList, DexFile dexFile, int i, int i3, boolean z6, CstMethodRef cstMethodRef) {
        this.positions = positionList;
        this.locals = localList;
        this.file = dexFile;
        this.desc = cstMethodRef.getPrototype();
        this.isStatic = z6;
        this.codeSize = i;
        this.regSize = i3;
        this.lastEntryForReg = new LocalList.Entry[i3];
    }

    private void annotate(int i, String str) {
        if (this.prefix != null) {
            str = b.h(new StringBuilder(), this.prefix, str);
        }
        AnnotatedOutput annotatedOutput = this.annotateTo;
        if (annotatedOutput != null) {
            if (!this.shouldConsume) {
                i = 0;
            }
            annotatedOutput.annotate(i, str);
        }
        PrintWriter printWriter = this.debugPrint;
        if (printWriter != null) {
            printWriter.println(str);
        }
    }

    private ArrayList<PositionList.Entry> buildSortedPositions() {
        PositionList positionList = this.positions;
        int size = positionList == null ? 0 : positionList.size();
        ArrayList<PositionList.Entry> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.positions.get(i));
        }
        Collections.sort(arrayList, new Comparator<PositionList.Entry>() { // from class: com.android.dx.dex.file.DebugInfoEncoder.1
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return obj == this;
            }

            @Override // java.util.Comparator
            public int compare(PositionList.Entry entry, PositionList.Entry entry2) {
                return entry.getAddress() - entry2.getAddress();
            }
        });
        return arrayList;
    }

    private static int computeOpcode(int i, int i3) {
        if (i < -4 || i > 10) {
            throw new RuntimeException("Parameter out of range");
        }
        return (i3 * 15) + (i - (-4)) + 10;
    }

    private byte[] convert0() {
        ArrayList<PositionList.Entry> arrayListBuildSortedPositions = buildSortedPositions();
        emitHeader(arrayListBuildSortedPositions, extractMethodArguments());
        this.output.writeByte(7);
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(1, String.format("%04x: prologue end", Integer.valueOf(this.address)));
        }
        int size = arrayListBuildSortedPositions.size();
        int size2 = this.locals.size();
        int iEmitLocalsAtAddress = 0;
        int iEmitPositionsAtAddress = 0;
        while (true) {
            iEmitLocalsAtAddress = emitLocalsAtAddress(iEmitLocalsAtAddress);
            iEmitPositionsAtAddress = emitPositionsAtAddress(iEmitPositionsAtAddress, arrayListBuildSortedPositions);
            int address = iEmitLocalsAtAddress < size2 ? this.locals.get(iEmitLocalsAtAddress).getAddress() : Integer.MAX_VALUE;
            int address2 = iEmitPositionsAtAddress < size ? arrayListBuildSortedPositions.get(iEmitPositionsAtAddress).getAddress() : Integer.MAX_VALUE;
            int iMin = Math.min(address2, address);
            if (iMin == Integer.MAX_VALUE || (iMin == this.codeSize && address == Integer.MAX_VALUE && address2 == Integer.MAX_VALUE)) {
                break;
            }
            if (iMin == address2) {
                emitPosition(arrayListBuildSortedPositions.get(iEmitPositionsAtAddress));
                iEmitPositionsAtAddress++;
            } else {
                emitAdvancePc(iMin - this.address);
            }
        }
        emitEndSequence();
        return this.output.toByteArray();
    }

    private void emitAdvanceLine(int i) {
        int cursor = this.output.getCursor();
        this.output.writeByte(2);
        this.output.writeSleb128(i);
        this.line += i;
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("line = %d", Integer.valueOf(this.line)));
    }

    private void emitAdvancePc(int i) {
        int cursor = this.output.getCursor();
        this.output.writeByte(1);
        this.output.writeUleb128(i);
        this.address += i;
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("%04x: advance pc", Integer.valueOf(this.address)));
    }

    private void emitEndSequence() {
        this.output.writeByte(0);
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(1, "end sequence");
    }

    private void emitHeader(ArrayList<PositionList.Entry> arrayList, ArrayList<LocalList.Entry> arrayList2) {
        LocalList.Entry next;
        boolean z6 = (this.annotateTo == null && this.debugPrint == null) ? false : true;
        int cursor = this.output.getCursor();
        if (arrayList.size() > 0) {
            this.line = arrayList.get(0).getPosition().getLine();
        }
        this.output.writeUleb128(this.line);
        if (z6) {
            annotate(this.output.getCursor() - cursor, "line_start: " + this.line);
        }
        int paramBase = getParamBase();
        StdTypeList parameterTypes = this.desc.getParameterTypes();
        int size = parameterTypes.size();
        if (!this.isStatic) {
            Iterator<LocalList.Entry> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LocalList.Entry next2 = it.next();
                if (paramBase == next2.getRegister()) {
                    this.lastEntryForReg[paramBase] = next2;
                    break;
                }
            }
            paramBase++;
        }
        int cursor2 = this.output.getCursor();
        this.output.writeUleb128(size);
        if (z6) {
            annotate(this.output.getCursor() - cursor2, String.format("parameters_size: %04x", Integer.valueOf(size)));
        }
        for (int i = 0; i < size; i++) {
            Type type = parameterTypes.get(i);
            int cursor3 = this.output.getCursor();
            Iterator<LocalList.Entry> it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (paramBase == next.getRegister()) {
                    if (next.getSignature() != null) {
                        emitStringIndex(null);
                    } else {
                        emitStringIndex(next.getName());
                    }
                    this.lastEntryForReg[paramBase] = next;
                }
            }
            if (next == null) {
                emitStringIndex(null);
            }
            if (z6) {
                annotate(this.output.getCursor() - cursor3, "parameter " + ((next == null || next.getSignature() != null) ? "<unnamed>" : next.getName().toHuman()) + " v" + paramBase);
            }
            paramBase += type.getCategory();
        }
        for (LocalList.Entry entry : this.lastEntryForReg) {
            if (entry != null && entry.getSignature() != null) {
                emitLocalStartExtended(entry);
            }
        }
    }

    private void emitLocalEnd(LocalList.Entry entry) {
        int cursor = this.output.getCursor();
        this.output.writeByte(5);
        this.output.writeUleb128(entry.getRegister());
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("%04x: -local %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
    }

    private void emitLocalRestart(LocalList.Entry entry) {
        int cursor = this.output.getCursor();
        this.output.writeByte(6);
        emitUnsignedLeb128(entry.getRegister());
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("%04x: +local restart %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
    }

    private void emitLocalStart(LocalList.Entry entry) {
        if (entry.getSignature() != null) {
            emitLocalStartExtended(entry);
            return;
        }
        int cursor = this.output.getCursor();
        this.output.writeByte(3);
        emitUnsignedLeb128(entry.getRegister());
        emitStringIndex(entry.getName());
        emitTypeIndex(entry.getType());
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("%04x: +local %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
    }

    private void emitLocalStartExtended(LocalList.Entry entry) {
        int cursor = this.output.getCursor();
        this.output.writeByte(4);
        emitUnsignedLeb128(entry.getRegister());
        emitStringIndex(entry.getName());
        emitTypeIndex(entry.getType());
        emitStringIndex(entry.getSignature());
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(this.output.getCursor() - cursor, String.format("%04x: +localx %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
    }

    private int emitLocalsAtAddress(int i) {
        int size = this.locals.size();
        while (i < size && this.locals.get(i).getAddress() == this.address) {
            int i3 = i + 1;
            LocalList.Entry entry = this.locals.get(i);
            int register = entry.getRegister();
            LocalList.Entry[] entryArr = this.lastEntryForReg;
            LocalList.Entry entry2 = entryArr[register];
            if (entry != entry2) {
                entryArr[register] = entry;
                if (entry.isStart()) {
                    if (entry2 == null || !entry.matches(entry2)) {
                        emitLocalStart(entry);
                    } else {
                        if (entry2.isStart()) {
                            throw new RuntimeException("shouldn't happen");
                        }
                        emitLocalRestart(entry);
                    }
                } else if (entry.getDisposition() != LocalList.Disposition.END_REPLACED) {
                    emitLocalEnd(entry);
                }
            }
            i = i3;
        }
        return i;
    }

    private void emitPosition(PositionList.Entry entry) {
        int line = entry.getPosition().getLine();
        int address = entry.getAddress();
        int i = line - this.line;
        int i3 = address - this.address;
        if (i3 < 0) {
            throw new RuntimeException("Position entries must be in ascending address order");
        }
        int i4 = 0;
        if (i < -4 || i > 10) {
            emitAdvanceLine(i);
            i = 0;
        }
        int iComputeOpcode = computeOpcode(i, i3);
        if ((iComputeOpcode & (-256)) > 0) {
            emitAdvancePc(i3);
            iComputeOpcode = computeOpcode(i, 0);
            if ((iComputeOpcode & (-256)) > 0) {
                emitAdvanceLine(i);
                iComputeOpcode = computeOpcode(0, 0);
                i3 = 0;
            } else {
                i3 = 0;
                i4 = i;
            }
        } else {
            i4 = i;
        }
        this.output.writeByte(iComputeOpcode);
        this.line += i4;
        int i5 = this.address + i3;
        this.address = i5;
        if (this.annotateTo == null && this.debugPrint == null) {
            return;
        }
        annotate(1, String.format("%04x: line %d", Integer.valueOf(i5), Integer.valueOf(this.line)));
    }

    private int emitPositionsAtAddress(int i, ArrayList<PositionList.Entry> arrayList) {
        int size = arrayList.size();
        while (i < size && arrayList.get(i).getAddress() == this.address) {
            emitPosition(arrayList.get(i));
            i++;
        }
        return i;
    }

    private void emitStringIndex(CstString cstString) {
        DexFile dexFile;
        if (cstString == null || (dexFile = this.file) == null) {
            this.output.writeUleb128(0);
        } else {
            this.output.writeUleb128(dexFile.getStringIds().indexOf(cstString) + 1);
        }
    }

    private void emitTypeIndex(CstType cstType) {
        DexFile dexFile;
        if (cstType == null || (dexFile = this.file) == null) {
            this.output.writeUleb128(0);
        } else {
            this.output.writeUleb128(dexFile.getTypeIds().indexOf(cstType) + 1);
        }
    }

    private void emitUnsignedLeb128(int i) {
        if (i < 0) {
            throw new RuntimeException(b.c(i, "Signed value where unsigned required: "));
        }
        this.output.writeUleb128(i);
    }

    private String entryAnnotationString(LocalList.Entry entry) {
        StringBuilder sb = new StringBuilder(RegisterSpec.PREFIX);
        sb.append(entry.getRegister());
        sb.append(' ');
        CstString name = entry.getName();
        if (name == null) {
            sb.append("null");
        } else {
            sb.append(name.toHuman());
        }
        sb.append(' ');
        CstType type = entry.getType();
        if (type == null) {
            sb.append("null");
        } else {
            sb.append(type.toHuman());
        }
        CstString signature = entry.getSignature();
        if (signature != null) {
            sb.append(' ');
            sb.append(signature.toHuman());
        }
        return sb.toString();
    }

    private ArrayList<LocalList.Entry> extractMethodArguments() {
        ArrayList<LocalList.Entry> arrayList = new ArrayList<>(this.desc.getParameterTypes().size());
        int paramBase = getParamBase();
        BitSet bitSet = new BitSet(this.regSize - paramBase);
        int size = this.locals.size();
        for (int i = 0; i < size; i++) {
            LocalList.Entry entry = this.locals.get(i);
            int register = entry.getRegister();
            if (register >= paramBase) {
                int i3 = register - paramBase;
                if (!bitSet.get(i3)) {
                    bitSet.set(i3);
                    arrayList.add(entry);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<LocalList.Entry>() { // from class: com.android.dx.dex.file.DebugInfoEncoder.2
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return obj == this;
            }

            @Override // java.util.Comparator
            public int compare(LocalList.Entry entry2, LocalList.Entry entry3) {
                return entry2.getRegister() - entry3.getRegister();
            }
        });
        return arrayList;
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (!this.isStatic ? 1 : 0);
    }

    public byte[] convert() {
        try {
            return convert0();
        } catch (IOException e) {
            throw C0476a.withContext(e, "...while encoding debug info");
        }
    }

    public byte[] convertAndAnnotate(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z6) {
        this.prefix = str;
        this.debugPrint = printWriter;
        this.annotateTo = annotatedOutput;
        this.shouldConsume = z6;
        return convert();
    }
}
