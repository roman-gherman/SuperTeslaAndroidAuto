package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o extends p implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3039a;

    public o() {
        this.f3039a = new ArrayList();
    }

    @Override // com.google.gson.p
    public final String a() {
        ArrayList arrayList = this.f3039a;
        int size = arrayList.size();
        if (size == 1) {
            return ((p) arrayList.get(0)).a();
        }
        throw new IllegalStateException(B2.b.c(size, "Array must have size 1, but has size "));
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof o) && ((o) obj).f3039a.equals(this.f3039a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f3039a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3039a.iterator();
    }

    public o(int i) {
        this.f3039a = new ArrayList(i);
    }
}
