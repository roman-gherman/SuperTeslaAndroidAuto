package com.android.dx.cf.code;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.util.LabeledItem;
import com.android.dx.util.LabeledList;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBlockList extends LabeledList {
    public ByteBlockList(int i) {
        super(i);
    }

    public ByteBlock get(int i) {
        return (ByteBlock) get0(i);
    }

    public ByteBlock labelToBlock(int i) {
        int iIndexOfLabel = indexOfLabel(i);
        if (iIndexOfLabel >= 0) {
            return get(iIndexOfLabel);
        }
        throw new IllegalArgumentException(a.z(i, new StringBuilder("no such label: ")));
    }

    public void set(int i, ByteBlock byteBlock) {
        super.set(i, (LabeledItem) byteBlock);
    }
}
