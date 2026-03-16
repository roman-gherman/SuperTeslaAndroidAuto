package c4;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: c4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0245c extends AbstractC0243a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f1784k = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final M3.a f1785l = new M3.a(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f1786h;
    public BigInteger i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f1787j;

    /* JADX WARN: Code restructure failed: missing block: B:216:0x0263, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0245c(java.math.BigInteger r18, java.math.BigInteger r19, java.math.BigInteger r20, java.math.BigInteger r21, java.math.BigInteger r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.C0245c.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, boolean):void");
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        AbstractC0246d abstractC0246d = this.b;
        AbstractC0246d abstractC0246d2 = this.c;
        BigInteger bigInteger = this.d;
        BigInteger bigInteger2 = this.e;
        BigInteger bigInteger3 = this.f1786h;
        C0245c c0245c = new C0245c(bigInteger3);
        c0245c.f1786h = bigInteger3;
        c0245c.i = this.i;
        c0245c.f1787j = new i(c0245c, null, null, 1);
        c0245c.b = abstractC0246d;
        c0245c.c = abstractC0246d2;
        c0245c.d = bigInteger;
        c0245c.e = bigInteger2;
        c0245c.f1778f = 4;
        return c0245c;
    }

    @Override // c4.AbstractC0243a
    public final j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new i(this, abstractC0246d, abstractC0246d2, 1);
    }

    @Override // c4.AbstractC0243a
    public final j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new i(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 1);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        if (bigInteger != null && bigInteger.signum() >= 0) {
            BigInteger bigInteger2 = this.f1786h;
            if (bigInteger.compareTo(bigInteger2) < 0) {
                return new C0248f(bigInteger2, this.i, bigInteger);
            }
        }
        throw new IllegalArgumentException("x value invalid for Fp field element");
    }

    @Override // c4.AbstractC0243a
    public final j h() {
        return this.f1787j;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return this.f1786h;
    }

    @Override // c4.AbstractC0243a
    public final j j(j jVar) {
        int i;
        return (this == jVar.f1798a || this.f1778f != 2 || jVar.e() || !((i = jVar.f1798a.f1778f) == 2 || i == 3 || i == 4)) ? super.j(jVar) : new i(this, f(jVar.b.G0()), f(jVar.c.G0()), new AbstractC0246d[]{f(jVar.d[0].G0())}, 1);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 0 || i == 1 || i == 2 || i == 4;
    }
}
