package net.bytebuddy.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ElementMatcher<T> {

    public interface Junction<S> extends ElementMatcher<S> {

        public static abstract class AbstractBase<V> implements Junction<V> {
            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            public <U extends V> Junction<U> and(ElementMatcher<? super U> elementMatcher) {
                return new Conjunction(this, elementMatcher);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            public <U extends V> Junction<U> or(ElementMatcher<? super U> elementMatcher) {
                return new Disjunction(this, elementMatcher);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public Conjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return this.matchers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@UnknownNull W w5) {
                Iterator<ElementMatcher<? super W>> it = this.matchers.iterator();
                while (it.hasNext()) {
                    if (!it.next().matches(w5)) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("(");
                boolean z6 = true;
                for (ElementMatcher<? super W> elementMatcher : this.matchers) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(" and ");
                    }
                    sb.append(elementMatcher);
                }
                sb.append(")");
                return sb.toString();
            }

            public Conjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher<? super W> elementMatcher : list) {
                    if (elementMatcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) elementMatcher).matchers);
                    } else {
                        this.matchers.add(elementMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public Disjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return this.matchers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@UnknownNull W w5) {
                Iterator<ElementMatcher<? super W>> it = this.matchers.iterator();
                while (it.hasNext()) {
                    if (it.next().matches(w5)) {
                        return true;
                    }
                }
                return false;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("(");
                boolean z6 = true;
                for (ElementMatcher<? super W> elementMatcher : this.matchers) {
                    if (z6) {
                        z6 = false;
                    } else {
                        sb.append(" or ");
                    }
                    sb.append(elementMatcher);
                }
                sb.append(")");
                return sb.toString();
            }

            public Disjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher<? super W> elementMatcher : list) {
                    if (elementMatcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) elementMatcher).matchers);
                    } else {
                        this.matchers.add(elementMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForNonNullValues<W> extends AbstractBase<W> {
            public abstract boolean doMatch(W w5);

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return getClass().hashCode();
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@MaybeNull W w5) {
                return w5 != null && doMatch(w5);
            }
        }

        <U extends S> Junction<U> and(ElementMatcher<? super U> elementMatcher);

        <U extends S> Junction<U> or(ElementMatcher<? super U> elementMatcher);
    }

    boolean matches(@UnknownNull T t6);
}
