package org.mockito.internal.matchers;

/* JADX INFO: loaded from: classes.dex */
public interface ContainsExtraTypeInfo {
    Object getWanted();

    String toStringWithType(String str);

    boolean typeMatches(Object obj);
}
