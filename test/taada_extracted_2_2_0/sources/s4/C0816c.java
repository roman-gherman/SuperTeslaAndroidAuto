package s4;

/* JADX INFO: renamed from: s4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0816c extends B4.a {
    public final byte[] c;
    public final byte[] d;

    public C0816c(C0814a c0814a, byte[] bArr) {
        super((Object) c0814a, false);
        this.c = g5.c.h(bArr, 0, 32);
        this.d = g5.c.h(bArr, 32, bArr.length);
    }

    public C0816c(C0814a c0814a, byte[] bArr, byte[] bArr2) {
        super((Object) c0814a, false);
        this.c = g5.c.c(bArr);
        this.d = g5.c.c(bArr2);
    }
}
