package com.android.dx.io.instructions;

import B2.b;
import com.android.dx.io.IndexType;

/* JADX INFO: loaded from: classes.dex */
public class InvokePolymorphicDecodedInstruction extends DecodedInstruction {
    private final int protoIndex;
    private final int[] registers;

    public InvokePolymorphicDecodedInstruction(InstructionCodec instructionCodec, int i, int i3, IndexType indexType, int i4, int[] iArr) {
        super(instructionCodec, i, i3, indexType, 0, 0L);
        if (i4 != ((short) i4)) {
            throw new IllegalArgumentException(b.c(i4, "protoIndex doesn't fit in a short: "));
        }
        this.protoIndex = i4;
        this.registers = iArr;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        int[] iArr = this.registers;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return 0;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getD() {
        int[] iArr = this.registers;
        if (iArr.length > 1) {
            return iArr[1];
        }
        return 0;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getE() {
        int[] iArr = this.registers;
        if (iArr.length > 2) {
            return iArr[2];
        }
        return 0;
    }

    public int getF() {
        int[] iArr = this.registers;
        if (iArr.length > 3) {
            return iArr[3];
        }
        return 0;
    }

    public int getG() {
        int[] iArr = this.registers;
        if (iArr.length > 4) {
            return iArr[4];
        }
        return 0;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public short getProtoIndex() {
        return (short) this.protoIndex;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return this.registers.length;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i) {
        throw new UnsupportedOperationException("use withProtoIndex to update both the method and proto indices for invoke-polymorphic");
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withProtoIndex(int i, int i3) {
        return new InvokePolymorphicDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), i3, this.registers);
    }
}
