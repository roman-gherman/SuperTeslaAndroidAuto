package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.IntList;

/* JADX INFO: loaded from: classes.dex */
public final class ByteCatchList extends FixedSizeList {
    public static final ByteCatchList EMPTY = new ByteCatchList(0);

    public static class Item {
        private final int endPc;
        private final CstType exceptionClass;
        private final int handlerPc;
        private final int startPc;

        public Item(int i, int i3, int i4, CstType cstType) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i3 < i) {
                throw new IllegalArgumentException("endPc < startPc");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("handlerPc < 0");
            }
            this.startPc = i;
            this.endPc = i3;
            this.handlerPc = i4;
            this.exceptionClass = cstType;
        }

        public boolean covers(int i) {
            return i >= this.startPc && i < this.endPc;
        }

        public int getEndPc() {
            return this.endPc;
        }

        public CstType getExceptionClass() {
            CstType cstType = this.exceptionClass;
            return cstType != null ? cstType : CstType.OBJECT;
        }

        public int getHandlerPc() {
            return this.handlerPc;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    public ByteCatchList(int i) {
        super(i);
    }

    private static boolean typeNotFound(Item item, Item[] itemArr, int i) {
        CstType exceptionClass = item.getExceptionClass();
        for (int i3 = 0; i3 < i; i3++) {
            CstType exceptionClass2 = itemArr[i3].getExceptionClass();
            if (exceptionClass2 == exceptionClass || exceptionClass2 == CstType.OBJECT) {
                return false;
            }
        }
        return true;
    }

    public int byteLength() {
        return (size() * 8) + 2;
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public ByteCatchList listFor(int i) {
        int size = size();
        Item[] itemArr = new Item[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Item item = get(i4);
            if (item.covers(i) && typeNotFound(item, itemArr, i3)) {
                itemArr[i3] = item;
                i3++;
            }
        }
        if (i3 == 0) {
            return EMPTY;
        }
        ByteCatchList byteCatchList = new ByteCatchList(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            byteCatchList.set(i5, itemArr[i5]);
        }
        byteCatchList.setImmutable();
        return byteCatchList;
    }

    public void set(int i, Item item) {
        if (item == null) {
            throw new NullPointerException("item == null");
        }
        set0(i, item);
    }

    public TypeList toRopCatchList() {
        int size = size();
        if (size == 0) {
            return StdTypeList.EMPTY;
        }
        StdTypeList stdTypeList = new StdTypeList(size);
        for (int i = 0; i < size; i++) {
            stdTypeList.set(i, get(i).getExceptionClass().getClassType());
        }
        stdTypeList.setImmutable();
        return stdTypeList;
    }

    public IntList toTargetList(int i) {
        if (i < -1) {
            throw new IllegalArgumentException("noException < -1");
        }
        int i3 = i >= 0 ? 1 : 0;
        int size = size();
        if (size == 0) {
            return i3 != 0 ? IntList.makeImmutable(i) : IntList.EMPTY;
        }
        IntList intList = new IntList(size + i3);
        for (int i4 = 0; i4 < size; i4++) {
            intList.add(get(i4).getHandlerPc());
        }
        if (i3 != 0) {
            intList.add(i);
        }
        intList.setImmutable();
        return intList;
    }

    public void set(int i, int i3, int i4, int i5, CstType cstType) {
        set0(i, new Item(i3, i4, i5, cstType));
    }
}
