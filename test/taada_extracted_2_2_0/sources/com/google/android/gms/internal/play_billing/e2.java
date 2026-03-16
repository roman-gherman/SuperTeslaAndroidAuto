package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class e2 extends AbstractC0272d1 implements zzin {
    private static final e2 zzb;
    private int zzd;
    private int zze;

    static {
        e2 e2Var = new e2();
        zzb = e2Var;
        AbstractC0272d1.j(e2.class, e2Var);
    }

    public static e2 m() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", J0.i});
        }
        if (i3 == 3) {
            return new e2();
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
