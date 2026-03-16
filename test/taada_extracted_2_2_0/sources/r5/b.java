package r5;

import java.util.concurrent.ConcurrentHashMap;
import org.objenesis.Objenesis;
import org.objenesis.instantiator.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Objenesis {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z5.b f4739a = new z5.b(0);
    public final ConcurrentHashMap b;

    public b(boolean z6) {
        this.b = z6 ? new ConcurrentHashMap() : null;
    }

    @Override // org.objenesis.Objenesis
    public final ObjectInstantiator getInstantiatorOf(Class cls) {
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Primitive types can't be instantiated in Java");
        }
        z5.b bVar = this.f4739a;
        ConcurrentHashMap concurrentHashMap = this.b;
        if (concurrentHashMap == null) {
            return bVar.newInstantiatorOf(cls);
        }
        ObjectInstantiator objectInstantiator = (ObjectInstantiator) concurrentHashMap.get(cls.getName());
        if (objectInstantiator != null) {
            return objectInstantiator;
        }
        ObjectInstantiator objectInstantiatorNewInstantiatorOf = bVar.newInstantiatorOf(cls);
        ObjectInstantiator objectInstantiator2 = (ObjectInstantiator) concurrentHashMap.putIfAbsent(cls.getName(), objectInstantiatorNewInstantiatorOf);
        return objectInstantiator2 == null ? objectInstantiatorNewInstantiatorOf : objectInstantiator2;
    }

    @Override // org.objenesis.Objenesis
    public final Object newInstance(Class cls) {
        return getInstantiatorOf(cls).newInstance();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.class.getName());
        sb.append(" using ");
        sb.append(z5.b.class.getName());
        return B2.b.h(sb, this.b == null ? " without" : " with", " caching");
    }
}
