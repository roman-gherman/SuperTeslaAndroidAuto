package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(View view, float f6, float f7, boolean z6);

    boolean onNestedPreFling(View view, float f6, float f7);

    void onNestedPreScroll(View view, int i, int i3, int[] iArr);

    void onNestedScroll(View view, int i, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int i);

    boolean onStartNestedScroll(View view, View view2, int i);

    void onStopNestedScroll(View view);
}
