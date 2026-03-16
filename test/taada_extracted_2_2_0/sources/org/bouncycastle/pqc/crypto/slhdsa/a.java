package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P3.a f4388a;
    public final Object b;

    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, org.bouncycastle.crypto.Digest] */
    public a(int i, int i3, int i4) {
        super(i, i3, i4);
        new N3.c();
        if (i == 16) {
            this.b = new N3.c();
            this.f4388a = new P3.a(new N3.c());
            new N3.c();
        } else {
            this.b = new N3.f();
            this.f4388a = new P3.a(new N3.f());
            new N3.f();
        }
        byte[] bArr = new byte[this.f4388a.b];
        byte[] bArr2 = new byte[this.b.getDigestSize()];
    }
}
