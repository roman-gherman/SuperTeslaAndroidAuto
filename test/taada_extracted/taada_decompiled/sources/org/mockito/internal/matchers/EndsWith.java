package org.mockito.internal.matchers;

import B2.b;
import java.io.Serializable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class EndsWith implements ArgumentMatcher<String>, Serializable {
    private final String suffix;

    public EndsWith(String str) {
        this.suffix = str;
    }

    public String toString() {
        return b.h(new StringBuilder("endsWith(\""), this.suffix, "\")");
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(String str) {
        return str != null && str.endsWith(this.suffix);
    }
}
