package z1;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Map.Entry, KMutableMap.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5179a;
    public Object b;

    public j(Object obj, Object obj2) {
        this.f5179a = obj;
        this.b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Map.Entry)) {
            Map.Entry entry = (Map.Entry) obj;
            if (kotlin.jvm.internal.h.a(entry.getKey(), this.f5179a) && kotlin.jvm.internal.h.a(entry.getValue(), this.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5179a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f5179a;
        kotlin.jvm.internal.h.c(obj);
        int iHashCode = obj.hashCode() + 527;
        Object obj2 = this.b;
        kotlin.jvm.internal.h.c(obj2);
        return obj2.hashCode() + iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.b = obj;
        return obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5179a);
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(this.b);
        return sb.toString();
    }
}
