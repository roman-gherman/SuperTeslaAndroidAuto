package com.google.android.gms.common.server.response;

import C0.x;
import D.j;
import Q.h;
import a.AbstractC0132a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import c4.AbstractC0246d;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new h(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1983a;
    public final Parcel b;
    public final int c;
    public final zan d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1985g;

    public SafeParcelResponse(int i, Parcel parcel, zan zanVar) {
        this.f1983a = i;
        j.c(parcel);
        this.b = parcel;
        this.c = 2;
        this.d = zanVar;
        this.e = zanVar == null ? null : zanVar.c;
        this.f1984f = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void i(StringBuilder sb, Map map, Parcel parcel) {
        BigInteger bigInteger;
        Parcel parcelObtain;
        BigInteger[] bigIntegerArr;
        long[] jArrCreateLongArray;
        float[] fArrCreateFloatArray;
        double[] dArrCreateDoubleArray;
        BigDecimal[] bigDecimalArr;
        boolean[] zArrCreateBooleanArray;
        String[] strArrCreateStringArray;
        Parcel[] parcelArr;
        Object bigInteger2;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse$Field) entry.getValue()).f1979g, entry);
        }
        sb.append('{');
        int iM0 = AbstractC0246d.M0(parcel);
        boolean z6 = false;
        while (parcel.dataPosition() < iM0) {
            int i = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i);
            if (entry2 != null) {
                if (z6) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) entry2.getValue();
                B2.b.r(sb, "\"", str, "\":");
                StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f1982k;
                int i3 = fastJsonResponse$Field.d;
                if (stringToIntConverter != null) {
                    StringToIntConverter stringToIntConverter2 = fastJsonResponse$Field.f1982k;
                    switch (i3) {
                        case 0:
                            Object objValueOf = Integer.valueOf(AbstractC0246d.q0(parcel, i));
                            if (stringToIntConverter2 != 0) {
                                objValueOf = stringToIntConverter2.zad(objValueOf);
                            }
                            k(sb, fastJsonResponse$Field, objValueOf);
                            break;
                        case 1:
                            int iT0 = AbstractC0246d.t0(parcel, i);
                            int iDataPosition = parcel.dataPosition();
                            if (iT0 == 0) {
                                bigInteger2 = null;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iT0);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            if (stringToIntConverter2 != 0) {
                                bigInteger2 = stringToIntConverter2.zad(bigInteger2);
                            }
                            k(sb, fastJsonResponse$Field, bigInteger2);
                            break;
                        case 2:
                            Object objValueOf2 = Long.valueOf(AbstractC0246d.r0(parcel, i));
                            if (stringToIntConverter2 != 0) {
                                objValueOf2 = stringToIntConverter2.zad(objValueOf2);
                            }
                            k(sb, fastJsonResponse$Field, objValueOf2);
                            break;
                        case 3:
                            Object objValueOf3 = Float.valueOf(AbstractC0246d.n0(parcel, i));
                            if (stringToIntConverter2 != 0) {
                                objValueOf3 = stringToIntConverter2.zad(objValueOf3);
                            }
                            k(sb, fastJsonResponse$Field, objValueOf3);
                            break;
                        case 4:
                            AbstractC0246d.P0(parcel, i, 8);
                            Object objValueOf4 = Double.valueOf(parcel.readDouble());
                            if (stringToIntConverter2 != 0) {
                                objValueOf4 = stringToIntConverter2.zad(objValueOf4);
                            }
                            k(sb, fastJsonResponse$Field, objValueOf4);
                            break;
                        case 5:
                            Object objS = AbstractC0246d.s(parcel, i);
                            if (stringToIntConverter2 != 0) {
                                objS = stringToIntConverter2.zad(objS);
                            }
                            k(sb, fastJsonResponse$Field, objS);
                            break;
                        case 6:
                            Object objValueOf5 = Boolean.valueOf(AbstractC0246d.l0(parcel, i));
                            if (stringToIntConverter2 != 0) {
                                objValueOf5 = stringToIntConverter2.zad(objValueOf5);
                            }
                            k(sb, fastJsonResponse$Field, objValueOf5);
                            break;
                        case 7:
                            Object objA = AbstractC0246d.A(parcel, i);
                            if (stringToIntConverter2 != 0) {
                                objA = stringToIntConverter2.zad(objA);
                            }
                            k(sb, fastJsonResponse$Field, objA);
                            break;
                        case 8:
                        case 9:
                            Object objU = AbstractC0246d.u(parcel, i);
                            if (stringToIntConverter2 != 0) {
                                objU = stringToIntConverter2.zad(objU);
                            }
                            k(sb, fastJsonResponse$Field, objU);
                            break;
                        case 10:
                            Bundle bundleT = AbstractC0246d.t(parcel, i);
                            Object map2 = new HashMap();
                            for (String str2 : bundleT.keySet()) {
                                String string = bundleT.getString(str2);
                                j.c(string);
                                map2.put(str2, string);
                            }
                            if (stringToIntConverter2 != 0) {
                                map2 = stringToIntConverter2.zad(map2);
                            }
                            k(sb, fastJsonResponse$Field, map2);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(B2.b.c(i3, "Unknown field out type = "));
                    }
                } else {
                    boolean z7 = fastJsonResponse$Field.e;
                    String str3 = fastJsonResponse$Field.i;
                    if (z7) {
                        sb.append("[");
                        switch (i3) {
                            case 0:
                                int[] iArrW = AbstractC0246d.w(parcel, i);
                                int length = iArrW.length;
                                for (int i4 = 0; i4 < length; i4++) {
                                    if (i4 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(iArrW[i4]);
                                }
                                break;
                            case 1:
                                int iT02 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition2 = parcel.dataPosition();
                                if (iT02 == 0) {
                                    bigIntegerArr = null;
                                } else {
                                    int i5 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i5];
                                    for (int i6 = 0; i6 < i5; i6++) {
                                        bigIntegerArr[i6] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + iT02);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i7 = 0; i7 < length2; i7++) {
                                    if (i7 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigIntegerArr[i7]);
                                }
                                break;
                            case 2:
                                int iT03 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition3 = parcel.dataPosition();
                                if (iT03 == 0) {
                                    jArrCreateLongArray = null;
                                } else {
                                    jArrCreateLongArray = parcel.createLongArray();
                                    parcel.setDataPosition(iDataPosition3 + iT03);
                                }
                                int length3 = jArrCreateLongArray.length;
                                for (int i8 = 0; i8 < length3; i8++) {
                                    if (i8 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(jArrCreateLongArray[i8]);
                                }
                                break;
                            case 3:
                                int iT04 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition4 = parcel.dataPosition();
                                if (iT04 == 0) {
                                    fArrCreateFloatArray = null;
                                } else {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition4 + iT04);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i9 = 0; i9 < length4; i9++) {
                                    if (i9 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(fArrCreateFloatArray[i9]);
                                }
                                break;
                            case 4:
                                int iT05 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition5 = parcel.dataPosition();
                                if (iT05 == 0) {
                                    dArrCreateDoubleArray = null;
                                } else {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition5 + iT05);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i10 = 0; i10 < length5; i10++) {
                                    if (i10 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(dArrCreateDoubleArray[i10]);
                                }
                                break;
                            case 5:
                                int iT06 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition6 = parcel.dataPosition();
                                if (iT06 == 0) {
                                    bigDecimalArr = null;
                                } else {
                                    int i11 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i11];
                                    for (int i12 = 0; i12 < i11; i12++) {
                                        bigDecimalArr[i12] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition6 + iT06);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i13 = 0; i13 < length6; i13++) {
                                    if (i13 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigDecimalArr[i13]);
                                }
                                break;
                            case 6:
                                int iT07 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition7 = parcel.dataPosition();
                                if (iT07 == 0) {
                                    zArrCreateBooleanArray = null;
                                } else {
                                    zArrCreateBooleanArray = parcel.createBooleanArray();
                                    parcel.setDataPosition(iDataPosition7 + iT07);
                                }
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i14 = 0; i14 < length7; i14++) {
                                    if (i14 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(zArrCreateBooleanArray[i14]);
                                }
                                break;
                            case 7:
                                int iT08 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition8 = parcel.dataPosition();
                                if (iT08 == 0) {
                                    strArrCreateStringArray = null;
                                } else {
                                    strArrCreateStringArray = parcel.createStringArray();
                                    parcel.setDataPosition(iDataPosition8 + iT08);
                                }
                                int length8 = strArrCreateStringArray.length;
                                for (int i15 = 0; i15 < length8; i15++) {
                                    if (i15 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(strArrCreateStringArray[i15]);
                                    sb.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int iT09 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition9 = parcel.dataPosition();
                                if (iT09 == 0) {
                                    parcelArr = null;
                                } else {
                                    int i16 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i16];
                                    for (int i17 = 0; i17 < i16; i17++) {
                                        int i18 = parcel.readInt();
                                        if (i18 != 0) {
                                            int iDataPosition10 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition10, i18);
                                            parcelArr2[i17] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition10 + i18);
                                        } else {
                                            parcelArr2[i17] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition9 + iT09);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i19 = 0; i19 < length9; i19++) {
                                    if (i19 > 0) {
                                        sb.append(",");
                                    }
                                    parcelArr[i19].setDataPosition(0);
                                    j.c(str3);
                                    j.c(fastJsonResponse$Field.f1981j);
                                    Map map3 = (Map) fastJsonResponse$Field.f1981j.b.get(str3);
                                    j.c(map3);
                                    i(sb, map3, parcelArr[i19]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb.append("]");
                    } else {
                        switch (i3) {
                            case 0:
                                sb.append(AbstractC0246d.q0(parcel, i));
                                break;
                            case 1:
                                int iT010 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition11 = parcel.dataPosition();
                                if (iT010 == 0) {
                                    bigInteger = null;
                                } else {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition11 + iT010);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb.append(bigInteger);
                                break;
                            case 2:
                                sb.append(AbstractC0246d.r0(parcel, i));
                                break;
                            case 3:
                                sb.append(AbstractC0246d.n0(parcel, i));
                                break;
                            case 4:
                                AbstractC0246d.P0(parcel, i, 8);
                                sb.append(parcel.readDouble());
                                break;
                            case 5:
                                sb.append(AbstractC0246d.s(parcel, i));
                                break;
                            case 6:
                                sb.append(AbstractC0246d.l0(parcel, i));
                                break;
                            case 7:
                                String strA = AbstractC0246d.A(parcel, i);
                                sb.append("\"");
                                sb.append(L.a.a(strA));
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] bArrU = AbstractC0246d.u(parcel, i);
                                sb.append("\"");
                                sb.append(bArrU == null ? null : Base64.encodeToString(bArrU, 0));
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] bArrU2 = AbstractC0246d.u(parcel, i);
                                sb.append("\"");
                                sb.append(bArrU2 == null ? null : Base64.encodeToString(bArrU2, 10));
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle bundleT2 = AbstractC0246d.t(parcel, i);
                                Set<String> setKeySet = bundleT2.keySet();
                                sb.append("{");
                                boolean z8 = true;
                                for (String str4 : setKeySet) {
                                    if (!z8) {
                                        sb.append(",");
                                    }
                                    B2.b.r(sb, "\"", str4, "\":\"");
                                    sb.append(L.a.a(bundleT2.getString(str4)));
                                    sb.append("\"");
                                    z8 = false;
                                }
                                sb.append("}");
                                break;
                            case 11:
                                int iT011 = AbstractC0246d.t0(parcel, i);
                                int iDataPosition12 = parcel.dataPosition();
                                if (iT011 == 0) {
                                    parcelObtain = null;
                                } else {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition12, iT011);
                                    parcel.setDataPosition(iDataPosition12 + iT011);
                                }
                                parcelObtain.setDataPosition(0);
                                j.c(str3);
                                j.c(fastJsonResponse$Field.f1981j);
                                Map map4 = (Map) fastJsonResponse$Field.f1981j.b.get(str3);
                                j.c(map4);
                                i(sb, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z6 = true;
            }
        }
        if (parcel.dataPosition() != iM0) {
            throw new x(B2.b.c(iM0, "Overread allowed size end="), parcel);
        }
        sb.append('}');
    }

    public static final void j(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                j.c(obj);
                sb.append(L.a.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                byte[] bArr = (byte[]) obj;
                sb.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb.append("\"");
                return;
            case 10:
                j.c(obj);
                AbstractC0132a.p0(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(B2.b.c(i, "Unknown type = "));
        }
    }

    public static final void k(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        boolean z6 = fastJsonResponse$Field.c;
        int i = fastJsonResponse$Field.b;
        if (!z6) {
            j(sb, i, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            j(sb, i, arrayList.get(i3));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Map b() {
        zan zanVar = this.d;
        if (zanVar == null) {
            return null;
        }
        String str = this.e;
        j.c(str);
        return (Map) zanVar.b.get(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Object d() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean f() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel h() {
        int i = this.f1984f;
        Parcel parcel = this.b;
        if (i != 0) {
            if (i != 1) {
                return parcel;
            }
            AbstractC0132a.t0(parcel, this.f1985g);
            this.f1984f = 2;
            return parcel;
        }
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        this.f1985g = iS0;
        AbstractC0132a.t0(parcel, iS0);
        this.f1984f = 2;
        return parcel;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final String toString() {
        zan zanVar = this.d;
        j.d(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelH = h();
        parcelH.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        String str = this.e;
        j.c(str);
        Map map = (Map) zanVar.b.get(str);
        j.c(map);
        i(sb, map, parcelH);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1983a);
        Parcel parcelH = h();
        if (parcelH != null) {
            int iS02 = AbstractC0132a.s0(parcel, 2);
            parcel.appendFrom(parcelH, 0, parcelH.dataSize());
            AbstractC0132a.t0(parcel, iS02);
        }
        AbstractC0132a.m0(parcel, 3, this.c != 0 ? this.d : null, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
