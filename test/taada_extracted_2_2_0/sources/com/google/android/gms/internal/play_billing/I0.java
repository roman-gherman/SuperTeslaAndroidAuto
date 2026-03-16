package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class I0 extends AbstractC0272d1 implements zzin {
    private static final I0 zzb;
    private int zzd;
    private String zze = "";

    static {
        I0 i0 = new I0();
        zzb = i0;
        AbstractC0272d1.j(I0.class, i0);
    }

    public static H0 m() {
        return (H0) zzb.e();
    }

    public static /* synthetic */ void n(I0 i0, String str) {
        i0.zzd |= 1;
        i0.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i3 == 3) {
            return new I0();
        }
        if (i3 == 4) {
            return new H0(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
