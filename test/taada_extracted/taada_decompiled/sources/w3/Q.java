package w3;

/* JADX INFO: loaded from: classes2.dex */
public final class Q extends C0889g {
    @Override // w3.C0889g, w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(k(), 24, z6);
    }

    @Override // w3.C0889g, w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(k().length, z6);
    }

    @Override // w3.C0889g, w3.AbstractC0899q
    public final AbstractC0899q h() {
        return this;
    }

    @Override // w3.AbstractC0899q
    public final AbstractC0899q i() {
        return this;
    }

    public final byte[] k() {
        byte[] bArr = this.f5056a;
        if (bArr[bArr.length - 1] == 90) {
            if (!j(10) || !j(11)) {
                byte[] bArr2 = new byte[bArr.length + 4];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 1);
                String str = g5.e.f3346a;
                byte[] bArr3 = new byte[5];
                for (int i = 0; i != 5; i++) {
                    bArr3[i] = (byte) "0000Z".charAt(i);
                }
                System.arraycopy(bArr3, 0, bArr2, bArr.length - 1, 5);
                return bArr2;
            }
            if (!j(12) || !j(13)) {
                byte[] bArr4 = new byte[bArr.length + 2];
                System.arraycopy(bArr, 0, bArr4, 0, bArr.length - 1);
                String str2 = g5.e.f3346a;
                byte[] bArr5 = new byte[3];
                for (int i3 = 0; i3 != 3; i3++) {
                    bArr5[i3] = (byte) "00Z".charAt(i3);
                }
                System.arraycopy(bArr5, 0, bArr4, bArr.length - 1, 3);
                return bArr4;
            }
            for (int i4 = 0; i4 != bArr.length; i4++) {
                if (bArr[i4] == 46 && i4 == 14) {
                    int length = bArr.length - 2;
                    while (length > 0 && bArr[length] == 48) {
                        length--;
                    }
                    if (bArr[length] == 46) {
                        byte[] bArr6 = new byte[length + 1];
                        System.arraycopy(bArr, 0, bArr6, 0, length);
                        bArr6[length] = 90;
                        return bArr6;
                    }
                    byte[] bArr7 = new byte[length + 2];
                    int i5 = length + 1;
                    System.arraycopy(bArr, 0, bArr7, 0, i5);
                    bArr7[i5] = 90;
                    return bArr7;
                }
            }
        }
        return bArr;
    }
}
