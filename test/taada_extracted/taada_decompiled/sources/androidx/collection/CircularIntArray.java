package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i = this.mHead;
        int i3 = length - i;
        int i4 = length << 1;
        if (i4 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i4];
        System.arraycopy(iArr, i, iArr2, 0, i3);
        System.arraycopy(this.mElements, 0, iArr2, i3, this.mHead);
        this.mElements = iArr2;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i4 - 1;
    }

    public void addFirst(int i) {
        int i3 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i3;
        this.mElements[i3] = i;
        if (i3 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i) {
        int[] iArr = this.mElements;
        int i3 = this.mTail;
        iArr[i3] = i;
        int i4 = this.mCapacityBitmask & (i3 + 1);
        this.mTail = i4;
        if (i4 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i)];
    }

    public int getFirst() {
        int i = this.mHead;
        if (i != this.mTail) {
            return this.mElements[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i = this.mHead;
        int i3 = this.mTail;
        if (i != i3) {
            return this.mElements[(i3 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public int popFirst() {
        int i = this.mHead;
        if (i == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.mElements[i];
        this.mHead = (i + 1) & this.mCapacityBitmask;
        return i3;
    }

    public int popLast() {
        int i = this.mHead;
        int i3 = this.mTail;
        if (i == i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.mCapacityBitmask & (i3 - 1);
        int i5 = this.mElements[i4];
        this.mTail = i4;
        return i5;
    }

    public void removeFromEnd(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mTail = this.mCapacityBitmask & (this.mTail - i);
    }

    public void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mHead = this.mCapacityBitmask & (this.mHead + i);
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.mCapacityBitmask = i - 1;
        this.mElements = new int[i];
    }
}
