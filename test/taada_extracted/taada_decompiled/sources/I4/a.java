package I4;

import s4.C0814a;
import s4.C0816c;
import w3.AbstractC0884b;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import y4.C0938b;
import y4.d;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f794a;

    public /* synthetic */ a(int i) {
        this.f794a = i;
    }

    public static C0816c a(C0814a c0814a, AbstractC0884b abstractC0884b) {
        try {
            AbstractC0899q abstractC0899qG = AbstractC0899q.g(abstractC0884b.n());
            if (!(abstractC0899qG instanceof AbstractC0902u)) {
                return new C0816c(c0814a, AbstractC0897o.j(abstractC0899qG).f5066a);
            }
            AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0899qG);
            return new C0816c(c0814a, AbstractC0897o.j(abstractC0902uL.m(0)).f5066a, AbstractC0897o.j(abstractC0902uL.m(1)).f5066a);
        } catch (Exception unused) {
            return new C0816c(c0814a, abstractC0884b.n());
        }
    }

    public static d b(C0938b c0938b, AbstractC0884b abstractC0884b) {
        try {
            AbstractC0899q abstractC0899qG = AbstractC0899q.g(abstractC0884b.n());
            if (!(abstractC0899qG instanceof AbstractC0902u)) {
                return new d(c0938b, AbstractC0897o.j(abstractC0899qG).f5066a);
            }
            AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0899qG);
            return new d(c0938b, AbstractC0897o.j(abstractC0902uL.m(0)).f5066a, AbstractC0897o.j(abstractC0902uL.m(1)).f5066a);
        } catch (Exception unused) {
            return new d(c0938b, abstractC0884b.n());
        }
    }

    public static e c(z4.c cVar, AbstractC0884b abstractC0884b) {
        try {
            AbstractC0899q abstractC0899qG = AbstractC0899q.g(abstractC0884b.n());
            if (!(abstractC0899qG instanceof AbstractC0902u)) {
                return new e(cVar, AbstractC0897o.j(abstractC0899qG).f5066a);
            }
            AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0899qG);
            return new e(cVar, AbstractC0897o.j(abstractC0902uL.m(0)).f5066a, AbstractC0897o.j(abstractC0902uL.m(1)).f5066a);
        } catch (Exception unused) {
            return new e(cVar, abstractC0884b.n());
        }
    }
}
