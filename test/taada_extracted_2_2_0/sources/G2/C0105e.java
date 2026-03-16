package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$ValueOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0105e extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$Annotation$Argument$ValueOrBuilder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0105e f568p;
    public static final C0101a q = new C0101a(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f569a;
    public int b;
    public EnumC0104d c;
    public long d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f572h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0108h f573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f576m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte f577n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f578o;

    static {
        C0105e c0105e = new C0105e();
        f568p = c0105e;
        c0105e.c();
    }

    public C0105e() {
        this.f577n = (byte) -1;
        this.f578o = -1;
        this.f569a = AbstractC0604e.f3861a;
    }

    public final void c() {
        this.c = EnumC0104d.BYTE;
        this.d = 0L;
        this.e = 0.0f;
        this.f570f = 0.0d;
        this.f571g = 0;
        this.f572h = 0;
        this.i = 0;
        this.f573j = C0108h.f588g;
        this.f574k = Collections.EMPTY_LIST;
        this.f575l = 0;
        this.f576m = 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f568p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f578o;
        if (i != -1) {
            return i;
        }
        int iA = (this.b & 1) == 1 ? C0606g.a(1, this.c.f560a) : 0;
        if ((this.b & 2) == 2) {
            long j6 = this.d;
            iA += C0606g.g((j6 >> 63) ^ (j6 << 1)) + C0606g.h(2);
        }
        if ((this.b & 4) == 4) {
            iA += C0606g.h(3) + 4;
        }
        if ((this.b & 8) == 8) {
            iA += C0606g.h(4) + 8;
        }
        if ((this.b & 16) == 16) {
            iA += C0606g.b(5, this.f571g);
        }
        if ((this.b & 32) == 32) {
            iA += C0606g.b(6, this.f572h);
        }
        if ((this.b & 64) == 64) {
            iA += C0606g.b(7, this.i);
        }
        if ((this.b & 128) == 128) {
            iA += C0606g.d(8, this.f573j);
        }
        for (int i3 = 0; i3 < this.f574k.size(); i3++) {
            iA += C0606g.d(9, (MessageLite) this.f574k.get(i3));
        }
        if ((this.b & 512) == 512) {
            iA += C0606g.b(10, this.f576m);
        }
        if ((this.b & 256) == 256) {
            iA += C0606g.b(11, this.f575l);
        }
        int size = this.f569a.size() + iA;
        this.f578o = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f577n;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 128) == 128 && !this.f573j.isInitialized()) {
            this.f577n = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f574k.size(); i++) {
            if (!((C0105e) this.f574k.get(i)).isInitialized()) {
                this.f577n = (byte) 0;
                return false;
            }
        }
        this.f577n = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0103c.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0103c c0103cC = C0103c.c();
        c0103cC.d(this);
        return c0103cC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.l(1, this.c.f560a);
        }
        if ((this.b & 2) == 2) {
            long j6 = this.d;
            c0606g.x(2, 0);
            c0606g.w((j6 >> 63) ^ (j6 << 1));
        }
        if ((this.b & 4) == 4) {
            float f6 = this.e;
            c0606g.x(3, 5);
            c0606g.t(Float.floatToRawIntBits(f6));
        }
        if ((this.b & 8) == 8) {
            double d = this.f570f;
            c0606g.x(4, 1);
            c0606g.u(Double.doubleToRawLongBits(d));
        }
        if ((this.b & 16) == 16) {
            c0606g.m(5, this.f571g);
        }
        if ((this.b & 32) == 32) {
            c0606g.m(6, this.f572h);
        }
        if ((this.b & 64) == 64) {
            c0606g.m(7, this.i);
        }
        if ((this.b & 128) == 128) {
            c0606g.o(8, this.f573j);
        }
        for (int i = 0; i < this.f574k.size(); i++) {
            c0606g.o(9, (MessageLite) this.f574k.get(i));
        }
        if ((this.b & 512) == 512) {
            c0606g.m(10, this.f576m);
        }
        if ((this.b & 256) == 256) {
            c0606g.m(11, this.f575l);
        }
        c0606g.r(this.f569a);
    }

    public C0105e(C0103c c0103c) {
        this.f577n = (byte) -1;
        this.f578o = -1;
        this.f569a = c0103c.f3870a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public C0105e(C0605f c0605f, C0608i c0608i) {
        C0107g c0107g;
        this.f577n = (byte) -1;
        this.f578o = -1;
        c();
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        char c = 0;
        while (true) {
            ?? Q5 = 256;
            if (!z6) {
                try {
                    try {
                        int iN = c0605f.n();
                        switch (iN) {
                            case 0:
                                z6 = true;
                                break;
                            case 8:
                                int iK = c0605f.k();
                                EnumC0104d enumC0104dA = EnumC0104d.a(iK);
                                if (enumC0104dA == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK);
                                } else {
                                    this.b |= 1;
                                    this.c = enumC0104dA;
                                }
                                break;
                            case 16:
                                this.b |= 2;
                                long jL = c0605f.l();
                                this.d = (-(jL & 1)) ^ (jL >>> 1);
                                break;
                            case 29:
                                this.b |= 4;
                                this.e = Float.intBitsToFloat(c0605f.i());
                                break;
                            case 33:
                                this.b |= 8;
                                this.f570f = Double.longBitsToDouble(c0605f.j());
                                break;
                            case 40:
                                this.b |= 16;
                                this.f571g = c0605f.k();
                                break;
                            case 48:
                                this.b |= 32;
                                this.f572h = c0605f.k();
                                break;
                            case 56:
                                this.b |= 64;
                                this.i = c0605f.k();
                                break;
                            case 66:
                                if ((this.b & 128) == 128) {
                                    C0108h c0108h = this.f573j;
                                    c0108h.getClass();
                                    c0107g = new C0107g();
                                    c0107g.d = Collections.EMPTY_LIST;
                                    c0107g.c(c0108h);
                                } else {
                                    c0107g = null;
                                }
                                C0108h c0108h2 = (C0108h) c0605f.g(C0108h.f589h, c0608i);
                                this.f573j = c0108h2;
                                if (c0107g != null) {
                                    c0107g.c(c0108h2);
                                    this.f573j = c0107g.b();
                                }
                                this.b |= 128;
                                break;
                            case 74:
                                if ((c & 256) != 256) {
                                    this.f574k = new ArrayList();
                                    c = 256;
                                }
                                this.f574k.add(c0605f.g(q, c0608i));
                                break;
                            case 80:
                                this.b |= 512;
                                this.f576m = c0605f.k();
                                break;
                            case 88:
                                this.b |= 256;
                                this.f575l = c0605f.k();
                                break;
                            default:
                                Q5 = c0605f.q(iN, c0606gJ);
                                if (Q5 == 0) {
                                    z6 = true;
                                }
                                break;
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                        e.f3875a = this;
                        throw e;
                    } catch (IOException e6) {
                        kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                        rVar.f3875a = this;
                        throw rVar;
                    }
                } catch (Throwable th) {
                    if ((c & 256) == Q5) {
                        this.f574k = Collections.unmodifiableList(this.f574k);
                    }
                    try {
                        c0606gJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    throw th;
                }
            } else {
                if ((c & 256) == 256) {
                    this.f574k = Collections.unmodifiableList(this.f574k);
                }
                try {
                    c0606gJ.i();
                    return;
                } catch (IOException unused2) {
                    return;
                } finally {
                    this.f569a = c0603d.c();
                }
            }
        }
    }
}
