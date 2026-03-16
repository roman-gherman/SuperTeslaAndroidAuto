package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f3881a;
    public u b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f3883g;

    public y(z zVar) {
        this.f3883g = zVar;
        w wVar = new w(zVar);
        this.f3881a = wVar;
        u next = wVar.next();
        this.b = next;
        this.c = next.b.length;
        this.d = 0;
        this.e = 0;
    }

    public final void a() {
        if (this.b != null) {
            int i = this.d;
            int i3 = this.c;
            if (i == i3) {
                this.e += i3;
                this.d = 0;
                if (!this.f3881a.hasNext()) {
                    this.b = null;
                    this.c = 0;
                } else {
                    u next = this.f3881a.next();
                    this.b = next;
                    this.c = next.b.length;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f3883g.b - (this.e + this.d);
    }

    public final int b(byte[] bArr, int i, int i3) {
        int i4 = i3;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            a();
            if (this.b != null) {
                int iMin = Math.min(this.c - this.d, i4);
                if (bArr != null) {
                    this.b.c(bArr, this.d, i, iMin);
                    i += iMin;
                }
                this.d += iMin;
                i4 -= iMin;
            } else if (i4 == i3) {
                return -1;
            }
        }
        return i3 - i4;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f3882f = this.e + this.d;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) {
        bArr.getClass();
        if (i < 0 || i3 < 0 || i3 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        return b(bArr, i, i3);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        w wVar = new w(this.f3883g);
        this.f3881a = wVar;
        u next = wVar.next();
        this.b = next;
        this.c = next.b.length;
        this.d = 0;
        this.e = 0;
        b(null, 0, this.f3882f);
    }

    @Override // java.io.InputStream
    public final long skip(long j6) {
        if (j6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j6 > 2147483647L) {
            j6 = 2147483647L;
        }
        return b(null, 0, (int) j6);
    }

    @Override // java.io.InputStream
    public final int read() {
        a();
        u uVar = this.b;
        if (uVar == null) {
            return -1;
        }
        int i = this.d;
        this.d = i + 1;
        return uVar.b[i] & 255;
    }
}
