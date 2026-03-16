package I1;

import E1.k;
import io.ktor.utils.io.jvm.javaio.q;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f750a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f751f;

    public a(ByteBuffer memory) {
        h.f(memory, "memory");
        this.f750a = memory;
        this.e = memory.limit();
        this.f751f = memory.limit();
    }

    public final void a(int i) {
        int i3 = this.c;
        int i4 = i3 + i;
        if (i < 0 || i4 > this.e) {
            k.m(i, this.e - i3);
            throw null;
        }
        this.c = i4;
    }

    public final void b(int i) {
        int i3 = this.e;
        int i4 = this.c;
        if (i < i4) {
            k.m(i - i4, i3 - i4);
            throw null;
        }
        if (i < i3) {
            this.c = i;
        } else if (i == i3) {
            this.c = i;
        } else {
            k.m(i - i4, i3 - i4);
            throw null;
        }
    }

    public final void c(int i) {
        if (i == 0) {
            return;
        }
        int i3 = this.b;
        int i4 = i3 + i;
        if (i < 0 || i4 > this.c) {
            k.w(i, this.c - i3);
            throw null;
        }
        this.b = i4;
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "newReadPosition shouldn't be negative: ").toString());
        }
        if (i > this.b) {
            StringBuilder sbJ = B2.b.j(i, "newReadPosition shouldn't be ahead of the read position: ", " > ");
            sbJ.append(this.b);
            throw new IllegalArgumentException(sbJ.toString().toString());
        }
        this.b = i;
        if (this.d > i) {
            this.d = i;
        }
    }

    public final void e() {
        int i = this.f751f;
        int i3 = i - 8;
        int i4 = this.c;
        if (i3 >= i4) {
            this.e = i3;
            return;
        }
        if (i3 < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "End gap 8 is too big: capacity is "));
        }
        if (i3 < this.d) {
            throw new IllegalArgumentException(B2.b.g(new StringBuilder("End gap 8 is too big: there are already "), " bytes reserved in the beginning", this.d));
        }
        if (this.b == i4) {
            this.e = i3;
            this.b = i3;
            this.c = i3;
        } else {
            throw new IllegalArgumentException("Unable to reserve end gap 8: there are already " + (this.c - this.b) + " content bytes at offset " + this.b);
        }
    }

    public final void f(int i) {
        int i3 = this.d;
        this.b = i3;
        this.c = i3;
        this.e = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Buffer[0x");
        int iHashCode = hashCode();
        q.c(16);
        String string = Integer.toString(iHashCode, 16);
        h.e(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        sb.append("](");
        sb.append(this.c - this.b);
        sb.append(" used, ");
        sb.append(this.e - this.c);
        sb.append(" free, ");
        int i = this.d;
        int i3 = this.e;
        int i4 = this.f751f;
        sb.append((i4 - i3) + i);
        sb.append(" reserved of ");
        sb.append(i4);
        sb.append(')');
        return sb.toString();
    }
}
