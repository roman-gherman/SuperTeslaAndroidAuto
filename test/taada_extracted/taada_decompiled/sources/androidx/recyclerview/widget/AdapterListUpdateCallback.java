package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i3, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i, i3, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i3) {
        this.mAdapter.notifyItemRangeInserted(i, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i3) {
        this.mAdapter.notifyItemMoved(i, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i3) {
        this.mAdapter.notifyItemRangeRemoved(i, i3);
    }
}
