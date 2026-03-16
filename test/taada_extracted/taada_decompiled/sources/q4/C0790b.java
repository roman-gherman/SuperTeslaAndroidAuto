package q4;

/* JADX INFO: renamed from: q4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0790b extends B4.a {
    public byte[] c;
    public byte[] d;
    public byte[] e;

    public final byte[] getEncoded() {
        byte[] bArr = this.c;
        byte[] bArr2 = this.d;
        byte[] bArr3 = this.e;
        if (bArr == null) {
            return g5.c.e(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return g5.c.e(bArr, bArr3);
        }
        if (bArr3 == null) {
            return g5.c.e(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }
}
