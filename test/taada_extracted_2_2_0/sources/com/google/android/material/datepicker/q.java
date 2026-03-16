package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class q extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f2429a = L.g(null);
    public final Calendar b = L.g(null);
    public final /* synthetic */ MaterialCalendar c;

    public q(MaterialCalendar materialCalendar) {
        this.c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if ((recyclerView.getAdapter() instanceof O) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            O o6 = (O) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            MaterialCalendar materialCalendar = this.c;
            for (Pair<Long, Long> pair : materialCalendar.c.getSelectedRanges()) {
                Long l6 = pair.first;
                if (l6 != null && pair.second != null) {
                    long jLongValue = l6.longValue();
                    Calendar calendar = this.f2429a;
                    calendar.setTimeInMillis(jLongValue);
                    long jLongValue2 = pair.second.longValue();
                    Calendar calendar2 = this.b;
                    calendar2.setTimeInMillis(jLongValue2);
                    int i = calendar.get(1) - o6.f2407a.d.f2361a.c;
                    int i3 = calendar2.get(1) - o6.f2407a.d.f2361a.c;
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i3);
                    int spanCount = i / gridLayoutManager.getSpanCount();
                    int spanCount2 = i3 / gridLayoutManager.getSpanCount();
                    for (int i4 = spanCount; i4 <= spanCount2; i4++) {
                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i4);
                        if (viewFindViewByPosition3 != null) {
                            int top = viewFindViewByPosition3.getTop() + materialCalendar.f2379h.d.f2413a.top;
                            int bottom = viewFindViewByPosition3.getBottom() - materialCalendar.f2379h.d.f2413a.bottom;
                            canvas.drawRect((i4 != spanCount || viewFindViewByPosition == null) ? 0 : (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft(), top, (i4 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft(), bottom, materialCalendar.f2379h.f2418h);
                        }
                    }
                }
            }
        }
    }
}
