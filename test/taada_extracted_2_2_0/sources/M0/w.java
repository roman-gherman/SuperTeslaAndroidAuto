package M0;

import com.google.gson.E;
import com.google.gson.TypeAdapterFactory;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public final class w implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f1021a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ E c;

    public w(Class cls, Class cls2, E e) {
        this.f1021a = cls;
        this.b = cls2;
        this.c = e;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        Class cls = aVar.f3041a;
        if (cls == this.f1021a || cls == this.b) {
            return this.c;
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Factory[type=");
        androidx.constraintlayout.core.motion.a.u(this.b, sb, Marker.ANY_NON_NULL_MARKER);
        androidx.constraintlayout.core.motion.a.u(this.f1021a, sb, ",adapter=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
