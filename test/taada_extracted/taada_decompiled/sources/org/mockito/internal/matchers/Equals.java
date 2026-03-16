package org.mockito.internal.matchers;

import B2.b;
import java.io.Serializable;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.text.ValuePrinter;

/* JADX INFO: loaded from: classes.dex */
public class Equals implements ArgumentMatcher<Object>, ContainsExtraTypeInfo, Serializable {
    private final Object wanted;

    public Equals(Object obj) {
        this.wanted = obj;
    }

    private String describe(Object obj) {
        return ValuePrinter.print(obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Equals)) {
            return false;
        }
        Equals equals = (Equals) obj;
        Object obj2 = this.wanted;
        if (obj2 == null && equals.wanted == null) {
            return true;
        }
        return obj2 != null && obj2.equals(equals.wanted);
    }

    @Override // org.mockito.internal.matchers.ContainsExtraTypeInfo
    public final Object getWanted() {
        return this.wanted;
    }

    public int hashCode() {
        return 1;
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        return Equality.areEqual(this.wanted, obj);
    }

    public String toString() {
        return describe(this.wanted);
    }

    @Override // org.mockito.internal.matchers.ContainsExtraTypeInfo
    public String toStringWithType(String str) {
        StringBuilder sbM = b.m("(", str, ") ");
        sbM.append(describe(this.wanted));
        return sbM.toString();
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<?> type() {
        Object obj = this.wanted;
        return obj != null ? obj.getClass() : super.type();
    }

    @Override // org.mockito.internal.matchers.ContainsExtraTypeInfo
    public boolean typeMatches(Object obj) {
        return (this.wanted == null || obj == null || obj.getClass() != this.wanted.getClass()) ? false : true;
    }
}
