package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements ByteString$ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3877a = 0;
    public final int b;
    public final /* synthetic */ u c;

    public t(u uVar) {
        this.c = uVar;
        this.b = uVar.b.length;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3877a < this.b;
    }

    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator
    public final byte nextByte() {
        try {
            byte[] bArr = this.c.b;
            int i = this.f3877a;
            this.f3877a = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
