package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$Type$ArgumentOrBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final S f477h;
    public static final C0101a i = new C0101a(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f478a;
    public int b;
    public Q c;
    public U d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f480g;

    static {
        S s3 = new S();
        f477h = s3;
        s3.c = Q.INV;
        s3.d = U.f492t;
        s3.e = 0;
    }

    public S() {
        this.f479f = (byte) -1;
        this.f480g = -1;
        this.f478a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f477h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i3 = this.f480g;
        if (i3 != -1) {
            return i3;
        }
        int iA = (this.b & 1) == 1 ? C0606g.a(1, this.c.f476a) : 0;
        if ((this.b & 2) == 2) {
            iA += C0606g.d(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iA += C0606g.b(3, this.e);
        }
        int size = this.f478a.size() + iA;
        this.f480g = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f479f;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 2) != 2 || this.d.isInitialized()) {
            this.f479f = (byte) 1;
            return true;
        }
        this.f479f = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return P.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        P pC = P.c();
        pC.d(this);
        return pC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.l(1, this.c.f476a);
        }
        if ((this.b & 2) == 2) {
            c0606g.o(2, this.d);
        }
        if ((this.b & 4) == 4) {
            c0606g.m(3, this.e);
        }
        c0606g.r(this.f478a);
    }

    public S(P p5) {
        this.f479f = (byte) -1;
        this.f480g = -1;
        this.f478a = p5.f3870a;
    }

    public S(C0605f c0605f, C0608i c0608i) {
        this.f479f = (byte) -1;
        this.f480g = -1;
        Q q = Q.INV;
        this.c = q;
        this.d = U.f492t;
        boolean z6 = false;
        this.e = 0;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        T tK = null;
                        Q q6 = null;
                        if (iN == 8) {
                            int iK = c0605f.k();
                            if (iK == 0) {
                                q6 = Q.IN;
                            } else if (iK == 1) {
                                q6 = Q.OUT;
                            } else if (iK == 2) {
                                q6 = q;
                            } else if (iK == 3) {
                                q6 = Q.STAR;
                            }
                            if (q6 == null) {
                                c0606gJ.v(iN);
                                c0606gJ.v(iK);
                            } else {
                                this.b |= 1;
                                this.c = q6;
                            }
                        } else if (iN == 18) {
                            if ((this.b & 2) == 2) {
                                U u = this.d;
                                u.getClass();
                                tK = U.k(u);
                            }
                            U u2 = (U) c0605f.g(U.u, c0608i);
                            this.d = u2;
                            if (tK != null) {
                                tK.e(u2);
                                this.d = tK.c();
                            }
                            this.b |= 2;
                        } else if (iN != 24) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            this.b |= 4;
                            this.e = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    try {
                        c0606gJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                e.f3875a = this;
                throw e;
            } catch (IOException e6) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                rVar.f3875a = this;
                throw rVar;
            }
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f478a = c0603d.c();
        }
    }
}
