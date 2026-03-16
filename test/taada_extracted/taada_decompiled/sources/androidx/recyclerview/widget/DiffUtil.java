package androidx.recyclerview.widget;

import B2.b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i = snake.x - snake2.x;
            return i == 0 ? snake.y - snake2.y : i;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i3);

        public abstract boolean areItemsTheSame(int i, int i3);

        public Object getChangePayload(int i, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        public DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z6) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z6;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.x == 0 && snake.y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.x = 0;
            snake2.y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mNewItemStatuses[i6];
                int i8 = i7 & 31;
                if (i8 == 0) {
                    listUpdateCallback.onInserted(i, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                } else if (i8 == 4 || i8 == 8) {
                    int i9 = i7 >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i9, true).currentPos, i);
                    if (i8 == 4) {
                        listUpdateCallback.onChanged(i, 1, this.mCallback.getChangePayload(i9, i6));
                    }
                } else {
                    if (i8 != 16) {
                        StringBuilder sbJ = b.j(i6, "unknown flag for pos ", " ");
                        sbJ.append(Long.toBinaryString(i8));
                        throw new IllegalStateException(sbJ.toString());
                    }
                    list.add(new PostponedUpdate(i6, i, false));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mOldItemStatuses[i6];
                int i8 = i7 & 31;
                if (i8 == 0) {
                    listUpdateCallback.onRemoved(i + i5, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                } else if (i8 == 4 || i8 == 8) {
                    int i9 = i7 >> 5;
                    PostponedUpdate postponedUpdateRemovePostponedUpdate = removePostponedUpdate(list, i9, false);
                    listUpdateCallback.onMoved(i + i5, postponedUpdateRemovePostponedUpdate.currentPos - 1);
                    if (i8 == 4) {
                        listUpdateCallback.onChanged(postponedUpdateRemovePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i6, i9));
                    }
                } else {
                    if (i8 != 16) {
                        StringBuilder sbJ = b.j(i6, "unknown flag for pos ", " ");
                        sbJ.append(Long.toBinaryString(i8));
                        throw new IllegalStateException(sbJ.toString());
                    }
                    list.add(new PostponedUpdate(i6, i + i5, true));
                }
            }
        }

        private void findAddition(int i, int i3, int i4) {
            if (this.mOldItemStatuses[i - 1] != 0) {
                return;
            }
            findMatchingItem(i, i3, i4, false);
        }

        private boolean findMatchingItem(int i, int i3, int i4, boolean z6) {
            int i5;
            int i6;
            int i7;
            if (z6) {
                i3--;
                i6 = i;
                i5 = i3;
            } else {
                i5 = i - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                Snake snake = this.mSnakes.get(i4);
                int i8 = snake.x;
                int i9 = snake.size;
                int i10 = i8 + i9;
                int i11 = snake.y + i9;
                if (z6) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.mCallback.areItemsTheSame(i12, i5)) {
                            i7 = this.mCallback.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.mNewItemStatuses[i5] = (i12 << 5) | 16;
                            this.mOldItemStatuses[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.mCallback.areItemsTheSame(i5, i13)) {
                            i7 = this.mCallback.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i - 1;
                            this.mOldItemStatuses[i14] = (i13 << 5) | 16;
                            this.mNewItemStatuses[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i6 = snake.x;
                i3 = snake.y;
                i4--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.x;
                int i5 = snake.size;
                int i6 = i4 + i5;
                int i7 = snake.y + i5;
                if (this.mDetectMoves) {
                    while (i > i6) {
                        findAddition(i, i3, size);
                        i--;
                    }
                    while (i3 > i7) {
                        findRemoval(i, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < snake.size; i8++) {
                    int i9 = snake.x + i8;
                    int i10 = snake.y + i8;
                    int i11 = this.mCallback.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.mOldItemStatuses[i9] = (i10 << 5) | i11;
                    this.mNewItemStatuses[i10] = (i9 << 5) | i11;
                }
                i = snake.x;
                i3 = snake.y;
            }
        }

        private void findRemoval(int i, int i3, int i4) {
            if (this.mNewItemStatuses[i3 - 1] != 0) {
                return;
            }
            findMatchingItem(i, i3, i4, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z6) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z6) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z6 ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(int i) {
            if (i < 0 || i >= this.mNewListSize) {
                StringBuilder sbJ = b.j(i, "Index out of bounds - passed position = ", ", new list size = ");
                sbJ.append(this.mNewListSize);
                throw new IndexOutOfBoundsException(sbJ.toString());
            }
            int i3 = this.mNewItemStatuses[i];
            if ((i3 & 31) == 0) {
                return -1;
            }
            return i3 >> 5;
        }

        public int convertOldPositionToNew(int i) {
            if (i < 0 || i >= this.mOldListSize) {
                StringBuilder sbJ = b.j(i, "Index out of bounds - passed position = ", ", old list size = ");
                sbJ.append(this.mOldListSize);
                throw new IndexOutOfBoundsException(sbJ.toString());
            }
            int i3 = this.mOldItemStatuses[i];
            if ((i3 & 31) == 0) {
                return -1;
            }
            return i3 >> 5;
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            DiffResult diffResult;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.size;
                int i5 = snake.x + i4;
                int i6 = snake.y + i4;
                if (i5 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i5, i - i5, i5);
                }
                if (i6 < i3) {
                    diffResult = this;
                    diffResult.dispatchAdditions(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                } else {
                    diffResult = this;
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = diffResult.mOldItemStatuses;
                    int i8 = snake.x;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i8 + i7, 1, diffResult.mCallback.getChangePayload(i8 + i7, snake.y + i7));
                    }
                }
                i = snake.x;
                i3 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t6, T t7);

        public abstract boolean areItemsTheSame(T t6, T t7);

        public Object getChangePayload(T t6, T t7) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i3, boolean z6) {
            this.posInOwnerList = i;
            this.currentPos = i3;
            this.removal = z6;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i, int i3, int i4, int i5) {
            this.oldListStart = i;
            this.oldListEnd = i3;
            this.newListStart = i4;
            this.newListEnd = i5;
        }
    }

    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;
    }

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake diffPartial(androidx.recyclerview.widget.DiffUtil.Callback r17, int r18, int r19, int r20, int r21, int[] r22, int[] r23, int r24) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.diffPartial(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    public static DiffResult calculateDiff(Callback callback, boolean z6) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int iAbs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i = iAbs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            int[] iArr3 = iArr2;
            int[] iArr4 = iArr;
            Callback callback2 = callback;
            Snake snakeDiffPartial = diffPartial(callback2, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr4, iArr3, iAbs);
            iArr = iArr4;
            if (snakeDiffPartial != null) {
                if (snakeDiffPartial.size > 0) {
                    arrayList.add(snakeDiffPartial);
                }
                snakeDiffPartial.x += range.oldListStart;
                snakeDiffPartial.y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (snakeDiffPartial.reverse) {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y;
                } else if (snakeDiffPartial.removal) {
                    range2.oldListEnd = snakeDiffPartial.x - 1;
                    range2.newListEnd = snakeDiffPartial.y;
                } else {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y - 1;
                }
                arrayList2.add(range2);
                if (!snakeDiffPartial.reverse) {
                    int i3 = snakeDiffPartial.x;
                    int i4 = snakeDiffPartial.size;
                    range.oldListStart = i3 + i4;
                    range.newListStart = snakeDiffPartial.y + i4;
                } else if (snakeDiffPartial.removal) {
                    int i5 = snakeDiffPartial.x;
                    int i6 = snakeDiffPartial.size;
                    range.oldListStart = i5 + i6 + 1;
                    range.newListStart = snakeDiffPartial.y + i6;
                } else {
                    int i7 = snakeDiffPartial.x;
                    int i8 = snakeDiffPartial.size;
                    range.oldListStart = i7 + i8;
                    range.newListStart = snakeDiffPartial.y + i8 + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
            callback = callback2;
            iArr2 = iArr3;
        }
        Callback callback3 = callback;
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback3, arrayList, iArr, iArr2, z6);
    }
}
