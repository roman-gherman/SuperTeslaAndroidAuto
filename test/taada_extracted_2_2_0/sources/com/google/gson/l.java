package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public final class l extends M0.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f3020a;

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) {
        E e = this.f3020a;
        if (e != null) {
            return e.a(bVar);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) {
        E e = this.f3020a;
        if (e == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        e.b(cVar, obj);
    }

    @Override // M0.s
    public final E c() {
        E e = this.f3020a;
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}
