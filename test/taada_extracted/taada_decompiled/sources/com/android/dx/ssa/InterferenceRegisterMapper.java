package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.ssa.back.InterferenceGraph;
import com.android.dx.util.BitIntSet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InterferenceRegisterMapper extends BasicRegisterMapper {
    private final ArrayList<BitIntSet> newRegInterference;
    private final InterferenceGraph oldRegInterference;

    public InterferenceRegisterMapper(InterferenceGraph interferenceGraph, int i) {
        super(i);
        this.newRegInterference = new ArrayList<>();
        this.oldRegInterference = interferenceGraph;
    }

    private void addInterfence(int i, int i3) {
        int i4 = i + 1;
        this.newRegInterference.ensureCapacity(i4);
        while (i >= this.newRegInterference.size()) {
            this.newRegInterference.add(new BitIntSet(i4));
        }
        this.oldRegInterference.mergeInterferenceSet(i3, this.newRegInterference.get(i));
    }

    @Override // com.android.dx.ssa.BasicRegisterMapper
    public void addMapping(int i, int i3, int i4) {
        super.addMapping(i, i3, i4);
        addInterfence(i3, i);
        if (i4 == 2) {
            addInterfence(i3 + 1, i);
        }
    }

    public boolean areAnyPinned(RegisterSpecList registerSpecList, int i, int i3) {
        int size = registerSpecList.size();
        for (int i4 = 0; i4 < size; i4++) {
            RegisterSpec registerSpec = registerSpecList.get(i4);
            int iOldToNew = oldToNew(registerSpec.getReg());
            if (iOldToNew == i) {
                return true;
            }
            if (registerSpec.getCategory() == 2 && iOldToNew + 1 == i) {
                return true;
            }
            if (i3 == 2 && iOldToNew == i + 1) {
                return true;
            }
        }
        return false;
    }

    public boolean interferes(int i, int i3, int i4) {
        BitIntSet bitIntSet;
        if (i3 < this.newRegInterference.size() && (bitIntSet = this.newRegInterference.get(i3)) != null) {
            return i4 == 1 ? bitIntSet.has(i) : bitIntSet.has(i) || interferes(i, i3 + 1, i4 - 1);
        }
        return false;
    }

    public boolean interferes(RegisterSpec registerSpec, int i) {
        return interferes(registerSpec.getReg(), i, registerSpec.getCategory());
    }
}
