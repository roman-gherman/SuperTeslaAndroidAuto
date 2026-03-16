package f;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f3154a;
    public int b = 0;
    public final /* synthetic */ m c;

    public j(m mVar) {
        this.c = mVar;
        this.f3154a = mVar.d(mVar.b.f3174g.c);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.c.b.f3174g.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b++;
        l lVar = this.f3154a;
        ByteBuffer byteBuffer = lVar.b;
        return new f(lVar.d, byteBuffer.position(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
