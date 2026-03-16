package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class a2 extends AbstractC0272d1 implements zzin {
    private static final a2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private T1 zzg;
    private U1 zzh;

    static {
        a2 a2Var = new a2();
        zzb = a2Var;
        AbstractC0272d1.j(a2.class, a2Var);
    }

    public static /* synthetic */ void m(a2 a2Var, J1 j12) {
        a2Var.zzf = j12;
        a2Var.zze = 2;
    }

    public static /* synthetic */ void n(a2 a2Var, L1 l12) {
        a2Var.zzf = l12;
        a2Var.zze = 3;
    }

    public static /* synthetic */ void o(a2 a2Var, P1 p12) {
        p12.getClass();
        a2Var.zzf = p12;
        a2Var.zze = 7;
    }

    public static /* synthetic */ void p(a2 a2Var, T1 t1) {
        t1.getClass();
        a2Var.zzg = t1;
        a2Var.zzd |= 1;
    }

    public static /* synthetic */ void q(a2 a2Var, d2 d2Var) {
        d2Var.getClass();
        a2Var.zzf = d2Var;
        a2Var.zze = 8;
    }

    public static /* synthetic */ void r(a2 a2Var, e2 e2Var) {
        a2Var.zzf = e2Var;
        a2Var.zze = 4;
    }

    public static Z1 s() {
        return (Z1) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", J1.class, L1.class, e2.class, R1.class, "zzh", P1.class, d2.class});
        }
        if (i3 == 3) {
            return new a2();
        }
        if (i3 == 4) {
            return new Z1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
