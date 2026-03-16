package com.google.android.gms.common.server.response;

import B.h;
import a.AbstractC0132a;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: classes.dex */
public class FastJsonResponse$Field<I, O> extends AbstractSafeParcelable {
    public static final b CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1977a;
    public final int b;
    public final boolean c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class f1980h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zan f1981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StringToIntConverter f1982k;

    public FastJsonResponse$Field(int i, int i3, boolean z6, int i4, boolean z7, String str, int i5, String str2, zaa zaaVar) {
        this.f1977a = i;
        this.b = i3;
        this.c = z6;
        this.d = i4;
        this.e = z7;
        this.f1978f = str;
        this.f1979g = i5;
        if (str2 == null) {
            this.f1980h = null;
            this.i = null;
        } else {
            this.f1980h = SafeParcelResponse.class;
            this.i = str2;
        }
        if (zaaVar == null) {
            this.f1982k = null;
            return;
        }
        StringToIntConverter stringToIntConverter = zaaVar.b;
        if (stringToIntConverter == null) {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
        this.f1982k = stringToIntConverter;
    }

    public final String toString() {
        h hVar = new h(this, 4);
        hVar.a(Integer.valueOf(this.f1977a), "versionCode");
        hVar.a(Integer.valueOf(this.b), "typeIn");
        hVar.a(Boolean.valueOf(this.c), "typeInArray");
        hVar.a(Integer.valueOf(this.d), "typeOut");
        hVar.a(Boolean.valueOf(this.e), "typeOutArray");
        hVar.a(this.f1978f, "outputFieldName");
        hVar.a(Integer.valueOf(this.f1979g), "safeParcelFieldId");
        String str = this.i;
        if (str == null) {
            str = null;
        }
        hVar.a(str, "concreteTypeName");
        Class cls = this.f1980h;
        if (cls != null) {
            hVar.a(cls.getCanonicalName(), "concreteType.class");
        }
        if (this.f1982k != null) {
            hVar.a(StringToIntConverter.class.getCanonicalName(), "converterName");
        }
        return hVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1977a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.n0(parcel, 6, this.f1978f);
        AbstractC0132a.u0(parcel, 7, 4);
        parcel.writeInt(this.f1979g);
        String str = this.i;
        if (str == null) {
            str = null;
        }
        AbstractC0132a.n0(parcel, 8, str);
        StringToIntConverter stringToIntConverter = this.f1982k;
        AbstractC0132a.m0(parcel, 9, stringToIntConverter != null ? new zaa(stringToIntConverter) : null, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
