package com.google.android.material.carousel;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f2296a;
    public List b;

    public c() {
        Paint paint = new Paint();
        this.f2296a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        Paint paint = this.f2296a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (e eVar : this.b) {
            paint.setColor(ColorUtils.blendARGB(-65281, -16776961, eVar.c));
            float paddingTop = ((CarouselLayoutManager) recyclerView.getLayoutManager()).getPaddingTop();
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) recyclerView.getLayoutManager();
            float height = carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            float f6 = eVar.b;
            canvas.drawLine(f6, paddingTop, f6, height, paint);
        }
    }
}
