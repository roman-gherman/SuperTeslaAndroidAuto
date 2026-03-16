package com.google.gson;

import fr.sd.taada.core.auth.DeviceRegistrationResponse;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f3021a;
    public final ConcurrentHashMap b;
    public final B.w c;
    public final M0.c d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.gson.internal.h f3022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f3023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3024h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f3025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f3026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f3027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f3028m;

    /* JADX WARN: Illegal instructions before constructor call */
    public m() {
        com.google.gson.internal.h hVar = com.google.gson.internal.h.c;
        C0408b c0408b = i.f2992a;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this(hVar, c0408b, map, true, false, false, true, 1, list, list, list, D.f2990a, D.b, list);
    }

    public static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(com.google.gson.stream.b bVar, com.google.gson.reflect.a aVar) {
        boolean z6 = bVar.b;
        boolean z7 = true;
        bVar.b = true;
        try {
            try {
                try {
                    try {
                        bVar.w();
                        z7 = false;
                        return e(aVar).a(bVar);
                    } catch (EOFException e) {
                        if (!z7) {
                            throw new w(e);
                        }
                        bVar.b = z6;
                        return null;
                    }
                } catch (IllegalStateException e6) {
                    throw new w(e6);
                }
            } catch (IOException e7) {
                throw new w(e7);
            } catch (AssertionError e8) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e8.getMessage(), e8);
            }
        } finally {
            bVar.b = z6;
        }
    }

    public final Object c(Reader reader, com.google.gson.reflect.a aVar) {
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(reader);
        bVar.b = this.f3025j;
        Object objB = b(bVar, aVar);
        if (objB != null) {
            try {
                if (bVar.w() != 10) {
                    throw new w("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.stream.d e) {
                throw new w(e);
            } catch (IOException e6) {
                throw new q(e6);
            }
        }
        return objB;
    }

    public final Object d(String str) {
        Class cls = DeviceRegistrationResponse.class;
        Object objC = str == null ? null : c(new StringReader(str), new com.google.gson.reflect.a(cls));
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(objC);
    }

    public final E e(com.google.gson.reflect.a aVar) {
        boolean z6;
        ConcurrentHashMap concurrentHashMap = this.b;
        E e = (E) concurrentHashMap.get(aVar);
        if (e != null) {
            return e;
        }
        ThreadLocal threadLocal = this.f3021a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z6 = true;
        } else {
            E e6 = (E) map.get(aVar);
            if (e6 != null) {
                return e6;
            }
            z6 = false;
        }
        try {
            l lVar = new l();
            E eCreate = null;
            lVar.f3020a = null;
            map.put(aVar, lVar);
            Iterator it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eCreate = ((TypeAdapterFactory) it.next()).create(this, aVar);
                if (eCreate != null) {
                    if (lVar.f3020a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    lVar.f3020a = eCreate;
                    map.put(aVar, eCreate);
                }
            }
            if (z6) {
                threadLocal.remove();
            }
            if (eCreate != null) {
                if (z6) {
                    concurrentHashMap.putAll(map);
                }
                return eCreate;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z6) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final E f(TypeAdapterFactory typeAdapterFactory, com.google.gson.reflect.a aVar) {
        List<TypeAdapterFactory> list = this.e;
        if (!list.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.d;
        }
        boolean z6 = false;
        for (TypeAdapterFactory typeAdapterFactory2 : list) {
            if (z6) {
                E eCreate = typeAdapterFactory2.create(this, aVar);
                if (eCreate != null) {
                    return eCreate;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z6 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public final com.google.gson.stream.c g(Writer writer) {
        com.google.gson.stream.c cVar = new com.google.gson.stream.c(writer);
        if (this.i) {
            cVar.d = "  ";
            cVar.e = ": ";
        }
        cVar.f3059g = this.f3024h;
        cVar.f3058f = this.f3025j;
        cVar.i = false;
        return cVar;
    }

    public final String h(Object obj) {
        if (obj == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                i(g(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new q(e);
            }
        }
        Type type = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            j(obj, type, g(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e6) {
            throw new q(e6);
        }
    }

    public final void i(com.google.gson.stream.c cVar) {
        r rVar = r.f3040a;
        boolean z6 = cVar.f3058f;
        cVar.f3058f = true;
        boolean z7 = cVar.f3059g;
        cVar.f3059g = this.f3024h;
        boolean z8 = cVar.i;
        cVar.i = false;
        try {
            try {
                M0.v vVar = M0.y.f1025a;
                M0.u.d(cVar, rVar);
                cVar.f3058f = z6;
                cVar.f3059g = z7;
                cVar.i = z8;
            } catch (IOException e) {
                throw new q(e);
            } catch (AssertionError e6) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e6.getMessage(), e6);
            }
        } catch (Throwable th) {
            cVar.f3058f = z6;
            cVar.f3059g = z7;
            cVar.i = z8;
            throw th;
        }
    }

    public final void j(Object obj, Type type, com.google.gson.stream.c cVar) {
        E e = e(new com.google.gson.reflect.a(type));
        boolean z6 = cVar.f3058f;
        cVar.f3058f = true;
        boolean z7 = cVar.f3059g;
        cVar.f3059g = this.f3024h;
        boolean z8 = cVar.i;
        cVar.i = false;
        try {
            try {
                try {
                    e.b(cVar, obj);
                } catch (IOException e6) {
                    throw new q(e6);
                }
            } catch (AssertionError e7) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e7.getMessage(), e7);
            }
        } finally {
            cVar.f3058f = z6;
            cVar.f3059g = z7;
            cVar.i = z8;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public m(com.google.gson.internal.h hVar, i iVar, Map map, boolean z6, boolean z7, boolean z8, boolean z9, int i, List list, List list2, List list3, D d, D d6, List list4) {
        M0.l lVar;
        E jVar;
        M0.l lVar2;
        this.f3021a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f3022f = hVar;
        this.f3023g = map;
        B.w wVar = new B.w(map, z9, list4);
        this.c = wVar;
        this.f3024h = z6;
        this.i = z7;
        this.f3025j = z8;
        this.f3026k = list;
        this.f3027l = list2;
        this.f3028m = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(M0.y.f1023A);
        if (d == D.f2990a) {
            lVar = M0.m.c;
        } else {
            lVar = new M0.l(d, 1);
        }
        arrayList.add(lVar);
        arrayList.add(hVar);
        arrayList.addAll(list3);
        arrayList.add(M0.y.f1035p);
        arrayList.add(M0.y.f1027g);
        arrayList.add(M0.y.d);
        arrayList.add(M0.y.e);
        arrayList.add(M0.y.f1026f);
        if (i == 1) {
            jVar = M0.y.f1030k;
        } else {
            jVar = new j(0);
        }
        arrayList.add(new M0.w(Long.TYPE, Long.class, jVar));
        arrayList.add(new M0.w(Double.TYPE, Double.class, new M0.u(28)));
        arrayList.add(new M0.w(Float.TYPE, Float.class, new j(1)));
        if (d6 == D.b) {
            lVar2 = M0.d.d;
        } else {
            lVar2 = new M0.l(new M0.d(d6), 0);
        }
        arrayList.add(lVar2);
        arrayList.add(M0.y.f1028h);
        arrayList.add(M0.y.i);
        arrayList.add(new M0.v(AtomicLong.class, new k(new k(jVar, 0), 2), 0));
        arrayList.add(new M0.v(AtomicLongArray.class, new k(new k(jVar, 1), 2), 0));
        arrayList.add(M0.y.f1029j);
        arrayList.add(M0.y.f1031l);
        arrayList.add(M0.y.q);
        arrayList.add(M0.y.f1036r);
        arrayList.add(new M0.v(BigDecimal.class, M0.y.f1032m, 0));
        arrayList.add(new M0.v(BigInteger.class, M0.y.f1033n, 0));
        arrayList.add(new M0.v(com.google.gson.internal.j.class, M0.y.f1034o, 0));
        arrayList.add(M0.y.f1037s);
        arrayList.add(M0.y.f1038t);
        arrayList.add(M0.y.f1039v);
        arrayList.add(M0.y.f1040w);
        arrayList.add(M0.y.y);
        arrayList.add(M0.y.u);
        arrayList.add(M0.y.b);
        arrayList.add(M0.d.c);
        arrayList.add(M0.y.x);
        if (P0.c.f1197a) {
            arrayList.add(P0.c.e);
            arrayList.add(P0.c.d);
            arrayList.add(P0.c.f1198f);
        }
        arrayList.add(M0.b.d);
        arrayList.add(M0.y.f1025a);
        arrayList.add(new M0.c(wVar, 0));
        arrayList.add(new M0.c(wVar, 2));
        M0.c cVar = new M0.c(wVar, 1);
        this.d = cVar;
        arrayList.add(cVar);
        arrayList.add(M0.y.f1024B);
        arrayList.add(new M0.r(wVar, iVar, hVar, cVar, list4));
        this.e = Collections.unmodifiableList(arrayList);
    }
}
