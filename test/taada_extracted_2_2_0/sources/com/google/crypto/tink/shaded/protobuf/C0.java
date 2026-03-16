package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class C0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2809a;
    public int b = -1;
    public boolean c;
    public Iterator d;
    public final /* synthetic */ AbstractMap e;

    public /* synthetic */ C0(AbstractMap abstractMap, int i) {
        this.f2809a = i;
        this.e = abstractMap;
    }

    public final Iterator a() {
        switch (this.f2809a) {
            case 0:
                if (this.d == null) {
                    this.d = ((C0401y0) this.e).c.entrySet().iterator();
                }
                break;
            default:
                if (this.d == null) {
                    this.d = ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.e).c.entrySet().iterator();
                }
                break;
        }
        return this.d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2809a) {
            case 0:
                int i = this.b + 1;
                C0401y0 c0401y0 = (C0401y0) this.e;
                if (i >= c0401y0.b.size()) {
                    if (c0401y0.c.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            default:
                if (this.b + 1 < ((kotlin.reflect.jvm.internal.impl.protobuf.A) this.e).b.size() || a().hasNext()) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2809a) {
            case 0:
                this.c = true;
                int i = this.b + 1;
                this.b = i;
                C0401y0 c0401y0 = (C0401y0) this.e;
                if (i >= c0401y0.b.size()) {
                }
                break;
            default:
                this.c = true;
                int i3 = this.b + 1;
                this.b = i3;
                kotlin.reflect.jvm.internal.impl.protobuf.A a6 = (kotlin.reflect.jvm.internal.impl.protobuf.A) this.e;
                if (i3 >= a6.b.size()) {
                }
                break;
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractMap abstractMap = this.e;
        switch (this.f2809a) {
            case 0:
                if (!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                int i = C0401y0.f2927g;
                C0401y0 c0401y0 = (C0401y0) abstractMap;
                c0401y0.b();
                if (this.b >= c0401y0.b.size()) {
                    a().remove();
                    return;
                }
                int i3 = this.b;
                this.b = i3 - 1;
                c0401y0.g(i3);
                return;
            default:
                if (!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                int i4 = kotlin.reflect.jvm.internal.impl.protobuf.A.f3842f;
                kotlin.reflect.jvm.internal.impl.protobuf.A a6 = (kotlin.reflect.jvm.internal.impl.protobuf.A) abstractMap;
                a6.b();
                if (this.b >= a6.b.size()) {
                    a().remove();
                    return;
                }
                int i5 = this.b;
                this.b = i5 - 1;
                a6.f(i5);
                return;
        }
    }
}
