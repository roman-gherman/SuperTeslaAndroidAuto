package com.google.android.gms.common.server.response;

import D.j;
import a.AbstractC0132a;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastSafeParcelableJsonResponse implements SafeParcelable {
    public static final void g(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        int i = fastJsonResponse$Field.b;
        if (i == 11) {
            Class cls = fastJsonResponse$Field.f1980h;
            j.c(cls);
            sb.append(((FastSafeParcelableJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(L.a.a((String) obj));
            sb.append("\"");
        }
    }

    public abstract Map b();

    public final Object c(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f1980h == null) {
            return d();
        }
        Object objD = d();
        String str = fastJsonResponse$Field.f1978f;
        if (objD != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object d() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean e(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.d != 11) {
            return f();
        }
        if (fastJsonResponse$Field.e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastSafeParcelableJsonResponse fastSafeParcelableJsonResponse = (FastSafeParcelableJsonResponse) obj;
        for (FastJsonResponse$Field fastJsonResponse$Field : b().values()) {
            if (e(fastJsonResponse$Field)) {
                if (!fastSafeParcelableJsonResponse.e(fastJsonResponse$Field) || !j.f(c(fastJsonResponse$Field), fastSafeParcelableJsonResponse.c(fastJsonResponse$Field))) {
                    return false;
                }
            } else if (fastSafeParcelableJsonResponse.e(fastJsonResponse$Field)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse$Field fastJsonResponse$Field : b().values()) {
            if (e(fastJsonResponse$Field)) {
                Object objC = c(fastJsonResponse$Field);
                j.c(objC);
                iHashCode = (iHashCode * 31) + objC.hashCode();
            }
        }
        return iHashCode;
    }

    public String toString() {
        Map mapB = b();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapB.keySet()) {
            FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) mapB.get(str);
            if (e(fastJsonResponse$Field)) {
                Object objC = c(fastJsonResponse$Field);
                StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f1982k;
                if (stringToIntConverter != null) {
                    objC = stringToIntConverter.zad(objC);
                }
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                B2.b.r(sb, "\"", str, "\":");
                if (objC != null) {
                    switch (fastJsonResponse$Field.d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objC, 0));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objC, 10));
                            sb.append("\"");
                            break;
                        case 10:
                            AbstractC0132a.p0(sb, (HashMap) objC);
                            break;
                        default:
                            if (fastJsonResponse$Field.c) {
                                ArrayList arrayList = (ArrayList) objC;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        g(sb, fastJsonResponse$Field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                g(sb, fastJsonResponse$Field, objC);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
