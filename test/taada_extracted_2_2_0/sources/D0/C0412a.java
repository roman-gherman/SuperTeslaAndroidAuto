package d0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: renamed from: d0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0412a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f3067a;

    public C0412a(Chip chip) {
        this.f3067a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        C0414c c0414c = this.f3067a.f2329a;
        if (c0414c != null) {
            c0414c.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
