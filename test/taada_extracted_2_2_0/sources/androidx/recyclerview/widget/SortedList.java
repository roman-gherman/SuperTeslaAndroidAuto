package androidx.recyclerview.widget;

import B2.b;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i3) {
            this.mBatchingListUpdateCallback.onChanged(i, i3, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i3) {
            this.mBatchingListUpdateCallback.onInserted(i, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i3) {
            this.mBatchingListUpdateCallback.onMoved(i, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i3) {
            this.mBatchingListUpdateCallback.onRemoved(i, i3);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i3, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i, i3, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i, int i3);

        public void onChanged(int i, int i3, Object obj) {
            onChanged(i, i3);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iSortAndDedup = sortAndDedup(tArr);
        if (this.mSize != 0) {
            merge(tArr, iSortAndDedup);
            return;
        }
        this.mData = tArr;
        this.mSize = iSortAndDedup;
        this.mCallback.onInserted(0, iSortAndDedup);
    }

    private void addToData(int i, T t6) {
        int i3 = this.mSize;
        if (i > i3) {
            StringBuilder sbJ = b.j(i, "cannot add item to ", " because size is ");
            sbJ.append(this.mSize);
            throw new IndexOutOfBoundsException(sbJ.toString());
        }
        T[] tArr = this.mData;
        if (i3 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i);
            tArr2[i] = t6;
            System.arraycopy(this.mData, i, tArr2, i + 1, this.mSize - i);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i, tArr, i + 1, i3 - i);
            this.mData[i] = t6;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t6, T[] tArr, int i, int i3, int i4) {
        while (i < i3) {
            int i5 = (i + i3) / 2;
            T t7 = tArr[i5];
            int iCompare = this.mCallback.compare(t7, t6);
            if (iCompare < 0) {
                i = i5 + 1;
            } else {
                if (iCompare == 0) {
                    if (!this.mCallback.areItemsTheSame(t7, t6)) {
                        int iLinearEqualitySearch = linearEqualitySearch(t6, i5, i, i3);
                        if (i4 != 1 || iLinearEqualitySearch != -1) {
                            return iLinearEqualitySearch;
                        }
                    }
                    return i5;
                }
                i3 = i5;
            }
        }
        if (i4 == 1) {
            return i;
        }
        return -1;
    }

    private int findSameItem(T t6, T[] tArr, int i, int i3) {
        while (i < i3) {
            if (this.mCallback.areItemsTheSame(tArr[i], t6)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t6, int i, int i3, int i4) {
        T t7;
        for (int i5 = i - 1; i5 >= i3; i5--) {
            T t8 = this.mData[i5];
            if (this.mCallback.compare(t8, t6) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t8, t6)) {
                return i5;
            }
        }
        do {
            i++;
            if (i >= i4) {
                return -1;
            }
            t7 = this.mData[i];
            if (this.mCallback.compare(t7, t6) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t7, t6));
        return i;
    }

    private void merge(T[] tArr, int i) {
        boolean z6 = this.mCallback instanceof BatchedCallback;
        if (!z6) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i3 = 0;
        this.mOldDataStart = 0;
        int i4 = this.mSize;
        this.mOldDataSize = i4;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i4 + i + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 >= i6 && i3 >= i) {
                break;
            }
            if (i5 == i6) {
                int i7 = i - i3;
                System.arraycopy(tArr, i3, this.mData, this.mNewDataStart, i7);
                int i8 = this.mNewDataStart + i7;
                this.mNewDataStart = i8;
                this.mSize += i7;
                this.mCallback.onInserted(i8 - i7, i7);
                break;
            }
            if (i3 == i) {
                int i9 = i6 - i5;
                System.arraycopy(this.mOldData, i5, this.mData, this.mNewDataStart, i9);
                this.mNewDataStart += i9;
                break;
            }
            T t6 = this.mOldData[i5];
            T t7 = tArr[i3];
            int iCompare = this.mCallback.compare(t6, t7);
            if (iCompare > 0) {
                T[] tArr2 = this.mData;
                int i10 = this.mNewDataStart;
                this.mNewDataStart = i10 + 1;
                tArr2[i10] = t7;
                this.mSize++;
                i3++;
                this.mCallback.onInserted(i10, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(t6, t7)) {
                T[] tArr3 = this.mData;
                int i11 = this.mNewDataStart;
                this.mNewDataStart = i11 + 1;
                tArr3[i11] = t7;
                i3++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t6, t7)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t6, t7));
                }
            } else {
                T[] tArr4 = this.mData;
                int i12 = this.mNewDataStart;
                this.mNewDataStart = i12 + 1;
                tArr4[i12] = t6;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z6) {
            return;
        }
        endBatchedUpdates();
    }

    private void removeItemAtIndex(int i, boolean z6) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i + 1, tArr, i, (this.mSize - i) - 1);
        int i3 = this.mSize - 1;
        this.mSize = i3;
        this.mData[i3] = null;
        if (z6) {
            this.mCallback.onRemoved(i, 1);
        }
    }

    private void replaceAllInsert(T t6) {
        T[] tArr = this.mData;
        int i = this.mNewDataStart;
        tArr[i] = t6;
        this.mNewDataStart = i + 1;
        this.mSize++;
        this.mCallback.onInserted(i, 1);
    }

    private void replaceAllInternal(T[] tArr) {
        boolean z6 = this.mCallback instanceof BatchedCallback;
        if (!z6) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup));
        while (true) {
            int i = this.mNewDataStart;
            if (i >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i3 = this.mOldDataStart;
            int i4 = this.mOldDataSize;
            if (i3 >= i4) {
                int i5 = iSortAndDedup - i;
                System.arraycopy(tArr, i, this.mData, i, i5);
                this.mNewDataStart += i5;
                this.mSize += i5;
                this.mCallback.onInserted(i, i5);
                break;
            }
            if (i >= iSortAndDedup) {
                int i6 = i4 - i3;
                this.mSize -= i6;
                this.mCallback.onRemoved(i, i6);
                break;
            }
            T t6 = this.mOldData[i3];
            T t7 = tArr[i];
            int iCompare = this.mCallback.compare(t6, t7);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(t7);
            } else if (this.mCallback.areItemsTheSame(t6, t7)) {
                T[] tArr2 = this.mData;
                int i7 = this.mNewDataStart;
                tArr2[i7] = t7;
                this.mOldDataStart++;
                this.mNewDataStart = i7 + 1;
                if (!this.mCallback.areContentsTheSame(t6, t7)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t6, t7));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t7);
            }
        }
        this.mOldData = null;
        if (z6) {
            return;
        }
        endBatchedUpdates();
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i = 0;
        int i3 = 1;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T t6 = tArr[i4];
            if (this.mCallback.compare(tArr[i], t6) == 0) {
                int iFindSameItem = findSameItem(t6, tArr, i, i3);
                if (iFindSameItem != -1) {
                    tArr[iFindSameItem] = t6;
                } else {
                    if (i3 != i4) {
                        tArr[i3] = t6;
                    }
                    i3++;
                }
            } else {
                if (i3 != i4) {
                    tArr[i3] = t6;
                }
                i = i3;
                i3++;
            }
        }
        return i3;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t6) {
        throwIfInMutationOperation();
        return add(t6, true);
    }

    public void addAll(T[] tArr, boolean z6) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z6) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i = this.mSize;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i) {
        int i3;
        if (i < this.mSize && i >= 0) {
            T[] tArr = this.mOldData;
            return (tArr == null || i < (i3 = this.mNewDataStart)) ? this.mData[i] : tArr[(i - i3) + this.mOldDataStart];
        }
        StringBuilder sbJ = b.j(i, "Asked to get item at ", " but size is ");
        sbJ.append(this.mSize);
        throw new IndexOutOfBoundsException(sbJ.toString());
    }

    public int indexOf(T t6) {
        if (this.mOldData == null) {
            return findIndexOf(t6, this.mData, 0, this.mSize, 4);
        }
        int iFindIndexOf = findIndexOf(t6, this.mData, 0, this.mNewDataStart, 4);
        if (iFindIndexOf != -1) {
            return iFindIndexOf;
        }
        int iFindIndexOf2 = findIndexOf(t6, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (iFindIndexOf2 != -1) {
            return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i) {
        throwIfInMutationOperation();
        T t6 = get(i);
        removeItemAtIndex(i, false);
        int iAdd = add(t6, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    public boolean remove(T t6) {
        throwIfInMutationOperation();
        return remove(t6, true);
    }

    public T removeItemAt(int i) {
        throwIfInMutationOperation();
        T t6 = get(i);
        removeItemAtIndex(i, true);
        return t6;
    }

    public void replaceAll(T[] tArr, boolean z6) {
        throwIfInMutationOperation();
        if (z6) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i, T t6) {
        throwIfInMutationOperation();
        T t7 = get(i);
        boolean z6 = t7 == t6 || !this.mCallback.areContentsTheSame(t7, t6);
        if (t7 != t6 && this.mCallback.compare(t7, t6) == 0) {
            this.mData[i] = t6;
            if (z6) {
                Callback callback = this.mCallback;
                callback.onChanged(i, 1, callback.getChangePayload(t7, t6));
                return;
            }
            return;
        }
        if (z6) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i, 1, callback2.getChangePayload(t7, t6));
        }
        removeItemAtIndex(i, false);
        int iAdd = add(t6, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t6, boolean z6) {
        int iFindIndexOf = findIndexOf(t6, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            T t7 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(t7, t6)) {
                if (this.mCallback.areContentsTheSame(t7, t6)) {
                    this.mData[iFindIndexOf] = t6;
                    return iFindIndexOf;
                }
                this.mData[iFindIndexOf] = t6;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(t7, t6));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, t6);
        if (z6) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    private boolean remove(T t6, boolean z6) {
        int iFindIndexOf = findIndexOf(t6, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z6);
        return true;
    }

    public void replaceAll(T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
