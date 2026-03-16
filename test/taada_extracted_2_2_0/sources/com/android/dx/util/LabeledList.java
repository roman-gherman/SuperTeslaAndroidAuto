package com.android.dx.util;

import B2.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class LabeledList extends FixedSizeList {
    private final IntList labelToIndex;

    public LabeledList(int i) {
        super(i);
        this.labelToIndex = new IntList(i);
    }

    private void addLabelIndex(int i, int i3) {
        int size = this.labelToIndex.size();
        for (int i4 = 0; i4 <= i - size; i4++) {
            this.labelToIndex.add(-1);
        }
        this.labelToIndex.set(i, i3);
    }

    private void rebuildLabelToIndex() {
        int size = size();
        for (int i = 0; i < size; i++) {
            LabeledItem labeledItem = (LabeledItem) get0(i);
            if (labeledItem != null) {
                this.labelToIndex.set(labeledItem.getLabel(), i);
            }
        }
    }

    private void removeLabel(int i) {
        this.labelToIndex.set(i, -1);
    }

    public final int[] getLabelsInOrder() {
        int size = size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            LabeledItem labeledItem = (LabeledItem) get0(i);
            if (labeledItem == null) {
                throw new NullPointerException(b.c(i, "null at index "));
            }
            iArr[i] = labeledItem.getLabel();
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public final int getMaxLabel() {
        int size = this.labelToIndex.size() - 1;
        while (size >= 0 && this.labelToIndex.get(size) < 0) {
            size--;
        }
        int i = size + 1;
        this.labelToIndex.shrink(i);
        return i;
    }

    public final int indexOfLabel(int i) {
        if (i >= this.labelToIndex.size()) {
            return -1;
        }
        return this.labelToIndex.get(i);
    }

    public void set(int i, LabeledItem labeledItem) {
        LabeledItem labeledItem2 = (LabeledItem) getOrNull0(i);
        set0(i, labeledItem);
        if (labeledItem2 != null) {
            removeLabel(labeledItem2.getLabel());
        }
        if (labeledItem != null) {
            addLabelIndex(labeledItem.getLabel(), i);
        }
    }

    @Override // com.android.dx.util.FixedSizeList
    public void shrinkToFit() {
        super.shrinkToFit();
        rebuildLabelToIndex();
    }

    public LabeledList(LabeledList labeledList) {
        super(labeledList.size());
        this.labelToIndex = labeledList.labelToIndex.mutableCopy();
        int size = labeledList.size();
        for (int i = 0; i < size; i++) {
            Object obj = labeledList.get0(i);
            if (obj != null) {
                set0(i, obj);
            }
        }
    }
}
