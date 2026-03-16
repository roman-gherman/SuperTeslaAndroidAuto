package P2;

import A2.C0019a;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.C0763B;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f1218a = new h();

    public final b a(List list, C0763B c0763b, k2.k kVar) {
        List listO0 = kotlin.collections.m.o0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            g gVarB = b(it.next(), null);
            if (gVarB != null) {
                arrayList.add(gVarB);
            }
        }
        return c0763b != null ? new w(arrayList, c0763b.d.p(kVar)) : new b(arrayList, new C0019a(kVar, 7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.collections.u] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v0, types: [P2.h] */
    public final g b(Object obj, C0763B c0763b) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new k(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new s(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            Character ch = (Character) obj;
            ch.getClass();
            return new e(ch);
        }
        if (obj instanceof Float) {
            return new c(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new c(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            Boolean bool = (Boolean) obj;
            bool.getClass();
            return new c(bool);
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        boolean z6 = obj instanceof byte[];
        ?? P5 = kotlin.collections.u.f3805a;
        int i = 0;
        if (z6) {
            byte[] bArr = (byte[]) obj;
            kotlin.jvm.internal.h.f(bArr, "<this>");
            int length = bArr.length;
            if (length != 0) {
                if (length != 1) {
                    P5 = new ArrayList(bArr.length);
                    int length2 = bArr.length;
                    while (i < length2) {
                        P5.add(Byte.valueOf(bArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Byte.valueOf(bArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.BYTE);
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            kotlin.jvm.internal.h.f(sArr, "<this>");
            int length3 = sArr.length;
            if (length3 != 0) {
                if (length3 != 1) {
                    P5 = new ArrayList(sArr.length);
                    int length4 = sArr.length;
                    while (i < length4) {
                        P5.add(Short.valueOf(sArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Short.valueOf(sArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.SHORT);
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            kotlin.jvm.internal.h.f(iArr, "<this>");
            int length5 = iArr.length;
            ?? M5 = P5;
            if (length5 != 0) {
                M5 = length5 != 1 ? kotlin.collections.j.M(iArr) : Z.p(Integer.valueOf(iArr[0]));
            }
            return a(M5, c0763b, k2.k.INT);
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            kotlin.jvm.internal.h.f(jArr, "<this>");
            int length6 = jArr.length;
            if (length6 != 0) {
                if (length6 != 1) {
                    P5 = new ArrayList(jArr.length);
                    int length7 = jArr.length;
                    while (i < length7) {
                        P5.add(Long.valueOf(jArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Long.valueOf(jArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.LONG);
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            kotlin.jvm.internal.h.f(cArr, "<this>");
            int length8 = cArr.length;
            if (length8 != 0) {
                if (length8 != 1) {
                    P5 = new ArrayList(cArr.length);
                    int length9 = cArr.length;
                    while (i < length9) {
                        P5.add(Character.valueOf(cArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Character.valueOf(cArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.CHAR);
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            kotlin.jvm.internal.h.f(fArr, "<this>");
            int length10 = fArr.length;
            if (length10 != 0) {
                if (length10 != 1) {
                    P5 = new ArrayList(fArr.length);
                    int length11 = fArr.length;
                    while (i < length11) {
                        P5.add(Float.valueOf(fArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Float.valueOf(fArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.FLOAT);
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            kotlin.jvm.internal.h.f(dArr, "<this>");
            int length12 = dArr.length;
            if (length12 != 0) {
                if (length12 != 1) {
                    P5 = new ArrayList(dArr.length);
                    int length13 = dArr.length;
                    while (i < length13) {
                        P5.add(Double.valueOf(dArr[i]));
                        i++;
                    }
                } else {
                    P5 = Z.p(Double.valueOf(dArr[0]));
                }
            }
            return a(P5, c0763b, k2.k.DOUBLE);
        }
        if (!(obj instanceof boolean[])) {
            if (obj == null) {
                return new t(null);
            }
            return null;
        }
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.h.f(zArr, "<this>");
        int length14 = zArr.length;
        if (length14 != 0) {
            if (length14 != 1) {
                P5 = new ArrayList(zArr.length);
                int length15 = zArr.length;
                while (i < length15) {
                    P5.add(Boolean.valueOf(zArr[i]));
                    i++;
                }
            } else {
                P5 = Z.p(Boolean.valueOf(zArr[0]));
            }
        }
        return a(P5, c0763b, k2.k.BOOLEAN);
    }
}
