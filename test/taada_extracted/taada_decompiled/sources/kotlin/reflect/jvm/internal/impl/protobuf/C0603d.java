package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0603d extends OutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f3858f = new byte[0];
    public int c;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3859a = 128;
    public final ArrayList b = new ArrayList();
    public byte[] d = new byte[128];

    public final void a(int i) {
        this.b.add(new u(this.d));
        int length = this.c + this.d.length;
        this.c = length;
        this.d = new byte[Math.max(this.f3859a, Math.max(i, length >>> 1))];
        this.e = 0;
    }

    public final void b() {
        int i = this.e;
        byte[] bArr = this.d;
        int length = bArr.length;
        ArrayList arrayList = this.b;
        if (i >= length) {
            arrayList.add(new u(this.d));
            this.d = f3858f;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            arrayList.add(new u(bArr2));
        }
        this.c += this.e;
        this.e = 0;
    }

    public final synchronized AbstractC0604e c() {
        ArrayList arrayList;
        b();
        arrayList = this.b;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((AbstractC0604e) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList.isEmpty() ? AbstractC0604e.f3860a : AbstractC0604e.a(arrayList.iterator(), arrayList.size());
    }

    public final String toString() {
        int i;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        synchronized (this) {
            i = this.c + this.e;
        }
        return String.format("<ByteString.Output@%s size=%d>", hexString, Integer.valueOf(i));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        try {
            if (this.e == this.d.length) {
                a(1);
            }
            byte[] bArr = this.d;
            int i3 = this.e;
            this.e = i3 + 1;
            bArr[i3] = (byte) i;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i3) {
        try {
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e;
            if (i3 <= length - i4) {
                System.arraycopy(bArr, i, bArr2, i4, i3);
                this.e += i3;
            } else {
                int length2 = bArr2.length - i4;
                System.arraycopy(bArr, i, bArr2, i4, length2);
                int i5 = i3 - length2;
                a(i5);
                System.arraycopy(bArr, i + length2, this.d, 0, i5);
                this.e = i5;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
