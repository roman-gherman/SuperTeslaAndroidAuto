package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class N1 extends AbstractC0272d1 implements zzin {
    private static final N1 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        N1 n12 = new N1();
        zzb = n12;
        AbstractC0272d1.j(N1.class, n12);
    }

    public static /* synthetic */ void m(N1 n12, String str) {
        n12.zzd |= 8;
        n12.zzh = str;
    }

    public static /* synthetic */ void n(N1 n12, String str) {
        str.getClass();
        n12.zzd |= 2;
        n12.zzf = str;
    }

    public static /* synthetic */ void o(N1 n12, int i) {
        n12.zzd |= 1;
        n12.zze = i;
    }

    public static /* synthetic */ void p(N1 n12, int i) {
        n12.zzg = i - 1;
        n12.zzd |= 4;
    }

    public static M1 q() {
        return (M1) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", J0.d, "zzh"});
        }
        if (i3 == 3) {
            return new N1();
        }
        if (i3 == 4) {
            return new M1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
