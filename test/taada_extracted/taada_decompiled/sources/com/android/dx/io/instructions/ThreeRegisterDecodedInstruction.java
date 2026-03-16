package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* JADX INFO: loaded from: classes.dex */
public final class ThreeRegisterDecodedInstruction extends DecodedInstruction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1869a;
    private final int b;
    private final int c;

    public ThreeRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i3, IndexType indexType, int i4, long j6, int i5, int i6, int i7) {
        super(instructionCodec, i, i3, indexType, i4, j6);
        this.f1869a = i5;
        this.b = i6;
        this.c = i7;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1869a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getB() {
        return this.b;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        return this.c;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 3;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i) {
        return new ThreeRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f1869a, this.b, this.c);
    }
}
