package H0;

import G0.C0068l;
import G0.C1;
import G0.D;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.m;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import y0.AbstractC0928a;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    static {
        D0.c[] cVarArr = {new D0.c(StreamingAead.class, 2)};
        HashMap map = new HashMap();
        for (D0.c cVar : cVarArr) {
            boolean zContainsKey = map.containsKey(cVar.f226a);
            Class cls = cVar.f226a;
            if (zContainsKey) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map.put(cls, cVar);
        }
        if (cVarArr.length > 0) {
            Class cls2 = cVarArr[0].f226a;
        }
        Collections.unmodifiableMap(map);
        D0.c[] cVarArr2 = {new D0.c(StreamingAead.class, 3)};
        HashMap map2 = new HashMap();
        for (D0.c cVar2 : cVarArr2) {
            boolean zContainsKey2 = map2.containsKey(cVar2.f226a);
            Class cls3 = cVar2.f226a;
            if (zContainsKey2) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map2.put(cls3, cVar2);
        }
        if (cVarArr2.length > 0) {
            Class cls4 = cVarArr2[0].f226a;
        }
        Collections.unmodifiableMap(map2);
        int i = C1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        m.h(g.f736a);
        if (AbstractC0928a.a()) {
            return;
        }
        m.f(new a(C0068l.class, new D0.c[]{new D0.c(StreamingAead.class, 2)}, 0), true);
        m.f(new a(D.class, new D0.c[]{new D0.c(StreamingAead.class, 3)}, 1), true);
    }
}
