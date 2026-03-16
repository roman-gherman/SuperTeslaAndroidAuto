package com.google.android.datatransport.runtime;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public final String a(String str) {
        String str2 = (String) ((i) this).f1881f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) ((i) this).f1881f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final h c() {
        h hVar = new h();
        i iVar = (i) this;
        String str = iVar.f1880a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        hVar.f1878a = str;
        hVar.b = iVar.b;
        n nVar = iVar.c;
        if (nVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        hVar.c = nVar;
        hVar.d = Long.valueOf(iVar.d);
        hVar.e = Long.valueOf(iVar.e);
        hVar.f1879f = new HashMap(iVar.f1881f);
        return hVar;
    }
}
