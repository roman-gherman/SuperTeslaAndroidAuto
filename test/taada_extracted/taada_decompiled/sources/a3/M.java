package a3;

import g3.AbstractC0484a;
import g3.AbstractC0487d;
import g3.C0486c;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends AbstractC0487d {
    public static final B.h b = new B.h(13);
    public static final M c = new M(kotlin.collections.u.f3804a);

    public M(List list) {
        this.f3308a = g3.l.f3314a;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0148k c0148k = (C0148k) it.next();
            c0148k.getClass();
            int iJ = b.j(kotlin.jvm.internal.w.f3817a.b(C0148k.class));
            int iA = this.f3308a.a();
            if (iA != 0) {
                if (iA == 1) {
                    AbstractC0484a abstractC0484a = this.f3308a;
                    kotlin.jvm.internal.h.d(abstractC0484a, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                    g3.r rVar = (g3.r) abstractC0484a;
                    int i = rVar.b;
                    if (i == iJ) {
                        this.f3308a = new g3.r(iJ, c0148k);
                    } else {
                        C0486c c0486c = new C0486c();
                        c0486c.f3307a = new Object[20];
                        c0486c.b = 0;
                        this.f3308a = c0486c;
                        c0486c.b(i, rVar.f3319a);
                    }
                }
                this.f3308a.b(iJ, c0148k);
            } else {
                this.f3308a = new g3.r(iJ, c0148k);
            }
        }
    }
}
