package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.L1;
import com.google.android.gms.internal.play_billing.P1;
import com.google.android.gms.internal.play_billing.S1;
import com.google.android.gms.internal.play_billing.T1;
import com.google.android.gms.internal.play_billing.Z1;
import com.google.android.gms.internal.play_billing.a2;
import com.google.android.gms.internal.play_billing.d2;
import com.google.android.gms.internal.play_billing.e2;
import java.util.ArrayList;
import k.C0569b;
import l.C0614a;

/* JADX INFO: loaded from: classes.dex */
public final class I implements zzch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1819a;
    public Object b;

    public I(C0257h c0257h, ArrayList arrayList) {
        this.f1819a = arrayList;
        this.b = c0257h;
    }

    public p a() {
        if ("first_party".equals((String) this.b)) {
            throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
        }
        if (((String) this.f1819a) == null) {
            throw new IllegalArgumentException("Product id must be provided.");
        }
        if (((String) this.b) != null) {
            return new p(this);
        }
        throw new IllegalArgumentException("Product type must be provided.");
    }

    @Override // com.android.billingclient.api.zzch
    public void zza(J1 j12) {
        if (j12 == null) {
            return;
        }
        try {
            Z1 z1S = a2.s();
            z1S.e((T1) this.f1819a);
            z1S.d();
            a2.m((a2) z1S.b, j12);
            ((A2.B) this.b).a((a2) z1S.b());
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zzb(J1 j12, int i) {
        try {
            S1 s12 = (S1) ((T1) this.f1819a).f();
            s12.d();
            T1.m((T1) s12.b, i);
            this.f1819a = (T1) s12.b();
            zza(j12);
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zzc(L1 l12) {
        if (l12 == null) {
            return;
        }
        try {
            Z1 z1S = a2.s();
            z1S.e((T1) this.f1819a);
            z1S.d();
            a2.n((a2) z1S.b, l12);
            ((A2.B) this.b).a((a2) z1S.b());
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zzd(L1 l12, int i) {
        try {
            S1 s12 = (S1) ((T1) this.f1819a).f();
            s12.d();
            T1.m((T1) s12.b, i);
            this.f1819a = (T1) s12.b();
            zzc(l12);
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zze(P1 p12) {
        try {
            Z1 z1S = a2.s();
            z1S.e((T1) this.f1819a);
            z1S.d();
            a2.o((a2) z1S.b, p12);
            ((A2.B) this.b).a((a2) z1S.b());
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zzf(d2 d2Var) {
        try {
            A2.B b = (A2.B) this.b;
            Z1 z1S = a2.s();
            z1S.e((T1) this.f1819a);
            z1S.d();
            a2.q((a2) z1S.b, d2Var);
            b.a((a2) z1S.b());
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public void zzg(e2 e2Var) {
        if (e2Var == null) {
            return;
        }
        try {
            Z1 z1S = a2.s();
            z1S.e((T1) this.f1819a);
            z1S.d();
            a2.r((a2) z1S.b, e2Var);
            ((A2.B) this.b).a((a2) z1S.b());
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to log.", th);
        }
    }

    public I(Context context, T1 t1) {
        A2.B b = new A2.B();
        try {
            com.google.android.datatransport.runtime.v.b(context);
            b.c = com.google.android.datatransport.runtime.v.a().c(C0614a.e).getTransport("PLAY_BILLING_LIBRARY", a2.class, new C0569b("proto"), new z.e(3));
        } catch (Throwable unused) {
            b.b = true;
        }
        this.b = b;
        this.f1819a = t1;
    }
}
