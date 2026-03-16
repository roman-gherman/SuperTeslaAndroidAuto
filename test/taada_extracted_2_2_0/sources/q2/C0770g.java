package q2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import k2.C0588g;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: q2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0770g implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4593a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0770g(Object obj, int i) {
        this.f4593a = i;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f4593a) {
            case 0:
                StringBuilder sb = new StringBuilder("Scope for type parameter ");
                C0588g c0588g = (C0588g) this.b;
                sb.append(((L2.f) c0588g.b).b());
                return kotlin.reflect.l.m(sb.toString(), ((AbstractC0772i) c0588g.c).getUpperBounds());
            case 1:
                r rVar = (r) this.b;
                rVar.getClass();
                HashSet hashSet = new HashSet();
                for (L2.f fVar : (Set) rVar.d.i.invoke()) {
                    if (fVar == null) {
                        r.a(5);
                        throw null;
                    }
                    Collection collection = (Collection) rVar.f4606a.invoke(fVar);
                    if (collection == null) {
                        r.a(7);
                        throw null;
                    }
                    hashSet.addAll(collection);
                    Collection collection2 = (Collection) rVar.b.invoke(fVar);
                    if (collection2 == null) {
                        r.a(3);
                        throw null;
                    }
                    hashSet.addAll(collection2);
                }
                return hashSet;
            default:
                return (List) this.b;
        }
    }
}
