package com.android.dx.rop.cst;

import B2.b;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public final class CstChar extends CstLiteral32 {
    public static final CstChar VALUE_0 = make((char) 0);

    private CstChar(char c) {
        super(c);
    }

    public static CstChar make(char c) {
        return new CstChar(c);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.CHAR;
    }

    public char getValue() {
        return (char) getIntBits();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        int intBits = getIntBits();
        return "char{0x" + Hex.u2(intBits) + " / " + intBits + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "char";
    }

    public static CstChar make(int i) {
        char c = (char) i;
        if (c == i) {
            return make(c);
        }
        throw new IllegalArgumentException(b.c(i, "bogus char value: "));
    }
}
