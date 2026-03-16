package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class X1 extends AbstractC0272d1 implements zzin {
    private static final X1 zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        X1 x12 = new X1();
        zzb = x12;
        AbstractC0272d1.j(X1.class, x12);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", J0.f2040h, "zzf"});
        }
        if (i3 == 3) {
            return new X1();
        }
        if (i3 == 4) {
            return new O1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
