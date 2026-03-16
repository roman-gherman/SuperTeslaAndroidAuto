package com.google.firebase.encoders;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2989a;
    public final Map b;

    public b(String str, Map map) {
        this.f2989a = str;
        this.b = map;
    }

    public static b a(String str) {
        return new b(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2989a.equals(bVar.f2989a) && this.b.equals(bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f2989a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f2989a + ", properties=" + this.b.values() + "}";
    }
}
