package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class d2 extends AbstractC0272d1 implements zzin {
    private static final d2 zzb;
    private int zzd;
    private N1 zze;

    static {
        d2 d2Var = new d2();
        zzb = d2Var;
        AbstractC0272d1.j(d2.class, d2Var);
    }

    public static /* synthetic */ void m(d2 d2Var, N1 n12) {
        d2Var.zze = n12;
        d2Var.zzd |= 1;
    }

    public static c2 n() {
        return (c2) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i3 == 3) {
            return new d2();
        }
        if (i3 == 4) {
            return new c2(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
