package com.android.dx.rop.cst;

/* JADX INFO: loaded from: classes.dex */
public abstract class CstLiteral64 extends CstLiteralBits {
    private final long bits;

    public CstLiteral64(long j6) {
        this.bits = j6;
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        long j6 = ((CstLiteral64) constant).bits;
        long j7 = this.bits;
        if (j7 < j6) {
            return -1;
        }
        return j7 > j6 ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.bits == ((CstLiteral64) obj).bits;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final boolean fitsInInt() {
        long j6 = this.bits;
        return ((long) ((int) j6)) == j6;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final int getIntBits() {
        return (int) this.bits;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final long getLongBits() {
        return this.bits;
    }

    public final int hashCode() {
        long j6 = this.bits;
        return ((int) (j6 >> 32)) ^ ((int) j6);
    }

    @Override // com.android.dx.rop.cst.Constant
    public final boolean isCategory2() {
        return true;
    }
}
