package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class E implements Comparable, Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f3844a;
    public Object b;
    public final /* synthetic */ A c;

    public E(A a6, Comparable comparable, Object obj) {
        this.c = a6;
        this.f3844a = comparable;
        this.b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3844a.compareTo(((E) obj).f3844a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f3844a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3844a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f3844a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.c.b();
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f3844a);
        String strValueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 1);
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
