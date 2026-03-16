package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* JADX INFO: loaded from: classes.dex */
public final class RegisterRangeDecodedInstruction extends DecodedInstruction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1868a;
    private final int registerCount;

    public RegisterRangeDecodedInstruction(InstructionCodec instructionCodec, int i, int i3, IndexType indexType, int i4, long j6, int i5, int i6) {
        super(instructionCodec, i, i3, indexType, i4, j6);
        this.f1868a = i5;
        this.registerCount = i6;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1868a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i) {
        return new RegisterRangeDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f1868a, this.registerCount);
    }
}
