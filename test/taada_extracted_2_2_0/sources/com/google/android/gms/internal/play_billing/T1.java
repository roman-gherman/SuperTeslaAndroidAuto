package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class T1 extends AbstractC0272d1 implements zzin {
    private static final T1 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private long zzh;

    static {
        T1 t1 = new T1();
        zzb = t1;
        AbstractC0272d1.j(T1.class, t1);
    }

    public static /* synthetic */ void m(T1 t1, int i) {
        t1.zzd |= 4;
        t1.zzg = i;
    }

    public static /* synthetic */ void n(T1 t1, long j6) {
        t1.zzd |= 8;
        t1.zzh = j6;
    }

    public static /* synthetic */ void o(T1 t1, String str) {
        str.getClass();
        t1.zzd |= 2;
        t1.zzf = str;
    }

    public static /* synthetic */ void p(T1 t1, String str) {
        str.getClass();
        t1.zzd |= 1;
        t1.zze = str;
    }

    public static S1 q() {
        return (S1) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new T1();
        }
        if (i3 == 4) {
            return new S1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
