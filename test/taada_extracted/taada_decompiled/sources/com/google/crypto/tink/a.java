package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f2791a = new byte[0];

    public static f a(String str) throws GeneralSecurityException {
        Map mapUnmodifiableMap;
        AtomicReference atomicReference = m.f2804a;
        synchronized (m.class) {
            mapUnmodifiableMap = Collections.unmodifiableMap(m.d);
        }
        f fVar = (f) mapUnmodifiableMap.get(str);
        if (fVar != null) {
            return fVar;
        }
        throw new GeneralSecurityException(androidx.constraintlayout.core.motion.a.p("cannot find key template: ", str));
    }
}
