package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import d0.C0414c;

/* JADX INFO: loaded from: classes.dex */
public final class k extends k0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2502a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(Object obj, int i) {
        this.f2502a = i;
        this.b = obj;
    }

    private final void c(int i) {
    }

    @Override // k0.g
    public final void a(int i) {
        switch (this.f2502a) {
            case 0:
                l lVar = (l) this.b;
                lVar.d = true;
                TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = (TextDrawableHelper$TextDrawableDelegate) lVar.e.get();
                if (textDrawableHelper$TextDrawableDelegate != null) {
                    textDrawableHelper$TextDrawableDelegate.onTextSizeChange();
                }
                break;
        }
    }

    @Override // k0.g
    public final void b(Typeface typeface, boolean z6) {
        switch (this.f2502a) {
            case 0:
                if (!z6) {
                    l lVar = (l) this.b;
                    lVar.d = true;
                    TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = (TextDrawableHelper$TextDrawableDelegate) lVar.e.get();
                    if (textDrawableHelper$TextDrawableDelegate != null) {
                        textDrawableHelper$TextDrawableDelegate.onTextSizeChange();
                    }
                    break;
                }
                break;
            default:
                Chip chip = (Chip) this.b;
                C0414c c0414c = chip.f2329a;
                chip.setText(c0414c.f3075C0 ? c0414c.E : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
        }
    }
}
