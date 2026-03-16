package com.google.android.material.carousel;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2297a;
    public e c;
    public e d;
    public final ArrayList b = new ArrayList();
    public int e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2298f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2299g = 0.0f;

    public d(float f6) {
        this.f2297a = f6;
    }

    public final void a(float f6, float f7, float f8, boolean z6) {
        if (f8 <= 0.0f) {
            return;
        }
        e eVar = new e(Float.MIN_VALUE, f6, f7, f8);
        ArrayList arrayList = this.b;
        if (z6) {
            if (this.c == null) {
                this.c = eVar;
                this.e = arrayList.size();
            }
            if (this.f2298f != -1 && arrayList.size() - this.f2298f > 1) {
                throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
            }
            if (f8 != this.c.d) {
                throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
            }
            this.d = eVar;
            this.f2298f = arrayList.size();
        } else {
            if (this.c == null && f8 < this.f2299g) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            }
            if (this.d != null && f8 > this.f2299g) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
        }
        this.f2299g = f8;
        arrayList.add(eVar);
    }

    public final f b() {
        if (this.c == null) {
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            ArrayList arrayList2 = this.b;
            int size = arrayList2.size();
            float f6 = this.f2297a;
            if (i >= size) {
                return new f(f6, arrayList, this.e, this.f2298f);
            }
            e eVar = (e) arrayList2.get(i);
            arrayList.add(new e((i * f6) + (this.c.b - (this.e * f6)), eVar.b, eVar.c, eVar.d));
            i++;
        }
    }
}
