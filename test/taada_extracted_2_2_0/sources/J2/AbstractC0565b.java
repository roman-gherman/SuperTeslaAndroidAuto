package j2;

import L2.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.n;
import w2.D;

/* JADX INFO: renamed from: j2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0565b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f3660a;
    public static final L2.b b;

    static {
        List listY = n.y(D.f4964a, D.f4967h, D.i, D.c, D.d, D.f4965f);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listY.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(L2.b.j((c) it.next()));
        }
        f3660a = linkedHashSet;
        b = L2.b.j(D.f4966g);
    }
}
