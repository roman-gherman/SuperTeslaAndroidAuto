package com.google.android.play.core.review;

import E1.h;
import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.play.core.review.internal.zzh;

/* JADX INFO: loaded from: classes.dex */
public final class e extends O.a implements zzh {
    public final h b;
    public final com.google.android.gms.tasks.c c;
    public final /* synthetic */ f d;

    public e(f fVar, com.google.android.gms.tasks.c cVar) {
        h hVar = new h("OnRequestInstallCallback");
        this.d = fVar;
        super(4);
        attachInterface(this, "com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
        this.b = hVar;
        this.c = cVar;
    }

    @Override // com.google.android.play.core.review.internal.zzh
    public final void zzb(Bundle bundle) {
        t0.h hVar = this.d.f2765a;
        if (hVar != null) {
            com.google.android.gms.tasks.c cVar = this.c;
            synchronized (hVar.f4786f) {
                hVar.e.remove(cVar);
            }
            hVar.a().post(new t0.g(hVar, 0));
        }
        this.b.a("onGetLaunchReviewFlowInfo", new Object[0]);
        this.c.b(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
