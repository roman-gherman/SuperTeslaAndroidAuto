package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends B4.a {
    public final byte[] c;
    public final byte[] d;

    public d(C0938b c0938b, byte[] bArr) {
        super((Object) c0938b, false);
        this.c = g5.c.h(bArr, 0, 32);
        byte[] bArrH = g5.c.h(bArr, 32, bArr.length);
        this.d = bArrH;
        if (bArrH.length == 0) {
            throw new IllegalArgumentException("encoding too short");
        }
    }

    public d(C0938b c0938b, byte[] bArr, byte[] bArr2) {
        super((Object) c0938b, false);
        if (bArr == null) {
            throw new NullPointerException("rho cannot be null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("t1 cannot be null");
        }
        this.c = g5.c.c(bArr);
        this.d = g5.c.c(bArr2);
    }
}
