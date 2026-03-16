package Y3;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1490a;
    public final byte[] b;
    public final c c;
    public final boolean d;

    public d(c cVar, byte[] bArr) {
        if (bArr.length != 64) {
            throw new IllegalArgumentException("incorrect length for seed");
        }
        this.d = true;
        this.c = cVar;
        this.f1490a = g5.c.c(bArr);
        this.b = null;
    }

    public d(c cVar, byte[] bArr, byte[] bArr2) {
        this.d = false;
        this.c = cVar;
        this.f1490a = g5.c.c(bArr);
        this.b = g5.c.c(bArr2);
    }
}
