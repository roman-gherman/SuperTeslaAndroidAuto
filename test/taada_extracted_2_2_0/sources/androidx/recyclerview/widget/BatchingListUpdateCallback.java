package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.mLastEventType;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i3, Object obj) {
        int i4;
        if (this.mLastEventType == 3) {
            int i5 = this.mLastEventPosition;
            int i6 = this.mLastEventCount;
            if (i <= i5 + i6 && (i4 = i + i3) >= i5 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i, i5);
                this.mLastEventCount = Math.max(i6 + i5, i4) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i3;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i3) {
        int i4;
        if (this.mLastEventType == 1 && i >= (i4 = this.mLastEventPosition)) {
            int i5 = this.mLastEventCount;
            if (i <= i4 + i5) {
                this.mLastEventCount = i5 + i3;
                this.mLastEventPosition = Math.min(i, i4);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i3;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i3) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i3) {
        int i4;
        if (this.mLastEventType == 2 && (i4 = this.mLastEventPosition) >= i && i4 <= i + i3) {
            this.mLastEventCount += i3;
            this.mLastEventPosition = i;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i3;
            this.mLastEventType = 2;
        }
    }
}
