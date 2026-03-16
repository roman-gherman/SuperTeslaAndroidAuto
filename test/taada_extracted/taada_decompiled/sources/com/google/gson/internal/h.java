package com.google.gson.internal;

import com.google.gson.E;
import com.google.gson.ExclusionStrategy;
import com.google.gson.TypeAdapterFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h implements TypeAdapterFactory, Cloneable {
    public static final h c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f3001a;
    public List b;

    static {
        h hVar = new h();
        List list = Collections.EMPTY_LIST;
        hVar.f3001a = list;
        hVar.b = list;
        c = hVar;
    }

    public static boolean b(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || (cls.getModifiers() & 8) != 0) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public final boolean a(Class cls, boolean z6) {
        Iterator it = (z6 ? this.f3001a : this.b).iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final Object clone() {
        try {
            return (h) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        Class cls = aVar.f3041a;
        boolean zB = b(cls);
        boolean z6 = zB || a(cls, true);
        boolean z7 = zB || a(cls, false);
        if (z6 || z7) {
            return new g(this, z7, z6, mVar, aVar);
        }
        return null;
    }
}
