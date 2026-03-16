package org.mockito.internal.invocation;

import java.util.Comparator;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class InvocationComparator implements Comparator<Invocation> {
    @Override // java.util.Comparator
    public int compare(Invocation invocation, Invocation invocation2) {
        return Integer.compare(invocation.getSequenceNumber(), invocation2.getSequenceNumber());
    }
}
