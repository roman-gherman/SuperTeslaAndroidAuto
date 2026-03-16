package com.google.android.play.core.review;

import E1.h;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.android.billingclient.api.C;
import com.google.android.play.core.review.internal.zzf;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d extends t0.d {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public d(C c, IBinder iBinder) {
        this.c = iBinder;
        this.d = c;
    }

    @Override // t0.d
    public final void a() {
        HashMap map;
        zzf bVar;
        switch (this.b) {
            case 0:
                try {
                    f fVar = (f) this.d;
                    zzf zzfVar = fVar.f2765a.f4791m;
                    String str = fVar.b;
                    Bundle bundle = new Bundle();
                    HashMap map2 = g.f2766a;
                    synchronized (g.class) {
                        map = g.f2766a;
                        map.put("java", 20002);
                    }
                    bundle.putInt("playcore_version_code", ((Integer) map.get("java")).intValue());
                    if (map.containsKey("native")) {
                        bundle.putInt("playcore_native_version", ((Integer) map.get("native")).intValue());
                    }
                    if (map.containsKey("unity")) {
                        bundle.putInt("playcore_unity_version", ((Integer) map.get("unity")).intValue());
                    }
                    f fVar2 = (f) this.d;
                    com.google.android.gms.tasks.c cVar = (com.google.android.gms.tasks.c) this.c;
                    String str2 = fVar2.b;
                    zzfVar.zzc(str, bundle, new e(fVar2, cVar));
                    return;
                } catch (RemoteException e) {
                    f fVar3 = (f) this.d;
                    h hVar = f.c;
                    Object[] objArr = {fVar3.b};
                    hVar.getClass();
                    if (Log.isLoggable("PlayCore", 6)) {
                        Log.e("PlayCore", h.c(hVar.b, "error requesting in-app review for %s", objArr), e);
                    }
                    ((com.google.android.gms.tasks.c) this.c).a(new RuntimeException(e));
                    return;
                }
            default:
                int i = t0.c.b;
                IBinder iBinder = (IBinder) this.c;
                if (iBinder == null) {
                    bVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
                    bVar = iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new t0.b(iBinder);
                }
                t0.h hVar2 = (t0.h) ((C) this.d).b;
                hVar2.f4791m = bVar;
                h hVar3 = hVar2.b;
                hVar3.a("linkToDeath", new Object[0]);
                try {
                    hVar2.f4791m.asBinder().linkToDeath(hVar2.f4788j, 0);
                    break;
                } catch (RemoteException e6) {
                    Object[] objArr2 = new Object[0];
                    hVar3.getClass();
                    if (Log.isLoggable("PlayCore", 6)) {
                        Log.e("PlayCore", h.c(hVar3.b, "linkToDeath failed", objArr2), e6);
                    }
                }
                hVar2.f4786g = false;
                Iterator it = hVar2.d.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                hVar2.d.clear();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, com.google.android.gms.tasks.c cVar, com.google.android.gms.tasks.c cVar2) {
        super(cVar);
        this.c = cVar2;
        this.d = fVar;
    }
}
