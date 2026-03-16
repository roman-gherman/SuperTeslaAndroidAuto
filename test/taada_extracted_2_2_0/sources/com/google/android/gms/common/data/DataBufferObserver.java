package com.google.android.gms.common.data;

/* JADX INFO: loaded from: classes.dex */
public interface DataBufferObserver {

    public interface Observable {
        void addObserver(DataBufferObserver dataBufferObserver);

        void removeObserver(DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(int i, int i3);

    void onDataRangeInserted(int i, int i3);

    void onDataRangeMoved(int i, int i3, int i4);

    void onDataRangeRemoved(int i, int i3);
}
