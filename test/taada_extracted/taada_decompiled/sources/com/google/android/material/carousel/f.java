package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2301a;
    public final List b;
    public final int c;
    public final int d;

    public f(float f6, ArrayList arrayList, int i, int i3) {
        this.f2301a = f6;
        this.b = Collections.unmodifiableList(arrayList);
        this.c = i;
        this.d = i3;
    }

    public final e a() {
        return (e) this.b.get(this.c);
    }

    public final e b() {
        return (e) this.b.get(0);
    }

    public final e c() {
        return (e) this.b.get(this.d);
    }

    public final e d() {
        return (e) B2.b.b(1, this.b);
    }
}
