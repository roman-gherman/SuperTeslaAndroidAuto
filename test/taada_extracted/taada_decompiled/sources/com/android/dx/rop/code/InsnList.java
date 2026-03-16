package com.android.dx.rop.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.util.FixedSizeList;

/* JADX INFO: loaded from: classes.dex */
public final class InsnList extends FixedSizeList {
    public InsnList(int i) {
        super(i);
    }

    public boolean contentEquals(InsnList insnList) {
        int size;
        if (insnList == null || (size = size()) != insnList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).contentEquals(insnList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void forEach(Insn.Visitor visitor) {
        int size = size();
        for (int i = 0; i < size; i++) {
            get(i).accept(visitor);
        }
    }

    public Insn get(int i) {
        return (Insn) get0(i);
    }

    public Insn getLast() {
        return get(size() - 1);
    }

    public void set(int i, Insn insn) {
        set0(i, insn);
    }

    public InsnList withRegisterOffset(int i) {
        int size = size();
        InsnList insnList = new InsnList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Insn insn = (Insn) get0(i3);
            if (insn != null) {
                insnList.set0(i3, insn.withRegisterOffset(i));
            }
        }
        if (isImmutable()) {
            insnList.setImmutable();
        }
        return insnList;
    }
}
