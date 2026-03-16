package androidx.collection;

import N1.m;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aX\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0018H\u0086\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\"\u0010#\"\"\u0010&\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "", "key", "", "contains", "(Landroidx/collection/SparseArrayCompat;I)Z", "value", "LN1/m;", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "other", "plus", "(Landroidx/collection/SparseArrayCompat;Landroidx/collection/SparseArrayCompat;)Landroidx/collection/SparseArrayCompat;", "defaultValue", "getOrDefault", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Landroidx/collection/SparseArrayCompat;)Z", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroidx/collection/SparseArrayCompat;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/y;", "keyIterator", "(Landroidx/collection/SparseArrayCompat;)Lkotlin/collections/y;", "", "valueIterator", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"androidx/collection/SparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "collection-ktx"}, k = 1, mv = {1, 1, 13})
    public static final class C01681<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArrayCompat $this_valueIterator;
        private int index;

        public C01681(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) sparseArrayCompat.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> receiver$0, int i) {
        h.g(receiver$0, "receiver$0");
        return receiver$0.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> receiver$0, Function2<? super Integer, ? super T, m> action) {
        h.g(receiver$0, "receiver$0");
        h.g(action, "action");
        int size = receiver$0.size();
        for (int i = 0; i < size; i++) {
            action.mo5invoke(Integer.valueOf(receiver$0.keyAt(i)), receiver$0.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> receiver$0, int i, T t6) {
        h.g(receiver$0, "receiver$0");
        return receiver$0.get(i, t6);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> receiver$0, int i, Function0<? extends T> defaultValue) {
        h.g(receiver$0, "receiver$0");
        h.g(defaultValue, "defaultValue");
        T t6 = receiver$0.get(i);
        return t6 != null ? t6 : defaultValue.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> receiver$0) {
        h.g(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> receiver$0) {
        h.g(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> y keyIterator(final SparseArrayCompat<T> receiver$0) {
        h.g(receiver$0, "receiver$0");
        return new y() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.y
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i = this.index;
                this.index = i + 1;
                return sparseArrayCompat.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> receiver$0, SparseArrayCompat<T> other) {
        h.g(receiver$0, "receiver$0");
        h.g(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(other.size() + receiver$0.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(SparseArrayCompat<T> receiver$0, int i, T t6) {
        h.g(receiver$0, "receiver$0");
        return receiver$0.remove(i, t6);
    }

    public static final <T> void set(SparseArrayCompat<T> receiver$0, int i, T t6) {
        h.g(receiver$0, "receiver$0");
        receiver$0.put(i, t6);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> receiver$0) {
        h.g(receiver$0, "receiver$0");
        return new C01681(receiver$0);
    }
}
