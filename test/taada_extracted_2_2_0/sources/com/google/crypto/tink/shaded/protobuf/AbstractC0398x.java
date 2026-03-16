package com.google.crypto.tink.shaded.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0398x extends AbstractC0369i {
    public static final Logger d = Logger.getLogger(AbstractC0398x.class.getName());
    public static final boolean e = S0.e;
    public C0400y c;

    public static int A(AbstractC0381o abstractC0381o) {
        int size = abstractC0381o.size();
        return I(size) + size;
    }

    public static int B(int i) {
        return G(i) + 4;
    }

    public static int C(int i) {
        return G(i) + 8;
    }

    public static int D(int i, MessageLite messageLite, Schema schema) {
        return ((AbstractC0357c) messageLite).a(schema) + (G(i) * 2);
    }

    public static int E(int i) {
        if (i >= 0) {
            return I(i);
        }
        return 10;
    }

    public static int F(String str) {
        int length;
        try {
            length = V0.b(str);
        } catch (U0 unused) {
            length = str.getBytes(T.f2849a).length;
        }
        return I(length) + length;
    }

    public static int G(int i) {
        return I(i << 3);
    }

    public static int H(int i, int i3) {
        return I(i3) + G(i);
    }

    public static int I(int i) {
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

    public static int J(long j6) {
        int i;
        if (((-128) & j6) == 0) {
            return 1;
        }
        if (j6 < 0) {
            return 10;
        }
        if (((-34359738368L) & j6) != 0) {
            j6 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j6) != 0) {
            i += 2;
            j6 >>>= 14;
        }
        return (j6 & (-16384)) != 0 ? i + 1 : i;
    }

    public static int z(int i, AbstractC0381o abstractC0381o) {
        return A(abstractC0381o) + G(i);
    }

    public final void K(String str, U0 u02) throws C0394v {
        d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) u02);
        byte[] bytes = str.getBytes(T.f2849a);
        try {
            f0(bytes.length);
            y(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e6) {
            throw new C0394v(e6);
        }
    }

    public abstract void L(byte b);

    public abstract void M(int i, boolean z6);

    public abstract void N(int i, byte[] bArr);

    public abstract void O(int i, AbstractC0381o abstractC0381o);

    public abstract void P(AbstractC0381o abstractC0381o);

    public abstract void Q(int i, int i3);

    public abstract void R(int i);

    public abstract void S(int i, long j6);

    public abstract void T(long j6);

    public abstract void U(int i, int i3);

    public abstract void V(int i);

    public abstract void W(int i, MessageLite messageLite);

    public abstract void X(int i, MessageLite messageLite, Schema schema);

    public abstract void Y(MessageLite messageLite);

    public abstract void Z(int i, MessageLite messageLite);

    public abstract void a0(int i, AbstractC0381o abstractC0381o);

    public abstract void b0(int i, String str);

    public abstract void c0(String str);

    public abstract void d0(int i, int i3);

    public abstract void e0(int i, int i3);

    public abstract void f0(int i);

    public abstract void g0(int i, long j6);

    public abstract void h0(long j6);
}
