package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.play_billing.AbstractBinderC0276f;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.C0273e;
import com.google.android.gms.internal.play_billing.L1;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1801a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C(Object obj, int i) {
        this.f1801a = i;
        this.b = obj;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzav c0273e;
        switch (this.f1801a) {
            case 0:
                AbstractC0289j0.e("BillingClientTesting", "Billing Override Service connected.");
                D d = (D) this.b;
                int i = AbstractBinderC0276f.b;
                if (iBinder == null) {
                    c0273e = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
                    c0273e = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.play_billing.zzav ? (com.google.android.gms.internal.play_billing.zzav) iInterfaceQueryLocalInterface : new C0273e(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService", 1);
                }
                d.f1803B = c0273e;
                ((D) this.b).f1802A = 2;
                D d6 = (D) this.b;
                d6.getClass();
                L1 l1D = G.d(26);
                Objects.requireNonNull(l1D, "ApiSuccess should not be null");
                d6.f1828g.zzc(l1D);
                break;
            default:
                t0.h hVar = (t0.h) this.b;
                hVar.b.a("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
                hVar.a().post(new com.google.android.play.core.review.d(this, iBinder));
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.f1801a) {
            case 0:
                AbstractC0289j0.f("BillingClientTesting", "Billing Override Service disconnected.");
                ((D) this.b).f1803B = null;
                ((D) this.b).f1802A = 0;
                break;
            default:
                t0.h hVar = (t0.h) this.b;
                hVar.b.a("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
                hVar.a().post(new t0.g(this, 1));
                break;
        }
    }
}
