package com.google.gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.h f3029a = com.google.gson.internal.h.c;
    public final int b = 1;
    public final C0408b c = i.f2992a;
    public final HashMap d = new HashMap();
    public final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f3030f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3031g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3032h = 2;
    public final boolean i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3033j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3034k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f3035l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z f3036m = D.f2990a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final A f3037n = D.b;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList f3038o = new LinkedList();

    public final m a() {
        int i;
        M0.v vVar;
        M0.v vVar2;
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f3030f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z6 = P0.c.f1197a;
        M0.e eVar = M0.f.b;
        int i3 = this.f3031g;
        if (i3 != 2 && (i = this.f3032h) != 2) {
            M0.b bVar = new M0.b(eVar, i3, i);
            M0.v vVar3 = M0.y.f1025a;
            M0.v vVar4 = new M0.v(Date.class, bVar, 0);
            if (z6) {
                P0.b bVar2 = P0.c.c;
                bVar2.getClass();
                vVar = new M0.v(bVar2.f994a, new M0.b(bVar2, i3, i), 0);
                P0.b bVar3 = P0.c.b;
                bVar3.getClass();
                vVar2 = new M0.v(bVar3.f994a, new M0.b(bVar3, i3, i), 0);
            } else {
                vVar = null;
                vVar2 = null;
            }
            arrayList3.add(vVar4);
            if (z6) {
                arrayList3.add(vVar);
                arrayList3.add(vVar2);
            }
        }
        return new m(this.f3029a, this.c, new HashMap(this.d), this.i, this.f3033j, this.f3034k, this.f3035l, this.b, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, this.f3036m, this.f3037n, new ArrayList(this.f3038o));
    }
}
