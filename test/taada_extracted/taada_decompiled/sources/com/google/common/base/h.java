package com.google.common.base;

import a.AbstractC0132a;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC0132a {
    public final char b;

    public h(char c) {
        this.b = c;
    }

    @Override // a.AbstractC0132a
    public final boolean T(char c) {
        return c == this.b;
    }

    public final String toString() {
        return "CharMatcher.is('" + AbstractC0132a.a(this.b) + "')";
    }
}
