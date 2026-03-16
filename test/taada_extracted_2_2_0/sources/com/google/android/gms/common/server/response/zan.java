package com.google.android.gms.common.server.response;

import D.j;
import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new h(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1988a;
    public final HashMap b;
    public final String c;

    public zan(int i, String str, ArrayList arrayList) {
        this.f1988a = i;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zalVar = (zal) arrayList.get(i3);
            String str2 = zalVar.b;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.c;
            j.c(arrayList2);
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zamVar = (zam) arrayList2.get(i4);
                map2.put(zamVar.b, zamVar.c);
            }
            map.put(str2, map2);
        }
        this.b = map;
        j.c(str);
        this.c = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse$Field) map3.get((String) it2.next())).f1981j = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap map = this.b;
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                B2.b.r(sb, "  ", str2, ": ");
                sb.append(map2.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1988a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.b;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        AbstractC0132a.r0(parcel, 2, arrayList);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
