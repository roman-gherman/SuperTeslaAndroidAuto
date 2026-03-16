package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Stack;
import org.slf4j.Marker;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0604e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f3861a = new u(new byte[0]);

    public static AbstractC0604e a(Iterator it, int i) {
        if (i == 1) {
            return (AbstractC0604e) it.next();
        }
        int i3 = i >>> 1;
        return a(it, i3).b(a(it, i - i3));
    }

    public static C0603d i() {
        return new C0603d();
    }

    public final AbstractC0604e b(AbstractC0604e abstractC0604e) {
        int size = size();
        int size2 = abstractC0604e.size();
        if (((long) size) + ((long) size2) >= 2147483647L) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append(Marker.ANY_NON_NULL_MARKER);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
        int[] iArr = z.f3884h;
        z zVar = this instanceof z ? (z) this : null;
        if (abstractC0604e.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return abstractC0604e;
        }
        int size3 = abstractC0604e.size() + size();
        if (size3 < 128) {
            int size4 = size();
            int size5 = abstractC0604e.size();
            byte[] bArr = new byte[size4 + size5];
            c(bArr, 0, 0, size4);
            abstractC0604e.c(bArr, 0, size4, size5);
            return new u(bArr);
        }
        if (zVar != null) {
            AbstractC0604e abstractC0604e2 = zVar.d;
            if (abstractC0604e.size() + abstractC0604e2.size() < 128) {
                int size6 = abstractC0604e2.size();
                int size7 = abstractC0604e.size();
                byte[] bArr2 = new byte[size6 + size7];
                abstractC0604e2.c(bArr2, 0, 0, size6);
                abstractC0604e.c(bArr2, 0, size6, size7);
                return new z(zVar.c, new u(bArr2));
            }
        }
        if (zVar != null) {
            AbstractC0604e abstractC0604e3 = zVar.c;
            int iE = abstractC0604e3.e();
            AbstractC0604e abstractC0604e4 = zVar.d;
            if (iE > abstractC0604e4.e()) {
                if (zVar.f3885f > abstractC0604e.e()) {
                    return new z(abstractC0604e3, new z(abstractC0604e4, abstractC0604e));
                }
            }
        }
        if (size3 >= z.f3884h[Math.max(e(), abstractC0604e.e()) + 1]) {
            return new z(this, abstractC0604e);
        }
        v vVar = new v(0);
        vVar.a(this);
        vVar.a(abstractC0604e);
        Stack stack = (Stack) vVar.f3878a;
        AbstractC0604e zVar2 = (AbstractC0604e) stack.pop();
        while (!stack.isEmpty()) {
            zVar2 = new z((AbstractC0604e) stack.pop(), zVar2);
        }
        return zVar2;
    }

    public final void c(byte[] bArr, int i, int i3, int i4) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i4 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i5 = i + i4;
        if (i5 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i5);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i6 = i3 + i4;
        if (i6 <= bArr.length) {
            if (i4 > 0) {
                d(bArr, i, i3, i4);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i6);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public abstract void d(byte[] bArr, int i, int i3, int i4);

    public abstract int e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract C0605f h();

    public abstract int j(int i, int i3, int i4);

    public abstract int k(int i, int i3, int i4);

    public abstract int l();

    public abstract String m();

    public final String n() {
        try {
            return m();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public abstract void o(OutputStream outputStream, int i, int i3);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
