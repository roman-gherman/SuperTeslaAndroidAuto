package com.google.android.material.color;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.billingclient.api.A;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2343a;
    public final c b;
    public final f c = new f(false, "?1", "?2", "?3", "?4", "?5", TypedValues.Custom.S_COLOR);
    public final f d;
    public final A e;

    public b(c cVar, List list) {
        this.b = cVar;
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = ((a) list.get(i)).d;
        }
        this.d = new f(true, strArr);
        this.e = new A(list);
        this.f2343a = new d((short) 512, (short) 288, a());
    }

    public final int a() {
        int i = this.c.f2353l + 288 + this.d.f2353l;
        A a6 = this.e;
        int i3 = (a6.f1800a * 4) + 16;
        Y0.b bVar = (Y0.b) a6.d;
        return (((e[]) bVar.e).length * 16) + (((int[]) bVar.d).length * 4) + 84 + i3 + i;
    }
}
