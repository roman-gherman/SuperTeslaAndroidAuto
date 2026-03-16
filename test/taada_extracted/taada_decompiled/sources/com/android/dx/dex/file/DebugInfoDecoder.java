package com.android.dx.dex.file;

import B2.b;
import C5.f;
import com.android.billingclient.api.z;
import com.android.dex.util.ByteInput;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import g.C0476a;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DebugInfoDecoder {
    private final int codesize;
    private final Prototype desc;
    private final byte[] encoded;
    private final DexFile file;
    private final boolean isStatic;
    private final LocalEntry[] lastEntryForReg;
    private final ArrayList<LocalEntry> locals;
    private final ArrayList<PositionEntry> positions;
    private final int regSize;
    private final int thisStringIdx;
    private int line = 1;
    private int address = 0;

    public static class LocalEntry {
        public int address;
        public boolean isStart;
        public int nameIndex;
        public int reg;
        public int signatureIndex;
        public int typeIndex;

        public LocalEntry(int i, boolean z6, int i3, int i4, int i5, int i6) {
            this.address = i;
            this.isStart = z6;
            this.reg = i3;
            this.nameIndex = i4;
            this.typeIndex = i5;
            this.signatureIndex = i6;
        }

        public String toString() {
            return String.format("[%x %s v%d %04x %04x %04x]", Integer.valueOf(this.address), this.isStart ? "start" : "end", Integer.valueOf(this.reg), Integer.valueOf(this.nameIndex), Integer.valueOf(this.typeIndex), Integer.valueOf(this.signatureIndex));
        }
    }

    public static class PositionEntry {
        public int address;
        public int line;

        public PositionEntry(int i, int i3) {
            this.address = i;
            this.line = i3;
        }
    }

    public DebugInfoDecoder(byte[] bArr, int i, int i3, boolean z6, CstMethodRef cstMethodRef, DexFile dexFile) {
        int iIndexOf;
        if (bArr == null) {
            throw new NullPointerException("encoded == null");
        }
        this.encoded = bArr;
        this.isStatic = z6;
        this.desc = cstMethodRef.getPrototype();
        this.file = dexFile;
        this.regSize = i3;
        this.positions = new ArrayList<>();
        this.locals = new ArrayList<>();
        this.codesize = i;
        this.lastEntryForReg = new LocalEntry[i3];
        try {
            iIndexOf = dexFile.getStringIds().indexOf(new CstString("this"));
        } catch (IllegalArgumentException unused) {
            iIndexOf = -1;
        }
        this.thisStringIdx = iIndexOf;
    }

    private void decode0() {
        z zVar = new z(this.encoded);
        this.line = f.Z(zVar);
        int iZ = f.Z(zVar);
        StdTypeList parameterTypes = this.desc.getParameterTypes();
        int paramBase = getParamBase();
        if (iZ != parameterTypes.size()) {
            throw new RuntimeException("Mismatch between parameters_size and prototype");
        }
        if (!this.isStatic) {
            LocalEntry localEntry = new LocalEntry(0, true, paramBase, this.thisStringIdx, 0, 0);
            this.locals.add(localEntry);
            this.lastEntryForReg[paramBase] = localEntry;
            paramBase++;
        }
        int category = paramBase;
        for (int i = 0; i < iZ; i++) {
            Type type = parameterTypes.getType(i);
            int stringIndex = readStringIndex(zVar);
            LocalEntry localEntry2 = stringIndex == -1 ? new LocalEntry(0, true, category, -1, 0, 0) : new LocalEntry(0, true, category, stringIndex, 0, 0);
            this.locals.add(localEntry2);
            this.lastEntryForReg[category] = localEntry2;
            category += type.getCategory();
        }
        while (true) {
            int i3 = zVar.readByte() & 255;
            switch (i3) {
                case 0:
                    return;
                case 1:
                    this.address = f.Z(zVar) + this.address;
                    break;
                case 2:
                    this.line = f.Y(zVar) + this.line;
                    break;
                case 3:
                    int iZ2 = f.Z(zVar);
                    LocalEntry localEntry3 = new LocalEntry(this.address, true, iZ2, readStringIndex(zVar), readStringIndex(zVar), 0);
                    this.locals.add(localEntry3);
                    this.lastEntryForReg[iZ2] = localEntry3;
                    break;
                case 4:
                    int iZ3 = f.Z(zVar);
                    LocalEntry localEntry4 = new LocalEntry(this.address, true, iZ3, readStringIndex(zVar), readStringIndex(zVar), readStringIndex(zVar));
                    this.locals.add(localEntry4);
                    this.lastEntryForReg[iZ3] = localEntry4;
                    break;
                case 5:
                    int iZ4 = f.Z(zVar);
                    try {
                        LocalEntry localEntry5 = this.lastEntryForReg[iZ4];
                        if (!localEntry5.isStart) {
                            throw new RuntimeException("nonsensical END_LOCAL on dead register v" + iZ4);
                        }
                        LocalEntry localEntry6 = new LocalEntry(this.address, false, iZ4, localEntry5.nameIndex, localEntry5.typeIndex, localEntry5.signatureIndex);
                        this.locals.add(localEntry6);
                        this.lastEntryForReg[iZ4] = localEntry6;
                    } catch (NullPointerException unused) {
                        throw new RuntimeException(b.c(iZ4, "Encountered END_LOCAL on new v"));
                    }
                    break;
                case 6:
                    int iZ5 = f.Z(zVar);
                    try {
                        LocalEntry localEntry7 = this.lastEntryForReg[iZ5];
                        if (localEntry7.isStart) {
                            throw new RuntimeException("nonsensical RESTART_LOCAL on live register v" + iZ5);
                        }
                        LocalEntry localEntry8 = new LocalEntry(this.address, true, iZ5, localEntry7.nameIndex, localEntry7.typeIndex, 0);
                        this.locals.add(localEntry8);
                        this.lastEntryForReg[iZ5] = localEntry8;
                    } catch (NullPointerException unused2) {
                        throw new RuntimeException(b.c(iZ5, "Encountered RESTART_LOCAL on new v"));
                    }
                    break;
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    if (i3 < 10) {
                        throw new RuntimeException(b.c(i3, "Invalid extended opcode encountered "));
                    }
                    int i4 = ((i3 - 10) / 15) + this.address;
                    this.address = i4;
                    int i5 = ((r1 % 15) - 4) + this.line;
                    this.line = i5;
                    this.positions.add(new PositionEntry(i4, i5));
                    break;
                    break;
            }
        }
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (!this.isStatic ? 1 : 0);
    }

    private int readStringIndex(ByteInput byteInput) {
        return f.Z(byteInput) - 1;
    }

    public static void validateEncode(byte[] bArr, DexFile dexFile, CstMethodRef cstMethodRef, DalvCode dalvCode, boolean z6) {
        PositionList positions = dalvCode.getPositions();
        LocalList locals = dalvCode.getLocals();
        DalvInsnList insns = dalvCode.getInsns();
        try {
            validateEncode0(bArr, insns.codeSize(), insns.getRegistersSize(), z6, cstMethodRef, dexFile, positions, locals);
        } catch (RuntimeException e) {
            System.err.println("instructions:");
            insns.debugPrint((OutputStream) System.err, "  ", true);
            System.err.println("local list:");
            locals.debugPrint(System.err, "  ");
            throw C0476a.withContext(e, "while processing " + cstMethodRef.toHuman());
        }
    }

    private static void validateEncode0(byte[] bArr, int i, int i3, boolean z6, CstMethodRef cstMethodRef, DexFile dexFile, PositionList positionList, LocalList localList) {
        LocalEntry localEntry;
        DebugInfoDecoder debugInfoDecoder = new DebugInfoDecoder(bArr, i, i3, z6, cstMethodRef, dexFile);
        debugInfoDecoder.decode();
        List<PositionEntry> positionList2 = debugInfoDecoder.getPositionList();
        if (positionList2.size() != positionList.size()) {
            throw new RuntimeException("Decoded positions table not same size was " + positionList2.size() + " expected " + positionList.size());
        }
        for (PositionEntry positionEntry : positionList2) {
            for (int size = positionList.size() - 1; size >= 0; size--) {
                PositionList.Entry entry = positionList.get(size);
                if (positionEntry.line != entry.getPosition().getLine() || positionEntry.address != entry.getAddress()) {
                }
            }
            throw new RuntimeException("Could not match position entry: " + positionEntry.address + ", " + positionEntry.line);
        }
        List<LocalEntry> locals = debugInfoDecoder.getLocals();
        int i4 = debugInfoDecoder.thisStringIdx;
        int size2 = locals.size();
        int paramBase = debugInfoDecoder.getParamBase();
        for (int i5 = 0; i5 < size2; i5++) {
            LocalEntry localEntry2 = locals.get(i5);
            int i6 = localEntry2.nameIndex;
            if (i6 < 0 || i6 == i4) {
                int i7 = i5 + 1;
                while (true) {
                    if (i7 < size2) {
                        LocalEntry localEntry3 = locals.get(i7);
                        if (localEntry3.address == 0) {
                            if (localEntry2.reg == localEntry3.reg && localEntry3.isStart) {
                                locals.set(i5, localEntry3);
                                locals.remove(i7);
                                size2--;
                                break;
                            }
                            i7++;
                        }
                    }
                }
            }
        }
        int size3 = localList.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size3; i9++) {
            LocalList.Entry entry2 = localList.get(i9);
            if (entry2.getDisposition() != LocalList.Disposition.END_REPLACED) {
                do {
                    localEntry = locals.get(i8);
                    if (localEntry.nameIndex >= 0) {
                        break;
                    } else {
                        i8++;
                    }
                } while (i8 < size2);
                int i10 = localEntry.address;
                if (localEntry.reg != entry2.getRegister()) {
                    System.err.println("local register mismatch at orig " + i9 + " / decoded " + i8);
                } else if (localEntry.isStart != entry2.isStart()) {
                    System.err.println("local start/end mismatch at orig " + i9 + " / decoded " + i8);
                } else if (i10 == entry2.getAddress() || (i10 == 0 && localEntry.reg >= paramBase)) {
                    i8++;
                } else {
                    System.err.println("local address mismatch at orig " + i9 + " / decoded " + i8);
                }
                System.err.println("decoded locals:");
                for (LocalEntry localEntry4 : locals) {
                    System.err.println("  " + localEntry4);
                }
                throw new RuntimeException("local table problem");
            }
        }
    }

    public void decode() {
        try {
            decode0();
        } catch (Exception e) {
            throw C0476a.withContext(e, "...while decoding debug info");
        }
    }

    public List<LocalEntry> getLocals() {
        return this.locals;
    }

    public List<PositionEntry> getPositionList() {
        return this.positions;
    }
}
