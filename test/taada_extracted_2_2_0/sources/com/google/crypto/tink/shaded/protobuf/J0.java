package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class J0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final J0 f2833f = new J0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2834a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public J0(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.f2834a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z6;
    }

    public static J0 c() {
        return new J0(0, new int[8], new Object[8], true);
    }

    public static void e(int i, Object obj, Writer writer) {
        int i3 = i >>> 3;
        int i4 = i & 7;
        if (i4 == 0) {
            writer.writeInt64(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            writer.writeFixed64(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            writer.writeBytes(i3, (AbstractC0381o) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new RuntimeException(V.c());
            }
            writer.writeFixed32(i3, ((Integer) obj).intValue());
        } else if (writer.fieldOrder() == e1.f2877a) {
            writer.writeStartGroup(i3);
            ((J0) obj).f(writer);
            writer.writeEndGroup(i3);
        } else {
            writer.writeEndGroup(i3);
            ((J0) obj).f(writer);
            writer.writeStartGroup(i3);
        }
    }

    public final void a(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i3 = this.f2834a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i) {
                i = i4;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final int b() {
        int iG;
        int iJ;
        int iC;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2834a; i4++) {
            int i5 = this.b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.c[i4]).getClass();
                    iC = AbstractC0398x.C(i6);
                } else if (i7 == 2) {
                    iC = AbstractC0398x.z(i6, (AbstractC0381o) this.c[i4]);
                } else if (i7 == 3) {
                    iG = AbstractC0398x.G(i6) * 2;
                    iJ = ((J0) this.c[i4]).b();
                } else {
                    if (i7 != 5) {
                        throw new IllegalStateException(V.c());
                    }
                    ((Integer) this.c[i4]).getClass();
                    iC = AbstractC0398x.B(i6);
                }
                i3 = iC + i3;
            } else {
                long jLongValue = ((Long) this.c[i4]).longValue();
                iG = AbstractC0398x.G(i6);
                iJ = AbstractC0398x.J(jLongValue);
            }
            i3 = iJ + iG + i3;
        }
        this.d = i3;
        return i3;
    }

    public final void d(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        a(this.f2834a + 1);
        int[] iArr = this.b;
        int i3 = this.f2834a;
        iArr[i3] = i;
        this.c[i3] = obj;
        this.f2834a = i3 + 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof J0)) {
            return false;
        }
        J0 j02 = (J0) obj;
        int i = this.f2834a;
        if (i == j02.f2834a) {
            int[] iArr = this.b;
            int[] iArr2 = j02.b;
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = j02.c;
                    int i4 = this.f2834a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
                if (iArr[i3] != iArr2[i3]) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final void f(Writer writer) {
        if (this.f2834a == 0) {
            return;
        }
        if (writer.fieldOrder() == e1.f2877a) {
            for (int i = 0; i < this.f2834a; i++) {
                e(this.b[i], this.c[i], writer);
            }
            return;
        }
        for (int i3 = this.f2834a - 1; i3 >= 0; i3--) {
            e(this.b[i3], this.c[i3], writer);
        }
    }

    public final int hashCode() {
        int i = this.f2834a;
        int i3 = (527 + i) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i3 + i4) * 31;
        Object[] objArr = this.c;
        int i7 = this.f2834a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }
}
