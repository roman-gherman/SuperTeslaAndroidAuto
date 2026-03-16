package com.google.crypto.tink;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2803a;
    public final j b;
    public final F0.a c;

    public l(ConcurrentHashMap concurrentHashMap, j jVar, F0.a aVar, Class cls) {
        this.f2803a = concurrentHashMap;
        this.b = jVar;
        this.c = aVar;
    }

    public final List a(byte[] bArr) {
        List list = (List) this.f2803a.get(new k(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }
}
