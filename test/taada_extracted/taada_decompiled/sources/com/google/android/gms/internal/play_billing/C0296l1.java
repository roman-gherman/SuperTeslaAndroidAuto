package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.l1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0296l1 implements zzik, zziy {
    public static final C0266b1 b = new C0266b1(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2101a;

    public C0296l1(zzik... zzikVarArr) {
        this.f2101a = zzikVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zziy
    public zzix zza(Class cls) {
        C0266b1 c0266b1 = AbstractC0325v1.f2131a;
        if (!AbstractC0272d1.class.isAssignableFrom(cls)) {
            C0316s1 c0316s1 = C0316s1.c;
        }
        zzij zzijVarZzb = ((C0296l1) this.f2101a).zzb(cls);
        if (zzijVarZzb.zzb()) {
            C0316s1 c0316s12 = C0316s1.c;
            C0266b1 c0266b12 = AbstractC0325v1.f2131a;
            C0266b1 c0266b13 = Y0.f2064a;
            return new C0311q1(c0266b12, zzijVarZzb.zza());
        }
        C0316s1 c0316s13 = C0316s1.c;
        int i = AbstractC0313r1.f2122a;
        int i3 = AbstractC0293k1.f2098a;
        C0266b1 c0266b14 = AbstractC0325v1.f2131a;
        C0266b1 c0266b15 = zzijVarZzb.zzc() + (-1) != 1 ? Y0.f2064a : null;
        int i4 = AbstractC0302n1.f2108a;
        return C0308p1.l(zzijVarZzb, c0266b14, c0266b15);
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public zzij zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzik zzikVar = ((zzik[]) this.f2101a)[i];
            if (zzikVar.zzc(cls)) {
                return zzikVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((zzik[]) this.f2101a)[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public C0296l1() {
        C0316s1 c0316s1 = C0316s1.c;
        C0296l1 c0296l1 = new C0296l1(C0266b1.b, b);
        Charset charset = AbstractC0278f1.f2076a;
        this.f2101a = c0296l1;
    }
}
