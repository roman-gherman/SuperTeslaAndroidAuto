package org.bouncycastle.math.ec;

import c4.j;

/* JADX INFO: loaded from: classes2.dex */
public interface ECLookupTable {
    int getSize();

    j lookup(int i);

    j lookupVar(int i);
}
