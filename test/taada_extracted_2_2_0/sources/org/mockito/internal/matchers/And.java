package org.mockito.internal.matchers;

import java.io.Serializable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class And implements ArgumentMatcher<Object>, Serializable {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private final ArgumentMatcher f4454m1;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private final ArgumentMatcher f4455m2;

    public And(ArgumentMatcher<?> argumentMatcher, ArgumentMatcher<?> argumentMatcher2) {
        this.f4454m1 = argumentMatcher;
        this.f4455m2 = argumentMatcher2;
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        return this.f4454m1.matches(obj) && this.f4455m2.matches(obj);
    }

    public String toString() {
        return "and(" + this.f4454m1 + ", " + this.f4455m2 + ")";
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<?> type() {
        return this.f4454m1.type().isAssignableFrom(this.f4455m2.type()) ? this.f4454m1.type() : this.f4455m2.type().isAssignableFrom(this.f4454m1.type()) ? this.f4455m2.type() : super.type();
    }
}
