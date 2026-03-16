package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class Y1 extends AbstractC0272d1 implements zzin {
    private static final Y1 zzb;
    private zzho zzd = C0319t1.e;

    static {
        Y1 y12 = new Y1();
        zzb = y12;
        AbstractC0272d1.j(Y1.class, y12);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", X1.class});
        }
        if (i3 == 3) {
            return new Y1();
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
