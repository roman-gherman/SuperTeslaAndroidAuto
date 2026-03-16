package com.google.gson.internal;

import com.google.gson.E;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class g extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f2999a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ com.google.gson.m d;
    public final /* synthetic */ com.google.gson.reflect.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f3000f;

    public g(h hVar, boolean z6, boolean z7, com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        this.f3000f = hVar;
        this.b = z6;
        this.c = z7;
        this.d = mVar;
        this.e = aVar;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        if (this.b) {
            bVar.C();
            return null;
        }
        E eF = this.f2999a;
        if (eF == null) {
            eF = this.d.f(this.f3000f, this.e);
            this.f2999a = eF;
        }
        return eF.a(bVar);
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (this.c) {
            cVar.i();
            return;
        }
        E eF = this.f2999a;
        if (eF == null) {
            eF = this.d.f(this.f3000f, this.e);
            this.f2999a = eF;
        }
        eF.b(cVar, obj);
    }
}
