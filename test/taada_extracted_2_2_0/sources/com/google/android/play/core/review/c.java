package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.h;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ReviewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2764a;
    public final Handler b = new Handler(Looper.getMainLooper());

    public c(f fVar) {
        this.f2764a = fVar;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final com.google.android.gms.tasks.b launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo.c()) {
            h hVar = new h();
            hVar.d();
            return hVar;
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.b());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
        intent.putExtra("result_receiver", new zzc(this.b, cVar));
        activity.startActivity(intent);
        return cVar.f2174a;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final com.google.android.gms.tasks.b requestReviewFlow() {
        f fVar = this.f2764a;
        String str = fVar.b;
        E1.h hVar = f.c;
        hVar.a("requestInAppReview (%s)", str);
        if (fVar.f2765a != null) {
            com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
            t0.h hVar2 = fVar.f2765a;
            d dVar = new d(fVar, cVar, cVar);
            hVar2.getClass();
            hVar2.a().post(new t0.f(hVar2, cVar, cVar, dVar));
            return cVar.f2174a;
        }
        Object[] objArr = new Object[0];
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", E1.h.c(hVar.b, "Play Store app is either not installed or not the official version", objArr));
        }
        a aVar = new a(-1);
        h hVar3 = new h();
        synchronized (hVar3.f2179a) {
            hVar3.e();
            hVar3.c = true;
            hVar3.e = aVar;
        }
        hVar3.b.a(hVar3);
        return hVar3;
    }
}
