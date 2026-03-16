package com.android.dx.rop.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public final class RegisterSpecList extends FixedSizeList implements TypeList {
    public static final RegisterSpecList EMPTY = new RegisterSpecList(0);

    public static class Expander {
        private int base;
        private final BitSet compatRegs;
        private boolean duplicateFirst;
        private final RegisterSpecList regSpecList;
        private final RegisterSpecList result;

        /* JADX INFO: Access modifiers changed from: private */
        public void expandRegister(int i) {
            expandRegister(i, (RegisterSpec) this.regSpecList.get0(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RegisterSpecList getResult() {
            if (this.regSpecList.isImmutable()) {
                this.result.setImmutable();
            }
            return this.result;
        }

        private Expander(RegisterSpecList registerSpecList, BitSet bitSet, int i, boolean z6) {
            this.regSpecList = registerSpecList;
            this.compatRegs = bitSet;
            this.base = i;
            this.result = new RegisterSpecList(registerSpecList.size());
            this.duplicateFirst = z6;
        }

        private void expandRegister(int i, RegisterSpec registerSpec) {
            BitSet bitSet = this.compatRegs;
            if (bitSet == null || !bitSet.get(i)) {
                registerSpec = registerSpec.withReg(this.base);
                if (!this.duplicateFirst) {
                    this.base = registerSpec.getCategory() + this.base;
                }
            }
            this.duplicateFirst = false;
            this.result.set0(i, registerSpec);
        }
    }

    public RegisterSpecList(int i) {
        super(i);
    }

    public static RegisterSpecList make(RegisterSpec registerSpec) {
        RegisterSpecList registerSpecList = new RegisterSpecList(1);
        registerSpecList.set(0, registerSpec);
        return registerSpecList;
    }

    public RegisterSpec get(int i) {
        return (RegisterSpec) get0(i);
    }

    public int getRegistersSize() {
        int nextReg;
        int size = size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i3);
            if (registerSpec != null && (nextReg = registerSpec.getNextReg()) > i) {
                i = nextReg;
            }
        }
        return i;
    }

    @Override // com.android.dx.rop.type.TypeList
    public Type getType(int i) {
        return get(i).getType().getType();
    }

    @Override // com.android.dx.rop.type.TypeList
    public int getWordCount() {
        int size = size();
        int category = 0;
        for (int i = 0; i < size; i++) {
            category += getType(i).getCategory();
        }
        return category;
    }

    public int indexOfRegister(int i) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (get(i3).getReg() == i) {
                return i3;
            }
        }
        return -1;
    }

    public void set(int i, RegisterSpec registerSpec) {
        set0(i, registerSpec);
    }

    public RegisterSpec specForRegister(int i) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            RegisterSpec registerSpec = get(i3);
            if (registerSpec.getReg() == i) {
                return registerSpec;
            }
        }
        return null;
    }

    public RegisterSpecList subset(BitSet bitSet) {
        int size = size() - bitSet.cardinality();
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        int i = 0;
        for (int i3 = 0; i3 < size(); i3++) {
            if (!bitSet.get(i3)) {
                registerSpecList.set0(i, get0(i3));
                i++;
            }
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    @Override // com.android.dx.rop.type.TypeList
    public TypeList withAddedType(Type type) {
        throw new UnsupportedOperationException("unsupported");
    }

    public RegisterSpecList withExpandedRegisters(int i, boolean z6, BitSet bitSet) {
        int size = size();
        if (size == 0) {
            return this;
        }
        Expander expander = new Expander(bitSet, i, z6);
        for (int i3 = 0; i3 < size; i3++) {
            expander.expandRegister(i3);
        }
        return expander.getResult();
    }

    public RegisterSpecList withFirst(RegisterSpec registerSpec) {
        int size = size();
        RegisterSpecList registerSpecList = new RegisterSpecList(size + 1);
        int i = 0;
        while (i < size) {
            int i3 = i + 1;
            registerSpecList.set0(i3, get0(i));
            i = i3;
        }
        registerSpecList.set0(0, registerSpec);
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withOffset(int i) {
        int size = size();
        if (size == 0) {
            return this;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        for (int i3 = 0; i3 < size; i3++) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i3);
            if (registerSpec != null) {
                registerSpecList.set0(i3, registerSpec.withOffset(i));
            }
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withoutFirst() {
        int size = size() - 1;
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        int i = 0;
        while (i < size) {
            int i3 = i + 1;
            registerSpecList.set0(i, get0(i3));
            i = i3;
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withoutLast() {
        int size = size() - 1;
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        for (int i = 0; i < size; i++) {
            registerSpecList.set0(i, get0(i));
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        RegisterSpecList registerSpecList = new RegisterSpecList(2);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3) {
        RegisterSpecList registerSpecList = new RegisterSpecList(3);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        registerSpecList.set(2, registerSpec3);
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3, RegisterSpec registerSpec4) {
        RegisterSpecList registerSpecList = new RegisterSpecList(4);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        registerSpecList.set(2, registerSpec3);
        registerSpecList.set(3, registerSpec4);
        return registerSpecList;
    }
}
