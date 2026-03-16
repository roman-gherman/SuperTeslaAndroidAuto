package org.mockito.internal.matchers;

import java.io.Serializable;
import java.util.Objects;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class EqualsWithDelta implements ArgumentMatcher<Number>, Serializable {
    private final Number delta;
    private final Number wanted;

    public EqualsWithDelta(Number number, Number number2) {
        this.wanted = number;
        this.delta = number2;
    }

    public String toString() {
        return "eq(" + this.wanted + ", " + this.delta + ")";
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Number number) {
        Number number2 = this.wanted;
        if ((number2 == null) ^ (number == null)) {
            return false;
        }
        if (Objects.equals(number2, number)) {
            return true;
        }
        if (this.wanted.doubleValue() - this.delta.doubleValue() <= number.doubleValue()) {
            if (number.doubleValue() <= this.delta.doubleValue() + this.wanted.doubleValue()) {
                return true;
            }
        }
        return false;
    }
}
