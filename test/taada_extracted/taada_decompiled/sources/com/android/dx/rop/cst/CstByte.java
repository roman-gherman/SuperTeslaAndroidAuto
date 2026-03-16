package com.android.dx.rop.cst;

import B2.b;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public final class CstByte extends CstLiteral32 {
    public static final CstByte VALUE_0 = make((byte) 0);

    private CstByte(byte b) {
        super(b);
    }

    public static CstByte make(byte b) {
        return new CstByte(b);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.BYTE;
    }

    public byte getValue() {
        return (byte) getIntBits();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        int intBits = getIntBits();
        return "byte{0x" + Hex.u1(intBits) + " / " + intBits + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "byte";
    }

    public static CstByte make(int i) {
        byte b = (byte) i;
        if (b == i) {
            return make(b);
        }
        throw new IllegalArgumentException(b.c(i, "bogus byte value: "));
    }
}
