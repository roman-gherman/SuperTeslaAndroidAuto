package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final Logger b = Logger.getLogger(d.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2793a;

    public d(d dVar) {
        this.f2793a = new ConcurrentHashMap(dVar.f2793a);
    }

    public final synchronized KeyManagerRegistry$KeyManagerContainer a(String str) {
        if (!this.f2793a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (KeyManagerRegistry$KeyManagerContainer) this.f2793a.get(str);
    }

    public final synchronized void b(C0.e eVar) {
        int iA = eVar.a();
        if (!(iA != 1 ? com.google.protobuf.a.b(iA) : com.google.protobuf.a.a(iA))) {
            throw new GeneralSecurityException("failed to register key manager " + eVar.getClass() + " as it is not FIPS compatible.");
        }
        c(new c(eVar));
    }

    public final synchronized void c(c cVar) {
        try {
            String strB = ((C0.e) ((B.h) cVar.getUntypedKeyManager()).b).b();
            KeyManagerRegistry$KeyManagerContainer keyManagerRegistry$KeyManagerContainer = (KeyManagerRegistry$KeyManagerContainer) this.f2793a.get(strB);
            if (keyManagerRegistry$KeyManagerContainer != null && !keyManagerRegistry$KeyManagerContainer.getImplementingClass().equals(cVar.f2792a.getClass())) {
                b.warning("Attempted overwrite of a registered key manager for key type ".concat(strB));
                throw new GeneralSecurityException("typeUrl (" + strB + ") is already registered with " + keyManagerRegistry$KeyManagerContainer.getImplementingClass().getName() + ", cannot be re-registered with " + cVar.f2792a.getClass().getName());
            }
            this.f2793a.putIfAbsent(strB, cVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public d() {
        this.f2793a = new ConcurrentHashMap();
    }
}
