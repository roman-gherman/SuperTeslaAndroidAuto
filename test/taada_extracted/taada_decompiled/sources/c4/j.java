package c4;

import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.SecureRandomProvider;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static final AbstractC0246d[] e = new AbstractC0246d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0243a f1798a;
    public final AbstractC0246d b;
    public final AbstractC0246d c;
    public final AbstractC0246d[] d;

    public j(AbstractC0243a abstractC0243a, AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        this.f1798a = abstractC0243a;
        this.b = abstractC0246d;
        this.c = abstractC0246d2;
        this.d = abstractC0246dArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x010f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(c4.j r12) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.j.a(c4.j):boolean");
    }

    public final int b() {
        AbstractC0243a abstractC0243a = this.f1798a;
        if (abstractC0243a == null) {
            return 0;
        }
        return abstractC0243a.f1778f;
    }

    public AbstractC0246d c() {
        return this.c;
    }

    public AbstractC0246d d() {
        AbstractC0246d[] abstractC0246dArr = this.d;
        if (abstractC0246dArr.length <= 0) {
            return null;
        }
        return abstractC0246dArr[0];
    }

    public final boolean e() {
        if (this.b == null || this.c == null) {
            return true;
        }
        AbstractC0246d[] abstractC0246dArr = this.d;
        return abstractC0246dArr.length > 0 && abstractC0246dArr[0].c0();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return a((j) obj);
        }
        return false;
    }

    public final j f() {
        int iB;
        if (!e() && (iB = b()) != 0 && iB != 5) {
            AbstractC0246d abstractC0246dD = d();
            if (!abstractC0246dD.a0()) {
                AbstractC0243a abstractC0243a = this.f1798a;
                if (abstractC0243a == null) {
                    throw new IllegalStateException("Detached points must be in affine coordinates");
                }
                AtomicReference atomicReference = L3.h.d;
                while (!atomicReference.compareAndSet(null, L3.h.c) && atomicReference.get() == null) {
                }
                AbstractC0246d abstractC0246dK = abstractC0243a.k(((SecureRandomProvider) atomicReference.get()).get());
                return g(abstractC0246dD.h0(abstractC0246dK).W().h0(abstractC0246dK));
            }
        }
        return this;
    }

    public final j g(AbstractC0246d abstractC0246d) {
        AbstractC0246d abstractC0246dH0;
        int iB = b();
        if (iB == 1) {
            abstractC0246dH0 = this.b.h0(abstractC0246d);
        } else if (iB == 2 || iB == 3 || iB == 4) {
            AbstractC0246d abstractC0246dC0 = abstractC0246d.C0();
            abstractC0246d = abstractC0246dC0.h0(abstractC0246d);
            abstractC0246dH0 = this.b.h0(abstractC0246dC0);
        } else {
            if (iB != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
            abstractC0246dH0 = this.b.h0(abstractC0246d);
        }
        return this.f1798a.c(abstractC0246dH0, this.c.h0(abstractC0246d));
    }

    public j h(AbstractC0246d abstractC0246d) {
        if (e()) {
            return this;
        }
        return this.f1798a.d(this.b.h0(abstractC0246d), this.c, this.d);
    }

    public final int hashCode() {
        AbstractC0243a abstractC0243a = this.f1798a;
        int i = abstractC0243a == null ? 0 : ~abstractC0243a.hashCode();
        if (e()) {
            return i;
        }
        j jVarF = f();
        return (i ^ (jVarF.b.hashCode() * 17)) ^ (jVarF.c().hashCode() * 257);
    }

    public final String toString() {
        if (e()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        stringBuffer.append(this.b);
        stringBuffer.append(',');
        stringBuffer.append(this.c);
        int i = 0;
        while (true) {
            AbstractC0246d[] abstractC0246dArr = this.d;
            if (i >= abstractC0246dArr.length) {
                stringBuffer.append(')');
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
            stringBuffer.append(abstractC0246dArr[i]);
            i++;
        }
    }
}
