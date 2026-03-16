package com.android.dx.cf.code;

import B2.b;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledItem;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBlock implements LabeledItem {
    private final ByteCatchList catches;
    private final int end;
    private final int label;
    private final int start;
    private final IntList successors;

    public ByteBlock(int i, int i3, int i4, IntList intList, ByteCatchList byteCatchList) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i4 <= i3) {
            throw new IllegalArgumentException("end <= start");
        }
        if (intList == null) {
            throw new NullPointerException("targets == null");
        }
        int size = intList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (intList.get(i5) < 0) {
                StringBuilder sbJ = b.j(i5, "successors[", "] == ");
                sbJ.append(intList.get(i5));
                throw new IllegalArgumentException(sbJ.toString());
            }
        }
        if (byteCatchList == null) {
            throw new NullPointerException("catches == null");
        }
        this.label = i;
        this.start = i3;
        this.end = i4;
        this.successors = intList;
        this.catches = byteCatchList;
    }

    public ByteCatchList getCatches() {
        return this.catches;
    }

    public int getEnd() {
        return this.end;
    }

    @Override // com.android.dx.util.LabeledItem
    public int getLabel() {
        return this.label;
    }

    public int getStart() {
        return this.start;
    }

    public IntList getSuccessors() {
        return this.successors;
    }

    public String toString() {
        return "{" + Hex.u2(this.label) + ": " + Hex.u2(this.start) + ".." + Hex.u2(this.end) + '}';
    }
}
