package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class U1 extends AbstractC0272d1 implements zzin {
    private static final U1 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        U1 u12 = new U1();
        zzb = u12;
        AbstractC0272d1.j(U1.class, u12);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new U1();
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
