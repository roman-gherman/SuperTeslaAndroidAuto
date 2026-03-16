package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Type;
import com.android.dx.util.FixedSizeList;

/* JADX INFO: loaded from: classes.dex */
public final class LocalVariableList extends FixedSizeList {
    public static final LocalVariableList EMPTY = new LocalVariableList(0);

    public static class Item {
        private final CstString descriptor;
        private final int index;
        private final int length;
        private final CstString name;
        private final CstString signature;
        private final int startPc;

        public Item(int i, int i3, CstString cstString, CstString cstString2, CstString cstString3, int i4) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("length < 0");
            }
            if (cstString == null) {
                throw new NullPointerException("name == null");
            }
            if (cstString2 == null && cstString3 == null) {
                throw new NullPointerException("(descriptor == null) && (signature == null)");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("index < 0");
            }
            this.startPc = i;
            this.length = i3;
            this.name = cstString;
            this.descriptor = cstString2;
            this.signature = cstString3;
            this.index = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CstString getSignature() {
            return this.signature;
        }

        public CstString getDescriptor() {
            return this.descriptor;
        }

        public int getIndex() {
            return this.index;
        }

        public int getLength() {
            return this.length;
        }

        public LocalItem getLocalItem() {
            return LocalItem.make(this.name, this.signature);
        }

        public int getStartPc() {
            return this.startPc;
        }

        public Type getType() {
            return Type.intern(this.descriptor.getString());
        }

        public boolean matchesAllButType(Item item) {
            return this.startPc == item.startPc && this.length == item.length && this.index == item.index && this.name.equals(item.name);
        }

        public boolean matchesPcAndIndex(int i, int i3) {
            int i4;
            return i3 == this.index && i >= (i4 = this.startPc) && i < i4 + this.length;
        }

        public Item withSignature(CstString cstString) {
            return new Item(this.startPc, this.length, this.name, this.descriptor, cstString, this.index);
        }
    }

    public LocalVariableList(int i) {
        super(i);
    }

    public static LocalVariableList concat(LocalVariableList localVariableList, LocalVariableList localVariableList2) {
        if (localVariableList == EMPTY) {
            return localVariableList2;
        }
        int size = localVariableList.size();
        int size2 = localVariableList2.size();
        LocalVariableList localVariableList3 = new LocalVariableList(size + size2);
        for (int i = 0; i < size; i++) {
            localVariableList3.set(i, localVariableList.get(i));
        }
        for (int i3 = 0; i3 < size2; i3++) {
            localVariableList3.set(size + i3, localVariableList2.get(i3));
        }
        localVariableList3.setImmutable();
        return localVariableList3;
    }

    public static LocalVariableList mergeDescriptorsAndSignatures(LocalVariableList localVariableList, LocalVariableList localVariableList2) {
        int size = localVariableList.size();
        LocalVariableList localVariableList3 = new LocalVariableList(size);
        for (int i = 0; i < size; i++) {
            Item itemWithSignature = localVariableList.get(i);
            Item itemItemToLocal = localVariableList2.itemToLocal(itemWithSignature);
            if (itemItemToLocal != null) {
                itemWithSignature = itemWithSignature.withSignature(itemItemToLocal.getSignature());
            }
            localVariableList3.set(i, itemWithSignature);
        }
        localVariableList3.setImmutable();
        return localVariableList3;
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public Item itemToLocal(Item item) {
        int size = size();
        for (int i = 0; i < size; i++) {
            Item item2 = (Item) get0(i);
            if (item2 != null && item2.matchesAllButType(item)) {
                return item2;
            }
        }
        return null;
    }

    public Item pcAndIndexToLocal(int i, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            Item item = (Item) get0(i4);
            if (item != null && item.matchesPcAndIndex(i, i3)) {
                return item;
            }
        }
        return null;
    }

    public void set(int i, Item item) {
        if (item == null) {
            throw new NullPointerException("item == null");
        }
        set0(i, item);
    }

    public void set(int i, int i3, int i4, CstString cstString, CstString cstString2, CstString cstString3, int i5) {
        set0(i, new Item(i3, i4, cstString, cstString2, cstString3, i5));
    }
}
