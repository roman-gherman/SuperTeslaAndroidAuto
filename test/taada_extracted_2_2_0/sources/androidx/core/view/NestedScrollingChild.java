package androidx.core.view;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f6, float f7, boolean z6);

    boolean dispatchNestedPreFling(float f6, float f7);

    boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2);

    boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z6);

    boolean startNestedScroll(int i);

    void stopNestedScroll();
}
