package org.mockito.internal.verification.checkers;

import org.mockito.internal.reporting.Discrepancy;

/* JADX INFO: loaded from: classes.dex */
public class AtLeastDiscrepancy extends Discrepancy {
    public AtLeastDiscrepancy(int i, int i3) {
        super(i, i3);
    }

    @Override // org.mockito.internal.reporting.Discrepancy
    public String getPluralizedWantedCount() {
        return "*at least* " + super.getPluralizedWantedCount();
    }
}
