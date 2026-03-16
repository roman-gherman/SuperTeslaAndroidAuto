package net.bytebuddy.matcher;

import A1.a;
import B2.b;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.matcher.FilterableList;

/* JADX INFO: loaded from: classes2.dex */
public interface FilterableList<T, S extends FilterableList<T, S>> extends List<T> {

    public static abstract class AbstractBase<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        private static final int ONLY = 0;

        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                a aVar = (Object) it.next();
                if (elementMatcher.matches(aVar)) {
                    arrayList.add(aVar);
                }
            }
            return arrayList.size() == size() ? this : (S) wrap(arrayList);
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            if (size() == 1) {
                return get(0);
            }
            throw new IllegalStateException("size = " + size());
        }

        public abstract S wrap(List<T> list);

        @Override // java.util.AbstractList, java.util.List
        public S subList(int i, int i3) {
            return (S) wrap(super.subList(i, i3));
        }
    }

    public static class Empty<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            return this;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            throw new IndexOutOfBoundsException(b.c(i, "index = "));
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            throw new IllegalStateException("size = 0");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public S subList(int i, int i3) {
            if (i == i3 && i3 == 0) {
                return this;
            }
            if (i <= i3) {
                throw new IndexOutOfBoundsException(b.c(i, "fromIndex = "));
            }
            throw new IllegalArgumentException("fromIndex(" + i + ") > toIndex(" + i3 + ")");
        }
    }

    S filter(ElementMatcher<? super T> elementMatcher);

    T getOnly();

    @Override // java.util.List
    S subList(int i, int i3);
}
