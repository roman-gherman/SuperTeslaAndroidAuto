package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class P1 extends AbstractC0272d1 implements zzin {
    private static final P1 zzb;

    static {
        P1 p12 = new P1();
        zzb = p12;
        AbstractC0272d1.j(P1.class, p12);
    }

    public static P1 m() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0000", null);
        }
        if (i3 == 3) {
            return new P1();
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
