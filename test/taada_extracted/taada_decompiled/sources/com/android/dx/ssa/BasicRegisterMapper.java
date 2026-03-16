package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.util.IntList;

/* JADX INFO: loaded from: classes.dex */
public class BasicRegisterMapper extends RegisterMapper {
    private final IntList oldToNew;
    private int runningCountNewRegisters;

    public BasicRegisterMapper(int i) {
        this.oldToNew = new IntList(i);
    }

    public void addMapping(int i, int i3, int i4) {
        if (i >= this.oldToNew.size()) {
            for (int size = i - this.oldToNew.size(); size >= 0; size--) {
                this.oldToNew.add(-1);
            }
        }
        this.oldToNew.set(i, i3);
        int i5 = i3 + i4;
        if (this.runningCountNewRegisters < i5) {
            this.runningCountNewRegisters = i5;
        }
    }

    @Override // com.android.dx.ssa.RegisterMapper
    public int getNewRegisterCount() {
        return this.runningCountNewRegisters;
    }

    @Override // com.android.dx.ssa.RegisterMapper
    public RegisterSpec map(RegisterSpec registerSpec) {
        int i;
        if (registerSpec == null) {
            return null;
        }
        try {
            i = this.oldToNew.get(registerSpec.getReg());
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (i >= 0) {
            return registerSpec.withReg(i);
        }
        throw new RuntimeException("no mapping specified for register");
    }

    public int oldToNew(int i) {
        if (i >= this.oldToNew.size()) {
            return -1;
        }
        return this.oldToNew.get(i);
    }

    public String toHuman() {
        StringBuilder sb = new StringBuilder("Old\tNew\n");
        int size = this.oldToNew.size();
        for (int i = 0; i < size; i++) {
            sb.append(i);
            sb.append('\t');
            sb.append(this.oldToNew.get(i));
            sb.append('\n');
        }
        sb.append("new reg count:");
        sb.append(this.runningCountNewRegisters);
        sb.append('\n');
        return sb.toString();
    }
}
