package androidx.core.view;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2, int i4);

    boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr, int i6);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i3);

    void stopNestedScroll(int i);
}
