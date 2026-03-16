package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    public static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i = 0; i < 4; i++) {
            if (str.charAt(i) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i))) {
                return false;
            }
        }
        return true;
    }

    public static int compareStrings(int i, int i3, ByteBuffer byteBuffer) {
        int i4 = byteBuffer.getInt(i) + i;
        int i5 = byteBuffer.getInt(i3) + i3;
        int i6 = byteBuffer.getInt(i4);
        int i7 = byteBuffer.getInt(i5);
        int i8 = i4 + 4;
        int i9 = i5 + 4;
        int iMin = Math.min(i6, i7);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = i10 + i8;
            int i12 = i10 + i9;
            if (byteBuffer.get(i11) != byteBuffer.get(i12)) {
                return byteBuffer.get(i11) - byteBuffer.get(i12);
            }
        }
        return i6 - i7;
    }

    public int __indirect(int i) {
        return this.bb.getInt(i) + i;
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + i);
        }
        return 0;
    }

    public void __reset(int i, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer == null) {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        } else {
            this.bb_pos = i;
            int i3 = i - byteBuffer.getInt(i);
            this.vtable_start = i3;
            this.vtable_size = this.bb.getShort(i3);
        }
    }

    public String __string(int i) {
        return __string(i, this.bb, this.utf8);
    }

    public Table __union(Table table, int i) {
        return __union(table, i, this.bb);
    }

    public int __vector(int i) {
        int i3 = i + this.bb_pos;
        return this.bb.getInt(i3) + i3 + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int i, int i3) {
        int i__offset = __offset(i);
        if (i__offset == 0) {
            return null;
        }
        ByteBuffer byteBufferOrder = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int i__vector = __vector(i__offset);
        byteBufferOrder.position(i__vector);
        byteBufferOrder.limit((__vector_len(i__offset) * i3) + i__vector);
        return byteBufferOrder;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i, int i3) {
        int i__offset = __offset(i);
        if (i__offset == 0) {
            return null;
        }
        int i__vector = __vector(i__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(i__offset) * i3) + i__vector);
        byteBuffer.position(i__vector);
        return byteBuffer;
    }

    public int __vector_len(int i) {
        int i3 = i + this.bb_pos;
        return this.bb.getInt(this.bb.getInt(i3) + i3);
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void sortTables(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: androidx.emoji2.text.flatbuffer.Table.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Table.this.keysCompare(num, num2, byteBuffer);
            }
        });
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
    }

    public static int __indirect(int i, ByteBuffer byteBuffer) {
        return byteBuffer.getInt(i) + i;
    }

    public static int __offset(int i, int i3, ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - i3;
        return byteBuffer.getShort((i + iCapacity) - byteBuffer.getInt(iCapacity)) + iCapacity;
    }

    public static String __string(int i, ByteBuffer byteBuffer, Utf8 utf8) {
        int i3 = byteBuffer.getInt(i) + i;
        return utf8.decodeUtf8(byteBuffer, i3 + 4, byteBuffer.getInt(i3));
    }

    public static Table __union(Table table, int i, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i, byteBuffer), byteBuffer);
        return table;
    }

    public static int compareStrings(int i, byte[] bArr, ByteBuffer byteBuffer) {
        int i3 = byteBuffer.getInt(i) + i;
        int i4 = byteBuffer.getInt(i3);
        int length = bArr.length;
        int i5 = i3 + 4;
        int iMin = Math.min(i4, length);
        for (int i6 = 0; i6 < iMin; i6++) {
            int i7 = i6 + i5;
            if (byteBuffer.get(i7) != bArr[i6]) {
                return byteBuffer.get(i7) - bArr[i6];
            }
        }
        return i4 - length;
    }

    public void __reset() {
        __reset(0, null);
    }
}
