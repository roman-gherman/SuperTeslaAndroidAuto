package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static void a(View view, ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener) {
        int paddingStart = ViewCompat.getPaddingStart(view);
        int paddingTop = view.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(view);
        int paddingBottom = view.getPaddingBottom();
        r rVar = new r();
        rVar.f2507a = paddingStart;
        rVar.b = paddingTop;
        rVar.c = paddingEnd;
        rVar.d = paddingBottom;
        ViewCompat.setOnApplyWindowInsetsListener(view, new B.h(viewUtils$OnApplyWindowInsetsListener, rVar, 17, false));
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new q());
        }
    }

    public static boolean b(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode c(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
