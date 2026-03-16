package M0;

import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class p extends o {
    public final ObjectConstructor b;

    public p(ObjectConstructor objectConstructor, LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.b = objectConstructor;
    }

    @Override // M0.o
    public final Object c() {
        return this.b.construct();
    }

    @Override // M0.o
    public final Object d(Object obj) {
        return obj;
    }

    @Override // M0.o
    public final void e(Object obj, com.google.gson.stream.b bVar, n nVar) throws IllegalAccessException {
        Object objA = nVar.i.a(bVar);
        if (objA == null && nVar.f1012l) {
            return;
        }
        Field field = nVar.b;
        if (nVar.f1007f) {
            r.a(obj, field);
        } else if (nVar.f1013m) {
            throw new com.google.gson.q(androidx.constraintlayout.core.motion.a.p("Cannot set value of 'static final' ", O0.c.d(field, false)));
        }
        field.set(obj, objA);
    }
}
