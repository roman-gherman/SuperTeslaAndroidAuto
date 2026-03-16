package com.google.common.base;

import a.AbstractC0132a;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC0132a {
    public static final i b = new i();

    @Override // a.AbstractC0132a
    public final int G(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException(kotlin.reflect.l.e(i, length, "index"));
        }
        return -1;
    }

    @Override // a.AbstractC0132a
    public final boolean T(char c) {
        return false;
    }

    public final String toString() {
        return "CharMatcher.none()";
    }
}
