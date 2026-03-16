package P1;

import a.AbstractC0132a;
import e2.C0429e;
import e2.C0430f;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Map, Serializable, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1204a;
    public Object[] b;
    public int[] c;
    public int[] d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1207h;
    public f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f1208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f1209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1210l;

    public e() {
        this(8);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (!this.f1210l) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        i iVar = new i();
        iVar.f1214a = this;
        return iVar;
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int iH = h(obj);
            int i = this.e * 2;
            int length = this.d.length / 2;
            if (i > length) {
                i = length;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.d;
                int i4 = iArr[iH];
                if (i4 <= 0) {
                    int i5 = this.f1205f;
                    Object[] objArr = this.f1204a;
                    if (i5 < objArr.length) {
                        int i6 = i5 + 1;
                        this.f1205f = i6;
                        objArr[i5] = obj;
                        this.c[i5] = iH;
                        iArr[iH] = i6;
                        this.f1207h++;
                        if (i3 > this.e) {
                            this.e = i3;
                        }
                        return i5;
                    }
                    e(1);
                } else {
                    if (kotlin.jvm.internal.h.a(this.f1204a[i4 - 1], obj)) {
                        return -i4;
                    }
                    i3++;
                    if (i3 > i) {
                        i(this.d.length * 2);
                        break;
                    }
                    iH = iH == 0 ? this.d.length - 1 : iH - 1;
                }
            }
        }
    }

    public final void b() {
        if (this.f1210l) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean c(Collection m6) {
        kotlin.jvm.internal.h.f(m6, "m");
        for (Object obj : m6) {
            if (obj != null) {
                try {
                    if (!d((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final void clear() {
        b();
        C0429e c0429eA = new C0430f(0, this.f1205f - 1, 1).iterator();
        while (c0429eA.c) {
            int iNextInt = c0429eA.nextInt();
            int[] iArr = this.c;
            int i = iArr[iNextInt];
            if (i >= 0) {
                this.d[i] = 0;
                iArr[iNextInt] = -1;
            }
        }
        AbstractC0132a.c0(this.f1204a, 0, this.f1205f);
        Object[] objArr = this.b;
        if (objArr != null) {
            AbstractC0132a.c0(objArr, 0, this.f1205f);
        }
        this.f1207h = 0;
        this.f1205f = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final boolean d(Map.Entry entry) {
        kotlin.jvm.internal.h.f(entry, "entry");
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        Object[] objArr = this.b;
        kotlin.jvm.internal.h.c(objArr);
        return kotlin.jvm.internal.h.a(objArr[iF], entry.getValue());
    }

    public final void e(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f1204a;
        int length = objArr.length;
        int i3 = this.f1205f;
        int i4 = length - i3;
        int i5 = i3 - this.f1207h;
        if (i4 < i && i4 + i5 >= i && i5 >= objArr.length / 4) {
            i(this.d.length);
            return;
        }
        int i6 = i3 + i;
        if (i6 < 0) {
            throw new OutOfMemoryError();
        }
        if (i6 > objArr.length) {
            int length2 = (objArr.length * 3) / 2;
            if (i6 <= length2) {
                i6 = length2;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i6);
            kotlin.jvm.internal.h.e(objArrCopyOf2, "copyOf(this, newSize)");
            this.f1204a = objArrCopyOf2;
            Object[] objArr2 = this.b;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i6);
                kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
            } else {
                objArrCopyOf = null;
            }
            this.b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.c, i6);
            kotlin.jvm.internal.h.e(iArrCopyOf, "copyOf(this, newSize)");
            this.c = iArrCopyOf;
            if (i6 < 1) {
                i6 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(i6 * 3);
            if (iHighestOneBit > this.d.length) {
                i(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        f fVar = this.f1209k;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this, 0);
        this.f1209k = fVar2;
        return fVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f1207h == map.size() && c(map.entrySet());
    }

    public final int f(Object obj) {
        int iH = h(obj);
        int i = this.e;
        while (true) {
            int i3 = this.d[iH];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (kotlin.jvm.internal.h.a(this.f1204a[i4], obj)) {
                    return i4;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iH = iH == 0 ? this.d.length - 1 : iH - 1;
        }
    }

    public final int g(Object obj) {
        int i = this.f1205f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                kotlin.jvm.internal.h.c(objArr);
                if (kotlin.jvm.internal.h.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.b;
        kotlin.jvm.internal.h.c(objArr);
        return objArr[iF];
    }

    public final int h(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f1206g;
    }

    @Override // java.util.Map
    public final int hashCode() {
        c cVar = new c(this, 0);
        int i = 0;
        while (cVar.hasNext()) {
            int i3 = cVar.b;
            e eVar = cVar.f1202a;
            if (i3 >= eVar.f1205f) {
                throw new NoSuchElementException();
            }
            cVar.b = i3 + 1;
            cVar.c = i3;
            Object obj = eVar.f1204a[i3];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = eVar.b;
            kotlin.jvm.internal.h.c(objArr);
            Object obj2 = objArr[cVar.c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            cVar.a();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r3[r0] = r7;
        r6.c[r2] = r0;
        r2 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r7) {
        /*
            r6 = this;
            int r0 = r6.f1205f
            int r1 = r6.f1207h
            r2 = 0
            if (r0 <= r1) goto L34
            java.lang.Object[] r0 = r6.b
            r1 = r2
            r3 = r1
        Lb:
            int r4 = r6.f1205f
            if (r1 >= r4) goto L26
            int[] r4 = r6.c
            r4 = r4[r1]
            if (r4 < 0) goto L23
            java.lang.Object[] r4 = r6.f1204a
            r5 = r4[r1]
            r4[r3] = r5
            if (r0 == 0) goto L21
            r4 = r0[r1]
            r0[r3] = r4
        L21:
            int r3 = r3 + 1
        L23:
            int r1 = r1 + 1
            goto Lb
        L26:
            java.lang.Object[] r1 = r6.f1204a
            a.AbstractC0132a.c0(r1, r3, r4)
            if (r0 == 0) goto L32
            int r1 = r6.f1205f
            a.AbstractC0132a.c0(r0, r3, r1)
        L32:
            r6.f1205f = r3
        L34:
            int[] r0 = r6.d
            int r1 = r0.length
            if (r7 == r1) goto L46
            int[] r0 = new int[r7]
            r6.d = r0
            int r7 = java.lang.Integer.numberOfLeadingZeros(r7)
            int r7 = r7 + 1
            r6.f1206g = r7
            goto L4f
        L46:
            int r7 = r0.length
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.h.f(r0, r1)
            java.util.Arrays.fill(r0, r2, r7, r2)
        L4f:
            int r7 = r6.f1205f
            if (r2 >= r7) goto L83
            int r7 = r2 + 1
            java.lang.Object[] r0 = r6.f1204a
            r0 = r0[r2]
            int r0 = r6.h(r0)
            int r1 = r6.e
        L5f:
            int[] r3 = r6.d
            r4 = r3[r0]
            if (r4 != 0) goto L6d
            r3[r0] = r7
            int[] r1 = r6.c
            r1[r2] = r0
            r2 = r7
            goto L4f
        L6d:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L7b
            int r4 = r0 + (-1)
            if (r0 != 0) goto L79
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L5f
        L79:
            r0 = r4
            goto L5f
        L7b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r7.<init>(r0)
            throw r7
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.e.i(int):void");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f1207h == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:6:0x001e->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f1204a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.h.f(r0, r1)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.c
            r0 = r0[r12]
            int r1 = r11.e
            int r1 = r1 * 2
            int[] r2 = r11.d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1e:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L28
            int[] r0 = r11.d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L29
        L28:
            r0 = r5
        L29:
            int r4 = r4 + 1
            int r5 = r11.e
            r6 = -1
            if (r4 <= r5) goto L35
            int[] r0 = r11.d
            r0[r1] = r2
            goto L66
        L35:
            int[] r5 = r11.d
            r7 = r5[r0]
            if (r7 != 0) goto L3e
            r5[r1] = r2
            goto L66
        L3e:
            if (r7 >= 0) goto L45
            r5[r1] = r6
        L42:
            r1 = r0
            r4 = r2
            goto L5f
        L45:
            java.lang.Object[] r5 = r11.f1204a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.h(r5)
            int r5 = r5 - r0
            int[] r9 = r11.d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L5f
            r9[r1] = r7
            int[] r4 = r11.c
            r4[r8] = r1
            goto L42
        L5f:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1e
            int[] r0 = r11.d
            r0[r1] = r6
        L66:
            int[] r0 = r11.c
            r0[r12] = r6
            int r12 = r11.f1207h
            int r12 = r12 + r6
            r11.f1207h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.e.j(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        f fVar = this.i;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this, 1);
        this.i = fVar2;
        return fVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.b;
        if (objArr == null) {
            int length = this.f1204a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        kotlin.jvm.internal.h.f(from, "from");
        b();
        Set<Map.Entry> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        e(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.b;
            if (objArr == null) {
                int length = this.f1204a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!kotlin.jvm.internal.h.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int iF = f(obj);
        if (iF < 0) {
            iF = -1;
        } else {
            j(iF);
        }
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.b;
        kotlin.jvm.internal.h.c(objArr);
        Object obj2 = objArr[iF];
        objArr[iF] = null;
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f1207h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f1207h * 3) + 2);
        sb.append("{");
        c cVar = new c(this, 0);
        int i = 0;
        while (cVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i3 = cVar.b;
            e eVar = cVar.f1202a;
            if (i3 >= eVar.f1205f) {
                throw new NoSuchElementException();
            }
            cVar.b = i3 + 1;
            cVar.c = i3;
            Object obj = eVar.f1204a[i3];
            if (kotlin.jvm.internal.h.a(obj, eVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append(SignatureVisitor.INSTANCEOF);
            Object[] objArr = eVar.b;
            kotlin.jvm.internal.h.c(objArr);
            Object obj2 = objArr[cVar.c];
            if (kotlin.jvm.internal.h.a(obj2, eVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            cVar.a();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        g gVar = this.f1208j;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f1208j = gVar2;
        return gVar2;
    }

    public e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f1204a = objArr;
        this.b = null;
        this.c = iArr;
        this.d = new int[iHighestOneBit];
        this.e = 2;
        this.f1205f = 0;
        this.f1206g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
