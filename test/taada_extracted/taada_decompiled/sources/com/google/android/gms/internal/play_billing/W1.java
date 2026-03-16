package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class W1 extends AbstractC0272d1 implements zzin {
    private static final W1 zzb;
    private int zzd;
    private int zze;

    static {
        W1 w12 = new W1();
        zzb = w12;
        AbstractC0272d1.j(W1.class, w12);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", J0.f2039g});
        }
        if (i3 == 3) {
            return new W1();
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
