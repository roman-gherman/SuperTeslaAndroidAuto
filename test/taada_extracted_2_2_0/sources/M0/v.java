package M0;

import com.google.gson.E;
import com.google.gson.TypeAdapterFactory;

/* JADX INFO: loaded from: classes.dex */
public final class v implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1020a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ E c;

    public /* synthetic */ v(Class cls, E e, int i) {
        this.f1020a = i;
        this.b = cls;
        this.c = e;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        switch (this.f1020a) {
            case 0:
                if (aVar.f3041a == this.b) {
                    return this.c;
                }
                return null;
            default:
                Class<?> cls = aVar.f3041a;
                if (this.b.isAssignableFrom(cls)) {
                    return new b(this, cls);
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f1020a) {
            case 0:
                StringBuilder sb = new StringBuilder("Factory[type=");
                androidx.constraintlayout.core.motion.a.u(this.b, sb, ",adapter=");
                sb.append(this.c);
                sb.append("]");
                return sb.toString();
            default:
                StringBuilder sb2 = new StringBuilder("Factory[typeHierarchy=");
                androidx.constraintlayout.core.motion.a.u(this.b, sb2, ",adapter=");
                sb2.append(this.c);
                sb2.append("]");
                return sb2.toString();
        }
    }
}
