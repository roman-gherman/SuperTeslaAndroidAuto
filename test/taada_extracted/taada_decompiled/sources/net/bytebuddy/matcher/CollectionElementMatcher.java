package net.bytebuddy.matcher;

import com.google.protobuf.a;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class CollectionElementMatcher<T> extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>> {
    private final int index;
    private final ElementMatcher<? super T> matcher;

    public CollectionElementMatcher(int i, ElementMatcher<? super T> elementMatcher) {
        this.index = i;
        this.matcher = elementMatcher;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CollectionElementMatcher collectionElementMatcher = (CollectionElementMatcher) obj;
        return this.index == collectionElementMatcher.index && this.matcher.equals(collectionElementMatcher.matcher);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return this.matcher.hashCode() + (((super.hashCode() * 31) + this.index) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("with(");
        sb.append(this.index);
        sb.append(" matches ");
        return a.n(sb, this.matcher, ")");
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        for (int i = 0; i < this.index; i++) {
            if (!it.hasNext()) {
                return false;
            }
            it.next();
        }
        return it.hasNext() && this.matcher.matches(it.next());
    }
}
