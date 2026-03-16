package m1;

import u1.AbstractC0838c;
import u1.C0840e;

/* JADX INFO: renamed from: m1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0643l extends v1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0840e f4058a;
    public final long b;
    public final /* synthetic */ Object c;

    public C0643l(C0840e c0840e, Object obj) {
        this.c = obj;
        if (c0840e == null) {
            C0840e c0840e2 = AbstractC0838c.f4860a;
            c0840e = AbstractC0838c.b;
        }
        this.f4058a = c0840e;
        this.b = ((byte[]) obj).length;
    }

    @Override // v1.g
    public final Long a() {
        return Long.valueOf(this.b);
    }

    @Override // v1.g
    public final C0840e b() {
        return this.f4058a;
    }

    @Override // v1.e
    public final byte[] d() {
        return (byte[]) this.c;
    }
}
