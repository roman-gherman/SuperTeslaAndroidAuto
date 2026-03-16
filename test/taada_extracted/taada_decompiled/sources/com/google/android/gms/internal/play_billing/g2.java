package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class g2 extends AbstractC0272d1 implements zzin {
    private static final g2 zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        g2 g2Var = new g2();
        zzb = g2Var;
        AbstractC0272d1.j(g2.class, g2Var);
    }

    public static /* synthetic */ void m(g2 g2Var) {
        g2Var.zzd |= 2;
        g2Var.zzf = true;
    }

    public static f2 n() {
        return (f2) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new g2();
        }
        if (i3 == 4) {
            return new f2(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
