package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i, int i3, ByteBuffer byteBuffer) {
        __reset(i, i3, byteBuffer);
        return this;
    }

    public Table get(Table table, int i) {
        return Table.__union(table, __element(i), this.bb);
    }
}
