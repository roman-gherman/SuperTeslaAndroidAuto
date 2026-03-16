package com.google.android.datatransport.runtime;

import java.util.HashMap;
import p.C0751a;
import p.C0752b;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B2.d f1890a;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        K0.a aVar = L0.e.f954a;
        map.put(q.class, e.f1875a);
        map2.remove(q.class);
        map.put(C0751a.class, a.f1871a);
        map2.remove(C0751a.class);
        map.put(p.g.class, g.f1877a);
        map2.remove(p.g.class);
        map.put(p.e.class, d.f1874a);
        map2.remove(p.e.class);
        map.put(p.d.class, c.f1873a);
        map2.remove(p.d.class);
        map.put(C0752b.class, b.f1872a);
        map2.remove(C0752b.class);
        map.put(p.f.class, f.f1876a);
        map2.remove(p.f.class);
        f1890a = new B2.d(new HashMap(map), new HashMap(map2), aVar, 4);
    }
}
