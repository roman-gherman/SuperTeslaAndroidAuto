package org.mockito.internal.util.collections;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class IdentitySet {
    private final LinkedList list = new LinkedList();

    public void add(Object obj) {
        this.list.add(obj);
    }

    public boolean contains(Object obj) {
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            if (it.next() == obj) {
                return true;
            }
        }
        return false;
    }
}
