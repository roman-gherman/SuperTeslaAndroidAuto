package z;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class j extends i {
    public final byte[] d;

    public j(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.d = bArr;
    }

    @Override // z.i
    public final byte[] c() {
        return this.d;
    }
}
