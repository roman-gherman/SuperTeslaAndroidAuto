package kotlin.text;

import A2.C0019a;
import C0.t;
import e2.C0430f;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.collections.AbstractC0594a;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AbstractC0594a implements MatchNamedGroupCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3945a;

    public e(t tVar) {
        this.f3945a = tVar;
    }

    @Override // kotlin.collections.AbstractC0594a
    public final int a() {
        return ((Matcher) this.f3945a.b).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof c) {
            return super.contains((c) obj);
        }
        return false;
    }

    @Override // kotlin.text.MatchGroupCollection
    public final c get(int i) {
        t tVar = this.f3945a;
        Matcher matcher = (Matcher) tVar.b;
        C0430f c0430fS0 = E1.k.s0(matcher.start(i), matcher.end(i));
        if (c0430fS0.f3132a < 0) {
            return null;
        }
        String strGroup = ((Matcher) tVar.b).group(i);
        kotlin.jvm.internal.h.e(strGroup, "matchResult.group(index)");
        return new c(strGroup, c0430fS0);
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new k3.t(k3.m.D(kotlin.collections.m.K(new C0430f(0, size() - 1, 1)), new C0019a(this, 22)));
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    public final c get(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return W1.c.f1390a.c(name, (Matcher) this.f3945a.b);
    }
}
