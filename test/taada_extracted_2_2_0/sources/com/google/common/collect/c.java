package com.google.common.collect;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2780a = new c();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f2780a;
    }

    @Override // com.google.common.collect.d
    public final int a(d dVar) {
        return dVar == this ? 0 : -1;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((d) obj) == this ? 0 : -1;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }
}
