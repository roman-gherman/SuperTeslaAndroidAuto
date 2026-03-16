package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.android.gms.internal.play_billing.U0;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0606g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3865a;
    public final int b;
    public int c = 0;
    public final OutputStream d;

    public C0606g(OutputStream outputStream, byte[] bArr) {
        this.d = outputStream;
        this.f3865a = bArr;
        this.b = bArr.length;
    }

    public static int a(int i, int i3) {
        return c(i3) + h(i);
    }

    public static int b(int i, int i3) {
        return c(i3) + h(i);
    }

    public static int c(int i) {
        if (i >= 0) {
            return f(i);
        }
        return 10;
    }

    public static int d(int i, MessageLite messageLite) {
        return e(messageLite) + h(i);
    }

    public static int e(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return f(serializedSize) + serializedSize;
    }

    public static int f(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int g(long j6) {
        if (((-128) & j6) == 0) {
            return 1;
        }
        if (((-16384) & j6) == 0) {
            return 2;
        }
        if (((-2097152) & j6) == 0) {
            return 3;
        }
        if (((-268435456) & j6) == 0) {
            return 4;
        }
        if (((-34359738368L) & j6) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j6) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j6) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j6) == 0) {
            return 8;
        }
        return (j6 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int h(int i) {
        return f(i << 3);
    }

    public static C0606g j(OutputStream outputStream, int i) {
        return new C0606g(outputStream, new byte[i]);
    }

    public final void i() throws IOException {
        if (this.d != null) {
            k();
        }
    }

    public final void k() throws IOException {
        OutputStream outputStream = this.d;
        if (outputStream == null) {
            throw new U0("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
        outputStream.write(this.f3865a, 0, this.c);
        this.c = 0;
    }

    public final void l(int i, int i3) {
        x(i, 0);
        n(i3);
    }

    public final void m(int i, int i3) {
        x(i, 0);
        n(i3);
    }

    public final void n(int i) {
        if (i >= 0) {
            v(i);
        } else {
            w(i);
        }
    }

    public final void o(int i, MessageLite messageLite) {
        x(i, 2);
        p(messageLite);
    }

    public final void p(MessageLite messageLite) {
        v(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public final void q(int i) throws IOException {
        byte b = (byte) i;
        if (this.c == this.b) {
            k();
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.f3865a[i3] = b;
    }

    public final void r(AbstractC0604e abstractC0604e) {
        int size = abstractC0604e.size();
        int i = this.c;
        int i3 = this.b;
        int i4 = i3 - i;
        byte[] bArr = this.f3865a;
        if (i4 >= size) {
            abstractC0604e.c(bArr, 0, i, size);
            this.c += size;
            return;
        }
        abstractC0604e.c(bArr, 0, i, i4);
        int i5 = size - i4;
        this.c = i3;
        k();
        if (i5 <= i3) {
            abstractC0604e.c(bArr, i4, 0, i5);
            this.c = i5;
            return;
        }
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i4);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i5 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i5);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i6 = i4 + i5;
        if (i6 <= abstractC0604e.size()) {
            if (i5 > 0) {
                abstractC0604e.o(this.d, i4, i5);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i6);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final void s(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = this.c;
        int i3 = this.b;
        int i4 = i3 - i;
        byte[] bArr2 = this.f3865a;
        if (i4 >= length) {
            System.arraycopy(bArr, 0, bArr2, i, length);
            this.c += length;
            return;
        }
        System.arraycopy(bArr, 0, bArr2, i, i4);
        int i5 = length - i4;
        this.c = i3;
        k();
        if (i5 > i3) {
            this.d.write(bArr, i4, i5);
        } else {
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            this.c = i5;
        }
    }

    public final void t(int i) {
        q(i & 255);
        q((i >> 8) & 255);
        q((i >> 16) & 255);
        q((i >> 24) & 255);
    }

    public final void u(long j6) {
        q(((int) j6) & 255);
        q(((int) (j6 >> 8)) & 255);
        q(((int) (j6 >> 16)) & 255);
        q(((int) (j6 >> 24)) & 255);
        q(((int) (j6 >> 32)) & 255);
        q(((int) (j6 >> 40)) & 255);
        q(((int) (j6 >> 48)) & 255);
        q(((int) (j6 >> 56)) & 255);
    }

    public final void v(int i) {
        while ((i & (-128)) != 0) {
            q((i & 127) | 128);
            i >>>= 7;
        }
        q(i);
    }

    public final void w(long j6) {
        while (((-128) & j6) != 0) {
            q((((int) j6) & 127) | 128);
            j6 >>>= 7;
        }
        q((int) j6);
    }

    public final void x(int i, int i3) {
        v((i << 3) | i3);
    }
}
