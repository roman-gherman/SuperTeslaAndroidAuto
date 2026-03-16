package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class D {
    public static volatile D b;
    public static final D c = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2810a = Collections.EMPTY_MAP;

    public static D a() {
        D d;
        D d6 = b;
        if (d6 != null) {
            return d6;
        }
        synchronized (D.class) {
            try {
                d = b;
                if (d == null) {
                    Class cls = C.f2808a;
                    D d7 = null;
                    if (cls != null) {
                        try {
                            d7 = (D) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    d = d7 != null ? d7 : c;
                    b = d;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d;
    }
}
