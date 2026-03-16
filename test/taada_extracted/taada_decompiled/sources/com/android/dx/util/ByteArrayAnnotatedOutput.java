package com.android.dx.util;

import B2.b;
import C5.f;
import com.android.dex.util.ByteOutput;
import g.C0476a;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ByteArrayAnnotatedOutput implements AnnotatedOutput, ByteOutput {
    private static final int DEFAULT_SIZE = 1000;
    private int annotationWidth;
    private ArrayList<Annotation> annotations;
    private int cursor;
    private byte[] data;
    private int hexCols;
    private final boolean stretchy;
    private boolean verbose;

    public ByteArrayAnnotatedOutput(byte[] bArr) {
        this(bArr, false);
    }

    private void ensureCapacity(int i) {
        byte[] bArr = this.data;
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i * 2) + 1000];
            System.arraycopy(bArr, 0, bArr2, 0, this.cursor);
            this.data = bArr2;
        }
    }

    private static void throwBounds() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    @Override // com.android.dx.util.Output
    public void alignTo(int i) {
        int i3 = i - 1;
        if (i < 0 || (i & i3) != 0) {
            throw new IllegalArgumentException("bogus alignment");
        }
        int i4 = (this.cursor + i3) & (~i3);
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        Arrays.fill(this.data, this.cursor, i4, (byte) 0);
        this.cursor = i4;
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void annotate(String str) {
        if (this.annotations == null) {
            return;
        }
        endAnnotation();
        this.annotations.add(new Annotation(this.cursor, str));
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public boolean annotates() {
        return this.annotations != null;
    }

    @Override // com.android.dx.util.Output
    public void assertCursor(int i) {
        if (this.cursor == i) {
            return;
        }
        StringBuilder sbJ = b.j(i, "expected cursor ", "; actual value: ");
        sbJ.append(this.cursor);
        throw new C0476a(sbJ.toString(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[PHI: r1
      0x0017: PHI (r1v3 int) = (r1v0 int), (r1v1 int) binds: [B:9:0x0015, B:12:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void enableAnnotations(int r4, boolean r5) {
        /*
            r3 = this;
            java.util.ArrayList<com.android.dx.util.ByteArrayAnnotatedOutput$Annotation> r0 = r3.annotations
            if (r0 != 0) goto L36
            int r0 = r3.cursor
            if (r0 != 0) goto L36
            r0 = 40
            if (r4 < r0) goto L2e
            int r0 = r4 + (-7)
            int r0 = r0 / 15
            int r0 = r0 + 1
            r0 = r0 & (-2)
            r1 = 6
            if (r0 >= r1) goto L19
        L17:
            r0 = r1
            goto L1e
        L19:
            r1 = 10
            if (r0 <= r1) goto L1e
            goto L17
        L1e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r2)
            r3.annotations = r1
            r3.annotationWidth = r4
            r3.hexCols = r0
            r3.verbose = r5
            return
        L2e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "annotationWidth < 40"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "cannot enable annotations"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.util.ByteArrayAnnotatedOutput.enableAnnotations(int, boolean):void");
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void endAnnotation() {
        int size;
        ArrayList<Annotation> arrayList = this.annotations;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return;
        }
        this.annotations.get(size - 1).setEndIfUnset(this.cursor);
    }

    public void finishAnnotating() {
        endAnnotation();
        ArrayList<Annotation> arrayList = this.annotations;
        if (arrayList != null) {
            for (int size = arrayList.size(); size > 0; size--) {
                int i = size - 1;
                Annotation annotation = this.annotations.get(i);
                if (annotation.getStart() <= this.cursor) {
                    int end = annotation.getEnd();
                    int i3 = this.cursor;
                    if (end > i3) {
                        annotation.setEnd(i3);
                        return;
                    }
                    return;
                }
                this.annotations.remove(i);
            }
        }
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public int getAnnotationWidth() {
        int i = this.hexCols;
        return this.annotationWidth - ((i / 2) + ((i * 2) + 8));
    }

    public byte[] getArray() {
        return this.data;
    }

    @Override // com.android.dx.util.Output
    public int getCursor() {
        return this.cursor;
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public boolean isVerbose() {
        return this.verbose;
    }

    public byte[] toByteArray() {
        int i = this.cursor;
        byte[] bArr = new byte[i];
        System.arraycopy(this.data, 0, bArr, 0, i);
        return bArr;
    }

    @Override // com.android.dx.util.Output
    public void write(ByteArray byteArray) {
        int size = byteArray.size();
        int i = this.cursor;
        int i3 = size + i;
        if (this.stretchy) {
            ensureCapacity(i3);
        } else if (i3 > this.data.length) {
            throwBounds();
            return;
        }
        byteArray.getBytes(this.data, i);
        this.cursor = i3;
    }

    public void writeAnnotationsTo(Writer writer) {
        int i;
        String text;
        int i3;
        TwoColumnOutput twoColumnOutput = new TwoColumnOutput(writer, (this.annotationWidth - r0) - 1, getAnnotationWidth(), "|");
        Writer left = twoColumnOutput.getLeft();
        Writer right = twoColumnOutput.getRight();
        int size = this.annotations.size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = this.cursor;
            if (i5 >= i || i4 >= size) {
                break;
            }
            Annotation annotation = this.annotations.get(i4);
            int start = annotation.getStart();
            if (i5 < start) {
                text = "";
                i3 = start;
                start = i5;
            } else {
                int end = annotation.getEnd();
                text = annotation.getText();
                i4++;
                i3 = end;
            }
            left.write(Hex.dump(this.data, start, i3 - start, start, this.hexCols, 6));
            right.write(text);
            twoColumnOutput.flush();
            i5 = i3;
        }
        if (i5 < i) {
            left.write(Hex.dump(this.data, i5, i - i5, i5, this.hexCols, 6));
        }
        while (i4 < size) {
            right.write(this.annotations.get(i4).getText());
            i4++;
        }
        twoColumnOutput.flush();
    }

    @Override // com.android.dx.util.Output, com.android.dex.util.ByteOutput
    public void writeByte(int i) {
        int i3 = this.cursor;
        int i4 = i3 + 1;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        this.data[i3] = (byte) i;
        this.cursor = i4;
    }

    @Override // com.android.dx.util.Output
    public void writeInt(int i) {
        int i3 = this.cursor;
        int i4 = i3 + 4;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        byte[] bArr = this.data;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i >> 8);
        bArr[i3 + 2] = (byte) (i >> 16);
        bArr[i3 + 3] = (byte) (i >> 24);
        this.cursor = i4;
    }

    @Override // com.android.dx.util.Output
    public void writeLong(long j6) {
        int i = this.cursor;
        int i3 = i + 8;
        if (this.stretchy) {
            ensureCapacity(i3);
        } else if (i3 > this.data.length) {
            throwBounds();
            return;
        }
        int i4 = (int) j6;
        byte[] bArr = this.data;
        bArr[i] = (byte) i4;
        bArr[i + 1] = (byte) (i4 >> 8);
        bArr[i + 2] = (byte) (i4 >> 16);
        bArr[i + 3] = (byte) (i4 >> 24);
        int i5 = (int) (j6 >> 32);
        bArr[i + 4] = (byte) i5;
        bArr[i + 5] = (byte) (i5 >> 8);
        bArr[i + 6] = (byte) (i5 >> 16);
        bArr[i + 7] = (byte) (i5 >> 24);
        this.cursor = i3;
    }

    @Override // com.android.dx.util.Output
    public void writeShort(int i) {
        int i3 = this.cursor;
        int i4 = i3 + 2;
        if (this.stretchy) {
            ensureCapacity(i4);
        } else if (i4 > this.data.length) {
            throwBounds();
            return;
        }
        byte[] bArr = this.data;
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i >> 8);
        this.cursor = i4;
    }

    @Override // com.android.dx.util.Output
    public int writeSleb128(int i) {
        if (this.stretchy) {
            ensureCapacity(this.cursor + 5);
        }
        int i3 = this.cursor;
        f.q0(this, i);
        return this.cursor - i3;
    }

    @Override // com.android.dx.util.Output
    public int writeUleb128(int i) {
        if (this.stretchy) {
            ensureCapacity(this.cursor + 5);
        }
        int i3 = this.cursor;
        f.r0(this, i);
        return this.cursor - i3;
    }

    @Override // com.android.dx.util.Output
    public void writeZeroes(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        int i3 = this.cursor + i;
        if (this.stretchy) {
            ensureCapacity(i3);
        } else if (i3 > this.data.length) {
            throwBounds();
            return;
        }
        Arrays.fill(this.data, this.cursor, i3, (byte) 0);
        this.cursor = i3;
    }

    public ByteArrayAnnotatedOutput() {
        this(1000);
    }

    public ByteArrayAnnotatedOutput(int i) {
        this(new byte[i], true);
    }

    public static class Annotation {
        private int end;
        private final int start;
        private final String text;

        public Annotation(int i, int i3, String str) {
            this.start = i;
            this.end = i3;
            this.text = str;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public String getText() {
            return this.text;
        }

        public void setEnd(int i) {
            this.end = i;
        }

        public void setEndIfUnset(int i) {
            if (this.end == Integer.MAX_VALUE) {
                this.end = i;
            }
        }

        public Annotation(int i, String str) {
            this(i, Integer.MAX_VALUE, str);
        }
    }

    private ByteArrayAnnotatedOutput(byte[] bArr, boolean z6) {
        if (bArr != null) {
            this.stretchy = z6;
            this.data = bArr;
            this.cursor = 0;
            this.verbose = false;
            this.annotations = null;
            this.annotationWidth = 0;
            this.hexCols = 0;
            return;
        }
        throw new NullPointerException("data == null");
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void annotate(int i, String str) {
        if (this.annotations == null) {
            return;
        }
        endAnnotation();
        int size = this.annotations.size();
        int end = size == 0 ? 0 : this.annotations.get(size - 1).getEnd();
        int i3 = this.cursor;
        if (end <= i3) {
            end = i3;
        }
        this.annotations.add(new Annotation(end, i + end, str));
    }

    @Override // com.android.dx.util.Output
    public void write(byte[] bArr, int i, int i3) {
        int i4 = this.cursor;
        int i5 = i4 + i3;
        int i6 = i + i3;
        if ((i | i3 | i5) >= 0 && i6 <= bArr.length) {
            if (this.stretchy) {
                ensureCapacity(i5);
            } else if (i5 > this.data.length) {
                throwBounds();
                return;
            }
            System.arraycopy(bArr, i, this.data, i4, i3);
            this.cursor = i5;
            return;
        }
        throw new IndexOutOfBoundsException("bytes.length " + bArr.length + "; " + i + "..!" + i5);
    }

    @Override // com.android.dx.util.Output
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }
}
