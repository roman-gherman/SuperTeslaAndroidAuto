package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class u extends AbstractC0604e {
    public final byte[] b;
    public int c = 0;

    public u(byte[] bArr) {
        this.b = bArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public void d(byte[] bArr, int i, int i3, int i4) {
        System.arraycopy(this.b, i, bArr, i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0604e) || size() != ((AbstractC0604e) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof u) {
            return p((u) obj, 0, size());
        }
        if (obj instanceof z) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(B2.b.h(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final boolean f() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final boolean g() {
        byte[] bArr = this.b;
        return D.c(bArr, 0, bArr.length) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final C0605f h() {
        C0605f c0605f = new C0605f(this);
        try {
            c0605f.d(this.b.length);
            return c0605f;
        } catch (r e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final int hashCode() {
        int iJ = this.c;
        if (iJ == 0) {
            int size = size();
            iJ = j(size, 0, size);
            if (iJ == 0) {
                iJ = 1;
            }
            this.c = iJ;
        }
        return iJ;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new t(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int j(int i, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i = (i * 31) + this.b[i5];
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r0[r9] > (-65)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r0[r9] > (-65)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        if (r0[r8] > (-65)) goto L59;
     */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int k(int r8, int r9, int r10) {
        /*
            r7 = this;
            int r10 = r10 + r9
            byte[] r0 = r7.b
            if (r8 == 0) goto L95
            if (r9 < r10) goto L8
            return r8
        L8:
            byte r1 = (byte) r8
            r2 = -1
            r3 = -65
            r4 = -32
            if (r1 >= r4) goto L1f
            r8 = -62
            if (r1 < r8) goto L94
            int r8 = r9 + 1
            r9 = r0[r9]
            if (r9 <= r3) goto L1c
            goto L94
        L1c:
            r9 = r8
            goto L95
        L1f:
            r5 = -16
            if (r1 >= r5) goto L4c
            int r8 = r8 >> 8
            int r8 = ~r8
            byte r8 = (byte) r8
            if (r8 != 0) goto L37
            int r8 = r9 + 1
            r9 = r0[r9]
            if (r8 < r10) goto L34
            int r8 = kotlin.reflect.jvm.internal.impl.protobuf.D.a(r1, r9)
            return r8
        L34:
            r6 = r9
            r9 = r8
            r8 = r6
        L37:
            if (r8 > r3) goto L94
            r5 = -96
            if (r1 != r4) goto L3f
            if (r8 < r5) goto L94
        L3f:
            r4 = -19
            if (r1 != r4) goto L45
            if (r8 >= r5) goto L94
        L45:
            int r8 = r9 + 1
            r9 = r0[r9]
            if (r9 <= r3) goto L1c
            goto L94
        L4c:
            int r4 = r8 >> 8
            int r4 = ~r4
            byte r4 = (byte) r4
            if (r4 != 0) goto L5f
            int r8 = r9 + 1
            r4 = r0[r9]
            if (r8 < r10) goto L5d
            int r8 = kotlin.reflect.jvm.internal.impl.protobuf.D.a(r1, r4)
            return r8
        L5d:
            r9 = 0
            goto L65
        L5f:
            int r8 = r8 >> 16
            byte r8 = (byte) r8
            r6 = r9
            r9 = r8
            r8 = r6
        L65:
            if (r9 != 0) goto L81
            int r9 = r8 + 1
            r8 = r0[r8]
            if (r9 < r10) goto L7e
            r9 = -12
            if (r1 > r9) goto L7d
            if (r4 > r3) goto L7d
            if (r8 <= r3) goto L76
            goto L7d
        L76:
            int r9 = r4 << 8
            r9 = r9 ^ r1
            int r8 = r8 << 16
            r8 = r8 ^ r9
            return r8
        L7d:
            return r2
        L7e:
            r6 = r9
            r9 = r8
            r8 = r6
        L81:
            if (r4 > r3) goto L94
            int r1 = r1 << 28
            int r4 = r4 + 112
            int r4 = r4 + r1
            int r1 = r4 >> 30
            if (r1 != 0) goto L94
            if (r9 > r3) goto L94
            int r9 = r8 + 1
            r8 = r0[r8]
            if (r8 <= r3) goto L95
        L94:
            return r2
        L95:
            int r8 = kotlin.reflect.jvm.internal.impl.protobuf.D.c(r0, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.u.k(int, int, int):int");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int l() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final String m() {
        byte[] bArr = this.b;
        return new String(bArr, 0, bArr.length, "UTF-8");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final void o(OutputStream outputStream, int i, int i3) throws IOException {
        outputStream.write(this.b, i, i3);
    }

    public final boolean p(u uVar, int i, int i3) {
        byte[] bArr = uVar.b;
        int length = bArr.length;
        byte[] bArr2 = this.b;
        if (i3 > length) {
            int length2 = bArr2.length;
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = i + i3;
        int length3 = bArr.length;
        byte[] bArr3 = uVar.b;
        if (i4 <= length3) {
            int i5 = 0;
            while (i5 < i3) {
                if (bArr2[i5] != bArr3[i]) {
                    return false;
                }
                i5++;
                i++;
            }
            return true;
        }
        int length4 = bArr3.length;
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("Ran off end of other: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i3);
        sb2.append(", ");
        sb2.append(length4);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public int size() {
        return this.b.length;
    }
}
