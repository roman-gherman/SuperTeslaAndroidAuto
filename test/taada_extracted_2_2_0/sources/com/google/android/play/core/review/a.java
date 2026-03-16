package com.google.android.play.core.review;

import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Locale;
import u0.AbstractC0831a;

/* JADX INFO: loaded from: classes.dex */
public class a extends A.a {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(int i) {
        String str;
        Locale locale = Locale.getDefault();
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = AbstractC0831a.f4845a;
        Integer numValueOf2 = Integer.valueOf(i);
        if (map.containsKey(numValueOf2)) {
            str = ((String) map.get(numValueOf2)) + " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#" + ((String) AbstractC0831a.b.get(numValueOf2)) + ")";
        } else {
            str = "";
        }
        super(new Status(i, String.format(locale, "Review Error(%d): %s", numValueOf, str), null, null));
    }
}
