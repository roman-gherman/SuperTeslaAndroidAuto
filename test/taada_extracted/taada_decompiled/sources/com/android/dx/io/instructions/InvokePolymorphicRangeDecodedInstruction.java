package com.android.dx.io.instructions;

import B2.b;
import com.android.dx.io.IndexType;

/* JADX INFO: loaded from: classes.dex */
public class InvokePolymorphicRangeDecodedInstruction extends DecodedInstruction {
    private final int c;
    private final int protoIndex;
    private final int registerCount;

    public InvokePolymorphicRangeDecodedInstruction(InstructionCodec instructionCodec, int i, int i3, IndexType indexType, int i4, int i5, int i6) {
        super(instructionCodec, i, i3, indexType, 0, 0L);
        if (i6 != ((short) i6)) {
            throw new IllegalArgumentException(b.c(i6, "protoIndex doesn't fit in a short: "));
        }
        this.c = i4;
        this.registerCount = i5;
        this.protoIndex = i6;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        return this.c;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public short getProtoIndex() {
        return (short) this.protoIndex;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i) {
        throw new UnsupportedOperationException("use withProtoIndex to update both the method and proto indices for invoke-polymorphic/range");
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withProtoIndex(int i, int i3) {
        return new InvokePolymorphicRangeDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), this.c, this.registerCount, i3);
    }
}
