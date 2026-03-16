package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends AbstractList implements List, KMutableList {
    public abstract int a();

    public abstract Object b(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return b(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
