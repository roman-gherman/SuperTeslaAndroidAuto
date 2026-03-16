package org.mockito.internal.matchers;

import java.io.Serializable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class Or implements ArgumentMatcher<Object>, Serializable {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private final ArgumentMatcher f4455m1;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private final ArgumentMatcher f4456m2;

    public Or(ArgumentMatcher<?> argumentMatcher, ArgumentMatcher<?> argumentMatcher2) {
        this.f4455m1 = argumentMatcher;
        this.f4456m2 = argumentMatcher2;
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        return this.f4455m1.matches(obj) || this.f4456m2.matches(obj);
    }

    public String toString() {
        return "or(" + this.f4455m1 + ", " + this.f4456m2 + ")";
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<?> type() {
        return this.f4455m1.type().isAssignableFrom(this.f4456m2.type()) ? this.f4455m1.type() : this.f4456m2.type().isAssignableFrom(this.f4455m1.type()) ? this.f4456m2.type() : super.type();
    }
}
