package z0;

import G0.C1;
import G0.S;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.m;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import y0.AbstractC0928a;

/* JADX INFO: renamed from: z0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0940a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5167a = 0;

    static {
        D0.c[] cVarArr = {new D0.c(DeterministicAead.class, 13)};
        HashMap map = new HashMap();
        D0.c cVar = cVarArr[0];
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
            m.h(c.b);
            if (AbstractC0928a.a()) {
                return;
            }
            m.f(new H0.a(S.class, new D0.c[]{new D0.c(DeterministicAead.class, 13)}, 10), true);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
