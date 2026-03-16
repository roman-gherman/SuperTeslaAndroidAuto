package net.bytebuddy.matcher;

import com.google.protobuf.a;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class FailSafeMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final boolean fallback;
    private final ElementMatcher<? super T> matcher;

    public FailSafeMatcher(ElementMatcher<? super T> elementMatcher, boolean z6) {
        this.matcher = elementMatcher;
        this.fallback = z6;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FailSafeMatcher failSafeMatcher = (FailSafeMatcher) obj;
        return this.fallback == failSafeMatcher.fallback && this.matcher.equals(failSafeMatcher.matcher);
    }

    public int hashCode() {
        return a.j(this.matcher, getClass().hashCode() * 31, 31) + (this.fallback ? 1 : 0);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull T t6) {
        try {
            return this.matcher.matches(t6);
        } catch (Exception unused) {
            return this.fallback;
        }
    }

    public String toString() {
        return "failSafe(try(" + this.matcher + ") or " + this.fallback + ")";
    }
}
