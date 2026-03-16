package net.bytebuddy.matcher;

import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance(permitSubclassEquality = true)
public class CachingMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final Object NULL_VALUE = new Object();

    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    protected final ConcurrentMap<? super T, Boolean> map;
    private final ElementMatcher<? super T> matcher;

    @SuppressFBWarnings(justification = "Equality does not consider eviction size.", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
    public static class WithInlineEviction<S> extends CachingMatcher<S> {
        private final int evictionSize;

        public WithInlineEviction(ElementMatcher<? super S> elementMatcher, ConcurrentMap<? super S, Boolean> concurrentMap, int i) {
            super(elementMatcher, concurrentMap);
            this.evictionSize = i;
        }

        @Override // net.bytebuddy.matcher.CachingMatcher
        public boolean onCacheMiss(@MaybeNull S s3) {
            if (this.map.size() >= this.evictionSize) {
                Iterator<Map.Entry<? super T, Boolean>> it = this.map.entrySet().iterator();
                it.next();
                it.remove();
            }
            return super.onCacheMiss(s3);
        }
    }

    public CachingMatcher(ElementMatcher<? super T> elementMatcher, ConcurrentMap<? super T, Boolean> concurrentMap) {
        this.matcher = elementMatcher;
        this.map = concurrentMap;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CachingMatcher) && this.matcher.equals(((CachingMatcher) obj).matcher);
    }

    public int hashCode() {
        return this.matcher.hashCode() + (CachingMatcher.class.hashCode() * 31);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull T t6) {
        Boolean boolValueOf = this.map.get(t6 == null ? NULL_VALUE : t6);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(onCacheMiss(t6));
        }
        return boolValueOf.booleanValue();
    }

    public boolean onCacheMiss(@MaybeNull T t6) {
        boolean zMatches = this.matcher.matches(t6);
        ConcurrentMap<? super T, Boolean> concurrentMap = this.map;
        if (t6 == null) {
            t6 = (Object) NULL_VALUE;
        }
        concurrentMap.put(t6, Boolean.valueOf(zMatches));
        return zMatches;
    }

    public String toString() {
        return a.n(new StringBuilder("cached("), this.matcher, ")");
    }
}
