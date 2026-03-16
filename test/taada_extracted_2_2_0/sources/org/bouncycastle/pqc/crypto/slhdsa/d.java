package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements SLHDSAEngineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4389a;
    public final int b;
    public final int c;
    public final int d;

    public /* synthetic */ d(int i, int i3, int i4, int i5, int i6, int i7) {
        this.f4389a = i7;
        this.b = i;
        this.c = i3;
        this.d = i6;
    }

    @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAEngineProvider
    public final c get() {
        switch (this.f4389a) {
            case 0:
                return new a(this.b, this.c, this.d);
            default:
                b bVar = new b(this.b, this.c, this.d);
                new N3.g(256);
                new N3.g(256);
                return bVar;
        }
    }

    @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAEngineProvider
    public final int getN() {
        switch (this.f4389a) {
        }
        return this.b;
    }
}
