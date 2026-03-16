package I1;

import E1.k;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectPool f760a;
    public J1.b b;
    public ByteBuffer c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f762g;

    public f(J1.b head, long j6, ObjectPool pool) {
        h.f(head, "head");
        h.f(pool, "pool");
        this.f760a = pool;
        this.b = head;
        this.c = head.f750a;
        int i = head.b;
        this.d = i;
        int i3 = head.c;
        this.e = i3;
        this.f761f = j6 - ((long) (i3 - i));
    }

    public final void a(int i) throws EOFException {
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "Negative discard is not allowed: ").toString());
        }
        int i3 = 0;
        int i4 = i;
        while (i4 != 0) {
            J1.b bVarE = e();
            if (this.e - this.d < 1) {
                bVarE = g(1, bVarE);
            }
            if (bVarE == null) {
                break;
            }
            int iMin = Math.min(bVarE.c - bVarE.b, i4);
            bVarE.c(iMin);
            this.d += iMin;
            if (bVarE.c - bVarE.b == 0) {
                h(bVarE);
            }
            i4 -= iMin;
            i3 += iMin;
        }
        if (i3 != i) {
            throw new EOFException(B2.b.d(i, "Unable to discard ", " bytes due to end of packet"));
        }
    }

    public final J1.b b(J1.b bVar) {
        J1.b bVar2 = J1.b.f828k;
        while (bVar != bVar2) {
            J1.b bVarG = bVar.g();
            bVar.j(this.f760a);
            if (bVarG == null) {
                j(bVar2);
                i(0L);
                bVar = bVar2;
            } else {
                if (bVarG.c > bVarG.b) {
                    j(bVarG);
                    i(this.f761f - ((long) (bVarG.c - bVarG.b)));
                    return bVarG;
                }
                bVar = bVarG;
            }
        }
        if (this.f762g) {
            return null;
        }
        this.f762g = true;
        return null;
    }

    public final void c(J1.b bVar) {
        long j6 = 0;
        if (this.f762g && bVar.h() == null) {
            this.d = bVar.b;
            this.e = bVar.c;
            i(0L);
            return;
        }
        int i = bVar.c - bVar.b;
        int iMin = Math.min(i, 8 - (bVar.f751f - bVar.e));
        ObjectPool objectPool = this.f760a;
        if (i > iMin) {
            J1.b bVar2 = (J1.b) objectPool.borrow();
            J1.b bVarH = (J1.b) objectPool.borrow();
            bVar2.e();
            bVarH.e();
            bVar2.l(bVarH);
            bVarH.l(bVar.g());
            C5.f.p0(bVar2, bVar, i - iMin);
            C5.f.p0(bVarH, bVar, iMin);
            j(bVar2);
            do {
                j6 += (long) (bVarH.c - bVarH.b);
                bVarH = bVarH.h();
            } while (bVarH != null);
            i(j6);
        } else {
            J1.b bVar3 = (J1.b) objectPool.borrow();
            bVar3.e();
            bVar3.l(bVar.g());
            C5.f.p0(bVar3, bVar, i);
            j(bVar3);
        }
        bVar.j(objectPool);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
        if (this.f762g) {
            return;
        }
        this.f762g = true;
    }

    public final boolean d() {
        if (this.e - this.d != 0 || this.f761f != 0) {
            return false;
        }
        boolean z6 = this.f762g;
        if (!z6 && !z6) {
            this.f762g = true;
        }
        return true;
    }

    public final J1.b e() {
        J1.b bVar = this.b;
        int i = this.d;
        if (i < 0 || i > bVar.c) {
            int i3 = bVar.b;
            k.w(i - i3, bVar.c - i3);
            throw null;
        }
        if (bVar.b != i) {
            bVar.b = i;
        }
        return bVar;
    }

    public final long f() {
        return ((long) (this.e - this.d)) + this.f761f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.b g(int r7, J1.b r8) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.f.g(int, J1.b):J1.b");
    }

    public final void h(J1.b bVar) {
        J1.b bVarG = bVar.g();
        if (bVarG == null) {
            bVarG = J1.b.f828k;
        }
        j(bVarG);
        i(this.f761f - ((long) (bVarG.c - bVarG.b)));
        bVar.j(this.f760a);
    }

    public final void i(long j6) {
        if (j6 >= 0) {
            this.f761f = j6;
        } else {
            throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j6).toString());
        }
    }

    public final void j(J1.b bVar) {
        this.b = bVar;
        this.c = bVar.f750a;
        this.d = bVar.b;
        this.e = bVar.c;
    }

    public final void release() {
        J1.b bVarE = e();
        J1.b bVar = J1.b.f828k;
        if (bVarE != bVar) {
            j(bVar);
            i(0L);
            ObjectPool pool = this.f760a;
            h.f(pool, "pool");
            while (bVarE != null) {
                J1.b bVarG = bVarE.g();
                bVarE.j(pool);
                bVarE = bVarG;
            }
        }
    }
}
