package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.u1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0322u1 implements zzij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzim f2128a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C0322u1(zzim zzimVar, String str, Object[] objArr) {
        this.f2128a = zzimVar;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzij
    public final zzim zza() {
        return this.f2128a;
    }

    @Override // com.google.android.gms.internal.play_billing.zzij
    public final boolean zzb() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzij
    public final int zzc() {
        int i = this.d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
