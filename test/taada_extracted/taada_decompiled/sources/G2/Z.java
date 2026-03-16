package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class Z extends AbstractC0612m implements ProtoBuf$TypeParameterOrBuilder {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Z f527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0101a f528n = new C0101a(19);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Y f530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f531h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f534l;

    static {
        Z z6 = new Z();
        f527m = z6;
        z6.d = 0;
        z6.e = 0;
        z6.f529f = false;
        z6.f530g = Y.INV;
        List list = Collections.EMPTY_LIST;
        z6.f531h = list;
        z6.i = list;
    }

    public Z(X x) {
        super(x);
        this.f532j = -1;
        this.f533k = (byte) -1;
        this.f534l = -1;
        this.b = x.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f527m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f528n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f534l;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? C0606g.b(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iB += C0606g.b(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iB += C0606g.h(3) + 1;
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.a(4, this.f530g.f526a);
        }
        for (int i3 = 0; i3 < this.f531h.size(); i3++) {
            iB += C0606g.d(5, (MessageLite) this.f531h.get(i3));
        }
        int iC = 0;
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            iC += C0606g.c(((Integer) this.i.get(i4)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.i.isEmpty()) {
            iC2 = iC2 + 1 + C0606g.c(iC);
        }
        this.f532j = iC;
        int size = this.b.size() + c() + iC2;
        this.f534l = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f533k;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 1) != 1) {
            this.f533k = (byte) 0;
            return false;
        }
        if ((i & 2) != 2) {
            this.f533k = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < this.f531h.size(); i3++) {
            if (!((U) this.f531h.get(i3)).isInitialized()) {
                this.f533k = (byte) 0;
                return false;
            }
        }
        if (this.f3870a.e()) {
            this.f533k = (byte) 1;
            return true;
        }
        this.f533k = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return X.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        X xD = X.d();
        xD.e(this);
        return xD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) throws IOException {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        if ((this.c & 2) == 2) {
            c0606g.m(2, this.e);
        }
        if ((this.c & 4) == 4) {
            boolean z6 = this.f529f;
            c0606g.x(3, 0);
            c0606g.q(z6 ? 1 : 0);
        }
        if ((this.c & 8) == 8) {
            c0606g.l(4, this.f530g.f526a);
        }
        for (int i = 0; i < this.f531h.size(); i++) {
            c0606g.o(5, (MessageLite) this.f531h.get(i));
        }
        if (this.i.size() > 0) {
            c0606g.v(50);
            c0606g.v(this.f532j);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            c0606g.n(((Integer) this.i.get(i3)).intValue());
        }
        hVar.q(1000, c0606g);
        c0606g.r(this.b);
    }

    public Z() {
        this.f532j = -1;
        this.f533k = (byte) -1;
        this.f534l = -1;
        this.b = AbstractC0604e.f3860a;
    }

    public Z(C0605f c0605f, C0608i c0608i) {
        Y y;
        this.f532j = -1;
        this.f533k = (byte) -1;
        this.f534l = -1;
        this.d = 0;
        this.e = 0;
        this.f529f = false;
        Y y6 = Y.INV;
        this.f530g = y6;
        List list = Collections.EMPTY_LIST;
        this.f531h = list;
        this.i = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i = 0;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0605f.k();
                        } else if (iN == 16) {
                            this.c |= 2;
                            this.e = c0605f.k();
                        } else if (iN == 24) {
                            this.c |= 4;
                            this.f529f = c0605f.l() != 0;
                        } else if (iN == 32) {
                            int iK = c0605f.k();
                            if (iK == 0) {
                                y = Y.IN;
                            } else if (iK != 1) {
                                y = iK != 2 ? null : y6;
                            } else {
                                y = Y.OUT;
                            }
                            if (y == null) {
                                c0606gJ.v(iN);
                                c0606gJ.v(iK);
                            } else {
                                this.c |= 8;
                                this.f530g = y;
                            }
                        } else if (iN == 42) {
                            if ((i & 16) != 16) {
                                this.f531h = new ArrayList();
                                i |= 16;
                            }
                            this.f531h.add(c0605f.g(U.u, c0608i));
                        } else if (iN == 48) {
                            if ((i & 32) != 32) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            this.i.add(Integer.valueOf(c0605f.k()));
                        } else if (iN != 50) {
                            if (!g(c0605f, c0606gJ, c0608i, iN)) {
                            }
                        } else {
                            int iD = c0605f.d(c0605f.k());
                            if ((i & 32) != 32 && c0605f.b() > 0) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            while (c0605f.b() > 0) {
                                this.i.add(Integer.valueOf(c0605f.k()));
                            }
                            c0605f.c(iD);
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    if ((i & 16) == 16) {
                        this.f531h = Collections.unmodifiableList(this.f531h);
                    }
                    if ((i & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
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
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                e.f3874a = this;
                throw e;
            } catch (IOException e6) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                rVar.f3874a = this;
                throw rVar;
            }
        }
        if ((i & 16) == 16) {
            this.f531h = Collections.unmodifiableList(this.f531h);
        }
        if ((i & 32) == 32) {
            this.i = Collections.unmodifiableList(this.i);
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
