package com.google.android.gms.common.server.converter;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse$FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new h(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1974a;
    public final HashMap b = new HashMap();
    public final SparseArray c = new SparseArray();

    public StringToIntConverter(int i, ArrayList arrayList) {
        this.f1974a = i;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zac zacVar = (zac) arrayList.get(i3);
            String str = zacVar.b;
            int i4 = zacVar.c;
            this.b.put(str, Integer.valueOf(i4));
            this.c.put(i4, str);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1974a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.b;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        AbstractC0132a.r0(parcel, 2, arrayList);
        AbstractC0132a.t0(parcel, iS0);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
    public final int zaa() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
    public final int zab() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
    public final /* bridge */ /* synthetic */ Object zac(Object obj) {
        HashMap map = this.b;
        Integer num = (Integer) map.get((String) obj);
        return num == null ? (Integer) map.get("gms_unknown") : num;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
    public final /* bridge */ /* synthetic */ Object zad(Object obj) {
        String str = (String) this.c.get(((Integer) obj).intValue());
        return (str == null && this.b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }
}
