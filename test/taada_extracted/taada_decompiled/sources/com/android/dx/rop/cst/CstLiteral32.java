package com.android.dx.rop.cst;

/* JADX INFO: loaded from: classes.dex */
public abstract class CstLiteral32 extends CstLiteralBits {
    private final int bits;

    public CstLiteral32(int i) {
        this.bits = i;
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        int i = ((CstLiteral32) constant).bits;
        int i3 = this.bits;
        if (i3 < i) {
            return -1;
        }
        return i3 > i ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.bits == ((CstLiteral32) obj).bits;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final boolean fitsInInt() {
        return true;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final int getIntBits() {
        return this.bits;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final long getLongBits() {
        return this.bits;
    }

    public final int hashCode() {
        return this.bits;
    }

    @Override // com.android.dx.rop.cst.Constant
    public final boolean isCategory2() {
        return false;
    }
}
