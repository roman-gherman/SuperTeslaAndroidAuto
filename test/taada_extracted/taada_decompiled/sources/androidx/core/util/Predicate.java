package androidx.core.util;

import androidx.core.content.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface Predicate<T> {
    static <T> Predicate<T> isEqual(Object obj) {
        return obj == null ? new d(11) : new b(obj, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(Predicate predicate, Object obj) {
        return test(obj) && predicate.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$1(Object obj) {
        return !test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$2(Predicate predicate, Object obj) {
        return test(obj) || predicate.test(obj);
    }

    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    default Predicate<T> and(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new a(this, predicate, 1);
    }

    default Predicate<T> negate() {
        return new b(this, 1);
    }

    default Predicate<T> or(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new a(this, predicate, 0);
    }

    boolean test(T t6);
}
