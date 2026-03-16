package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class G implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f3846a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3846a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f3846a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
