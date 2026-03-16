package com.android.dx.io.instructions;

/* JADX INFO: loaded from: classes.dex */
public final class PackedSwitchPayloadDecodedInstruction extends DecodedInstruction {
    private final int firstKey;
    private final int[] targets;

    public PackedSwitchPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, int i3, int[] iArr) {
        super(instructionCodec, i, 0, null, 0, 0L);
        this.firstKey = i3;
        this.targets = iArr;
    }

    public int getFirstKey() {
        return this.firstKey;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 0;
    }

    public int[] getTargets() {
        return this.targets;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i) {
        throw new UnsupportedOperationException("no index in instruction");
    }
}
