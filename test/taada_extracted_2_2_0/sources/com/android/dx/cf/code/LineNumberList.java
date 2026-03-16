package com.android.dx.cf.code;

import com.android.dx.util.FixedSizeList;

/* JADX INFO: loaded from: classes.dex */
public final class LineNumberList extends FixedSizeList {
    public static final LineNumberList EMPTY = new LineNumberList(0);

    public static class Item {
        private final int lineNumber;
        private final int startPc;

        public Item(int i, int i3) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("lineNumber < 0");
            }
            this.startPc = i;
            this.lineNumber = i3;
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    public LineNumberList(int i) {
        super(i);
    }

    public static LineNumberList concat(LineNumberList lineNumberList, LineNumberList lineNumberList2) {
        if (lineNumberList == EMPTY) {
            return lineNumberList2;
        }
        int size = lineNumberList.size();
        int size2 = lineNumberList2.size();
        LineNumberList lineNumberList3 = new LineNumberList(size + size2);
        for (int i = 0; i < size; i++) {
            lineNumberList3.set(i, lineNumberList.get(i));
        }
        for (int i3 = 0; i3 < size2; i3++) {
            lineNumberList3.set(size + i3, lineNumberList2.get(i3));
        }
        return lineNumberList3;
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public int pcToLine(int i) {
        int size = size();
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Item item = get(i5);
            int startPc = item.getStartPc();
            if (startPc <= i && startPc > i3) {
                int lineNumber = item.getLineNumber();
                if (startPc == i) {
                    return lineNumber;
                }
                i4 = lineNumber;
                i3 = startPc;
            }
        }
        return i4;
    }

    public void set(int i, Item item) {
        if (item == null) {
            throw new NullPointerException("item == null");
        }
        set0(i, item);
    }

    public void set(int i, int i3, int i4) {
        set0(i, new Item(i3, i4));
    }
}
