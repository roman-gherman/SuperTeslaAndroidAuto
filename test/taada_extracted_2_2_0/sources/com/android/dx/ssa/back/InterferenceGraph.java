package com.android.dx.ssa.back;

import B2.b;
import com.android.dx.ssa.SetFactory;
import com.android.dx.util.IntSet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InterferenceGraph {
    private final ArrayList<IntSet> interference;

    public InterferenceGraph(int i) {
        this.interference = new ArrayList<>(i);
        for (int i3 = 0; i3 < i; i3++) {
            this.interference.add(SetFactory.makeInterferenceSet(i));
        }
    }

    private void ensureCapacity(int i) {
        this.interference.ensureCapacity(i);
        for (int size = this.interference.size(); size < i; size++) {
            this.interference.add(SetFactory.makeInterferenceSet(i));
        }
    }

    public void add(int i, int i3) {
        ensureCapacity(Math.max(i, i3) + 1);
        this.interference.get(i).add(i3);
        this.interference.get(i3).add(i);
    }

    public void dumpToStdout() {
        int size = this.interference.size();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbJ = b.j(i, "Reg ", ":");
            sbJ.append(this.interference.get(i).toString());
            sb.append(sbJ.toString());
            System.out.println(sb.toString());
        }
    }

    public void mergeInterferenceSet(int i, IntSet intSet) {
        if (i < this.interference.size()) {
            intSet.merge(this.interference.get(i));
        }
    }
}
