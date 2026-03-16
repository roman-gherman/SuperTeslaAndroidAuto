package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.q1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0311q1 implements zzix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzim f2120a;
    public final C0266b1 b;

    public C0311q1(C0266b1 c0266b1, zzim zzimVar) {
        C0266b1 c0266b12 = Y0.f2064a;
        this.b = c0266b1;
        this.f2120a = zzimVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zza(Object obj) {
        C0334y1 c0334y1 = ((AbstractC0272d1) obj).zzc;
        int i = c0334y1.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i3 = 0; i3 < c0334y1.f2136a; i3++) {
            int i4 = c0334y1.b[i3] >>> 3;
            S0 s02 = (S0) c0334y1.c[i3];
            int iB0 = V0.b0(8);
            int iB02 = V0.b0(i4) + V0.b0(16);
            int iB03 = V0.b0(24);
            int iC = s02.c();
            iA += iB0 + iB0 + iB02 + androidx.constraintlayout.core.motion.a.a(iC, iC, iB03);
        }
        c0334y1.d = iA;
        return iA;
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final int zzb(Object obj) {
        return ((AbstractC0272d1) obj).zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final Object zze() {
        zzim zzimVar = this.f2120a;
        return zzimVar instanceof AbstractC0272d1 ? (AbstractC0272d1) ((AbstractC0272d1) zzimVar).d(4) : zzimVar.zzI().zzh();
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzf(Object obj) {
        this.b.getClass();
        C0334y1 c0334y1 = ((AbstractC0272d1) obj).zzc;
        if (c0334y1.e) {
            c0334y1.e = false;
        }
        C0266b1 c0266b1 = Y0.f2064a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzg(Object obj, Object obj2) {
        AbstractC0325v1.l(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzh(Object obj, byte[] bArr, int i, int i3, N0 n02) {
        AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) obj;
        if (abstractC0272d1.zzc == C0334y1.f2135f) {
            abstractC0272d1.zzc = C0334y1.b();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzi(Object obj, zzjw zzjwVar) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzj(Object obj, Object obj2) {
        return ((AbstractC0272d1) obj).zzc.equals(((AbstractC0272d1) obj2).zzc);
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzk(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }
}
