package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f6, float f7, int i, boolean z6);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f6, float f7, int i, boolean z6);

    void onSelected(View view);
}
