package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class E0 extends AbstractC0272d1 implements zzin {
    private static final E0 zzb;
    private int zzd;
    private I0 zze;
    private I0 zzf;
    private int zzg;

    static {
        E0 e02 = new E0();
        zzb = e02;
        AbstractC0272d1.j(E0.class, e02);
    }

    public static D0 m() {
        return (D0) zzb.e();
    }

    public static /* synthetic */ void n(E0 e02, I0 i0) {
        e02.zze = i0;
        e02.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", J0.b});
        }
        if (i3 == 3) {
            return new E0();
        }
        if (i3 == 4) {
            return new D0(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
