package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public final class s extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.n f3042a = new com.google.gson.internal.n(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof s) && ((s) obj).f3042a.equals(this.f3042a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f3042a.hashCode();
    }
}
