package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2302a;
    public final List b;
    public final List c;
    public final float[] d;
    public final float[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f2304g;

    public g(f fVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f2302a = fVar;
        this.b = Collections.unmodifiableList(arrayList);
        this.c = Collections.unmodifiableList(arrayList2);
        float f6 = ((f) androidx.constraintlayout.core.motion.a.g(1, arrayList)).b().f2300a - fVar.b().f2300a;
        this.f2303f = f6;
        float f7 = fVar.d().f2300a - ((f) androidx.constraintlayout.core.motion.a.g(1, arrayList2)).d().f2300a;
        this.f2304g = f7;
        this.d = a(f6, arrayList, true);
        this.e = a(f7, arrayList2, false);
    }

    public static float[] a(float f6, ArrayList arrayList, boolean z6) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i3 = i - 1;
            f fVar = (f) arrayList.get(i3);
            f fVar2 = (f) arrayList.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i3] + ((z6 ? fVar2.b().f2300a - fVar.b().f2300a : fVar.d().f2300a - fVar2.d().f2300a) / f6);
            i++;
        }
        return fArr;
    }

    public static f b(List list, float f6, float[] fArr) {
        int size = list.size();
        float f7 = fArr[0];
        int i = 1;
        while (i < size) {
            float f8 = fArr[i];
            if (f6 <= f8) {
                float fB = W.a.b(0.0f, 1.0f, f7, f8, f6);
                f fVar = (f) list.get(i - 1);
                f fVar2 = (f) list.get(i);
                if (fVar.f2301a != fVar2.f2301a) {
                    throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
                }
                List list2 = fVar.b;
                int size2 = list2.size();
                List list3 = fVar2.b;
                if (size2 != list3.size()) {
                    throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    e eVar = (e) list2.get(i3);
                    e eVar2 = (e) list3.get(i3);
                    arrayList.add(new e(W.a.a(eVar.f2300a, eVar2.f2300a, fB), W.a.a(eVar.b, eVar2.b, fB), W.a.a(eVar.c, eVar2.c, fB), W.a.a(eVar.d, eVar2.d, fB)));
                }
                return new f(fVar.f2301a, arrayList, W.a.c(fVar.c, fVar2.c, fB), W.a.c(fVar.d, fVar2.d, fB));
            }
            i++;
            f7 = f8;
        }
        return (f) list.get(0);
    }

    public static f c(f fVar, int i, int i3, float f6, int i4, int i5) {
        ArrayList arrayList = new ArrayList(fVar.b);
        arrayList.add(i3, (e) arrayList.remove(i));
        d dVar = new d(fVar.f2301a);
        int i6 = 0;
        while (i6 < arrayList.size()) {
            e eVar = (e) arrayList.get(i6);
            float f7 = eVar.d;
            dVar.a((f7 / 2.0f) + f6, eVar.c, f7, i6 >= i4 && i6 <= i5);
            f6 += eVar.d;
            i6++;
        }
        return dVar.b();
    }
}
