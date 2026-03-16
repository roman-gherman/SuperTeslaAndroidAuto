package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class L1 extends AbstractC0272d1 implements zzin {
    private static final L1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        L1 l12 = new L1();
        zzb = l12;
        AbstractC0272d1.j(L1.class, l12);
    }

    public static /* synthetic */ void m(L1 l12, g2 g2Var) {
        l12.zzf = g2Var;
        l12.zze = 3;
    }

    public static /* synthetic */ void n(L1 l12, int i) {
        l12.zzg = i - 1;
        l12.zzd |= 1;
    }

    public static K1 o() {
        return (K1) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", J0.c, W1.class, g2.class, Y1.class});
        }
        if (i3 == 3) {
            return new L1();
        }
        if (i3 == 4) {
            return new K1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
