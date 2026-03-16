package org.mockito.internal.matchers;

import B2.b;
import java.io.Serializable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class Contains implements ArgumentMatcher<String>, Serializable {
    private final String substring;

    public Contains(String str) {
        this.substring = str;
    }

    public String toString() {
        return b.h(new StringBuilder("contains(\""), this.substring, "\")");
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(String str) {
        return str != null && str.contains(this.substring);
    }
}
