package I1;

import io.ktor.utils.io.bits.Allocator;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends K1.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Allocator f759h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e() {
        super(1000);
        G1.a aVar = G1.a.f420a;
        this.f758g = 4096;
        this.f759h = aVar;
    }

    @Override // K1.e
    public final Object c(Object obj) {
        J1.b bVar = (J1.b) obj;
        bVar.m();
        bVar.k();
        return bVar;
    }

    @Override // K1.e
    public final void d(Object obj) {
        J1.b bVar = (J1.b) obj;
        this.f759h.mo3free3GNKZMM(bVar.f750a);
        if (!J1.b.i.compareAndSet(bVar, 0, -1)) {
            throw new IllegalStateException("Unable to unlink: buffer is in use.");
        }
        bVar.g();
    }

    @Override // K1.e
    public final Object e() {
        return new J1.b(this.f759h.mo1allocgFvZug(this.f758g), this);
    }

    @Override // K1.e
    public final void g(Object obj) {
        J1.b bVar = (J1.b) obj;
        long jLimit = bVar.f750a.limit();
        int i = this.f758g;
        if (jLimit != i) {
            StringBuilder sbJ = B2.b.j(i, "Buffer size mismatch. Expected: ", ", actual: ");
            sbJ.append(r0.limit());
            throw new IllegalStateException(sbJ.toString().toString());
        }
        J1.b bVar2 = J1.b.f828k;
        if (bVar == bVar2) {
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled");
        }
        if (bVar == bVar2) {
            throw new IllegalStateException("Empty instance couldn't be recycled");
        }
        if (bVar.i() != 0) {
            throw new IllegalStateException("Unable to clear buffer: it is still in use.");
        }
        if (bVar.h() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.");
        }
    }
}
