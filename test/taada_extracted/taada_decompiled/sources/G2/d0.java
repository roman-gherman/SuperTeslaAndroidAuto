package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends AbstractC0612m implements ProtoBuf$ValueParameterOrBuilder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d0 f561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0101a f562m = new C0101a(21);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public U f563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f565h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f567k;

    static {
        d0 d0Var = new d0();
        f561l = d0Var;
        d0Var.d = 0;
        d0Var.e = 0;
        U u = U.f492t;
        d0Var.f563f = u;
        d0Var.f564g = 0;
        d0Var.f565h = u;
        d0Var.i = 0;
    }

    public d0(c0 c0Var) {
        super(c0Var);
        this.f566j = (byte) -1;
        this.f567k = -1;
        this.b = c0Var.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f561l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f562m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f567k;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? C0606g.b(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iB += C0606g.b(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iB += C0606g.d(3, this.f563f);
        }
        if ((this.c & 16) == 16) {
            iB += C0606g.d(4, this.f565h);
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.b(5, this.f564g);
        }
        if ((this.c & 32) == 32) {
            iB += C0606g.b(6, this.i);
        }
        int size = this.b.size() + c() + iB;
        this.f567k = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f566j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 2) != 2) {
            this.f566j = (byte) 0;
            return false;
        }
        if ((i & 4) == 4 && !this.f563f.isInitialized()) {
            this.f566j = (byte) 0;
            return false;
        }
        if ((this.c & 16) == 16 && !this.f565h.isInitialized()) {
            this.f566j = (byte) 0;
            return false;
        }
        if (this.f3870a.e()) {
            this.f566j = (byte) 1;
            return true;
        }
        this.f566j = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        c0 c0Var = new c0();
        U u = U.f492t;
        c0Var.f548g = u;
        c0Var.i = u;
        return c0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        c0 c0Var = new c0();
        U u = U.f492t;
        c0Var.f548g = u;
        c0Var.i = u;
        c0Var.d(this);
        return c0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        if ((this.c & 2) == 2) {
            c0606g.m(2, this.e);
        }
        if ((this.c & 4) == 4) {
            c0606g.o(3, this.f563f);
        }
        if ((this.c & 16) == 16) {
            c0606g.o(4, this.f565h);
        }
        if ((this.c & 8) == 8) {
            c0606g.m(5, this.f564g);
        }
        if ((this.c & 32) == 32) {
            c0606g.m(6, this.i);
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public d0() {
        this.f566j = (byte) -1;
        this.f567k = -1;
        this.b = AbstractC0604e.f3860a;
    }

    public d0(C0605f c0605f, C0608i c0608i) {
        this.f566j = (byte) -1;
        this.f567k = -1;
        boolean z6 = false;
        this.d = 0;
        this.e = 0;
        U u = U.f492t;
        this.f563f = u;
        this.f564g = 0;
        this.f565h = u;
        this.i = 0;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0605f.k();
                        } else if (iN != 16) {
                            T tK = null;
                            if (iN == 26) {
                                if ((this.c & 4) == 4) {
                                    U u2 = this.f563f;
                                    u2.getClass();
                                    tK = U.k(u2);
                                }
                                U u6 = (U) c0605f.g(U.u, c0608i);
                                this.f563f = u6;
                                if (tK != null) {
                                    tK.e(u6);
                                    this.f563f = tK.c();
                                }
                                this.c |= 4;
                            } else if (iN == 34) {
                                if ((this.c & 16) == 16) {
                                    U u7 = this.f565h;
                                    u7.getClass();
                                    tK = U.k(u7);
                                }
                                U u8 = (U) c0605f.g(U.u, c0608i);
                                this.f565h = u8;
                                if (tK != null) {
                                    tK.e(u8);
                                    this.f565h = tK.c();
                                }
                                this.c |= 16;
                            } else if (iN == 40) {
                                this.c |= 8;
                                this.f564g = c0605f.k();
                            } else if (iN != 48) {
                                if (!g(c0605f, c0606gJ, c0608i, iN)) {
                                }
                            } else {
                                this.c |= 32;
                                this.i = c0605f.k();
                            }
                        } else {
                            this.c |= 2;
                            this.e = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
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
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                e.f3874a = this;
                throw e;
            } catch (IOException e6) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                rVar.f3874a = this;
                throw rVar;
            }
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
