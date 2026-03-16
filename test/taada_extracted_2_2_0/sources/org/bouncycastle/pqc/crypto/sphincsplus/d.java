package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements SPHINCSPlusEngineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4407a;
    public final int b;
    public final int c;
    public final int d;

    public /* synthetic */ d(boolean z6, int i, int i3, int i4, int i5, int i6, int i7) {
        this.f4407a = i7;
        this.b = i;
        this.c = i3;
        this.d = i6;
    }

    @Override // org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngineProvider
    public final c get() {
        switch (this.f4407a) {
            case 0:
                return new a(this.b, this.c, this.d);
            case 1:
                return new b(this.b, this.c, this.d);
            default:
                a aVar = new a(this.b, this.c, this.d);
                new N3.g(256);
                new N3.g(256);
                return aVar;
        }
    }

    @Override // org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngineProvider
    public final int getN() {
        switch (this.f4407a) {
        }
        return this.b;
    }
}
