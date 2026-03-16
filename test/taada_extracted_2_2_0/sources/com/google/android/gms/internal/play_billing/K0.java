package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class K0 implements zzim {
    protected int zza;

    public abstract int a(zzix zzixVar);

    public final byte[] b() {
        try {
            AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) this;
            int iZzk = abstractC0272d1.zzk();
            byte[] bArr = new byte[iZzk];
            T0 t02 = new T0(bArr, iZzk);
            abstractC0272d1.zzJ(t02);
            if (iZzk - t02.f2053g == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(androidx.constraintlayout.core.motion.a.q("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final S0 zzf() {
        try {
            AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) this;
            int iZzk = abstractC0272d1.zzk();
            R0 r02 = S0.b;
            byte[] bArr = new byte[iZzk];
            T0 t02 = new T0(bArr, iZzk);
            abstractC0272d1.zzJ(t02);
            if (iZzk - t02.f2053g == 0) {
                return new R0(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(androidx.constraintlayout.core.motion.a.q("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }
}
