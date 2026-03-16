package com.android.dx.dex.code;

import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.FixedSizeList;

/* JADX INFO: loaded from: classes.dex */
public final class PositionList extends FixedSizeList {
    public static final PositionList EMPTY = new PositionList(0);
    public static final int IMPORTANT = 3;
    public static final int LINES = 2;
    public static final int NONE = 1;

    public static class Entry {
        private final int address;
        private final SourcePosition position;

        public Entry(int i, SourcePosition sourcePosition) {
            if (i < 0) {
                throw new IllegalArgumentException("address < 0");
            }
            if (sourcePosition == null) {
                throw new NullPointerException("position == null");
            }
            this.address = i;
            this.position = sourcePosition;
        }

        public int getAddress() {
            return this.address;
        }

        public SourcePosition getPosition() {
            return this.position;
        }
    }

    public PositionList(int i) {
        super(i);
    }

    public static PositionList make(DalvInsnList dalvInsnList, int i) {
        if (i == 1) {
            return EMPTY;
        }
        if (i != 2 && i != 3) {
            throw new IllegalArgumentException("bogus howMuch");
        }
        SourcePosition sourcePosition = SourcePosition.NO_INFO;
        int size = dalvInsnList.size();
        Entry[] entryArr = new Entry[size];
        SourcePosition sourcePosition2 = sourcePosition;
        int i3 = 0;
        boolean z6 = false;
        for (int i4 = 0; i4 < size; i4++) {
            DalvInsn dalvInsn = dalvInsnList.get(i4);
            if (dalvInsn instanceof CodeAddress) {
                z6 = true;
            } else {
                SourcePosition position = dalvInsn.getPosition();
                if (!position.equals(sourcePosition) && !position.sameLine(sourcePosition2) && (i != 3 || z6)) {
                    entryArr[i3] = new Entry(dalvInsn.getAddress(), position);
                    i3++;
                    z6 = false;
                    sourcePosition2 = position;
                }
            }
        }
        PositionList positionList = new PositionList(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            positionList.set(i5, entryArr[i5]);
        }
        positionList.setImmutable();
        return positionList;
    }

    public Entry get(int i) {
        return (Entry) get0(i);
    }

    public void set(int i, Entry entry) {
        set0(i, entry);
    }
}
