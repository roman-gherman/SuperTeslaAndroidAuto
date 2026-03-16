package org.mockito.internal.junit;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.mockito.invocation.Invocation;
import org.mockito.plugins.MockitoLogger;

/* JADX INFO: loaded from: classes.dex */
class StubbingArgMismatches {
    final Map<Invocation, Set<Invocation>> mismatches = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$add$0(Invocation invocation) {
        return new LinkedHashSet();
    }

    public void add(Invocation invocation, Invocation invocation2) {
        this.mismatches.computeIfAbsent(invocation2, new b()).add(invocation);
    }

    public void format(String str, MockitoLogger mockitoLogger) {
        if (this.mismatches.isEmpty()) {
            return;
        }
        StubbingHint stubbingHint = new StubbingHint(str);
        int i = 1;
        for (Map.Entry<Invocation, Set<Invocation>> entry : this.mismatches.entrySet()) {
            int i3 = i + 1;
            stubbingHint.appendLine(Integer.valueOf(i), ". Unused... ", entry.getKey().getLocation());
            Iterator<Invocation> it = entry.getValue().iterator();
            while (it.hasNext()) {
                stubbingHint.appendLine(" ...args ok? ", it.next().getLocation());
            }
            i = i3;
        }
        mockitoLogger.log(stubbingHint.toString());
    }

    public int size() {
        return this.mismatches.size();
    }

    public String toString() {
        return "" + this.mismatches;
    }
}
