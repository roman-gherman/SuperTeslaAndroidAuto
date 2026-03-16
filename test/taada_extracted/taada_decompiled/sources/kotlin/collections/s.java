package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends r {
    public static void F(Iterable elements, Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void G(AbstractCollection abstractCollection, Object[] elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        abstractCollection.addAll(j.t(elements));
    }

    public static final boolean H(Iterable iterable, Function1 function1, boolean z6) {
        Iterator it = iterable.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue() == z6) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static Object I(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(n.x(list));
    }
}
