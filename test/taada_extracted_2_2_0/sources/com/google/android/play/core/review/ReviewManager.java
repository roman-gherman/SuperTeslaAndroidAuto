package com.google.android.play.core.review;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public interface ReviewManager {
    com.google.android.gms.tasks.b launchReviewFlow(Activity activity, ReviewInfo reviewInfo);

    com.google.android.gms.tasks.b requestReviewFlow();
}
