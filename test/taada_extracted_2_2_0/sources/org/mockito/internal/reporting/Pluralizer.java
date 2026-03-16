package org.mockito.internal.reporting;

import B2.b;

/* JADX INFO: loaded from: classes.dex */
public final class Pluralizer {
    private Pluralizer() {
    }

    public static String pluralize(int i) {
        if (i == 1) {
            return "1 time";
        }
        return i + " times";
    }

    public static String were_exactly_x_interactions(int i) {
        return i == 1 ? "was exactly 1 interaction" : b.d(i, "were exactly ", " interactions");
    }
}
