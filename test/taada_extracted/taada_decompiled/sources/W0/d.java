package w0;

/* JADX INFO: loaded from: classes.dex */
public final class d extends V2.a {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(byte[] bArr, int i) {
        super(bArr);
        this.d = i;
    }

    @Override // V2.a
    public final c e(int i, byte[] bArr) {
        switch (this.d) {
            case 0:
                return new c(bArr, i, 0);
            default:
                return new c(bArr, i, 1);
        }
    }
}
