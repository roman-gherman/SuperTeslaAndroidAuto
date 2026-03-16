package org.mockito.internal.matchers;

import B2.b;
import java.io.Serializable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class StartsWith implements ArgumentMatcher<String>, Serializable {
    private final String prefix;

    public StartsWith(String str) {
        this.prefix = str;
    }

    public String toString() {
        return b.h(new StringBuilder("startsWith(\""), this.prefix, "\")");
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(String str) {
        return str != null && str.startsWith(this.prefix);
    }
}
