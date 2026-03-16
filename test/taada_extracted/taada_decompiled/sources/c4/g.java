package c4;

import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1796f;

    /* JADX WARN: Illegal instructions before constructor call */
    public g(AbstractC0243a abstractC0243a, AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, int i) {
        AbstractC0246d[] abstractC0246dArr;
        this.f1796f = i;
        int i3 = abstractC0243a == null ? 0 : abstractC0243a.f1778f;
        if (i3 == 0 || i3 == 5) {
            abstractC0246dArr = j.e;
        } else {
            AbstractC0246d abstractC0246dF = abstractC0243a.f(ECConstants.ONE);
            if (i3 == 1 || i3 == 2) {
                abstractC0246dArr = new AbstractC0246d[]{abstractC0246dF};
            } else if (i3 == 3) {
                abstractC0246dArr = new AbstractC0246d[]{abstractC0246dF, abstractC0246dF, abstractC0246dF};
            } else if (i3 != 4) {
                if (i3 != 6) {
                    throw new IllegalArgumentException("unknown coordinate system");
                }
                abstractC0246dArr = new AbstractC0246d[]{abstractC0246dF};
            } else {
                abstractC0246dArr = new AbstractC0246d[]{abstractC0246dF, abstractC0243a.b};
            }
        }
        super(abstractC0243a, abstractC0246d, abstractC0246d2, abstractC0246dArr);
    }

    @Override // c4.j
    public j h(AbstractC0246d abstractC0246d) {
        switch (this.f1796f) {
            case 0:
                if (e()) {
                    return this;
                }
                int iB = b();
                AbstractC0243a abstractC0243a = this.f1798a;
                AbstractC0246d[] abstractC0246dArr = this.d;
                AbstractC0246d abstractC0246d2 = this.c;
                AbstractC0246d abstractC0246d3 = this.b;
                if (iB == 5) {
                    return abstractC0243a.d(abstractC0246d3, abstractC0246d2.b(abstractC0246d3).G(abstractC0246d).b(abstractC0246d3.h0(abstractC0246d)), abstractC0246dArr);
                }
                if (iB != 6) {
                    return super.h(abstractC0246d);
                }
                AbstractC0246d abstractC0246d4 = abstractC0246dArr[0];
                AbstractC0246d abstractC0246dH0 = abstractC0246d3.h0(abstractC0246d.C0());
                return abstractC0243a.d(abstractC0246dH0, abstractC0246d2.b(abstractC0246d3).b(abstractC0246dH0), new AbstractC0246d[]{abstractC0246d4.h0(abstractC0246d)});
            default:
                return super.h(abstractC0246d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(AbstractC0243a abstractC0243a, AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr, int i) {
        super(abstractC0243a, abstractC0246d, abstractC0246d2, abstractC0246dArr);
        this.f1796f = i;
    }
}
