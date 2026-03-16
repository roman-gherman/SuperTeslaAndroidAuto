package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$VersionRequirementOrBuilder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h0 f592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0101a f593l = new C0101a(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f594a;
    public int b;
    public int c;
    public int d;
    public f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g0 f597h;
    public byte i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f598j;

    static {
        h0 h0Var = new h0();
        f592k = h0Var;
        h0Var.c = 0;
        h0Var.d = 0;
        h0Var.e = f0.ERROR;
        h0Var.f595f = 0;
        h0Var.f596g = 0;
        h0Var.f597h = g0.LANGUAGE_VERSION;
    }

    public h0() {
        this.i = (byte) -1;
        this.f598j = -1;
        this.f594a = AbstractC0604e.f3860a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f592k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f593l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f598j;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iB += C0606g.a(3, this.e.f586a);
        }
        if ((this.b & 8) == 8) {
            iB += C0606g.b(4, this.f595f);
        }
        if ((this.b & 16) == 16) {
            iB += C0606g.b(5, this.f596g);
        }
        if ((this.b & 32) == 32) {
            iB += C0606g.a(6, this.f597h.f587a);
        }
        int size = this.f594a.size() + iB;
        this.f598j = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (this.i == 1) {
            return true;
        }
        this.i = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return e0.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        e0 e0VarC = e0.c();
        e0VarC.d(this);
        return e0VarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.m(1, this.c);
        }
        if ((this.b & 2) == 2) {
            c0606g.m(2, this.d);
        }
        if ((this.b & 4) == 4) {
            c0606g.l(3, this.e.f586a);
        }
        if ((this.b & 8) == 8) {
            c0606g.m(4, this.f595f);
        }
        if ((this.b & 16) == 16) {
            c0606g.m(5, this.f596g);
        }
        if ((this.b & 32) == 32) {
            c0606g.l(6, this.f597h.f587a);
        }
        c0606g.r(this.f594a);
    }

    public h0(e0 e0Var) {
        this.i = (byte) -1;
        this.f598j = -1;
        this.f594a = e0Var.f3869a;
    }

    public h0(C0605f c0605f) {
        this.i = (byte) -1;
        this.f598j = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = 0;
        f0 f0Var = f0.ERROR;
        this.e = f0Var;
        this.f595f = 0;
        this.f596g = 0;
        g0 g0Var = g0.LANGUAGE_VERSION;
        this.f597h = g0Var;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.b |= 1;
                            this.c = c0605f.k();
                        } else if (iN != 16) {
                            g0 g0Var2 = null;
                            f0 f0Var2 = null;
                            if (iN == 24) {
                                int iK = c0605f.k();
                                if (iK == 0) {
                                    f0Var2 = f0.WARNING;
                                } else if (iK == 1) {
                                    f0Var2 = f0Var;
                                } else if (iK == 2) {
                                    f0Var2 = f0.HIDDEN;
                                }
                                if (f0Var2 == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK);
                                } else {
                                    this.b |= 4;
                                    this.e = f0Var2;
                                }
                            } else if (iN == 32) {
                                this.b |= 8;
                                this.f595f = c0605f.k();
                            } else if (iN == 40) {
                                this.b |= 16;
                                this.f596g = c0605f.k();
                            } else if (iN != 48) {
                                if (!c0605f.q(iN, c0606gJ)) {
                                }
                            } else {
                                int iK2 = c0605f.k();
                                if (iK2 == 0) {
                                    g0Var2 = g0Var;
                                } else if (iK2 == 1) {
                                    g0Var2 = g0.COMPILER_VERSION;
                                } else if (iK2 == 2) {
                                    g0Var2 = g0.API_VERSION;
                                }
                                if (g0Var2 == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK2);
                                } else {
                                    this.b |= 32;
                                    this.f597h = g0Var2;
                                }
                            }
                        } else {
                            this.b |= 2;
                            this.d = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                    e.f3874a = this;
                    throw e;
                } catch (IOException e6) {
                    kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                    rVar.f3874a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                try {
                    c0606gJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    throw th2;
                }
                throw th;
            }
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f594a = c0603d.c();
        }
    }
}
