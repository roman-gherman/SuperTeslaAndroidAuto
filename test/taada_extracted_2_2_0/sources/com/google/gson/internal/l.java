package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3005a;
    public final /* synthetic */ n b;

    public /* synthetic */ l(n nVar, int i) {
        this.f3005a = i;
        this.b = nVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f3005a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        m mVarA;
        switch (this.f3005a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                n nVar = this.b;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                m mVar = null;
                if (key != null) {
                    try {
                        mVarA = nVar.a(key, false);
                    } catch (ClassCastException unused) {
                        mVarA = null;
                    }
                    break;
                } else {
                    mVarA = null;
                }
                if (mVarA != null && Objects.equals(mVarA.f3009h, entry.getValue())) {
                    mVar = mVarA;
                }
                return mVar != null;
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3005a) {
            case 0:
                return new k(this.b, 0);
            default:
                return new k(this.b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        m mVarA;
        switch (this.f3005a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    n nVar = this.b;
                    Object key = entry.getKey();
                    m mVar = null;
                    if (key != null) {
                        try {
                            mVarA = nVar.a(key, false);
                        } catch (ClassCastException unused) {
                            mVarA = null;
                        }
                    } else {
                        mVarA = null;
                    }
                    if (mVarA != null && Objects.equals(mVarA.f3009h, entry.getValue())) {
                        mVar = mVarA;
                    }
                    if (mVar != null) {
                        nVar.c(mVar, true);
                        break;
                    }
                    break;
                }
                break;
            default:
                n nVar2 = this.b;
                m mVarA2 = null;
                if (obj != null) {
                    try {
                        mVarA2 = nVar2.a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (mVarA2 != null) {
                    nVar2.c(mVarA2, true);
                }
                if (mVarA2 != null) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f3005a) {
        }
        return this.b.d;
    }
}
