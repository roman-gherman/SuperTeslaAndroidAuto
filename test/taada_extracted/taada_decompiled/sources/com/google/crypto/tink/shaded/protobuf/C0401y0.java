package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0401y0 extends AbstractMap {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2927g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2928a;
    public List b = Collections.EMPTY_LIST;
    public Map c;
    public boolean d;
    public volatile D0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f2929f;

    public C0401y0(int i) {
        this.f2928a = i;
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.f2929f = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            com.google.crypto.tink.shaded.protobuf.B0 r2 = (com.google.crypto.tink.shaded.protobuf.B0) r2
            java.lang.Comparable r2 = r2.f2807a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            com.google.crypto.tink.shaded.protobuf.B0 r3 = (com.google.crypto.tink.shaded.protobuf.B0) r3
            java.lang.Comparable r3 = r3.f2807a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C0401y0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final Iterable d() {
        return this.c.isEmpty() ? AbstractC0369i.b : this.c.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f2929f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new D0(this, 0);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0401y0)) {
            return super.equals(obj);
        }
        C0401y0 c0401y0 = (C0401y0) obj;
        int size = size();
        if (size == c0401y0.size()) {
            int size2 = this.b.size();
            if (size2 != c0401y0.b.size()) {
                return ((AbstractSet) entrySet()).equals(c0401y0.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(c0401y0.c(i))) {
                }
            }
            if (size2 != size) {
                return this.c.equals(c0401y0.c);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((B0) this.b.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.b.isEmpty();
        int i = this.f2928a;
        if (zIsEmpty && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(i);
        }
        int i3 = -(iA + 1);
        if (i3 >= i) {
            return e().put(comparable, obj);
        }
        if (this.b.size() == i) {
            B0 b02 = (B0) this.b.remove(i - 1);
            e().put(b02.f2807a, b02.b);
        }
        this.b.add(i3, new B0(this, comparable, obj));
        return null;
    }

    public final Object g(int i) {
        b();
        Object obj = ((B0) this.b.remove(i)).b;
        if (!this.c.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new B0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((B0) this.b.get(iA)).b : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.b.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((B0) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? this.c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return g(iA);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size() + this.b.size();
    }
}
