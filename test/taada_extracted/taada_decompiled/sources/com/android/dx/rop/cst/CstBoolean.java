package com.android.dx.rop.cst;

import B2.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.dx.rop.type.Type;

/* JADX INFO: loaded from: classes.dex */
public final class CstBoolean extends CstLiteral32 {
    public static final CstBoolean VALUE_FALSE = new CstBoolean(false);
    public static final CstBoolean VALUE_TRUE = new CstBoolean(true);

    private CstBoolean(boolean z6) {
        super(z6 ? 1 : 0);
    }

    public static CstBoolean make(boolean z6) {
        return z6 ? VALUE_TRUE : VALUE_FALSE;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.BOOLEAN;
    }

    public boolean getValue() {
        return getIntBits() != 0;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return getValue() ? "true" : "false";
    }

    public String toString() {
        return getValue() ? "boolean{true}" : "boolean{false}";
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return TypedValues.Custom.S_BOOLEAN;
    }

    public static CstBoolean make(int i) {
        if (i == 0) {
            return VALUE_FALSE;
        }
        if (i == 1) {
            return VALUE_TRUE;
        }
        throw new IllegalArgumentException(b.c(i, "bogus value: "));
    }
}
