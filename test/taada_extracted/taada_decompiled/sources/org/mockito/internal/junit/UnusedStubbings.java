package org.mockito.internal.junit;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.plugins.MockitoLogger;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public class UnusedStubbings {
    private final Collection<? extends Stubbing> unused;

    public UnusedStubbings(Collection<? extends Stubbing> collection) {
        this.unused = collection;
    }

    public void format(String str, MockitoLogger mockitoLogger) {
        if (this.unused.isEmpty()) {
            return;
        }
        StubbingHint stubbingHint = new StubbingHint(str);
        int i = 1;
        for (Stubbing stubbing : this.unused) {
            if (!stubbing.wasUsed()) {
                stubbingHint.appendLine(Integer.valueOf(i), ". Unused ", stubbing.getInvocation().getLocation());
                i++;
            }
        }
        mockitoLogger.log(stubbingHint.toString());
    }

    public void reportUnused() {
        if (this.unused.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<? extends Stubbing> it = this.unused.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().getInvocation());
        }
        if (linkedList.isEmpty()) {
            return;
        }
        Reporter.unncessaryStubbingException(linkedList);
    }

    public int size() {
        return this.unused.size();
    }

    public String toString() {
        return this.unused.toString();
    }
}
