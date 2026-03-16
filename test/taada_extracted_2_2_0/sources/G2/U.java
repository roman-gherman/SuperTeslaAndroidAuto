package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class U extends AbstractC0612m implements ProtoBuf$TypeOrBuilder {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final U f492t;
    public static final C0101a u = new C0101a(16);
    public final AbstractC0604e b;
    public int c;
    public List d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f495h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public U f499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public U f501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f502p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte f503r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f504s;

    static {
        U u2 = new U();
        f492t = u2;
        u2.j();
    }

    public U(T t6) {
        super(t6);
        this.f503r = (byte) -1;
        this.f504s = -1;
        this.b = t6.f3870a;
    }

    public static T k(U u2) {
        T tD = T.d();
        tD.e(u2);
        return tD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f492t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f504s;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 4096) == 4096 ? C0606g.b(1, this.q) : 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            iB += C0606g.d(2, (MessageLite) this.d.get(i3));
        }
        if ((this.c & 1) == 1) {
            iB += C0606g.h(3) + 1;
        }
        if ((this.c & 2) == 2) {
            iB += C0606g.b(4, this.f493f);
        }
        if ((this.c & 4) == 4) {
            iB += C0606g.d(5, this.f494g);
        }
        if ((this.c & 16) == 16) {
            iB += C0606g.b(6, this.i);
        }
        if ((this.c & 32) == 32) {
            iB += C0606g.b(7, this.f496j);
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.b(8, this.f495h);
        }
        if ((this.c & 64) == 64) {
            iB += C0606g.b(9, this.f497k);
        }
        if ((this.c & 256) == 256) {
            iB += C0606g.d(10, this.f499m);
        }
        if ((this.c & 512) == 512) {
            iB += C0606g.b(11, this.f500n);
        }
        if ((this.c & 128) == 128) {
            iB += C0606g.b(12, this.f498l);
        }
        if ((this.c & 1024) == 1024) {
            iB += C0606g.d(13, this.f501o);
        }
        if ((this.c & 2048) == 2048) {
            iB += C0606g.b(14, this.f502p);
        }
        int size = this.b.size() + c() + iB;
        this.f504s = size;
        return size;
    }

    public final boolean i() {
        return (this.c & 16) == 16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f503r;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((S) this.d.get(i)).isInitialized()) {
                this.f503r = (byte) 0;
                return false;
            }
        }
        if ((this.c & 4) == 4 && !this.f494g.isInitialized()) {
            this.f503r = (byte) 0;
            return false;
        }
        if ((this.c & 256) == 256 && !this.f499m.isInitialized()) {
            this.f503r = (byte) 0;
            return false;
        }
        if ((this.c & 1024) == 1024 && !this.f501o.isInitialized()) {
            this.f503r = (byte) 0;
            return false;
        }
        if (this.f3871a.e()) {
            this.f503r = (byte) 1;
            return true;
        }
        this.f503r = (byte) 0;
        return false;
    }

    public final void j() {
        this.d = Collections.EMPTY_LIST;
        this.e = false;
        this.f493f = 0;
        U u2 = f492t;
        this.f494g = u2;
        this.f495h = 0;
        this.i = 0;
        this.f496j = 0;
        this.f497k = 0;
        this.f498l = 0;
        this.f499m = u2;
        this.f500n = 0;
        this.f501o = u2;
        this.f502p = 0;
        this.q = 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final T toBuilder() {
        return k(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return T.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) throws IOException {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 4096) == 4096) {
            c0606g.m(1, this.q);
        }
        for (int i = 0; i < this.d.size(); i++) {
            c0606g.o(2, (MessageLite) this.d.get(i));
        }
        if ((this.c & 1) == 1) {
            boolean z6 = this.e;
            c0606g.x(3, 0);
            c0606g.q(z6 ? 1 : 0);
        }
        if ((this.c & 2) == 2) {
            c0606g.m(4, this.f493f);
        }
        if ((this.c & 4) == 4) {
            c0606g.o(5, this.f494g);
        }
        if ((this.c & 16) == 16) {
            c0606g.m(6, this.i);
        }
        if ((this.c & 32) == 32) {
            c0606g.m(7, this.f496j);
        }
        if ((this.c & 8) == 8) {
            c0606g.m(8, this.f495h);
        }
        if ((this.c & 64) == 64) {
            c0606g.m(9, this.f497k);
        }
        if ((this.c & 256) == 256) {
            c0606g.o(10, this.f499m);
        }
        if ((this.c & 512) == 512) {
            c0606g.m(11, this.f500n);
        }
        if ((this.c & 128) == 128) {
            c0606g.m(12, this.f498l);
        }
        if ((this.c & 1024) == 1024) {
            c0606g.o(13, this.f501o);
        }
        if ((this.c & 2048) == 2048) {
            c0606g.m(14, this.f502p);
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public U() {
        this.f503r = (byte) -1;
        this.f504s = -1;
        this.b = AbstractC0604e.f3861a;
    }

    public U(C0605f c0605f, C0608i c0608i) {
        this.f503r = (byte) -1;
        this.f504s = -1;
        j();
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        boolean z7 = false;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    C0101a c0101a = u;
                    T tK = null;
                    switch (iN) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 4096;
                            this.q = c0605f.k();
                            continue;
                        case 18:
                            if (!z7) {
                                this.d = new ArrayList();
                                z7 = true;
                            }
                            this.d.add(c0605f.g(S.i, c0608i));
                            continue;
                        case 24:
                            this.c |= 1;
                            this.e = c0605f.l() != 0;
                            continue;
                        case 32:
                            this.c |= 2;
                            this.f493f = c0605f.k();
                            continue;
                        case 42:
                            if ((this.c & 4) == 4) {
                                U u2 = this.f494g;
                                u2.getClass();
                                tK = k(u2);
                            }
                            U u6 = (U) c0605f.g(c0101a, c0608i);
                            this.f494g = u6;
                            if (tK != null) {
                                tK.e(u6);
                                this.f494g = tK.c();
                            }
                            this.c |= 4;
                            continue;
                        case 48:
                            this.c |= 16;
                            this.i = c0605f.k();
                            continue;
                        case 56:
                            this.c |= 32;
                            this.f496j = c0605f.k();
                            continue;
                        case 64:
                            this.c |= 8;
                            this.f495h = c0605f.k();
                            continue;
                        case 72:
                            this.c |= 64;
                            this.f497k = c0605f.k();
                            continue;
                        case 82:
                            if ((this.c & 256) == 256) {
                                U u7 = this.f499m;
                                u7.getClass();
                                tK = k(u7);
                            }
                            U u8 = (U) c0605f.g(c0101a, c0608i);
                            this.f499m = u8;
                            if (tK != null) {
                                tK.e(u8);
                                this.f499m = tK.c();
                            }
                            this.c |= 256;
                            continue;
                        case 88:
                            this.c |= 512;
                            this.f500n = c0605f.k();
                            continue;
                        case 96:
                            this.c |= 128;
                            this.f498l = c0605f.k();
                            continue;
                        case 106:
                            if ((this.c & 1024) == 1024) {
                                U u9 = this.f501o;
                                u9.getClass();
                                tK = k(u9);
                            }
                            U u10 = (U) c0605f.g(c0101a, c0608i);
                            this.f501o = u10;
                            if (tK != null) {
                                tK.e(u10);
                                this.f501o = tK.c();
                            }
                            this.c |= 1024;
                            continue;
                        case 112:
                            this.c |= 2048;
                            this.f502p = c0605f.k();
                            continue;
                        default:
                            if (!g(c0605f, c0606gJ, c0608i, iN)) {
                            }
                            break;
                    }
                    z6 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                    e.f3875a = this;
                    throw e;
                } catch (IOException e6) {
                    kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                    rVar.f3875a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if (z7) {
                    this.d = Collections.unmodifiableList(this.d);
                }
                try {
                    c0606gJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.b = c0603d.c();
                    throw th2;
                }
                this.b = c0603d.c();
                f();
                throw th;
            }
        }
        if (z7) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.b = c0603d.c();
            throw th3;
        }
        this.b = c0603d.c();
        f();
    }
}
