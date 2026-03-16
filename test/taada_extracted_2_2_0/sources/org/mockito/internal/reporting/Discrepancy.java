package org.mockito.internal.reporting;

/* JADX INFO: loaded from: classes.dex */
public class Discrepancy {
    private final int actualCount;
    private final int wantedCount;

    public Discrepancy(int i, int i3) {
        this.wantedCount = i;
        this.actualCount = i3;
    }

    public int getActualCount() {
        return this.actualCount;
    }

    public String getPluralizedActualCount() {
        return Pluralizer.pluralize(this.actualCount);
    }

    public String getPluralizedWantedCount() {
        return Pluralizer.pluralize(this.wantedCount);
    }

    public int getWantedCount() {
        return this.wantedCount;
    }
}
