package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i) {
        if (i == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i << 1];
    }

    private static int binarySearchHashes(int[] iArr, int i, int i3) {
        try {
            return ContainerHelpers.binarySearch(iArr, i, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i4 = (i << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    public void clear() {
        int i = this.mSize;
        if (i > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        int i3 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i) {
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                System.arraycopy(objArr, 0, this.mArray, 0, i3 << 1);
            }
            freeArrays(iArr, objArr, i3);
        }
        if (this.mSize != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i = 0; i < this.mSize; i++) {
                try {
                    K kKeyAt = keyAt(i);
                    V vValueAt = valueAt(i);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    K kKeyAt2 = keyAt(i3);
                    V vValueAt2 = valueAt(i3);
                    Object obj3 = map.get(kKeyAt2);
                    if (vValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(kKeyAt2)) {
                            return false;
                        }
                    } else if (!vValueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v6) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.mArray[(iIndexOfKey << 1) + 1] : v6;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    public int indexOf(Object obj, int i) {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, i3, i);
        if (iBinarySearchHashes < 0 || obj.equals(this.mArray[iBinarySearchHashes << 1])) {
            return iBinarySearchHashes;
        }
        int i4 = iBinarySearchHashes + 1;
        while (i4 < i3 && this.mHashes[i4] == i) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iBinarySearchHashes - 1; i5 >= 0 && this.mHashes[i5] == i; i5--) {
            if (obj.equals(this.mArray[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, i, 0);
        if (iBinarySearchHashes < 0 || this.mArray[iBinarySearchHashes << 1] == null) {
            return iBinarySearchHashes;
        }
        int i3 = iBinarySearchHashes + 1;
        while (i3 < i && this.mHashes[i3] == 0) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearchHashes - 1; i4 >= 0 && this.mHashes[i4] == 0; i4--) {
            if (this.mArray[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public int indexOfValue(Object obj) {
        int i = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i) {
        return (K) this.mArray[i << 1];
    }

    public V put(K k6, V v6) {
        int i;
        int iIndexOf;
        int i3 = this.mSize;
        if (k6 == null) {
            iIndexOf = indexOfNull();
            i = 0;
        } else {
            int iHashCode = k6.hashCode();
            i = iHashCode;
            iIndexOf = indexOf(k6, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i4 = (iIndexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v7 = (V) objArr[i4];
            objArr[i4] = v6;
            return v7;
        }
        int i5 = ~iIndexOf;
        int[] iArr = this.mHashes;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i6);
            if (i3 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            freeArrays(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.mHashes;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.mSize - i5) << 1);
        }
        int i8 = this.mSize;
        if (i3 == i8) {
            int[] iArr4 = this.mHashes;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr4 = this.mArray;
                int i9 = i5 << 1;
                objArr4[i9] = k6;
                objArr4[i9 + 1] = v6;
                this.mSize = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i);
        if (this.mSize != 0) {
            for (int i3 = 0; i3 < i; i3++) {
                put(simpleArrayMap.keyAt(i3), simpleArrayMap.valueAt(i3));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
            this.mSize = i;
        }
    }

    public V putIfAbsent(K k6, V v6) {
        V v7 = get(k6);
        return v7 == null ? put(k6, v6) : v7;
    }

    public V remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        Object[] objArr = this.mArray;
        int i3 = i << 1;
        V v6 = (V) objArr[i3 + 1];
        int i4 = this.mSize;
        int i5 = 0;
        if (i4 <= 1) {
            freeArrays(this.mHashes, objArr, i4);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i6) {
                    int i7 = i + 1;
                    int i8 = i6 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                allocArrays(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr, 0, this.mArray, 0, i3);
                }
                if (i < i6) {
                    int i10 = i + 1;
                    int i11 = i6 - i;
                    System.arraycopy(iArr, i10, this.mHashes, i, i11);
                    System.arraycopy(objArr, i10 << 1, this.mArray, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i5;
        return v6;
    }

    public V replace(K k6, V v6) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v6);
        }
        return null;
    }

    public V setValueAt(int i, V v6) {
        int i3 = (i << 1) + 1;
        Object[] objArr = this.mArray;
        V v7 = (V) objArr[i3];
        objArr[i3] = v6;
        return v7;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i);
            if (kKeyAt != this) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(SignatureVisitor.INSTANCEOF);
            V vValueAt = valueAt(i);
            if (vValueAt != this) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i) {
        return (V) this.mArray[(i << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (obj2 != vValueAt && (obj2 == null || !obj2.equals(vValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K k6, V v6, V v7) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (vValueAt != v6 && (v6 == null || !v6.equals(vValueAt))) {
            return false;
        }
        setValueAt(iIndexOfKey, v7);
        return true;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }
}
