package kotlin.collections;

import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AbstractC0598e implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f3802a;

    public k(int[] iArr) {
        this.f3802a = iArr;
    }

    @Override // kotlin.collections.AbstractC0594a
    public final int a() {
        return this.f3802a.length;
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Number) obj).intValue();
            int[] iArr = this.f3802a;
            kotlin.jvm.internal.h.f(iArr, "<this>");
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                if (iIntValue == iArr[i]) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return Integer.valueOf(this.f3802a[i]);
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.f3802a;
        kotlin.jvm.internal.h.f(iArr, "<this>");
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (iIntValue == iArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection
    public final boolean isEmpty() {
        return this.f3802a.length == 0;
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.f3802a;
        kotlin.jvm.internal.h.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (iIntValue == iArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }
}
