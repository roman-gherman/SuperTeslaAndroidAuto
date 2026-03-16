package P1;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Map.Entry, KMutableMap.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1203a;
    public final int b;

    public d(e map, int i) {
        kotlin.jvm.internal.h.f(map, "map");
        this.f1203a = map;
        this.b = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return kotlin.jvm.internal.h.a(entry.getKey(), getKey()) && kotlin.jvm.internal.h.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1203a.f1204a[this.b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object[] objArr = this.f1203a.b;
        kotlin.jvm.internal.h.c(objArr);
        return objArr[this.b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        e eVar = this.f1203a;
        eVar.b();
        Object[] objArr = eVar.b;
        if (objArr == null) {
            int length = eVar.f1204a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            eVar.b = objArr;
        }
        int i = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(getValue());
        return sb.toString();
    }
}
