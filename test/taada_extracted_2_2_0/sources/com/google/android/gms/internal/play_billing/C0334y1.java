package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0334y1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0334y1 f2135f = new C0334y1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2136a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public C0334y1(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.f2136a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z6;
    }

    public static C0334y1 b() {
        return new C0334y1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iB0;
        int iM;
        int iB02;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i3 = 0; i3 < this.f2136a; i3++) {
            int i4 = this.b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.c[i3]).getClass();
                    iB02 = V0.b0(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    S0 s02 = (S0) this.c[i3];
                    int iB03 = V0.b0(i7);
                    int iC = s02.c();
                    iA = androidx.constraintlayout.core.motion.a.A(iC, iC, iB03, iA);
                } else if (i6 == 3) {
                    int iB04 = V0.b0(i5 << 3);
                    iB0 = iB04 + iB04;
                    iM = ((C0334y1) this.c[i3]).a();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new C0281g1());
                    }
                    ((Integer) this.c[i3]).getClass();
                    iB02 = V0.b0(i5 << 3) + 4;
                }
                iA = iB02 + iA;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.c[i3]).longValue();
                iB0 = V0.b0(i8);
                iM = V0.M(jLongValue);
            }
            iA = iM + iB0 + iA;
        }
        this.d = iA;
        return iA;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        e(this.f2136a + 1);
        int[] iArr = this.b;
        int i3 = this.f2136a;
        iArr[i3] = i;
        this.c[i3] = obj;
        this.f2136a = i3 + 1;
    }

    public final void d(zzjw zzjwVar) {
        if (this.f2136a != 0) {
            for (int i = 0; i < this.f2136a; i++) {
                int i3 = this.b[i];
                Object obj = this.c[i];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 == 0) {
                    zzjwVar.zzt(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzjwVar.zzm(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzjwVar.zzd(i5, (S0) obj);
                } else if (i4 == 3) {
                    zzjwVar.zzF(i5);
                    ((C0334y1) obj).d(zzjwVar);
                    zzjwVar.zzh(i5);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(new C0281g1());
                    }
                    zzjwVar.zzk(i5, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i3 = this.f2136a;
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0334y1)) {
            return false;
        }
        C0334y1 c0334y1 = (C0334y1) obj;
        int i = this.f2136a;
        if (i == c0334y1.f2136a) {
            int[] iArr = this.b;
            int[] iArr2 = c0334y1.b;
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = c0334y1.c;
                    int i4 = this.f2136a;
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

    public final int hashCode() {
        int i = this.f2136a;
        int i3 = i + 527;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int iB = androidx.constraintlayout.core.motion.a.b(i3, 31, i4, 31);
        Object[] objArr = this.c;
        int i6 = this.f2136a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return iB + iHashCode;
    }
}
