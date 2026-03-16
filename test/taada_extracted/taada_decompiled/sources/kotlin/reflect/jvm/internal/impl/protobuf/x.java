package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements ByteString$ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f3879a;
    public t b;
    public int c;

    public x(z zVar) {
        w wVar = new w(zVar);
        this.f3879a = wVar;
        this.b = new t(wVar.next());
        this.c = zVar.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c > 0;
    }

    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator
    public final byte nextByte() {
        if (!this.b.hasNext()) {
            this.b = new t(this.f3879a.next());
        }
        this.c--;
        return this.b.nextByte();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
