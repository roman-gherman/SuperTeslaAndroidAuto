package com.android.dx.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FixedSizeList extends MutabilityControl implements ToHuman {
    private Object[] arr;

    public FixedSizeList(int i) {
        super(i != 0);
        try {
            this.arr = new Object[i];
        } catch (NegativeArraySizeException unused) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    private Object throwIndex(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("n < 0");
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    private String toString0(String str, String str2, String str3, boolean z6) {
        int length = this.arr.length;
        StringBuilder sb = new StringBuilder((length * 10) + 10);
        if (str != null) {
            sb.append(str);
        }
        for (int i = 0; i < length; i++) {
            if (i != 0 && str2 != null) {
                sb.append(str2);
            }
            if (z6) {
                sb.append(((ToHuman) this.arr[i]).toHuman());
            } else {
                sb.append(this.arr[i]);
            }
        }
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.arr, ((FixedSizeList) obj).arr);
    }

    public final Object get0(int i) {
        try {
            Object obj = this.arr[i];
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("unset: " + i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return throwIndex(i);
        }
    }

    public final Object getOrNull0(int i) {
        return this.arr[i];
    }

    public int hashCode() {
        return Arrays.hashCode(this.arr);
    }

    public final void set0(int i, Object obj) {
        throwIfImmutable();
        try {
            this.arr[i] = obj;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throwIndex(i);
        }
    }

    public void shrinkToFit() {
        int length = this.arr.length;
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.arr[i3] != null) {
                i++;
            }
        }
        if (length == i) {
            return;
        }
        throwIfImmutable();
        Object[] objArr = new Object[i];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            Object obj = this.arr[i5];
            if (obj != null) {
                objArr[i4] = obj;
                i4++;
            }
        }
        this.arr = objArr;
        if (i == 0) {
            setImmutable();
        }
    }

    public final int size() {
        return this.arr.length;
    }

    public String toHuman() {
        String name = getClass().getName();
        return toString0(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", true);
    }

    public String toString() {
        String name = getClass().getName();
        return toString0(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", false);
    }

    public String toHuman(String str, String str2, String str3) {
        return toString0(str, str2, str3, true);
    }

    public String toString(String str, String str2, String str3) {
        return toString0(str, str2, str3, false);
    }
}
