package z1;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Iterator, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f5177a;
    public final /* synthetic */ i b;

    public h(i iVar) {
        this.b = iVar;
        this.f5177a = iVar.f5178a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5177a.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // java.util.Iterator
    public final Object next() {
        return this.b.b.invoke(this.f5177a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5177a.remove();
    }
}
