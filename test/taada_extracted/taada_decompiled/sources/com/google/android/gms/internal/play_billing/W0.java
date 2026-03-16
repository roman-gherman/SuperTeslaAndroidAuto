package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class W0 implements zzjw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V0 f2062a;

    public W0(V0 v02) {
        Charset charset = AbstractC0278f1.f2076a;
        this.f2062a = v02;
        v02.b = this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzA(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.Q(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        v02.X(i4);
        while (i3 < list.size()) {
            v02.R(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzB(int i, int i3) {
        this.f2062a.W(i, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzC(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    int iIntValue = ((Integer) list.get(i3)).intValue();
                    v02.W(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int iB0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int iIntValue2 = ((Integer) list.get(i4)).intValue();
                iB0 += V0.b0((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            v02.X(iB0);
            while (i3 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i3)).intValue();
                v02.X((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                int iB = c0275e1.b(i3);
                v02.W(i, (iB >> 31) ^ (iB + iB));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iB02 = 0;
        for (int i5 = 0; i5 < c0275e1.c; i5++) {
            int iB2 = c0275e1.b(i5);
            iB02 += V0.b0((iB2 >> 31) ^ (iB2 + iB2));
        }
        v02.X(iB02);
        while (i3 < c0275e1.c) {
            int iB3 = c0275e1.b(i3);
            v02.X((iB3 >> 31) ^ (iB3 + iB3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzD(int i, long j6) {
        this.f2062a.Y(i, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzE(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                v02.Y(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iM = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long jLongValue2 = ((Long) list.get(i4)).longValue();
            iM += V0.M((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        v02.X(iM);
        while (i3 < list.size()) {
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            v02.Z((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzF(int i) {
        this.f2062a.V(i, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzG(int i, String str) {
        this.f2062a.U(i, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzH(int i, List list) {
        boolean z6 = list instanceof zzhy;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.U(i, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzhy zzhyVar = (zzhy) list;
        while (i3 < list.size()) {
            Object objZzc = zzhyVar.zzc();
            if (objZzc instanceof String) {
                v02.U(i, (String) objZzc);
            } else {
                v02.N(i, (S0) objZzc);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzI(int i, int i3) {
        this.f2062a.W(i, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzJ(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    v02.W(i, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int iB0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iB0 += V0.b0(((Integer) list.get(i4)).intValue());
            }
            v02.X(iB0);
            while (i3 < list.size()) {
                v02.X(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                v02.W(i, c0275e1.b(i3));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iB02 = 0;
        for (int i5 = 0; i5 < c0275e1.c; i5++) {
            iB02 += V0.b0(c0275e1.b(i5));
        }
        v02.X(iB02);
        while (i3 < c0275e1.c) {
            v02.X(c0275e1.b(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzK(int i, long j6) {
        this.f2062a.Y(i, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzL(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iM = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iM += V0.M(((Long) list.get(i4)).longValue());
        }
        v02.X(iM);
        while (i3 < list.size()) {
            v02.Z(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzb(int i, boolean z6) throws U0 {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3;
        T0 t02 = (T0) this.f2062a;
        t02.X(i << 3);
        int i4 = t02.f2053g;
        try {
            i3 = i4 + 1;
        } catch (IndexOutOfBoundsException e) {
            indexOutOfBoundsException = e;
        }
        try {
            t02.e[i4] = z6 ? (byte) 1 : (byte) 0;
            t02.f2053g = i3;
        } catch (IndexOutOfBoundsException e6) {
            indexOutOfBoundsException = e6;
            i4 = i3;
            throw new U0(i4, t02.f2052f, 1, indexOutOfBoundsException);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzc(int i, List list, boolean z6) throws U0 {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                byte bBooleanValue = ((Boolean) list.get(i3)).booleanValue();
                T0 t02 = (T0) v02;
                t02.X(i << 3);
                int i4 = t02.f2053g;
                try {
                    int i5 = i4 + 1;
                    try {
                        t02.e[i4] = bBooleanValue;
                        t02.f2053g = i5;
                        i3++;
                    } catch (IndexOutOfBoundsException e) {
                        indexOutOfBoundsException = e;
                        i4 = i5;
                        throw new U0(i4, t02.f2052f, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e6) {
                    indexOutOfBoundsException = e6;
                }
            }
            return;
        }
        v02.V(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            ((Boolean) list.get(i7)).getClass();
            i6++;
        }
        v02.X(i6);
        while (i3 < list.size()) {
            byte bBooleanValue2 = ((Boolean) list.get(i3)).booleanValue();
            T0 t03 = (T0) v02;
            int i8 = t03.f2053g;
            try {
                int i9 = i8 + 1;
                try {
                    t03.e[i8] = bBooleanValue2;
                    t03.f2053g = i9;
                    i3++;
                } catch (IndexOutOfBoundsException e7) {
                    indexOutOfBoundsException2 = e7;
                    i8 = i9;
                    throw new U0(i8, t03.f2052f, 1, indexOutOfBoundsException2);
                }
            } catch (IndexOutOfBoundsException e8) {
                indexOutOfBoundsException2 = e8;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzd(int i, S0 s02) {
        this.f2062a.N(i, s02);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zze(int i, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f2062a.N(i, (S0) list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzf(int i, double d) {
        this.f2062a.Q(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzg(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.Q(i, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Double) list.get(i5)).getClass();
            i4 += 8;
        }
        v02.X(i4);
        while (i3 < list.size()) {
            v02.R(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzh(int i) {
        this.f2062a.V(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzi(int i, int i3) {
        this.f2062a.S(i, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzj(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    v02.S(i, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int iM = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iM += V0.M(((Integer) list.get(i4)).intValue());
            }
            v02.X(iM);
            while (i3 < list.size()) {
                v02.T(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                v02.S(i, c0275e1.b(i3));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iM2 = 0;
        for (int i5 = 0; i5 < c0275e1.c; i5++) {
            iM2 += V0.M(c0275e1.b(i5));
        }
        v02.X(iM2);
        while (i3 < c0275e1.c) {
            v02.T(c0275e1.b(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzk(int i, int i3) {
        this.f2062a.O(i, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzl(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    v02.O(i, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            v02.X(i4);
            while (i3 < list.size()) {
                v02.P(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                v02.O(i, c0275e1.b(i3));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < c0275e1.c; i7++) {
            c0275e1.b(i7);
            i6 += 4;
        }
        v02.X(i6);
        while (i3 < c0275e1.c) {
            v02.P(c0275e1.b(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzm(int i, long j6) {
        this.f2062a.Q(i, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzn(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.Q(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        v02.X(i4);
        while (i3 < list.size()) {
            v02.R(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzo(int i, float f6) {
        this.f2062a.O(i, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzp(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.O(i, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Float) list.get(i5)).getClass();
            i4 += 4;
        }
        v02.X(i4);
        while (i3 < list.size()) {
            v02.P(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzq(int i, Object obj, zzix zzixVar) {
        V0 v02 = this.f2062a;
        v02.V(i, 3);
        zzixVar.zzi((zzim) obj, v02.b);
        v02.V(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzr(int i, int i3) {
        this.f2062a.S(i, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzs(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    v02.S(i, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int iM = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iM += V0.M(((Integer) list.get(i4)).intValue());
            }
            v02.X(iM);
            while (i3 < list.size()) {
                v02.T(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                v02.S(i, c0275e1.b(i3));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iM2 = 0;
        for (int i5 = 0; i5 < c0275e1.c; i5++) {
            iM2 += V0.M(c0275e1.b(i5));
        }
        v02.X(iM2);
        while (i3 < c0275e1.c) {
            v02.T(c0275e1.b(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzt(int i, long j6) {
        this.f2062a.Y(i, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzu(int i, List list, boolean z6) {
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z6) {
            while (i3 < list.size()) {
                v02.Y(i, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int iM = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iM += V0.M(((Long) list.get(i4)).longValue());
        }
        v02.X(iM);
        while (i3 < list.size()) {
            v02.Z(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzv(int i, Object obj, zzix zzixVar) {
        zzim zzimVar = (zzim) obj;
        T0 t02 = (T0) this.f2062a;
        t02.X((i << 3) | 2);
        t02.X(((K0) zzimVar).a(zzixVar));
        zzixVar.zzi(zzimVar, t02.b);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzw(int i, Object obj) {
        boolean z6 = obj instanceof S0;
        V0 v02 = this.f2062a;
        if (z6) {
            T0 t02 = (T0) v02;
            t02.X(11);
            t02.W(2, i);
            t02.N(3, (S0) obj);
            t02.X(12);
            return;
        }
        zzim zzimVar = (zzim) obj;
        T0 t03 = (T0) v02;
        t03.X(11);
        t03.W(2, i);
        t03.X(26);
        t03.X(zzimVar.zzk());
        zzimVar.zzJ(t03);
        t03.X(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzx(int i, int i3) {
        this.f2062a.O(i, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzy(int i, List list, boolean z6) {
        boolean z7 = list instanceof C0275e1;
        int i3 = 0;
        V0 v02 = this.f2062a;
        if (!z7) {
            if (!z6) {
                while (i3 < list.size()) {
                    v02.O(i, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            v02.V(i, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                i4 += 4;
            }
            v02.X(i4);
            while (i3 < list.size()) {
                v02.P(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        if (!z6) {
            while (i3 < c0275e1.c) {
                v02.O(i, c0275e1.b(i3));
                i3++;
            }
            return;
        }
        v02.V(i, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < c0275e1.c; i7++) {
            c0275e1.b(i7);
            i6 += 4;
        }
        v02.X(i6);
        while (i3 < c0275e1.c) {
            v02.P(c0275e1.b(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzz(int i, long j6) {
        this.f2062a.Q(i, j6);
    }
}
