package com.google.gson.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f3006a;
    public m b;
    public m c;
    public m d;
    public m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f3009h;
    public int i;

    public m(boolean z6) {
        this.f3007f = null;
        this.f3008g = z6;
        this.e = this;
        this.d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f3007f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f3009h;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3007f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3009h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f3007f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f3009h;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f3008g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f3009h;
        this.f3009h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f3007f + "=" + this.f3009h;
    }

    public m(boolean z6, m mVar, Object obj, m mVar2, m mVar3) {
        this.f3006a = mVar;
        this.f3007f = obj;
        this.f3008g = z6;
        this.i = 1;
        this.d = mVar2;
        this.e = mVar3;
        mVar3.d = this;
        mVar2.e = this;
    }
}
