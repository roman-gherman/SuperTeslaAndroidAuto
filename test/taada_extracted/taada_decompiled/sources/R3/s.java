package r3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;
import t3.C0828a;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    @NotNull
    private volatile AtomicReferenceArray<Object> array;

    public s(int i) {
        this.array = new AtomicReferenceArray<>(i);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int i) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i);
        }
        return null;
    }

    public final void c(int i, C0828a c0828a) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i < length) {
            atomicReferenceArray.set(i, c0828a);
            return;
        }
        int i3 = i + 1;
        int i4 = length * 2;
        if (i3 < i4) {
            i3 = i4;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i3);
        for (int i5 = 0; i5 < length; i5++) {
            atomicReferenceArray2.set(i5, atomicReferenceArray.get(i5));
        }
        atomicReferenceArray2.set(i, c0828a);
        this.array = atomicReferenceArray2;
    }
}
