package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0316s1 {
    public static final C0316s1 c = new C0316s1();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0296l1 f2125a = new C0296l1();

    public final zzix a(Class cls) {
        Charset charset = AbstractC0278f1.f2076a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        zzix zzixVar = (zzix) concurrentHashMap.get(cls);
        if (zzixVar != null) {
            return zzixVar;
        }
        zzix zzixVarZza = this.f2125a.zza(cls);
        zzix zzixVar2 = (zzix) concurrentHashMap.putIfAbsent(cls, zzixVarZza);
        return zzixVar2 == null ? zzixVarZza : zzixVar2;
    }
}
