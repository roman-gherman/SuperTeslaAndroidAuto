package com.android.dx.cf.code;

import com.android.dx.util.IntList;
import com.android.dx.util.MutabilityControl;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchList extends MutabilityControl {
    private int size;
    private final IntList targets;
    private final IntList values;

    public SwitchList(int i) {
        super(true);
        this.values = new IntList(i);
        this.targets = new IntList(i + 1);
        this.size = i;
    }

    public void add(int i, int i3) {
        throwIfImmutable();
        if (i3 < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        this.values.add(i);
        this.targets.add(i3);
    }

    public int getDefaultTarget() {
        return this.targets.get(this.size);
    }

    public int getTarget(int i) {
        return this.targets.get(i);
    }

    public IntList getTargets() {
        return this.targets;
    }

    public int getValue(int i) {
        return this.values.get(i);
    }

    public IntList getValues() {
        return this.values;
    }

    public void removeSuperfluousDefaults() {
        throwIfImmutable();
        int i = this.size;
        if (i != this.targets.size() - 1) {
            throw new IllegalArgumentException("incomplete instance");
        }
        int i3 = this.targets.get(i);
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = this.targets.get(i5);
            if (i6 != i3) {
                if (i5 != i4) {
                    this.targets.set(i4, i6);
                    IntList intList = this.values;
                    intList.set(i4, intList.get(i5));
                }
                i4++;
            }
        }
        if (i4 != i) {
            this.values.shrink(i4);
            this.targets.set(i4, i3);
            this.targets.shrink(i4 + 1);
            this.size = i4;
        }
    }

    public void setDefaultTarget(int i) {
        throwIfImmutable();
        if (i < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        if (this.targets.size() != this.size) {
            throw new RuntimeException("non-default elements not all set");
        }
        this.targets.add(i);
    }

    @Override // com.android.dx.util.MutabilityControl
    public void setImmutable() {
        this.values.setImmutable();
        this.targets.setImmutable();
        super.setImmutable();
    }

    public int size() {
        return this.size;
    }
}
