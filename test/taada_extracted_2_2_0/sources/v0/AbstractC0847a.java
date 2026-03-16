package v0;

import G0.C0056h;
import G0.C0095x;
import G0.C1;
import G0.J;
import G0.M1;
import G0.N;
import G0.W;
import G0.t1;
import G0.x1;
import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import y0.AbstractC0928a;

/* JADX INFO: renamed from: v0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0847a {
    static {
        D0.c[] cVarArr = {new D0.c(Aead.class, 4)};
        HashMap map = new HashMap();
        for (int i = 0; i < 1; i++) {
            D0.c cVar = cVarArr[i];
            boolean zContainsKey = map.containsKey(cVar.f226a);
            Class cls = cVar.f226a;
            if (zContainsKey) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
            }
            map.put(cls, cVar);
        }
        Class cls2 = cVarArr[0].f226a;
        Collections.unmodifiableMap(map);
        D0.c[] cVarArr2 = {new D0.c(Aead.class, 7)};
        HashMap map2 = new HashMap();
        D0.c cVar2 = cVarArr2[0];
        boolean zContainsKey2 = map2.containsKey(cVar2.f226a);
        Class cls3 = cVar2.f226a;
        if (zContainsKey2) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map2.put(cls3, cVar2);
        Class cls4 = cVarArr2[0].f226a;
        Collections.unmodifiableMap(map2);
        D0.c[] cVarArr3 = {new D0.c(Aead.class, 8)};
        HashMap map3 = new HashMap();
        D0.c cVar3 = cVarArr3[0];
        boolean zContainsKey3 = map3.containsKey(cVar3.f226a);
        Class cls5 = cVar3.f226a;
        if (zContainsKey3) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls5, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map3.put(cls5, cVar3);
        Class cls6 = cVarArr3[0].f226a;
        Collections.unmodifiableMap(map3);
        D0.c[] cVarArr4 = {new D0.c(Aead.class, 6)};
        HashMap map4 = new HashMap();
        D0.c cVar4 = cVarArr4[0];
        boolean zContainsKey4 = map4.containsKey(cVar4.f226a);
        Class cls7 = cVar4.f226a;
        if (zContainsKey4) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls7, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map4.put(cls7, cVar4);
        Class cls8 = cVarArr4[0].f226a;
        Collections.unmodifiableMap(map4);
        D0.c[] cVarArr5 = {new D0.c(Aead.class, 10)};
        HashMap map5 = new HashMap();
        D0.c cVar5 = cVarArr5[0];
        boolean zContainsKey5 = map5.containsKey(cVar5.f226a);
        Class cls9 = cVar5.f226a;
        if (zContainsKey5) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls9, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map5.put(cls9, cVar5);
        Class cls10 = cVarArr5[0].f226a;
        Collections.unmodifiableMap(map5);
        D0.c[] cVarArr6 = {new D0.c(Aead.class, 11)};
        HashMap map6 = new HashMap();
        D0.c cVar6 = cVarArr6[0];
        boolean zContainsKey6 = map6.containsKey(cVar6.f226a);
        Class cls11 = cVar6.f226a;
        if (zContainsKey6) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls11, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map6.put(cls11, cVar6);
        Class cls12 = cVarArr6[0].f226a;
        Collections.unmodifiableMap(map6);
        D0.c[] cVarArr7 = {new D0.c(Aead.class, 9)};
        HashMap map7 = new HashMap();
        D0.c cVar7 = cVarArr7[0];
        boolean zContainsKey7 = map7.containsKey(cVar7.f226a);
        Class cls13 = cVar7.f226a;
        if (zContainsKey7) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls13, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map7.put(cls13, cVar7);
        Class cls14 = cVarArr7[0].f226a;
        Collections.unmodifiableMap(map7);
        D0.c[] cVarArr8 = {new D0.c(Aead.class, 12)};
        HashMap map8 = new HashMap();
        D0.c cVar8 = cVarArr8[0];
        boolean zContainsKey8 = map8.containsKey(cVar8.f226a);
        Class cls15 = cVar8.f226a;
        if (zContainsKey8) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls15, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map8.put(cls15, cVar8);
        Class cls16 = cVarArr8[0].f226a;
        Collections.unmodifiableMap(map8);
        int i3 = C1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        int i = 9;
        int i3 = 8;
        int i4 = 6;
        int i5 = 7;
        com.google.crypto.tink.m.h(d.b);
        D0.p.a();
        com.google.crypto.tink.m.f(new H0.a(C0056h.class, new D0.c[]{new D0.c(Aead.class, 4)}, 2), true);
        Class<J> cls = J.class;
        com.google.crypto.tink.m.f(new H0.a(cls, new D0.c[]{new D0.c(Aead.class, 7)}, 4), true);
        C0.n nVar = l.f4914a;
        C0.l lVar = C0.l.b;
        lVar.e(l.f4914a);
        lVar.d(l.b);
        lVar.c(l.c);
        lVar.b(l.d);
        if (AbstractC0928a.a()) {
            return;
        }
        com.google.crypto.tink.m.f(new H0.a(C0095x.class, new D0.c[]{new D0.c(Aead.class, 6)}, 3), true);
        lVar.e(h.f4910a);
        lVar.d(h.b);
        lVar.c(h.c);
        lVar.b(h.d);
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            com.google.crypto.tink.m.f(new H0.a(N.class, new D0.c[]{new D0.c(Aead.class, 8)}, 5), true);
            lVar.e(o.f4917a);
            lVar.d(o.b);
            lVar.c(o.c);
            lVar.b(o.d);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
        com.google.crypto.tink.m.f(new H0.a(W.class, new D0.c[]{new D0.c(Aead.class, 9)}, i4), true);
        C0.n nVar2 = r.f4920a;
        C0.l lVar2 = C0.l.b;
        lVar2.e(r.f4920a);
        lVar2.d(r.b);
        lVar2.c(r.c);
        lVar2.b(r.d);
        com.google.crypto.tink.m.f(new H0.a(t1.class, new D0.c[]{new D0.c(Aead.class, 10)}, i5), true);
        com.google.crypto.tink.m.f(new H0.a(x1.class, new D0.c[]{new D0.c(Aead.class, 11)}, i3), true);
        com.google.crypto.tink.m.f(new H0.a(M1.class, new D0.c[]{new D0.c(Aead.class, 12)}, i), true);
        lVar2.e(v.f4924a);
        lVar2.d(v.b);
        lVar2.c(v.c);
        lVar2.b(v.d);
    }
}
