package D0;

import G0.C0038b;
import G0.C1;
import com.google.crypto.tink.Mac;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import y0.AbstractC0928a;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    static {
        c[] cVarArr = {new c(Mac.class, 1)};
        HashMap map = new HashMap();
        c cVar = cVarArr[0];
        boolean zContainsKey = map.containsKey(cVar.f226a);
        Class cls = cVar.f226a;
        if (zContainsKey) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map.put(cls, cVar);
        Class cls2 = cVarArr[0].f226a;
        Collections.unmodifiableMap(map);
        int i = C1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        com.google.crypto.tink.m.h(t.c);
        com.google.crypto.tink.m.h(k.f242a);
        com.google.crypto.tink.m.f(new e(), true);
        C0.n nVar = o.f245a;
        C0.l lVar = C0.l.b;
        lVar.e(o.f245a);
        lVar.d(o.b);
        lVar.c(o.c);
        lVar.b(o.d);
        C0.k kVar = C0.k.b;
        kVar.a(e.f227f);
        if (AbstractC0928a.a()) {
            return;
        }
        com.google.crypto.tink.m.f(new e(C0038b.class, new c[]{new c(Mac.class, 0)}), true);
        lVar.e(h.f239a);
        lVar.d(h.b);
        lVar.c(h.c);
        lVar.b(h.d);
        kVar.a(e.e);
    }
}
