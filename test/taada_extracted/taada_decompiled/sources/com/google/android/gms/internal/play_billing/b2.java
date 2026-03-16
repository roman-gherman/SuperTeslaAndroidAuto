package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class b2 extends AbstractC0272d1 implements zzin {
    private static final b2 zzb;
    private int zzd;
    private int zzf;
    private zzho zze = C0319t1.e;
    private String zzg = "";

    static {
        b2 b2Var = new b2();
        zzb = b2Var;
        AbstractC0272d1.j(b2.class, b2Var);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new b2();
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
