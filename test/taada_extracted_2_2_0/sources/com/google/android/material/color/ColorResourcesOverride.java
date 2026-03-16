package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import androidx.core.os.BuildCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ColorResourcesOverride {
    static ColorResourcesOverride getInstance() {
        int i = Build.VERSION.SDK_INT;
        n0.d dVar = g.d;
        if ((30 > i || i > 33) && !BuildCompat.isAtLeastU()) {
            return null;
        }
        return dVar;
    }

    boolean applyIfPossible(Context context, Map<Integer, Integer> map);

    Context wrapContextIfPossible(Context context, Map<Integer, Integer> map);
}
