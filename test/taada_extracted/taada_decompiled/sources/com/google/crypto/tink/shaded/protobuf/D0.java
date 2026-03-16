package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class D0 extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2811a;
    public final /* synthetic */ AbstractMap b;

    public /* synthetic */ D0(AbstractMap abstractMap, int i) {
        this.f2811a = i;
        this.b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f2811a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((C0401y0) this.b).put((Comparable) entry.getKey(), entry.getValue());
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (!contains(entry2)) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b).put((Comparable) entry2.getKey(), entry2.getValue());
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f2811a) {
            case 0:
                ((C0401y0) this.b).clear();
                break;
            default:
                ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f2811a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((C0401y0) this.b).get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj3 = ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b).get(entry2.getKey());
                Object value2 = entry2.getValue();
                if (obj3 == value2 || (obj3 != null && obj3.equals(value2))) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f2811a) {
            case 0:
                return new C0((C0401y0) this.b, 0);
            default:
                return new C0((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f2811a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((C0401y0) this.b).remove(entry.getKey());
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (contains(entry2)) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b).remove(entry2.getKey());
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f2811a) {
            case 0:
                return ((C0401y0) this.b).size();
            default:
                return ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.b).size();
        }
    }
}
