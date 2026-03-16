package com.google.crypto.tink;

import C0.p;
import C0.q;
import G0.A1;
import G0.C0049e1;
import G0.C0055g1;
import G0.C0058h1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import f.s;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f2804a;
    public static final ConcurrentHashMap b;
    public static final ConcurrentHashMap c;
    public static final ConcurrentHashMap d;

    static {
        Logger.getLogger(m.class.getName());
        f2804a = new AtomicReference(new d());
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static synchronized void a(String str, Map map, boolean z6) {
        if (z6) {
            try {
                ConcurrentHashMap concurrentHashMap = c;
                if (concurrentHashMap.containsKey(str) && !((Boolean) concurrentHashMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            } finally {
            }
        }
        if (z6) {
            if (((d) f2804a.get()).f2793a.containsKey(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!d.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (d.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + ((String) entry2.getKey()));
                    }
                }
            }
        }
    }

    public static Object b(b bVar, Class cls) throws GeneralSecurityException {
        q qVar = (q) C0.k.b.f146a.get();
        qVar.getClass();
        p pVar = new p(bVar.getClass(), cls);
        HashMap map = qVar.f152a;
        if (map.containsKey(pVar)) {
            return ((C0.o) map.get(pVar)).b.constructPrimitive(bVar);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + pVar + " available");
    }

    public static Object c(String str, AbstractC0381o abstractC0381o, Class cls) throws GeneralSecurityException {
        d dVar = (d) f2804a.get();
        dVar.getClass();
        KeyManagerRegistry$KeyManagerContainer keyManagerRegistry$KeyManagerContainerA = dVar.a(str);
        if (keyManagerRegistry$KeyManagerContainerA.supportedPrimitives().contains(cls)) {
            return keyManagerRegistry$KeyManagerContainerA.getKeyManager(cls).getPrimitive(abstractC0381o);
        }
        StringBuilder sb = new StringBuilder("Primitive type ");
        androidx.constraintlayout.core.motion.a.u(cls, sb, " not supported by key manager of type ");
        sb.append(keyManagerRegistry$KeyManagerContainerA.getImplementingClass());
        sb.append(", supported primitives: ");
        Set<Class<?>> setSupportedPrimitives = keyManagerRegistry$KeyManagerContainerA.supportedPrimitives();
        StringBuilder sb2 = new StringBuilder();
        boolean z6 = true;
        for (Class<?> cls2 : setSupportedPrimitives) {
            if (!z6) {
                sb2.append(", ");
            }
            sb2.append(cls2.getCanonicalName());
            z6 = false;
        }
        sb.append(sb2.toString());
        throw new GeneralSecurityException(sb.toString());
    }

    public static KeyManager d(String str) {
        return ((d) f2804a.get()).a(str).getUntypedKeyManager();
    }

    public static synchronized C0049e1 e(C0058h1 c0058h1) {
        KeyManager keyManagerD;
        keyManagerD = d(c0058h1.getTypeUrl());
        if (!((Boolean) c.get(c0058h1.getTypeUrl())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + c0058h1.getTypeUrl());
        }
        return keyManagerD.newKeyData(c0058h1.getValue());
    }

    public static synchronized void f(C0.e eVar, boolean z6) {
        try {
            AtomicReference atomicReference = f2804a;
            d dVar = new d((d) atomicReference.get());
            dVar.b(eVar);
            String strB = eVar.b();
            a(strB, z6 ? eVar.d().h() : Collections.EMPTY_MAP, z6);
            if (!((d) atomicReference.get()).f2793a.containsKey(strB)) {
                b.put(strB, new e(eVar, 1));
                if (z6) {
                    g(strB, eVar.d().h());
                }
            }
            c.put(strB, Boolean.valueOf(z6));
            atomicReference.set(dVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void g(String str, Map map) {
        A1 a12;
        for (Map.Entry entry : map.entrySet()) {
            ConcurrentHashMap concurrentHashMap = d;
            String str2 = (String) entry.getKey();
            byte[] byteArray = ((C0.c) entry.getValue()).f141a.toByteArray();
            int i = ((C0.c) entry.getValue()).b;
            C0055g1 c0055g1X = C0058h1.x();
            c0055g1X.v(str);
            c0055g1X.w(AbstractC0381o.c(byteArray, 0, byteArray.length));
            int iB = s.b(i);
            if (iB == 0) {
                a12 = A1.TINK;
            } else if (iB == 1) {
                a12 = A1.LEGACY;
            } else if (iB == 2) {
                a12 = A1.RAW;
            } else {
                if (iB != 3) {
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                a12 = A1.CRUNCHY;
            }
            c0055g1X.u(a12);
            concurrentHashMap.put(str2, new f((C0058h1) c0055g1X.build()));
        }
    }

    public static synchronized void h(PrimitiveWrapper primitiveWrapper) {
        C0.k kVar = C0.k.b;
        synchronized (kVar) {
            B.h hVar = new B.h((q) kVar.f146a.get());
            hVar.l(primitiveWrapper);
            kVar.f146a.set(new q(hVar));
        }
    }
}
